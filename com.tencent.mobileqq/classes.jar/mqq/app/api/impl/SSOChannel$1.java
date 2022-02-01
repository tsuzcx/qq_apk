package mqq.app.api.impl;

import com.tencent.qphone.base.util.QLog;
import mqq.app.api.SSOResponse;
import mqq.app.api.SSOResultCallback;

class SSOChannel$1
  implements Runnable
{
  SSOChannel$1(SSOChannel paramSSOChannel, SSOResponse paramSSOResponse, String paramString, SSOResultCallback paramSSOResultCallback) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      if (this.val$response == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = this.val$response.isSuc.booleanValue();; bool = false)
    {
      QLog.d(".SSOChannel", 2, String.format("notifyResult, cmd: %s, isSuc: %s", new Object[] { this.val$cmd, Boolean.valueOf(bool) }));
      this.val$result.callback(this.val$response);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.api.impl.SSOChannel.1
 * JD-Core Version:    0.7.0.1
 */