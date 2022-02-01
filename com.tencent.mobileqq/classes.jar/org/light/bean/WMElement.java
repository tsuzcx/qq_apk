package org.light.bean;

import java.util.HashMap;
import org.light.Controller;

public class WMElement
{
  public static final int CHECK_IN_ERR_CODE_DUPLICATE = 11;
  public static final int CHECK_IN_ERR_CODE_SUCCESS = 0;
  public static final String TYPE_CHECK_IN = "CHECK_IN";
  public static final String TYPE_COUNTDOWN = "COUNTDOWN";
  public static final String TYPE_EDITABLE_LOCATION = "EDITABLE_LOCATION";
  public static final String TYPE_PLAIN_TEXT = "PLAIN_TEXT";
  public static final String TYPE_SINCE = "SINCE";
  public Controller controller;
  public final String elementId;
  public final String key;
  public final String materialId;
  public final String type;
  
  public WMElement(String paramString1, String paramString2, String paramString3)
  {
    this.materialId = paramString1;
    this.elementId = paramString2;
    this.type = paramString3;
    this.key = (this.materialId + "_" + this.elementId);
  }
  
  private native String getCustomInnerValue(String paramString1, String paramString2);
  
  private native HashMap<String, String> getItemPresetMap(String paramString1, String paramString2);
  
  private native void resetCheckIn(String paramString);
  
  private void setCustomData(String paramString1, String paramString2)
  {
    setCustomData(paramString1, paramString2, true);
  }
  
  private native void setCustomData(String paramString1, String paramString2, boolean paramBoolean);
  
  public int doCheckIn()
  {
    return doCheckIn(this.key, this.type);
  }
  
  public native int doCheckIn(String paramString1, String paramString2);
  
  public String getInnerValue()
  {
    return getCustomInnerValue(this.key, this.type);
  }
  
  public void resetCheckIn()
  {
    resetCheckIn(this.key);
  }
  
  public void setDate(long paramLong)
  {
    setCustomData(this.key, String.valueOf(paramLong));
  }
  
  public void setLocation(String paramString)
  {
    setCustomData(this.key, paramString, false);
  }
  
  public void setText(String paramString)
  {
    setCustomData(this.key, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.bean.WMElement
 * JD-Core Version:    0.7.0.1
 */