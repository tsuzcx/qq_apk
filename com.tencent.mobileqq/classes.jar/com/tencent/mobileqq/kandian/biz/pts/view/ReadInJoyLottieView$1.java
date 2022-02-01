package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyLottieView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyLottieView$1(ReadInJoyLottieView paramReadInJoyLottieView) {}
  
  public void onGlobalLayout()
  {
    if ((ReadInJoyLottieView.a(this.a).isShown()) && (!ReadInJoyLottieView.b(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      ReadInJoyLottieView.a(this.a, true);
    }
    if ((!ReadInJoyLottieView.a(this.a).isShown()) && (ReadInJoyLottieView.b(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      ReadInJoyLottieView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView.1
 * JD-Core Version:    0.7.0.1
 */