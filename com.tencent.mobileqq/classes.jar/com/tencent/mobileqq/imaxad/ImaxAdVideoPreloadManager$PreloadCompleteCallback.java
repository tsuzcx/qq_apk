package com.tencent.mobileqq.imaxad;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class ImaxAdVideoPreloadManager$PreloadCompleteCallback
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private ImaxAdVideoPreloadManager$PreloadCompleteCallback(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (ImaxAdVideoPreloadManager.b(this.a))
    {
      String str = ImaxAdVideoPreloadManager.d(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComplete path:");
      localStringBuilder.append(str);
      ImaxAdUtil.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComplete vid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", detail:");
      localStringBuilder.append(paramString2);
      ImaxAdUtil.c(localStringBuilder.toString());
      ImaxAdVideoPreloadManager.a(this.a, paramString1);
      paramString2 = new File(ImaxAdVideoPreloadManager.e(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      ImaxAdVideoPreloadManager.b(this.a, paramString1);
      ImaxAdVideoPreloadManager.b(this.a, ImaxAdVideoPreloadManager.c(this.a));
      ImaxAdVideoPreloadManager.d(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.PreloadCompleteCallback
 * JD-Core Version:    0.7.0.1
 */