package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;

class OlympicStatusResDownloader$1
  implements Runnable
{
  OlympicStatusResDownloader$1(OlympicStatusResDownloader paramOlympicStatusResDownloader, String paramString1, String paramString2, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)))
    {
      String[] arrayOfString = OlympicStatusResDownloader.c();
      if (ZipResourcesDownloader.a(this.a, this.b, arrayOfString))
      {
        QLog.d("OlympicStatusResDownloader", 2, "[OlympicStatusResDownloader] downloadRes res is ready");
        return;
      }
      QLog.d("OlympicStatusResDownloader", 2, "[OlympicStatusResDownloader] downloadRes res need download");
      OlympicStatusResDownloader.a(this.this$0).a(this.c, 10096, "prd", this.a, this.b, arrayOfString, null);
      return;
    }
    QLog.d("OlympicStatusResDownloader", 2, new Object[] { "[OlympicStatusResDownloader] downloadRes paramError resUrl=", this.a, " md5=", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader.1
 * JD-Core Version:    0.7.0.1
 */