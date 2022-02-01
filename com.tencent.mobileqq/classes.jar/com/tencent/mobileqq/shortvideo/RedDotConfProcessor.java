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
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localRedDotConfBean;
    }
    return null;
  }
  
  public void a(RedDotConfBean paramRedDotConfBean)
  {
    boolean bool2 = true;
    int i = paramRedDotConfBean.a;
    int j = paramRedDotConfBean.b;
    int k = paramRedDotConfBean.c;
    int m = paramRedDotConfBean.d;
    paramRedDotConfBean = a();
    if (ShortVideoUtils.getHotPiCRedDotConfigVersion(paramRedDotConfBean) != j)
    {
      ShortVideoUtils.setHotPiCRedDotConfigVersion(paramRedDotConfBean, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.setHotPicRedDotStatus(paramRedDotConfBean, bool1);
        ShortVideoUtils.isHotPicConfiginitied = false;
      }
    }
    else if (ShortVideoUtils.getPtvRedDotConfigVersion(paramRedDotConfBean) != m)
    {
      ShortVideoUtils.setPtvRedDotConfigVersion(paramRedDotConfBean, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.setPtvRedDotStatus(paramRedDotConfBean, bool1);
      ShortVideoUtils.isPtvConfiginitied = false;
      return;
      bool1 = false;
      break;
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
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 325;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.RedDotConfProcessor
 * JD-Core Version:    0.7.0.1
 */