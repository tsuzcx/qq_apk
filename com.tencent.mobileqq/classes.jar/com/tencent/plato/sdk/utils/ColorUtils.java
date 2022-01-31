package com.tencent.plato.sdk.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.plato.core.utils.AssertUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class ColorUtils
{
  private static final int COLOR_RANGE = 255;
  private static final int HEX = 16;
  private static final String RGB = "rgb";
  private static final String RGBA = "rgba";
  private static final String RGBADELIM = "rgba()";
  private static final String RGBDELIM = "rgb()";
  private static final HashMap<String, Integer> sColorNameMap = new HashMap();
  
  static
  {
    sColorNameMap.put("black", Integer.valueOf(-16777216));
    sColorNameMap.put("darkgray", Integer.valueOf(-12303292));
    sColorNameMap.put("gray", Integer.valueOf(-7829368));
    sColorNameMap.put("lightgray", Integer.valueOf(-3355444));
    sColorNameMap.put("white", Integer.valueOf(-1));
    sColorNameMap.put("red", Integer.valueOf(-65536));
    sColorNameMap.put("green", Integer.valueOf(-16711936));
    sColorNameMap.put("blue", Integer.valueOf(-16776961));
    sColorNameMap.put("yellow", Integer.valueOf(-256));
    sColorNameMap.put("cyan", Integer.valueOf(-16711681));
    sColorNameMap.put("magenta", Integer.valueOf(-65281));
    sColorNameMap.put("aqua", Integer.valueOf(-16711681));
    sColorNameMap.put("fuchsia", Integer.valueOf(-65281));
    sColorNameMap.put("darkgrey", Integer.valueOf(-12303292));
    sColorNameMap.put("grey", Integer.valueOf(-7829368));
    sColorNameMap.put("lightgrey", Integer.valueOf(-3355444));
    sColorNameMap.put("lime", Integer.valueOf(-16711936));
    sColorNameMap.put("maroon", Integer.valueOf(-8388608));
    sColorNameMap.put("navy", Integer.valueOf(-16777088));
    sColorNameMap.put("olive", Integer.valueOf(-8355840));
    sColorNameMap.put("purple", Integer.valueOf(-8388480));
    sColorNameMap.put("silver", Integer.valueOf(-4144960));
    sColorNameMap.put("teal", Integer.valueOf(-16744320));
  }
  
  public static int parseColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str;
    boolean bool;
    if (paramString.startsWith("rgba"))
    {
      localObject = new StringTokenizer(paramString, "rgba()");
      do
      {
        if (!((StringTokenizer)localObject).hasMoreElements()) {
          break;
        }
        str = ((StringTokenizer)localObject).nextToken();
      } while (str == null);
      paramString = str.split(",");
      if (paramString.length == 4) {}
      for (bool = true;; bool = false)
      {
        AssertUtil.Assert(bool, "color error");
        return Color.argb((int)(Float.valueOf(paramString[3].trim()).floatValue() * 255.0F), Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
      }
    }
    if (paramString.startsWith("rgb"))
    {
      localObject = new StringTokenizer(paramString, "rgb()");
      do
      {
        if (!((StringTokenizer)localObject).hasMoreElements()) {
          break;
        }
        str = ((StringTokenizer)localObject).nextToken();
      } while (str == null);
      paramString = str.split(",");
      if (paramString.length == 3) {}
      for (bool = true;; bool = false)
      {
        AssertUtil.Assert(bool, "color error");
        return Color.rgb(Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
      }
    }
    if (paramString.charAt(0) == '#')
    {
      long l = Long.parseLong(paramString.substring(1), 16);
      if (paramString.length() == 4)
      {
        int k = Integer.parseInt(paramString.substring(1, 4), 16);
        int i = k & 0xF00;
        int j = k & 0xF0;
        k &= 0xF;
        l = Color.rgb(i >> 4 | i >> 8, j >> 4 | j, k << 4 | k);
      }
      for (;;)
      {
        return (int)l;
        if (paramString.length() == 7)
        {
          l |= 0xFF000000;
        }
        else
        {
          if (paramString.length() != 9) {
            break;
          }
          l = (0xFF & l) << 24 | (0xFFFFFF00 & l) >> 8;
        }
      }
      throw new IllegalArgumentException("Unknown color");
    }
    Object localObject = (Integer)sColorNameMap.get(paramString.toLowerCase(Locale.ROOT));
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    throw new IllegalArgumentException("Unknown color : " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.ColorUtils
 * JD-Core Version:    0.7.0.1
 */