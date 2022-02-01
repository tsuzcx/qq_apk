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
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean b()
  {
    MsgBackupConfigProcessor.MsgBackupConfigData localMsgBackupConfigData2 = (MsgBackupConfigProcessor.MsgBackupConfigData)QConfigManager.a().a(522);
    MsgBackupConfigProcessor.MsgBackupConfigData localMsgBackupConfigData1 = localMsgBackupConfigData2;
    if (localMsgBackupConfigData2 == null)
    {
      localMsgBackupConfigData2 = new MsgBackupConfigProcessor.MsgBackupConfigData();
      localMsgBackupConfigData1 = localMsgBackupConfigData2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localMsgBackupConfigData1 = localMsgBackupConfigData2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localMsgBackupConfigData1);
    }
    return localMsgBackupConfigData1.a();
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
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfQConfItem[0].a);
      }
      return MsgBackupConfigProcessor.MsgBackupConfigData.a(paramArrayOfQConfItem[0].a);
    }
    return new MsgBackupConfigProcessor.MsgBackupConfigData();
  }
  
  public void a(MsgBackupConfigProcessor.MsgBackupConfigData paramMsgBackupConfigData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramMsgBackupConfigData);
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
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public int type()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor
 * JD-Core Version:    0.7.0.1
 */