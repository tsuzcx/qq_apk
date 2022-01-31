package eipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

class EIPCClient$1
  implements ServiceConnection
{
  EIPCClient$1(EIPCClient paramEIPCClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      try
      {
        if ((paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
        {
          Object localObject = EIPCChannel.Stub.asInterface(paramIBinder);
          int i = ((EIPCChannel)localObject).setClient(MobileQQ.processName, Process.myPid(), this.a.channel, this.a.c);
          paramComponentName = ((EIPCChannel)localObject).getProcName();
          this.a.d = new EIPCConnection((EIPCChannel)localObject, ((EIPCChannel)localObject).getProcName());
          this.a.d.e = i;
          this.a.d.c = this.a;
          this.a.d.a = "EIPCServer";
          localObject = this.a.guardServerProcList.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (TextUtils.equals(paramComponentName, (String)((Iterator)localObject).next()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("EIPCConst", 2, MobileQQ.processName + " guard " + paramComponentName);
              }
              paramComponentName = new EIPCClient.ClientDeathRecipient();
              paramComponentName.eipcClient = this.a;
              paramComponentName.binder = paramIBinder;
              paramComponentName.connection = this.a.d;
              paramIBinder.linkToDeath(paramComponentName, 0);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("EIPCConst", 2, "EIPCClient onServiceConnected success, " + this.a.d);
          }
          paramComponentName = this.a.e.iterator();
          while (paramComponentName.hasNext())
          {
            paramIBinder = (EIPClientConnectListener)paramComponentName.next();
            if (paramIBinder != null) {
              paramIBinder.connectSuccess(this.a.d);
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break label357;
        }
      }
      catch (Exception paramComponentName)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EIPCConst", 2, "EIPCClient onServiceConnected but failed", paramComponentName);
        }
      }
    } else {
      QLog.d("EIPCConst", 2, "EIPCClient onServiceConnected but failed");
    }
    label357:
    paramComponentName = this.a.e.iterator();
    while (paramComponentName.hasNext())
    {
      paramIBinder = (EIPClientConnectListener)paramComponentName.next();
      if (paramIBinder != null)
      {
        paramIBinder.connectFailed();
        continue;
        this.a.e.clear();
        this.a.notifyBind(this.a.d);
        return;
      }
    }
    this.a.e.clear();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "EIPCClient onServiceDisconnected");
    }
    paramComponentName = this.a.d;
    if (paramComponentName != null)
    {
      paramComponentName.b = false;
      this.a.notifyUnbind(paramComponentName);
    }
    this.a.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCClient.1
 * JD-Core Version:    0.7.0.1
 */