package com.tencent.viola.utils;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.text.TextUtils;
import com.tencent.viola.ui.dom.DomObject;
import java.util.ArrayList;
import java.util.List;

public class GradientParseUtils
{
  private static final String TAG = "GradientParseUtils";
  public static final String TO_BOTTOM = "to bottom";
  public static final String TO_LEFT = "to left";
  public static final String TO_LEFT_BOTTOM = "to left bottom";
  public static final String TO_LEFT_TOP = "to left top";
  public static final String TO_RIGHT = "to right";
  public static final String TO_RIGHT_BOTTOM = "to right bottom";
  public static final String TO_RIGHT_TOP = "to right top";
  public static final String TO_TOP = "to top";
  
  private static double getTanByDeg(int paramInt)
  {
    return Math.tan(Math.toRadians(paramInt));
  }
  
  private static PointF[] make0To90PointF(int paramInt, float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF2.x = ((float)(paramFloat1 / 2.0F + getTanByDeg(paramInt) * paramFloat2 / 2.0D));
    localPointF2.y = 0.0F;
    if (localPointF2.x > paramFloat1)
    {
      localPointF2.x = paramFloat1;
      localPointF2.y = ((float)(paramFloat2 / 2.0F - paramFloat1 / 2.0F / getTanByDeg(paramInt)));
    }
    float f = (float)(getTanByDeg(paramInt) * paramFloat2 / 2.0D);
    localPointF1.x = (paramFloat1 / 2.0F - f);
    localPointF1.y = paramFloat2;
    if (localPointF1.x < 0.0F)
    {
      localPointF1.x = 0.0F;
      localPointF1.y = ((float)(paramFloat2 / 2.0F + paramFloat1 / 2.0F / getTanByDeg(paramInt)));
    }
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] make180PointF(float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF1.x = (paramFloat1 / 2.0F);
    localPointF1.y = 0.0F;
    localPointF2.x = (paramFloat1 / 2.0F);
    localPointF2.y = paramFloat2;
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] make180To270PointF(int paramInt, float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = make0To90PointF(paramInt - 180, paramFloat1, paramFloat2);
    return new PointF[] { arrayOfPointF[1], arrayOfPointF[0] };
  }
  
  private static PointF[] make270PointF(float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = make90PointF(paramFloat1, paramFloat2);
    return new PointF[] { arrayOfPointF[1], arrayOfPointF[0] };
  }
  
  private static PointF[] make270To360PointF(int paramInt, float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = make90To180Point(paramInt - 180, paramFloat1, paramFloat2);
    return new PointF[] { arrayOfPointF[1], arrayOfPointF[0] };
  }
  
  private static PointF[] make90PointF(float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF1.x = 0.0F;
    localPointF1.y = (paramFloat2 / 2.0F);
    localPointF2.x = paramFloat1;
    localPointF2.y = (paramFloat2 / 2.0F);
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] make90To180Point(int paramInt, float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF2.y = ((float)(paramFloat2 / 2.0F + getTanByDeg(paramInt - 90) * paramFloat1 / 2.0D));
    localPointF2.x = paramFloat1;
    if (localPointF2.y > paramFloat2)
    {
      localPointF2.y = paramFloat2;
      localPointF2.x = ((float)(paramFloat1 / 2.0F + paramFloat2 / 2.0F / getTanByDeg(paramInt - 90)));
    }
    localPointF1.y = (paramFloat2 / 2.0F - (float)(paramFloat1 / 2.0F * Math.tan(Math.toRadians(paramInt - 90))));
    localPointF1.x = 0.0F;
    if (localPointF1.y < 0.0F)
    {
      localPointF1.y = 0.0F;
      paramFloat2 = (float)(paramFloat2 / 2.0F / getTanByDeg(paramInt - 90));
      localPointF1.x = (paramFloat1 / 2.0F - paramFloat2);
    }
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] makeNe0ToNe90(int paramInt, float paramFloat1, float paramFloat2)
  {
    return make270To360PointF(paramInt + 360, paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe180PointF(float paramFloat1, float paramFloat2)
  {
    return make180PointF(paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe180ToNe270(int paramInt, float paramFloat1, float paramFloat2)
  {
    return make90To180Point(paramInt + 360, paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe270PointF(float paramFloat1, float paramFloat2)
  {
    return make90PointF(paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe270ToNe360(int paramInt, float paramFloat1, float paramFloat2)
  {
    return make0To90PointF(paramInt + 360, paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe90PointF(float paramFloat1, float paramFloat2)
  {
    return make270PointF(paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNe90ToNe180(int paramInt, float paramFloat1, float paramFloat2)
  {
    return make180To270PointF(paramInt + 360, paramFloat1, paramFloat2);
  }
  
  private static PointF[] makeNePointF(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == -90) {
      return makeNe90PointF(paramFloat1, paramFloat2);
    }
    if (paramInt == -180) {
      return makeNe180PointF(paramFloat1, paramFloat2);
    }
    if (paramInt == -270) {
      return makeNe270PointF(paramFloat1, paramFloat2);
    }
    if (-90 < paramInt) {
      return makeNe0ToNe90(paramInt, paramFloat1, paramFloat2);
    }
    if (-180 < paramInt) {
      return makeNe90ToNe180(paramInt, paramFloat1, paramFloat2);
    }
    if (-270 < paramInt) {
      return makeNe180ToNe270(paramInt, paramFloat1, paramFloat2);
    }
    return makeNe270ToNe360(paramInt, paramFloat1, paramFloat2);
  }
  
  private static PointF[] makePoPointF(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 90) {
      return make90PointF(paramFloat1, paramFloat2);
    }
    if (paramInt == 180) {
      return make180PointF(paramFloat1, paramFloat2);
    }
    if (paramInt == 270) {
      return make270PointF(paramFloat1, paramFloat2);
    }
    if (paramInt < 90) {
      return make0To90PointF(paramInt, paramFloat1, paramFloat2);
    }
    if (paramInt < 180) {
      return make90To180Point(paramInt, paramFloat1, paramFloat2);
    }
    if (paramInt < 270) {
      return make180To270PointF(paramInt, paramFloat1, paramFloat2);
    }
    return make270To360PointF(paramInt, paramFloat1, paramFloat2);
  }
  
  public static int[] parseColor(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt < paramArrayOfString.length)
    {
      String str2 = paramArrayOfString[paramInt].trim();
      int i;
      String str1;
      if (str2.contains("rgba"))
      {
        str2 = pickRgbOra(paramArrayOfString, paramInt, 4);
        i = paramInt + 3;
        str1 = str2;
        if (str2 == null) {
          return null;
        }
      }
      else
      {
        str1 = str2;
        i = paramInt;
        if (str2.contains("rgb"))
        {
          str2 = pickRgbOra(paramArrayOfString, paramInt, 3);
          i = paramInt + 2;
          str1 = str2;
          if (str2 == null) {
            return null;
          }
        }
      }
      localArrayList.add(str1);
      paramInt = i + 1;
    }
    paramArrayOfString = new int[localArrayList.size()];
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      paramArrayOfString[paramInt] = ColorParseUtils.parseColor((String)localArrayList.get(paramInt));
      paramInt += 1;
    }
    return paramArrayOfString;
  }
  
  private static PointF[] parseDegrees(String paramString, float paramFloat1, float paramFloat2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("deg"))) {
      return null;
    }
    int i = Integer.parseInt(paramString.substring(0, paramString.indexOf("deg"))) % 360;
    if (i >= 0) {
      return makePoPointF(i, paramFloat1, paramFloat2);
    }
    return makeNePointF(i, paramFloat1, paramFloat2);
  }
  
  private static PointF[] parseFromPosition(String paramString, float paramFloat1, float paramFloat2)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString.equals("to top"))
        {
          i = 0;
          continue;
          if (paramString.equals("to bottom"))
          {
            i = 1;
            continue;
            if (paramString.equals("to left"))
            {
              i = 2;
              continue;
              if (paramString.equals("to right"))
              {
                i = 3;
                continue;
                if (paramString.equals("to left top"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("to left bottom"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("to right top"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("to right bottom")) {
                        i = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return make0To90PointF(0, paramFloat1, paramFloat2);
    return make180PointF(paramFloat1, paramFloat2);
    return make270PointF(paramFloat1, paramFloat2);
    return make90PointF(paramFloat1, paramFloat2);
    return make270To360PointF(315, paramFloat1, paramFloat2);
    return make180To270PointF(225, paramFloat1, paramFloat2);
    return make0To90PointF(45, paramFloat1, paramFloat2);
    return make90To180Point(135, paramFloat1, paramFloat2);
  }
  
  public static LinearGradient parseLinearGradient(Object paramObject, DomObject paramDomObject)
  {
    for (;;)
    {
      float f1;
      float f2;
      try
      {
        paramObject = ViolaUtils.getString(paramObject, null);
        if (TextUtils.isEmpty(paramObject)) {
          return null;
        }
        if (!paramObject.contains("linear-gradient(")) {
          return null;
        }
        String[] arrayOfString = paramObject.substring(paramObject.indexOf('(') + 1, paramObject.lastIndexOf(')')).split(",");
        if (arrayOfString.length <= 1) {
          return null;
        }
        paramObject = arrayOfString[0];
        f1 = paramDomObject.getLayoutWidth();
        f2 = paramDomObject.getLayoutHeight();
        if (paramObject.contains("to"))
        {
          paramObject = parseFromPosition(paramObject, f1, f2);
          paramDomObject = parseColor(arrayOfString, 1);
          if ((paramObject == null) || (paramDomObject == null) || (paramDomObject.length < 1)) {
            break;
          }
          ViolaLogUtils.d("GradientParseUtils", "width: " + f1 + ", height: " + f2);
          ViolaLogUtils.d("GradientParseUtils", "start: " + paramObject[0].toString() + ", end: " + paramObject[1].toString());
          paramObject = new LinearGradient(paramObject[0].x, paramObject[0].y, paramObject[1].x, paramObject[1].y, paramDomObject, null, Shader.TileMode.CLAMP);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e("GradientParseUtils", paramObject.getMessage());
        return null;
      }
      if (paramObject.contains("deg")) {
        paramObject = parseDegrees(paramObject, f1, f2);
      } else {
        paramObject = parseFromPosition("to bottom", f1, f2);
      }
    }
    return null;
  }
  
  private static String pickRgbOra(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < paramInt1 + paramInt2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
    {
      if (i != paramInt1) {
        localStringBuilder.append(',').append(paramArrayOfString[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfString[i]);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.GradientParseUtils
 * JD-Core Version:    0.7.0.1
 */