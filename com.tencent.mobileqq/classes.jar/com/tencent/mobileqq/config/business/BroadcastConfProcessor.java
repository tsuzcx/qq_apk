package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class BroadcastConfProcessor
  extends IQConfigProcessor<BroadcastConfProcessor.BroadcastConfBean>
{
  @NonNull
  public BroadcastConfProcessor.BroadcastConfBean a(int paramInt)
  {
    return new BroadcastConfProcessor.BroadcastConfBean();
  }
  
  @Nullable
  public BroadcastConfProcessor.BroadcastConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfQConfItem);
      }
      BroadcastConfProcessor.BroadcastConfBean localBroadcastConfBean = BroadcastConfProcessor.BroadcastConfBean.a(paramArrayOfQConfItem);
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfQConfItem).apply();
        MobileQQ.addBroadcastWhitList(localBroadcastConfBean.a);
      }
    }
    return new BroadcastConfProcessor.BroadcastConfBean();
  }
  
  public void a(BroadcastConfProcessor.BroadcastConfBean paramBroadcastConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<BroadcastConfProcessor.BroadcastConfBean> clazz()
  {
    return BroadcastConfProcessor.BroadcastConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 567;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BroadcastConfProcessor
 * JD-Core Version:    0.7.0.1
 */