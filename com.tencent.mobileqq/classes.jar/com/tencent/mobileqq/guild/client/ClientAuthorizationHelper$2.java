package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class ClientAuthorizationHelper$2
  implements IGetAppRoleListCallback
{
  ClientAuthorizationHelper$2(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams) {}
  
  public void a(int paramInt, String paramString1, String paramString2, List<IGProRoleInfo> paramList, String paramString3, String paramString4)
  {
    if (paramInt != 0)
    {
      QQGuildUtil.c(this.a.getString(2131890522));
      QLog.e("ClientAuthorizationUtils", 1, String.format("requestClientRoleList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
      return;
    }
    QLog.i("ClientAuthorizationUtils", 1, "requestClientRoleList success");
    if (paramList.isEmpty())
    {
      QQGuildUtil.c(this.a.getString(2131890359));
      return;
    }
    if (paramList.size() == 1)
    {
      ClientAuthorizationHelper.a(this.a, this.b, (IGProRoleInfo)paramList.get(0));
      return;
    }
    paramString1 = new GuildClientSelectRoleDialogParams(this.b).a(new GuildClientRoleInfo(paramList, paramString3)).a();
    GuildClientSelectRoleDialogFragment.a(this.a, null, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.ClientAuthorizationHelper.2
 * JD-Core Version:    0.7.0.1
 */