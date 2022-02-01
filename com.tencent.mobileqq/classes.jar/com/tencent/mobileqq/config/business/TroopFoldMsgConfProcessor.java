package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TroopFoldMsgConfProcessor
  extends IQConfigProcessor<TroopFoldMsgBean>
{
  public static TroopFoldMsgBean a()
  {
    return (TroopFoldMsgBean)QConfigManager.a().a(635);
  }
  
  @NonNull
  public TroopFoldMsgBean a(int paramInt)
  {
    return new TroopFoldMsgBean();
  }
  
  @Nullable
  public TroopFoldMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    TroopFoldMsgBean localTroopFoldMsgBean2 = null;
    TroopFoldMsgBean localTroopFoldMsgBean1;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      localTroopFoldMsgBean2 = TroopFoldMsgBean.a(paramArrayOfQConfItem[0].a);
      localTroopFoldMsgBean1 = localTroopFoldMsgBean2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
        localTroopFoldMsgBean1 = localTroopFoldMsgBean2;
      }
    }
    for (;;)
    {
      paramArrayOfQConfItem = localTroopFoldMsgBean1;
      if (localTroopFoldMsgBean1 == null) {
        paramArrayOfQConfItem = new TroopFoldMsgBean();
      }
      return paramArrayOfQConfItem;
      localTroopFoldMsgBean1 = localTroopFoldMsgBean2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localTroopFoldMsgBean1 = localTroopFoldMsgBean2;
      }
    }
  }
  
  public void a(TroopFoldMsgBean paramTroopFoldMsgBean)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<TroopFoldMsgBean> clazz()
  {
    return TroopFoldMsgBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor
 * JD-Core Version:    0.7.0.1
 */