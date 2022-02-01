package cooperation.vip.manager;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class CommonRequestManager$1
  implements Runnable
{
  CommonRequestManager$1(CommonRequestManager paramCommonRequestManager, Intent paramIntent) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), this.this$0.getClass());
    localNewIntent.putExtras(this.a);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.manager.CommonRequestManager.1
 * JD-Core Version:    0.7.0.1
 */