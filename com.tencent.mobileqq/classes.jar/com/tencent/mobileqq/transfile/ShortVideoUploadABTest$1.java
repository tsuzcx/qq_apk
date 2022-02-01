package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

final class ShortVideoUploadABTest$1
  implements Runnable
{
  ShortVideoUploadABTest$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    ShortVideoUploadABTest.doSendABTestMessage(this.val$app, BaseApplication.getContext(), this.val$aioSessionInfo, this.val$sb.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadABTest.1
 * JD-Core Version:    0.7.0.1
 */