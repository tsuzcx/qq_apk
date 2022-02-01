package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.sveffects.SLog;

class QQMTVFilter$2
  implements Runnable
{
  QQMTVFilter$2(QQMTVFilter paramQQMTVFilter) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset:");
    localStringBuilder.append(QQMTVFilter.access$100(this.this$0));
    SLog.d("QQMTVFilter", localStringBuilder.toString());
    QQMTVFilter.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMTVFilter.2
 * JD-Core Version:    0.7.0.1
 */