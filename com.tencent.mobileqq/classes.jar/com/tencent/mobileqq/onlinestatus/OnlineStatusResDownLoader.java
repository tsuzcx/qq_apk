package com.tencent.mobileqq.onlinestatus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnlineStatusResDownLoader
{
  private ZipResourcesDownloader a = new ZipResourcesDownloader();
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ZipResourcesDownloader.a(paramString1, paramString2));
    localStringBuilder.append("/");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public static String[] a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("data.json");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("images/");
    return new String[] { localObject2, localStringBuilder.toString() };
  }
  
  public void a()
  {
    QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] onDestroy call destroy zipDownloader");
    this.a.a();
  }
  
  public void a(AppInterface paramAppInterface)
  {
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localObject == null)
    {
      QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean is null");
      return;
    }
    localObject = ((OnlineStatusBean)localObject).c();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ThreadManagerV2.excute(new OnlineStatusResDownLoader.1(this, (ArrayList)localObject, paramAppInterface), 16, null, true);
      return;
    }
    QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean.moodList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader
 * JD-Core Version:    0.7.0.1
 */