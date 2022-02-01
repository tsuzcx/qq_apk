package cooperation.qappcenter.remote;

import android.os.RemoteException;
import blxr;
import blxv;

public class RemoteServiceProxy$3
  implements Runnable
{
  public RemoteServiceProxy$3(blxv paramblxv, SendMsg paramSendMsg) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a != null)
      {
        this.this$0.a.a(this.a);
        return;
      }
      try
      {
        RecvMsg localRecvMsg = this.this$0.a(this.a, "main thread sendMsgToServiceFailed. serviceHandler is null.");
        this.this$0.a(this.a, localRecvMsg);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy.3
 * JD-Core Version:    0.7.0.1
 */