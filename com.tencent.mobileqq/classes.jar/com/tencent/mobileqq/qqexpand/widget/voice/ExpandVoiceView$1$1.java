package com.tencent.mobileqq.qqexpand.widget.voice;

import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ExpandVoiceView$1$1
  implements OnCompositionLoadedListener
{
  ExpandVoiceView$1$1(ExpandVoiceView.1 param1, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int m = this.jdField_a_of_type_Int;
    int k = this.b;
    int j = m;
    int i = k;
    if (ExpandVoiceView.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView$1.this$0) == 2)
    {
      j = (int)(m * 0.8F);
      i = (int)(k * 0.8F);
    }
    if (paramLottieComposition == null)
    {
      QLog.e("ExtendFriendVoiceView", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = j / ((Rect)localObject).width();
    float f2 = i / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(true);
    ExpandVoiceView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView$1.this$0, (LottieDrawable)localObject);
    ThreadManager.getUIHandler().post(new ExpandVoiceView.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.1.1
 * JD-Core Version:    0.7.0.1
 */