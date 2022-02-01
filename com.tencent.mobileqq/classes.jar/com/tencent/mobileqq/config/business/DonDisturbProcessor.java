package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.AppRuntime;

public class DonDisturbProcessor
  extends IQConfigProcessor<DonDisturbBean>
{
  @NonNull
  public DonDisturbBean a(int paramInt)
  {
    return new DonDisturbBean();
  }
  
  @Nullable
  public DonDisturbBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      DonDisturbBean localDonDisturbBean = DonDisturbBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfQConfItem[0].a);
      }
      return localDonDisturbBean;
    }
    return new DonDisturbBean();
  }
  
  public void a(DonDisturbBean paramDonDisturbBean)
  {
    SharedPreUtils.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramDonDisturbBean.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramDonDisturbBean);
    }
  }
  
  public Class<DonDisturbBean> clazz()
  {
    return DonDisturbBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 453;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DonDisturbProcessor
 * JD-Core Version:    0.7.0.1
 */