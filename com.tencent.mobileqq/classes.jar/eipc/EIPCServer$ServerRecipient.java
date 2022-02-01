package eipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class EIPCServer$ServerRecipient
  implements IBinder.DeathRecipient
{
  public IBinder binder;
  public EIPCConnection connection;
  public EIPCServer eipcServer;
  
  public void binderDied()
  {
    synchronized (this.eipcServer.clients)
    {
      if (this.eipcServer.clients.remove(this.connection)) {
        this.eipcServer.notifyUnbind(this.connection);
      }
      this.binder.unlinkToDeath(this, 0);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("ServerRecipient ");
        ((StringBuilder)???).append(this.connection);
        QLog.d("EIPCConst", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     eipc.EIPCServer.ServerRecipient
 * JD-Core Version:    0.7.0.1
 */