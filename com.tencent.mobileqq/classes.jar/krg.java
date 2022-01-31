import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.gdt.qq_ad_get.QQAdGet;

public class krg
{
  private static krg a;
  
  public static krg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new krg();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, AppRuntime paramAppRuntime, qq_ad_get.QQAdGet paramQQAdGet, BusinessObserver paramBusinessObserver)
  {
    paramContext = new NewIntent(BaseApplicationImpl.getApplication(), krh.class);
    paramContext.setObserver(paramBusinessObserver);
    paramContext.putExtra("GdtLoadAdServletCMD", "QqAd.getAd");
    paramContext.putExtra("sso_GdtLoadAd_rquest_bytes", paramQQAdGet.toByteArray());
    paramAppRuntime.startServlet(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     krg
 * JD-Core Version:    0.7.0.1
 */