import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.gdt.qq_ad_get.QQAdGet;

public class lao
{
  private static lao a;
  
  public static lao a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lao();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, AppRuntime paramAppRuntime, qq_ad_get.QQAdGet paramQQAdGet, BusinessObserver paramBusinessObserver)
  {
    paramContext = new NewIntent(BaseApplicationImpl.getApplication(), lap.class);
    paramContext.setObserver(paramBusinessObserver);
    paramContext.putExtra("GdtLoadAdServletCMD", "QqAd.getAd");
    paramContext.putExtra("sso_GdtLoadAd_rquest_bytes", paramQQAdGet.toByteArray());
    paramAppRuntime.startServlet(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lao
 * JD-Core Version:    0.7.0.1
 */