package com.tencent.mobileqq.flashshow.widgets;

import com.tencent.qphone.base.util.QLog;

class FSDoubleClickLayout$2
  implements Runnable
{
  FSDoubleClickLayout$2(FSDoubleClickLayout paramFSDoubleClickLayout) {}
  
  public void run()
  {
    if (FSDoubleClickLayout.d(this.this$0) != null)
    {
      FSDoubleClickLayout.d(this.this$0).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLongClick:");
      localStringBuilder.append(FSDoubleClickLayout.a(this.this$0));
      QLog.d("FSDoubleClickLayout", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSDoubleClickLayout.2
 * JD-Core Version:    0.7.0.1
 */