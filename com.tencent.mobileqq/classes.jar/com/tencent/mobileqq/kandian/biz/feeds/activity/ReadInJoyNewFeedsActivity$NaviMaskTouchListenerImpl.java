package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoyNewBaseActivity;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview.NaviMaskTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoyNewFeedsActivity$NaviMaskTouchListenerImpl
  implements ReadInJoyNavigationGridview.NaviMaskTouchListener
{
  private WeakReference<ReadInJoyNewBaseActivity> a;
  
  ReadInJoyNewFeedsActivity$NaviMaskTouchListenerImpl(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity)
  {
    this.a = new WeakReference(paramReadInJoyNewBaseActivity);
  }
  
  public void a()
  {
    ReadInJoyNewFeedsActivity localReadInJoyNewFeedsActivity = (ReadInJoyNewFeedsActivity)this.a.get();
    if (localReadInJoyNewFeedsActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "NaviMaskTouchListenerImpl. activity has destoryed");
      }
      return;
    }
    if ((ReadInJoyNewFeedsActivity.c(localReadInJoyNewFeedsActivity) == 0) && (localReadInJoyNewFeedsActivity.e != null)) {
      localReadInJoyNewFeedsActivity.e.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.NaviMaskTouchListenerImpl
 * JD-Core Version:    0.7.0.1
 */