package com.tencent.mobileqq.config.business.sigtopic;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class SigTopicConfProcessor
  extends IQConfigProcessor<SigTopicConfBean>
{
  public static SigTopicConfBean a()
  {
    SigTopicConfBean localSigTopicConfBean = (SigTopicConfBean)QConfigManager.a().a(529);
    if (localSigTopicConfBean != null) {
      return localSigTopicConfBean;
    }
    return new SigTopicConfBean();
  }
  
  @NonNull
  public SigTopicConfBean a(int paramInt)
  {
    return new SigTopicConfBean();
  }
  
  @Nullable
  public SigTopicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0)
      {
        str = paramArrayOfQConfItem[0].a;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
          if (QLog.isColorLevel()) {
            QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed] type=" + type() + ", content = " + str);
          }
        }
      }
    }
    try
    {
      paramArrayOfQConfItem = (SigTopicConfBean.SigTopicConfig)QStorage.a(str, SigTopicConfBean.SigTopicConfig.class);
      localObject1 = new SigTopicConfBean(str, paramArrayOfQConfItem);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfQConfItem)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfQConfItem);
        paramArrayOfQConfItem = null;
      }
    }
  }
  
  public void a(SigTopicConfBean paramSigTopicConfBean) {}
  
  public Class<SigTopicConfBean> clazz()
  {
    return SigTopicConfBean.class;
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
    return 529;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor
 * JD-Core Version:    0.7.0.1
 */