package com.tencent.mobileqq.servlet;

import android.os.Build;
import android.os.Build.VERSION;
import azbq;
import azbr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;

public final class LoginVerifyServlet$3
  implements Runnable
{
  public LoginVerifyServlet$3(String paramString1, String paramString2, String paramString3, azbr paramazbr) {}
  
  public void run()
  {
    try
    {
      Object localObject5 = new URL(this.jdField_a_of_type_JavaLangString);
      Object localObject1 = new azbq(this, (URL)localObject5);
      Object localObject2 = (HttpsURLConnection)((URL)localObject5).openConnection();
      ((HttpsURLConnection)localObject2).setHostnameVerifier((HostnameVerifier)localObject1);
      ((HttpsURLConnection)localObject2).setConnectTimeout(10000);
      ((HttpsURLConnection)localObject2).setReadTimeout(30000);
      ((HttpsURLConnection)localObject2).setDoOutput(true);
      ((HttpsURLConnection)localObject2).setDoInput(true);
      ((HttpsURLConnection)localObject2).setUseCaches(false);
      ((HttpsURLConnection)localObject2).setRequestMethod("POST");
      ((HttpsURLConnection)localObject2).setRequestProperty("Connection", "Keep-Alive");
      ((HttpsURLConnection)localObject2).setRequestProperty("User-Agent", "android" + "_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE + "_" + "8.3.5" + "_" + "QQ/" + "8.3.54555");
      ((HttpsURLConnection)localObject2).setRequestProperty("Accept", "*/*");
      ((HttpsURLConnection)localObject2).setRequestProperty("Content-Type", this.b);
      localObject1 = ((HttpsURLConnection)localObject2).getOutputStream();
      ((OutputStream)localObject1).write(this.c.getBytes());
      ((OutputStream)localObject1).flush();
      ((OutputStream)localObject1).close();
      ((HttpsURLConnection)localObject2).connect();
      int i = ((HttpsURLConnection)localObject2).getResponseCode();
      localObject1 = ((HttpsURLConnection)localObject2).getResponseMessage();
      QLog.d("LoginVerifyServlet", 1, "code : " + i + " message : " + (String)localObject1 + " url : " + localObject5);
      if (i == 200)
      {
        localObject1 = new ByteArrayOutputStream();
        localObject2 = ((HttpsURLConnection)localObject2).getInputStream();
        localObject5 = new byte[1024];
        for (;;)
        {
          i = ((InputStream)localObject2).read((byte[])localObject5);
          if (i == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject5, 0, i);
        }
      }
      byte[] arrayOfByte;
      boolean bool;
      ThreadManager.getUIHandler().post(new LoginVerifyServlet.3.2(this, false, (String)localObject1));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localObject2 = localMalformedURLException.getMessage();
      localObject1 = localObject2;
      try
      {
        QLog.e("LoginVerifyServlet", 1, "get AppConfig MalformedURLException : " + localMalformedURLException.getMessage());
        ThreadManager.getUIHandler().post(new LoginVerifyServlet.3.2(this, false, (String)localObject2));
        return;
      }
      finally
      {
        break label500;
      }
      arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      ((ByteArrayOutputStream)localObject1).close();
      ((InputStream)localObject2).close();
      localObject1 = new String(arrayOfByte);
      for (bool = true;; bool = false)
      {
        ThreadManager.getUIHandler().post(new LoginVerifyServlet.3.2(this, bool, (String)localObject1));
        return;
      }
    }
    catch (IOException localIOException)
    {
      localObject2 = localIOException.getMessage();
      localObject1 = localObject2;
      QLog.e("LoginVerifyServlet", 1, "get AppConfig IOException : " + localIOException.getMessage());
      ThreadManager.getUIHandler().post(new LoginVerifyServlet.3.2(this, false, (String)localObject2));
      return;
    }
    finally
    {
      localObject1 = null;
    }
    label500:
    throw localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.LoginVerifyServlet.3
 * JD-Core Version:    0.7.0.1
 */