package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoySearchJumpurlConfProcessor
  extends IQConfigProcessor<ReadInjoySearchJumpurlConfBean>
{
  public static ReadInjoySearchJumpurlConfBean a()
  {
    return (ReadInjoySearchJumpurlConfBean)QConfigManager.a().a(292);
  }
  
  @NonNull
  public ReadInjoySearchJumpurlConfBean a(int paramInt)
  {
    return new ReadInjoySearchJumpurlConfBean();
  }
  
  @Nullable
  public ReadInjoySearchJumpurlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfQConfItem);
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfQConfItem[0].a);
      }
      return ReadInjoySearchJumpurlConfBean.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(ReadInjoySearchJumpurlConfBean paramReadInjoySearchJumpurlConfBean) {}
  
  public Class<ReadInjoySearchJumpurlConfBean> clazz()
  {
    return ReadInjoySearchJumpurlConfBean.class;
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
    return 292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor
 * JD-Core Version:    0.7.0.1
 */