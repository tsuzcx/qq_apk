package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class NowLiveNativePlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  NowLiveNativePlugin$1(NowLiveNativePlugin paramNowLiveNativePlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowLiveNativePlugin.access$002(this.this$0, paramBundle.getInt("state"));
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("TroopMemberApiClient.Callback | plugin state: ");
        paramBundle.append(NowLiveNativePlugin.access$100(this.this$0));
        QLog.d("NowLiveNativePlugin", 2, paramBundle.toString());
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
        QLog.d("NowLiveNativePlugin", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin.1
 * JD-Core Version:    0.7.0.1
 */