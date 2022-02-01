package com.tencent.viola.ui.animation;

import android.animation.PropertyValuesHolder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationBean$Style
{
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BOTTOM = "bottom";
  public static final String CENTER = "center";
  private static final String DEG = "deg";
  private static final String DP = "dp";
  private static final String FULL = "100%";
  private static final String HALF = "50%";
  public static final String HEIGHT = "height";
  public static final String LEFT = "left";
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
  private static Map<Property<View, Float>, Float> defaultMap;
  public static Map<String, List<Property<View, Float>>> toAndroidMap = new HashMap();
  public String backgroundColor;
  private float cameraDistance = 3.4028235E+38F;
  public String height;
  private List<PropertyValuesHolder> holders = new LinkedList();
  public String opacity;
  private Pair<Float, Float> pivot;
  public String transform;
  private Map<Property<View, Float>, Float> transformMap = new LinkedHashMap();
  public String transformOrigin;
  public String width;
  
  static
  {
    defaultMap = new HashMap();
    toAndroidMap.put("translate", Arrays.asList(new Property[] { View.TRANSLATION_X, View.TRANSLATION_Y }));
    toAndroidMap.put("translateX", Collections.singletonList(View.TRANSLATION_X));
    toAndroidMap.put("translateY", Collections.singletonList(View.TRANSLATION_Y));
    toAndroidMap.put("rotate", Collections.singletonList(View.ROTATION));
    toAndroidMap.put("rotateX", Collections.singletonList(View.ROTATION_X));
    toAndroidMap.put("rotateY", Collections.singletonList(View.ROTATION_Y));
    toAndroidMap.put("scale", Arrays.asList(new Property[] { View.SCALE_X, View.SCALE_Y }));
    toAndroidMap.put("scaleX", Collections.singletonList(View.SCALE_X));
    toAndroidMap.put("scaleY", Collections.singletonList(View.SCALE_Y));
    toAndroidMap = Collections.unmodifiableMap(toAndroidMap);
    defaultMap.put(View.TRANSLATION_X, Float.valueOf(0.0F));
    defaultMap.put(View.TRANSLATION_Y, Float.valueOf(0.0F));
    defaultMap.put(View.SCALE_X, Float.valueOf(1.0F));
    defaultMap.put(View.SCALE_Y, Float.valueOf(1.0F));
    defaultMap.put(View.ROTATION, Float.valueOf(0.0F));
    defaultMap.put(View.ROTATION_X, Float.valueOf(0.0F));
    defaultMap.put(View.ROTATION_Y, Float.valueOf(0.0F));
  }
  
  AnimationBean$Style(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("width")) {
        this.width = paramJSONObject.getString("width");
      }
      if (paramJSONObject.has("height")) {
        this.height = paramJSONObject.getString("height");
      }
      if (paramJSONObject.has("backgroundColor")) {
        this.backgroundColor = paramJSONObject.getString("backgroundColor");
      }
      if (paramJSONObject.has("transform")) {
        this.transform = paramJSONObject.getString("transform");
      }
      if (paramJSONObject.has("transformOrigin")) {
        this.transformOrigin = paramJSONObject.getString("transformOrigin");
      }
      if (paramJSONObject.has("opacity")) {
        this.opacity = paramJSONObject.getString("opacity");
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  private void initHolders()
  {
    Iterator localIterator = this.transformMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.holders.add(PropertyValuesHolder.ofFloat((Property)localEntry.getKey(), new float[] { ((Float)localEntry.getValue()).floatValue() }));
    }
    if (!TextUtils.isEmpty(this.opacity)) {
      this.holders.add(PropertyValuesHolder.ofFloat(View.ALPHA, new float[] { ViolaUtils.fastGetFloat(this.opacity, 3) }));
    }
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
    paramInt1 = paramString.lastIndexOf("dp");
    if (paramInt1 != -1) {
      return FlexConvertUtils.converPxByViewportToRealPx(Float.valueOf(ViolaUtils.fastGetFloat(paramString.substring(0, paramInt1), 1)), paramInt2);
    }
    return FlexConvertUtils.converPxByViewportToRealPx(Float.valueOf(ViolaUtils.fastGetFloat(paramString, 1)), paramInt2);
  }
  
  public static Pair<Float, Float> parsePivot(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
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
    return TransformParser.parseTransForm(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public static void resetToDefaultIfAbsent(Map<Property<View, Float>, Float> paramMap)
  {
    Iterator localIterator = defaultMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramMap.containsKey(localEntry.getKey())) {
        paramMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  public float getCameraDistance()
  {
    return this.cameraDistance;
  }
  
  public List<PropertyValuesHolder> getHolders()
  {
    return this.holders;
  }
  
  @Nullable
  public Pair<Float, Float> getPivot()
  {
    return this.pivot;
  }
  
  public void init(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pivot = parsePivot(paramString1, paramInt1, paramInt2, paramInt3);
    this.transformMap.putAll(parseTransForm(paramString2, paramInt1, paramInt2, paramInt3));
    resetToDefaultIfAbsent(this.transformMap);
    if (this.transformMap.containsKey(CameraDistanceProperty.getInstance())) {
      this.cameraDistance = ((Float)this.transformMap.remove(CameraDistanceProperty.getInstance())).floatValue();
    }
    initHolders();
  }
  
  public void init(@NonNull Map<Property<View, Float>, Pair<Float, Float>> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.holders.add(PropertyValuesHolder.ofFloat((Property)localEntry.getKey(), new float[] { ((Float)((Pair)localEntry.getValue()).first).floatValue(), ((Float)((Pair)localEntry.getValue()).second).floatValue() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.animation.AnimationBean.Style
 * JD-Core Version:    0.7.0.1
 */