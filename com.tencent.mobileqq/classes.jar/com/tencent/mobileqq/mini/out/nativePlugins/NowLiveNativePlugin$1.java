package com.tencent.mobileqq.mini.out.nativePlugins;

import aaea;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class NowLiveNativePlugin$1
  implements aaea
{
  NowLiveNativePlugin$1(NowLiveNativePlugin paramNowLiveNativePlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowLiveNativePlugin.access$002(this.this$0, paramBundle.getInt("state"));
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveNativePlugin", 2, "TroopMemberApiClient.Callback | plugin state: " + NowLiveNativePlugin.access$100(this.this$0));
      }
    }
    do
    {
      do
      {
        return;
      } while (i != 91);
      i = paramBundle.getInt("errCode");
      paramBundle = paramBundle.getString("desc");
    } while (!QLog.isColorLevel());
    QLog.d("NowLiveNativePlugin", 2, "TroopMemberApiClient.Callback | errCode=" + i + ", desc=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin.1
 * JD-Core Version:    0.7.0.1
 */