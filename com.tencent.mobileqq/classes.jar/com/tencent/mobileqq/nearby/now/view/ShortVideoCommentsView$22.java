package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ShortVideoCommentsView$22
  implements Runnable
{
  ShortVideoCommentsView$22(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    if ((ShortVideoCommentsView.access$1800(this.this$0) != null) && (ShortVideoCommentsView.access$1800(this.this$0).getChildCount() > 0))
    {
      if (ShortVideoCommentsView.access$1800(this.this$0).getChildAt(0).getTop() != 0)
      {
        ShortVideoCommentsView.access$1800(this.this$0).setSelection(0);
        ThreadManager.getUIHandler().postDelayed(this, 10L);
        return;
      }
      ThreadManager.getUIHandler().removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.22
 * JD-Core Version:    0.7.0.1
 */