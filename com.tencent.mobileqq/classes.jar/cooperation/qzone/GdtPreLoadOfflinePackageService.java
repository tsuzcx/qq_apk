package cooperation.qzone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZLog;

public class GdtPreLoadOfflinePackageService
  extends Service
{
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      String str = paramIntent.getStringExtra("url");
      if (!TextUtils.isEmpty(str)) {
        try
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          HtmlOffline.a();
          HtmlOffline.a(str, localBaseApplicationImpl.getRuntime());
        }
        catch (Exception localException)
        {
          QZLog.e("GdtPreLoadOfflinePackageService", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.GdtPreLoadOfflinePackageService
 * JD-Core Version:    0.7.0.1
 */