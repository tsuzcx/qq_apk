package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;

class IndividualityRemoteCommandHandler$1
  extends UniPayHandler.UniPayUpdateListener
{
  IndividualityRemoteCommandHandler$1(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  public void a()
  {
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 2, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler.1
 * JD-Core Version:    0.7.0.1
 */