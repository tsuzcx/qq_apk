package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildRouterApiImpl$1
  implements IGetUserInfoCallback
{
  QQGuildRouterApiImpl$1(QQGuildRouterApiImpl paramQQGuildRouterApiImpl, int paramInt1, AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if ((paramList != null) && (paramList.size() != 0)) {
      paramString = (IGProUserInfo)paramList.get(0);
    } else {
      paramString = null;
    }
    paramList = new StringBuilder();
    paramList.append("openGuildMemberCard onFetchUserInfo ,userInfo:");
    paramList.append(paramString);
    paramList.append(",finalSelfType:");
    paramList.append(this.a);
    QLog.i("QQGuildRouterApiImpl", 1, paramList.toString());
    QQGuildUtil.a(this.b, this.c, this.d, paramString, this.e, this.f, this.g, this.a, paramInt, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildRouterApiImpl.1
 * JD-Core Version:    0.7.0.1
 */