package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

class KanDianViewController$4
  implements Runnable
{
  KanDianViewController$4(KanDianViewController paramKanDianViewController, int paramInt) {}
  
  public void run()
  {
    if (((KanDianViewController.a(this.this$0) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.a(this.this$0).a() == 0))
    {
      ListView localListView = ((ReadInJoyListViewGroup)KanDianViewController.a(this.this$0)).a();
      if (localListView != null)
      {
        localListView.setInterpolator(new AccelerateDecelerateInterpolator());
        localListView.smoothScrollToPositionFromTop(this.a + localListView.getHeaderViewsCount(), (int)KanDianViewController.a(this.this$0, localListView, this.a), 200);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[scrollListToPos] pos = ");
        localStringBuilder.append(this.a);
        QLog.i("KanDianViewController", 1, localStringBuilder.toString());
      }
      ThreadManager.getUIHandler().postDelayed(new KanDianViewController.4.1(this, localListView), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.4
 * JD-Core Version:    0.7.0.1
 */