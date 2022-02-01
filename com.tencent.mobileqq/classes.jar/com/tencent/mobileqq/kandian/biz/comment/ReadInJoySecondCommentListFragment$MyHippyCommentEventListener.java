package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

class ReadInJoySecondCommentListFragment$MyHippyCommentEventListener
  extends TKDHippy2NativeEventSimpleReceiver
{
  private ReadInJoySecondCommentListFragment$MyHippyCommentEventListener(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onCommentViewLayout()
  {
    RecyclerView localRecyclerView = (RecyclerView)TKDTuWenCommentUtil.rFindView(this.a.getView(), HippyTKDListView.class);
    ReadInJoySecondCommentListFragment.c(this.a).setRecyclerView(localRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment.MyHippyCommentEventListener
 * JD-Core Version:    0.7.0.1
 */