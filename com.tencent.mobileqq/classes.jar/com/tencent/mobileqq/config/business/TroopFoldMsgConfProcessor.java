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
    Object localObject;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgBean.a(paramArrayOfQConfItem[0].a);
      localObject = localTroopFoldMsgBean;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].a);
        QLog.d("TroopFoldMsgConfProcessor", 2, ((StringBuilder)localObject).toString());
        localObject = localTroopFoldMsgBean;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
      }
      localObject = null;
    }
    paramArrayOfQConfItem = (QConfItem[])localObject;
    if (localObject == null) {
      paramArrayOfQConfItem = new TroopFoldMsgBean();
    }
    return paramArrayOfQConfItem;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("TroopFoldMsgConfProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor
 * JD-Core Version:    0.7.0.1
 */