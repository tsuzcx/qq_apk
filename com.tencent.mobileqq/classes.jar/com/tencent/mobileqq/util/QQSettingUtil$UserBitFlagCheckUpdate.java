package com.tencent.mobileqq.util;

import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQSettingUtil$UserBitFlagCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public QQSettingUtil$UserBitFlagCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 106;
    UserBitFlagReq localUserBitFlagReq = new UserBitFlagReq();
    localUserBitFlagReq.cEmotionMall = 0;
    localUserBitFlagReq.cMyWallet = ((byte)QQSettingUtil.a(this.a));
    localUserBitFlagReq.cPtt2Text = 0;
    localUserBitFlagReq.cAccout2Dis = 0;
    localReqItem.vecParam = localUserBitFlagReq.toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.eServiceID == 106)
    {
      UserBitFlagRes localUserBitFlagRes = new UserBitFlagRes();
      localUserBitFlagRes.readFrom(new JceInputStream(paramRespItem.vecUpdate));
      int i = localUserBitFlagRes.cEmotionMall;
      int j = localUserBitFlagRes.cMyWallet;
      int k = localUserBitFlagRes.cAccout2Dis;
      if (QLog.isColorLevel())
      {
        paramRespItem = new StringBuilder();
        paramRespItem.append("vEmotion=");
        paramRespItem.append(i);
        paramRespItem.append(",cMyWallet=");
        paramRespItem.append(j);
        paramRespItem.append(",cPtt2Text=");
        paramRespItem.append(localUserBitFlagRes.cPtt2Text);
        paramRespItem.append(" ,cAccout2Dis=");
        paramRespItem.append(k);
        QLog.d("QQSetting", 2, paramRespItem.toString());
      }
      paramRespItem = this.a;
      if (paramRespItem != null)
      {
        paramRespItem = paramRespItem.getApp().getApplicationContext();
        Object localObject = this.a.getCurrentAccountUin();
        boolean bool = false;
        paramRespItem.getSharedPreferences((String)localObject, 0).edit().putInt("mywallet_flag", j).putInt("select_member_contacts_flag", k).commit();
        paramRespItem = (ISttManagerApi)QRoute.api(ISttManagerApi.class);
        localObject = this.a;
        if (localUserBitFlagRes.cPtt2Text == 1) {
          bool = true;
        }
        paramRespItem.setSttAbility((AppRuntime)localObject, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil.UserBitFlagCheckUpdate
 * JD-Core Version:    0.7.0.1
 */