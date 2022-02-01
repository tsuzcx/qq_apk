package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.QLog;

public class TencentDocConfigProcessor
  extends IQConfigProcessor<TencentDocConfigBean>
{
  @NonNull
  public TencentDocConfigBean a(int paramInt)
  {
    return new TencentDocConfigBean();
  }
  
  @Nullable
  public TencentDocConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocConfigBean paramTencentDocConfigBean)
  {
    if (paramTencentDocConfigBean == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    TeamWorkUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramTencentDocConfigBean.a());
    TeamWorkUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramTencentDocConfigBean.b());
  }
  
  public Class<TencentDocConfigBean> clazz()
  {
    return TencentDocConfigBean.class;
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
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 294;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConfigProcessor
 * JD-Core Version:    0.7.0.1
 */