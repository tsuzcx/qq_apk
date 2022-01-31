package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.GradientColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnimatableGradientColorValue
  extends BaseAnimatableValue<GradientColor, GradientColor>
{
  private AnimatableGradientColorValue(List<Keyframe<GradientColor>> paramList, GradientColor paramGradientColor)
  {
    super(paramList, paramGradientColor);
  }
  
  public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new GradientColorKeyframeAnimation(this.keyframes);
  }
  
  public static final class Factory
  {
    public static AnimatableGradientColorValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, 1.0F, paramLottieComposition, new AnimatableGradientColorValue.ValueFactory(paramJSONObject.optInt("p", paramJSONObject.optJSONArray("k").length() / 4), null)).parseJson();
      paramLottieComposition = (GradientColor)paramJSONObject.initialValue;
      return new AnimatableGradientColorValue(paramJSONObject.keyframes, paramLottieComposition, null);
    }
  }
  
  private static class ValueFactory
    implements AnimatableValue.Factory<GradientColor>
  {
    private final int colorPoints;
    
    private ValueFactory(int paramInt)
    {
      this.colorPoints = paramInt;
    }
    
    private void addOpacityStopsToGradientIfNeeded(GradientColor paramGradientColor, JSONArray paramJSONArray)
    {
      int i = this.colorPoints * 4;
      if (paramJSONArray.length() <= i) {}
      for (;;)
      {
        return;
        int j = (paramJSONArray.length() - i) / 2;
        double[] arrayOfDouble1 = new double[j];
        double[] arrayOfDouble2 = new double[j];
        j = 0;
        if (i < paramJSONArray.length())
        {
          if (i % 2 == 0) {
            arrayOfDouble1[j] = paramJSONArray.optDouble(i);
          }
          for (;;)
          {
            i += 1;
            break;
            arrayOfDouble2[j] = paramJSONArray.optDouble(i);
            j += 1;
          }
        }
        i = 0;
        while (i < paramGradientColor.getSize())
        {
          j = paramGradientColor.getColors()[i];
          j = Color.argb(getOpacityAtPosition(paramGradientColor.getPositions()[i], arrayOfDouble1, arrayOfDouble2), Color.red(j), Color.green(j), Color.blue(j));
          paramGradientColor.getColors()[i] = j;
          i += 1;
        }
      }
    }
    
    @IntRange(from=0L, to=255L)
    private int getOpacityAtPosition(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    {
      int i = 1;
      while (i < paramArrayOfDouble1.length)
      {
        double d1 = paramArrayOfDouble1[(i - 1)];
        double d2 = paramArrayOfDouble1[i];
        if (paramArrayOfDouble1[i] >= paramDouble)
        {
          paramDouble = (paramDouble - d1) / (d2 - d1);
          return (int)(MiscUtils.lerp(paramArrayOfDouble2[(i - 1)], paramArrayOfDouble2[i], paramDouble) * 255.0D);
        }
        i += 1;
      }
      return (int)(255.0D * paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)]);
    }
    
    public GradientColor valueFromObject(Object paramObject, float paramFloat)
    {
      paramObject = (JSONArray)paramObject;
      float[] arrayOfFloat = new float[this.colorPoints];
      int[] arrayOfInt = new int[this.colorPoints];
      GradientColor localGradientColor = new GradientColor(arrayOfFloat, arrayOfInt);
      int j = 0;
      int k = 0;
      if (paramObject.length() != this.colorPoints * 4) {
        Log.w("LOTTIE", "Unexpected gradient length: " + paramObject.length() + ". Expected " + this.colorPoints * 4 + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
      }
      int i = 0;
      if (i < this.colorPoints * 4)
      {
        int m = i / 4;
        double d = paramObject.optDouble(i);
        switch (i % 4)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFloat[m] = ((float)d);
          continue;
          j = (int)(255.0D * d);
          continue;
          k = (int)(255.0D * d);
          continue;
          arrayOfInt[m] = Color.argb(255, j, k, (int)(255.0D * d));
        }
      }
      addOpacityStopsToGradientIfNeeded(localGradientColor, paramObject);
      return localGradientColor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue
 * JD-Core Version:    0.7.0.1
 */