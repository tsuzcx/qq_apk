package com.tencent.mobileqq.msgbackup.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupConfigProcessor
  extends IQConfigProcessor<MsgBackupConfigProcessor.MsgBackupConfigData>
{
  public static boolean a = false;
  private static boolean b = false;
  
  public static boolean a()
  {
    if (b) {
      return a;
    }
    b = true;
    a = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsgBackupConfigData isSwitchOpened = ");
      localStringBuilder.append(a);
      QLog.d("MsgBackupConfigProcessor", 2, localStringBuilder.toString());
    }
    return a;
  }
  
  private static boolean b()
  {
    Object localObject2 = (MsgBackupConfigProcessor.MsgBackupConfigData)QConfigManager.a().a(522);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new MsgBackupConfigProcessor.MsgBackupConfigData();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MsgBackupConfigData switch isOpened = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("MsgBackupConfigProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1.a();
  }
  
  @NonNull
  public MsgBackupConfigProcessor.MsgBackupConfigData a(int paramInt)
  {
    return new MsgBackupConfigProcessor.MsgBackupConfigData();
  }
  
  @Nullable
  public MsgBackupConfigProcessor.MsgBackupConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("MsgBackupConfigProcessor", 2, localStringBuilder.toString());
      }
      return MsgBackupConfigProcessor.MsgBackupConfigData.a(paramArrayOfQConfItem[0].a);
    }
    return new MsgBackupConfigProcessor.MsgBackupConfigData();
  }
  
  public void a(MsgBackupConfigProcessor.MsgBackupConfigData paramMsgBackupConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramMsgBackupConfigData);
      QLog.d("MsgBackupConfigProcessor", 2, localStringBuilder.toString());
    }
    if (paramMsgBackupConfigData != null) {
      a = paramMsgBackupConfigData.a();
    }
  }
  
  public Class<MsgBackupConfigProcessor.MsgBackupConfigData> clazz()
  {
    return MsgBackupConfigProcessor.MsgBackupConfigData.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed : ");
      localStringBuilder.append(paramInt);
      QLog.d("MsgBackupConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor
 * JD-Core Version:    0.7.0.1
 */