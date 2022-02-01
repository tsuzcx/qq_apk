package com.tencent.mobileqq.config.business.tendoc.tds;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public final class TdsReaderGrayConfigProcessor
  extends IQConfigProcessor<TdsReaderGrayConfigBean>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    TdsReaderGrayConfigBean.a(false, (TdsReaderGrayConfigBean)QConfigManager.a().a(501));
  }
  
  @NonNull
  public TdsReaderGrayConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent type:");
    localStringBuilder.append(paramInt);
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, localStringBuilder.toString());
    return new TdsReaderGrayConfigBean();
  }
  
  @Nullable
  public TdsReaderGrayConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return TdsReaderGrayConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(TdsReaderGrayConfigBean paramTdsReaderGrayConfigBean)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    TdsReaderGrayConfigBean.a(true, paramTdsReaderGrayConfigBean);
  }
  
  public Class<TdsReaderGrayConfigBean> clazz()
  {
    return TdsReaderGrayConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    localStringBuilder.append("onReqFailed: ");
    localStringBuilder.append(paramInt);
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderGrayConfigProcessor
 * JD-Core Version:    0.7.0.1
 */