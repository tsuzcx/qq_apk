package com.tencent.mobileqq.dinifly;

import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;

final class DiniFlyAnimationView$1
  implements LottieListener<Throwable>
{
  public void onResult(Throwable paramThrowable)
  {
    if (Utils.isNetworkException(paramThrowable))
    {
      Logger.warning("Unable to load composition.", paramThrowable);
      return;
    }
    throw new IllegalStateException("Unable to parse composition", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView.1
 * JD-Core Version:    0.7.0.1
 */