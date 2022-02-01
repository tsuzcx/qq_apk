package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class QQGamePubHeaderFactory
{
  public static IHeaderView a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQGameMsgInfo == null) {}
      try
      {
        return new MoreMsgHeaderView(paramActivity);
      }
      catch (Throwable paramQQGameMsgInfo)
      {
        QLog.d("QQGamePubHeaderFactory", 4, "decode header(web) faile:" + paramQQGameMsgInfo.getMessage());
        return null;
      }
      if (paramQQGameMsgInfo.msgType == 1)
      {
        paramQQGameMsgInfo = new GameArkView(paramActivity, null);
        return paramQQGameMsgInfo;
      }
      if (paramQQGameMsgInfo.msgType == 2) {
        return new ImgHeaderView(paramActivity);
      }
      if (paramQQGameMsgInfo.msgType == 3) {
        return new TextHeaderView(paramActivity);
      }
      paramQQGameMsgInfo = new MoreMsgHeaderView(paramActivity);
      return paramQQGameMsgInfo;
    }
    QLog.d("QQGamePubHeaderFactory", 4, "createHeader fail activity is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGamePubHeaderFactory
 * JD-Core Version:    0.7.0.1
 */