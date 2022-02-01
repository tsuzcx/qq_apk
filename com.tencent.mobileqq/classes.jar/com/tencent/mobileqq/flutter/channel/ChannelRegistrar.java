package com.tencent.mobileqq.flutter.channel;

import com.tencent.mobileqq.flutter.channel.apm.APMChannel;
import com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannel;
import com.tencent.mobileqq.flutter.channel.expand.ExpandPushChannel;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel;
import com.tencent.mobileqq.flutter.channel.expand.redpoint.ExpandRedPointApiChannel;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel;
import com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel;
import com.tencent.mobileqq.flutter.channel.report.ReportChannel;
import com.tencent.mobileqq.flutter.channel.sso.SSOChannel;
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
  private ExpandRedPointApiChannel jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel = new ExpandRedPointApiChannel();
  private List<BaseChannel> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  private void a(BinaryMessenger paramBinaryMessenger, BaseMethodChannel paramBaseMethodChannel)
  {
    MethodCodec localMethodCodec = paramBaseMethodChannel.a();
    String str = paramBaseMethodChannel.a();
    new MethodChannel(paramBinaryMessenger, str, localMethodCodec).setMethodCallHandler(paramBaseMethodChannel.a());
    this.jdField_a_of_type_JavaUtilList.add(paramBaseMethodChannel);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.ChannelRegistrar", 2, "registerMethodChannel, channelName: " + str);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      QLog.d("QFlutter.ChannelRegistrar", 1, "unregister, channel is empty");
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseChannel localBaseChannel = (BaseChannel)localIterator.next();
      localBaseChannel.a();
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.ChannelRegistrar", 2, "channel: " + localBaseChannel.a() + " unregister");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel.a();
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
    a(paramFlutterEngine, new ExpandConfigChannel());
    a(paramFlutterEngine, new ExpandChatApiChannel(paramFlutterEngine));
    a(paramFlutterEngine, new ExpandPushChannel(paramFlutterEngine));
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel.a(paramFlutterEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.ChannelRegistrar
 * JD-Core Version:    0.7.0.1
 */