package com.tencent.mobileqq.data.nativemonitor;

import ajop;
import amts;
import amtt;
import android.content.pm.ApplicationInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NativeMonitorConfigHelper$1$1
  implements Runnable
{
  public NativeMonitorConfigHelper$1$1(amtt paramamtt, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    String str3 = amts.a(localFile);
    long l = localFile.length();
    Object localObject2 = BaseApplicationImpl.getApplication();
    String str2 = ((BaseApplicationImpl)localObject2).getQQProcessName();
    Object localObject1 = ((BaseApplicationImpl)localObject2).getPackageName();
    String str1;
    if (str2.equals(localObject1))
    {
      str1 = "main";
      localObject2 = ((BaseApplicationImpl)localObject2).getApplicationInfo().nativeLibraryDir;
      localObject1 = "/data/data/" + (String)localObject1;
      str2 = this.a;
      if (!this.a.startsWith((String)localObject2)) {
        break label319;
      }
      str2 = this.a.substring(((String)localObject2).length());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NativeMonitorConfig", 2, "soPath: " + str2 + ", md5: " + str3 + ", len: " + l + ", proc: " + str1 + ", backtrace:\n" + this.b);
      }
      if (ajop.a())
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("so", localFile.getName());
        ((HashMap)localObject1).put("path", str2);
        ((HashMap)localObject1).put("md5", str3);
        ((HashMap)localObject1).put("len", String.valueOf(l));
        ((HashMap)localObject1).put("proc", str1);
        ((HashMap)localObject1).put("backtrace", this.b);
        UserAction.onUserAction("nativeMonitorOnSoLoad", true, -1L, -1L, (Map)localObject1, false);
      }
      return;
      str1 = str2;
      if (!str2.startsWith((String)localObject1)) {
        break;
      }
      str1 = str2.substring(((String)localObject1).length());
      break;
      label319:
      if (this.a.startsWith((String)localObject1)) {
        str2 = this.a.substring(((String)localObject1).length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper.1.1
 * JD-Core Version:    0.7.0.1
 */