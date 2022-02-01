package com.tencent.ttpic.openapi.model;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FaceStyleItem
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public boolean alwaysTriggered;
  public String cartoonEnlightLut;
  public FaceStyleItem.CartoonFaceLine cartoonFaceLine;
  public String cartoonLut;
  public FaceStyleItem.ChangeGenderParams changeGenderParams;
  public int countTriggerType;
  public String crazyFacePath;
  public String cropBorderColorRGBA;
  public String dataPath;
  public String externalTriggerWords;
  public float[] faceCropExpandInset = { 0.0F, 0.0F, 0.0F, 0.0F };
  public int faceCropType;
  public float faceExpandFactor;
  public int faceFilterType;
  public int[] featureMaskSize;
  public float horizontalFaceRadiusPercent;
  public int horizontalMinRadius;
  public String id;
  public int[] imageSize = { 320, 320 };
  public FaceStyleItem.Process initProcess;
  public String libraryPath;
  public String libraryText = "";
  public int limitDeviceLevel;
  public Map<String, String> lutPaths = new HashMap();
  public Map<String, String> materialPaths = new HashMap();
  public FaceStyleItem.ModelConfig modelConfig;
  public String modelName;
  public int playCount;
  public FaceStyleItem.Process postProcess;
  public FaceStyleItem.Render postRender;
  public FaceStyleItem.Process preProcess;
  public boolean returnPostProcessTexture;
  public List<StickerItem> stickerItemList;
  public int styleChangeType;
  public List<String> textureMaterials;
  public String transformMask;
  public ArrayList<String> triggerState;
  private String triggerType;
  public float verticalFaceRadiusPercent;
  public int verticalMinRadius;
  
  private boolean isBlobValid(List<String> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (TextUtils.isEmpty((String)paramList.next())) {
        return false;
      }
    }
    return true;
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
  
  public boolean isValid()
  {
    if ((this.styleChangeType != FaceStyleItem.StyleChangeType.GENDER_SWITCH.value) && ((!isBlobValid(this.preProcess.blobNames)) || (!isBlobValid(this.postProcess.blobNames))))
    {
      LogUtils.w("TNN", "FaceStyleItem config is invalid.");
      return false;
    }
    return true;
  }
  
  public void setTriggerType(String paramString)
  {
    this.triggerType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceStyleItem
 * JD-Core Version:    0.7.0.1
 */