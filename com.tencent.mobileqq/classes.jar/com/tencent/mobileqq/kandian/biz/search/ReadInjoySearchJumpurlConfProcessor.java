package com.tencent.mobileqq.kandian.biz.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoySearchJumpurlConfProcessor
  extends IQConfigProcessor<IReadInJoySearchJumpUrlConfBean>
{
  public static IReadInJoySearchJumpUrlConfBean a()
  {
    return (IReadInJoySearchJumpUrlConfBean)QConfigManager.b().b(292);
  }
  
  @NonNull
  public IReadInJoySearchJumpUrlConfBean a(int paramInt)
  {
    return new ReadInjoySearchJumpurlConfBean();
  }
  
  @Nullable
  public IReadInJoySearchJumpUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onParsed] confFiles = ");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, localStringBuilder.toString());
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onParsed] confFiles[0].content= ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, localStringBuilder.toString());
      }
      return new ReadInjoySearchJumpurlConfBean().e(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(IReadInJoySearchJumpUrlConfBean paramIReadInJoySearchJumpUrlConfBean) {}
  
  public Class<IReadInJoySearchJumpUrlConfBean> clazz()
  {
    return IReadInJoySearchJumpUrlConfBean.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor
 * JD-Core Version:    0.7.0.1
 */