package com.tencent.plato.sdk.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.utils.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PAnimation
{
  public static final int ACTION_PAUSE = 2;
  public static final int ACTION_RESUME = 3;
  public static final int ACTION_START = 1;
  public static final int ACTION_STOP = 4;
  public static final String ANIMATION_ATTR_DELAY = "delay";
  public static final String ANIMATION_ATTR_DURATION = "duration";
  public static final String ANIMATION_ATTR_PROPERTY = "property";
  public static final String ANIMATION_ATTR_TIMINGFUNCTION = "timing-function";
  public static final String BACKGROUNDCOLOR = "backgroundColor";
  public static final String BACKGROUNDCOLOR_TRANSITION = "background-color";
  public static final String CUBIC_BEZIER = "cubic-bezier";
  public static final String EASE_IN = "ease-in";
  public static final String EASE_IN_OUT = "ease-in-out";
  public static final String EASE_OUT = "ease-out";
  public static final String HEIGHT = "height";
  public static final String LEFT = "left";
  public static final String LINEAR = "linear";
  public static final int NUM_CUBIC_PARAM = 4;
  public static final String OPACITY = "opacity";
  public static final String ROTATE = "rotate";
  public static final String ROTATEX = "rotateX";
  public static final String ROTATEY = "rotateY";
  public static final String ROTATEZ = "rotateZ";
  public static final String SCALE = "scale";
  public static final String SCALEX = "scaleX";
  public static final String SCALEY = "scaleY";
  public static final String SECONDS = "s";
  public static final String TAG = "PAnimation";
  public static final String TOP = "top";
  public static final String TRANSFORM = "transform";
  public static final String TRANSITION_ALL = "all";
  public static final String TRANSLATE = "translate";
  public static final String TRANSLATEX = "translateX";
  public static final String TRANSLATEY = "translateY";
  public static final String TRANSLATEZ = "translateZ";
  public static final String WIDTH = "width";
  public static List<String> timingFunctionList;
  public static List<String> transitionList = new ArrayList();
  private Animator animator;
  private String callBack;
  private String name;
  
  static
  {
    timingFunctionList = new ArrayList();
    transitionList.add("opacity");
    transitionList.add("left");
    transitionList.add("top");
    transitionList.add("width");
    transitionList.add("height");
    transitionList.add("background-color");
    transitionList.add("backgroundColor");
    transitionList.add("transform");
    transitionList.add("all");
    timingFunctionList.add("linear");
    timingFunctionList.add("ease-in-out");
    timingFunctionList.add("ease-in");
    timingFunctionList.add("ease-out");
    timingFunctionList.add("cubic-bezier");
  }
  
  public PAnimation(String paramString, Animator paramAnimator)
  {
    this.name = paramString;
    this.animator = paramAnimator;
  }
  
  public PAnimation(String paramString1, Animator paramAnimator, String paramString2)
  {
    this(paramString1, paramAnimator);
    this.callBack = paramString2;
  }
  
  public static PAnimation createAnimation(String paramString, PropertyValuesHolder paramPropertyValuesHolder, int paramInt)
  {
    return createAnimation(paramString, paramPropertyValuesHolder, paramInt, null);
  }
  
  public static PAnimation createAnimation(String paramString1, PropertyValuesHolder paramPropertyValuesHolder, int paramInt, String paramString2)
  {
    paramPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramPropertyValuesHolder });
    if (paramInt > 0) {
      paramPropertyValuesHolder.setDuration(paramInt);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = createInterpolator(paramString2);
      if (paramString2 != null) {
        paramPropertyValuesHolder.setInterpolator(paramString2);
      }
    }
    return new PAnimation(paramString1, paramPropertyValuesHolder);
  }
  
  public static Interpolator createInterpolator(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      float[] arrayOfFloat;
      for (;;)
      {
        switch (i)
        {
        default: 
          if (!paramString.startsWith("cubic-bezier")) {
            break label271;
          }
          paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
          if (TextUtils.isEmpty(paramString)) {
            break label271;
          }
          paramString = paramString.split(",");
          if ((paramString == null) || (paramString.length != 4)) {
            break label271;
          }
          arrayOfFloat = new float[4];
          i = 0;
          while (i < 4)
          {
            arrayOfFloat[i] = Float.parseFloat(paramString[i]);
            i += 1;
          }
          if (paramString.equals("ease-in"))
          {
            i = 0;
            continue;
            if (paramString.equals("ease-out"))
            {
              i = 1;
              continue;
              if (paramString.equals("ease-in-out"))
              {
                i = 2;
                continue;
                if (paramString.equals("linear")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      return new AccelerateInterpolator();
      return new DecelerateInterpolator();
      return new AccelerateDecelerateInterpolator();
      return new LinearInterpolator();
      return PathInterpolatorCompat.create(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      label271:
      return null;
    }
    return null;
  }
  
  private static String getTransitionName(String[] paramArrayOfString)
  {
    Object localObject2;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    int i = 0;
    int m = paramArrayOfString.length;
    int j = 0;
    for (;;)
    {
      int k = i;
      localObject2 = localObject1;
      if (j < m)
      {
        String str = paramArrayOfString[j];
        k = i;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          k = i;
          localObject2 = localObject1;
          if (transitionList.contains(str))
          {
            localObject1 = str;
            i += 1;
            k = i;
            localObject2 = localObject1;
            if (i > 1)
            {
              localObject2 = localObject1;
              k = i;
            }
          }
        }
      }
      else
      {
        if (k == 1) {
          break;
        }
        return null;
      }
      j += 1;
      i = k;
      localObject1 = localObject2;
    }
  }
  
  private static int getTransitionTime(String[] paramArrayOfString)
  {
    int n = 0;
    int i = 0;
    int i1 = 0;
    int m = 0;
    int k = i1;
    int j = n;
    int i3;
    if (paramArrayOfString != null)
    {
      k = i1;
      j = n;
      if (paramArrayOfString.length > 0)
      {
        i3 = paramArrayOfString.length;
        n = 0;
      }
    }
    for (;;)
    {
      k = m;
      j = i;
      if (n < i3)
      {
        String str = paramArrayOfString[n];
        j = m;
        i1 = i;
        if (!TextUtils.isEmpty(str))
        {
          int i2 = parseTime(str).intValue();
          j = m;
          i1 = i;
          if (i2 >= 0)
          {
            k = m + 1;
            if (k == 1) {
              i = i2;
            }
            j = k;
            i1 = i;
            if (k > 2) {
              j = i;
            }
          }
        }
      }
      else
      {
        if (k > 2) {
          j = 0;
        }
        return j;
      }
      n += 1;
      m = j;
      i = i1;
    }
  }
  
  private static String getTransitionTimingFunction(String[] paramArrayOfString)
  {
    Object localObject2;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    int i = 0;
    int m = paramArrayOfString.length;
    int j = 0;
    for (;;)
    {
      int k = i;
      localObject2 = localObject1;
      if (j < m)
      {
        String str = paramArrayOfString[j];
        k = i;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          k = i;
          localObject2 = localObject1;
          if (timingFunctionList.contains(str))
          {
            localObject1 = str;
            i += 1;
            k = i;
            localObject2 = localObject1;
            if (i > 1)
            {
              localObject2 = localObject1;
              k = i;
            }
          }
        }
      }
      else
      {
        if (k == 1) {
          break;
        }
        return null;
      }
      j += 1;
      i = k;
      localObject1 = localObject2;
    }
  }
  
  private static Object[] list2Array(List<Object> paramList)
  {
    return paramList.toArray(new Object[paramList.size()]);
  }
  
  private static Object[] parseRotate(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.contains("deg"))) {
          localArrayList.add(Float.valueOf(Float.parseFloat(localCharSequence.substring(0, localCharSequence.indexOf("deg")))));
        }
        i += 1;
      }
    }
    return list2Array(localArrayList);
  }
  
  private static Object[] parseScale(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(Float.valueOf(Float.parseFloat(localCharSequence)));
        }
        i += 1;
      }
    }
    return list2Array(localArrayList);
  }
  
  public static Integer parseTime(String paramString)
  {
    localFloat2 = Float.valueOf((0.0F / 0.0F));
    localFloat1 = localFloat2;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = paramString.trim();
        if (!paramString.endsWith("s")) {
          continue;
        }
        f = Float.parseFloat(paramString.substring(0, paramString.indexOf("s")));
        localFloat1 = Float.valueOf(f * 1000.0F);
      }
      catch (NumberFormatException paramString)
      {
        float f;
        PLog.e("PAnimation", "parseTime error, " + paramString.toString());
        localFloat1 = localFloat2;
        continue;
        int i = localFloat1.intValue();
        continue;
      }
      if (!localFloat1.isNaN()) {
        continue;
      }
      i = -1;
      return Integer.valueOf(i);
      f = Float.parseFloat(paramString);
      localFloat1 = Float.valueOf(f);
    }
  }
  
  public static Pair<String, Object[]> parseTransform(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.trim();
      String str = paramString.substring(paramString.indexOf("(") + 1, paramString.lastIndexOf(")"));
      if ((paramString.startsWith("rotateX")) || (paramString.startsWith("rotateY")) || (paramString.startsWith("rotateZ")) || (paramString.startsWith("rotate")))
      {
        if (paramString.startsWith("rotateX")) {
          paramString = "rotateX";
        }
        while (!TextUtils.isEmpty(str))
        {
          return new Pair(paramString, parseRotate(str));
          if (paramString.startsWith("rotateY")) {
            paramString = "rotateY";
          } else if (paramString.startsWith("rotateZ")) {
            paramString = "rotateZ";
          } else {
            paramString = "rotate";
          }
        }
      }
      else if ((paramString.startsWith("scaleX")) || (paramString.startsWith("scaleY")) || (paramString.startsWith("scale")))
      {
        if (paramString.startsWith("scaleX")) {
          paramString = "scaleX";
        }
        while (!TextUtils.isEmpty(str))
        {
          return new Pair(paramString, parseScale(str));
          if (paramString.startsWith("scaleY")) {
            paramString = "scaleY";
          } else {
            paramString = "scale";
          }
        }
      }
      else if ((paramString.startsWith("translateX")) || (paramString.startsWith("translateY")) || (paramString.startsWith("translateZ")))
      {
        if (paramString.startsWith("translateX")) {
          paramString = "translateX";
        }
        while (!TextUtils.isEmpty(str))
        {
          return new Pair(paramString, parseTranslate(str));
          if (paramString.startsWith("translateY")) {
            paramString = "translateY";
          } else {
            paramString = "translateZ";
          }
        }
      }
    }
  }
  
  public static Map<String, Map<String, Object>> parseTransition(String paramString)
  {
    HashMap localHashMap1 = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramString.trim().split(" ");
      if ((localObject != null) && (localObject.length > 0) && (localObject.length <= 4))
      {
        paramString = getTransitionName((String[])localObject);
        if (!TextUtils.isEmpty(paramString))
        {
          int i = getTransitionTime((String[])localObject);
          if (i > 0)
          {
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("duration", Integer.valueOf(i));
            localObject = getTransitionTimingFunction((String[])localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localHashMap2.put("timing-function", localObject);
            }
            localHashMap1.put(paramString, localHashMap2);
          }
        }
      }
    }
    return localHashMap1;
  }
  
  private static Object[] parseTranslate(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(Float.valueOf(Dimension.parse(localCharSequence).px));
        }
        i += 1;
      }
    }
    return list2Array(localArrayList);
  }
  
  public Animator getAnimator()
  {
    return this.animator;
  }
  
  public String getCallBack()
  {
    return this.callBack;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public PAnimation setAnimator(Animator paramAnimator)
  {
    this.animator = paramAnimator;
    return this;
  }
  
  public PAnimation setCallBack(String paramString)
  {
    this.callBack = paramString;
    return this;
  }
  
  public PAnimation setName(String paramString)
  {
    this.name = paramString;
    return this;
  }
  
  public static abstract interface ITransition
  {
    public abstract PAnimation createAnimation();
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.animation.PAnimation
 * JD-Core Version:    0.7.0.1
 */