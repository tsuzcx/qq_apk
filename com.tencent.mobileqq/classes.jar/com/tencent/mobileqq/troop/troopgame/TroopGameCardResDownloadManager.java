package com.tencent.mobileqq.troop.troopgame;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TroopGameCardResDownloadManager
  implements ResDownloadManager.IResDownloadListener
{
  public static String a;
  private ResDownloadManager b;
  private TroopGameCardResDownloadManager.IStatusListener c;
  
  public TroopGameCardResDownloadManager(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.b = ((ResDownloadManager)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD));
    } else {
      this.b = new ResDownloadManager(paramAppInterface);
    }
    this.b.a(this);
  }
  
  private void a(int paramInt, String paramString)
  {
    TroopGameCardResDownloadManager.IStatusListener localIStatusListener = this.c;
    if (localIStatusListener != null)
    {
      if (paramInt == 0)
      {
        localIStatusListener.a(paramString);
        return;
      }
      localIStatusListener.b(paramInt);
    }
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(a)) {
      a = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getString("resPath", a);
    }
    if (!TextUtils.isEmpty(a))
    {
      Object localObject;
      if (a.endsWith(File.separator))
      {
        localObject = a;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("Gameicon");
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadStart()");
    }
    TroopGameCardResDownloadManager.IStatusListener localIStatusListener = this.c;
    if (localIStatusListener != null) {
      localIStatusListener.a();
    }
  }
  
  public void a(TroopGameCardResDownloadManager.ResInfo paramResInfo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResDownloadManager", 2, "startDownload res...");
      }
      this.b.a(paramResInfo.a, paramResInfo.b, ".zip", true, 6);
      return;
    }
    finally {}
  }
  
  public void a(TroopGameCardResDownloadManager.ResInfo paramResInfo, TroopGameCardResDownloadManager.IStatusListener paramIStatusListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkResDownloadReady resUrl is ");
      String str;
      if (paramResInfo == null) {
        str = "emptyUrl";
      } else {
        str = paramResInfo.a;
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" resMd5 is ");
      if (paramResInfo == null) {
        str = "emptyMd5";
      } else {
        str = paramResInfo.b;
      }
      localStringBuilder.append(str);
      QLog.d("TroopGameCardResDownloadManager", 2, localStringBuilder.toString());
    }
    this.c = paramIStatusListener;
    if ((paramResInfo != null) && (!TextUtils.isEmpty(paramResInfo.a)) && (!TextUtils.isEmpty(paramResInfo.b)))
    {
      a(paramResInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardResDownloadManager", 2, "need pull config");
    }
    ((TroopGameCardConfigProcessor)QConfigManager.b().a(695)).a(new TroopGameCardResDownloadManager.1(this));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate,url =   ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",percent = ");
      localStringBuilder.append(paramInt);
      QLog.d("TroopGameCardResDownloadManager", 2, localStringBuilder.toString());
    }
    paramString1 = this.c;
    if (paramString1 != null) {
      paramString1.a(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish,url =   ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",errCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",path = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",userData = ");
      localStringBuilder.append(paramObject);
      QLog.d("TroopGameCardResDownloadManager", 2, localStringBuilder.toString());
    }
    if (!paramString3.endsWith("/"))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(File.separator);
      paramString3 = paramString1.toString();
    }
    a(paramInt, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager
 * JD-Core Version:    0.7.0.1
 */