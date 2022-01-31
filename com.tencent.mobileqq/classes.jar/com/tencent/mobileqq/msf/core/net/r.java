package com.tencent.mobileqq.msf.core.net;

import android.content.res.AssetManager;
import android.os.Environment;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;

class r
  extends Thread
{
  r(m paramm) {}
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "start tcpdump now");
    }
    for (;;)
    {
      try
      {
        localObject5 = BaseApplication.getContext().getAssets();
        localObject4 = null;
        localObject1 = null;
        localObject3 = localObject4;
      }
      catch (Exception localException2)
      {
        Object localObject5;
        Object localObject4;
        Object localObject1;
        Object localObject3;
        int j;
        int i;
        int k;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump: readLine Exception" + localException2);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump started Sleep for 10 minutes");
        this.a.B = System.currentTimeMillis();
        Thread.sleep(a.aB());
        localException2.close();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump end Sleep for 10 minutes");
        m.k();
        this.a.z = true;
        return;
        continue;
        if (localObject3 != null) {
          continue;
        }
      }
      try
      {
        localObject5 = ((AssetManager)localObject5).list("");
        localObject3 = localObject4;
        j = localObject5.length;
        i = 0;
        localObject3 = localObject1;
        if (i >= j) {
          continue;
        }
        localObject4 = localObject5[i];
        localObject3 = localObject1;
        k = ((String)localObject4).indexOf("tcpdump");
        if (k == -1) {
          continue;
        }
        localObject1 = localObject4;
        i += 1;
        continue;
        BaseApplication.getContext().getDir("assets", 0).toString();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    localObject2 = new StringBuilder();
    m.a(BaseApplication.getContext());
    new ProcessBuilder(new String[0]).command(new String[] { "chmod", "777", BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump" }).redirectErrorStream(true).start();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "start tcpdump");
    }
    ((StringBuilder)localObject2).setLength(0);
    localObject3 = BaseApplication.getContext().getPackageName();
    localObject3 = Environment.getExternalStorageDirectory().getPath() + "/tencent/" + ((String)localObject3).replace(".", "/") + "/";
    localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    localObject4 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append((String)localObject4);
    ((StringBuilder)localObject2).append(".pcap");
    try
    {
      localObject2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "su", "-c", BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump  -p -l -vv -i any -s 0 -w " + localObject2 }).getErrorStream()));
      if (!((BufferedReader)localObject2).readLine().toLowerCase().contains("syntax error")) {
        break label511;
      }
      ((BufferedReader)localObject2).close();
      return;
    }
    catch (IOException localIOException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
    }
    QLog.d("MSF.C.NetConnTag", 2, "Error running tcpdump, msg=" + localIOException.getMessage());
    return;
    label511:
  }
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.r
 * JD-Core Version:    0.7.0.1
 */