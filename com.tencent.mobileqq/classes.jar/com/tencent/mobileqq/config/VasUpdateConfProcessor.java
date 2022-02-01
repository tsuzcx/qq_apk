package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
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
        Object localObject;
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            localObject = paramArrayOfQConfItem[i];
            if (localObject != null)
            {
              VasUpdateCfgBean localVasUpdateCfgBean = VasUpdateCfgBean.a(((QConfItem)localObject).a);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("onParsed ");
                localStringBuilder.append(((QConfItem)localObject).a);
                QLog.d("VasUpdateConfProcessor", 2, localStringBuilder.toString());
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed Exception = ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem.getMessage());
        QLog.e("VasUpdateConfProcessor", 1, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.VasUpdateConfProcessor
 * JD-Core Version:    0.7.0.1
 */