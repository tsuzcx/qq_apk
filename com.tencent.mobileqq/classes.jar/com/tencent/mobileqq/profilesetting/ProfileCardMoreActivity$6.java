package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ProfileCardMoreActivity$6
  implements IResultWithSecurityCallback
{
  ProfileCardMoreActivity$6(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    this.a.k();
    QLog.e("IphoneTitleBarActivity", 1, new Object[] { "onRemoveGuildResult item_remove_group result:", this.a.E, ", errMsg:", paramString });
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult)))
    {
      this.a.notifyUser(2131915679, 2);
      if (this.a.E == null) {
        this.a.E = new Intent();
      }
      this.a.E.putExtra("guild_user_allow_admin", false);
      paramString = this.a;
      paramString.setResult(-1, paramString.E);
      if (this.a.b.extras.getInt("guild_open_robot_type") == 1)
      {
        ProfileCardMoreActivity.a(this.a, false);
        return;
      }
      this.a.finish();
      return;
    }
    ((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).toastErrorAndSecurity(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131915678), paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.6
 * JD-Core Version:    0.7.0.1
 */