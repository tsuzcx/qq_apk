package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class SoLibraryChecker$4
  implements Runnable
{
  SoLibraryChecker$4(SoLibraryChecker paramSoLibraryChecker, JSONObject paramJSONObject, String paramString, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    String str = this.a.optString("url");
    Object localObject2 = new File(this.b);
    Object localObject1 = new Bundle();
    localObject2 = new DownloadTask(str, (File)localObject2);
    ((DownloadTask)localObject2).e = 3;
    SoLibraryChecker.f(this.this$0).startDownload((DownloadTask)localObject2, this.c, (Bundle)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start Download url = ");
      ((StringBuilder)localObject1).append(str);
      QLog.d("SoLibraryLoader", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */