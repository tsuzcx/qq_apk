package eipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qphone.base.util.QLog;

public class EIPCClient$ClientDeathRecipient
  implements IBinder.DeathRecipient
{
  public IBinder binder;
  public EIPCConnection connection;
  public EIPCClient eipcClient;
  
  public void binderDied()
  {
    Object localObject = this.eipcClient;
    if (localObject != null) {
      ((EIPCClient)localObject).connect(new EIPCClient.ClientDeathRecipient.1(this));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("client binderDied, ");
      ((StringBuilder)localObject).append(this.connection);
      QLog.d("EIPCConst", 2, ((StringBuilder)localObject).toString());
    }
    this.binder.unlinkToDeath(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCClient.ClientDeathRecipient
 * JD-Core Version:    0.7.0.1
 */