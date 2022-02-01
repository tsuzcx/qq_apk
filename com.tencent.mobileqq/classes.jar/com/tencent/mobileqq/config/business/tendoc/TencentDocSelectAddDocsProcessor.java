package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocSelectAddDocsProcessor
  extends IQConfigProcessor<TencentDocSelectAddDocsBean>
{
  public static TencentDocSelectAddDocsBean a()
  {
    return (TencentDocSelectAddDocsBean)QConfigManager.b().b(335);
  }
  
  @NonNull
  public TencentDocSelectAddDocsBean a(int paramInt)
  {
    return new TencentDocSelectAddDocsBean();
  }
  
  @Nullable
  public TencentDocSelectAddDocsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocSelectAddDocsBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocSelectAddDocsBean paramTencentDocSelectAddDocsBean) {}
  
  public Class<TencentDocSelectAddDocsBean> clazz()
  {
    return TencentDocSelectAddDocsBean.class;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("TencentDocSelectAddDocsProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsProcessor
 * JD-Core Version:    0.7.0.1
 */