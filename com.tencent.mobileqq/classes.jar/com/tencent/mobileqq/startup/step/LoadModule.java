package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import bdil;
import bdim;
import bdin;
import bdio;
import bdip;
import bdiq;
import bdir;
import bdis;
import bdit;
import bdiu;
import bdiv;
import bdiw;
import bdix;
import bdiy;
import bdiz;
import bdja;
import bdjb;
import bdjc;
import bdjd;
import bdje;
import bdjf;
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
  private static IMCoreProxyRoute.ExceptionTracker.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$ExceptionTracker$Proxy = new bdix();
  private static IMCoreProxyRoute.GetStaticProxy<AppRuntime> jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$GetStaticProxy = new bdit();
  private static IMCoreProxyRoute.MsgProxyUtils.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$MsgProxyUtils$Proxy;
  private static IMCoreProxyRoute.OGEntityDaoManager.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$OGEntityDaoManager$Proxy = new bdiu();
  private static IMCoreProxyRoute.TableBuilder.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$TableBuilder$Proxy = new bdiy();
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqImcoreProxyIMCoreProxyRoute$MsgProxyUtils$Proxy = new bdiw();
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
    IMCoreProxyRoute.StatisticCollector.registerProxy(new bdiv());
    IMCoreProxyRoute.CaughtExceptionReport.registerProxy(new bdiz());
    IMCoreProxyRoute.SQLiteFTSUtils.registerProxy(new bdja());
    IMCoreProxyRoute.ThreadTraceHelper.registerProxy(new bdjb());
    IMCoreProxyRoute.AIOUtils.registerProxy(new bdjc());
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", BaseApplicationImpl.processName });
    }
    IMCoreProxyRoute.ThreadRegulator.registerProxy(new bdjd());
    IMCoreProxyRoute.TalkBack.registerProxy(new bdje());
    RecentRoute.MsgUtils.registerProxy(new bdjf());
    RecentRoute.QQTextProxy.registerProxy(new bdil());
    RecentRoute.TimeFormatterUtils.registerProxy(new bdim());
    RecentRoute.ConversationFacadeProxy.registerProxy(new bdin());
    RecentRoute.ContactUtilsProxy.registerProxy(new bdio());
    RecentRoute.ColorNickManagerProxy.registerProxy(new bdip());
    RecentRoute.TroopManagerProxy.registerProxy(new bdiq());
    RecentRoute.HotChatManagerProxy.registerProxy(new bdir());
    RecentRoute.TroopAssistantManagerProxy.registerProxy(new bdis());
  }
  
  private static void d()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.recent_icon_failed = 2130849558;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.recent_icon_sending = 2130849559;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.skin_orange = 2131167102;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.skin_gray2_theme_version2 = 2131167074;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant_num_unreadmsg = 2131718846;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant_detail = 2131718836;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.troop_assistant = 2131718832;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule
 * JD-Core Version:    0.7.0.1
 */