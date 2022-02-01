package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.lang.ref.WeakReference;

class KeyframeParser
{
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final float MAX_CP_VALUE = 100.0F;
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
  
  static <T> Keyframe<T> parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser, boolean paramBoolean)
  {
    if (paramBoolean) {
      return parseKeyframe(paramLottieComposition, paramJsonReader, paramFloat, paramValueParser);
    }
    return parseStaticValue(paramJsonReader, paramFloat, paramValueParser);
  }
  
  private static <T> Keyframe<T> parseKeyframe(LottieComposition paramLottieComposition, JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser)
  {
    paramJsonReader.beginObject();
    int j = 0;
    PointF localPointF4 = null;
    PointF localPointF3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    float f1 = 0.0F;
    PointF localPointF2 = null;
    PointF localPointF1 = null;
    int i;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      i = str.hashCode();
      int k = 1;
      if (i != 101)
      {
        if (i != 111)
        {
          if (i != 3701)
          {
            if (i != 3707)
            {
              if (i != 104)
              {
                if (i != 105)
                {
                  if (i != 115)
                  {
                    if ((i == 116) && (str.equals("t")))
                    {
                      i = 0;
                      break label245;
                    }
                  }
                  else if (str.equals("s"))
                  {
                    i = 1;
                    break label245;
                  }
                }
                else if (str.equals("i"))
                {
                  i = 4;
                  break label245;
                }
              }
              else if (str.equals("h"))
              {
                i = 5;
                break label245;
              }
            }
            else if (str.equals("to"))
            {
              i = 6;
              break label245;
            }
          }
          else if (str.equals("ti"))
          {
            i = 7;
            break label245;
          }
        }
        else if (str.equals("o"))
        {
          i = 3;
          break label245;
        }
      }
      else if (str.equals("e"))
      {
        i = 2;
        break label245;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 7: 
        localPointF1 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 6: 
        localPointF2 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 5: 
        if (paramJsonReader.nextInt() == 1) {
          i = k;
        } else {
          i = 0;
        }
        j = i;
        break;
      case 4: 
        localPointF3 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 3: 
        localPointF4 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        break;
      case 2: 
        localObject1 = paramValueParser.parse(paramJsonReader, paramFloat);
        break;
      case 1: 
        localObject2 = paramValueParser.parse(paramJsonReader, paramFloat);
        break;
      case 0: 
        label245:
        f1 = (float)paramJsonReader.nextDouble();
      }
    }
    paramJsonReader.endObject();
    if (j != 0)
    {
      paramValueParser = LINEAR_INTERPOLATOR;
      paramJsonReader = localObject2;
    }
    else if ((localPointF4 != null) && (localPointF3 != null))
    {
      float f2 = localPointF4.x;
      float f3 = -paramFloat;
      localPointF4.x = MiscUtils.clamp(f2, f3, paramFloat);
      localPointF4.y = MiscUtils.clamp(localPointF4.y, -100.0F, 100.0F);
      localPointF3.x = MiscUtils.clamp(localPointF3.x, f3, paramFloat);
      localPointF3.y = MiscUtils.clamp(localPointF3.y, -100.0F, 100.0F);
      i = Utils.hashFor(localPointF4.x, localPointF4.y, localPointF3.x, localPointF3.y);
      paramValueParser = getInterpolator(i);
      if (paramValueParser != null) {
        paramJsonReader = (Interpolator)paramValueParser.get();
      } else {
        paramJsonReader = null;
      }
      if (paramValueParser != null)
      {
        paramValueParser = paramJsonReader;
        if (paramJsonReader != null) {}
      }
      else
      {
        paramValueParser = PathInterpolatorCompat.create(localPointF4.x / paramFloat, localPointF4.y / paramFloat, localPointF3.x / paramFloat, localPointF3.y / paramFloat);
      }
    }
    try
    {
      putInterpolator(i, new WeakReference(paramValueParser));
      label606:
      paramJsonReader = localObject1;
      break label619;
      paramValueParser = LINEAR_INTERPOLATOR;
      paramJsonReader = localObject1;
      label619:
      paramLottieComposition = new Keyframe(paramLottieComposition, localObject2, paramJsonReader, paramValueParser, f1, null);
      paramLottieComposition.pathCp1 = localPointF2;
      paramLottieComposition.pathCp2 = localPointF1;
      return paramLottieComposition;
    }
    catch (ArrayIndexOutOfBoundsException paramJsonReader)
    {
      break label606;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.KeyframeParser
 * JD-Core Version:    0.7.0.1
 */