package com.tencent.mobileqq.onlinestatus.utils;

import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class LottieHelper$1
  implements OnCompositionLoadedListener
{
  LottieHelper$1(int paramInt1, int paramInt2, String paramString, LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.w("onlinestate.LottieHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
    {
      paramLottieComposition = paramLottieComposition.getBounds();
      int i = ViewUtils.b(this.jdField_a_of_type_Int);
      int j = ViewUtils.b(this.b);
      localLottieDrawable.setScale(i / paramLottieComposition.width(), j / paramLottieComposition.height());
    }
    localLottieDrawable.setRepeatCount(0);
    localLottieDrawable.setImageAssetDelegate(new LottieHelper.1.1(this));
    ThreadManager.getUIHandler().post(new LottieHelper.1.2(this, localLottieDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.1
 * JD-Core Version:    0.7.0.1
 */