package com.tencent.mobileqq.flashshow.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSCommentPanelPart$7
  implements View.OnClickListener
{
  FSCommentPanelPart$7(FSCommentPanelPart paramFSCommentPanelPart) {}
  
  public void onClick(View paramView)
  {
    FSCommentPanelPart.a(this.a).e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.7
 * JD-Core Version:    0.7.0.1
 */