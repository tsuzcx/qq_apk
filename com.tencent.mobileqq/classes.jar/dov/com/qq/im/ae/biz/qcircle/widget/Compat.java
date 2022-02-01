package dov.com.qq.im.ae.biz.qcircle.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

class Compat
{
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      b(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
  
  @TargetApi(16)
  private static void b(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.Compat
 * JD-Core Version:    0.7.0.1
 */