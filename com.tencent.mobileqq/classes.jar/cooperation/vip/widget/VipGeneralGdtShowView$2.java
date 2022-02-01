package cooperation.vip.widget;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;

class VipGeneralGdtShowView$2
  implements Runnable
{
  VipGeneralGdtShowView$2(VipGeneralGdtShowView paramVipGeneralGdtShowView, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(this.a)) {
          return;
        }
        Object localObject = (HttpURLConnection)new URL(this.a).openConnection();
        ((HttpURLConnection)localObject).setRequestMethod("POST");
        ((HttpURLConnection)localObject).setConnectTimeout(10000);
        ((HttpURLConnection)localObject).setReadTimeout(10000);
        ((HttpURLConnection)localObject).setUseCaches(false);
        ((HttpURLConnection)localObject).connect();
        int i = ((HttpURLConnection)localObject).getResponseCode();
        if (i != 200) {
          break label166;
        }
        bool = true;
        if (QZLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@getGdtInfo exporsure rspCode ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("， request thirdparty");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(" url =");
          ((StringBuilder)localObject).append(this.a);
          QZLog.i("VipGeneralGdtShowView", ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        if (QZLog.isColorLevel()) {
          QZLog.w("VipGeneralGdtShowView", 2, new Object[] { localException.toString() });
        }
      }
      return;
      label166:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.2
 * JD-Core Version:    0.7.0.1
 */