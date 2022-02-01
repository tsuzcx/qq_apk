package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.filter.CFFaceOffFilter;
import com.tencent.ttpic.filter.CFSkinCropFilter;
import com.tencent.ttpic.filter.CFSkinCropFilterV2;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.model.FaceFeatureTex;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.model.CosFunParam;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate.ImageLayer;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.CfTemplateParser;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CosFunTransitionFilter
{
  private SizeI MAX_SIZE;
  private final int backgroundMode1;
  private final int backgroundMode2;
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private FaceFeatureTex dstFeature;
  private boolean enableGAN = false;
  private boolean isInited = false;
  private Frame materialFrame;
  int materialTex;
  private int procType = 0;
  private FaceFeatureTex srcFeature;
  private CrazyFaceDataTemplate template;
  private CFTransformFilterOpt transFilter;
  private CFTransformFilterForTex transFilterForTex;
  private List<CosFunParam> userCosFunParams = new ArrayList();
  
  public CosFunTransitionFilter(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    this.template = CfTemplateParser.parseCrazyFace(FileUtils.getRealPath(paramString), (String)localObject);
    this.MAX_SIZE = initMaxLength();
    this.backgroundMode1 = paramInt1;
    this.backgroundMode2 = paramInt2;
    if (this.template == null) {
      return;
    }
    paramString = new StringBuilder();
    paramString.append(this.template.folderPath);
    paramString.append(File.separator);
    paramString.append(this.template.getFaceLayer(0).imagePath);
    paramString = FaceOffUtil.getFaceBitmap(paramString.toString(), this.MAX_SIZE.width, this.MAX_SIZE.height);
    if (BitmapUtils.isLegal(paramString))
    {
      this.materialTex = RendererUtils.createTexture(paramString);
      paramString.recycle();
      this.materialFrame = new Frame(0, this.materialTex, paramString.getWidth(), paramString.getHeight());
      this.isInited = true;
    }
  }
  
  public CosFunTransitionFilter(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = paramString2.split("/");
    localObject = localObject[(localObject.length - 1)];
    this.template = CfTemplateParser.parseCrazyFace(FileUtils.getRealPath(paramString2), (String)localObject);
    this.MAX_SIZE = initMaxLength();
    this.backgroundMode1 = paramInt1;
    this.backgroundMode2 = paramInt2;
    if (this.template == null) {
      return;
    }
    paramString1 = FaceOffUtil.getFaceBitmap(paramString1, this.MAX_SIZE.width, this.MAX_SIZE.height);
    if (BitmapUtils.isLegal(paramString1))
    {
      paramInt1 = RendererUtils.createTexture(paramString1);
      paramString1.recycle();
      this.materialFrame = new Frame(0, paramInt1, paramString1.getWidth(), paramString1.getHeight());
      this.isInited = true;
    }
  }
  
  private SizeI initMaxLength()
  {
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
      return new SizeI(1080, 1920);
    }
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      return new SizeI(720, 1280);
    }
    return new SizeI(720, 1280);
  }
  
  private void processCosFun()
  {
    BenchUtil.benchStart("[CosFunTransitionFilter] initCos 0");
    if (this.template != null)
    {
      if (this.materialFrame == null) {
        return;
      }
      this.copyFilter.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
      List localList = this.template.faceLayers;
      FaceImageLayer localFaceImageLayer1 = this.template.getFaceLayer(0);
      int i = (int)Math.min(localFaceImageLayer1.width, this.MAX_SIZE.width);
      int j = (int)Math.min(localFaceImageLayer1.height, this.MAX_SIZE.height);
      double d1 = i;
      double d2 = localFaceImageLayer1.width;
      Double.isNaN(d1);
      d1 /= d2;
      d2 = j;
      double d3 = localFaceImageLayer1.height;
      Double.isNaN(d2);
      d1 = Math.min(d1, d2 / d3);
      j = (int)(localFaceImageLayer1.width * d1);
      int k = (int)(localFaceImageLayer1.height * d1);
      Object localObject2 = new CFFaceOffFilter(this.template.folderPath);
      ((CFFaceOffFilter)localObject2).updateVideoSize(j, k, d1);
      ((CFFaceOffFilter)localObject2).ApplyGLSLFilter();
      BenchUtil.benchEnd("[CosFunTransitionFilter] initCos 0");
      BenchUtil.benchStart("[CosFunTransitionFilter] initCos 1");
      Object localObject1 = new Frame();
      this.copyFilter.RenderProcess(this.materialFrame.getTextureId(), this.materialFrame.width, this.materialFrame.height, -1, 0.0D, (Frame)localObject1);
      BenchUtil.benchEnd("[CosFunTransitionFilter] initCos 1");
      i = 0;
      Object localObject3;
      while (i < localList.size())
      {
        BenchUtil.benchStart("[CosFunTransitionFilter] processCos 0");
        localObject3 = new Frame();
        this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), j, k, -1, 0.0D, (Frame)localObject3);
        CosFunParam localCosFunParam = (CosFunParam)this.userCosFunParams.get(i);
        FaceImageLayer localFaceImageLayer2 = (FaceImageLayer)localList.get(i);
        ((CFFaceOffFilter)localObject2).setFaceLayer(localFaceImageLayer2);
        ((CFFaceOffFilter)localObject2).setUserFaceTex(localCosFunParam.mFaceTexture);
        ((CFFaceOffFilter)localObject2).setSkinColorParams(localCosFunParam);
        BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 0");
        BenchUtil.benchStart("[CosFunTransitionFilter] processCos 1");
        ((CFFaceOffFilter)localObject2).setFacePointsInfo(localCosFunParam.mUserFacePointsList, localCosFunParam.mWidth, localCosFunParam.mHeight, localFaceImageLayer2.faceTriangleID);
        BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 1");
        BenchUtil.benchStart("[CosFunTransitionFilter] processCos 2");
        if (!this.enableGAN) {
          ((CFFaceOffFilter)localObject2).RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject3).width, ((Frame)localObject3).height, -1, 0.0D, (Frame)localObject3);
        }
        BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 2");
        ((Frame)localObject1).clear();
        this.dstFeature.faceFeature = ((CFFaceOffFilter)localObject2).getFaceFeature();
        i += 1;
        localObject1 = localObject3;
      }
      ((CFFaceOffFilter)localObject2).clearGLSLSelf();
      BenchUtil.benchStart("[CosFunTransitionFilter] processBgFg");
      d1 = ((Frame)localObject1).width;
      d2 = localFaceImageLayer1.width;
      Double.isNaN(d1);
      d1 /= d2;
      i = (int)(this.template.width * d1);
      j = (int)(this.template.height * d1);
      GlUtil.setBlendMode(true);
      localObject2 = new Frame();
      if (this.template.backgroundLayer != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.template.folderPath);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append(this.template.backgroundLayer.imagePath);
        localObject3 = FaceOffUtil.getFaceBitmap(((StringBuilder)localObject3).toString(), this.MAX_SIZE.width, this.MAX_SIZE.height);
        f1 = (float)this.template.backgroundLayer.x;
        f2 = (float)(this.template.backgroundLayer.x + this.template.backgroundLayer.width);
        f3 = (float)this.template.backgroundLayer.y;
        f4 = (float)(this.template.backgroundLayer.y + this.template.backgroundLayer.height);
        k = RendererUtils.createTexture((Bitmap)localObject3);
        ((Bitmap)localObject3).recycle();
        this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
        this.copyFilter.RenderProcess(k, i, j, -1, 0.0D, (Frame)localObject2);
        RendererUtils.clearTexture(k);
      }
      float f1 = (float)localFaceImageLayer1.x;
      float f2 = (float)(localFaceImageLayer1.x + localFaceImageLayer1.width);
      float f3 = (float)localFaceImageLayer1.y;
      float f4 = (float)(localFaceImageLayer1.y + localFaceImageLayer1.height);
      this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
      this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), i, j, -1, 0.0D, (Frame)localObject2);
      ((Frame)localObject1).clear();
      if (this.template.foregroundLayer != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.template.folderPath);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.template.foregroundLayer.imagePath);
        localObject1 = FaceOffUtil.getFaceBitmap(((StringBuilder)localObject1).toString(), this.MAX_SIZE.width, this.MAX_SIZE.height);
        f1 = (float)this.template.foregroundLayer.x;
        f2 = (float)(this.template.foregroundLayer.x + this.template.foregroundLayer.width);
        f3 = (float)this.template.foregroundLayer.y;
        f4 = (float)(this.template.foregroundLayer.y + this.template.foregroundLayer.height);
        k = RendererUtils.createTexture((Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
        this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
        this.copyFilter.RenderProcess(k, i, j, -1, 0.0D, (Frame)localObject2);
        RendererUtils.clearTexture(k);
      }
      GlUtil.setBlendMode(false);
      GlUtil.resetFilterCoords(this.copyFilter);
      CosFunUtil.scale(this.dstFeature.faceFeature, d1);
      this.dstFeature.faceTex = RendererUtils.createTexture();
      localObject1 = new Frame();
      this.copyFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, this.dstFeature.faceTex, 0.0D, (Frame)localObject1);
      ((Frame)localObject1).clear();
      ((Frame)localObject2).clear();
      BenchUtil.benchEnd("[CosFunTransitionFilter] processBgFg");
    }
  }
  
  private CosFunParam processUserBitmap(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, FaceImageLayer paramFaceImageLayer)
  {
    BenchUtil.benchStart("[CosFunTransitionFilter] crop");
    CosFunParam localCosFunParam = new CosFunParam();
    Object localObject1 = (PointF)paramList.get(101);
    Object localObject2 = (PointF)paramList.get(99);
    PointF localPointF1 = (PointF)paramList.get(105);
    PointF localPointF2 = (PointF)paramList.get(103);
    int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF1);
    int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
    float f1 = ((PointF)localObject2).x;
    float f2 = paramInt2;
    f1 /= f2;
    float f4 = ((PointF)localObject2).y;
    float f3 = paramInt3;
    f4 /= f3;
    float f5 = ((PointF)localObject1).x / f2;
    float f6 = ((PointF)localObject1).y / f3;
    float f7 = localPointF2.x / f2;
    float f8 = localPointF2.y / f3;
    f2 = localPointF1.x / f2;
    f3 = localPointF1.y / f3;
    this.copyFilter.setTexCords(new float[] { f1, f4, f5, f6, f7, f8, f2, f3 });
    localCosFunParam.mFaceTexture = RendererUtils.createTexture();
    localObject1 = new Frame();
    this.copyFilter.RenderProcess(paramInt1, i, j, localCosFunParam.mFaceTexture, 0.0D, (Frame)localObject1);
    ((Frame)localObject1).clear();
    BenchUtil.benchEnd("[CosFunTransitionFilter] crop");
    BenchUtil.benchStart("[CosFunTransitionFilter] updateFacePoints");
    CosFunUtil.updateFacePoints(paramList);
    BenchUtil.benchEnd("[CosFunTransitionFilter] updateFacePoints");
    BenchUtil.benchStart("[CosFunTransitionFilter] calSkin");
    localObject1 = new Frame();
    if (paramFaceImageLayer.getVersion() == 1)
    {
      localObject2 = new CFSkinCropFilter();
      ((CFSkinCropFilter)localObject2).setFacePoints(paramList);
      ((CFSkinCropFilter)localObject2).applyFilterChain(false, i, j);
      ((CFSkinCropFilter)localObject2).RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor);
      ((CFSkinCropFilter)localObject2).clearGLSLSelf();
    }
    else
    {
      localObject2 = new CFSkinCropFilterV2(this.template.folderPath);
      ((CFSkinCropFilterV2)localObject2).setFacePointsInfo(paramList, i, j, paramFaceImageLayer.faceTriangleID);
      ((CFSkinCropFilterV2)localObject2).ApplyGLSLFilter();
      ((CFSkinCropFilterV2)localObject2).RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor2, paramFaceImageLayer.faceColorRange);
      ((CFSkinCropFilterV2)localObject2).clearGLSLSelf();
    }
    ((Frame)localObject1).clear();
    BenchUtil.benchEnd("[CosFunTransitionFilter] calSkin");
    localCosFunParam.mWidth = i;
    localCosFunParam.mHeight = j;
    localCosFunParam.mUserFacePointsList = paramList;
    return localCosFunParam;
  }
  
  public void destroy()
  {
    this.copyFilter.clearGLSLSelf();
    Object localObject = this.dstFeature;
    if (localObject != null) {
      RendererUtils.clearTexture(((FaceFeatureTex)localObject).faceTex);
    }
    localObject = this.userCosFunParams.iterator();
    while (((Iterator)localObject).hasNext()) {
      RendererUtils.clearTexture(((CosFunParam)((Iterator)localObject).next()).mFaceTexture);
    }
    localObject = this.transFilter;
    if (localObject != null) {
      ((CFTransformFilterOpt)localObject).clearGLSLSelf();
    }
    localObject = this.transFilterForTex;
    if (localObject != null) {
      ((CFTransformFilterForTex)localObject).clearGLSLSelf();
    }
    if (this.materialFrame != null) {
      RendererUtils.clearTexture(this.materialTex);
    }
    FaceOffUtil.recycleCrazySkinMergeBitmap();
  }
  
  public int getHeight()
  {
    CrazyFaceDataTemplate localCrazyFaceDataTemplate = this.template;
    if (localCrazyFaceDataTemplate == null) {
      return 0;
    }
    return (int)localCrazyFaceDataTemplate.height;
  }
  
  public Frame getMergedFrame(float paramFloat)
  {
    if (this.procType == 1)
    {
      localObject = this.transFilter;
      if (localObject == null) {
        return this.materialFrame;
      }
      return ((CFTransformFilterOpt)localObject).getMergedFrame(paramFloat);
    }
    Object localObject = this.transFilterForTex;
    if (localObject == null) {
      return this.materialFrame;
    }
    return ((CFTransformFilterForTex)localObject).getMergedFrame(paramFloat);
  }
  
  public int getWidth()
  {
    CrazyFaceDataTemplate localCrazyFaceDataTemplate = this.template;
    if (localCrazyFaceDataTemplate == null) {
      return 0;
    }
    return (int)localCrazyFaceDataTemplate.width;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, double paramDouble, boolean paramBoolean)
  {
    this.copyFilter.ApplyGLSLFilter();
    BenchUtil.benchStart("[CosFunTransitionFilter] preprocess");
    paramList = VideoMaterial.copyList(paramList);
    CosFunUtil.scale(paramList, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    this.srcFeature = new FaceFeatureTex();
    this.dstFeature = new FaceFeatureTex();
    this.srcFeature.faceFeature = new FaceFeature(paramList, paramInt2, paramInt3);
    this.srcFeature.faceTex = paramInt1;
    BenchUtil.benchEnd("[CosFunTransitionFilter] preprocess");
    BenchUtil.benchStart("[CosFunTransitionFilter] processUserBitmap");
    if (this.template != null)
    {
      int i = 0;
      while (i < this.template.faceLayers.size())
      {
        Object localObject = (FaceImageLayer)this.template.faceLayers.get(i);
        localObject = processUserBitmap(paramInt1, paramInt2, paramInt3, VideoMaterial.copyList(paramList), (FaceImageLayer)localObject);
        this.userCosFunParams.add(localObject);
        i += 1;
      }
    }
    BenchUtil.benchEnd("[CosFunTransitionFilter] processUserBitmap");
    BenchUtil.benchStart("[CosFunTransitionFilter] processCosFun");
    this.enableGAN = paramBoolean;
    processCosFun();
    BenchUtil.benchEnd("[CosFunTransitionFilter] processCosFun");
    if (this.dstFeature.faceFeature != null)
    {
      this.transFilter = new CFTransformFilterOpt(this.srcFeature, this.dstFeature, this.backgroundMode1, this.backgroundMode2);
      this.transFilter.ApplyGLSLFilter();
      this.transFilterForTex = new CFTransformFilterForTex(this.srcFeature, this.dstFeature, this.backgroundMode1, this.backgroundMode2);
      this.transFilterForTex.ApplyGLSLFilter();
    }
  }
  
  public boolean isInited()
  {
    return this.isInited;
  }
  
  public void setClampToEdge(boolean paramBoolean)
  {
    CFTransformFilterOpt localCFTransformFilterOpt = this.transFilter;
    if (localCFTransformFilterOpt != null) {
      localCFTransformFilterOpt.setClampToEdge(paramBoolean);
    }
  }
  
  public void setMaterialFrame(Frame paramFrame)
  {
    this.materialFrame = paramFrame;
  }
  
  public void setTransType(int paramInt)
  {
    CFTransformFilterOpt localCFTransformFilterOpt = this.transFilter;
    if (localCFTransformFilterOpt != null) {
      localCFTransformFilterOpt.setProcMethod(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CosFunTransitionFilter
 * JD-Core Version:    0.7.0.1
 */