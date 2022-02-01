package com.tencent.mobileqq.flashshow.view.refresh;

import android.widget.TextView;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer.OnRefreshLoadViewStatusListener;
import com.tencent.qphone.base.util.QLog;

class FSLayerRefreshHeaderView$1
  implements Runnable
{
  FSLayerRefreshHeaderView$1(FSLayerRefreshHeaderView paramFSLayerRefreshHeaderView) {}
  
  public void run()
  {
    FSLayerRefreshHeaderView.a(this.this$0).setVisibility(8);
    FSLayerRefreshHeaderView.b(this.this$0).b();
    FSLayerRefreshHeaderView.b(this.this$0).setVisibility(8);
    this.this$0.invalidate();
    if (FSLayerRefreshHeaderView.c(this.this$0) != null) {
      FSLayerRefreshHeaderView.c(this.this$0).b(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onComplete");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.FSLayerRefreshHeaderView.1
 * JD-Core Version:    0.7.0.1
 */