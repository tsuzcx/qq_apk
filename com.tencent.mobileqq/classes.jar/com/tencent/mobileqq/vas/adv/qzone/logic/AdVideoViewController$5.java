package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;

class AdVideoViewController$5
  implements Runnable
{
  AdVideoViewController$5(AdVideoViewController paramAdVideoViewController, String paramString) {}
  
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
          QZLog.i("AdVideoView", ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        if (QZLog.isColorLevel()) {
          QZLog.w("AdVideoView", 2, new Object[] { localException.toString() });
        }
      }
      return;
      label166:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.5
 * JD-Core Version:    0.7.0.1
 */