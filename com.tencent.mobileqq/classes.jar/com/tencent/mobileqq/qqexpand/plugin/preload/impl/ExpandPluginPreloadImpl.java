package com.tencent.mobileqq.qqexpand.plugin.preload.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.plugin.preload.IExpandPluginPreload;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ExpandPluginPreloadImpl
  implements IExpandPluginPreload
{
  private static final String TAG = "ExpandPluginPreloadImpl";
  
  private boolean shouldPreloadPluginProcess(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    boolean bool = ((ExpandManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("shouldPreloadPluginProcess ");
      paramAppInterface.append(bool);
      QLog.d("ExpandPluginPreloadImpl", 2, paramAppInterface.toString());
    }
    return bool;
  }
  
  public void preloadProcessIfPlugin(@Nullable AppInterface paramAppInterface, long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ExpandPluginPreloadImpl.1(this, paramAppInterface), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.impl.ExpandPluginPreloadImpl
 * JD-Core Version:    0.7.0.1
 */