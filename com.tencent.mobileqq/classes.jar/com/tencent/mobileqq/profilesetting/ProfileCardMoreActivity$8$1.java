package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ProfileCardMoreActivity$8$1
  implements IResultWithSecurityCallback
{
  ProfileCardMoreActivity$8$1(ProfileCardMoreActivity.8 param8) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    this.a.b.k();
    QLog.e("IphoneTitleBarActivity", 1, new Object[] { "onRemoveGuildResult item_exit_guild errorCode:", Integer.valueOf(paramInt), ", errMsg:", paramString });
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult)))
    {
      this.a.b.notifyUser(2131889059, 2);
      if (this.a.b.E == null) {
        this.a.b.E = new Intent();
      }
      this.a.b.E.putExtra("finchat", true);
      this.a.b.setResult(-1, this.a.b.E);
      this.a.b.finish();
      return;
    }
    ((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).toastErrorAndSecurity(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131889058), paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.8.1
 * JD-Core Version:    0.7.0.1
 */