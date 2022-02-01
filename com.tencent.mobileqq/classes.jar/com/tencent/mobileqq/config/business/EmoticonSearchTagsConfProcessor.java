package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class EmoticonSearchTagsConfProcessor
  extends IQConfigProcessor<EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean>
{
  public static EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean a()
  {
    return (EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean)QConfigManager.a().a(620);
  }
  
  @NonNull
  public EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean a(int paramInt)
  {
    return new EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean();
  }
  
  @Nullable
  public EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean paramEmoticonSearchTagConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "EmoticonSearchTagsConfProcessor onUpdate");
    }
  }
  
  public Class<EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean> clazz()
  {
    return EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 620;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor
 * JD-Core Version:    0.7.0.1
 */