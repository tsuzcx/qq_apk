package com.tencent.mobileqq.data.nativemonitor;

import android.content.pm.ApplicationInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class NativeMonitorConfigHelper$1$1
  implements Runnable
{
  NativeMonitorConfigHelper$1$1(NativeMonitorConfigHelper.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    String str = NativeMonitorConfigHelper.a(localFile);
    long l = localFile.length();
    Object localObject4 = BaseApplicationImpl.getApplication();
    Object localObject2 = ((BaseApplicationImpl)localObject4).getQQProcessName();
    Object localObject3 = ((BaseApplicationImpl)localObject4).getPackageName();
    Object localObject1;
    if (((String)localObject2).equals(localObject3))
    {
      localObject1 = "main";
    }
    else
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith((String)localObject3)) {
        localObject1 = ((String)localObject2).substring(((String)localObject3).length());
      }
    }
    localObject4 = ((BaseApplicationImpl)localObject4).getApplicationInfo().nativeLibraryDir;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("/data/data/");
    ((StringBuilder)localObject2).append((String)localObject3);
    localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = this.a;
    if (((String)localObject2).startsWith((String)localObject4)) {
      localObject2 = this.a.substring(((String)localObject4).length());
    } else if (this.a.startsWith((String)localObject3)) {
      localObject2 = this.a.substring(((String)localObject3).length());
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("soPath: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", md5: ");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(", len: ");
      ((StringBuilder)localObject3).append(l);
      ((StringBuilder)localObject3).append(", proc: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(", backtrace:\n");
      ((StringBuilder)localObject3).append(this.b);
      QLog.i("NativeMonitorConfig", 2, ((StringBuilder)localObject3).toString());
    }
    if (PrivacyPolicyHelper.a())
    {
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("so", localFile.getName());
      ((HashMap)localObject3).put("path", localObject2);
      ((HashMap)localObject3).put("md5", str);
      ((HashMap)localObject3).put("len", String.valueOf(l));
      ((HashMap)localObject3).put("proc", localObject1);
      ((HashMap)localObject3).put("backtrace", this.b);
      UserAction.onUserAction("nativeMonitorOnSoLoad", true, -1L, -1L, (Map)localObject3, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper.1.1
 * JD-Core Version:    0.7.0.1
 */