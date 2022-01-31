package com.tencent.viola.ui.animation;

import android.animation.PropertyValuesHolder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.FunctionParser;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TransformParser
{
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BOTTOM = "bottom";
  public static final String CENTER = "center";
  private static final String DEG = "deg";
  private static final String FULL = "100%";
  private static final String HALF = "50%";
  public static final String HEIGHT = "height";
  public static final String LEFT = "left";
  private static final String PX = "px";
  public static final String RIGHT = "right";
  public static final String ROTATE = "rotate";
  public static final String ROTATE_X = "rotateX";
  public static final String ROTATE_Y = "rotateY";
  public static final String SCALE = "scale";
  public static final String SCALE_X = "scaleX";
  public static final String SCALE_Y = "scaleY";
  public static final String TOP = "top";
  public static final String TRANSLATE = "translate";
  public static final String TRANSLATE_X = "translateX";
  public static final String TRANSLATE_Y = "translateY";
  public static final String WIDTH = "width";
  private static final String ZERO = "0%";
  public static Map<String, List<Property<View, Float>>> toAndroidMap = Collections.unmodifiableMap(toAndroidMap);
  
  static
  {
    toAndroidMap.put("translate", Arrays.asList(new Property[] { View.TRANSLATION_X, View.TRANSLATION_Y }));
    toAndroidMap.put("translateX", Collections.singletonList(View.TRANSLATION_X));
    toAndroidMap.put("translateY", Collections.singletonList(View.TRANSLATION_Y));
    toAndroidMap.put("rotate", Collections.singletonList(View.ROTATION));
    toAndroidMap.put("rotateX", Collections.singletonList(View.ROTATION_X));
    toAndroidMap.put("rotateY", Collections.singletonList(View.ROTATION_Y));
    toAndroidMap.put("scale", Arrays.asList(new Property[] { View.SCALE_X, View.SCALE_Y }));
    toAndroidMap.put("scaleX", Collections.singletonList(View.SCALE_X));
    toAndroidMap.put("scaleY", Collections.singletonList(View.SCALE_Y));
  }
  
  private static float parsePercent(String paramString, int paramInt1, int paramInt2)
  {
    return ViolaUtils.fastGetFloat(paramString, paramInt2) / 100.0F * paramInt1;
  }
  
  private static float parsePercentOrPx(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.lastIndexOf('%');
    if (i != -1) {
      return parsePercent(paramString.substring(0, i), paramInt1, 1);
    }
    if (paramString.lastIndexOf("px") != -1) {
      return FlexConvertUtils.converPxByViewportToRealPx(paramString, paramInt2);
    }
    return FlexConvertUtils.converPxByViewportToRealPx(paramString, paramInt2);
  }
  
  private static Pair<Float, Float> parsePivot(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.indexOf(' ');
      if (j != -1)
      {
        int i = j;
        for (;;)
        {
          if ((i >= paramString.length()) || (paramString.charAt(i) != ' '))
          {
            if ((i >= paramString.length()) || (paramString.charAt(i) == ' ')) {
              break;
            }
            ArrayList localArrayList = new ArrayList(2);
            localArrayList.add(paramString.substring(0, j).trim());
            localArrayList.add(paramString.substring(i, paramString.length()).trim());
            return parsePivot(localArrayList, paramInt1, paramInt2, paramInt3);
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static Pair<Float, Float> parsePivot(@NonNull List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    return new Pair(Float.valueOf(parsePivotX((String)paramList.get(0), paramInt1, paramInt3)), Float.valueOf(parsePivotY((String)paramList.get(1), paramInt2, paramInt3)));
  }
  
  private static float parsePivotX(String paramString, int paramInt1, int paramInt2)
  {
    String str;
    if ("left".equals(paramString)) {
      str = "0%";
    }
    for (;;)
    {
      return parsePercentOrPx(str, paramInt1, paramInt2);
      if ("right".equals(paramString))
      {
        str = "100%";
      }
      else
      {
        str = paramString;
        if ("center".equals(paramString)) {
          str = "50%";
        }
      }
    }
  }
  
  private static float parsePivotY(String paramString, int paramInt1, int paramInt2)
  {
    String str;
    if ("top".equals(paramString)) {
      str = "0%";
    }
    for (;;)
    {
      return parsePercentOrPx(str, paramInt1, paramInt2);
      if ("bottom".equals(paramString))
      {
        str = "100%";
      }
      else
      {
        str = paramString;
        if ("center".equals(paramString)) {
          str = "50%";
        }
      }
    }
  }
  
  public static Map<Property<View, Float>, Float> parseTransForm(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new FunctionParser(paramString, new TransformParser.1(paramInt1, paramInt2, paramInt3)).parse();
    }
    return new LinkedHashMap();
  }
  
  public static PropertyValuesHolder[] toHolders(Map<Property<View, Float>, Float> paramMap)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[paramMap.size()];
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      arrayOfPropertyValuesHolder[i] = PropertyValuesHolder.ofFloat((Property)localEntry.getKey(), new float[] { ((Float)localEntry.getValue()).floatValue() });
      i += 1;
    }
    return arrayOfPropertyValuesHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.animation.TransformParser
 * JD-Core Version:    0.7.0.1
 */