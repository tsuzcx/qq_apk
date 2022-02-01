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
    if (this.faceStyleItem.postRender == null)
    {
      paramFaceStyleItem = null;
    }
    else
    {
      paramFaceStyleItem = AEModule.getContext();
      paramList = new StringBuilder();
      paramList.append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
      paramList.append(this.faceStyleItem.postRender.function);
      paramFaceStyleItem = FileUtils.load(paramFaceStyleItem, paramList.toString());
    }
    int i = this.NET_SIZE.width;
    int j = this.NET_SIZE.height;
    if (TextUtils.isEmpty(paramFaceStyleItem)) {
      paramList = StyleChildPostRender.FRAGMENT_SHADER;
    } else {
      paramList = paramFaceStyleItem;
    }
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
    paramFaceStyleItem = new StringBuilder();
    paramFaceStyleItem.append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
    paramFaceStyleItem.append(this.faceStyleItem.transformMask);
    paramFaceStyleItem = paramFaceStyleItem.toString();
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
  }
  
  private void decodeMaterialBitmap()
  {
    if (this.faceStyleItem.textureMaterials != null)
    {
      localObject1 = this.faceStyleItem.textureMaterials.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
        localStringBuilder.append((String)localObject2);
        localObject2 = localStringBuilder.toString();
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
      ((StringBuilder)localObject1).append(this.faceStyleItem.postRender.faceMaskName);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (FileUtils.exists((String)localObject1)) {
        this.faceMask = BitmapUtils.decodeBitmap((String)localObject1, true);
      }
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
      ((StringBuilder)localObject1).append(this.faceStyleItem.postRender.faceMaskName);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (FileUtils.exists((String)localObject1)) {
        this.faceMaskMouth = BitmapUtils.decodeBitmap((String)localObject1, true);
      }
    }
    Object localObject1 = this.faceStyleItem;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((FaceStyleItem)localObject1).cartoonEnlightLut)) && (FileUtils.exists(this.faceStyleItem.cartoonEnlightLut))) {
      this.lutABitmap = BitmapUtils.decodeBitmap(this.faceStyleItem.cartoonEnlightLut, true);
    }
  }
  
  private List<Float> getFacePointsList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localArrayList;
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      localObject1 = this.faceStyleItem.postRender.faceMaskName;
      int j = ((String)localObject1).lastIndexOf(".");
      Object localObject2 = new StringBuilder();
      int i = 0;
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, j));
      ((StringBuilder)localObject2).append(".json");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      if (FileUtils.exists((String)localObject1))
      {
        localObject2 = GsonUtils.optJsonArray(GsonUtils.json2JsonObject(FileOfflineUtil.readJsonStringFromFile((String)localObject1)), "facePoints");
        localObject1 = localArrayList;
        if (localObject2 != null) {
          for (;;)
          {
            localObject1 = localArrayList;
            if (i >= ((JsonArray)localObject2).size()) {
              break;
            }
            localArrayList.add(Float.valueOf((float)GsonUtils.optDouble((JsonArray)localObject2, i)));
            i += 1;
          }
        }
      }
      else
      {
        localObject1 = Arrays.asList(FaceOffUtil.COSMETIC_MODEL_IMAGE_FACEPOINTS);
      }
    }
    return localObject1;
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
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 6))
    {
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
    return null;
  }
  
  private float[] getPositionHair(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat1 = new float[8];
    float[] arrayOfFloat2 = new float[8];
    float f = paramArrayOfFloat[2];
    int k = 0;
    arrayOfFloat2[0] = f;
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
      j = i + 1;
      arrayOfFloat2[j] /= paramInt2;
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
      ((PointF)localList.get(i)).x = ((((PointF)paramList.get(i)).x + paramArrayOfFloat[2]) * paramArrayOfFloat[0] + (((PointF)paramList.get(i)).y + paramArrayOfFloat[5]) * paramArrayOfFloat[1]);
      ((PointF)localList.get(i)).y = ((((PointF)paramList.get(i)).x + paramArrayOfFloat[2]) * paramArrayOfFloat[3] + (((PointF)paramList.get(i)).y + paramArrayOfFloat[5]) * paramArrayOfFloat[4]);
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
    FaceStyleItem localFaceStyleItem = this.faceStyleItem;
    boolean bool;
    if ((localFaceStyleItem != null) && (localFaceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CARTOON_STYLE.value)) {
      bool = true;
    } else {
      bool = false;
    }
    this.isCartoonStyleMaterial = bool;
    this.isEnlightSkin = (TextUtils.isEmpty(this.faceStyleItem.cartoonEnlightLut) ^ true);
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
  }
  
  private void initCustomGroup()
  {
    List localList = this.customFilterList;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      this.styleCustomFilterGroup = new StyleCustomFilterGroup(this.customFilterList);
    }
  }
  
  private void initProcessMaterial()
  {
    boolean bool = TextUtils.isEmpty(this.faceStyleItem.initProcess.function);
    int i = 0;
    int j = 0;
    if (!bool)
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
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      double d = localPointF.x;
      Double.isNaN(d);
      localPointF.x = ((float)(d * paramDouble));
      d = localPointF.y;
      Double.isNaN(d);
      localPointF.y = ((float)(d * paramDouble));
    }
  }
  
  private void updateCoords(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = this.texCoords;
    float f = paramArrayOfFloat[2];
    int k = 0;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = paramArrayOfFloat[5];
    arrayOfFloat[2] = (this.NET_SIZE.height * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
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
      paramArrayOfFloat = this.texCoords;
      paramArrayOfFloat[i] /= paramInt1;
      j = i + 1;
      paramArrayOfFloat[j] /= paramInt2;
      i += 2;
    }
    for (;;)
    {
      paramArrayOfFloat = this.texCoords;
      if (j >= paramArrayOfFloat.length) {
        break;
      }
      this.position[j] = (paramArrayOfFloat[j] * 2.0F - 1.0F);
      j += 1;
    }
  }
  
  private void updateTextureBitmapList(PTFaceAttr paramPTFaceAttr, Frame paramFrame, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.isCosTransProcessed = false;
    }
    if ((!this.isCosTransProcessed) && (paramBoolean2) && (this.cosFunTransitionFilter != null))
    {
      List localList = this.textureBitmapList;
      if (localList != null)
      {
        localList.clear();
        this.cosFunTransitionFilter.init(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, (List)paramPTFaceAttr.getAllFacePoints().get(0), paramPTFaceAttr.getFaceDetectScale(), false);
        paramPTFaceAttr = RendererUtils.saveTexture(this.cosFunTransitionFilter.getMergedFrame(1.0F));
        if (BitmapUtils.isLegal(paramPTFaceAttr)) {
          this.textureBitmapList.add(paramPTFaceAttr);
        }
        this.isCosTransProcessed = true;
      }
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
    Object localObject = this.styleCustomFilterGroup;
    if (localObject != null) {
      ((StyleCustomFilterGroup)localObject).destroy();
    }
    localObject = this.textureBitmapList.iterator();
    while (((Iterator)localObject).hasNext()) {
      BitmapUtils.recycle((Bitmap)((Iterator)localObject).next());
    }
    BitmapUtils.recycle(this.faceMask);
    BitmapUtils.recycle(this.lutABitmap);
    BitmapUtils.recycle(this.outBitmap);
    BitmapUtils.recycle(this.warpMat);
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.deInitAll();
    localObject = this.tex;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
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
    Object localObject = this.styleCustomFilterGroup;
    if (localObject != null) {
      ((StyleCustomFilterGroup)localObject).apply();
    }
    localObject = this.tex;
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
  }
  
  public void initCosFunTransitionFilter(VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PTFaceAttr paramPTFaceAttr, Frame paramFrame, String paramString)
  {
    Object localObject = this.faceStyleItem;
    if ((localObject != null) && (((FaceStyleItem)localObject).crazyFacePath != null))
    {
      if (TextUtils.isEmpty(this.faceStyleItem.crazyFacePath)) {
        return;
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = this.faceStyleItem.crazyFacePath;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.cosFunTransitionFilter == null))
      {
        paramString = new StringBuilder();
        paramString.append(paramVideoMaterial.getDataPath());
        paramString.append(File.separator);
        paramString.append((String)localObject);
        this.cosFunTransitionFilter = new CosFunTransitionFilter(paramString.toString(), 2, 0);
      }
      updateTextureBitmapList(paramPTFaceAttr, paramFrame, paramBoolean1, paramBoolean2);
    }
  }
  
  public void initCosFunTransitionFilter(VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PTFaceAttr paramPTFaceAttr, Frame paramFrame, String paramString, StickerItem paramStickerItem)
  {
    if ((paramStickerItem != null) && (paramStickerItem.crazyFacePath != null))
    {
      if (TextUtils.isEmpty(paramStickerItem.crazyFacePath)) {
        return;
      }
      paramStickerItem = paramString;
      if (paramString == null) {
        paramStickerItem = this.faceStyleItem.crazyFacePath;
      }
      if ((!TextUtils.isEmpty(paramStickerItem)) && (this.cosFunTransitionFilter == null))
      {
        paramString = new StringBuilder();
        paramString.append(paramVideoMaterial.getDataPath());
        paramString.append(File.separator);
        paramString.append(paramStickerItem);
        this.cosFunTransitionFilter = new CosFunTransitionFilter(paramString.toString(), 2, 0);
      }
      updateTextureBitmapList(paramPTFaceAttr, paramFrame, paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean isCartoonStyleMaterial()
  {
    return this.isCartoonStyleMaterial;
  }
  
  public boolean isCrazyFacePath()
  {
    FaceStyleItem localFaceStyleItem = this.faceStyleItem;
    return (localFaceStyleItem != null) && (!TextUtils.isEmpty(localFaceStyleItem.crazyFacePath));
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
    Frame localFrame2 = this.postRenderFrame;
    if (localFrame1 != localFrame2) {
      localFrame2.unlock();
    }
    if ((!this.faceRectFeatherMask) && (!this.isCartoonStyleMaterial))
    {
      if ((this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) && (this.faceStyleItem.changeGenderParams.outputTextureCount == 2))
      {
        localFrame2 = this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.styleChildPostRender.render(paramFrame, localFrame2, false, false);
        this.styleChildPostRenderHair.render(localFrame2, localFrame1, false, false);
      }
      else if (this.faceStyleItem.returnPostProcessTexture)
      {
        FrameUtil.clearFrame(localFrame1, 0.0F, 0.0F, 0.0F, 0.0F, localFrame1.width, localFrame1.height);
        this.styleChildPostRender.render(paramFrame, localFrame1, false, true);
      }
      else
      {
        this.styleChildPostRender.render(paramFrame, localFrame1, false, false);
      }
    }
    else
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
            localFrame1 = this.copyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
            localFrame2 = this.faceColorTransferFilter.render(localFrame1);
            if (localFrame1 != localFrame2) {
              localFrame1.unlock();
            }
          }
        }
      }
      this.styleChildPostMaskRender.render(paramFrame, this.postRenderMaskFrame, true);
      this.copyFilter.RenderProcess(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, -1, 0.0D, this.frameTmp2);
      this.copyFilter.RenderProcess(this.fillFrame2.getTextureId(), this.fillFrame2.width, this.fillFrame2.height, -1, 0.0D, this.resultFrame);
      if (this.isCartoonStyleMaterial)
      {
        if (this.faceStyleItem.faceFilterType == 99) {
          this.resultFrame = this.styleCustomFilterGroup.render(this.fillFrame2);
        } else if (this.faceStyleItem.faceFilterType == 1) {
          this.resultFrame = this.ttCartoonFilterGroup.render(this.fillFrame2);
        } else {
          this.resultFrame = this.ttToonFilterGroup.render(this.fillFrame2);
        }
        paramFrame = this.fillFrame2;
        if (paramFrame != this.resultFrame) {
          paramFrame.unlock();
        }
      }
      if (this.isCartoonStyleMaterial) {
        paramFrame = this.cartoonFusionFilter.render(this.resultFrame, this.frameTmp2, this.postRenderMaskFrame);
      } else {
        paramFrame = this.cartoonFusionFilter.renderFeather(this.resultFrame, this.frameTmp2, this.postRenderMaskFrame);
      }
      localFrame2 = this.frameTmp2;
      localFrame1 = paramFrame;
      if (paramFrame != localFrame2)
      {
        localFrame2.unlock();
        localFrame1 = paramFrame;
      }
    }
    this.copyFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, -1, 0.0D, this.resultFrame);
    if ((BitmapUtils.isLegal(this.faceMask)) && (!this.isCartoonStyleMaterial))
    {
      this.faceOffFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, -1, 0.0D, this.resultFrame);
      FrameUtil.clearFrame(this.faceOffMask, 0.0F, 0.0F, 0.0F, 0.0F, this.faceMask.getWidth(), this.faceMask.getHeight());
      this.faceOffMaskFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, -1, 0.0D, this.faceOffMask);
    }
    localFrame1.unlock();
    return this.resultFrame;
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
    SizeI localSizeI = this.NET_SIZE;
    localSizeI.width = paramInt1;
    localSizeI.height = paramInt2;
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    CartoonFusionFilter localCartoonFusionFilter = this.cartoonFusionFilter;
    if (localCartoonFusionFilter != null) {
      localCartoonFusionFilter.setSegmentMode(paramBoolean);
    }
  }
  
  public void setTextureBitmapList(List<Bitmap> paramList)
  {
    this.textureBitmapList = paramList;
  }
  
  public Frame updateAndRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, double paramDouble)
  {
    Object localObject2 = paramFrame;
    boolean bool;
    if (paramPTFaceAttr.getAllFacePoints().size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.isCurrentFrameHasFace = bool;
    if (!this.isCurrentFrameHasFace) {
      return localObject2;
    }
    Object localObject1 = localObject2;
    float f1;
    float f2;
    float f3;
    if (this.isCartoonStyleMaterial)
    {
      localObject1 = localObject2;
      if (paramPTFaceAttr.getFaceDetWidth() > 0)
      {
        localObject1 = localObject2;
        if (this.isEnlightSkin)
        {
          localObject1 = Bitmap.createBitmap(paramPTFaceAttr.getFaceDetWidth(), paramPTFaceAttr.getFaceDetHeight(), Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(paramPTFaceAttr.getData()).rewind());
          this.rgba = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.averageFaceColorUsingFacePoints((Bitmap)localObject1, (List)paramPTFaceAttr.getAllFacePoints().get(0));
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
            ((Bitmap)localObject1).recycle();
          }
          localObject1 = this.rgba;
          f1 = localObject1[0];
          f2 = localObject1[1];
          f3 = localObject1[2];
          float f4 = localObject1[3];
          f1 = f1 * 0.2126F + f2 * 0.7152F + f3 * 0.0722F;
          if (f1 > 0.7F) {
            f1 = 0.0F;
          } else if (f1 < 0.54F) {
            f1 = 1.0F;
          } else {
            f1 = Math.abs(0.7F - f1) * 1.0F / 0.16F;
          }
          this.gpuImageLookupFilter.setAdjustParam(1.0F - f1);
          this.copyFilter.RenderProcess(paramFrame.getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, this.frameTmp);
          localObject1 = this.gpuImageLookupFilter.render(this.frameTmp);
          paramFrame = this.frameTmp;
          if (paramFrame != localObject1) {
            paramFrame.unlock();
          }
          this.rgbaAfterLutA = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.pixelLUT(this.lutABitmap, this.rgba, f1, false);
        }
      }
    }
    paramFrame = (List)paramPTFaceAttr.getAllFacePoints().get(0);
    int k = ((Frame)localObject1).getTextureId();
    int j = ((Frame)localObject1).width;
    int i = ((Frame)localObject1).height;
    Object localObject3 = VideoMaterial.copyList(paramFrame);
    List localList = VideoMaterial.copyList(paramFrame);
    Object localObject4 = VideoMaterial.copyList(paramFrame);
    double d = 1.0D / paramDouble;
    scale((List)localObject4, d);
    scale((List)localObject3, d);
    FaceOffUtil.getFullCoords((List)localObject4, 2.5F);
    float[] arrayOfFloat = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.computeFaceCropTransform((List)localObject4, this.faceStyleItem.faceCropType, this.faceStyleItem.faceExpandFactor, this.faceStyleItem.faceCropExpandInset, this.NET_SIZE.width, this.NET_SIZE.height, this.faceStyleItem.changeGenderParams.toFloatArray());
    localObject2 = null;
    paramFrame = (Frame)localObject2;
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value)
    {
      paramFrame = (Frame)localObject2;
      if (this.faceStyleItem.changeGenderParams.outputTextureCount == 2) {
        paramFrame = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.computeFaceCropTransform((List)localObject4, 1003, this.faceStyleItem.faceExpandFactor, this.faceStyleItem.faceCropExpandInset, this.NET_SIZE.width, this.NET_SIZE.height, this.faceStyleItem.changeGenderParams.toFloatArray());
      }
    }
    updateCoords(arrayOfFloat, j, i);
    this.cropFilter.setBackgroundColor(this.faceStyleItem.cropBorderColorRGBA);
    this.cropFilter.setTexCords(this.texCoords);
    this.cropFilter.RenderProcess(k, this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CARTOON_STYLE.value)
    {
      localObject2 = getTransFacePoints((List)localObject3, getInvTransData(arrayOfFloat));
      this.cartoonStylePreProcessFilter.updatePoints((List)localObject2, this.cropFrame.width, this.cropFrame.height, ((float[])paramPTFaceAttr.getAllFaceAngles().get(0))[1] / 3.141593F * 180.0F, this.faceStyleItem.cartoonFaceLine);
      this.cartoonStylePreProcessFilter.render(this.cropFrame.getTextureId(), this.cropFrame.width, this.cropFrame.height);
    }
    localObject2 = GlUtil.saveTexture(this.cropFrame);
    BenchUtil.benchStart("tnn_time");
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, (Bitmap)localObject2, true);
    if (!TextUtils.isEmpty(this.faceStyleItem.preProcess.function))
    {
      localObject3 = this.textureBitmapList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Bitmap)((Iterator)localObject3).next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, (Bitmap)localObject4, true);
      }
    }
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.changeGenderBitmap, false);
    } else {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.outBitmap, false);
    }
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHILD_STYLE.value) {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.warpMat, false);
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postProcess.function))
    {
      localObject3 = this.textureBitmapList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Bitmap)((Iterator)localObject3).next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, (Bitmap)localObject4, true);
      }
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
    this.copyFilter.RenderProcess(k, j, i, -1, 0.0D, this.postRenderFrame);
    this.copyFilter.RenderProcess(k, j, i, -1, 0.0D, this.postRenderMaskFrame);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.GENDER_SWITCH.value)
    {
      this.fillFilter.setPositions(this.position);
      GlUtil.setBlendMode(true);
      this.fillFilter.RenderProcess(this.tex[0], j, i, -1, 0.0D, this.postRenderFrame);
      this.fillFilter.RenderProcess(this.tex[0], j, i, -1, 0.0D, this.postRenderMaskFrame);
      GlUtil.setBlendMode(false);
    }
    else
    {
      this.styleChildWarpFilter.updateParams(this.outBitmap, this.warpMat, this.faceOffMask, arrayOfFloat, this.position, localList, j, i, paramDouble);
      this.styleChildPostRender.updateParams(this.outBitmap, this.warpMat, arrayOfFloat);
      if (!this.faceStyleItem.returnPostProcessTexture) {
        this.styleChildPostRender.setPositions(this.position);
      }
      if ((this.faceStyleItem.styleChangeType == FaceStyleItem.StyleChangeType.CHANGE_GENDER.value) && (paramFrame != null) && (this.faceStyleItem.changeGenderParams.outputTextureCount == 2))
      {
        localObject3 = getPositionHair(paramFrame, j, i);
        localObject4 = Bitmap.createScaledBitmap(this.warpMat, this.NET_SIZE.width, this.NET_SIZE.height, true);
        this.styleChildPostRenderHair.updateParams((Bitmap)localObject4, this.outBitmap, paramFrame);
        this.styleChildPostRenderHair.setPositions((float[])localObject3);
        ((Bitmap)localObject4).recycle();
      }
      if ((this.faceRectFeatherMask) || (this.isCartoonStyleMaterial))
      {
        this.styleChildPostMaskRender.updateParams(this.outBitmap, this.warpMat, arrayOfFloat);
        this.styleChildPostMaskRender.setPositions(this.position);
      }
    }
    if (BitmapUtils.isLegal(this.faceMask))
    {
      this.faceOffFilter.updateVideoSize(j, i, paramDouble);
      this.faceOffFilter.updateParam(localList, k);
      this.faceOffMaskFilter.updateVideoSize(j, i, paramDouble);
      this.faceOffMaskFilter.updateParam(localList, k);
    }
    ((Bitmap)localObject2).recycle();
    if (((this.faceRectFeatherMask) || (this.isCartoonStyleMaterial)) && (paramPTFaceAttr.getFaceInfoList() != null) && (paramPTFaceAttr.getFaceInfoList().size() > 0))
    {
      f1 = ((com.tencent.ttpic.openapi.facedetect.FaceInfo)paramPTFaceAttr.getFaceInfoList().get(0)).rect[2] / paramPTFaceAttr.getFaceDetWidth();
      if (this.faceStyleItem.verticalMinRadius > 0)
      {
        f2 = this.featherMaskWidth;
        f3 = this.featherMaskHeight;
        j = (int)(f2 * f1 * this.faceStyleItem.horizontalFaceRadiusPercent);
        i = (int)(f1 * f3 * this.faceStyleItem.verticalFaceRadiusPercent);
        j = Math.max(j, this.faceStyleItem.horizontalMinRadius);
        i = Math.max(i, this.faceStyleItem.verticalMinRadius);
        this.cartoonFusionFilter.updateFaceFeatherRadius(j, i);
        return localObject1;
      }
      paramDouble = this.featherMaskWidth * f1;
      Double.isNaN(paramDouble);
      i = (int)(paramDouble * 0.12D);
      this.cartoonFusionFilter.updateFaceFeatherRadius(i, i);
    }
    return localObject1;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateTextureBitmapList(String paramString)
  {
    if (this.textureBitmapList == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath));
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (FileUtils.exists(paramString))
    {
      paramString = BitmapUtils.decodeBitmap(paramString, true);
      this.textureBitmapList.clear();
      if (BitmapUtils.isLegal(paramString)) {
        this.textureBitmapList.add(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildFilter
 * JD-Core Version:    0.7.0.1
 */