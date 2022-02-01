package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.stylizefilter.FaceColorTransferFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTCartoonFilterGroupForComic;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.CartoonFusionFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.TTToonFilterGroup;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.ChangeGenderParams;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Process;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Render;
import com.tencent.ttpic.openapi.model.FaceStyleItem.StyleChangeType;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StyleChildFilter
  extends AEChainI
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = "StyleChildFilter";
  private SizeI NET_SIZE = new SizeI(256, 256);
  private CartoonFusionFilter cartoonFusionFilter;
  private CartoonStylePreProcessFilter cartoonStylePreProcessFilter;
  Bitmap changeGenderBitmap;
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private CosFunTransitionFilter cosFunTransitionFilter;
  private BGColorCropFilter cropFilter = new BGColorCropFilter();
  private Frame cropFrame = new Frame();
  private List<CustomFilterItem> customFilterList;
  private final int fHeight = 640;
  private final int fWidth = 360;
  private FaceColorTransferFilter faceColorTransferFilter;
  private Bitmap faceMask;
  private Bitmap faceMaskMouth;
  private StyleChildFaceOffFilter faceOffFilter;
  private Frame faceOffMask = new Frame();
  private StyleChildFaceOffMaskFilter faceOffMaskFilter;
  private boolean faceRectFeatherMask;
  private FaceStyleItem faceStyleItem;
  private int featherMaskHeight = 640;
  private int featherMaskWidth = 360;
  private VideoFilterBase fillFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame fillFrame2 = new Frame();
  private Frame frameTmp = new Frame();
  private Frame frameTmp2 = new Frame();
  private GPUImageLookupFilter gpuImageLookupFilter;
  private boolean isCartoonStyleMaterial = true;
  private boolean isCosTransProcessed = false;
  private boolean isCurrentFrameHasFace = false;
  private boolean isEnlightSkin = false;
  private Bitmap lutABitmap;
  private int mGANTYPE = 1;
  Bitmap outBitmap;
  private float[] position = new float[8];
  private Frame postRenderFrame = new Frame();
  private Frame postRenderMaskFrame = new Frame();
  private Frame resultFrame = new Frame();
  private float[] rgba;
  private float[] rgbaAfterLutA;
  private StyleChildPostMaskRender styleChildPostMaskRender;
  private StyleChildPostRender styleChildPostRender;
  private StyleChildPostRender styleChildPostRenderHair;
  private StyleChildTransformFilter styleChildWarpFilter;
  private StyleCustomFilterGroup styleCustomFilterGroup;
  private int[] tex = new int[2];
  private float[] texCoords = new float[8];
  private List<Bitmap> textureBitmapList = new ArrayList();
  private TTCartoonFilterGroupForComic ttCartoonFilterGroup = new TTCartoonFilterGroupForComic();
  private TTToonFilterGroup ttToonFilterGroup = new TTToonFilterGroup();
  private float[] warpArr;
  private Frame warpFrame = new Frame();
  Bitmap warpMat;
  
  public StyleChildFilter(FaceStyleItem paramFaceStyleItem, List<CustomFilterItem> paramList)
  {
    this.faceStyleItem = paramFaceStyleItem;
    this.customFilterList = paramList;
    setImageNetSize(paramFaceStyleItem.imageSize[0], paramFaceStyleItem.imageSize[1]);
    int i;
    int j;
    if (this.faceStyleItem.postRender == null)
    {
      paramFaceStyleItem = null;
      i = this.NET_SIZE.width;
      j = this.NET_SIZE.height;
      if (!TextUtils.isEmpty(paramFaceStyleItem)) {
        break label955;
      }
    }
    label955:
    for (paramList = StyleChildPostRender.FRAGMENT_SHADER;; paramList = paramFaceStyleItem)
    {
      this.styleChildPostRender = new StyleChildPostRender(i, j, paramList);
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value)
      {
        i = this.NET_SIZE.width;
        j = this.NET_SIZE.height;
        paramList = paramFaceStyleItem;
        if (TextUtils.isEmpty(paramFaceStyleItem))
        {
          paramFaceStyleItem = this.styleChildPostRenderHair;
          paramList = StyleChildPostRender.FRAGMENT_SHADER;
        }
        this.styleChildPostRenderHair = new StyleChildPostRender(i, j, paramList);
      }
      this.styleChildPostMaskRender = new StyleChildPostMaskRender(this.NET_SIZE.width, this.NET_SIZE.height);
      paramFaceStyleItem = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.transformMask;
      this.styleChildWarpFilter = new StyleChildTransformFilter(this.NET_SIZE.width, this.NET_SIZE.height, paramFaceStyleItem);
      paramFaceStyleItem = getFacePointsList();
      if (paramFaceStyleItem != null) {
        this.faceOffFilter = new StyleChildFaceOffFilter(paramFaceStyleItem);
      }
      this.faceOffMaskFilter = new StyleChildFaceOffMaskFilter();
      this.cartoonStylePreProcessFilter = new CartoonStylePreProcessFilter();
      this.cartoonFusionFilter = new CartoonFusionFilter();
      this.gpuImageLookupFilter = new GPUImageLookupFilter();
      this.faceColorTransferFilter = new FaceColorTransferFilter();
      this.warpArr = new float[this.NET_SIZE.width * this.NET_SIZE.height * 2];
      this.warpMat = Bitmap.createBitmap(this.NET_SIZE.width, this.NET_SIZE.height, Bitmap.Config.ARGB_8888);
      this.outBitmap = Bitmap.createBitmap(this.NET_SIZE.width, this.NET_SIZE.height, Bitmap.Config.ARGB_8888);
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) {
        this.changeGenderBitmap = Bitmap.createBitmap(this.NET_SIZE.width * 2, this.NET_SIZE.height, Bitmap.Config.ARGB_8888);
      }
      this.faceRectFeatherMask = this.faceStyleItem.postRender.faceRectFeatherMask;
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.setParams(6, this.faceStyleItem.libraryText, this.faceStyleItem.styleChangeType, this.faceStyleItem.initProcess.function, this.faceStyleItem.preProcess.function, this.faceStyleItem.postProcess.function, processBlobNames(this.faceStyleItem.initProcess.blobNames), processBlobNames(this.faceStyleItem.preProcess.blobNames), processBlobNames(this.faceStyleItem.postProcess.blobNames), this.faceStyleItem.initProcess.scale, this.faceStyleItem.initProcess.bias, this.faceStyleItem.preProcess.scale, this.faceStyleItem.preProcess.bias, this.faceStyleItem.postProcess.scale, this.faceStyleItem.postProcess.bias);
      decodeMaterialBitmap();
      if (BitmapUtils.isLegal(this.faceMask))
      {
        this.faceOffFilter.loadMask(this.faceMask);
        this.faceOffMaskFilter.loadMask(this.faceMask);
      }
      initProcessMaterial();
      initCartoonFusionFilter();
      initCustomGroup();
      init();
      return;
      paramFaceStyleItem = FileUtils.load(AEModule.getContext(), FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.postRender.function);
      break;
    }
  }
  
  private void decodeMaterialBitmap()
  {
    Object localObject1;
    if (this.faceStyleItem.textureMaterials != null)
    {
      localObject1 = this.faceStyleItem.textureMaterials.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + (String)localObject2;
        if (FileUtils.exists((String)localObject2))
        {
          localObject2 = BitmapUtils.decodeBitmap((String)localObject2, true);
          if (BitmapUtils.isLegal((Bitmap)localObject2)) {
            this.textureBitmapList.add(localObject2);
          }
        }
      }
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      localObject1 = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.postRender.faceMaskName;
      if (FileUtils.exists((String)localObject1)) {
        this.faceMask = BitmapUtils.decodeBitmap((String)localObject1, true);
      }
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      localObject1 = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.postRender.faceMaskName;
      if (FileUtils.exists((String)localObject1)) {
        this.faceMaskMouth = BitmapUtils.decodeBitmap((String)localObject1, true);
      }
    }
    if ((this.faceStyleItem != null) && (!TextUtils.isEmpty(this.faceStyleItem.cartoonEnlightLut)) && (FileUtils.exists(this.faceStyleItem.cartoonEnlightLut))) {
      this.lutABitmap = BitmapUtils.decodeBitmap(this.faceStyleItem.cartoonEnlightLut, true);
    }
  }
  
  private List<Float> getFacePointsList()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      Object localObject = this.faceStyleItem.postRender.faceMaskName;
      int j = ((String)localObject).lastIndexOf(".");
      localObject = ((String)localObject).substring(0, j) + ".json";
      localObject = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + (String)localObject;
      if (FileUtils.exists((String)localObject))
      {
        localObject = GsonUtils.optJsonArray(GsonUtils.json2JsonObject(FileOfflineUtil.readJsonStringFromFile((String)localObject)), "facePoints");
        if (localObject != null) {
          while (i < ((JsonArray)localObject).size())
          {
            localArrayList.add(Float.valueOf((float)GsonUtils.optDouble((JsonArray)localObject, i)));
            i += 1;
          }
        }
      }
      else
      {
        return Arrays.asList(FaceOffUtil.COSMETIC_MODEL_IMAGE_FACEPOINTS);
      }
    }
    return localArrayList;
  }
  
  private void getInvMatrix2x2(float[][] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0][0];
    float f2 = paramArrayOfFloat[1][1];
    float f3 = paramArrayOfFloat[0][1];
    float f4 = paramArrayOfFloat[1][0];
    int i = paramArrayOfFloat[0][0];
    paramArrayOfFloat[0][0] = paramArrayOfFloat[1][1];
    paramArrayOfFloat[1][1] = i;
    paramArrayOfFloat[0][1] = (-paramArrayOfFloat[0][1]);
    paramArrayOfFloat[1][0] = (-paramArrayOfFloat[1][0]);
    i = 0;
    while (i < 2)
    {
      int j = 0;
      while (j < 2)
      {
        paramArrayOfFloat[i][j] /= (f1 * f2 - f3 * f4);
        j += 1;
      }
      i += 1;
    }
  }
  
  private float[] getInvTransData(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 6)) {
      return null;
    }
    float f1 = -paramArrayOfFloat[2];
    float f2 = -paramArrayOfFloat[5];
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 2, 2 });
    arrayOfFloat[0][0] = paramArrayOfFloat[0];
    arrayOfFloat[0][1] = paramArrayOfFloat[1];
    arrayOfFloat[1][0] = paramArrayOfFloat[3];
    arrayOfFloat[1][1] = paramArrayOfFloat[4];
    getInvMatrix2x2(arrayOfFloat);
    return new float[] { arrayOfFloat[0][0], arrayOfFloat[0][1], f1, arrayOfFloat[1][0], arrayOfFloat[1][1], f2 };
  }
  
  private float[] getPositionHair(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    int k = 0;
    float[] arrayOfFloat1 = new float[8];
    float[] arrayOfFloat2 = new float[8];
    arrayOfFloat2[0] = paramArrayOfFloat[2];
    arrayOfFloat2[1] = paramArrayOfFloat[5];
    arrayOfFloat2[2] = (this.NET_SIZE.height * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    arrayOfFloat2[3] = (this.NET_SIZE.height * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    arrayOfFloat2[4] = (this.NET_SIZE.width * paramArrayOfFloat[0] + this.NET_SIZE.height * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    arrayOfFloat2[5] = (this.NET_SIZE.width * paramArrayOfFloat[3] + this.NET_SIZE.height * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    arrayOfFloat2[6] = (this.NET_SIZE.width * paramArrayOfFloat[0] + paramArrayOfFloat[2]);
    arrayOfFloat2[7] = (this.NET_SIZE.width * paramArrayOfFloat[3] + paramArrayOfFloat[5]);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8) {
        break;
      }
      arrayOfFloat2[i] /= paramInt1;
      arrayOfFloat2[(i + 1)] /= paramInt2;
      i += 2;
    }
    while (j < arrayOfFloat2.length)
    {
      arrayOfFloat1[j] = (arrayOfFloat2[j] * 2.0F - 1.0F);
      j += 1;
    }
    return arrayOfFloat1;
  }
  
  private List<PointF> getTransFacePoints(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (paramList == null) {
      return null;
    }
    List localList = VideoMaterial.copyList(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      PointF localPointF = (PointF)localList.get(i);
      float f1 = ((PointF)paramList.get(i)).x;
      float f2 = paramArrayOfFloat[2];
      float f3 = paramArrayOfFloat[0];
      localPointF.x = ((((PointF)paramList.get(i)).y + paramArrayOfFloat[5]) * paramArrayOfFloat[1] + f3 * (f1 + f2));
      localPointF = (PointF)localList.get(i);
      f1 = ((PointF)paramList.get(i)).x;
      f2 = paramArrayOfFloat[2];
      f3 = paramArrayOfFloat[3];
      localPointF.y = ((((PointF)paramList.get(i)).y + paramArrayOfFloat[5]) * paramArrayOfFloat[4] + f3 * (f1 + f2));
      i += 1;
    }
    return localList;
  }
  
  private void initCartoonFusionFilter()
  {
    this.ttToonFilterGroup.updateLutPaths(this.faceStyleItem.lutPaths);
    this.ttToonFilterGroup.updateMateriaPaths(this.faceStyleItem.materialPaths);
    this.ttCartoonFilterGroup.updateLutPaths(this.faceStyleItem.lutPaths);
    this.ttCartoonFilterGroup.updateScaleValue(this.faceStyleItem.postRender.faceMaskBold);
    this.gpuImageLookupFilter.updateLut(this.faceStyleItem.cartoonEnlightLut);
    if ((this.faceStyleItem != null) && (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CARTOON_STYLE.value))
    {
      bool = true;
      this.isCartoonStyleMaterial = bool;
      if (TextUtils.isEmpty(this.faceStyleItem.cartoonEnlightLut)) {
        break label204;
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      this.isEnlightSkin = bool;
      if (this.faceStyleItem.featureMaskSize != null)
      {
        if (this.faceStyleItem.featureMaskSize[0] > 0) {
          this.featherMaskWidth = this.faceStyleItem.featureMaskSize[0];
        }
        if (this.faceStyleItem.featureMaskSize[1] > 0) {
          this.featherMaskHeight = this.faceStyleItem.featureMaskSize[1];
        }
      }
      this.cartoonFusionFilter.updateFaceFeatherWidthAndHeight(this.featherMaskWidth, this.featherMaskHeight);
      return;
      bool = false;
      break;
    }
  }
  
  private void initCustomGroup()
  {
    if ((this.customFilterList == null) || (this.customFilterList.size() <= 0)) {
      return;
    }
    this.styleCustomFilterGroup = new StyleCustomFilterGroup(this.customFilterList);
  }
  
  private void initProcessMaterial()
  {
    int i = 0;
    int j = 0;
    if (!TextUtils.isEmpty(this.faceStyleItem.initProcess.function))
    {
      Iterator localIterator = this.textureBitmapList.iterator();
      for (i = j; localIterator.hasNext(); i = 1)
      {
        Bitmap localBitmap = (Bitmap)localIterator.next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addInitMat(6, localBitmap, true);
      }
    }
    if (i != 0) {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.initProcess(6);
    }
  }
  
  private String processBlobNames(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString().trim();
  }
  
  public static void scale(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x * paramDouble));
        localPointF.y = ((float)(localPointF.y * paramDouble));
      }
    }
  }
  
  private void updateCoords(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    int k = 0;
    this.texCoords[0] = paramArrayOfFloat[2];
    this.texCoords[1] = paramArrayOfFloat[5];
    this.texCoords[2] = (this.NET_SIZE.height * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    this.texCoords[3] = (this.NET_SIZE.height * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    this.texCoords[4] = (this.NET_SIZE.width * paramArrayOfFloat[0] + this.NET_SIZE.height * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    this.texCoords[5] = (this.NET_SIZE.width * paramArrayOfFloat[3] + this.NET_SIZE.height * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    this.texCoords[6] = (this.NET_SIZE.width * paramArrayOfFloat[0] + paramArrayOfFloat[2]);
    this.texCoords[7] = (this.NET_SIZE.width * paramArrayOfFloat[3] + paramArrayOfFloat[5]);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8) {
        break;
      }
      this.texCoords[i] /= paramInt1;
      this.texCoords[(i + 1)] /= paramInt2;
      i += 2;
    }
    while (j < this.texCoords.length)
    {
      this.position[j] = (this.texCoords[j] * 2.0F - 1.0F);
      j += 1;
    }
  }
  
  private void updateTextureBitmapList(PTFaceAttr paramPTFaceAttr, Frame paramFrame, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.isCosTransProcessed = false;
    }
    if ((!this.isCosTransProcessed) && (paramBoolean2) && (this.cosFunTransitionFilter != null) && (this.textureBitmapList != null))
    {
      this.textureBitmapList.clear();
      this.cosFunTransitionFilter.init(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, (List)paramPTFaceAttr.getAllFacePoints().get(0), paramPTFaceAttr.getFaceDetectScale(), false);
      paramPTFaceAttr = RendererUtils.saveTexture(this.cosFunTransitionFilter.getMergedFrame(1.0F));
      if (BitmapUtils.isLegal(paramPTFaceAttr)) {
        this.textureBitmapList.add(paramPTFaceAttr);
      }
      this.isCosTransProcessed = true;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void destroy()
  {
    this.cropFilter.clearGLSLSelf();
    this.fillFilter.clearGLSLSelf();
    this.styleChildPostRender.clearGLSLSelf();
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) {
      this.styleChildPostRenderHair.clearGLSLSelf();
    }
    this.styleChildPostMaskRender.clearGLSLSelf();
    this.styleChildWarpFilter.clearGLSLSelf();
    this.faceOffFilter.clearGLSLSelf();
    this.faceOffMaskFilter.clearGLSLSelf();
    this.cartoonStylePreProcessFilter.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.cropFrame.clear();
    this.postRenderFrame.clear();
    this.postRenderMaskFrame.clear();
    this.warpFrame.clear();
    this.fillFrame2.clear();
    this.frameTmp2.clear();
    this.faceOffMask.clear();
    this.resultFrame.clear();
    this.cartoonFusionFilter.clear();
    this.gpuImageLookupFilter.clear();
    this.faceColorTransferFilter.clear();
    this.ttToonFilterGroup.clear();
    this.ttCartoonFilterGroup.clear();
    if (this.styleCustomFilterGroup != null) {
      this.styleCustomFilterGroup.destroy();
    }
    Iterator localIterator = this.textureBitmapList.iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    BitmapUtils.recycle(this.faceMask);
    BitmapUtils.recycle(this.lutABitmap);
    BitmapUtils.recycle(this.outBitmap);
    BitmapUtils.recycle(this.warpMat);
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.deInitAll();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
  }
  
  public boolean getIsCosTransProcessed()
  {
    return this.isCosTransProcessed;
  }
  
  public List<Bitmap> getTextureBitmapList()
  {
    return this.textureBitmapList;
  }
  
  public void init()
  {
    this.cropFilter.ApplyGLSLFilter();
    this.fillFilter.ApplyGLSLFilter();
    this.styleChildPostRender.ApplyGLSLFilter();
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) {
      this.styleChildPostRenderHair.ApplyGLSLFilter();
    }
    this.styleChildPostMaskRender.ApplyGLSLFilter();
    this.styleChildWarpFilter.ApplyGLSLFilter();
    this.faceOffFilter.ApplyGLSLFilter();
    this.faceOffMaskFilter.ApplyGLSLFilter();
    this.cartoonStylePreProcessFilter.ApplyGLSLFilter();
    this.copyFilter.apply();
    this.ttToonFilterGroup.apply();
    this.ttCartoonFilterGroup.apply();
    this.cartoonFusionFilter.apply();
    this.gpuImageLookupFilter.apply();
    this.faceColorTransferFilter.apply();
    if (this.styleCustomFilterGroup != null) {
      this.styleCustomFilterGroup.apply();
    }
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
  }
  
  public void initCosFunTransitionFilter(VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PTFaceAttr paramPTFaceAttr, Frame paramFrame, String paramString)
  {
    if ((this.faceStyleItem == null) || (this.faceStyleItem.crazyFacePath == null) || (TextUtils.isEmpty(this.faceStyleItem.crazyFacePath))) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = this.faceStyleItem.crazyFacePath;
    }
    if ((!TextUtils.isEmpty(str)) && (this.cosFunTransitionFilter == null)) {
      this.cosFunTransitionFilter = new CosFunTransitionFilter(paramVideoMaterial.getDataPath() + File.separator + str, 2, 0);
    }
    updateTextureBitmapList(paramPTFaceAttr, paramFrame, paramBoolean1, paramBoolean2);
  }
  
  public void initCosFunTransitionFilter(VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PTFaceAttr paramPTFaceAttr, Frame paramFrame, String paramString, StickerItem paramStickerItem)
  {
    if ((paramStickerItem == null) || (paramStickerItem.crazyFacePath == null) || (TextUtils.isEmpty(paramStickerItem.crazyFacePath))) {
      return;
    }
    paramStickerItem = paramString;
    if (paramString == null) {
      paramStickerItem = this.faceStyleItem.crazyFacePath;
    }
    if ((!TextUtils.isEmpty(paramStickerItem)) && (this.cosFunTransitionFilter == null)) {
      this.cosFunTransitionFilter = new CosFunTransitionFilter(paramVideoMaterial.getDataPath() + File.separator + paramStickerItem, 2, 0);
    }
    updateTextureBitmapList(paramPTFaceAttr, paramFrame, paramBoolean1, paramBoolean2);
  }
  
  public boolean isCartoonStyleMaterial()
  {
    return this.isCartoonStyleMaterial;
  }
  
  public boolean isCrazyFacePath()
  {
    return (this.faceStyleItem != null) && (!TextUtils.isEmpty(this.faceStyleItem.crazyFacePath));
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.GENDER_SWITCH.value) {
      return this.postRenderFrame;
    }
    if ((!this.isCurrentFrameHasFace) && (this.isCartoonStyleMaterial))
    {
      if (this.faceStyleItem.faceFilterType == 99) {
        return this.styleCustomFilterGroup.render(paramFrame);
      }
      if (this.faceStyleItem.faceFilterType == 1) {
        return this.ttCartoonFilterGroup.render(paramFrame);
      }
      return this.ttToonFilterGroup.render(paramFrame);
    }
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.fillFrame2);
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.resultFrame);
    Frame localFrame1 = this.copyFilter.RenderProcess(this.postRenderFrame.getTextureId(), this.postRenderFrame.width, this.postRenderFrame.height);
    if (localFrame1 != this.postRenderFrame) {
      this.postRenderFrame.unlock();
    }
    Frame localFrame2;
    if ((this.faceRectFeatherMask) || (this.isCartoonStyleMaterial))
    {
      this.styleChildPostRender.render(paramFrame, localFrame1, true, false);
      localFrame2 = localFrame1;
      if (this.isCartoonStyleMaterial)
      {
        localFrame2 = localFrame1;
        if (this.rgba != null)
        {
          localFrame2 = localFrame1;
          if (this.isEnlightSkin)
          {
            this.faceColorTransferFilter.updateParams(this.rgbaAfterLutA);
            Frame localFrame3 = this.copyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
            localFrame1 = this.faceColorTransferFilter.render(localFrame3);
            localFrame2 = localFrame1;
            if (localFrame3 != localFrame1)
            {
              localFrame3.unlock();
              localFrame2 = localFrame1;
            }
          }
        }
      }
      this.styleChildPostMaskRender.render(paramFrame, this.postRenderMaskFrame, true);
      this.copyFilter.RenderProcess(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, -1, 0.0D, this.frameTmp2);
      this.copyFilter.RenderProcess(this.fillFrame2.getTextureId(), this.fillFrame2.width, this.fillFrame2.height, -1, 0.0D, this.resultFrame);
      if (this.isCartoonStyleMaterial)
      {
        if (this.faceStyleItem.faceFilterType != 99) {
          break label587;
        }
        this.resultFrame = this.styleCustomFilterGroup.render(this.fillFrame2);
        if (this.fillFrame2 != this.resultFrame) {
          this.fillFrame2.unlock();
        }
      }
      if (this.isCartoonStyleMaterial)
      {
        paramFrame = this.cartoonFusionFilter.render(this.resultFrame, this.frameTmp2, this.postRenderMaskFrame);
        label442:
        localFrame1 = paramFrame;
        if (paramFrame == this.frameTmp2) {
          break label787;
        }
        this.frameTmp2.unlock();
      }
    }
    for (;;)
    {
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.resultFrame);
      if ((BitmapUtils.isLegal(this.faceMask)) && (!this.isCartoonStyleMaterial))
      {
        this.faceOffFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.resultFrame);
        FrameUtil.clearFrame(this.faceOffMask, 0.0F, 0.0F, 0.0F, 0.0F, this.faceMask.getWidth(), this.faceMask.getHeight());
        this.faceOffMaskFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.faceOffMask);
      }
      paramFrame.unlock();
      return this.resultFrame;
      label587:
      if (this.faceStyleItem.faceFilterType == 1)
      {
        this.resultFrame = this.ttCartoonFilterGroup.render(this.fillFrame2);
        break;
      }
      this.resultFrame = this.ttToonFilterGroup.render(this.fillFrame2);
      break;
      paramFrame = this.cartoonFusionFilter.renderFeather(this.resultFrame, this.frameTmp2, this.postRenderMaskFrame);
      break label442;
      if ((this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) && (this.faceStyleItem.changeGenderParams.outputTextureCount == 2))
      {
        localFrame2 = this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.styleChildPostRender.render(paramFrame, localFrame2, false, false);
        this.styleChildPostRenderHair.render(localFrame2, localFrame1, false, false);
        paramFrame = localFrame1;
      }
      else if (this.faceStyleItem.returnPostProcessTexture)
      {
        FrameUtil.clearFrame(localFrame1, 0.0F, 0.0F, 0.0F, 0.0F, localFrame1.width, localFrame1.height);
        this.styleChildPostRender.render(paramFrame, localFrame1, false, true);
        paramFrame = localFrame1;
      }
      else
      {
        this.styleChildPostRender.render(paramFrame, localFrame1, false, false);
        label787:
        paramFrame = localFrame1;
      }
    }
  }
  
  public Frame renderWarp(Frame paramFrame)
  {
    if (this.faceStyleItem.styleChangeType != FaceStyleItem.StyleChangeType.CHILD_STYLE.value) {
      return paramFrame;
    }
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.warpFrame);
    this.styleChildWarpFilter.render(paramFrame, this.warpFrame);
    this.copyFilter.RenderProcess(this.warpFrame.getTextureId(), this.warpFrame.width, this.warpFrame.height, -1, 0.0D, this.fillFrame2);
    return this.fillFrame2;
  }
  
  public void resetNeedCalFaceMoveDownParam()
  {
    this.styleChildWarpFilter.needCalFaceMoveDownParam = true;
  }
  
  public void setImageNetSize(int paramInt1, int paramInt2)
  {
    this.NET_SIZE.width = paramInt1;
    this.NET_SIZE.height = paramInt2;
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    if (this.cartoonFusionFilter != null) {
      this.cartoonFusionFilter.setSegmentMode(paramBoolean);
    }
  }
  
  public void setTextureBitmapList(List<Bitmap> paramList)
  {
    this.textureBitmapList = paramList;
  }
  
  public Frame updateAndRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, double paramDouble)
  {
    if (paramPTFaceAttr.getAllFacePoints().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCurrentFrameHasFace = bool;
      if (this.isCurrentFrameHasFace) {
        break;
      }
      return paramFrame;
    }
    Object localObject1 = paramFrame;
    float f1;
    float f2;
    float f3;
    if (this.isCartoonStyleMaterial)
    {
      localObject1 = paramFrame;
      if (paramPTFaceAttr.getFaceDetWidth() > 0)
      {
        localObject1 = paramFrame;
        if (this.isEnlightSkin)
        {
          localObject1 = Bitmap.createBitmap(paramPTFaceAttr.getFaceDetWidth(), paramPTFaceAttr.getFaceDetHeight(), Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(paramPTFaceAttr.getData()).rewind());
          this.rgba = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.averageFaceColorUsingFacePoints((Bitmap)localObject1, (List)paramPTFaceAttr.getAllFacePoints().get(0));
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
            ((Bitmap)localObject1).recycle();
          }
          f1 = this.rgba[0];
          f2 = this.rgba[1];
          f3 = this.rgba[2];
          float f4 = this.rgba[3];
          f1 = f1 * 0.2126F + f2 * 0.7152F + 0.0722F * f3;
          if (f1 <= 0.7F) {
            break label768;
          }
          f1 = 0.0F;
          this.gpuImageLookupFilter.setAdjustParam(1.0F - f1);
          this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.frameTmp);
          localObject1 = this.gpuImageLookupFilter.render(this.frameTmp);
          if (this.frameTmp != localObject1) {
            this.frameTmp.unlock();
          }
          this.rgbaAfterLutA = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.pixelLUT(this.lutABitmap, this.rgba, f1, false);
        }
      }
    }
    paramFrame = (List)paramPTFaceAttr.getAllFacePoints().get(0);
    int i = ((Frame)localObject1).getTextureId();
    int j = ((Frame)localObject1).width;
    int k = ((Frame)localObject1).height;
    Object localObject2 = VideoMaterial.copyList(paramFrame);
    List localList = VideoMaterial.copyList(paramFrame);
    paramFrame = VideoMaterial.copyList(paramFrame);
    scale(paramFrame, 1.0D / paramDouble);
    scale((List)localObject2, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramFrame, 2.5F);
    float[] arrayOfFloat = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.computeFaceCropTransform(paramFrame, this.faceStyleItem.faceCropType, this.faceStyleItem.faceExpandFactor, this.faceStyleItem.faceCropExpandInset, this.NET_SIZE.width, this.NET_SIZE.height, this.faceStyleItem.changeGenderParams.toFloatArray());
    if ((this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) && (this.faceStyleItem.changeGenderParams.outputTextureCount == 2)) {}
    for (paramFrame = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.computeFaceCropTransform(paramFrame, 1003, this.faceStyleItem.faceExpandFactor, this.faceStyleItem.faceCropExpandInset, this.NET_SIZE.width, this.NET_SIZE.height, this.faceStyleItem.changeGenderParams.toFloatArray());; paramFrame = null)
    {
      updateCoords(arrayOfFloat, j, k);
      this.cropFilter.setBackgroundColor(this.faceStyleItem.cropBorderColorRGBA);
      this.cropFilter.setTexCords(this.texCoords);
      this.cropFilter.RenderProcess(i, this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CARTOON_STYLE.value)
      {
        localObject2 = getTransFacePoints((List)localObject2, getInvTransData(arrayOfFloat));
        this.cartoonStylePreProcessFilter.updatePoints((List)localObject2, this.cropFrame.width, this.cropFrame.height, ((float[])paramPTFaceAttr.getAllFaceAngles().get(0))[1] / 3.141593F * 180.0F, this.faceStyleItem.cartoonFaceLine);
        this.cartoonStylePreProcessFilter.render(this.cropFrame.getTextureId(), this.cropFrame.width, this.cropFrame.height);
      }
      localObject2 = GlUtil.saveTexture(this.cropFrame);
      BenchUtil.benchStart("tnn_time");
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, (Bitmap)localObject2, true);
      Object localObject3;
      Bitmap localBitmap;
      if (!TextUtils.isEmpty(this.faceStyleItem.preProcess.function))
      {
        localObject3 = this.textureBitmapList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localBitmap = (Bitmap)((Iterator)localObject3).next();
            FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, localBitmap, true);
            continue;
            label768:
            if (f1 < 0.54F)
            {
              f1 = 1.0F;
              break;
            }
            f1 = Math.abs(0.7F - f1) * 1.0F / (0.7F - 0.54F);
            break;
          }
        }
      }
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) {
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.changeGenderBitmap, false);
      }
      for (;;)
      {
        if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHILD_STYLE.value) {
          FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.warpMat, false);
        }
        if (TextUtils.isEmpty(this.faceStyleItem.postProcess.function)) {
          break;
        }
        localObject3 = this.textureBitmapList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Iterator)localObject3).next();
          FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, localBitmap, true);
        }
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.outBitmap, false);
      }
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, (Bitmap)localObject2, true);
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.forward(6, 0);
      BenchUtil.benchEnd("tnn_time");
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value)
      {
        this.outBitmap = Bitmap.createBitmap(this.changeGenderBitmap, 0, 0, this.NET_SIZE.width, this.NET_SIZE.height);
        this.warpMat = Bitmap.createBitmap(this.changeGenderBitmap, this.NET_SIZE.width, 0, this.NET_SIZE.width, this.NET_SIZE.height);
      }
      GlUtil.loadTexture(this.tex[0], this.outBitmap);
      this.copyFilter.RenderProcess(i, j, k, -1, 0.0D, this.postRenderFrame);
      this.copyFilter.RenderProcess(i, j, k, -1, 0.0D, this.postRenderMaskFrame);
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.GENDER_SWITCH.value)
      {
        this.fillFilter.setPositions(this.position);
        GlUtil.setBlendMode(true);
        this.fillFilter.RenderProcess(this.tex[0], j, k, -1, 0.0D, this.postRenderFrame);
        this.fillFilter.RenderProcess(this.tex[0], j, k, -1, 0.0D, this.postRenderMaskFrame);
        GlUtil.setBlendMode(false);
      }
      for (;;)
      {
        if (BitmapUtils.isLegal(this.faceMask))
        {
          this.faceOffFilter.updateVideoSize(j, k, paramDouble);
          this.faceOffFilter.updateParam(localList, i);
          this.faceOffMaskFilter.updateVideoSize(j, k, paramDouble);
          this.faceOffMaskFilter.updateParam(localList, i);
        }
        ((Bitmap)localObject2).recycle();
        if (!this.faceRectFeatherMask)
        {
          paramFrame = (Frame)localObject1;
          if (!this.isCartoonStyleMaterial) {
            break;
          }
        }
        paramFrame = (Frame)localObject1;
        if (paramPTFaceAttr.getFaceInfoList() == null) {
          break;
        }
        paramFrame = (Frame)localObject1;
        if (paramPTFaceAttr.getFaceInfoList().size() <= 0) {
          break;
        }
        f1 = ((com.tencent.ttpic.openapi.facedetect.FaceInfo)paramPTFaceAttr.getFaceInfoList().get(0)).rect[2] / paramPTFaceAttr.getFaceDetWidth();
        if (this.faceStyleItem.verticalMinRadius <= 0) {
          break label1628;
        }
        f2 = this.featherMaskWidth;
        f3 = this.featherMaskHeight;
        j = (int)(f2 * f1 * this.faceStyleItem.horizontalFaceRadiusPercent);
        i = (int)(f1 * f3 * this.faceStyleItem.verticalFaceRadiusPercent);
        j = Math.max(j, this.faceStyleItem.horizontalMinRadius);
        i = Math.max(i, this.faceStyleItem.verticalMinRadius);
        this.cartoonFusionFilter.updateFaceFeatherRadius(j, i);
        return localObject1;
        this.styleChildWarpFilter.updateParams(this.outBitmap, this.warpMat, this.faceOffMask, arrayOfFloat, this.position, localList, j, k, paramDouble);
        this.styleChildPostRender.updateParams(this.outBitmap, this.warpMat, arrayOfFloat);
        if (!this.faceStyleItem.returnPostProcessTexture) {
          this.styleChildPostRender.setPositions(this.position);
        }
        if ((this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) && (paramFrame != null) && (this.faceStyleItem.changeGenderParams.outputTextureCount == 2))
        {
          localObject3 = getPositionHair(paramFrame, j, k);
          localBitmap = Bitmap.createScaledBitmap(this.warpMat, this.NET_SIZE.width, this.NET_SIZE.height, true);
          this.styleChildPostRenderHair.updateParams(localBitmap, this.outBitmap, paramFrame);
          this.styleChildPostRenderHair.setPositions((float[])localObject3);
          localBitmap.recycle();
        }
        if ((this.faceRectFeatherMask) || (this.isCartoonStyleMaterial))
        {
          this.styleChildPostMaskRender.updateParams(this.outBitmap, this.warpMat, arrayOfFloat);
          this.styleChildPostMaskRender.setPositions(this.position);
        }
      }
      label1628:
      i = (int)(f1 * this.featherMaskWidth * 0.12D);
      this.cartoonFusionFilter.updateFaceFeatherRadius(i, i);
      return localObject1;
    }
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateTextureBitmapList(String paramString)
  {
    if (this.textureBitmapList == null) {}
    do
    {
      do
      {
        return;
        paramString = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + paramString;
      } while (!FileUtils.exists(paramString));
      paramString = BitmapUtils.decodeBitmap(paramString, true);
      this.textureBitmapList.clear();
    } while (!BitmapUtils.isLegal(paramString));
    this.textureBitmapList.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildFilter
 * JD-Core Version:    0.7.0.1
 */