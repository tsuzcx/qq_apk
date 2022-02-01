package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$18
  extends ExpandObserver
{
  LebaQzoneAndPluginPart$18(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExpandObserver onUpdateRedPoint ");
    localStringBuilder.append(paramInt);
    QLog.i("LebaBusinessPartImpl", 1, localStringBuilder.toString());
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.18
 * JD-Core Version:    0.7.0.1
 */