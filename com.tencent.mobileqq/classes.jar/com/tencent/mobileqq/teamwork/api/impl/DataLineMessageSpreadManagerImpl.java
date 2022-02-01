package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.mobileqq.teamwork.api.IDataLineMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;
import mqq.app.AppRuntime;

public class DataLineMessageSpreadManagerImpl
  implements IDataLineMessageSpreadManager
{
  public void updateConfig(Object paramObject)
  {
    if ((paramObject instanceof TencentDocDataLineTipsConfigBean))
    {
      paramObject = (TencentDocDataLineTipsConfigBean)paramObject;
      if (!TextUtils.isEmpty(paramObject.d())) {
        ((DataLineMessageSpreadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.DataLineMessageSpreadManagerImpl
 * JD-Core Version:    0.7.0.1
 */