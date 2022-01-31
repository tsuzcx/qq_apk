package com.tencent.mobileqq.dinifly.value;

import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback
  extends LottieValueCallback<Integer>
{
  public Integer getOffset(LottieFrameInfo<Integer> paramLottieFrameInfo)
  {
    if (this.value == null) {
      throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
    return (Integer)this.value;
  }
  
  public Integer getValue(LottieFrameInfo<Integer> paramLottieFrameInfo)
  {
    return Integer.valueOf(MiscUtils.lerp(((Integer)paramLottieFrameInfo.getStartValue()).intValue(), ((Integer)paramLottieFrameInfo.getEndValue()).intValue(), paramLottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(paramLottieFrameInfo).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieRelativeIntegerValueCallback
 * JD-Core Version:    0.7.0.1
 */