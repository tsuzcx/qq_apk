package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.entrance.QCircleInvokeStubImpl;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.rank.QCircleRankEventCollector;
import com.tencent.biz.qqcircle.requests.QCircleGetRainbowKVConfRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.richframework.sender.call.BaseCall;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;

public class QCircleInitStartProcess
  extends QCircleBaseInitProcess
{
  private void c()
  {
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new QCircleInitStartProcess.1(this));
  }
  
  private void d()
  {
    QCircleInvokeProxy.bindStub(new QCircleInvokeStubImpl());
  }
  
  private void e()
  {
    QCircleGlobalBroadcastHelper.a().b();
  }
  
  private void f()
  {
    QCircleSkinHelper.getInstance().init(QCircleApplication.APP);
  }
  
  private void g()
  {
    QCircleRankEventCollector.getInstance().init();
    QCirclePluginInitHelper.getInstance().loadSoWithSoLoadManager();
    QCircleRequestSender.a().b().a(new QCircleGetRainbowKVConfRequest("ab24e8dd-f8e7-422e-b98d-62de8d524d9d", "TEST", "edge_config.json")).a(new QCircleInitStartProcess.2(this)).a();
  }
  
  public void b()
  {
    super.b();
    c();
    d();
    e();
    QCircleHostLauncher.VasAdvInitDeviceInfo();
    f();
    QCircleToast.a(ASInject.g().getToastDelegate());
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitStartProcess
 * JD-Core Version:    0.7.0.1
 */