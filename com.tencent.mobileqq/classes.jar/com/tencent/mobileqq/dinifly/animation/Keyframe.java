package com.tencent.mobileqq.dinifly.animation;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory<TT;>;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Keyframe<T>
{
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final float MAX_CP_VALUE = 100.0F;
  private final LottieComposition composition;
  @Nullable
  public Float endFrame;
  private float endProgress = 1.4E-45F;
  @Nullable
  public final T endValue;
  @Nullable
  public final Interpolator interpolator;
  public final float startFrame;
  private float startProgress = 1.4E-45F;
  @Nullable
  public final T startValue;
  
  public Keyframe(LottieComposition paramLottieComposition, @Nullable T paramT1, @Nullable T paramT2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    this.composition = paramLottieComposition;
    this.startValue = paramT1;
    this.endValue = paramT2;
    this.interpolator = paramInterpolator;
    this.startFrame = paramFloat;
    this.endFrame = paramFloat1;
  }
  
  public static void setEndFrames(List<? extends Keyframe<?>> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      ((Keyframe)paramList.get(i)).endFrame = Float.valueOf(((Keyframe)paramList.get(i + 1)).startFrame);
      i += 1;
    }
    Keyframe localKeyframe = (Keyframe)paramList.get(j - 1);
    if (localKeyframe.startValue == null) {
      paramList.remove(localKeyframe);
    }
  }
  
  public boolean containsProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (paramFloat >= getStartProgress()) && (paramFloat <= getEndProgress());
  }
  
  public float getEndProgress()
  {
    if (this.endProgress == 1.4E-45F) {
      if (this.endFrame != null) {
        break label27;
      }
    }
    label27:
    for (this.endProgress = 1.0F;; this.endProgress = (getStartProgress() + (this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames())) {
      return this.endProgress;
    }
  }
  
  public float getStartProgress()
  {
    if (this.startProgress == 1.4E-45F) {
      this.startProgress = ((this.startFrame - (float)this.composition.getStartFrame()) / this.composition.getDurationFrames());
    }
    return this.startProgress;
  }
  
  public boolean isStatic()
  {
    return this.interpolator == null;
  }
  
  public String toString()
  {
    return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
  }
  
  public static class Factory
  {
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
    
    public static <T> Keyframe<T> newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition, float paramFloat, AnimatableValue.Factory<T> paramFactory)
    {
      Object localObject5 = null;
      Object localObject6 = null;
      float f = 0.0F;
      Object localObject2 = null;
      Interpolator localInterpolator = null;
      Object localObject3 = null;
      if (paramJSONObject.has("t"))
      {
        f = (float)paramJSONObject.optDouble("t", 0.0D);
        localObject1 = paramJSONObject.opt("s");
        if (localObject1 == null) {
          break label411;
        }
      }
      label411:
      for (Object localObject1 = paramFactory.valueFromObject(localObject1, paramFloat);; localObject1 = null)
      {
        localObject3 = paramJSONObject.opt("e");
        if (localObject3 != null) {
          localObject2 = paramFactory.valueFromObject(localObject3, paramFloat);
        }
        JSONObject localJSONObject = paramJSONObject.optJSONObject("o");
        paramFactory = paramJSONObject.optJSONObject("i");
        Object localObject4 = localObject5;
        localObject3 = localObject6;
        if (localJSONObject != null)
        {
          localObject4 = localObject5;
          localObject3 = localObject6;
          if (paramFactory != null)
          {
            localObject4 = JsonUtils.pointFromJsonObject(localJSONObject, paramFloat);
            localObject3 = JsonUtils.pointFromJsonObject(paramFactory, paramFloat);
          }
        }
        int i;
        if (paramJSONObject.optInt("h", 0) == 1)
        {
          i = 1;
          if (i == 0) {
            break label190;
          }
          paramJSONObject = Keyframe.LINEAR_INTERPOLATOR;
          paramFactory = (AnimatableValue.Factory<T>)localObject1;
        }
        label166:
        for (paramFloat = f;; paramFloat = f)
        {
          for (;;)
          {
            return new Keyframe(paramLottieComposition, localObject1, paramFactory, paramJSONObject, paramFloat, null);
            i = 0;
            break;
            label190:
            if (localObject4 == null) {
              break label378;
            }
            ((PointF)localObject4).x = MiscUtils.clamp(((PointF)localObject4).x, -paramFloat, paramFloat);
            ((PointF)localObject4).y = MiscUtils.clamp(((PointF)localObject4).y, -100.0F, 100.0F);
            ((PointF)localObject3).x = MiscUtils.clamp(((PointF)localObject3).x, -paramFloat, paramFloat);
            ((PointF)localObject3).y = MiscUtils.clamp(((PointF)localObject3).y, -100.0F, 100.0F);
            i = Utils.hashFor(((PointF)localObject4).x, ((PointF)localObject4).y, ((PointF)localObject3).x, ((PointF)localObject3).y);
            paramJSONObject = getInterpolator(i);
            if (paramJSONObject != null) {
              localInterpolator = (Interpolator)paramJSONObject.get();
            }
            if (paramJSONObject != null)
            {
              paramJSONObject = localInterpolator;
              paramFactory = localObject2;
              if (localInterpolator != null) {
                break label166;
              }
            }
            paramJSONObject = PathInterpolatorCompat.create(((PointF)localObject4).x / paramFloat, ((PointF)localObject4).y / paramFloat, ((PointF)localObject3).x / paramFloat, ((PointF)localObject3).y / paramFloat);
            try
            {
              putInterpolator(i, new WeakReference(paramJSONObject));
              paramFactory = localObject2;
            }
            catch (ArrayIndexOutOfBoundsException paramFactory)
            {
              paramFactory = localObject2;
            }
          }
          break label166;
          label378:
          paramJSONObject = Keyframe.LINEAR_INTERPOLATOR;
          paramFactory = localObject2;
          break label166;
          paramJSONObject = paramFactory.valueFromObject(paramJSONObject, paramFloat);
          paramFactory = paramJSONObject;
          localObject1 = paramJSONObject;
          paramJSONObject = (JSONObject)localObject3;
        }
      }
    }
    
    public static <T> List<Keyframe<T>> parseKeyframes(JSONArray paramJSONArray, LottieComposition paramLottieComposition, float paramFloat, AnimatableValue.Factory<T> paramFactory)
    {
      int j = paramJSONArray.length();
      if (j == 0) {
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(newInstance(paramJSONArray.optJSONObject(i), paramLottieComposition, paramFloat, paramFactory));
        i += 1;
      }
      Keyframe.setEndFrames(localArrayList);
      return localArrayList;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.Keyframe
 * JD-Core Version:    0.7.0.1
 */