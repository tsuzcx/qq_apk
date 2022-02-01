package com.tencent.mobileqq.webview.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class WebProcessPreloadImpl$1
  implements Runnable
{
  WebProcessPreloadImpl$1(WebProcessPreloadImpl paramWebProcessPreloadImpl, List paramList) {}
  
  public void run()
  {
    try
    {
      if (WebProcessPreloadImpl.access$000() == -1)
      {
        Object localObject = ((IWebviewApi)QRoute.api(IWebviewApi.class)).getDnsFileName();
        localObject = new File(MobileQQ.getContext().getFilesDir(), (String)localObject);
        if (!((File)localObject).exists())
        {
          WebProcessPreloadImpl.access$002(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessStartServiceImpl", 2, "null == file || !file.exists() = true,return!");
          return;
        }
        localObject = FileUtils.a((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          WebProcessPreloadImpl.access$002(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessStartServiceImpl", 2, "TextUtils.isEmpty(JsonStr) = true,return!");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("WebProcessStartServiceImpl", 2, "UnKnownHost Exception!", localException);
        return;
        if (new JSONObject(localException).getBoolean("use_dns")) {}
        for (int i = 1;; i = 0)
        {
          WebProcessPreloadImpl.access$002(i);
          if (QLog.isColorLevel()) {
            QLog.i("WebProcessStartServiceImpl", 2, "isNeedPreparseDns :" + WebProcessPreloadImpl.access$000());
          }
          if (WebProcessPreloadImpl.access$000() != 1) {
            break;
          }
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            long l = System.currentTimeMillis();
            InetAddress.getByName(str);
            l = System.currentTimeMillis() - l;
            if (QLog.isColorLevel()) {
              QLog.i("WebStatusReport", 2, "time used:" + l);
            }
            WebProcessPreloadImpl.access$100(str, l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl.1
 * JD-Core Version:    0.7.0.1
 */