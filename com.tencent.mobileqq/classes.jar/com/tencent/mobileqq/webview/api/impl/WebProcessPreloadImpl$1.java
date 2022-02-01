package com.tencent.mobileqq.webview.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
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
    for (;;)
    {
      try
      {
        Object localObject;
        if (WebProcessPreloadImpl.access$000() == -1)
        {
          localObject = ClubContentJsonTask.e.a;
          localObject = new File(MobileQQ.getContext().getFilesDir(), (String)localObject);
          if (!((File)localObject).exists())
          {
            WebProcessPreloadImpl.access$002(-1);
            if (QLog.isColorLevel()) {
              QLog.i("WebProcessStartServiceImpl", 2, "null == file || !file.exists() = true,return!");
            }
          }
          else
          {
            localObject = FileUtils.readFileContent((File)localObject);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              WebProcessPreloadImpl.access$002(-1);
              if (!QLog.isColorLevel()) {
                break label291;
              }
              QLog.i("WebProcessStartServiceImpl", 2, "TextUtils.isEmpty(JsonStr) = true,return!");
              return;
            }
            if (!new JSONObject((String)localObject).getBoolean("use_dns")) {
              break label292;
            }
            i = 1;
            WebProcessPreloadImpl.access$002(i);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isNeedPreparseDns :");
            ((StringBuilder)localObject).append(WebProcessPreloadImpl.access$000());
            QLog.i("WebProcessStartServiceImpl", 2, ((StringBuilder)localObject).toString());
          }
          if (WebProcessPreloadImpl.access$000() == 1)
          {
            localObject = this.a.iterator();
            if (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              long l = System.currentTimeMillis();
              InetAddress.getByName(str);
              l = System.currentTimeMillis() - l;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("time used:");
                localStringBuilder.append(l);
                QLog.i("WebStatusReport", 2, localStringBuilder.toString());
              }
              WebProcessPreloadImpl.access$100(str, l);
              continue;
            }
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebProcessStartServiceImpl", 2, "UnKnownHost Exception!", localException);
        }
      }
      return;
      label291:
      return;
      label292:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl.1
 * JD-Core Version:    0.7.0.1
 */