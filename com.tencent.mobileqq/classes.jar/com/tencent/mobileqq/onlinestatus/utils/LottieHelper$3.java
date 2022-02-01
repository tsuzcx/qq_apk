package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class LottieHelper$3
  implements OnCompositionLoadedListener
{
  LottieHelper$3(int paramInt1, int paramInt2, int paramInt3, String paramString, Context paramContext, LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = ViewUtils.dpToPx(this.a);
    int j = ViewUtils.dpToPx(this.b);
    if (paramLottieComposition == null)
    {
      QLog.w("onlinestate.LottieHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(this.c);
    if (this.d != null) {
      ((LottieDrawable)localObject).setImageAssetDelegate(new LottieHelper.3.1(this));
    }
    ThreadManager.getUIHandler().post(new LottieHelper.3.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.3
 * JD-Core Version:    0.7.0.1
 */