package com.tencent.mobileqq.shortvideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class RedDotConfProcessor
  extends IQConfigProcessor<RedDotConfBean>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
  }
  
  @NonNull
  public RedDotConfBean a(int paramInt)
  {
    return new RedDotConfBean();
  }
  
  @Nullable
  public RedDotConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      RedDotConfBean localRedDotConfBean = RedDotConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, localStringBuilder.toString());
      }
      return localRedDotConfBean;
    }
    return null;
  }
  
  public void a(RedDotConfBean paramRedDotConfBean)
  {
    int i = paramRedDotConfBean.a;
    int j = paramRedDotConfBean.b;
    int k = paramRedDotConfBean.c;
    int m = paramRedDotConfBean.d;
    paramRedDotConfBean = a();
    int n = ShortVideoUtils.getHotPiCRedDotConfigVersion(paramRedDotConfBean);
    boolean bool2 = true;
    boolean bool1;
    if (n != j)
    {
      ShortVideoUtils.setHotPiCRedDotConfigVersion(paramRedDotConfBean, j);
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ShortVideoUtils.setHotPicRedDotStatus(paramRedDotConfBean, bool1);
      ShortVideoUtils.isHotPicConfiginitied = false;
    }
    if (ShortVideoUtils.getPtvRedDotConfigVersion(paramRedDotConfBean) != m)
    {
      ShortVideoUtils.setPtvRedDotConfigVersion(paramRedDotConfBean, m);
      if (k == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ShortVideoUtils.setPtvRedDotStatus(paramRedDotConfBean, bool1);
      ShortVideoUtils.isPtvConfiginitied = false;
    }
  }
  
  public Class<RedDotConfBean> clazz()
  {
    return RedDotConfBean.class;
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
    return ShortVideoUtils.getPtvHotPicConfigVersion(a());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 325;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.RedDotConfProcessor
 * JD-Core Version:    0.7.0.1
 */