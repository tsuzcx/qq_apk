package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class AEWatermarkText
{
  private TextWMElement mTextWMElement;
  
  public static void addDict(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
  }
  
  @Deprecated
  private void clearTextWM()
  {
    if (this.mTextWMElement != null) {
      this.mTextWMElement.clear();
    }
  }
  
  @Deprecated
  private Bitmap getBitmap()
  {
    if (this.mTextWMElement != null) {
      return this.mTextWMElement.getBitmap();
    }
    return null;
  }
  
  @Deprecated
  private void initTextWM()
  {
    this.mTextWMElement = new TextWMElement();
    this.mTextWMElement.init();
  }
  
  public static void setAltitude(String paramString)
  {
    LogicDataManager.getInstance().setAltitude(paramString);
  }
  
  @Deprecated
  private static void setLocation(String paramString)
  {
    LogicDataManager.getInstance().setLocation(paramString);
  }
  
  public static void setTemperature(String paramString)
  {
    LogicDataManager.getInstance().setTemperature(paramString);
  }
  
  public static void setWeather(int paramInt)
  {
    LogicDataManager.getInstance().setWeather(paramInt);
  }
  
  @Deprecated
  private static void setWeatherType(int paramInt)
  {
    LogicDataManager.getInstance().setWeatherType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEWatermarkText
 * JD-Core Version:    0.7.0.1
 */