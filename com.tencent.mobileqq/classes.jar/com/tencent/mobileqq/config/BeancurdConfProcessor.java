package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class BeancurdConfProcessor
  extends IQConfigProcessor<BeancurdConfBean>
{
  public static boolean a()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a(756);
    Object localObject = (BeancurdConfBean)localExpEntityInfo.b();
    localExpEntityInfo.h();
    if (localObject != null)
    {
      boolean bool = ((BeancurdConfBean)localObject).a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("expGrpLineCnt=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("expInfo:");
      ((StringBuilder)localObject).append(localExpEntityInfo.k());
      ABTestUtil.a("BeancurdConfProcessor", ((StringBuilder)localObject).toString());
      return bool;
    }
    return false;
  }
  
  @NonNull
  public BeancurdConfBean a(int paramInt)
  {
    return new BeancurdConfBean();
  }
  
  @Nullable
  public BeancurdConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("BeancurdConfProcessor", 2, localStringBuilder.toString());
      }
      return BeancurdConfBean.a(paramArrayOfQConfItem[0].b);
    }
    return new BeancurdConfBean();
  }
  
  public void a(BeancurdConfBean paramBeancurdConfBean) {}
  
  public Class<BeancurdConfBean> clazz()
  {
    return BeancurdConfBean.class;
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
    return 756;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.BeancurdConfProcessor
 * JD-Core Version:    0.7.0.1
 */