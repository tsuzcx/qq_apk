package com.tencent.mobileqq.education.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class AnswerSearchConfigProcessor
  extends IQConfigProcessor<AnswerSearchConfigBean>
{
  public AnswerSearchConfigBean a(int paramInt)
  {
    return new AnswerSearchConfigBean();
  }
  
  public AnswerSearchConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("AnswerSearchConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      try
      {
        paramArrayOfQConfItem = (AnswerSearchConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, AnswerSearchConfigBean.class);
        return paramArrayOfQConfItem;
      }
      catch (QStorageInstantiateException paramArrayOfQConfItem)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed: error. ");
        localStringBuilder.append(paramArrayOfQConfItem.getMessage());
        QLog.i("AnswerSearchConfigProcessor", 1, localStringBuilder.toString());
        paramArrayOfQConfItem.printStackTrace();
      }
    }
    return null;
  }
  
  public void a(AnswerSearchConfigBean paramAnswerSearchConfigBean)
  {
    QLog.i("AnswerSearchConfigProcessor", 1, "onUpdate: update config.");
  }
  
  public Class<AnswerSearchConfigBean> clazz()
  {
    return AnswerSearchConfigBean.class;
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
    localStringBuilder.append("onReqFailed: failCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("AnswerSearchConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 752;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.config.AnswerSearchConfigProcessor
 * JD-Core Version:    0.7.0.1
 */