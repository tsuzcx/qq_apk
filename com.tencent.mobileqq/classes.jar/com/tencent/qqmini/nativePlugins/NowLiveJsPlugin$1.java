package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;

class NowLiveJsPlugin$1
  implements TroopMemberApiClient.Callback
{
  NowLiveJsPlugin$1(NowLiveJsPlugin paramNowLiveJsPlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      NowLiveJsPlugin.a(this.a, paramBundle.getInt("state"));
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | plugin state: " + NowLiveJsPlugin.a(this.a));
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
    QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | errCode=" + i + ", desc=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.NowLiveJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */