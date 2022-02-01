package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.teamwork.api.IAIOMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import mqq.app.AppRuntime;

public class AIOMessageSpreadManagerImpl
  implements IAIOMessageSpreadManager
{
  public void updateConfig(Object paramObject)
  {
    if ((paramObject instanceof TencentDocTipsConfigBean))
    {
      paramObject = (TencentDocTipsConfigBean)paramObject;
      if (!TextUtils.isEmpty(paramObject.i())) {
        ((AIOMessageSpreadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.AIOMessageSpreadManagerImpl
 * JD-Core Version:    0.7.0.1
 */