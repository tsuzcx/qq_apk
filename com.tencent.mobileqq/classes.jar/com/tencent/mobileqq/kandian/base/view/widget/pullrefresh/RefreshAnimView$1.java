package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

class RefreshAnimView$1
  implements Runnable
{
  RefreshAnimView$1(RefreshAnimView paramRefreshAnimView, Context paramContext) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.a, "readinjoy_refresh_animation.json", new RefreshAnimView.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RefreshAnimView", 2, "fromAssetFileName", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView.1
 * JD-Core Version:    0.7.0.1
 */