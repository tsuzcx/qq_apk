package com.tencent.ttpic.openapi.model;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.ttpic.constant.MaterialType;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.BlurEffectItem;
import com.tencent.ttpic.model.FaceBeautyItem;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceMaskItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.ImageMaskItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.NonFitItem;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.offlineset.beans.FilterConfigBean.FilterParam;
import com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean;
import com.tencent.ttpic.openapi.filter.CustomFilterItem;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.AR_MATERIAL_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable.Info;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoMaterial
{
  public static final int SEGMENT_BORDERTYPE_SHAKE = 3;
  private List<TriggerActionItem> actionItemList;
  private String adAppLink;
  private String adIcon;
  private String adLink;
  private float alpha;
  private int arMaterialType;
  private List<String> arParticleList;
  private int arParticleType;
  private Audio2Text audio2Text;
  private GameParams audio3DParams;
  private double blendAlpha;
  private int blendMode;
  private BlurEffectItem blurEffectItem;
  private int categoryFlag;
  private List<VideoMaterial.ChildPendant> childrenPendants;
  private CosFun cosFun;
  private int cosmeticChangeMode;
  private int cosmeticChangeSwitch;
  private int cosmeticShelterSwitchClose;
  private List<CustomFilterItem> customFilterGroupList = new ArrayList();
  private List<CustomFilterItem> customFilterList = new ArrayList();
  private String dataPath;
  public String delayTips;
  private List<String> dependencies;
  private int detectorFlag;
  private List<DistortionItem> distortionItemList;
  private DoodleItem doodleItem;
  private List<MaterialStateEdgeItem> edgeItemList;
  private int environment;
  private HashMap<String, Object> extAttributes = new HashMap();
  private FabbyParts fabbyParts;
  private List<FaceBeautyItem> faceBeautyItemList;
  private FaceCropItem faceCropItem;
  private int faceDetectType;
  private String faceExchangeImage;
  public boolean faceExchangeImageDisableFaceCrop = false;
  private FaceExpression faceExpression;
  private List<FaceFeatureItem> faceFeatureItemList;
  private FaceImageLayer faceImageLayer;
  private List<FaceMaskItem> faceMaskItemList;
  private List<FaceMeshItem> faceMeshItemList;
  private List<FaceMoveItem> faceMoveItemList;
  private int[] faceMoveTriangles;
  private List<FaceItem> faceOffItemList;
  private List<Float> facePoints;
  private List<FaceStyleItem> faceStyleItemList;
  private int faceSwapType;
  private int faceValueDetectType;
  private int faceoffType;
  private int featureType;
  private List<String> filamentParticleList;
  private double filterBlurStrength;
  private String filterId;
  private List<FilterConfigBean.FilterParam> filtersConfig;
  private boolean flattenEar;
  private boolean flattenNose;
  private float fov;
  private GameParams gameParams;
  public int gestureAnimGapTime;
  public int gestureAnimType;
  public int gesturePointIndex;
  private List<GLBItemJava> glbList;
  private int grayScale;
  private String gridModel;
  private List<GridViewerItem> gridViewerItemList;
  private int handBoostEnable;
  private boolean hasAudio;
  private List<StickerItem> headCropItemList;
  private boolean hideUserHeadModel;
  private String id;
  private int imageDiyHeight;
  private int imageDiyWidth;
  private String imageFacePointsFileName;
  private List<ImageMaskItem> imageMaskItemList;
  private boolean isAR3DMaterial;
  private int isCanDiyPitcureVideo = 0;
  private boolean isCyberpunkMaterial = false;
  public boolean isDualPeople;
  private boolean isFaceCharmRangeMaterial = false;
  private boolean isFreezeFrameRequired = false;
  private boolean isHandCharmRangeMaterial = false;
  private boolean isInternalRecord;
  public boolean isNeedDecodeFaceFilter = true;
  private boolean isNeedDetectGender = false;
  private boolean isShookHeadPendant = false;
  private List<StickerItem> itemList;
  private List<StickerItem3D> itemList3D;
  public String itemTips;
  private String lipsLutPath;
  private String lipsLutStyleMaskPath;
  private int lipsSegType;
  private boolean loadImageFromCache = true;
  public BigAnimationParam mBigHeadParam;
  private List<VideoMaterial.DIYMaterialParams> mDIYMaterialParamsList = new ArrayList();
  private String mDiyItemId;
  public boolean mEnableFaceDetect = true;
  public List<String> mFilterList = new ArrayList();
  public String mGuideTips = null;
  public boolean mHasGestureFilter = false;
  public boolean mUseUlseeSdk = false;
  private String maskPaintImage;
  private int maskPaintRenderId;
  private int maskPaintSize;
  private int maskPaintType;
  private int maskType;
  private List<MaterialType> materialTypes = new ArrayList();
  private int maxFaceCount;
  private int minAppVersion;
  private List<MultiViewerItem> multiViewerItemList = new ArrayList();
  private String musicID;
  private boolean needBodyInfo = false;
  private boolean needFaceInfo = true;
  private boolean needReCaculateFace;
  public NonFitItem[] nonFitItems;
  private boolean notAllowBeautySetting = false;
  private int orderMode;
  private String overallAudio;
  private List<PhantomItem> phantomItemList;
  private String preferCameraId;
  private int randomGroupCount;
  private List<String> renderOrderList;
  private boolean resetWhenStartRecord;
  private List<String> resourceList;
  private int segmentBorderType = -1;
  private int segmentFeather;
  private boolean segmentRequired = false;
  private float[] segmentStrokeColor;
  private double segmentStrokeGap;
  private List<VideoMaterial.SegmentStroke> segmentStrokeList = new ArrayList();
  private double segmentStrokeWidth;
  private int shaderType;
  private String showTips;
  private float splitScreen;
  private StarParam starParam;
  private int stateVersion = 1;
  private int stickerOrderMode;
  private Map<String, StyleFilterSettingJsonBean> styleFilterList;
  private String substitue;
  private VideoMaterial substituteMaterial;
  private boolean supportLandscape;
  private boolean supportPause;
  private LazyLoadAnimationDrawable.Info tipsDrawableInfo;
  private String tipsIcon;
  private String tipsText;
  private int touchFlag = 0;
  private float transformAdjustAlpha = 1.0F;
  private int triggerType;
  private boolean useMesh = false;
  public BuckleFaceItem videoFaceCrop;
  private VideoFilterEffect videoFilterEffect;
  private int voicekind;
  private String weiboTag;
  
  private boolean hasCustomVideoFilter()
  {
    return (this.shaderType == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (this.shaderType == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value);
  }
  
  public void addDiyItemList(VideoMaterial.DIYMaterialParams paramDIYMaterialParams)
  {
    this.mDIYMaterialParamsList.add(paramDIYMaterialParams);
  }
  
  public void addExtAttribute(Object paramObject)
  {
    if (paramObject != null) {
      this.extAttributes.put(paramObject.getClass().getName(), paramObject);
    }
  }
  
  public void addMaterialType(MaterialType paramMaterialType)
  {
    if (!this.materialTypes.contains(paramMaterialType)) {
      this.materialTypes.add(paramMaterialType);
    }
  }
  
  public void createTipsDrawableInfo(Resources paramResources, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      localObject1 = new File(paramString1 + File.separator + paramString2);
    } while (!((File)localObject1).isDirectory());
    paramString1 = new ArrayList();
    Object localObject1 = ((File)localObject1).listFiles();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      if (!((File)localObject2).getName().startsWith(".")) {
        paramString1.add(localObject2);
      }
      i += 1;
    }
    localObject1 = new int[paramString1.size()];
    i = 0;
    while (i < paramString1.size())
    {
      localObject2 = ((File)paramString1.get(i)).getName();
      localObject1[i] = Integer.parseInt(((String)localObject2).substring(paramString2.length() + 1, ((String)localObject2).lastIndexOf(46)));
      i += 1;
    }
    paramString2 = new Integer[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramString2[i] = Integer.valueOf(i);
      i += 1;
    }
    Arrays.sort(paramString2, new VideoMaterial.1(this, (int[])localObject1));
    Object localObject2 = new int[localObject1.length];
    i = j;
    while (i < paramString2.length - 1)
    {
      localObject2[i] = ((localObject1[paramString2[(i + 1)].intValue()] - localObject1[paramString2[i].intValue()]) * paramInt1);
      i += 1;
    }
    if (paramString2.length >= 1)
    {
      i = localObject1[paramString2[(paramString2.length - 1)].intValue()];
      localObject2[(paramString2.length - 1)] = ((paramInt2 - i) * paramInt1);
    }
    this.tipsDrawableInfo = new LazyLoadAnimationDrawable.Info(paramResources, paramString1, (int[])localObject2, paramString2);
  }
  
  public String getAdAppLink()
  {
    return this.adAppLink;
  }
  
  public String getAdIcon()
  {
    return this.adIcon;
  }
  
  public String getAdLink()
  {
    return this.adLink;
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public int getArMaterialType()
  {
    return this.arMaterialType;
  }
  
  public List<String> getArParticleList()
  {
    return this.arParticleList;
  }
  
  public int getArParticleType()
  {
    return this.arParticleType;
  }
  
  public Audio2Text getAudio2Text()
  {
    return this.audio2Text;
  }
  
  public GameParams getAudio3DParams()
  {
    return this.audio3DParams;
  }
  
  public double getBlendAlpha()
  {
    return this.blendAlpha;
  }
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public BlurEffectItem getBlurEffectItem()
  {
    return this.blurEffectItem;
  }
  
  public int getCategoryFlag()
  {
    return this.categoryFlag;
  }
  
  public List<VideoMaterial.ChildPendant> getChildrenPendants()
  {
    return this.childrenPendants;
  }
  
  public CosFun getCosFun()
  {
    return this.cosFun;
  }
  
  public int getCosmeticChangeMode()
  {
    return this.cosmeticChangeMode;
  }
  
  public int getCosmeticChangeSwitch()
  {
    return this.cosmeticChangeSwitch;
  }
  
  public int getCosmeticShelterSwitchClose()
  {
    return this.cosmeticShelterSwitchClose;
  }
  
  public List<CustomFilterItem> getCustomFilterGroupList()
  {
    return this.customFilterGroupList;
  }
  
  public List<CustomFilterItem> getCustomFilterList()
  {
    return this.customFilterList;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public List<String> getDependencies()
  {
    return this.dependencies;
  }
  
  public int getDetectorFlag()
  {
    return this.detectorFlag;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public DoodleItem getDoodleItem()
  {
    return this.doodleItem;
  }
  
  public int getEnvironment()
  {
    return this.environment;
  }
  
  public Object getExtAttribute(String paramString)
  {
    if ((this.extAttributes != null) && (!this.extAttributes.isEmpty())) {
      return this.extAttributes.get(paramString);
    }
    return null;
  }
  
  public FabbyParts getFabbyParts()
  {
    return this.fabbyParts;
  }
  
  public List<FaceBeautyItem> getFaceBeautyItemList()
  {
    return this.faceBeautyItemList;
  }
  
  public FaceCropItem getFaceCropItem()
  {
    return this.faceCropItem;
  }
  
  public int getFaceDetectType()
  {
    return this.faceDetectType;
  }
  
  public String getFaceExchangeImage()
  {
    return this.faceExchangeImage;
  }
  
  public FaceExpression getFaceExpression()
  {
    return this.faceExpression;
  }
  
  public List<FaceFeatureItem> getFaceFeatureItemList()
  {
    return this.faceFeatureItemList;
  }
  
  public FaceImageLayer getFaceImageLayer()
  {
    return this.faceImageLayer;
  }
  
  public FaceMaskItem getFaceMaskItemById(String paramString)
  {
    if ((paramString != null) && (this.faceMaskItemList != null) && (this.faceMaskItemList.size() > 0))
    {
      Iterator localIterator = this.faceMaskItemList.iterator();
      while (localIterator.hasNext())
      {
        FaceMaskItem localFaceMaskItem = (FaceMaskItem)localIterator.next();
        if (paramString.equals(localFaceMaskItem.faceMaskID)) {
          return localFaceMaskItem;
        }
      }
    }
    return null;
  }
  
  public List<FaceMeshItem> getFaceMeshItemList()
  {
    return this.faceMeshItemList;
  }
  
  public List<FaceMoveItem> getFaceMoveItemList()
  {
    return this.faceMoveItemList;
  }
  
  public int[] getFaceMoveTriangles()
  {
    return this.faceMoveTriangles;
  }
  
  public List<FaceItem> getFaceOffItemList()
  {
    return this.faceOffItemList;
  }
  
  public List<Float> getFacePoints()
  {
    return this.facePoints;
  }
  
  public List<FaceStyleItem> getFaceStyleItemList()
  {
    return this.faceStyleItemList;
  }
  
  public int getFaceSwapType()
  {
    return this.faceSwapType;
  }
  
  public int getFaceValueDetectType()
  {
    return this.faceValueDetectType;
  }
  
  public int getFaceoffType()
  {
    return this.faceoffType;
  }
  
  public int getFeatureType()
  {
    return this.featureType;
  }
  
  public List<String> getFilamentParticleList()
  {
    return this.filamentParticleList;
  }
  
  public double getFilterBlurStrength()
  {
    return this.filterBlurStrength;
  }
  
  public String getFilterId()
  {
    return this.filterId;
  }
  
  public List<String> getFilterList()
  {
    return this.mFilterList;
  }
  
  public List<FilterConfigBean.FilterParam> getFiltersConfig()
  {
    return this.filtersConfig;
  }
  
  public VideoMaterial.DIYMaterialParams getFirstDIYMaterialParams()
  {
    if ((getmDIYMaterialParamsList() != null) && (getmDIYMaterialParamsList().size() > 0)) {
      return (VideoMaterial.DIYMaterialParams)getmDIYMaterialParamsList().get(0);
    }
    return null;
  }
  
  public String getFirstDiyFilePath()
  {
    if ((getmDIYMaterialParamsList() != null) && (getmDIYMaterialParamsList().size() > 0)) {
      return ((VideoMaterial.DIYMaterialParams)getmDIYMaterialParamsList().get(0)).diyFilePath;
    }
    return "";
  }
  
  public int getFirstDiyImageHeight()
  {
    if ((getmDIYMaterialParamsList() != null) && (getmDIYMaterialParamsList().size() > 0)) {
      return ((VideoMaterial.DIYMaterialParams)getmDIYMaterialParamsList().get(0)).diyImageHeight;
    }
    return 960;
  }
  
  public int getFirstDiyImageWidth()
  {
    if ((getmDIYMaterialParamsList() != null) && (getmDIYMaterialParamsList().size() > 0)) {
      return ((VideoMaterial.DIYMaterialParams)getmDIYMaterialParamsList().get(0)).diyImageWidth;
    }
    return 720;
  }
  
  public String getFirstDiyItemid()
  {
    if ((getmDIYMaterialParamsList() != null) && (getmDIYMaterialParamsList().size() > 0)) {
      return ((VideoMaterial.DIYMaterialParams)getmDIYMaterialParamsList().get(0)).diyItemid;
    }
    return null;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public GameParams getGameParams()
  {
    return this.gameParams;
  }
  
  public List<GLBItemJava> getGlbList()
  {
    return this.glbList;
  }
  
  public int getGrayScale()
  {
    return this.grayScale;
  }
  
  public String getGridModel()
  {
    return this.gridModel;
  }
  
  public List<GridViewerItem> getGridViewerItemList()
  {
    return this.gridViewerItemList;
  }
  
  public int getHandBoostEnable()
  {
    return this.handBoostEnable;
  }
  
  public List<StickerItem> getHeadCropItemList()
  {
    return this.headCropItemList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getImageFacePointsFileName()
  {
    return this.imageFacePointsFileName;
  }
  
  public ImageMaskItem getImageMaskItemById(String paramString)
  {
    if ((this.imageMaskItemList != null) && (this.imageMaskItemList.size() > 0))
    {
      Iterator localIterator = this.imageMaskItemList.iterator();
      while (localIterator.hasNext())
      {
        ImageMaskItem localImageMaskItem = (ImageMaskItem)localIterator.next();
        if (paramString.equals(localImageMaskItem.getMaskId())) {
          return localImageMaskItem;
        }
      }
    }
    return null;
  }
  
  public List<ImageMaskItem> getImageMaskItemList()
  {
    return this.imageMaskItemList;
  }
  
  public boolean getIsAR3DMaterial()
  {
    return this.isAR3DMaterial;
  }
  
  public boolean getIsInternalRecord()
  {
    return this.isInternalRecord;
  }
  
  public List<StickerItem> getItemList()
  {
    return this.itemList;
  }
  
  public List<StickerItem3D> getItemList3D()
  {
    return this.itemList3D;
  }
  
  public String getLipsLutPath()
  {
    return this.lipsLutPath;
  }
  
  public String getLipsLutStyleMaskPath()
  {
    return this.lipsLutStyleMaskPath;
  }
  
  public int getLipsSegType()
  {
    return this.lipsSegType;
  }
  
  public String getMaskPaintImage()
  {
    return this.maskPaintImage;
  }
  
  public int getMaskPaintRenderId()
  {
    return this.maskPaintRenderId;
  }
  
  public int getMaskPaintSize()
  {
    return this.maskPaintSize;
  }
  
  public int getMaskPaintType()
  {
    return this.maskPaintType;
  }
  
  public int getMaskType()
  {
    return this.maskType;
  }
  
  public String getMaterialMusicFilePath()
  {
    if (!TextUtils.isEmpty(this.overallAudio)) {
      return this.dataPath + File.separator + this.overallAudio;
    }
    return "";
  }
  
  public List<String> getMaterialTypes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.materialTypes.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((MaterialType)localIterator.next()).type);
    }
    return localArrayList;
  }
  
  public int getMaxFaceCount()
  {
    return this.maxFaceCount;
  }
  
  public int getMinAppVersion()
  {
    return this.minAppVersion;
  }
  
  public List<MultiViewerItem> getMultiViewerItemList()
  {
    return this.multiViewerItemList;
  }
  
  public String getMusicID()
  {
    return this.musicID;
  }
  
  public List<StickerItem> getNonFitItemList()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.nonFitItems != null)
    {
      localObject1 = localObject2;
      if (this.nonFitItems.length > 0)
      {
        localObject1 = new ArrayList();
        int i = 0;
        while (i < this.nonFitItems.length)
        {
          ((List)localObject1).add(this.nonFitItems[i]);
          i += 1;
        }
      }
    }
    return localObject1;
  }
  
  public NonFitItem[] getNonFitItems()
  {
    return this.nonFitItems;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public List<PhantomItem> getPhantomItemList()
  {
    return this.phantomItemList;
  }
  
  public String getPreferCameraId()
  {
    return this.preferCameraId;
  }
  
  public int getRandomGroupCount()
  {
    return this.randomGroupCount;
  }
  
  public List<String> getRenderOrderList()
  {
    return this.renderOrderList;
  }
  
  public List<String> getResourceList()
  {
    return this.resourceList;
  }
  
  public int getSegmentBorderType()
  {
    return this.segmentBorderType;
  }
  
  public int getSegmentFeather()
  {
    return this.segmentFeather;
  }
  
  public float[] getSegmentStrokeColor()
  {
    return this.segmentStrokeColor;
  }
  
  public double getSegmentStrokeGap()
  {
    return this.segmentStrokeGap;
  }
  
  public StickerItem getSegmentStrokeItem()
  {
    if ((this.itemList != null) && (!this.itemList.isEmpty()))
    {
      Iterator localIterator = this.itemList.iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (VideoMaterialUtil.isSegStrokeItem(localStickerItem)) {
          return localStickerItem;
        }
      }
    }
    return null;
  }
  
  public List<VideoMaterial.SegmentStroke> getSegmentStrokeList()
  {
    return this.segmentStrokeList;
  }
  
  public List<StickerItem> getSegmentStrokeTriggerItems()
  {
    Iterator localIterator = null;
    Object localObject1 = null;
    Object localObject2 = localIterator;
    if (this.itemList != null)
    {
      localObject2 = localIterator;
      if (!this.itemList.isEmpty())
      {
        localIterator = this.itemList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          StickerItem localStickerItem = (StickerItem)localIterator.next();
          if (VideoMaterialUtil.isSegStrokeTriggerItem(localStickerItem))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localStickerItem);
            localObject1 = localObject2;
          }
        }
      }
    }
    return localObject2;
  }
  
  public double getSegmentStrokeWidth()
  {
    return this.segmentStrokeWidth;
  }
  
  public int getShaderType()
  {
    return this.shaderType;
  }
  
  public String getShowTips()
  {
    return this.showTips;
  }
  
  public float getSplitScreen()
  {
    return this.splitScreen;
  }
  
  public StarParam getStarParam()
  {
    return this.starParam;
  }
  
  public int getStateVersion()
  {
    return this.stateVersion;
  }
  
  public int getStickerOrderMode()
  {
    return this.stickerOrderMode;
  }
  
  public Map<String, StyleFilterSettingJsonBean> getStyleFilterList()
  {
    return this.styleFilterList;
  }
  
  public String getSubstitue()
  {
    return this.substitue;
  }
  
  public VideoMaterial getSubstituteMaterial()
  {
    return this.substituteMaterial;
  }
  
  public LazyLoadAnimationDrawable getTipsDrawable()
  {
    if (this.tipsDrawableInfo == null) {
      return null;
    }
    return new LazyLoadAnimationDrawable(this.tipsDrawableInfo);
  }
  
  public String getTipsIcon()
  {
    return this.tipsIcon;
  }
  
  public String getTipsText()
  {
    return this.tipsText;
  }
  
  public int getTouchFlag()
  {
    return this.touchFlag;
  }
  
  public float getTransformAdjustAlpha()
  {
    return this.transformAdjustAlpha;
  }
  
  public List<TriggerActionItem> getTriggerActionItemList()
  {
    return this.actionItemList;
  }
  
  public List<MaterialStateEdgeItem> getTriggerStateEdgeItemList()
  {
    return this.edgeItemList;
  }
  
  public int getTriggerType()
  {
    return this.triggerType;
  }
  
  public VideoFilterEffect getVideoFilterEffect()
  {
    return this.videoFilterEffect;
  }
  
  public int getVoicekind()
  {
    return this.voicekind;
  }
  
  public String getWeiboTag()
  {
    return this.weiboTag;
  }
  
  public List<VideoMaterial.DIYMaterialParams> getmDIYMaterialParamsList()
  {
    return this.mDIYMaterialParamsList;
  }
  
  public boolean hasAd()
  {
    return (!TextUtils.isEmpty(this.adIcon)) || (!TextUtils.isEmpty(this.adLink)) || (!TextUtils.isEmpty(this.adAppLink));
  }
  
  public boolean hasDisplacementItem()
  {
    if (this.itemList != null)
    {
      Iterator localIterator = this.itemList.iterator();
      while (localIterator.hasNext()) {
        if (((StickerItem)localIterator.next()).isDisplacementMaterial()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasFilterList()
  {
    return this.mFilterList.size() > 0;
  }
  
  public boolean hasMultiViewer()
  {
    return (this.multiViewerItemList != null) && (this.multiViewerItemList.size() > 0);
  }
  
  public boolean isCanDiyPitcureVideo()
  {
    return getFirstDiyItemid() != null;
  }
  
  public boolean isDBTriggered()
  {
    if (this.itemList == null) {
      return false;
    }
    if (hasCustomVideoFilter()) {
      return true;
    }
    Iterator localIterator = this.itemList.iterator();
    while (localIterator.hasNext()) {
      if (((StickerItem)localIterator.next()).isDBTriggered()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isDetectGender()
  {
    return this.isNeedDetectGender;
  }
  
  public boolean isFaceCharmRange()
  {
    return this.isFaceCharmRangeMaterial;
  }
  
  public boolean isFaceExchangeImageDisableFaceCrop()
  {
    return this.faceExchangeImageDisableFaceCrop;
  }
  
  public boolean isFlattenEar()
  {
    return this.flattenEar;
  }
  
  public boolean isFlattenNose()
  {
    return this.flattenNose;
  }
  
  public boolean isHandCharmRange()
  {
    return this.isHandCharmRangeMaterial;
  }
  
  public boolean isHasAudio()
  {
    Iterator localIterator = this.multiViewerItemList.iterator();
    if (localIterator.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)localIterator.next();
      if ((this.hasAudio) || (localMultiViewerItem.videoMaterial.hasAudio)) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasAudio = bool;
        break;
      }
    }
    return this.hasAudio;
  }
  
  public boolean isHasCosFun()
  {
    return this.cosFun != null;
  }
  
  public boolean isHideUserHeadModel()
  {
    return this.hideUserHeadModel;
  }
  
  public boolean isLoadImageFromCache()
  {
    return this.loadImageFromCache;
  }
  
  public boolean isNeedFreezeFrame()
  {
    return this.isFreezeFrameRequired;
  }
  
  public boolean isNeedReCaculateFace()
  {
    return this.needReCaculateFace;
  }
  
  public boolean isNotAllowBeautySetting()
  {
    return this.notAllowBeautySetting;
  }
  
  public boolean isResetWhenStartRecord()
  {
    return this.resetWhenStartRecord;
  }
  
  public boolean isSegmentRequired()
  {
    return this.segmentRequired;
  }
  
  public boolean isShookHeadPendant()
  {
    return this.isShookHeadPendant;
  }
  
  public boolean isSpecificFilter()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.videoFilterEffect != null)
    {
      bool1 = bool2;
      if (this.videoFilterEffect.order == 100) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSupportLandscape()
  {
    return this.supportLandscape;
  }
  
  public boolean isSupportPause()
  {
    return this.supportPause;
  }
  
  public boolean isSupportTouchEvent()
  {
    return getArParticleType() == VideoMaterialUtil.AR_MATERIAL_TYPE.CLICKABLE.value;
  }
  
  public boolean isUseMesh()
  {
    return this.useMesh;
  }
  
  public boolean needBodyInfo()
  {
    return this.needBodyInfo;
  }
  
  public boolean needFaceInfo()
  {
    return this.needFaceInfo;
  }
  
  public void setAdAppLink(String paramString)
  {
    this.adAppLink = paramString;
  }
  
  public void setAdIcon(String paramString)
  {
    this.adIcon = paramString;
  }
  
  public void setAdLink(String paramString)
  {
    this.adLink = paramString;
  }
  
  public void setAllRenderID(int paramInt)
  {
    if (this.itemList != null)
    {
      Iterator localIterator = this.itemList.iterator();
      while (localIterator.hasNext()) {
        ((StickerItem)localIterator.next()).renderId = paramInt;
      }
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setArMaterialType(int paramInt)
  {
    this.arMaterialType = paramInt;
  }
  
  public void setArParticleList(List<String> paramList)
  {
    this.arParticleList = paramList;
  }
  
  public void setArParticleType(int paramInt)
  {
    this.arParticleType = paramInt;
  }
  
  public void setAudio2Text(Audio2Text paramAudio2Text)
  {
    this.audio2Text = paramAudio2Text;
  }
  
  public void setAudio3DParams(GameParams paramGameParams)
  {
    this.audio3DParams = paramGameParams;
  }
  
  public void setBlendAlpha(double paramDouble)
  {
    this.blendAlpha = paramDouble;
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setBlurEffectItem(BlurEffectItem paramBlurEffectItem)
  {
    this.blurEffectItem = paramBlurEffectItem;
  }
  
  public void setCategoryFlag(int paramInt)
  {
    this.categoryFlag = paramInt;
  }
  
  public void setChildrenPendants(List<VideoMaterial.ChildPendant> paramList)
  {
    this.childrenPendants = paramList;
  }
  
  public void setCosFun(CosFun paramCosFun)
  {
    this.cosFun = paramCosFun;
  }
  
  public void setCosmeticChangeMode(int paramInt)
  {
    this.cosmeticChangeMode = paramInt;
  }
  
  public void setCosmeticChangeSwitch(int paramInt)
  {
    this.cosmeticChangeSwitch = paramInt;
  }
  
  public void setCosmeticShelterSwitchClose(int paramInt)
  {
    this.cosmeticShelterSwitchClose = paramInt;
  }
  
  public void setCustomFilterGroupList(ArrayList<CustomFilterItem> paramArrayList)
  {
    this.customFilterGroupList = paramArrayList;
  }
  
  public void setCustomFilterList(ArrayList<CustomFilterItem> paramArrayList)
  {
    this.customFilterList = paramArrayList;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDependencies(List<String> paramList)
  {
    this.dependencies = paramList;
  }
  
  public void setDetectGender(boolean paramBoolean)
  {
    this.isNeedDetectGender = paramBoolean;
  }
  
  public void setDetectorFlag(int paramInt)
  {
    this.detectorFlag = paramInt;
  }
  
  public void setDistortionItemList(List<DistortionItem> paramList)
  {
    this.distortionItemList = paramList;
  }
  
  public void setDiyItemList(List<VideoMaterial.DIYMaterialParams> paramList)
  {
    this.mDIYMaterialParamsList = paramList;
  }
  
  public void setDoodleItem(DoodleItem paramDoodleItem)
  {
    this.doodleItem = paramDoodleItem;
  }
  
  public void setEnvironment(int paramInt)
  {
    this.environment = paramInt;
  }
  
  public void setFabbyParts(FabbyParts paramFabbyParts)
  {
    this.fabbyParts = paramFabbyParts;
  }
  
  public void setFaceBeautyItemList(List<FaceBeautyItem> paramList)
  {
    this.faceBeautyItemList = paramList;
  }
  
  public void setFaceCharmRangeMaterial(boolean paramBoolean)
  {
    this.isFaceCharmRangeMaterial = paramBoolean;
  }
  
  public void setFaceCropItem(FaceCropItem paramFaceCropItem)
  {
    this.faceCropItem = paramFaceCropItem;
  }
  
  public void setFaceDetectType(int paramInt)
  {
    this.faceDetectType = paramInt;
  }
  
  public void setFaceExchangeImage(String paramString)
  {
    this.faceExchangeImage = paramString;
  }
  
  public void setFaceExchangeImageDisableFaceCrop(boolean paramBoolean)
  {
    this.faceExchangeImageDisableFaceCrop = paramBoolean;
  }
  
  public void setFaceExpression(FaceExpression paramFaceExpression)
  {
    this.faceExpression = paramFaceExpression;
  }
  
  public void setFaceFeatureItemList(List<FaceFeatureItem> paramList)
  {
    this.faceFeatureItemList = paramList;
  }
  
  public void setFaceImageLayer(FaceImageLayer paramFaceImageLayer)
  {
    this.faceImageLayer = paramFaceImageLayer;
  }
  
  public void setFaceMaskItemList(List<FaceMaskItem> paramList)
  {
    this.faceMaskItemList = paramList;
  }
  
  public void setFaceMeshItemList(List<FaceMeshItem> paramList)
  {
    this.faceMeshItemList = paramList;
  }
  
  public void setFaceMoveItemList(List<FaceMoveItem> paramList)
  {
    this.faceMoveItemList = paramList;
  }
  
  public void setFaceMoveTriangles(int[] paramArrayOfInt)
  {
    this.faceMoveTriangles = paramArrayOfInt;
  }
  
  public void setFaceOffItemList(List<FaceItem> paramList)
  {
    this.faceOffItemList = paramList;
  }
  
  public void setFacePoints(List<Float> paramList)
  {
    this.facePoints = paramList;
  }
  
  public void setFaceStyleItemList(List<FaceStyleItem> paramList)
  {
    this.faceStyleItemList = paramList;
  }
  
  public void setFaceSwapType(int paramInt)
  {
    this.faceSwapType = paramInt;
  }
  
  public void setFaceValueDetectType(int paramInt)
  {
    this.faceValueDetectType = paramInt;
  }
  
  public void setFaceoffType(int paramInt)
  {
    this.faceoffType = paramInt;
  }
  
  public void setFeatureType(int paramInt)
  {
    this.featureType = paramInt;
  }
  
  public void setFilamentParticleList(List<String> paramList)
  {
    this.filamentParticleList = paramList;
  }
  
  public void setFilterBlurStrength(double paramDouble)
  {
    this.filterBlurStrength = paramDouble;
  }
  
  public void setFilterId(String paramString)
  {
    this.filterId = paramString;
  }
  
  public void setFiltersConfig(List<FilterConfigBean.FilterParam> paramList)
  {
    this.filtersConfig = paramList;
  }
  
  public void setFlattenEar(boolean paramBoolean)
  {
    this.flattenEar = paramBoolean;
  }
  
  public void setFlattenNose(boolean paramBoolean)
  {
    this.flattenNose = paramBoolean;
  }
  
  public void setFov(float paramFloat)
  {
    this.fov = paramFloat;
  }
  
  public void setGameParams(GameParams paramGameParams)
  {
    this.gameParams = paramGameParams;
  }
  
  public void setGlbList(List<GLBItemJava> paramList)
  {
    this.glbList = paramList;
  }
  
  public void setGrayScale(int paramInt)
  {
    this.grayScale = paramInt;
  }
  
  public void setGridModel(String paramString)
  {
    this.gridModel = paramString;
  }
  
  public void setGridViewerItemList(List<GridViewerItem> paramList)
  {
    this.gridViewerItemList = paramList;
  }
  
  public void setHandBoostEnable(int paramInt)
  {
    this.handBoostEnable = paramInt;
  }
  
  public void setHandCharmRangeMaterial(boolean paramBoolean)
  {
    this.isHandCharmRangeMaterial = paramBoolean;
  }
  
  public void setHasAudio(boolean paramBoolean)
  {
    this.hasAudio = paramBoolean;
  }
  
  public void setHeadCropItemList(List<StickerItem> paramList)
  {
    this.headCropItemList = paramList;
  }
  
  public void setHideUserHeadModel(boolean paramBoolean)
  {
    this.hideUserHeadModel = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImageFacePointsFileName(String paramString)
  {
    this.imageFacePointsFileName = paramString;
  }
  
  public void setImageMaskItemList(List<ImageMaskItem> paramList)
  {
    this.imageMaskItemList = paramList;
  }
  
  public void setIsAR3DMaterial(boolean paramBoolean)
  {
    this.isAR3DMaterial = paramBoolean;
  }
  
  public void setIsInternalRecord(boolean paramBoolean)
  {
    this.isInternalRecord = paramBoolean;
  }
  
  public void setItemList(List<StickerItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setItemList3D(List<StickerItem3D> paramList)
  {
    this.itemList3D = paramList;
  }
  
  public void setLipsLutPath(String paramString)
  {
    this.lipsLutPath = paramString;
  }
  
  public void setLipsLutStyleMaskPath(String paramString)
  {
    this.lipsLutStyleMaskPath = paramString;
  }
  
  public void setLipsSegType(int paramInt)
  {
    this.lipsSegType = paramInt;
  }
  
  public void setLoadImageFromCache(boolean paramBoolean)
  {
    this.loadImageFromCache = paramBoolean;
  }
  
  public void setMaskPaintImage(String paramString)
  {
    this.maskPaintImage = paramString;
  }
  
  public void setMaskPaintRenderId(int paramInt)
  {
    this.maskPaintRenderId = paramInt;
  }
  
  public void setMaskPaintSize(int paramInt)
  {
    this.maskPaintSize = paramInt;
  }
  
  public void setMaskPaintType(int paramInt)
  {
    this.maskPaintType = paramInt;
  }
  
  public void setMaskType(int paramInt)
  {
    this.maskType = paramInt;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    this.maxFaceCount = Math.max(1, paramInt);
  }
  
  public void setMinAppVersion(int paramInt)
  {
    this.minAppVersion = paramInt;
  }
  
  public void setMultiViewerItemList(List<MultiViewerItem> paramList)
  {
    this.multiViewerItemList = paramList;
  }
  
  public void setMusicID(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.musicID = paramString;
    }
  }
  
  public void setNeedBodyInfo(boolean paramBoolean)
  {
    this.needBodyInfo = paramBoolean;
  }
  
  public void setNeedFaceInfo(boolean paramBoolean)
  {
    this.needFaceInfo = paramBoolean;
  }
  
  public void setNeedFreezeFrame(boolean paramBoolean)
  {
    this.isFreezeFrameRequired = paramBoolean;
  }
  
  public void setNeedReCaculateFace(boolean paramBoolean)
  {
    this.needReCaculateFace = paramBoolean;
  }
  
  public void setNonFitItems(NonFitItem[] paramArrayOfNonFitItem)
  {
    if ((paramArrayOfNonFitItem != null) && (paramArrayOfNonFitItem.length > 0)) {
      this.nonFitItems = paramArrayOfNonFitItem;
    }
  }
  
  public void setNotAllowBeautySetting(boolean paramBoolean)
  {
    this.notAllowBeautySetting = paramBoolean;
  }
  
  public void setOrderMode(int paramInt)
  {
    this.orderMode = paramInt;
  }
  
  public void setOverallAudio(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.overallAudio = paramString;
    }
  }
  
  public void setPhantomItemList(List<PhantomItem> paramList)
  {
    this.phantomItemList = paramList;
  }
  
  public void setPreferCameraId(String paramString)
  {
    this.preferCameraId = paramString;
  }
  
  public void setRandomGroupCount(int paramInt)
  {
    this.randomGroupCount = paramInt;
  }
  
  public void setRenderOrderList(List<String> paramList)
  {
    this.renderOrderList = paramList;
  }
  
  public void setResetWhenStartRecord(boolean paramBoolean)
  {
    this.resetWhenStartRecord = paramBoolean;
  }
  
  public void setResourceList(List<String> paramList)
  {
    this.resourceList = paramList;
  }
  
  public void setSegmentBorderType(int paramInt)
  {
    this.segmentBorderType = paramInt;
  }
  
  public void setSegmentFeather(int paramInt)
  {
    this.segmentFeather = paramInt;
  }
  
  public void setSegmentRequired(boolean paramBoolean)
  {
    this.segmentRequired = paramBoolean;
  }
  
  public void setSegmentStrokeColor(float[] paramArrayOfFloat)
  {
    this.segmentStrokeColor = paramArrayOfFloat;
  }
  
  public void setSegmentStrokeGap(double paramDouble)
  {
    this.segmentStrokeGap = paramDouble;
  }
  
  public void setSegmentStrokeList(List<VideoMaterial.SegmentStroke> paramList)
  {
    this.segmentStrokeList = paramList;
  }
  
  public void setSegmentStrokeWidth(double paramDouble)
  {
    this.segmentStrokeWidth = paramDouble;
  }
  
  public void setShaderType(int paramInt)
  {
    this.shaderType = paramInt;
  }
  
  public void setShookHeadPendant(boolean paramBoolean)
  {
    this.isShookHeadPendant = paramBoolean;
  }
  
  public void setShowTips(String paramString)
  {
    this.showTips = paramString;
  }
  
  public void setSplitScreen(float paramFloat)
  {
    this.splitScreen = paramFloat;
  }
  
  public void setStarParam(StarParam paramStarParam)
  {
    this.starParam = paramStarParam;
  }
  
  public void setStateVersion(int paramInt)
  {
    this.stateVersion = paramInt;
  }
  
  public void setStickerOrderMode(int paramInt)
  {
    this.stickerOrderMode = paramInt;
  }
  
  public void setStyleFilterList(Map<String, StyleFilterSettingJsonBean> paramMap)
  {
    this.styleFilterList = paramMap;
  }
  
  public void setSubstitue(String paramString)
  {
    this.substitue = paramString;
  }
  
  public void setSubstituteMaterial(VideoMaterial paramVideoMaterial)
  {
    this.substituteMaterial = paramVideoMaterial;
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    this.supportLandscape = paramBoolean;
  }
  
  public void setSupportPause(boolean paramBoolean)
  {
    this.supportPause = paramBoolean;
  }
  
  public void setTipsIcon(String paramString)
  {
    this.tipsIcon = paramString;
  }
  
  public void setTipsText(String paramString)
  {
    this.tipsText = paramString;
  }
  
  public void setTouchFlag(int paramInt)
  {
    this.touchFlag = paramInt;
  }
  
  public void setTransformAdjustAlpha(float paramFloat)
  {
    this.transformAdjustAlpha = paramFloat;
  }
  
  public void setTriggerActionItemList(List<TriggerActionItem> paramList)
  {
    this.actionItemList = paramList;
  }
  
  public void setTriggerStateEdgeItemList(List<MaterialStateEdgeItem> paramList)
  {
    this.edgeItemList = paramList;
  }
  
  public void setTriggerType(int paramInt)
  {
    if ((paramInt > this.triggerType) && (paramInt < 100)) {
      this.triggerType = paramInt;
    }
  }
  
  public void setUseMesh(boolean paramBoolean)
  {
    this.useMesh = paramBoolean;
  }
  
  public void setVideoFilterEffect(VideoFilterEffect paramVideoFilterEffect)
  {
    this.videoFilterEffect = paramVideoFilterEffect;
  }
  
  public void setVoicekind(int paramInt)
  {
    this.voicekind = paramInt;
  }
  
  public void setWeiboTag(String paramString)
  {
    this.weiboTag = paramString;
  }
  
  public String toString()
  {
    return "VideoMaterial{dataPath='" + this.dataPath + '\'' + ", hasAudio=" + this.hasAudio + ", minAppVersion=" + this.minAppVersion + ", shaderType=" + this.shaderType + ", faceoffType=" + this.faceoffType + ", maxFaceCount=" + this.maxFaceCount + ", stickerOrderMode=" + this.stickerOrderMode + ", voicekind=" + this.voicekind + ", environment=" + this.environment + ", resourceList=" + this.resourceList + ", renderOrderList=" + this.renderOrderList + ", itemList=" + this.itemList + ", itemList3D=" + this.itemList3D + ", faceOffItemList=" + this.faceOffItemList + ", faceStyleItemList=" + this.faceStyleItemList + ", headCropItemList=" + this.headCropItemList + ", distortionItemList=" + this.distortionItemList + ", faceMeshItemList=" + this.faceMeshItemList + ", faceMoveItemList=" + this.faceMoveItemList + ", multiViewerItemList=" + this.multiViewerItemList + ", facePoints=" + this.facePoints + ", triggerType=" + this.triggerType + ", faceExchangeImage='" + this.faceExchangeImage + '\'' + ", faceExchangeImageDisableFaceCrop='" + this.faceExchangeImageDisableFaceCrop + '\'' + ", imageFacePointsFileName='" + this.imageFacePointsFileName + '\'' + ", blendAlpha=" + this.blendAlpha + ", grayScale=" + this.grayScale + ", orderMode=" + this.orderMode + ", blendMode=" + this.blendMode + ", featureType=" + this.featureType + ", id='" + this.id + '\'' + ", supportLandscape=" + this.supportLandscape + ", randomGroupCount=" + this.randomGroupCount + ", faceMoveTriangles=" + Arrays.toString(this.faceMoveTriangles) + ", filterId='" + this.filterId + '\'' + ", filterBlurStrength='" + this.filterBlurStrength + '\'' + ", videoFilterEffect=" + this.videoFilterEffect + ", faceSwapType=" + this.faceSwapType + ", arParticleType=" + this.arParticleType + ", arParticleList=" + this.arParticleList + ", faceDetectType=" + this.faceDetectType + ", faceExpression=" + this.faceExpression + ", faceImageLayer=" + this.faceImageLayer + ", tipsText='" + this.tipsText + '\'' + ", tipsIcon='" + this.tipsIcon + '\'' + ", faceCropItem=" + this.faceCropItem + ", faceValueDetectType=" + this.faceValueDetectType + ", adIcon='" + this.adIcon + '\'' + ", adLink='" + this.adLink + '\'' + ", adAppLink='" + this.adAppLink + '\'' + ", weiboTag='" + this.weiboTag + '\'' + ", lipsLutPath='" + this.lipsLutPath + '\'' + ", useMesh=" + this.useMesh + ", detectorFlag=" + this.detectorFlag + ", segmentRequired=" + this.segmentRequired + ", segmentStrokeWidth=" + this.segmentStrokeWidth + ", segmentStrokeGap=" + this.segmentStrokeGap + ", segmentStrokeColor=" + Arrays.toString(this.segmentStrokeColor) + ", segmentFeather=" + this.segmentFeather + ", fabbyParts=" + this.fabbyParts + ", categoryFlag=" + this.categoryFlag + ", needFaceInfo=" + this.needFaceInfo + ", fov=" + this.fov + ", gameParams=" + this.gameParams + ", auido2Text=" + this.audio2Text + ", audio3DParams=" + this.audio3DParams + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.VideoMaterial
 * JD-Core Version:    0.7.0.1
 */