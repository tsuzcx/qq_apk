package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VideoDrawConfProcessor
  extends IQConfigProcessor<String>
{
  @NonNull
  public String a(int paramInt)
  {
    return "";
  }
  
  @Nullable
  public String a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      paramArrayOfQConfItem = null;
    }
    String str;
    do
    {
      return paramArrayOfQConfItem;
      str = paramArrayOfQConfItem[0].a;
      paramArrayOfQConfItem = str;
    } while (!QLog.isColorLevel());
    QLog.d("VideoDrawConfProcessor", 2, " onParsed, content:" + str);
    return str;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<String> clazz()
  {
    return String.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 462;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.VideoDrawConfProcessor
 * JD-Core Version:    0.7.0.1
 */