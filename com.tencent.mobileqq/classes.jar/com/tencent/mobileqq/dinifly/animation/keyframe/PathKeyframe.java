package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.Keyframe.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import com.tencent.mobileqq.dinifly.utils.Utils;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathKeyframe
  extends Keyframe<PointF>
{
  @Nullable
  private Path path;
  
  private PathKeyframe(LottieComposition paramLottieComposition, @Nullable PointF paramPointF1, @Nullable PointF paramPointF2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    super(paramLottieComposition, paramPointF1, paramPointF2, paramInterpolator, paramFloat, paramFloat1);
  }
  
  @Nullable
  Path getPath()
  {
    return this.path;
  }
  
  public static class Factory
  {
    public static PathKeyframe newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition, AnimatableValue.Factory<PointF> paramFactory)
    {
      Keyframe localKeyframe = Keyframe.Factory.newInstance(paramJSONObject, paramLottieComposition, paramLottieComposition.getDpScale(), paramFactory);
      Object localObject1 = null;
      Object localObject2 = null;
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("ti");
      JSONArray localJSONArray2 = paramJSONObject.optJSONArray("to");
      paramFactory = localObject1;
      paramJSONObject = localObject2;
      if (localJSONArray1 != null)
      {
        paramFactory = localObject1;
        paramJSONObject = localObject2;
        if (localJSONArray2 != null)
        {
          paramFactory = JsonUtils.pointFromJsonArray(localJSONArray2, paramLottieComposition.getDpScale());
          paramJSONObject = JsonUtils.pointFromJsonArray(localJSONArray1, paramLottieComposition.getDpScale());
        }
      }
      paramLottieComposition = new PathKeyframe(paramLottieComposition, (PointF)localKeyframe.startValue, (PointF)localKeyframe.endValue, localKeyframe.interpolator, localKeyframe.startFrame, localKeyframe.endFrame, null);
      if ((localKeyframe.endValue != null) && (localKeyframe.startValue != null) && (((PointF)localKeyframe.startValue).equals(((PointF)localKeyframe.endValue).x, ((PointF)localKeyframe.endValue).y))) {}
      for (int i = 1;; i = 0)
      {
        if ((paramLottieComposition.endValue != null) && (i == 0) && (localKeyframe.startValue != null)) {
          PathKeyframe.access$102(paramLottieComposition, Utils.createPath((PointF)localKeyframe.startValue, (PointF)localKeyframe.endValue, paramFactory, paramJSONObject));
        }
        return paramLottieComposition;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe
 * JD-Core Version:    0.7.0.1
 */