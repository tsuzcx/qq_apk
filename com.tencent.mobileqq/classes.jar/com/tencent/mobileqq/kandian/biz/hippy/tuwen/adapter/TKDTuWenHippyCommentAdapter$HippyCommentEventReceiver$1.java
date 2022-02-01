package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import android.os.MessageQueue.IdleHandler;
import android.widget.ListAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView;
import com.tencent.widget.ListView;

class TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver$1
  implements MessageQueue.IdleHandler
{
  TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver$1(TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver paramHippyCommentEventReceiver) {}
  
  public boolean queueIdle()
  {
    this.this$1.this$0.vList.smoothScrollToPosition(this.this$1.this$0.vList.getAdapter().getCount() - 1);
    if (TKDTuWenHippyCommentAdapter.access$800(this.this$1.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$800(this.this$1.this$0).scrollBy(0, -TKDTuWenHippyCommentAdapter.access$800(this.this$1.this$0).getOffsetY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver.1
 * JD-Core Version:    0.7.0.1
 */