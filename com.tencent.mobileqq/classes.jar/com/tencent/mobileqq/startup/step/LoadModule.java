package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory;
import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory.Builder;
import com.tencent.mobileqq.activity.recent.msg.littleear.DefaultMsgSerializeProvider;
import com.tencent.mobileqq.activity.recent.msg.littleear.MsgDeserializeListProvider;
import com.tencent.mobileqq.activity.recent.msg.littleear.MsgSerializeListProvider;
import com.tencent.mobileqq.activity.recent.msg.littleear.creator.RecentMsgProxyProviderListProvider;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.imcore.proxy.basic.ExceptionTrackerProxy;
import com.tencent.mobileqq.imcore.proxy.basic.ExceptionTrackerProxy.Proxy;
import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy.Proxy;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy.Proxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy.Proxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LoadModule
  extends Step
{
  private static ExceptionTrackerProxy.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyBasicExceptionTrackerProxy$Proxy = new LoadModule.4();
  private static OGEntityDaoManagerProxy.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyDbOGEntityDaoManagerProxy$Proxy;
  private static TableBuilderProxy.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyDbTableBuilderProxy$Proxy = new LoadModule.5();
  private static MsgProxyUtilsProxy.Proxy jdField_a_of_type_ComTencentMobileqqImcoreProxyMsgMsgProxyUtilsProxy$Proxy;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqImcoreProxyDbOGEntityDaoManagerProxy$Proxy = new LoadModule.2();
    jdField_a_of_type_ComTencentMobileqqImcoreProxyMsgMsgProxyUtilsProxy$Proxy = new LoadModule.3();
  }
  
  private static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyImport Start, process=", MobileQQ.processName });
    }
    OGEntityDaoManagerProxy.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyDbOGEntityDaoManagerProxy$Proxy);
    TableBuilderProxy.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyDbTableBuilderProxy$Proxy);
    MsgProxyUtilsProxy.registerProxy(jdField_a_of_type_ComTencentMobileqqImcoreProxyMsgMsgProxyUtilsProxy$Proxy);
    ExceptionTrackerProxy.a(jdField_a_of_type_ComTencentMobileqqImcoreProxyBasicExceptionTrackerProxy$Proxy);
    RecentUserMsgFactory.a(new RecentUserMsgFactory.Builder().a(new MsgDeserializeListProvider()).b(new MsgSerializeListProvider()).c(new RecentMsgProxyProviderListProvider()).d(new DefaultMsgSerializeProvider()).a());
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", MobileQQ.processName });
    }
  }
  
  private static void b()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.a = 2130849953;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.b = 2130849954;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.a = 2131167145;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.b = 2131167117;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.a = 2131720064;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.b = 2131720054;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.c = 2131720050;
  }
  
  private static void c()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.StartupDirectorConstants.a = 10;
    com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.RecentConstants.a = 99;
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel())
    {
      if (jdField_a_of_type_Boolean) {
        QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", MobileQQ.processName, " repeat! InitInfo=", new RuntimeException("") });
      }
    }
    else {
      if (!jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    label96:
    long l;
    do
    {
      return true;
      QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", MobileQQ.processName, " InitInfo=", Boolean.valueOf(jdField_a_of_type_Boolean) });
      break;
      jdField_a_of_type_Boolean = true;
      l = SystemClock.uptimeMillis();
      a();
      b();
      c();
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