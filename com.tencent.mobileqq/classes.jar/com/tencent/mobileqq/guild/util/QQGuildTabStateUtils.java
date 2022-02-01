package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.ipc.methods.IsShowGuildTabMethod;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class QQGuildTabStateUtils
{
  public static boolean a()
  {
    int i = MobileQQ.sProcessId;
    boolean bool1 = false;
    if (i != 1) {
      return GuildIpcUtils.a(IsShowGuildTabMethod.class, new Object[0]).data.getBoolean("ret");
    }
    Context localContext = QQGuildUtil.h();
    String str = QQGuildUtil.f();
    boolean bool3 = TabDataHelper.isOnceFetchFromServer(localContext, str);
    boolean bool2 = c();
    boolean bool4 = b();
    boolean bool5 = TabDataHelper.isExtendTabShow(localContext, str, "GUILD");
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildTabStateUtils", 2, new Object[] { "isTabShow(): useTabManager: ", Boolean.valueOf(bool3), ", grayType: ", Boolean.valueOf(bool4), ", config: ", Boolean.valueOf(bool2), ", tabManager: ", Boolean.valueOf(bool5) });
    }
    if (bool3) {
      return bool5;
    }
    if ((bool4) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean b()
  {
    return QQGuildGrayUserTypeConfig.a().c();
  }
  
  private static boolean c()
  {
    return QQGuildSPUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildTabStateUtils
 * JD-Core Version:    0.7.0.1
 */