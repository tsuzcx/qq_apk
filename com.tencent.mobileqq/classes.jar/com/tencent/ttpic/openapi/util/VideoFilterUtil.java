package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.camerasdk.avreport.AEKitBean;
import com.tencent.camerasdk.avreport.AEKitReportEvent;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.VideoFilterInputFreeze;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.CustomFilterItem;
import com.tencent.ttpic.openapi.filter.FaceOff3DFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.TransformFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TNNMaterialReportInfo;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.RANGE_TRIGGER_TYPE;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter3D;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFilterUtil
{
  public static final int IMAGE_HEIGHT = 960;
  public static final int IMAGE_WIDTH = 720;
  public static final double SCREEN_RATIO = 0.75D;
  public static final int SHOW_ONCE_TEX_COUNT = 2;
  public static final String SIMPLE_FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n void main(void) {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  public static final String SIMPLE_VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private static VideoFilterUtil.EffectFilterProvider effectFilterProvider;
  private static boolean isTNNAvailable = false;
  private static TNNMaterialReportInfo tnnMaterialReportInfo = new TNNMaterialReportInfo();
  
  public static boolean actionTriggered(List<PointF> paramList, List<StickerItem> paramList1, Set<Integer> paramSet)
  {
    if (paramList == null) {
      return false;
    }
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      if (paramSet == null) {
        return true;
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (StickerItem)paramList.next();
        if ((paramList1 != null) && (paramSet.contains(Integer.valueOf(paramList1.getTriggerTypeInt())))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static boolean canUseBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramVideoFilterBase == null) {
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      if ((((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode()) || (GLCapabilities.isSupportFramebufferFetch())) {
        bool1 = true;
      }
      return bool1;
    }
    if ((!(paramVideoFilterBase instanceof FaceOffByImageFilter)) && (!(paramVideoFilterBase instanceof ThreeDimFilter)))
    {
      if ((paramVideoFilterBase instanceof HeadCropFilter)) {
        return true;
      }
      if ((paramVideoFilterBase instanceof FaceOffFilter))
      {
        if (!((FaceOffFilter)paramVideoFilterBase).canUseBlendMode())
        {
          bool1 = bool2;
          if (!GLCapabilities.isSupportFramebufferFetch()) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramVideoFilterBase instanceof FaceOff3DFilter))
      {
        if (!((FaceOff3DFilter)paramVideoFilterBase).canUseBlendMode())
        {
          bool1 = bool3;
          if (!GLCapabilities.isSupportFramebufferFetch()) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramVideoFilterBase instanceof VoiceTextFilter)) {
        return true;
      }
      if ((paramVideoFilterBase instanceof ParticleFilter)) {
        return true;
      }
      if ((paramVideoFilterBase instanceof ParticleFilter3D)) {
        return true;
      }
      return paramVideoFilterBase.canUseBlendMode();
    }
    return true;
  }
  
  private static List<StyleCustomFilterGroup> createCosFunCustomFilterGroup(CosFun paramCosFun)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCosFun != null)
    {
      paramCosFun = paramCosFun.getCosFunGroupItem();
      if (paramCosFun != null)
      {
        paramCosFun = paramCosFun.iterator();
        while (paramCosFun.hasNext())
        {
          Object localObject = ((CosFun.CosFunGroupItem)paramCosFun.next()).getCosFunItems();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              StyleCustomFilterGroup localStyleCustomFilterGroup = createCustomFilterGroup(((CosFun.CosFunItem)((Iterator)localObject).next()).getCustomFilterItemList());
              if (localStyleCustomFilterGroup != null) {
                localArrayList.add(localStyleCustomFilterGroup);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static StyleCustomFilterGroup createCustomFilterGroup(List<CustomFilterItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      return new StyleCustomFilterGroup(paramList);
    }
    return null;
  }
  
  @Deprecated
  private static VideoFilterInputFreeze createFreezeFilter(StickerItem paramStickerItem)
  {
    if ((paramStickerItem != null) && (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type))
    {
      VideoFilterInputFreeze localVideoFilterInputFreeze = new VideoFilterInputFreeze();
      if (PTFaceAttr.PTExpression.TIME_TRIGGER.value == paramStickerItem.getTriggerTypeInt())
      {
        d1 = paramStickerItem.triggerFrameStartTime;
        d2 = paramStickerItem.frameDuration;
        Double.isNaN(d1);
        long l = (d1 * d2);
        d1 = paramStickerItem.triggerFrameDurationTime;
        d2 = paramStickerItem.frameDuration;
        Double.isNaN(d1);
        localVideoFilterInputFreeze.setFreezeFrameStartTime(l, (d1 * d2), paramStickerItem.alwaysTriggered);
        localVideoFilterInputFreeze.setTriggerTimeUpdater(paramStickerItem.triggerTimeUpdater);
      }
      else
      {
        localVideoFilterInputFreeze.setFreezeFrameTriggleType(paramStickerItem.getTriggerTypeInt(), paramStickerItem.alwaysTriggered, paramStickerItem.activateTriggerCount, paramStickerItem.activateTriggerTotalCount);
      }
      if ((paramStickerItem.triggerState != null) && (paramStickerItem.triggerState.size() > 0))
      {
        localVideoFilterInputFreeze.setIsStateTrigger(true);
        localVideoFilterInputFreeze.setStateTriggerParam(paramStickerItem.renderId, paramStickerItem.triggerState, paramStickerItem.triggerStateRange);
      }
      double d1 = paramStickerItem.frames * paramStickerItem.playCount;
      double d2 = paramStickerItem.frameDuration;
      Double.isNaN(d1);
      localVideoFilterInputFreeze.setFramesAndCount((d1 * d2));
      localVideoFilterInputFreeze.setPlayTimes(paramStickerItem.triggedTimes);
      d1 = paramStickerItem.frameDuration;
      d2 = paramStickerItem.delayedTriggedTime;
      Double.isNaN(d2);
      localVideoFilterInputFreeze.setDelayTriggerTime((d1 * d2));
      return localVideoFilterInputFreeze;
    }
    return null;
  }
  
  public static int get4DirectionAngle(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 3.141592653589793D) {
      d = paramDouble - 6.283185307179586D;
    }
    if ((d >= -0.7853981633974483D) && (d <= 0.7853981633974483D)) {
      return 0;
    }
    if ((d >= 0.7853981633974483D) && (d <= 2.356194490192345D)) {
      return 90;
    }
    if ((d >= -2.356194490192345D) && (d <= -0.7853981633974483D)) {
      return 270;
    }
    return 180;
  }
  
  public static double get8DirectionAngle(double paramDouble)
  {
    if ((paramDouble >= -0.3926990816987241D) && (paramDouble <= 0.3926990816987241D)) {
      return 0.0D;
    }
    if ((paramDouble >= 0.3926990816987241D) && (paramDouble <= 1.178097245096172D)) {
      return 0.7853981633974483D;
    }
    if ((paramDouble >= 1.178097245096172D) && (paramDouble <= 1.963495408493621D)) {
      return 1.570796326794897D;
    }
    if ((paramDouble >= 1.963495408493621D) && (paramDouble <= 2.748893571891069D)) {
      return 2.356194490192345D;
    }
    if ((paramDouble >= -1.178097245096172D) && (paramDouble <= -0.3926990816987241D)) {
      return -0.7853981633974483D;
    }
    if ((paramDouble >= -1.963495408493621D) && (paramDouble <= -1.178097245096172D)) {
      return -1.570796326794897D;
    }
    if ((paramDouble >= -2.748893571891069D) && (paramDouble <= -1.963495408493621D)) {
      return -2.356194490192345D;
    }
    return -3.141592653589793D;
  }
  
  public static List<String> getAllPngFileNames(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return localArrayList;
    }
    if (paramString.startsWith("assets://"))
    {
      try
      {
        paramString = AEModule.getContext().getAssets().list(FileUtils.getRealPath(paramString));
        if (paramString == null) {
          return localArrayList;
        }
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.endsWith(".png")) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
        paramString = new File(paramString).list(VideoMaterial.mPngFilter);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return localArrayList;
      }
    }
    else
    {
      if (paramString == null) {
        return localArrayList;
      }
      localArrayList.addAll(Arrays.asList(paramString));
    }
    return localArrayList;
  }
  
  public static VideoFilterUtil.EffectFilterProvider getEffectFilterProvider()
  {
    return effectFilterProvider;
  }
  
  public static float getFaceStatus(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    if (paramFaceRangeStatus == null) {
      return -1.0F;
    }
    VideoMaterial.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterial.RANGE_TRIGGER_TYPE.values();
    int j = arrayOfRANGE_TRIGGER_TYPE.length;
    int i = 0;
    while (i < j)
    {
      VideoMaterial.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
      if (localRANGE_TRIGGER_TYPE.value == paramInt) {
        return localRANGE_TRIGGER_TYPE.checker.getLevel(paramFaceRangeStatus, paramValueRange);
      }
      i += 1;
    }
    return -1.0F;
  }
  
  public static Frame getSecondLastFrame(Frame paramFrame)
  {
    if (FrameUtil.isValid(paramFrame))
    {
      Frame localFrame = paramFrame;
      if (FrameUtil.isValid(paramFrame.nextFrame))
      {
        while ((FrameUtil.isValid(localFrame.nextFrame)) && (FrameUtil.isValid(localFrame.nextFrame.nextFrame))) {
          localFrame = localFrame.nextFrame;
        }
        return localFrame;
      }
    }
    return null;
  }
  
  public static boolean hasBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter)) {
      return ((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode() ^ true;
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter)) {
      return ((FaceOffFilter)paramVideoFilterBase).canUseBlendMode() ^ true;
    }
    if ((paramVideoFilterBase instanceof FaceOff3DFilter)) {
      return ((FaceOff3DFilter)paramVideoFilterBase).canUseBlendMode() ^ true;
    }
    return false;
  }
  
  public static boolean isStatusTriggered(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    if (paramFaceRangeStatus == null) {
      return false;
    }
    VideoMaterial.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterial.RANGE_TRIGGER_TYPE.values();
    int j = arrayOfRANGE_TRIGGER_TYPE.length;
    int i = 0;
    while (i < j)
    {
      VideoMaterial.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
      if (localRANGE_TRIGGER_TYPE.value == paramInt) {
        return localRANGE_TRIGGER_TYPE.checker.isInRange(paramFaceRangeStatus, paramValueRange);
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean isTNNAvailable(FaceStyleItem paramFaceStyleItem)
  {
    boolean bool = isTNNAvailable;
    if (bool) {
      return bool;
    }
    isTNNAvailable = loadTNNModel(paramFaceStyleItem, 6);
    paramFaceStyleItem = tnnMaterialReportInfo;
    bool = isTNNAvailable;
    paramFaceStyleItem.isTNNAvailable = bool;
    return bool;
  }
  
  private static boolean loadTNNModel(FaceStyleItem paramFaceStyleItem, int paramInt)
  {
    return FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.loadRapidModelFrom(paramFaceStyleItem.dataPath, paramFaceStyleItem.modelName, false, true, paramInt, 1, paramInt);
  }
  
  public static boolean maybeTransformFilter(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && (((paramVideoFilterBase instanceof TransformFilter)) || ((paramVideoFilterBase instanceof CustomVideoFilter)));
  }
  
  public static boolean needBlendMode(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((VideoFilterBase)paramList.next() instanceof NormalVideoFilter)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean needCopy(VideoFilterBase paramVideoFilterBase)
  {
    boolean bool = false;
    if (paramVideoFilterBase == null) {
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter)) {
      return ((NormalVideoFilter)paramVideoFilterBase).needCopyTex();
    }
    if (((paramVideoFilterBase instanceof FaceOffFilter)) || ((paramVideoFilterBase instanceof FaceOff3DFilter))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean needDepthBuffer(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && ((paramVideoFilterBase instanceof ThreeDimFilter));
  }
  
  private static boolean needDowngrade(FaceStyleItem paramFaceStyleItem)
  {
    int i;
    if (paramFaceStyleItem.limitDeviceLevel == 0) {
      i = 3;
    } else {
      i = paramFaceStyleItem.limitDeviceLevel;
    }
    paramFaceStyleItem = tnnMaterialReportInfo;
    boolean bool;
    if (AEOfflineConfig.getPhonePerfLevel() < i) {
      bool = true;
    } else {
      bool = false;
    }
    paramFaceStyleItem.isDeviceDowngrade = bool;
    return tnnMaterialReportInfo.isDeviceDowngrade;
  }
  
  public static void removeEmptyFilters(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramList.next() == null) {
        paramList.remove();
      }
    }
  }
  
  public static void removeEmptyRenderItems(List<RenderItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if ((localRenderItem == null) || (localRenderItem.filter == null)) {
        paramList.remove();
      }
    }
  }
  
  private static void reportTNNInfo()
  {
    AEKitBean localAEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_TNN_MATERIAL.value);
    TNNMaterialReportInfo localTNNMaterialReportInfo = tnnMaterialReportInfo;
    if ((localTNNMaterialReportInfo != null) && (!TextUtils.isEmpty(localTNNMaterialReportInfo.materialID)))
    {
      localAEKitBean.ext_str1 = tnnMaterialReportInfo.materialID;
      localAEKitBean.ext_str2 = Boolean.valueOf(tnnMaterialReportInfo.isTNNAvailable).toString();
      localAEKitBean.ext_str3 = Integer.valueOf(tnnMaterialReportInfo.deviceLevel).toString();
      localAEKitBean.ext_str4 = Boolean.valueOf(tnnMaterialReportInfo.isDeviceDowngrade).toString();
      localAEKitBean.ext_str5 = tnnMaterialReportInfo.modelName;
      localAEKitBean.ext_str6 = tnnMaterialReportInfo.netSize.toString();
      AVReportCenter.getInstance().commit(localAEKitBean, Boolean.valueOf(true));
    }
  }
  
  public static void setEffectFilterProvider(VideoFilterUtil.EffectFilterProvider paramEffectFilterProvider)
  {
    effectFilterProvider = paramEffectFilterProvider;
  }
  
  public static void setRenderMode(VideoFilterBase paramVideoFilterBase, int paramInt)
  {
    if (paramVideoFilterBase != null) {
      paramVideoFilterBase.setRenderMode(paramInt);
    }
  }
  
  public static void setRenderMode(BaseFilter paramBaseFilter, int paramInt)
  {
    while (paramBaseFilter != null)
    {
      paramBaseFilter.setRenderMode(paramInt);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
  }
  
  public static void setRenderMode(List<? extends VideoFilterBase> paramList, int paramInt)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((VideoFilterBase)paramList.next()).setRenderMode(paramInt);
    }
  }
  
  public static void setRenderModes(List<RenderItem> paramList, int paramInt)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if ((localRenderItem.filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)localRenderItem.filter).setRenderMode(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoFilterUtil
 * JD-Core Version:    0.7.0.1
 */