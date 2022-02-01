package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;

class FrameworkHandler$3
  implements View.OnClickListener
{
  FrameworkHandler$3(FrameworkHandler paramFrameworkHandler) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.3
 * JD-Core Version:    0.7.0.1
 */