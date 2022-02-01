package com.tencent.mobileqq.kandian.biz.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyCommonConfProcessor
  extends IQConfigProcessor<ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig>
{
  @NonNull
  public ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig a(int paramInt)
  {
    return new ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig();
  }
  
  @Nullable
  public ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig localReadinjoyManagerPlatformConfig = new ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig();
      localReadinjoyManagerPlatformConfig.a(paramArrayOfQConfItem);
      return localReadinjoyManagerPlatformConfig;
    }
    return new ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig();
  }
  
  public void a(ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig paramReadinjoyManagerPlatformConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig> clazz()
  {
    return ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return SharedPreUtils.K(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 92;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.ReadinjoyCommonConfProcessor
 * JD-Core Version:    0.7.0.1
 */