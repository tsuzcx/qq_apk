package com.tencent.mobileqq.kandian.glue.viola.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ViolaBaseView$MyHandler
  extends Handler
{
  public ViolaBaseView$MyHandler(ViolaBaseView paramViolaBaseView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        ViolaBaseView.c(this.a);
        return;
      }
      ViolaBaseView.a(this.a, true);
      ViolaBaseView.j(this.a);
      return;
    }
    ViolaBaseView.j(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.MyHandler
 * JD-Core Version:    0.7.0.1
 */