package com.tencent.mobileqq.flashshow.widgets;

import com.tencent.qphone.base.util.QLog;

class FSDoubleClickLayout$1
  implements Runnable
{
  FSDoubleClickLayout$1(FSDoubleClickLayout paramFSDoubleClickLayout) {}
  
  public void run()
  {
    FSDoubleClickLayout.a(this.this$0, false);
    if ((FSDoubleClickLayout.a(this.this$0) >= 2) && (FSDoubleClickLayout.b(this.this$0) != null))
    {
      FSDoubleClickLayout.b(this.this$0).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoubleClick:");
      localStringBuilder.append(FSDoubleClickLayout.a(this.this$0));
      QLog.d("FSDoubleClickLayout", 1, localStringBuilder.toString());
    }
    if (FSDoubleClickLayout.a(this.this$0) == 1) {
      FSDoubleClickLayout.c(this.this$0);
    }
    FSDoubleClickLayout.a(this.this$0, 0);
    FSDoubleClickLayout.a(this.this$0, null);
    FSDoubleClickLayout.b(this.this$0, null);
    FSDoubleClickLayout.c(this.this$0, null);
    FSDoubleClickLayout.d(this.this$0, null);
    FSDoubleClickLayout.e(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSDoubleClickLayout.1
 * JD-Core Version:    0.7.0.1
 */