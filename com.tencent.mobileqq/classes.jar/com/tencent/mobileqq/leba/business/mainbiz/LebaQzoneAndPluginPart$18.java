package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$18
  extends ExtendFriendObserver
{
  LebaQzoneAndPluginPart$18(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    QLog.i("LebaBusinessPartImpl", 1, "ExtendFriendObserver onUpdateRedPoint " + paramInt);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.18
 * JD-Core Version:    0.7.0.1
 */