package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
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
  
  public static void a(@NonNull MethodCall paramMethodCall, IExpandChannelCallback paramIExpandChannelCallback)
  {
    Object localObject = paramMethodCall.method;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onMethodCall] method=");
      localStringBuilder.append((String)localObject);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
    }
    if ("getBannerConfigList".equals(localObject))
    {
      ExpandFlutterIPCClient.a().a("METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST", new Bundle(), new ExpandConfigChannelHandler.2(paramIExpandChannelCallback));
      return;
    }
    if ("setTABTestPlan".equals(localObject))
    {
      paramMethodCall = (String)paramMethodCall.argument("plan");
      ExpandFlutterIPCClient.a().a(paramMethodCall, new ExpandConfigChannelHandler.3(paramIExpandChannelCallback));
      return;
    }
    if ("getStayMatchFlag".equals(localObject))
    {
      ExpandFlutterIPCClient.a().a(new ExpandConfigChannelHandler.4(paramIExpandChannelCallback));
      return;
    }
    if ("getResourceDirectory".equals(localObject))
    {
      paramMethodCall = ExpandFlutterIPCClient.a().a("METHOD_GET_FLUTTER_RESOURCE_PATH", null).getString("ret");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[METHOD_GET_RESOURCE_DIRECTORY] result=");
        ((StringBuilder)localObject).append(paramMethodCall);
        QLog.d("expand.flutter.expandConfigChannelHandler", 2, ((StringBuilder)localObject).toString());
      }
      paramIExpandChannelCallback.success(paramMethodCall);
      return;
    }
    if ("getCenterBannerConfigList".equals(localObject))
    {
      paramIExpandChannelCallback.success(null);
      return;
    }
    if ("getExpandConfig".equals(localObject))
    {
      paramIExpandChannelCallback.success(ExpandFlutterIPCClient.a().a("METHOD_GET_EXPAND_CONFIG", null).getString("ret"));
      return;
    }
    if ("getSelfBirthdate".equals(localObject))
    {
      ExpandFlutterIPCClient.a().a("METHOD_GET_BIRTH_DATE", new Bundle(), new ExpandConfigChannelHandler.5(paramIExpandChannelCallback));
      return;
    }
    if ("setSelfBirthdate".equals(localObject))
    {
      int i = ((Integer)paramMethodCall.argument("birthdate")).intValue();
      paramMethodCall = new Bundle();
      paramMethodCall.putInt("birthdate", i);
      ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DATE", paramMethodCall);
      return;
    }
    if ("setExpandBirthdayDialogShowFlag".equals(localObject))
    {
      ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DIALOG_FLAG", null);
      return;
    }
    if ("getExpandBirthdayDialogShowFlag".equals(localObject))
    {
      paramIExpandChannelCallback.success(Boolean.valueOf(ExpandFlutterIPCClient.a().a("METHOD_GET_BIRTH_DIALOG_FLAG", null).getBoolean("showflag")));
      return;
    }
    if ("createMessageNodeIfNeed".equals(localObject))
    {
      paramMethodCall = (String)paramMethodCall.argument("matchUin");
      ExpandFlutterIPCClient.a().a(paramMethodCall);
      return;
    }
    if ("batchCreateMessageNodeIfNeed".equals(localObject))
    {
      paramMethodCall = (Map)paramMethodCall.argument("matchInfoMap");
      ExpandFlutterIPCClient.a().a(paramMethodCall);
      paramIExpandChannelCallback.success(null);
      return;
    }
    if ("setSupportRightDragBack".equals(localObject))
    {
      paramIExpandChannelCallback.success(Boolean.valueOf(true));
      return;
    }
    if ("getExpandSecurityInfo".equals(localObject))
    {
      paramMethodCall = new Bundle();
      ExpandFlutterIPCClient.a().a("METHOD_GET_SECURITY_INFO", paramMethodCall, new ExpandConfigChannelHandler.6(paramIExpandChannelCallback));
      return;
    }
    if ("getABTestInfo".equals(localObject))
    {
      paramMethodCall = ExpandFlutterIPCClient.a().a("METHOD_GET_ABTEST_INFO", null).getString("data");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("abtest info : ");
      ((StringBuilder)localObject).append(paramMethodCall);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, ((StringBuilder)localObject).toString());
      paramIExpandChannelCallback.success(paramMethodCall);
      return;
    }
    if ("setQuietMode".equals(localObject))
    {
      boolean bool = ((Boolean)paramMethodCall.argument("isChecked")).booleanValue();
      paramMethodCall = new Bundle();
      paramMethodCall.putBoolean("isChecked", bool);
      ExpandFlutterIPCClient.a().a("METHOD_SET_QUIET_MODE", paramMethodCall, new ExpandConfigChannelHandler.7(paramIExpandChannelCallback));
      return;
    }
    if ("getQuietMode".equals(localObject))
    {
      ExpandFlutterIPCClient.a().a("METHOD_GET_QUIET_MODE", null, new ExpandConfigChannelHandler.8(paramIExpandChannelCallback));
      return;
    }
    if ("clearAllMsgs".equals(localObject))
    {
      paramMethodCall = ExpandFlutterIPCClient.a().a("METHOD_CLEAR_ALL_MSGS", null).getString("data");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear all msgs : ");
      ((StringBuilder)localObject).append(paramMethodCall);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, ((StringBuilder)localObject).toString());
      paramIExpandChannelCallback.success(paramMethodCall);
      return;
    }
    if ("getNetworkStatus".equals(localObject)) {
      ExpandFlutterIPCClient.a().a("getNetworkStatus", null, new ExpandConfigChannelHandler.9(paramIExpandChannelCallback));
    }
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    a(paramMethodCall, new ExpandConfigChannelHandler.1(this, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler
 * JD-Core Version:    0.7.0.1
 */