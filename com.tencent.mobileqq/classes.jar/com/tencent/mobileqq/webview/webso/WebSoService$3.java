package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class WebSoService$3
  implements Runnable
{
  WebSoService$3(WebSoService paramWebSoService, File paramFile, String paramString, WebSoService.CallBack paramCallBack, Uri paramUri) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = FileUtils.readFileToString(this.a);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("readFileToString cost=");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("WebSoService", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        l = System.currentTimeMillis();
        if (SHA1Util.a((String)localObject).equals(this.b))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("verify html success cost=");
            localStringBuilder.append(System.currentTimeMillis() - l);
            QLog.d("WebSoService", 2, localStringBuilder.toString());
          }
          this.c.a((String)localObject);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("verify html fail cost=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          QLog.d("WebSoService", 2, ((StringBuilder)localObject).toString());
        }
        WebSoUtils.f(this.d);
        this.c.a("");
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("verify load data exception=");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.d("WebSoService", 2, localStringBuilder.toString());
      }
      this.c.a("");
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deal eTag exception=");
        localStringBuilder.append(localIOException.getMessage());
        QLog.d("WebSoService", 2, localStringBuilder.toString());
      }
      WebSoUtils.f(this.d);
      this.c.a("");
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.3
 * JD-Core Version:    0.7.0.1
 */