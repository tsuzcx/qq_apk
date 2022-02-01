package com.tencent.mobileqq.transfile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.highway.api.HighwayConfBean;
import com.tencent.qphone.base.util.QLog;

public class HighwayConfProcessor
  extends IQConfigProcessor<HighwayConfBean>
{
  public static final int GET_HIGHWAY_CONFIG = 15;
  public static final String TAG = "HighwayConfProcessor";
  
  public Class<HighwayConfBean> clazz()
  {
    return HighwayConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public HighwayConfBean migrateOldOrDefaultContent(int paramInt)
  {
    HighwayConfBean localHighwayConfBean = new HighwayConfBean();
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localHighwayConfBean;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public HighwayConfBean onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      HighwayConfBean localHighwayConfBean = HighwayConfBean.parse(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HighwayConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localHighwayConfBean;
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onUpdate(HighwayConfBean paramHighwayConfBean)
  {
    HighwayConfBean.updateHighwayConf((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramHighwayConfBean);
  }
  
  public int type()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HighwayConfProcessor
 * JD-Core Version:    0.7.0.1
 */