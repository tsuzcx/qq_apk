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
    float f = paramFloat1 / 2.0F;
    double d1 = f;
    double d3 = getTanByDeg(paramInt);
    double d2 = paramFloat2;
    Double.isNaN(d2);
    d3 = d3 * d2 / 2.0D;
    Double.isNaN(d1);
    localPointF2.x = ((float)(d3 + d1));
    localPointF2.y = 0.0F;
    if (localPointF2.x > paramFloat1)
    {
      localPointF2.x = paramFloat1;
      d3 = paramFloat2 / 2.0F;
      double d4 = getTanByDeg(paramInt);
      Double.isNaN(d1);
      d4 = d1 / d4;
      Double.isNaN(d3);
      localPointF2.y = ((float)(d3 - d4));
    }
    d3 = getTanByDeg(paramInt);
    Double.isNaN(d2);
    localPointF1.x = (f - (float)(d3 * d2 / 2.0D));
    localPointF1.y = paramFloat2;
    if (localPointF1.x < 0.0F)
    {
      localPointF1.x = 0.0F;
      d2 = paramFloat2 / 2.0F;
      d3 = getTanByDeg(paramInt);
      Double.isNaN(d1);
      d1 /= d3;
      Double.isNaN(d2);
      localPointF1.y = ((float)(d2 + d1));
    }
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] make180PointF(float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    paramFloat1 /= 2.0F;
    localPointF1.x = paramFloat1;
    localPointF1.y = 0.0F;
    localPointF2.x = paramFloat1;
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
    paramFloat2 /= 2.0F;
    localPointF1.y = paramFloat2;
    localPointF2.x = paramFloat1;
    localPointF2.y = paramFloat2;
    return new PointF[] { localPointF1, localPointF2 };
  }
  
  private static PointF[] make90To180Point(int paramInt, float paramFloat1, float paramFloat2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    float f = paramFloat2 / 2.0F;
    double d1 = f;
    paramInt -= 90;
    double d2 = getTanByDeg(paramInt);
    double d3 = paramFloat1;
    Double.isNaN(d3);
    d2 = d2 * d3 / 2.0D;
    Double.isNaN(d1);
    localPointF2.y = ((float)(d2 + d1));
    localPointF2.x = paramFloat1;
    if (localPointF2.y > paramFloat2)
    {
      localPointF2.y = paramFloat2;
      d2 = paramFloat1 / 2.0F;
      d3 = getTanByDeg(paramInt);
      Double.isNaN(d1);
      d3 = d1 / d3;
      Double.isNaN(d2);
      localPointF2.x = ((float)(d2 + d3));
    }
    paramFloat1 /= 2.0F;
    d2 = paramFloat1;
    d3 = Math.tan(Math.toRadians(paramInt));
    Double.isNaN(d2);
    localPointF1.y = (f - (float)(d2 * d3));
    localPointF1.x = 0.0F;
    if (localPointF1.y < 0.0F)
    {
      localPointF1.y = 0.0F;
      d2 = getTanByDeg(paramInt);
      Double.isNaN(d1);
      localPointF1.x = (paramFloat1 - (float)(d1 / d2));
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
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int i;
      for (;;)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (paramInt >= j) {
          break;
        }
        Object localObject2 = paramArrayOfString[paramInt].trim();
        if (((String)localObject2).contains("rgba"))
        {
          localObject1 = pickRgbOra(paramArrayOfString, paramInt, 4, localArrayList1);
          i = paramInt + 3;
        }
        else if (((String)localObject2).contains("rgb"))
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
        localArrayList2.add(localObject1);
        paramInt = i + 1;
      }
      paramArrayOfString = new int[localArrayList2.size()];
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        paramArrayOfString[paramInt] = ColorParseUtils.parseColor((String)localArrayList2.get(paramInt));
        paramInt += 1;
      }
      if ((!localArrayList1.isEmpty()) && (localArrayList1.size() != localArrayList2.size())) {
        if ((localArrayList1.size() == 1) && ((localArrayList1.contains("0")) || (localArrayList1.contains("100"))))
        {
          localArrayList1.clear();
        }
        else if ((localArrayList1.size() == 2) && (localArrayList1.contains("0")) && (localArrayList1.contains("100")))
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
      Object localObject1 = new float[localArrayList1.size()];
      paramInt = i;
      while (paramInt < localObject1.length)
      {
        localObject1[paramInt] = (Integer.parseInt((String)localArrayList1.get(paramInt)) / 100.0F);
        paramInt += 1;
      }
      return new Pair(paramArrayOfString, localObject1);
    }
    return null;
  }
  
  private static PointF[] parseDegrees(String paramString, float paramFloat1, float paramFloat2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("deg")))
    {
      int i = Integer.parseInt(paramString.substring(0, paramString.indexOf("deg"))) % 360;
      if (i >= 0) {
        return makePoPointF(i, paramFloat1, paramFloat2);
      }
      return makeNePointF(i, paramFloat1, paramFloat2);
    }
    return null;
  }
  
  private static PointF[] parseFromPosition(String paramString, float paramFloat1, float paramFloat2)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1520072255: 
      if (paramString.equals("to left bottom")) {
        i = 5;
      }
      break;
    case 1381793217: 
      if (paramString.equals("to left top")) {
        i = 4;
      }
      break;
    case 1055841335: 
      if (paramString.equals("to right")) {
        i = 3;
      }
      break;
    case 926430700: 
      if (paramString.equals("to right top")) {
        i = 6;
      }
      break;
    case -677950924: 
      if (paramString.equals("to right bottom")) {
        i = 7;
      }
      break;
    case -870406608: 
      if (paramString.equals("to top")) {
        i = 0;
      }
      break;
    case -1213049204: 
      if (paramString.equals("to left")) {
        i = 2;
      }
      break;
    case -2080783504: 
      if (paramString.equals("to bottom")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return null;
    case 7: 
      return make90To180Point(135, paramFloat1, paramFloat2);
    case 6: 
      return make0To90PointF(45, paramFloat1, paramFloat2);
    case 5: 
      return make180To270PointF(225, paramFloat1, paramFloat2);
    case 4: 
      return make270To360PointF(315, paramFloat1, paramFloat2);
    case 3: 
      return make90PointF(paramFloat1, paramFloat2);
    case 2: 
      return make270PointF(paramFloat1, paramFloat2);
    case 1: 
      return make180PointF(paramFloat1, paramFloat2);
    }
    return make0To90PointF(0, paramFloat1, paramFloat2);
  }
  
  public static LinearGradient parseLinearGradient(Object paramObject, DomObject paramDomObject)
  {
    int i;
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
      float f1 = paramDomObject.getLayoutWidth();
      float f2 = paramDomObject.getLayoutHeight();
      if (paramObject.contains("to"))
      {
        paramObject = parseFromPosition(paramObject, f1, f2);
        break label230;
      }
      if (paramObject.contains("deg"))
      {
        paramObject = parseDegrees(paramObject, f1, f2);
        break label230;
      }
      paramObject = parseFromPosition("to bottom", f1, f2);
      i = 1;
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
    if ((paramObject != null) && (localObject != null) && (localObject.length >= 1)) {
      if (paramDomObject.length == 0) {
        break label250;
      }
    }
    for (;;)
    {
      paramObject = new LinearGradient(paramObject[0].x, paramObject[0].y, paramObject[1].x, paramObject[1].y, (int[])localObject, paramDomObject, Shader.TileMode.CLAMP);
      return paramObject;
      return null;
      label230:
      i = 0;
      if (i != 0)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label250:
      paramDomObject = null;
    }
  }
  
  private static String pickRgbOra(String[] paramArrayOfString, int paramInt1, int paramInt2, List<String> paramList)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = paramInt2 + paramInt1;
      if (j >= i)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt2 = paramInt1;
        while (paramInt2 < i)
        {
          Object localObject = paramArrayOfString[paramInt2].trim();
          if (((String)localObject).contains("%"))
          {
            localObject = spiltColorAndLocation((String)localObject);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject[0]);
            paramList.add(localObject[1]);
          }
          else if (paramInt2 != paramInt1)
          {
            localStringBuilder.append(',');
            localStringBuilder.append((String)localObject);
          }
          else
          {
            localStringBuilder.append((String)localObject);
          }
          paramInt2 += 1;
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  private static String[] spiltColorAndLocation(String paramString)
  {
    String[] arrayOfString = new String[2];
    paramString = paramString.trim().split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (!TextUtils.isEmpty(localObject.trim())) {
        if (localObject.contains("%")) {
          arrayOfString[1] = localObject.substring(0, localObject.length() - 1);
        } else {
          arrayOfString[0] = localObject;
        }
      }
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.GradientParseUtils
 * JD-Core Version:    0.7.0.1
 */