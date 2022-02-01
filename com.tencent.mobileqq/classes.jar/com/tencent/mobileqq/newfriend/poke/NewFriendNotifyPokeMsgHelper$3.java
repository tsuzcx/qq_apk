package com.tencent.mobileqq.newfriend.poke;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class NewFriendNotifyPokeMsgHelper$3
  implements OnCompositionLoadedListener
{
  NewFriendNotifyPokeMsgHelper$3(int paramInt1, int paramInt2, int paramInt3, Context paramContext, String paramString, NewFriendNotifyPokeMsgHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = ViewUtils.dpToPx(this.a);
    int j = ViewUtils.dpToPx(this.b);
    if (paramLottieComposition == null)
    {
      QLog.w("NewFriendNotifyPokeMsgHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(this.c);
    ((LottieDrawable)localObject).setImageAssetDelegate(new NewFriendNotifyPokeMsgHelper.3.1(this));
    ThreadManager.getUIHandler().post(new NewFriendNotifyPokeMsgHelper.3.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */