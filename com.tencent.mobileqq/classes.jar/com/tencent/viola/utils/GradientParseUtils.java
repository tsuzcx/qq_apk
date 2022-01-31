package com.tencent.viola.utils;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.text.TextUtils;
import android.util.Pair;
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
  
  public static Pair<int[], float[]> parseColorAndPosition(String[] paramArrayOfString, int paramInt)
  {
    int j = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    if (paramInt < paramArrayOfString.length)
    {
      Object localObject2 = paramArrayOfString[paramInt].trim();
      int i;
      if (((String)localObject2).contains("rgba"))
      {
        localObject1 = pickRgbOra(paramArrayOfString, paramInt, 4, localArrayList1);
        i = paramInt + 3;
      }
      for (;;)
      {
        localArrayList2.add(localObject1);
        paramInt = i + 1;
        break;
        if (((String)localObject2).contains("rgb"))
        {
          localObject1 = pickRgbOra(paramArrayOfString, paramInt, 3, localArrayList1);
          i = paramInt + 2;
        }
        else
        {
          localObject1 = localObject2;
          i = paramInt;
          if (((String)localObject2).contains("%"))
          {
            localObject2 = spiltColorAndLocation((String)localObject2);
            localObject1 = localObject2[0];
            localArrayList1.add(localObject2[1]);
            i = paramInt;
          }
        }
      }
    }
    paramArrayOfString = new int[localArrayList2.size()];
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      paramArrayOfString[paramInt] = ColorParseUtils.parseColor((String)localArrayList2.get(paramInt));
      paramInt += 1;
    }
    if ((!localArrayList1.isEmpty()) && (localArrayList1.size() != localArrayList2.size()))
    {
      if ((localArrayList1.size() != 1) || ((!localArrayList1.contains("0")) && (!localArrayList1.contains("100")))) {
        break label319;
      }
      localArrayList1.clear();
    }
    for (;;)
    {
      localObject1 = new float[localArrayList1.size()];
      paramInt = j;
      while (paramInt < localObject1.length)
      {
        localObject1[paramInt] = (Integer.parseInt((String)localArrayList1.get(paramInt)) / 100.0F);
        paramInt += 1;
      }
      label319:
      if ((localArrayList1.size() == 2) && (localArrayList1.contains("0")) && (localArrayList1.contains("100")))
      {
        localArrayList1.clear();
      }
      else
      {
        if (!localArrayList1.contains("0")) {
          localArrayList1.add(0, "0");
        }
        if ((localArrayList1.size() != localArrayList2.size()) && (!localArrayList1.contains("100"))) {
          localArrayList1.add(localArrayList1.size(), "100");
        }
      }
    }
    return new Pair(paramArrayOfString, localObject1);
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
    int j = 0;
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
        localObject = paramObject.substring(paramObject.indexOf('(') + 1, paramObject.lastIndexOf(')')).split(",");
        if (localObject.length <= 1) {
          return null;
        }
        paramObject = localObject[0];
        f1 = paramDomObject.getLayoutWidth();
        f2 = paramDomObject.getLayoutHeight();
        if (!paramObject.contains("to")) {
          break label198;
        }
        paramObject = parseFromPosition(paramObject, f1, f2);
        i = 0;
      }
      catch (Exception paramObject)
      {
        Object localObject;
        ViolaLogUtils.e("GradientParseUtils", paramObject.getMessage());
        return null;
      }
      paramDomObject = parseColorAndPosition((String[])localObject, i);
      localObject = (int[])paramDomObject.first;
      paramDomObject = (float[])paramDomObject.second;
      if ((paramObject != null) && (localObject != null) && (localObject.length >= 1))
      {
        if (paramDomObject.length == 0) {
          break label242;
        }
        label146:
        paramObject = new LinearGradient(paramObject[0].x, paramObject[0].y, paramObject[1].x, paramObject[1].y, (int[])localObject, paramDomObject, Shader.TileMode.CLAMP);
        return paramObject;
        label198:
        if (paramObject.contains("deg"))
        {
          paramObject = parseDegrees(paramObject, f1, f2);
          i = 0;
        }
        else
        {
          paramObject = parseFromPosition("to bottom", f1, f2);
          i = 1;
        }
      }
      label242:
      while (i == 0)
      {
        i = 1;
        break;
        return null;
        paramDomObject = null;
        break label146;
      }
      int i = j;
    }
  }
  
  private static String pickRgbOra(String[] paramArrayOfString, int paramInt1, int paramInt2, List<String> paramList)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < paramInt1 + paramInt2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
    {
      Object localObject = paramArrayOfString[i].trim();
      if (((String)localObject).contains("%"))
      {
        localObject = spiltColorAndLocation((String)localObject);
        localStringBuilder.append(",").append(localObject[0]);
        paramList.add(localObject[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i != paramInt1) {
          localStringBuilder.append(',').append((String)localObject);
        } else {
          localStringBuilder.append((String)localObject);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String[] spiltColorAndLocation(String paramString)
  {
    String[] arrayOfString = new String[2];
    paramString = paramString.trim().split(" ");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramString[i];
      if (TextUtils.isEmpty(localObject.trim())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject.contains("%")) {
          arrayOfString[1] = localObject.substring(0, localObject.length() - 1);
        } else {
          arrayOfString[0] = localObject;
        }
      }
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.GradientParseUtils
 * JD-Core Version:    0.7.0.1
 */