package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import bcbb;
import bcbc;
import bcbd;
import bcbe;
import bcbf;
import bcbg;
import bcbh;
import bcbi;
import bcbj;
import bcbk;
import bcbl;
import bcbm;
import bcbn;
import bcbo;
import bcbp;
import bcbq;
import bcbr;
import bcbs;
import bcbt;
import bcbu;
import bcbv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.imcore.IMCore;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.AIOUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.CaughtExceptionReport;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ExceptionTracker;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ExceptionTracker.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.SQLiteFTSUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder.Proxy;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TalkBack;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ColorNickManagerProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ConversationFacadeProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.HotChatManagerProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.MsgUtils;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TimeFormatterUtils;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopAssistantManagerProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopManagerProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LoadModule
  extends Step
{
  private static IMCoreProxyRoute.ExceptionTracker.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$ExceptionTracker$Proxy = new bcbn();
  private static IMCoreProxyRoute.GetStaticProxy<AppRuntime> jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$GetStaticProxy = new bcbj();
  private static IMCoreProxyRoute.MsgProxyUtils.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$MsgProxyUtils$Proxy;
  private static IMCoreProxyRoute.OGEntityDaoManager.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$OGEntityDaoManager$Proxy = new bcbk();
  private static IMCoreProxyRoute.TableBuilder.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$TableBuilder$Proxy = new bcbo();
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$MsgProxyUtils$Proxy = new bcbm();
  }
  
  private static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyImport Start, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.OGEntityDaoManager.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$OGEntityDaoManager$Proxy);
    IMCoreProxyRoute.TableBuilder.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$TableBuilder$Proxy);
    IMCoreProxyRoute.MsgProxyUtils.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$MsgProxyUtils$Proxy);
    IMCoreProxyRoute.ExceptionTracker.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$ExceptionTracker$Proxy);
    d();
    e();
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", BaseApplicationImpl.processName });
    }
  }
  
  private static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport Start, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.StatisticCollector.registerProxy(new bcbl());
    IMCoreProxyRoute.CaughtExceptionReport.registerProxy(new bcbp());
    IMCoreProxyRoute.SQLiteFTSUtils.registerProxy(new bcbq());
    IMCoreProxyRoute.ThreadTraceHelper.registerProxy(new bcbr());
    IMCoreProxyRoute.AIOUtils.registerProxy(new bcbs());
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.ThreadRegulator.registerProxy(new bcbt());
    IMCoreProxyRoute.TalkBack.registerProxy(new bcbu());
    RecentRoute.MsgUtils.registerProxy(new bcbv());
    RecentRoute.QQTextProxy.registerProxy(new bcbb());
    RecentRoute.TimeFormatterUtils.registerProxy(new bcbc());
    RecentRoute.ConversationFacadeProxy.registerProxy(new bcbd());
    RecentRoute.ContactUtilsProxy.registerProxy(new bcbe());
    RecentRoute.ColorNickManagerProxy.registerProxy(new bcbf());
    RecentRoute.TroopManagerProxy.registerProxy(new bcbg());
    RecentRoute.HotChatManagerProxy.registerProxy(new bcbh());
    RecentRoute.TroopAssistantManagerProxy.registerProxy(new bcbi());
  }
  
  private static void d()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.recent_icon_failed = 2130849470;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.recent_icon_sending = 2130849471;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.skin_orange = 2131167124;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.skin_gray2_theme_version2 = 2131167096;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant_num_unreadmsg = 2131719095;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant_detail = 2131719085;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant = 2131719081;
  }
  
  private static void e()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.TroopConstants.CreditInfo.LEVEL_NORMAL = 5L;
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel())
    {
      if (jdField_a_of_type_Boolean) {
        QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", BaseApplicationImpl.processName, " repeat! InitInfo=", new RuntimeException("") });
      }
    }
    else {
      if (!jdField_a_of_type_Boolean) {
        break label101;
      }
    }
    label101:
    long l;
    do
    {
      return true;
      QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", BaseApplicationImpl.processName, " InitInfo=", Boolean.valueOf(jdField_a_of_type_Boolean) });
      break;
      jdField_a_of_type_Boolean = true;
      l = SystemClock.uptimeMillis();
      IMCore.syncAppSetting(true, false, false, false);
      IMCore.init(jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$GetStaticProxy);
      b();
      ThreadManager.getSubThreadHandler().post(new LoadModule.1(this));
    } while (!QLog.isColorLevel());
    QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Finish, cost=", Long.valueOf(SystemClock.uptimeMillis() - l) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule
 * JD-Core Version:    0.7.0.1
 */