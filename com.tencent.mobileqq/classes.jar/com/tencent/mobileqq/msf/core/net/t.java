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

class t
  extends Thread
{
  t(n paramn) {}
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "start tcpdump now");
    }
    Object localObject3;
    label638:
    do
    {
      try
      {
        localObject1 = BaseApplication.getContext().getAssets();
        try
        {
          localObject4 = ((AssetManager)localObject1).list("");
          int j = localObject4.length;
          localObject1 = null;
          int i = 0;
          for (;;)
          {
            Object localObject2 = localObject1;
            if (i >= j) {
              break label638;
            }
            localObject2 = localObject4[i];
            try
            {
              int k = localObject2.indexOf("tcpdump");
              if (k != -1) {
                localObject1 = localObject2;
              }
              i += 1;
            }
            catch (Exception localException2) {}
          }
          localException3.printStackTrace();
        }
        catch (Exception localException3)
        {
          localObject1 = null;
        }
        localObject3 = localObject1;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("tcpdump: readLine Exception");
        ((StringBuilder)localObject3).append(localException1);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject3).toString());
        return;
      }
      BaseApplication.getContext().getDir("assets", 0).toString();
      localObject1 = new StringBuilder();
      n.a(BaseApplication.getContext());
      localObject3 = new ProcessBuilder(new String[0]);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(BaseApplication.getContext().getFilesDir().getParent());
      ((StringBuilder)localObject4).append("/txlib/tcpdump");
      ((ProcessBuilder)localObject3).command(new String[] { "chmod", "777", ((StringBuilder)localObject4).toString() }).redirectErrorStream(true).start();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "start tcpdump");
      }
      ((StringBuilder)localObject1).setLength(0);
      localObject3 = BaseApplication.getContext().getPackageName();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject4).append("/tencent/");
      ((StringBuilder)localObject4).append(((String)localObject3).replace(".", "/"));
      ((StringBuilder)localObject4).append("/");
      localObject3 = ((StringBuilder)localObject4).toString();
      localObject4 = new File((String)localObject3);
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdirs();
      }
      localObject4 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append((String)localObject4);
      ((StringBuilder)localObject1).append(".pcap");
      try
      {
        localObject3 = Runtime.getRuntime();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(BaseApplication.getContext().getFilesDir().getParent());
        ((StringBuilder)localObject4).append("/txlib/tcpdump  -p -l -vv -i any -s 0 -w ");
        ((StringBuilder)localObject4).append(localObject1);
        localObject1 = new BufferedReader(new InputStreamReader(((Runtime)localObject3).exec(new String[] { "su", "-c", ((StringBuilder)localObject4).toString() }).getErrorStream()));
        if (((BufferedReader)localObject1).readLine().toLowerCase().contains("syntax error"))
        {
          ((BufferedReader)localObject1).close();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump started Sleep for 10 minutes");
        }
        n.a(this.a, System.currentTimeMillis());
        Thread.sleep(a.aC());
        ((BufferedReader)localObject1).close();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump end Sleep for 10 minutes");
        }
        n.p();
        n.b(this.a, true);
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Error running tcpdump, msg=");
          ((StringBuilder)localObject3).append(localIOException.getMessage());
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
    } while (localObject3 != null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.t
 * JD-Core Version:    0.7.0.1
 */