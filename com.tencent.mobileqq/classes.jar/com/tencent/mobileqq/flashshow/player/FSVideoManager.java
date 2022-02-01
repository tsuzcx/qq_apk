package com.tencent.mobileqq.flashshow.player;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FSVideoManager
{
  private static volatile FSVideoManager a;
  private ConcurrentHashMap<String, FSPlayer> b = new ConcurrentHashMap();
  
  private FSVideoManager()
  {
    b();
  }
  
  public static FSVideoManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSVideoManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      try
      {
        HostDataTransUtils.initVideoSdk(new FSVideoManager.1(this));
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("FSVideoManager", 1, localRuntimeException.getMessage());
        localRuntimeException.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    if (this.b.size() > 0)
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((FSPlayer)this.b.remove(str)).f();
      }
    }
  }
  
  public FSPlayer a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("when newAQCirclePlayer release players, size:");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.d("FSVideoManager", 1, ((StringBuilder)localObject).toString());
      c();
      localObject = new FSPlayer();
      this.b.put(paramString, localObject);
      return localObject;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("releasePlayer is null:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FSVideoManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("releasePlayer :");
    localStringBuilder.append(paramString);
    QLog.d("FSVideoManager", 1, localStringBuilder.toString());
    this.b.remove(paramString);
    ((FSPlayer)localObject).f();
  }
  
  public FSPlayer c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.b.containsKey(paramString)) {
      return (FSPlayer)this.b.get(paramString);
    }
    QLog.d("FSVideoManager", 1, "getPlayer null ");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSVideoManager
 * JD-Core Version:    0.7.0.1
 */