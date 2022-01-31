package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceItem
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public boolean alwaysTriggered = true;
  public float blendAlpha;
  public int blendIris;
  public int blendMode;
  public CharmRange charmRange;
  public int countTriggerType;
  public boolean disable3DCorrect = false;
  public String faceExchangeImage;
  public boolean faceExchangeImageDisableOpacity = false;
  public boolean faceExchangeImageFullFace = false;
  public List<Float> facePoints;
  public int featureStatType;
  public StickerItem.ValueRange featureStatValueRange;
  public FaceOffUtil.FEATURE_TYPE featureType;
  public int frameDuration;
  public int frameType;
  public int frames;
  public int genderType = 0;
  public int grayScale;
  public int height;
  public String id;
  public String irisImage;
  public boolean is3DCos = false;
  public int personID;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  private String triggerType = String.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value);
  public int width;
  
  public FaceItem() {}
  
  public FaceItem(String paramString, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this(paramString, false, false, paramFloat, paramInt1, paramInt2, paramList);
  }
  
  public FaceItem(String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this(paramString, paramBoolean, false, paramFloat, paramInt1, paramInt2, paramList);
  }
  
  public FaceItem(String paramString, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this.faceExchangeImage = paramString;
    this.faceExchangeImageFullFace = paramBoolean1;
    this.faceExchangeImageDisableOpacity = paramBoolean2;
    this.blendAlpha = paramFloat;
    this.grayScale = paramInt1;
    this.featureType = FaceOffUtil.getFeatureType(paramInt2);
    this.facePoints = paramList;
    this.personID = -1;
    this.genderType = 0;
  }
  
  public int getTriggerTypeInt()
  {
    try
    {
      int i = Integer.parseInt(this.triggerType);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
  
  public String getTriggerTypeString()
  {
    return this.triggerType;
  }
  
  public void setTriggerType(String paramString)
  {
    this.triggerType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceItem
 * JD-Core Version:    0.7.0.1
 */