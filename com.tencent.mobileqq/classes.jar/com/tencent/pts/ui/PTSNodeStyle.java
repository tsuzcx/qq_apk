package com.tencent.pts.ui;

import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSStrToObjMap;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.Map;
import org.json.JSONObject;

public class PTSNodeStyle
  extends PTSStrToObjMap
{
  public PTSNodeStyle() {}
  
  public PTSNodeStyle(Map<String, Object> paramMap)
  {
    super(paramMap);
  }
  
  public PTSNodeStyle(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public Integer getBackgroundColor()
  {
    if (get("background-color") != null) {
      return Integer.valueOf(PTSValueConvertUtil.getColor(get("background-color")));
    }
    return null;
  }
  
  public float[] getBorderRadii()
  {
    arrayOfFloat = new float[4];
    try
    {
      Object localObject = (String)get("border-radius");
      if (localObject != null)
      {
        localObject = ((String)localObject).trim().split("\\s+");
        int i = 0;
        while (i < Math.min(localObject.length, 4))
        {
          arrayOfFloat[i] = PTSValueConvertUtil.dp2px(Float.valueOf(localObject[i]).floatValue());
          i += 1;
        }
      }
      return arrayOfFloat;
    }
    catch (Exception localException)
    {
      PTSLog.e(this.TAG, "getBorderRadii, e = " + localException);
    }
  }
  
  public float getFontSize()
  {
    float f = 16.0F;
    if (get("font-size") != null) {
      f = PTSValueConvertUtil.getFloat(get("font-size"));
    }
    return f;
  }
  
  public int getHeight()
  {
    return (int)PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(get("calculated_height")));
  }
  
  public int getLeft()
  {
    return (int)PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(get("calculated_left")));
  }
  
  public float getLineHeight()
  {
    float f = 1.6F * getFontSize();
    if (get("line-height") != null) {
      f = PTSValueConvertUtil.getFloat(get("line-height"));
    }
    return f;
  }
  
  public float getLineSpacing()
  {
    float f = getLineHeight() - getFontSize();
    if (f > 0.0F) {
      return f;
    }
    return 0.0F;
  }
  
  public int[] getPadding()
  {
    arrayOfInt = new int[4];
    try
    {
      String[] arrayOfString = ((String)get("padding")).trim().split("\\s+");
      int i = 0;
      while (i < Math.min(arrayOfString.length, 4))
      {
        arrayOfInt[i] = ((int)PTSValueConvertUtil.dp2px(Float.valueOf(arrayOfString[i]).floatValue()));
        i += 1;
      }
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      PTSLog.e(this.TAG, "getPadding, e = " + localException);
    }
  }
  
  public int getTop()
  {
    return (int)PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(get("calculated_top")));
  }
  
  public int getWidth()
  {
    return (int)PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(get("calculated_width")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeStyle
 * JD-Core Version:    0.7.0.1
 */