package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class QQVipPubHeaderFactory
{
  public static IHeaderView a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQVipMsgInfo == null) {
        return new MoreMsgHeaderView(paramActivity);
      }
      try
      {
        if (paramQQVipMsgInfo.msgType == 1)
        {
          paramQQVipMsgInfo = new QQVipArkHeaderView(paramActivity, null);
          return paramQQVipMsgInfo;
        }
      }
      catch (Throwable paramQQVipMsgInfo)
      {
        QLog.d("QQVipPubHeaderFactory", 4, "decode header(web) faile:" + paramQQVipMsgInfo.getMessage());
        return null;
      }
      if (paramQQVipMsgInfo.msgType == 2) {
        return new ImgHeaderView(paramActivity);
      }
      if (paramQQVipMsgInfo.msgType == 3) {
        return new TextHeaderView(paramActivity);
      }
      paramQQVipMsgInfo = new MoreMsgHeaderView(paramActivity);
      return paramQQVipMsgInfo;
    }
    QLog.d("QQVipPubHeaderFactory", 4, "createHeader fail activity is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipPubHeaderFactory
 * JD-Core Version:    0.7.0.1
 */