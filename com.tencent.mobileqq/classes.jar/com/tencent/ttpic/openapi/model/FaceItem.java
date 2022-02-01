package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.ArrayList;
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
  public float cos3DAmbientStrength = 1.0F;
  public float cos3DDiffuseStrength = 1.0F;
  public int countTriggerType;
  public boolean disable3DCorrect = false;
  public String externalTriggerWords;
  public String faceExchangeImage;
  public boolean faceExchangeImageDisableFaceCrop = false;
  public List<Float> facePoints;
  public int featureStatType;
  public StickerItem.ValueRange featureStatValueRange;
  public FaceOffUtil.FeatureType featureType;
  public float filterSkin = 0.0F;
  public int frameDuration;
  public int frameType;
  public int frames;
  public int genderType = 0;
  public int grayScale;
  public int height;
  public String id;
  public String irisImage;
  public int is3DCos;
  public float[] lipsRGBA;
  public String lipsStyleMask;
  public int personID;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  public ArrayList<String> triggerState;
  private String triggerType = String.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value);
  public int width;
  
  public FaceItem() {}
  
  public FaceItem(String paramString, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this(paramString, false, paramFloat, paramInt1, paramInt2, paramList);
  }
  
  public FaceItem(String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this.faceExchangeImage = paramString;
    this.faceExchangeImageDisableFaceCrop = paramBoolean;
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
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceItem
 * JD-Core Version:    0.7.0.1
 */