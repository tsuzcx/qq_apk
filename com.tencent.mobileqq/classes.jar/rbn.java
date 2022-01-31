import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.OnGetAppInfo;

public class rbn
  implements DefaultDoraemonAppInfoHelper.OnGetAppInfo
{
  public rbn(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager) {}
  
  public void a(AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      DefaultDoraemonAPIManager.a(this.a, paramAppInfo);
      DefaultDoraemonAPIManager.a(this.a, true);
      return;
    }
    DefaultDoraemonAPIManager.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbn
 * JD-Core Version:    0.7.0.1
 */