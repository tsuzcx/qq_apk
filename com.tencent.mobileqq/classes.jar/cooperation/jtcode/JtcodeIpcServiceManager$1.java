package cooperation.jtcode;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class JtcodeIpcServiceManager$1
  extends ResultReceiver
{
  JtcodeIpcServiceManager$1(JtcodeIpcServiceManager paramJtcodeIpcServiceManager, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.jtcode.JtcodeIpcServiceManager.1
 * JD-Core Version:    0.7.0.1
 */