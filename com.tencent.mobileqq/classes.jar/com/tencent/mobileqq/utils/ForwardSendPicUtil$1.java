package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;

final class ForwardSendPicUtil$1
  implements Runnable
{
  ForwardSendPicUtil$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.a;
      int i = this.b;
      QQAppInterface localQQAppInterface = this.c;
      StatisticConstants.a(new String[] { str }, i, false, true, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ForwardSendPicUtil.1
 * JD-Core Version:    0.7.0.1
 */