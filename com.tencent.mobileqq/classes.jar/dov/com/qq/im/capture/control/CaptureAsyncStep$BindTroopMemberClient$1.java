package dov.com.qq.im.capture.control;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import dov.com.qq.im.capture.QIMManager;

class CaptureAsyncStep$BindTroopMemberClient$1
  implements TroopMemberApiClient.Callback
{
  CaptureAsyncStep$BindTroopMemberClient$1(CaptureAsyncStep.BindTroopMemberClient paramBindTroopMemberClient) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nickName");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      AppInterface localAppInterface = QIMManager.a();
      if ((localAppInterface instanceof PeakAppInterface)) {
        ((PeakAppInterface)localAppInterface).a(paramBundle);
      }
      this.a.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.BindTroopMemberClient.1
 * JD-Core Version:    0.7.0.1
 */