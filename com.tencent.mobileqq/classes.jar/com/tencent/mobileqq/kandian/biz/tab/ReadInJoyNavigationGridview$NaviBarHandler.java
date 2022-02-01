package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoyNavigationGridview$NaviBarHandler
  extends Handler
{
  private WeakReference<ReadInJoyNavigationGridview> a;
  
  public ReadInJoyNavigationGridview$NaviBarHandler(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview)
  {
    this.a = new WeakReference(paramReadInJoyNavigationGridview);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyNavigationGridview localReadInJoyNavigationGridview = (ReadInJoyNavigationGridview)this.a.get();
    if (localReadInJoyNavigationGridview != null)
    {
      if (ReadInJoyNavigationGridview.b(localReadInJoyNavigationGridview)) {
        return;
      }
      if (paramMessage.what != 1) {
        return;
      }
      ReadInJoyNavigationGridview.c(localReadInJoyNavigationGridview);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview.NaviBarHandler
 * JD-Core Version:    0.7.0.1
 */