package com.tencent.mobileqq.kandian.biz.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    String str = localQQAppInterface.getCurrentUin();
    return SharedPreUtils.V(localQQAppInterface.getApp(), str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadinjoyResetFunctionConfProcessor
 * JD-Core Version:    0.7.0.1
 */