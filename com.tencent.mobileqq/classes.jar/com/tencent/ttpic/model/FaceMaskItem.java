package com.tencent.ttpic.model;

import com.google.gson.JsonObject;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;

public class FaceMaskItem
{
  public static final String FACE_MASKS_LIST = "faceMaskList";
  public String faceMaskID;
  public String faceMaskImgPath;
  public double faceMaskSize;
  public int faceMaskType = 0;
  public double featherStrength;
  public boolean isValid;
  
  public FaceMaskItem(JsonObject paramJsonObject, String paramString)
  {
    double d1 = 1.0D;
    this.faceMaskSize = 1.0D;
    double d2 = 0.0D;
    this.featherStrength = 0.0D;
    this.isValid = false;
    if (paramJsonObject == null) {
      return;
    }
    this.faceMaskID = GsonUtils.optString(paramJsonObject, FaceMaskItem.FaceMaskItemField.MASK_ID.value);
    this.faceMaskType = GsonUtils.optInt(paramJsonObject, FaceMaskItem.FaceMaskItemField.FACE_MASK_TYPE.value);
    this.faceMaskSize = GsonUtils.optDouble(paramJsonObject, FaceMaskItem.FaceMaskItemField.FACE_MASK_SIZE.value);
    if (!Double.isNaN(this.faceMaskSize))
    {
      double d3 = this.faceMaskSize;
      if (d3 > 0.1D) {
        d1 = d3;
      }
    }
    this.faceMaskSize = d1;
    this.featherStrength = GsonUtils.optDouble(paramJsonObject, FaceMaskItem.FaceMaskItemField.FEATHER_STRENGTH.value);
    if (Double.isNaN(this.featherStrength)) {
      d1 = d2;
    } else {
      d1 = this.featherStrength;
    }
    this.featherStrength = d1;
    String str = GsonUtils.optString(paramJsonObject, FaceMaskItem.FaceMaskItemField.FACE_MASK_PATH.value);
    paramJsonObject = null;
    if ((str != null) && (!str.trim().isEmpty()))
    {
      paramJsonObject = new StringBuilder();
      paramJsonObject.append(paramString);
      paramJsonObject.append(File.separator);
      paramJsonObject.append(str.trim());
      paramJsonObject.append(File.separator);
      paramJsonObject.append(str.trim());
      paramJsonObject.append("_");
      paramJsonObject = paramJsonObject.toString();
    }
    this.faceMaskImgPath = paramJsonObject;
    this.isValid = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceMaskItem
 * JD-Core Version:    0.7.0.1
 */