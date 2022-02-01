package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.Map;

public class ExpandConfigChannelHandler
  implements MethodChannel.MethodCallHandler
{
  private static final Handler a;
  public static final MethodCodec a;
  
  static
  {
    jdField_a_of_type_IoFlutterPluginCommonMethodCodec = StandardMethodCodec.INSTANCE;
    jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    if (QLog.isColorLevel()) {
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[onMethodCall] method=" + str);
    }
    if ("getBannerConfigList".equals(str))
    {
      ExpandFlutterIPCClient.a().a("METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST", new Bundle(), new ExpandConfigChannelHandler.1(this, paramResult));
      return;
    }
    if ("setTABTestPlan".equals(str))
    {
      paramMethodCall = (String)paramMethodCall.argument("plan");
      ExpandFlutterIPCClient.a().a(paramMethodCall, new ExpandConfigChannelHandler.2(this, paramResult));
      return;
    }
    if ("getStayMatchFlag".equals(str))
    {
      ExpandFlutterIPCClient.a().a(new ExpandConfigChannelHandler.3(this, paramResult));
      return;
    }
    if ("getResourceDirectory".equals(str))
    {
      paramMethodCall = ExpandFlutterIPCClient.a().a("METHOD_GET_FLUTTER_RESOURCE_PATH", null).getString("ret");
      if (QLog.isColorLevel()) {
        QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[METHOD_GET_RESOURCE_DIRECTORY] result=" + paramMethodCall);
      }
      paramResult.success(paramMethodCall);
      return;
    }
    if ("getCenterBannerConfigList".equals(str))
    {
      paramResult.success(null);
      return;
    }
    if ("getExpandConfig".equals(str))
    {
      paramResult.success(ExpandFlutterIPCClient.a().a("METHOD_GET_EXPAND_CONFIG", null).getString("ret"));
      return;
    }
    if ("getSelfBirthdate".equals(str))
    {
      ExpandFlutterIPCClient.a().a("METHOD_GET_BIRTH_DATE", new Bundle(), new ExpandConfigChannelHandler.4(this, paramResult));
      return;
    }
    if ("setSelfBirthdate".equals(str))
    {
      int i = ((Integer)paramMethodCall.argument("birthdate")).intValue();
      paramMethodCall = new Bundle();
      paramMethodCall.putInt("birthdate", i);
      ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DATE", paramMethodCall);
      return;
    }
    if ("setExpandBirthdayDialogShowFlag".equals(str))
    {
      ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DIALOG_FLAG", null);
      return;
    }
    if ("getExpandBirthdayDialogShowFlag".equals(str))
    {
      paramResult.success(Boolean.valueOf(ExpandFlutterIPCClient.a().a("METHOD_GET_BIRTH_DIALOG_FLAG", null).getBoolean("showflag")));
      return;
    }
    if ("createMessageNodeIfNeed".equals(str))
    {
      paramMethodCall = (String)paramMethodCall.argument("matchUin");
      ExpandFlutterIPCClient.a().a(paramMethodCall);
      return;
    }
    if ("batchCreateMessageNodeIfNeed".equals(str))
    {
      paramMethodCall = (Map)paramMethodCall.argument("matchInfoMap");
      ExpandFlutterIPCClient.a().a(paramMethodCall);
      paramResult.success(null);
      return;
    }
    if ("setSupportRightDragBack".equals(str))
    {
      paramResult.success(Boolean.valueOf(true));
      return;
    }
    if ("getExpandSecurityInfo".equals(str))
    {
      paramMethodCall = new Bundle();
      ExpandFlutterIPCClient.a().a("METHOD_GET_SECURITY_INFO", paramMethodCall, new ExpandConfigChannelHandler.5(this, paramResult));
      return;
    }
    if ("getABTestInfo".equals(str))
    {
      paramMethodCall = ExpandFlutterIPCClient.a().a("METHOD_GET_ABTEST_INFO", null).getString("data");
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "abtest info : " + paramMethodCall);
      paramResult.success(paramMethodCall);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler
 * JD-Core Version:    0.7.0.1
 */