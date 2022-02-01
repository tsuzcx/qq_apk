package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class LocalDataJsPlugin$1
  extends DownloadListener
{
  LocalDataJsPlugin$1(LocalDataJsPlugin paramLocalDataJsPlugin) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sigTplResDownloadListener.onDone| task:");
      ((StringBuilder)localObject1).append(paramDownloadTask);
      QLog.d("LocalDataJsPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramDownloadTask.a();
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sigTplResDownloadListener.onDone error no params: ");
      ((StringBuilder)localObject1).append(paramDownloadTask);
      QLog.e("LocalDataJsPlugin", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    String str2 = ((Bundle)localObject1).getString("callbackId");
    String str1 = ((Bundle)localObject1).getString("itemId");
    Object localObject4 = ((Bundle)localObject1).getString("localRules");
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (TextUtils.isDigitsOnly(str1)))
    {
      if ((3 != paramDownloadTask.a()) && (paramDownloadTask.a() != 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sigTpl download fail status = ");
        ((StringBuilder)localObject1).append(paramDownloadTask.a());
        ((StringBuilder)localObject1).append(" itemId = ");
        ((StringBuilder)localObject1).append(str1);
        QLog.e("LocalDataJsPlugin", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = new File(SignatureTemplateConfig.a(str1, "dynamic_aio"));
      if (DownloaderFactory.a(new File(SignatureTemplateConfig.a(str1, "temp.zip")), (File)localObject1, true))
      {
        Object localObject3 = null;
        localObject1 = localObject3;
        Object localObject2;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject1 = new JSONObject((String)localObject4);
          }
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("sigTplResDownloadListener error: ");
          ((StringBuilder)localObject4).append(localException.getMessage());
          QLog.e("LocalDataJsPlugin", 1, ((StringBuilder)localObject4).toString());
          localObject2 = localObject3;
        }
        LocalDataJsPlugin.access$000(this.this$0, str2, Integer.parseInt(str1), paramDownloadTask.c, localObject2);
      }
      return;
    }
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append("sigTplResDownloadListener.onDone error : callbackId = ");
    paramDownloadTask.append(str2);
    paramDownloadTask.append(" itemId = ");
    paramDownloadTask.append(str1);
    QLog.e("LocalDataJsPlugin", 1, paramDownloadTask.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */