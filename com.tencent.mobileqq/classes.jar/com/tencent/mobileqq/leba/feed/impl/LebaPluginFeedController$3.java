package com.tencent.mobileqq.leba.feed.impl;

import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;

class LebaPluginFeedController$3
  extends ResourcePluginListener
{
  LebaPluginFeedController$3(LebaPluginFeedController paramLebaPluginFeedController) {}
  
  public void a(byte paramByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResourcePluginListener listener notify = ");
    localStringBuilder.append(paramByte);
    QLog.i("LebaPluginFeedController", 1, localStringBuilder.toString());
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedController.3
 * JD-Core Version:    0.7.0.1
 */