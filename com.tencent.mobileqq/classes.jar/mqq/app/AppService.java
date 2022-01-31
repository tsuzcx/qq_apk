package mqq.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AppService
  extends Service
{
  protected static final int CONFIG_NEED_RUNTIME = 0;
  protected static final int CONFIG_NO_NEED_RUNTIME = 1;
  protected AppRuntime app;
  
  public String getModuleId()
  {
    return null;
  }
  
  public void onAccountChanged() {}
  
  public void onAccoutChangeFailed() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected int onConfigRuntime()
  {
    return 0;
  }
  
  public void onConfigStartMode(Intent paramIntent) {}
  
  public void onCreate()
  {
    super.onCreate();
    Intent localIntent = new Intent();
    onConfigStartMode(localIntent);
    MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    if (onConfigRuntime() == 0) {
      this.app = MobileQQ.getMobileQQ().waitAppRuntime(null).getAppRuntime(getModuleId());
    }
    MobileQQ.sMobileQQ.appServices.add(new WeakReference(this));
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime.getAppRuntime(getModuleId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppService
 * JD-Core Version:    0.7.0.1
 */