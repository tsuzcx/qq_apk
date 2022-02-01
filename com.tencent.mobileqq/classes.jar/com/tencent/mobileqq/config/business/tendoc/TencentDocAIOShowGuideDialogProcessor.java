package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocAIOShowGuideDialogProcessor
  extends IQConfigProcessor<TencentDocAIOShowGuideDialogBean>
{
  public static TencentDocAIOShowGuideDialogBean a()
  {
    return (TencentDocAIOShowGuideDialogBean)QConfigManager.a().a(342);
  }
  
  @NonNull
  public TencentDocAIOShowGuideDialogBean a(int paramInt)
  {
    return new TencentDocAIOShowGuideDialogBean();
  }
  
  @Nullable
  public TencentDocAIOShowGuideDialogBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocAIOShowGuideDialogBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocAIOShowGuideDialogBean paramTencentDocAIOShowGuideDialogBean) {}
  
  public Class<TencentDocAIOShowGuideDialogBean> clazz()
  {
    return TencentDocAIOShowGuideDialogBean.class;
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
    QLog.d("TencentDocAIOShowGuideDialogProcessor", 1, "TENCENT_DOC_AIO_SHOW_GUIDE_DIALOG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 342;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogProcessor
 * JD-Core Version:    0.7.0.1
 */