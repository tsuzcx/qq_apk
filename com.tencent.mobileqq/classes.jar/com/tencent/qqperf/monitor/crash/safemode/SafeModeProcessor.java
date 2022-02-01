package com.tencent.qqperf.monitor.crash.safemode;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SafeModeProcessor
  extends IQConfigProcessor<SafeModeBean>
{
  @NonNull
  public SafeModeBean a(int paramInt)
  {
    return new SafeModeBean();
  }
  
  @Nullable
  public SafeModeBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed: invoked.  content: ");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.i("SafeModeProcessor", 1, localStringBuilder.toString());
      paramArrayOfQConfItem = SafeModeBean.a(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem != null)
      {
        MobileQQ.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfQConfItem.a).apply();
        MobileQQ.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfQConfItem.a).commit();
      }
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  public void a(SafeModeBean paramSafeModeBean) {}
  
  public Class<SafeModeBean> clazz()
  {
    return SafeModeBean.class;
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
    return 424;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.safemode.SafeModeProcessor
 * JD-Core Version:    0.7.0.1
 */