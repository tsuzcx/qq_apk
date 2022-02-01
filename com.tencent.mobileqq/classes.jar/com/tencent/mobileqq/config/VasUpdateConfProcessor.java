package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

public class VasUpdateConfProcessor
  extends BaseQVipConfigProcessor<VasUpdateCfgBean>
{
  @NonNull
  public VasUpdateCfgBean a()
  {
    return new VasUpdateCfgBean();
  }
  
  @NonNull
  public VasUpdateCfgBean a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            QConfItem localQConfItem = paramArrayOfQConfItem[i];
            if (localQConfItem != null)
            {
              VasUpdateCfgBean localVasUpdateCfgBean = VasUpdateCfgBean.a(localQConfItem.a);
              if (QLog.isColorLevel()) {
                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + localQConfItem.a);
              }
              if (localVasUpdateCfgBean != null) {
                return localVasUpdateCfgBean;
              }
            }
            i += 1;
          }
        }
        return new VasUpdateCfgBean();
      }
      catch (Exception paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + paramArrayOfQConfItem.getMessage());
      }
    }
  }
  
  @NonNull
  public VasUpdateCfgBean b()
  {
    return new VasUpdateCfgBean();
  }
  
  public Class<VasUpdateCfgBean> clazz()
  {
    return VasUpdateCfgBean.class;
  }
  
  public int type()
  {
    return 649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.VasUpdateConfProcessor
 * JD-Core Version:    0.7.0.1
 */