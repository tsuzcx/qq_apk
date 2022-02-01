package com.tencent.mobileqq.flutter.channel;

import com.tencent.mobileqq.flutter.channel.apm.APMChannel;
import com.tencent.mobileqq.flutter.channel.kandian.RIJMethodChannel;
import com.tencent.mobileqq.flutter.channel.qqgame.QQGameChannel;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel;
import com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel;
import com.tencent.mobileqq.flutter.channel.report.ReportChannel;
import com.tencent.mobileqq.flutter.channel.sso.SSOChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelRegister;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCodec;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChannelRegistrar
{
  IExpandChannelRegister a = (IExpandChannelRegister)QRoute.api(IExpandChannelRegister.class);
  private List<BaseChannel> b = new LinkedList();
  
  private void a(BinaryMessenger paramBinaryMessenger, BaseMethodChannel paramBaseMethodChannel)
  {
    MethodCodec localMethodCodec = paramBaseMethodChannel.b();
    String str = paramBaseMethodChannel.a();
    new MethodChannel(paramBinaryMessenger, str, localMethodCodec).setMethodCallHandler(paramBaseMethodChannel.c());
    this.b.add(paramBaseMethodChannel);
    if (QLog.isColorLevel())
    {
      paramBinaryMessenger = new StringBuilder();
      paramBinaryMessenger.append("registerMethodChannel, channelName: ");
      paramBinaryMessenger.append(str);
      QLog.d("QFlutter.ChannelRegistrar", 2, paramBinaryMessenger.toString());
    }
  }
  
  public void a()
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseChannel localBaseChannel = (BaseChannel)((Iterator)localObject).next();
        localBaseChannel.f();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("channel: ");
          localStringBuilder.append(localBaseChannel.a());
          localStringBuilder.append(" unregister");
          QLog.d("QFlutter.ChannelRegistrar", 2, localStringBuilder.toString());
        }
      }
      this.a.unRegisterChannel();
      return;
    }
    QLog.d("QFlutter.ChannelRegistrar", 1, "unregister, channel is empty");
  }
  
  public void a(FlutterEngine paramFlutterEngine)
  {
    if (paramFlutterEngine == null) {
      return;
    }
    paramFlutterEngine = paramFlutterEngine.getDartExecutor();
    a(paramFlutterEngine, new SSOChannel());
    a(paramFlutterEngine, new APMChannel());
    a(paramFlutterEngine, new SCFChannel());
    a(paramFlutterEngine, new ZanRankingChannel());
    a(paramFlutterEngine, new ReportChannel());
    a(paramFlutterEngine, new RIJMethodChannel(paramFlutterEngine));
    a(paramFlutterEngine, new QQGameChannel());
    this.a.registerChannel(paramFlutterEngine, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.ChannelRegistrar
 * JD-Core Version:    0.7.0.1
 */