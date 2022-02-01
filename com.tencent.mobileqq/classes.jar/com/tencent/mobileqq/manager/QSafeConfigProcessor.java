package com.tencent.mobileqq.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.identity.IQSafeConfigCallback;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.safe.LoginInfoSafeEntrance;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ZipConfigCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QSafeConfigProcessor
  extends IQConfigProcessor<QSafeManagerBean>
{
  @ConfigInject(configPath="Business/qqsafeblock-api/src/main/resources/Inject_SecurityBlockConfig.yml", version=1)
  protected static ArrayList<Class<? extends IQSafeConfigCallback>> a = new ArrayList();
  private List<IQSafeConfigCallback> b = new ArrayList();
  
  static
  {
    a.add(ZipConfigCallback.class);
    a.add(LoginInfoSafeEntrance.class);
  }
  
  public QSafeConfigProcessor()
  {
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        IQSafeConfigCallback localIQSafeConfigCallback = (IQSafeConfigCallback)((Class)localIterator.next()).newInstance();
        this.b.add(localIQSafeConfigCallback);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QSafeConfigProcessor", 1, "QSafeConfigProcessor new instance error : ", localException);
    }
  }
  
  @NonNull
  public QSafeManagerBean a(int paramInt)
  {
    QLog.d("QSafeConfigProcessor", 1, "migrateOldOrDefaultContent");
    QSafeManagerBean localQSafeManagerBean = new QSafeManagerBean();
    localQSafeManagerBean.b(-1);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IQSafeConfigCallback)localIterator.next()).a(localQSafeManagerBean);
    }
    return localQSafeManagerBean;
  }
  
  @Nullable
  public QSafeManagerBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.d("QSafeConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      Object localObject = paramArrayOfQConfItem[0];
      paramArrayOfQConfItem = ((QConfItem)localObject).b;
      QSafeManagerBean localQSafeManagerBean = new QSafeManagerBean();
      localQSafeManagerBean.b(((QConfItem)localObject).a);
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQSafeConfigCallback)((Iterator)localObject).next()).a(localQSafeManagerBean, paramArrayOfQConfItem);
      }
      QLog.d("QSafeConfigProcessor", 1, new Object[] { "parsed bean : ", localQSafeManagerBean });
      return localQSafeManagerBean;
    }
    QLog.d("QSafeConfigProcessor", 1, "onParsed, but confFiles is empty");
    return null;
  }
  
  public void a(QSafeManagerBean paramQSafeManagerBean)
  {
    QLog.d("QSafeConfigProcessor", 1, "onUpdate");
    QSafeConfigManager.a().a(paramQSafeManagerBean);
  }
  
  public Class<QSafeManagerBean> clazz()
  {
    return QSafeManagerBean.class;
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
    return -1;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("QSafeConfigProcessor", 1, "onReqFailed");
    QSafeManagerBean localQSafeManagerBean = (QSafeManagerBean)QConfigManager.b().b(732);
    QSafeConfigManager.a().a(localQSafeManagerBean);
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    QLog.d("QSafeConfigProcessor", 1, "onReqNoReceive");
  }
  
  public int type()
  {
    return 732;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.manager.QSafeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */