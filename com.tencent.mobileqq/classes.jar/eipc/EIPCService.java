package eipc;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public abstract class EIPCService
  extends AppService
{
  protected EIPCServer mServer;
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onBind. " + this);
    }
    return this.mServer.a(paramIntent);
  }
  
  protected int onConfigRuntime()
  {
    return 1;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, getClass().getSimpleName() + ".onCreate");
    }
    super.onCreate();
    this.mServer = onCreateSingleServer();
  }
  
  public abstract EIPCServer onCreateSingleServer();
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onDestroy." + this);
    }
    this.mServer = null;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onUnbind." + this);
    }
    return this.mServer.b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCService
 * JD-Core Version:    0.7.0.1
 */