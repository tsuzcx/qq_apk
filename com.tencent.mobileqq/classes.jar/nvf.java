import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class nvf
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public nvf(CustomTabView paramCustomTabView) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("EcshopCustomTabView", 2, "onLaunchResult" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvf
 * JD-Core Version:    0.7.0.1
 */