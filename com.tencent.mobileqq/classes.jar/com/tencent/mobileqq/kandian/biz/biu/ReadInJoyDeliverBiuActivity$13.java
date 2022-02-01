package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInJoyDeliverBiuActivity$13
  extends FriendListObserver
{
  ReadInJoyDeliverBiuActivity$13(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is success ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new ReadInJoyDeliverBiuActivity.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.13
 * JD-Core Version:    0.7.0.1
 */