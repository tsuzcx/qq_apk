package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.mutualmark.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnlineStatusResDownLoader
{
  private ZipResourcesDownloader a = new ZipResourcesDownloader();
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    return ZipResourcesDownloader.a(paramString1, paramString2) + "/" + paramLong + "/";
  }
  
  public static String[] a(long paramLong)
  {
    String str = paramLong + "/";
    return new String[] { str + "data.json", str + "images/" };
  }
  
  public void a()
  {
    QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] onDestroy call destroy zipDownloader");
    this.a.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localObject == null)
    {
      QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean is null");
      return;
    }
    localObject = ((OnlineStatusBean)localObject).c();
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean.moodList is empty");
      return;
    }
    ThreadManagerV2.excute(new OnlineStatusResDownLoader.1(this, (ArrayList)localObject, paramQQAppInterface), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader
 * JD-Core Version:    0.7.0.1
 */