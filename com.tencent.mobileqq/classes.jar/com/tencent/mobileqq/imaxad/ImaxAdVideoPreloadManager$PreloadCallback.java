package com.tencent.mobileqq.imaxad;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class ImaxAdVideoPreloadManager$PreloadCallback
  implements TVK_ICacheMgr.IPreloadCallback
{
  private ImaxAdVideoPreloadManager$PreloadCallback(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.a(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreLoadFailed vid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", i:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", callbackMsg:");
      localStringBuilder.append(paramString2);
      ImaxAdUtil.b(localStringBuilder.toString());
      ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.a(this.a))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPreLoadSucess vid:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", detail:");
      ((StringBuilder)localObject2).append(paramString2);
      ImaxAdUtil.b(((StringBuilder)localObject2).toString());
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = ImaxAdVideoPreloadManager.a(paramString1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onPreLoadSucess path:");
          ((StringBuilder)localObject2).append(paramString2);
          ImaxAdUtil.b(((StringBuilder)localObject2).toString());
          ImaxAdVideoPreloadManager.a(this.a, paramString1);
          localObject2 = new File(ImaxAdVideoPreloadManager.b(paramString1));
          if (((File)localObject2).exists()) {
            ((File)localObject2).renameTo(new File(paramString2));
          }
          ImaxAdVideoPreloadManager.b(this.a, paramString1);
          ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.a(this.a));
          ImaxAdVideoPreloadManager.b(this.a);
        }
      }
      catch (Exception paramString1)
      {
        QLog.d("ImaxAdvertisement", 1, "onPreLoadSucess", paramString1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.PreloadCallback
 * JD-Core Version:    0.7.0.1
 */