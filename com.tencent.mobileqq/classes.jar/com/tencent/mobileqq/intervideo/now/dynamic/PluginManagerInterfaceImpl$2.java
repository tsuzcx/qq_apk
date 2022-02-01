package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.IDownloadListener;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PluginManagerInterfaceImpl$2
  implements IDownloadListener
{
  PluginManagerInterfaceImpl$2(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, DownloadCallback paramDownloadCallback, String paramString) {}
  
  public void a()
  {
    QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadComplete------");
    ThreadManager.getSubThreadHandler().post(new PluginManagerInterfaceImpl.2.1(this));
    PluginManagerInterfaceImpl.a(this.c).removeDownloadListener(this.b);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadFailed------");
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("errCode", paramInt1);
      localBundle.putInt("httpCode", paramInt2);
      localBundle.putString("errMsg", paramString);
      this.a.onDownloadError(paramInt1, paramInt2, paramString);
    }
    PluginManagerInterfaceImpl.a(this.c).removeDownloadListener(this.b);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("downloadSize", paramLong1);
      localBundle.putLong("totalSize", paramLong2);
      localBundle.putInt("percent", paramInt);
      this.a.onProgress((int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.2
 * JD-Core Version:    0.7.0.1
 */