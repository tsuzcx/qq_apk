package com.tencent.mobileqq.webprocess;

import android.text.TextUtils;
import bdhb;
import bdrh;
import bdrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class WebProcessManager$6
  implements Runnable
{
  WebProcessManager$6(List paramList) {}
  
  public void run()
  {
    try
    {
      if (WebProcessManager.a() == -1)
      {
        Object localObject = new File(BaseApplicationImpl.getContext().getFilesDir(), bdrh.e.a);
        if ((localObject == null) || (!((File)localObject).exists()))
        {
          WebProcessManager.a(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessManager", 2, "null == file || !file.exists() = true,return!");
          return;
        }
        localObject = bdhb.a((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          WebProcessManager.a(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessManager", 2, "TextUtils.isEmpty(JsonStr) = true,return!");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("WebProcessManager", 2, "UnKnownHost Exception!", localException);
        return;
        if (new JSONObject(localException).getBoolean("use_dns")) {}
        for (int i = 1;; i = 0)
        {
          WebProcessManager.a(i);
          if (QLog.isColorLevel()) {
            QLog.i("WebProcessManager", 2, "isNeedPreparseDns :" + WebProcessManager.a());
          }
          if (WebProcessManager.a() != 1) {
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
            WebProcessManager.d(str, l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.6
 * JD-Core Version:    0.7.0.1
 */