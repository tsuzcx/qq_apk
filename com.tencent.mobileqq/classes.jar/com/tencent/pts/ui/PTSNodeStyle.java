package com.tencent.pts.ui;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.utils.PTSDeviceUtil;
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
    float[] arrayOfFloat = new float[4];
    for (;;)
    {
      int i;
      try
      {
        Object localObject = (String)get("border-radius");
        if (localObject != null)
        {
          localObject = ((String)localObject).trim().split("\\s+");
          i = 0;
          if (i < Math.min(localObject.length, 4)) {
            if (Float.valueOf(localObject[i]).floatValue() > 0.0F) {
              arrayOfFloat[i] = PTSDeviceUtil.dp2px(Float.valueOf(localObject[i]).floatValue());
            } else {
              arrayOfFloat[i] = 0.0F;
            }
          }
        }
      }
      catch (Exception localException)
      {
        PTSLog.e(this.TAG, "getBorderRadii, e = " + localException);
      }
      return arrayOfFloat;
      i += 1;
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
  
  public String getFontWeight()
  {
    String str = "normal";
    if (get("font-weight") != null) {
      str = PTSValueConvertUtil.getString(get("font-weight"));
    }
    return str;
  }
  
  public int getHeight()
  {
    return PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_height")));
  }
  
  public int getLeft()
  {
    return PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_left")));
  }
  
  public float getLineHeight()
  {
    float f = 1.6F * getFontSize();
    if (get("line-height") != null) {
      f = PTSValueConvertUtil.getFloat(get("line-height"));
    }
    return f;
  }
  
  public float getLineSpacing(TextPaint paramTextPaint)
  {
    if (TextUtils.equals("bold", getFontWeight())) {
      paramTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }
    float f = PTSNodeTextBase.getLineSpacing(getLineHeight(), getFontSize(), paramTextPaint);
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
        arrayOfInt[i] = PTSDeviceUtil.dp2pxInt(Float.valueOf(arrayOfString[i]).floatValue());
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
    return PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_top")));
  }
  
  public int getWidth()
  {
    return PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_width")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeStyle
 * JD-Core Version:    0.7.0.1
 */