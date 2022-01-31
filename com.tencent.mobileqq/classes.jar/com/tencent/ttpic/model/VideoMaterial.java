package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoMaterial
{
  private String adAppLink;
  private String adIcon;
  private String adLink;
  private List<String> arParticleList;
  private int arParticleType;
  private double blendAlpha;
  private int blendMode;
  private String dataPath;
  private int detectorFlag;
  private List<DistortionItem> distortionItemList;
  private List<FabbyMvPart> fabbyMvParts = new ArrayList();
  private FaceCropItem faceCropItem;
  private int faceDetectType;
  private String faceExchangeImage;
  private FaceExpression faceExpression;
  private FaceImageLayer faceImageLayer;
  private List<FaceMeshItem> faceMeshItemList;
  private List<FaceMoveItem> faceMoveItemList;
  private int[] faceMoveTriangles;
  private List<FaceItem> faceOffItemList;
  private List<Float> facePoints;
  private int faceSwapType;
  private int faceValueDetectType;
  private int faceoffType;
  private int featureType;
  private String filterId;
  private int grayScale;
  private boolean hasAudio;
  private List<StickerItem> headCropItemList;
  private String id;
  private String imageFacePointsFileName;
  private List<StickerItem> itemList;
  private boolean loadImageFromCache = true;
  private int maxFaceCount;
  private int minAppVersion;
  private int orderMode;
  private List<String> resourceList;
  private int segmentFeather;
  private boolean segmentRequired = false;
  private float[] segmentStrokeColor;
  private double segmentStrokeGap;
  private double segmentStrokeWidth;
  private int shaderType;
  private boolean supportLandscape;
  private String tipsText;
  private int triggerType;
  private boolean useMesh = false;
  private VideoFilterEffect videoFilterEffect;
  private String weiboTag;
  
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
  
  public List<String> getArParticleList()
  {
    return this.arParticleList;
  }
  
  public int getArParticleType()
  {
    return this.arParticleType;
  }
  
  public double getBlendAlpha()
  {
    return this.blendAlpha;
  }
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public int getDetectorFlag()
  {
    return this.detectorFlag;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public List<FabbyMvPart> getFabbyMvParts()
  {
    return this.fabbyMvParts;
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
  
  public FaceImageLayer getFaceImageLayer()
  {
    return this.faceImageLayer;
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
  
  public String getFilterId()
  {
    return this.filterId;
  }
  
  public int getGrayScale()
  {
    return this.grayScale;
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
  
  public List<StickerItem> getItemList()
  {
    return this.itemList;
  }
  
  public int getMaxFaceCount()
  {
    return this.maxFaceCount;
  }
  
  public int getMinAppVersion()
  {
    return this.minAppVersion;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public List<String> getResourceList()
  {
    return this.resourceList;
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
  
  public double getSegmentStrokeWidth()
  {
    return this.segmentStrokeWidth;
  }
  
  public int getShaderType()
  {
    return this.shaderType;
  }
  
  public String getTipsText()
  {
    return this.tipsText;
  }
  
  public int getTriggerType()
  {
    return this.triggerType;
  }
  
  public VideoFilterEffect getVideoFilterEffect()
  {
    return this.videoFilterEffect;
  }
  
  public String getWeiboTag()
  {
    return this.weiboTag;
  }
  
  public boolean hasAd()
  {
    return (!TextUtils.isEmpty(this.adIcon)) || (!TextUtils.isEmpty(this.adLink)) || (!TextUtils.isEmpty(this.adAppLink));
  }
  
  public boolean isHasAudio()
  {
    return this.hasAudio;
  }
  
  public boolean isLoadImageFromCache()
  {
    return this.loadImageFromCache;
  }
  
  public boolean isSegmentRequired()
  {
    return this.segmentRequired;
  }
  
  public boolean isSupportLandscape()
  {
    return this.supportLandscape;
  }
  
  public boolean isUseMesh()
  {
    return this.useMesh;
  }
  
  public boolean needFaceInfo()
  {
    if ((getShaderType() != VideoMaterialUtil.SHADER_TYPE.NORMAL.value) || (this.itemList == null)) {
      return true;
    }
    Iterator localIterator = this.itemList.iterator();
    while (localIterator.hasNext()) {
      if (((StickerItem)localIterator.next()).triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) {
        return true;
      }
    }
    return false;
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
  
  public void setArParticleList(List<String> paramList)
  {
    this.arParticleList = paramList;
  }
  
  public void setArParticleType(int paramInt)
  {
    this.arParticleType = paramInt;
  }
  
  public void setBlendAlpha(double paramDouble)
  {
    this.blendAlpha = paramDouble;
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDetectorFlag(int paramInt)
  {
    this.detectorFlag = paramInt;
  }
  
  public void setDistortionItemList(List<DistortionItem> paramList)
  {
    this.distortionItemList = paramList;
  }
  
  public void setFabbyMvParts(List<FabbyMvPart> paramList)
  {
    this.fabbyMvParts = paramList;
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
  
  public void setFaceExpression(FaceExpression paramFaceExpression)
  {
    this.faceExpression = paramFaceExpression;
  }
  
  public void setFaceImageLayer(FaceImageLayer paramFaceImageLayer)
  {
    this.faceImageLayer = paramFaceImageLayer;
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
  
  public void setFilterId(String paramString)
  {
    this.filterId = paramString;
  }
  
  public void setGrayScale(int paramInt)
  {
    this.grayScale = paramInt;
  }
  
  public void setHasAudio(boolean paramBoolean)
  {
    this.hasAudio = paramBoolean;
  }
  
  public void setHeadCropItemList(List<StickerItem> paramList)
  {
    this.headCropItemList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImageFacePointsFileName(String paramString)
  {
    this.imageFacePointsFileName = paramString;
  }
  
  public void setItemList(List<StickerItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setLoadImageFromCache(boolean paramBoolean)
  {
    this.loadImageFromCache = paramBoolean;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    this.maxFaceCount = Math.max(1, paramInt);
  }
  
  public void setMinAppVersion(int paramInt)
  {
    this.minAppVersion = paramInt;
  }
  
  public void setOrderMode(int paramInt)
  {
    this.orderMode = paramInt;
  }
  
  public void setResourceList(List<String> paramList)
  {
    this.resourceList = paramList;
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
  
  public void setSegmentStrokeWidth(double paramDouble)
  {
    this.segmentStrokeWidth = paramDouble;
  }
  
  public void setShaderType(int paramInt)
  {
    this.shaderType = paramInt;
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    this.supportLandscape = paramBoolean;
  }
  
  public void setTipsText(String paramString)
  {
    this.tipsText = paramString;
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
  
  public void setWeiboTag(String paramString)
  {
    this.weiboTag = paramString;
  }
  
  public static class FaceImageLayer
  {
    public double blendAlpha;
    public double distortionAlpha;
    public List<DistortionItem> distortionList;
    public List<Double> faceMaskFacePoint;
    public String faceMaskImagePath;
    public List<Integer> faceTriangle;
    public FaceOffUtil.FEATURE_TYPE featureType = FaceOffUtil.FEATURE_TYPE.CRAZY_FACE;
    public double height;
    public List<Double> imageFaceColor;
    public List<Double> imageFacePoint;
    public String imagePath;
    public int type;
    public double width;
    public double x;
    public double y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoMaterial
 * JD-Core Version:    0.7.0.1
 */