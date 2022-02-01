package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.lang.ref.WeakReference;

class KeyframeParser
{
  static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of(new String[] { "x", "y" });
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final float MAX_CP_VALUE = 100.0F;
  static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "t", "s", "e", "o", "i", "h", "to", "ti" });
  private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
  
  @Nullable
  private static WeakReference<Interpolator> getInterpolator(int paramInt)
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)pathInterpolatorCache().get(paramInt);
      return localWeakReference;
    }
    finally {}
  }
  
  private static Interpolator interpolatorFor(PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1.x = MiscUtils.clamp(paramPointF1.x, -1.0F, 1.0F);
    paramPointF1.y = MiscUtils.clamp(paramPointF1.y, -100.0F, 100.0F);
    paramPointF2.x = MiscUtils.clamp(paramPointF2.x, -1.0F, 1.0F);
    paramPointF2.y = MiscUtils.clamp(paramPointF2.y, -100.0F, 100.0F);
    int i = Utils.hashFor(paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
    Object localObject = getInterpolator(i);
    Interpolator localInterpolator;
    if (localObject != null) {
      localInterpolator = (Interpolator)((WeakReference)localObject).get();
    } else {
      localInterpolator = null;
    }
    if (localObject != null)
    {
      localObject = localInterpolator;
      if (localInterpolator != null) {}
    }
    else
    {
      try
      {
        localInterpolator = PathInterpolatorCompat.create(paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
        paramPointF1 = localInterpolator;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if ("The Path cannot loop back on itself.".equals(localIllegalArgumentException.getMessage())) {
          paramPointF1 = PathInterpolatorCompat.create(Math.min(paramPointF1.x, 1.0F), paramPointF1.y, Math.max(paramPointF2.x, 0.0F), paramPointF2.y);
        } else {
          paramPointF1 = new LinearInterpolator();
        }
      }
    }
    try
    {
      putInterpolator(i, new WeakReference(paramPointF1));
      localObject = paramPointF1;
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException paramPointF2) {}
    return paramPointF1;
  }
  
  static <T> Keyframe<T> parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return parseMultiDimensionalKeyframe(paramLottieComposition, paramJsonReader, paramFloat, paramValueParser);
    }
    if (paramBoolean1) {
      return parseKeyframe(paramLottieComposition, paramJsonReader, paramFloat, paramValueParser);
    }
    return parseStaticValue(paramJsonReader, paramFloat, paramValueParser);
  }
  
  private static <T> Keyframe<T> parseKeyframe(LottieComposition paramLottieComposition, JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser)
  {
    paramJsonReader.beginObject();
    PointF localPointF2 = null;
    PointF localPointF1 = localPointF2;
    Object localObject2 = localPointF1;
    Object localObject1 = localObject2;
    Object localObject3 = localObject1;
    Object localObject4 = localObject3;
    int i = 0;
    float f = 0.0F;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 7: 
        localObject4 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 6: 
        localObject3 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 5: 
        if (paramJsonReader.nextInt() == 1) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      case 4: 
        localPointF1 = JsonUtils.jsonToPoint(paramJsonReader, 1.0F);
        break;
      case 3: 
        localPointF2 = JsonUtils.jsonToPoint(paramJsonReader, 1.0F);
        break;
      case 2: 
        localObject2 = paramValueParser.parse(paramJsonReader, paramFloat);
        break;
      case 1: 
        localObject1 = paramValueParser.parse(paramJsonReader, paramFloat);
        break;
      case 0: 
        f = (float)paramJsonReader.nextDouble();
      }
    }
    paramJsonReader.endObject();
    if (i != 0)
    {
      paramJsonReader = LINEAR_INTERPOLATOR;
      localObject2 = localObject1;
    }
    else if ((localPointF2 != null) && (localPointF1 != null))
    {
      paramJsonReader = interpolatorFor(localPointF2, localPointF1);
    }
    else
    {
      paramJsonReader = LINEAR_INTERPOLATOR;
    }
    paramLottieComposition = new Keyframe(paramLottieComposition, localObject1, localObject2, paramJsonReader, f, null);
    paramLottieComposition.pathCp1 = ((PointF)localObject3);
    paramLottieComposition.pathCp2 = ((PointF)localObject4);
    return paramLottieComposition;
  }
  
  private static <T> Keyframe<T> parseMultiDimensionalKeyframe(LottieComposition paramLottieComposition, JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser)
  {
    paramJsonReader.beginObject();
    PointF localPointF1 = null;
    int i = 0;
    PointF localPointF6 = null;
    PointF localPointF5 = null;
    PointF localPointF4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    PointF localPointF3 = null;
    Object localObject4 = null;
    float f1 = 0.0F;
    PointF localPointF2 = null;
    Object localObject1 = null;
    if (paramJsonReader.hasNext())
    {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipValue();
      }
      for (;;)
      {
        break;
        localPointF1 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
        localPointF2 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
        if (paramJsonReader.nextInt() == 1)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        float f5;
        float f3;
        float f2;
        float f4;
        int j;
        if (paramJsonReader.peek() == JsonReader.Token.BEGIN_OBJECT)
        {
          paramJsonReader.beginObject();
          f5 = 0.0F;
          f3 = 0.0F;
          f2 = 0.0F;
          f4 = 0.0F;
          if (paramJsonReader.hasNext())
          {
            j = paramJsonReader.selectName(INTERPOLATOR_NAMES);
            if (j != 0) {
              if (j != 1) {
                paramJsonReader.skipValue();
              }
            }
            label336:
            for (;;)
            {
              break;
              if (paramJsonReader.peek() == JsonReader.Token.NUMBER)
              {
                f4 = (float)paramJsonReader.nextDouble();
                f3 = f4;
              }
              else
              {
                paramJsonReader.beginArray();
                f3 = (float)paramJsonReader.nextDouble();
                if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
                  f4 = (float)paramJsonReader.nextDouble();
                } else {
                  f4 = f3;
                }
                paramJsonReader.endArray();
                break label336;
                if (paramJsonReader.peek() == JsonReader.Token.NUMBER)
                {
                  f2 = (float)paramJsonReader.nextDouble();
                  f5 = f2;
                }
                else
                {
                  paramJsonReader.beginArray();
                  f5 = (float)paramJsonReader.nextDouble();
                  if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
                    f2 = (float)paramJsonReader.nextDouble();
                  } else {
                    f2 = f5;
                  }
                  paramJsonReader.endArray();
                }
              }
            }
          }
          localPointF3 = new PointF(f5, f3);
          localObject4 = new PointF(f2, f4);
          paramJsonReader.endObject();
        }
        else
        {
          localPointF5 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
          continue;
          if (paramJsonReader.peek() != JsonReader.Token.BEGIN_OBJECT) {
            break label607;
          }
          paramJsonReader.beginObject();
          f4 = 0.0F;
          f2 = 0.0F;
          f5 = 0.0F;
          f3 = 0.0F;
          while (paramJsonReader.hasNext())
          {
            j = paramJsonReader.selectName(INTERPOLATOR_NAMES);
            if (j != 0)
            {
              if (j != 1)
              {
                paramJsonReader.skipValue();
              }
              else if (paramJsonReader.peek() == JsonReader.Token.NUMBER)
              {
                f3 = (float)paramJsonReader.nextDouble();
                f2 = f3;
              }
              else
              {
                paramJsonReader.beginArray();
                f2 = (float)paramJsonReader.nextDouble();
                if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
                  f3 = (float)paramJsonReader.nextDouble();
                } else {
                  f3 = f2;
                }
                paramJsonReader.endArray();
              }
            }
            else if (paramJsonReader.peek() == JsonReader.Token.NUMBER)
            {
              f5 = (float)paramJsonReader.nextDouble();
              f4 = f5;
            }
            else
            {
              paramJsonReader.beginArray();
              f4 = (float)paramJsonReader.nextDouble();
              if (paramJsonReader.peek() == JsonReader.Token.NUMBER) {
                f5 = (float)paramJsonReader.nextDouble();
              } else {
                f5 = f4;
              }
              paramJsonReader.endArray();
            }
          }
          localPointF4 = new PointF(f4, f2);
          localObject3 = new PointF(f5, f3);
          paramJsonReader.endObject();
        }
        continue;
        label607:
        localPointF6 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        continue;
        localObject1 = paramValueParser.parse(paramJsonReader, paramFloat);
        continue;
        localObject2 = paramValueParser.parse(paramJsonReader, paramFloat);
        continue;
        f1 = (float)paramJsonReader.nextDouble();
      }
    }
    paramJsonReader.endObject();
    if (i != 0) {
      paramValueParser = LINEAR_INTERPOLATOR;
    }
    for (paramJsonReader = localObject2;; paramJsonReader = localObject1)
    {
      localObject3 = null;
      localObject1 = null;
      break;
      if ((localPointF6 != null) && (localPointF5 != null))
      {
        paramValueParser = interpolatorFor(localPointF6, localPointF5);
      }
      else
      {
        if ((localPointF4 != null) && (localObject3 != null) && (localPointF3 != null) && (localObject4 != null))
        {
          paramJsonReader = interpolatorFor(localPointF4, localPointF3);
          localObject4 = interpolatorFor((PointF)localObject3, (PointF)localObject4);
          localObject3 = paramJsonReader;
          paramJsonReader = localObject1;
          paramValueParser = null;
          localObject1 = localObject4;
          break;
        }
        paramValueParser = LINEAR_INTERPOLATOR;
      }
    }
    if ((localObject3 != null) && (localObject1 != null)) {
      paramLottieComposition = new Keyframe(paramLottieComposition, localObject2, paramJsonReader, (Interpolator)localObject3, localObject1, f1, null);
    } else {
      paramLottieComposition = new Keyframe(paramLottieComposition, localObject2, paramJsonReader, paramValueParser, f1, null);
    }
    paramLottieComposition.pathCp1 = localPointF2;
    paramLottieComposition.pathCp2 = localPointF1;
    return paramLottieComposition;
  }
  
  private static <T> Keyframe<T> parseStaticValue(JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser)
  {
    return new Keyframe(paramValueParser.parse(paramJsonReader, paramFloat));
  }
  
  private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache()
  {
    if (pathInterpolatorCache == null) {
      pathInterpolatorCache = new SparseArrayCompat();
    }
    return pathInterpolatorCache;
  }
  
  private static void putInterpolator(int paramInt, WeakReference<Interpolator> paramWeakReference)
  {
    try
    {
      pathInterpolatorCache.put(paramInt, paramWeakReference);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.KeyframeParser
 * JD-Core Version:    0.7.0.1
 */