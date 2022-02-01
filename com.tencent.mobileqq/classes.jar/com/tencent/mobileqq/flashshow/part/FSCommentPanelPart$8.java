package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView.IStatusListener;
import com.tencent.qphone.base.util.QLog;

class FSCommentPanelPart$8
  implements FSSlidBottomView.IStatusListener
{
  FSCommentPanelPart$8(FSCommentPanelPart paramFSCommentPanelPart) {}
  
  public void a()
  {
    QLog.d("FSC-FSCommentPanelPart", 1, "[onShow] current slid view show.");
  }
  
  public void a(int paramInt)
  {
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[onStatusChange] status: ", Integer.valueOf(paramInt) });
  }
  
  public void b()
  {
    QLog.d("FSC-FSCommentPanelPart", 1, "[onDismiss] current slid view dismiss.");
    FSCommentPanelPart localFSCommentPanelPart = this.a;
    FSCommentPanelPart.a(localFSCommentPanelPart, FSCommentPanelPart.b(localFSCommentPanelPart), 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.8
 * JD-Core Version:    0.7.0.1
 */