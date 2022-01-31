package com.tencent.mobileqq.dinifly.model.animatable;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.Keyframe.Factory;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnimatableValueParser<T>
{
  private final LottieComposition composition;
  @Nullable
  private final JSONObject json;
  private final float scale;
  private final AnimatableValue.Factory<T> valueFactory;
  
  private AnimatableValueParser(@Nullable JSONObject paramJSONObject, float paramFloat, LottieComposition paramLottieComposition, AnimatableValue.Factory<T> paramFactory)
  {
    this.json = paramJSONObject;
    this.scale = paramFloat;
    this.composition = paramLottieComposition;
    this.valueFactory = paramFactory;
  }
  
  private static boolean hasKeyframes(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {}
    do
    {
      return false;
      paramObject = ((JSONArray)paramObject).opt(0);
    } while ((!(paramObject instanceof JSONObject)) || (!((JSONObject)paramObject).has("t")));
    return true;
  }
  
  static <T> AnimatableValueParser<T> newInstance(@Nullable JSONObject paramJSONObject, float paramFloat, LottieComposition paramLottieComposition, AnimatableValue.Factory<T> paramFactory)
  {
    return new AnimatableValueParser(paramJSONObject, paramFloat, paramLottieComposition, paramFactory);
  }
  
  @Nullable
  private T parseInitialValue(List<Keyframe<T>> paramList)
  {
    if (this.json != null)
    {
      if (!paramList.isEmpty()) {
        return ((Keyframe)paramList.get(0)).startValue;
      }
      return this.valueFactory.valueFromObject(this.json.opt("k"), this.scale);
    }
    return null;
  }
  
  private List<Keyframe<T>> parseKeyframes()
  {
    if (this.json != null)
    {
      Object localObject = this.json.opt("k");
      if (hasKeyframes(localObject)) {
        return Keyframe.Factory.parseKeyframes((JSONArray)localObject, this.composition, this.scale, this.valueFactory);
      }
      return Collections.emptyList();
    }
    return Collections.emptyList();
  }
  
  Result<T> parseJson()
  {
    List localList = parseKeyframes();
    return new Result(localList, parseInitialValue(localList));
  }
  
  static class Result<T>
  {
    @Nullable
    final T initialValue;
    final List<Keyframe<T>> keyframes;
    
    Result(List<Keyframe<T>> paramList, @Nullable T paramT)
    {
      this.keyframes = paramList;
      this.initialValue = paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableValueParser
 * JD-Core Version:    0.7.0.1
 */