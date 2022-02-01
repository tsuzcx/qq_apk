package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.SignatureObserver;

class IndividualityRemoteCommandHandler$3
  extends SignatureObserver
{
  IndividualityRemoteCommandHandler$3(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 0);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 1);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler.3
 * JD-Core Version:    0.7.0.1
 */