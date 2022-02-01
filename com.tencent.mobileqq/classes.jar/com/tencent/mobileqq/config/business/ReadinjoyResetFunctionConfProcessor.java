package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyResetFunctionConfProcessor
  extends IQConfigProcessor<ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig>
{
  @NonNull
  public ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig a(int paramInt)
  {
    return new ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig();
  }
  
  @Nullable
  public ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig localReadinjoyResetConfig = new ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig();
      localReadinjoyResetConfig.a(paramArrayOfQConfItem);
      return localReadinjoyResetConfig;
    }
    return new ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig();
  }
  
  public void a(ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig paramReadinjoyResetConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig> clazz()
  {
    return ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return SharedPreUtils.O(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 368;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ReadinjoyResetFunctionConfProcessor
 * JD-Core Version:    0.7.0.1
 */