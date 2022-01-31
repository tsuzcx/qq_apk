package com.tencent.ttpic.model;

import com.google.gson.JsonObject;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;

public class FaceMaskItem
{
  public static final String FACE_MASKS_LIST = "faceMaskList";
  public String faceMaskID;
  public String faceMaskImgPath;
  public double faceMaskSize = 1.0D;
  public int faceMaskType = 0;
  public double featherStrength = 0.0D;
  public boolean isValid = false;
  
  public FaceMaskItem(JsonObject paramJsonObject, String paramString)
  {
    if (paramJsonObject == null) {
      return;
    }
    this.faceMaskID = GsonUtils.optString(paramJsonObject, FaceMaskItem.FACE_MASK_ITEM_FIELD.MASK_ID.value);
    this.faceMaskType = GsonUtils.optInt(paramJsonObject, FaceMaskItem.FACE_MASK_ITEM_FIELD.FACE_MASK_TYPE.value);
    this.faceMaskSize = GsonUtils.optDouble(paramJsonObject, FaceMaskItem.FACE_MASK_ITEM_FIELD.FACE_MASK_SIZE.value);
    if (Double.isNaN(this.faceMaskSize))
    {
      this.faceMaskSize = d;
      this.featherStrength = GsonUtils.optDouble(paramJsonObject, FaceMaskItem.FACE_MASK_ITEM_FIELD.FEATHER_STRENGTH.value);
      if (!Double.isNaN(this.featherStrength)) {
        break label166;
      }
      d = 0.0D;
      label114:
      this.featherStrength = d;
      paramJsonObject = GsonUtils.optString(paramJsonObject, FaceMaskItem.FACE_MASK_ITEM_FIELD.FACE_MASK_PATH.value);
      if (paramJsonObject != null) {
        break label174;
      }
      paramJsonObject = null;
    }
    for (;;)
    {
      this.faceMaskImgPath = paramJsonObject;
      this.isValid = true;
      return;
      if (this.faceMaskSize <= 0.1D) {
        break;
      }
      d = this.faceMaskSize;
      break;
      label166:
      d = this.featherStrength;
      break label114;
      label174:
      if (paramJsonObject.trim().isEmpty()) {
        paramJsonObject = null;
      } else {
        paramJsonObject = paramString + File.separator + paramJsonObject.trim() + File.separator + paramJsonObject.trim() + "_";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceMaskItem
 * JD-Core Version:    0.7.0.1
 */