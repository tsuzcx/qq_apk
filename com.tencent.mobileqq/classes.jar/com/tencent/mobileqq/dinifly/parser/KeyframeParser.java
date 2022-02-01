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
    Object localObject4 = null;
    Object localObject3 = null;
    float f = 0.0F;
    Object localObject1 = null;
    Object localObject5 = null;
    int i = 0;
    PointF localPointF = null;
    Object localObject2 = null;
    paramJsonReader.beginObject();
    if (paramJsonReader.hasNext())
    {
      Object localObject6 = paramJsonReader.nextName();
      int j = -1;
      switch (((String)localObject6).hashCode())
      {
      default: 
        switch (j)
        {
        default: 
          label124:
          paramJsonReader.skipValue();
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject6;
        }
        break;
      }
      for (;;)
      {
        localObject6 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject6;
        break;
        if (!((String)localObject6).equals("t")) {
          break label124;
        }
        j = 0;
        break label124;
        if (!((String)localObject6).equals("s")) {
          break label124;
        }
        j = 1;
        break label124;
        if (!((String)localObject6).equals("e")) {
          break label124;
        }
        j = 2;
        break label124;
        if (!((String)localObject6).equals("o")) {
          break label124;
        }
        j = 3;
        break label124;
        if (!((String)localObject6).equals("i")) {
          break label124;
        }
        j = 4;
        break label124;
        if (!((String)localObject6).equals("h")) {
          break label124;
        }
        j = 5;
        break label124;
        if (!((String)localObject6).equals("to")) {
          break label124;
        }
        j = 6;
        break label124;
        if (!((String)localObject6).equals("ti")) {
          break label124;
        }
        j = 7;
        break label124;
        f = (float)paramJsonReader.nextDouble();
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject6;
        continue;
        localObject6 = paramValueParser.parse(paramJsonReader, paramFloat);
        localObject1 = localObject2;
        localObject2 = localObject6;
        continue;
        localObject5 = paramValueParser.parse(paramJsonReader, paramFloat);
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject6;
        continue;
        localObject6 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject6;
        continue;
        localObject6 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject6;
        continue;
        if (paramJsonReader.nextInt() == 1) {}
        for (i = 1;; i = 0)
        {
          localObject6 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject6;
          break;
        }
        localPointF = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject6;
        continue;
        localObject6 = JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
        localObject2 = localObject1;
        localObject1 = localObject6;
      }
    }
    paramJsonReader.endObject();
    if (i != 0)
    {
      paramJsonReader = LINEAR_INTERPOLATOR;
      localObject5 = localObject1;
      paramLottieComposition = new Keyframe(paramLottieComposition, localObject1, localObject5, paramJsonReader, f, null);
      paramLottieComposition.pathCp1 = localPointF;
      paramLottieComposition.pathCp2 = localObject2;
      return paramLottieComposition;
    }
    if ((localObject4 != null) && (localObject3 != null))
    {
      localObject4.x = MiscUtils.clamp(localObject4.x, -paramFloat, paramFloat);
      localObject4.y = MiscUtils.clamp(localObject4.y, -100.0F, 100.0F);
      localObject3.x = MiscUtils.clamp(localObject3.x, -paramFloat, paramFloat);
      localObject3.y = MiscUtils.clamp(localObject3.y, -100.0F, 100.0F);
      i = Utils.hashFor(localObject4.x, localObject4.y, localObject3.x, localObject3.y);
      paramValueParser = getInterpolator(i);
      if (paramValueParser == null) {
        break label763;
      }
    }
    label747:
    label763:
    for (paramJsonReader = (Interpolator)paramValueParser.get();; paramJsonReader = null) {
      for (;;)
      {
        if (paramValueParser != null)
        {
          paramValueParser = paramJsonReader;
          if (paramJsonReader != null) {}
        }
        else
        {
          paramValueParser = PathInterpolatorCompat.create(localObject4.x / paramFloat, localObject4.y / paramFloat, localObject3.x / paramFloat, localObject3.y / paramFloat);
        }
        try
        {
          putInterpolator(i, new WeakReference(paramValueParser));
          paramJsonReader = paramValueParser;
          break;
          paramJsonReader = LINEAR_INTERPOLATOR;
        }
        catch (ArrayIndexOutOfBoundsException paramJsonReader)
        {
          break label747;
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.KeyframeParser
 * JD-Core Version:    0.7.0.1
 */