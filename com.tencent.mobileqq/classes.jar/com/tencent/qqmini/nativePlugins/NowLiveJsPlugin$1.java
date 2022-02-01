package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class NowLiveJsPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  NowLiveJsPlugin$1(NowLiveJsPlugin paramNowLiveJsPlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowLiveJsPlugin.a(this.a, paramBundle.getInt("state"));
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("TroopMemberApiClient.Callback | plugin state: ");
        paramBundle.append(NowLiveJsPlugin.a(this.a));
        QLog.d("NowLiveJsPlugin", 2, paramBundle.toString());
      }
    }
    else if (i == 91)
    {
      i = paramBundle.getInt("errCode");
      paramBundle = paramBundle.getString("desc");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TroopMemberApiClient.Callback | errCode=");
        localStringBuilder.append(i);
        localStringBuilder.append(", desc=");
        localStringBuilder.append(paramBundle);
        QLog.d("NowLiveJsPlugin", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.NowLiveJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */