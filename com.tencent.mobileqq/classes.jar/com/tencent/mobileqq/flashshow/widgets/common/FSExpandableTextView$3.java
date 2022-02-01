package com.tencent.mobileqq.flashshow.widgets.common;

import com.tencent.qphone.base.util.QLog;

class FSExpandableTextView$3
  implements Runnable
{
  FSExpandableTextView$3(FSExpandableTextView paramFSExpandableTextView) {}
  
  public void run()
  {
    FSExpandableTextView localFSExpandableTextView = this.this$0;
    localFSExpandableTextView.k = (localFSExpandableTextView.getHeight() - this.this$0.a.getHeight());
    localFSExpandableTextView = this.this$0;
    localFSExpandableTextView.j = (FSExpandableTextView.a(localFSExpandableTextView, localFSExpandableTextView.a, this.this$0.c) + this.this$0.k);
    QLog.d("FSExpandableTextView", 1, new Object[] { "onMeasure isCollapsed == false lastHeight: ", Integer.valueOf(this.this$0.k), " | collapsedHeight: ", Integer.valueOf(this.this$0.j) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSExpandableTextView.3
 * JD-Core Version:    0.7.0.1
 */