package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ProfileCardMoreActivity$20
  implements IResultWithSecurityCallback
{
  ProfileCardMoreActivity$20(ProfileCardMoreActivity paramProfileCardMoreActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    QLog.e("IphoneTitleBarActivity", 1, new Object[] { "onSetGuildUserTypeResult result:", Integer.valueOf(paramInt), ", errMsg:", paramString });
    this.c.k();
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult)))
    {
      paramString = this.c;
      if (this.a) {
        paramInt = 2131916305;
      } else {
        paramInt = 2131917754;
      }
      paramString.notifyUser(paramInt, 2);
      return;
    }
    paramString = (IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class);
    BaseApplication localBaseApplication1 = BaseApplication.getContext();
    BaseApplication localBaseApplication2 = BaseApplication.getContext();
    int i;
    if (this.a) {
      i = 2131916304;
    } else {
      i = 2131917753;
    }
    paramString.toastErrorAndSecurity(localBaseApplication1, paramInt, localBaseApplication2.getString(i), paramIGProSecurityResult);
    this.c.r.setOnCheckedChangeListener(null);
    this.c.r.setChecked(this.b ^ true);
    this.c.r.setOnCheckedChangeListener(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.20
 * JD-Core Version:    0.7.0.1
 */