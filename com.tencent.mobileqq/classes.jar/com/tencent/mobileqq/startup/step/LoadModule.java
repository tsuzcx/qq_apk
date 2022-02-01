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
  public static volatile boolean a = false;
  private static OGEntityDaoManagerProxy.Proxy b = new LoadModule.2();
  private static MsgProxyUtilsProxy.Proxy c = new LoadModule.3();
  private static ExceptionTrackerProxy.Proxy d = new LoadModule.4();
  private static TableBuilderProxy.Proxy e = new LoadModule.5();
  
  private static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyImport Start, process=", MobileQQ.processName });
    }
    OGEntityDaoManagerProxy.registerProxy(b);
    TableBuilderProxy.registerProxy(e);
    MsgProxyUtilsProxy.registerProxy(c);
    ExceptionTrackerProxy.a(d);
    RecentUserMsgFactory.a(new RecentUserMsgFactory.Builder().a(new MsgDeserializeListProvider()).b(new MsgSerializeListProvider()).c(new RecentMsgProxyProviderListProvider()).d(new DefaultMsgSerializeProvider()).a());
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "initModuleProxyNotImport finish, process=", MobileQQ.processName });
    }
  }
  
  private static void b()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.a = 2130851558;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.drawable.b = 2130851559;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.a = 2131168153;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.color.b = 2131168122;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.a = 2131917400;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.b = 2131917390;
    com.tencent.mobileqq.imcore.proxy.IMCoreResourceRoute.Resource.string.c = 2131917386;
  }
  
  private static void c()
  {
    com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.StartupDirectorConstants.a = 10;
    com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.RecentConstants.a = 99;
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel()) {
      if (a) {
        QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", MobileQQ.processName, " repeat! InitInfo=", new RuntimeException("") });
      } else {
        QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Start, process=", MobileQQ.processName, " InitInfo=", Boolean.valueOf(a) });
      }
    }
    if (a) {
      return true;
    }
    a = true;
    long l = SystemClock.uptimeMillis();
    a();
    b();
    c();
    ThreadManager.getSubThreadHandler().post(new LoadModule.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("LoadModule", 2, new Object[] { "IMCoreModule Init Finish, cost=", Long.valueOf(SystemClock.uptimeMillis() - l) });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule
 * JD-Core Version:    0.7.0.1
 */