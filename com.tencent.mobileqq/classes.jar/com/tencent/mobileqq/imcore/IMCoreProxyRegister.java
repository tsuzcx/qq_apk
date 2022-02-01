package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.imcore.proxy.basic.TalkBackProxy;
import com.tencent.mobileqq.imcore.proxy.basic.TimeFormatterUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.business.ColorNickManagerProxy;
import com.tencent.mobileqq.imcore.proxy.business.ConversationDataFactoryProxy;
import com.tencent.mobileqq.imcore.proxy.business.FriendsProxy;
import com.tencent.mobileqq.imcore.proxy.business.HotChatManagerProxy;
import com.tencent.mobileqq.imcore.proxy.business.RecentDataListManagerProxy;
import com.tencent.mobileqq.imcore.proxy.business.RecentFaceDecoderProxy;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy;
import com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy;
import com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy;
import com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy;
import com.tencent.mobileqq.imcore.proxy.troop.TroopAssistantManagerProxy;
import com.tencent.mobileqq.imcore.proxy.troop.TroopManagerProxy;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public final class IMCoreProxyRegister
{
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCoreProxyRegister", 2, new Object[] { "initModuleProxyNotImport Start, process=", MobileQQ.processName });
    }
    g();
    f();
    c();
    d();
    e();
    b();
    if (QLog.isColorLevel()) {
      QLog.d("IMCoreProxyRegister", 2, new Object[] { "initModuleProxyNotImport finish, process=", MobileQQ.processName });
    }
  }
  
  public static void b()
  {
    ConversationDataFactoryProxy.a(new IMCoreProxyRegister.17());
    RecentDataListManagerProxy.a(new IMCoreProxyRegister.18());
    RecentFaceDecoderProxy.a(new IMCoreProxyRegister.19());
    TempMsgBoxManagerProxy.a(new IMCoreProxyRegister.20());
    FriendsProxy.a(new IMCoreProxyRegister.21());
  }
  
  private static void c()
  {
    AIOUtilsProxy.registerProxy(new IMCoreProxyRegister.1());
    MsgUtilsProxy.a(new IMCoreProxyRegister.2());
    ConversationFacadeProxy.a(new IMCoreProxyRegister.3());
    ContactUtilsProxy.a(new IMCoreProxyRegister.4());
    TimeFormatterUtilsProxy.a(new IMCoreProxyRegister.5());
  }
  
  private static void d()
  {
    ColorNickManagerProxy.a(new IMCoreProxyRegister.6());
    HotChatManagerProxy.a(new IMCoreProxyRegister.7());
  }
  
  private static void e()
  {
    TroopManagerProxy.a(new IMCoreProxyRegister.8());
    TroopAssistantManagerProxy.a(new IMCoreProxyRegister.9());
  }
  
  private static void f()
  {
    SQLiteFTSUtilsProxy.registerProxy(new IMCoreProxyRegister.10());
    ThreadTraceHelperProxy.registerProxy(new IMCoreProxyRegister.11());
  }
  
  private static void g()
  {
    StatisticCollectorProxy.registerProxy(new IMCoreProxyRegister.12());
    CaughtExceptionReportProxy.registerProxy(new IMCoreProxyRegister.13());
    TalkBackProxy.a(new IMCoreProxyRegister.14());
    QQTextProxy.a(new IMCoreProxyRegister.15());
    ThreadRegulatorProxy.registerProxy(new IMCoreProxyRegister.16());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister
 * JD-Core Version:    0.7.0.1
 */