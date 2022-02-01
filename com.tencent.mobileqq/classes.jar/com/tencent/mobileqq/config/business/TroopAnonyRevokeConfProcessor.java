package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TroopAnonyRevokeConfProcessor
  extends IQConfigProcessor<GeneralDataBean>
{
  public static GeneralDataBean a()
  {
    return (GeneralDataBean)QConfigManager.a().a(633);
  }
  
  @NonNull
  public GeneralDataBean a(int paramInt)
  {
    return new GeneralDataBean();
  }
  
  @Nullable
  public GeneralDataBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      GeneralDataBean localGeneralDataBean = GeneralDataBean.a(paramArrayOfQConfItem[0].a);
      localObject = localGeneralDataBean;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].a);
        QLog.d("TroopFoldMsgConfProcessor", 2, ((StringBuilder)localObject).toString());
        return localGeneralDataBean;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
      }
      localObject = null;
    }
    return localObject;
  }
  
  public void a(GeneralDataBean paramGeneralDataBean)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<GeneralDataBean> clazz()
  {
    return GeneralDataBean.class;
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
    return 633;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor
 * JD-Core Version:    0.7.0.1
 */