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
  private Integer backgroundColor;
  private float[] borderRadii;
  private float borderWidth;
  private float fontSize;
  private int height;
  private int left;
  private float lineHeight;
  private int[] padding;
  private int top;
  private int width;
  
  public PTSNodeStyle()
  {
    init();
  }
  
  public PTSNodeStyle(Map<String, Object> paramMap)
  {
    super(paramMap);
    init();
  }
  
  public PTSNodeStyle(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    init();
  }
  
  private void init()
  {
    this.left = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_left")));
    this.top = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_top")));
    this.width = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_width")));
    this.height = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get("calculated_height")));
    this.borderWidth = PTSValueConvertUtil.getFloat(get("border-width"));
    this.fontSize = 16.0F;
    if (get("font-size") != null) {
      this.fontSize = PTSValueConvertUtil.getFloat(get("font-size"));
    }
    this.lineHeight = (getFontSize() * 1.6F);
    if (get("line-height") != null) {
      this.lineHeight = PTSValueConvertUtil.getFloat(get("line-height"));
    }
    if (get("background-color") != null) {
      this.backgroundColor = Integer.valueOf(PTSValueConvertUtil.getColor(get("background-color")));
    }
    initPadding();
    initBorderRadii();
  }
  
  private void initBorderRadii()
  {
    this.borderRadii = new float[4];
    try
    {
      Object localObject = (String)get("border-radius");
      if (localObject != null)
      {
        localObject = ((String)localObject).trim().split("\\s+");
        int i = 0;
        while (i < Math.min(localObject.length, 4))
        {
          if (Float.valueOf(localObject[i]).floatValue() > 0.0F) {
            this.borderRadii[i] = PTSDeviceUtil.dp2px(Float.valueOf(localObject[i]).floatValue());
          } else {
            this.borderRadii[i] = 0.0F;
          }
          i += 1;
        }
      }
      String str;
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBorderRadii, e = ");
      localStringBuilder.append(localException);
      PTSLog.e(str, localStringBuilder.toString());
    }
  }
  
  private void initLineSpacing() {}
  
  private void initPadding()
  {
    this.padding = new int[4];
    try
    {
      String[] arrayOfString = ((String)get("padding")).trim().split("\\s+");
      int i = 0;
      while (i < Math.min(arrayOfString.length, 4))
      {
        this.padding[i] = PTSDeviceUtil.dp2pxInt(Float.valueOf(arrayOfString[i]).floatValue());
        i += 1;
      }
      String str;
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPadding, e = ");
      localStringBuilder.append(localException);
      PTSLog.e(str, localStringBuilder.toString());
    }
  }
  
  public Integer getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public float[] getBorderRadii()
  {
    return this.borderRadii;
  }
  
  public float getBorderWidth()
  {
    return this.borderWidth;
  }
  
  public float getFontSize()
  {
    return this.fontSize;
  }
  
  public String getFontWeight()
  {
    if (get("font-weight") != null) {
      return PTSValueConvertUtil.getString(get("font-weight"));
    }
    return "normal";
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLeft()
  {
    return this.left;
  }
  
  public float getLineHeight()
  {
    return this.lineHeight;
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
    return this.padding;
  }
  
  public int getTop()
  {
    return this.top;
  }
  
  public int getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeStyle
 * JD-Core Version:    0.7.0.1
 */