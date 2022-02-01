package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DownloaderGetCodeServer
{
  private static DownloaderGetCodeServer a;
  private DownloaderGetCodeServer.GetAuthCodeObserver b = new DownloaderGetCodeServer.GetAuthCodeObserver(this, null);
  private Map<String, Bundle> c = Collections.synchronizedMap(new HashMap());
  private QIPCModule d = new DownloaderGetCodeServer.1(this, "Module_DownloaderGetCodeServer");
  
  public static DownloaderGetCodeServer a()
  {
    if (a == null) {
      try
      {
        a = new DownloaderGetCodeServer();
      }
      finally {}
    }
    return a;
  }
  
  private QQAppInterface c()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QIPCModule b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer
 * JD-Core Version:    0.7.0.1
 */