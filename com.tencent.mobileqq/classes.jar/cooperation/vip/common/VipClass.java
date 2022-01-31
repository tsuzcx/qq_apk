package cooperation.vip.common;

import android.app.Activity;
import bgpp;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

public class VipClass
  extends bgpp
{
  private static VipClass a = new VipClass();
  
  public static VipClass getInstance()
  {
    return a;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    MiniAppLauncher.startMiniApp(paramActivity, paramString, 2004, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.common.VipClass
 * JD-Core Version:    0.7.0.1
 */