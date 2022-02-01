package com.tencent.mobileqq.onlinestatus.config.olympic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OlympicConfProcessor
  extends IQConfigProcessor<OlympicConfBean>
{
  public static OlympicConfBean b()
  {
    OlympicConfBean localOlympicConfBean = (OlympicConfBean)QConfigManager.b().b(766);
    if (localOlympicConfBean != null) {
      return localOlympicConfBean;
    }
    return new OlympicConfBean();
  }
  
  public AppInterface a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApp, runtime is null ?  ");
      boolean bool;
      if (localAppRuntime == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" , runtime instanceof QQAppInterface ? ");
      localStringBuilder.append(localAppRuntime instanceof AppInterface);
      QLog.d("OlympicConfProcessor", 2, localStringBuilder.toString());
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public OlympicConfBean a(int paramInt)
  {
    return new OlympicConfBean();
  }
  
  public OlympicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      String str = paramArrayOfQConfItem[0].b;
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("Olympic.[onParsed] type=");
          paramArrayOfQConfItem.append(type());
          paramArrayOfQConfItem.append(", content = ");
          paramArrayOfQConfItem.append(str);
          QLog.i("OlympicConfProcessor", 1, paramArrayOfQConfItem.toString());
        }
        try
        {
          paramArrayOfQConfItem = (OlympicConfBean.OlympicConfig)QStorage.a(str, OlympicConfBean.OlympicConfig.class);
        }
        catch (QStorageInstantiateException paramArrayOfQConfItem)
        {
          QLog.e("OlympicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfQConfItem);
          paramArrayOfQConfItem = localObject;
        }
        return new OlympicConfBean(str, paramArrayOfQConfItem);
      }
    }
    return null;
  }
  
  public void a(OlympicConfBean paramOlympicConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Olympic.[onUpdate] type=");
      localStringBuilder.append(type());
      localStringBuilder.append(", content = ");
      if (paramOlympicConfBean == null) {
        localObject = "";
      } else {
        localObject = paramOlympicConfBean.a();
      }
      localStringBuilder.append((String)localObject);
      QLog.i("OlympicConfProcessor", 2, localStringBuilder.toString());
    }
    Object localObject = paramOlympicConfBean.b();
    if (localObject == null) {
      return;
    }
    paramOlympicConfBean = ((OlympicConfBean.OlympicConfig)localObject).a;
    localObject = ((OlympicConfBean.OlympicConfig)localObject).b;
    if ((!TextUtils.isEmpty(paramOlympicConfBean)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramOlympicConfBean = a();
      if (paramOlympicConfBean != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicConfProcessor", 2, "Olympic.[onUpdate] startDownload res");
        }
        ((OnlineStatusOlympicManager)((IOnlineStatusManagerService)paramOlympicConfBean.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class)).a();
      }
      return;
    }
    QLog.e("OlympicConfProcessor", 1, "Olympic.[onUpdate] resUrl or md5 is null");
  }
  
  public Class<OlympicConfBean> clazz()
  {
    return OlympicConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 766;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor
 * JD-Core Version:    0.7.0.1
 */