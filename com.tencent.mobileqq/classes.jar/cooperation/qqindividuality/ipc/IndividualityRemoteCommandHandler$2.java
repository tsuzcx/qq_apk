package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.ConfigObserver;

class IndividualityRemoteCommandHandler$2
  extends ConfigObserver
{
  IndividualityRemoteCommandHandler$2(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("result", paramInt);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler.2
 * JD-Core Version:    0.7.0.1
 */