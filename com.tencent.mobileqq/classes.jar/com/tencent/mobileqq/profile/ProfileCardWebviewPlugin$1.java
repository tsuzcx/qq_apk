package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.util.URLUtil;

class ProfileCardWebviewPlugin$1
  extends BroadcastReceiver
{
  ProfileCardWebviewPlugin$1(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = this.a.mRuntime.d();
    if (paramContext != null)
    {
      if (paramContext.isFinishing()) {
        return;
      }
      paramIntent = this.a.mRuntime.a(this.a.mRuntime.d());
      if ((paramIntent != null) && ((paramIntent instanceof WebUiUtils.WebUiMethodInterface)))
      {
        paramIntent = ((WebUiUtils.WebUiMethodInterface)paramIntent).getCurrentUrl();
        if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.contains("entryId"))) {
          this.a.a = URLUtil.a(URLUtil.a(paramIntent), "entryId", 2);
        } else {
          this.a.a = 2;
        }
      }
      paramContext.finish();
      paramContext = new AllInOne(this.a.mRuntime.b().getCurrentAccountUin(), 0);
      paramContext = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.a.mRuntime.d(), paramContext);
      if (this.a.a == 0) {
        paramContext.setFlags(67108864);
      }
      this.a.mRuntime.d().startActivity(paramContext);
      paramContext = new Intent();
      paramContext.putExtra("closeSpecialLogic", true);
      this.a.mRuntime.d().setResult(-1, paramContext);
      this.a.mRuntime.d().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardWebviewPlugin.1
 * JD-Core Version:    0.7.0.1
 */