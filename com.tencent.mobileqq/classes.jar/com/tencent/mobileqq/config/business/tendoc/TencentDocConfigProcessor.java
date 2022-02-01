package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
    if (paramTencentDocConfigBean == null) {
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof AppInterface))
    {
      localObject = (AppInterface)localObject;
      ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).setTencentDocsAssitantEnable((AppInterface)localObject, paramTencentDocConfigBean.a());
      ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).setPreloadToolProcess((AppInterface)localObject, paramTencentDocConfigBean.b());
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("TencentDocConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 294;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConfigProcessor
 * JD-Core Version:    0.7.0.1
 */