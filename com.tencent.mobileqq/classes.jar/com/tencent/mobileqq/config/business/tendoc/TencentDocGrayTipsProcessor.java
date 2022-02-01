package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocGrayTipsProcessor
  extends IQConfigProcessor<TencentDocGrayTipsBean>
{
  public static TencentDocGrayTipsBean a()
  {
    return (TencentDocGrayTipsBean)QConfigManager.b().b(338);
  }
  
  @NonNull
  public TencentDocGrayTipsBean a(int paramInt)
  {
    return new TencentDocGrayTipsBean();
  }
  
  @Nullable
  public TencentDocGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocGrayTipsBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocGrayTipsBean paramTencentDocGrayTipsBean) {}
  
  public Class<TencentDocGrayTipsBean> clazz()
  {
    return TencentDocGrayTipsBean.class;
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
    localStringBuilder.append("TENCENT_DOC_GRAY_TIPS failed, resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("TencentDocGrayTipsProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 338;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsProcessor
 * JD-Core Version:    0.7.0.1
 */