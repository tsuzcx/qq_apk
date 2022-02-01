package com.tencent.mobileqq.c2cshortcutbar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class C2CShortcutBarConfProcessor
  extends IQConfigProcessor<C2CShortcutBarConfBean>
{
  @NonNull
  public static C2CShortcutBarConfBean a()
  {
    C2CShortcutBarConfBean localC2CShortcutBarConfBean2 = (C2CShortcutBarConfBean)QConfigManager.a().a(670);
    C2CShortcutBarConfBean localC2CShortcutBarConfBean1 = localC2CShortcutBarConfBean2;
    if (localC2CShortcutBarConfBean2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarConfProcessor", 2, "loadConfig(): bean is null then new C2CShortcutBarConfBean()");
      }
      localC2CShortcutBarConfBean1 = new C2CShortcutBarConfBean();
    }
    return localC2CShortcutBarConfBean1;
  }
  
  @NonNull
  public C2CShortcutBarConfBean a(int paramInt)
  {
    return new C2CShortcutBarConfBean();
  }
  
  @Nullable
  public C2CShortcutBarConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0))
    {
      QLog.d("C2CShortcutBarConfProcessor", 1, "C2CShortcutBarConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "C2CShortcutBarConfProcessor onParsed, content:" + paramArrayOfQConfItem);
    }
    return C2CShortcutBarConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(C2CShortcutBarConfBean paramC2CShortcutBarConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "onUpdate " + paramC2CShortcutBarConfBean.toString());
    }
  }
  
  public Class<C2CShortcutBarConfBean> clazz()
  {
    return C2CShortcutBarConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 670;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarConfProcessor
 * JD-Core Version:    0.7.0.1
 */