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
        if (paramQQVipMsgInfo.mMsgType == 1) {
          return new QQVipArkHeaderView(paramActivity, null);
        }
        if (paramQQVipMsgInfo.mMsgType == 2) {
          return new ImgHeaderView(paramActivity);
        }
        if (paramQQVipMsgInfo.mMsgType == 3) {
          return new TextHeaderView(paramActivity);
        }
        paramQQVipMsgInfo = new MoreMsgHeaderView(paramActivity);
        return paramQQVipMsgInfo;
      }
      catch (Throwable paramQQVipMsgInfo)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("decode header(web) faile:");
        paramActivity.append(paramQQVipMsgInfo.getMessage());
        QLog.d("QQVipPubHeaderFactory", 4, paramActivity.toString());
        return null;
      }
    }
    QLog.d("QQVipPubHeaderFactory", 4, "createHeader fail activity is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipPubHeaderFactory
 * JD-Core Version:    0.7.0.1
 */