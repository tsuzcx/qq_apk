package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onPlayRepeat"}, k=3, mv={1, 1, 16})
final class RIJCoinAnimationUtils$addApngListener$1
  implements ApngDrawable.OnPlayRepeatListener
{
  public static final 1 a = new 1();
  
  public final void onPlayRepeat(int paramInt)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJCoinAnimationUtils.addApngListener.1.1(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils.addApngListener.1
 * JD-Core Version:    0.7.0.1
 */