package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel.MethodChannelResultWrapper;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpandChatApiChannel
  extends ExpandBaseChannel
  implements EventChannel.StreamHandler
{
  public static final MethodCodec a;
  public static final String[] a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener jdField_a_of_type_ComTencentMobileqqQqexpandIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener = new ExpandChatApiChannel.1(this);
  private final Map<Object, EventChannel.EventSink> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map<Integer, ExpandBaseChannel.MethodChannelResultWrapper> b = new HashMap();
  
  static
  {
    jdField_a_of_type_IoFlutterPluginCommonMethodCodec = StandardMethodCodec.INSTANCE;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "onConversationUpdate", "onConversationListRefresh", "onOnlineStateChange", "onExtendFriendInfoUpdate" };
  }
  
  public ExpandChatApiChannel(BinaryMessenger paramBinaryMessenger)
  {
    a(paramBinaryMessenger);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    ExpandFlutterIPCClient.a().a(this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
  }
  
  private void a(ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ExpandChatApiChannel.2(this, paramMethodChannelResultWrapper, paramObject));
  }
  
  private void a(BinaryMessenger paramBinaryMessenger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/event.expand_chat.");
    localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[0]);
    new EventChannel(paramBinaryMessenger, localStringBuilder.toString(), jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/event.expand_chat.");
    localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[1]);
    new EventChannel(paramBinaryMessenger, localStringBuilder.toString(), jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/event.expand_chat.");
    localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[2]);
    new EventChannel(paramBinaryMessenger, localStringBuilder.toString(), jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/event.expand_chat.");
    localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[3]);
    new EventChannel(paramBinaryMessenger, localStringBuilder.toString(), jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
  }
  
  public static void a(@NonNull MethodCall paramMethodCall, IExpandChannelCallback paramIExpandChannelCallback)
  {
    Object localObject1 = paramMethodCall.method;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onMethodCall] method=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("expand.chat.ExpandChatApiChannel", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.equals("getConversationList", (CharSequence)localObject1))
    {
      localObject1 = (String)paramMethodCall.argument("cursor");
      paramMethodCall = (Integer)paramMethodCall.argument("count");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cursor", (String)localObject1);
      int i;
      if (paramMethodCall == null) {
        i = 0;
      } else {
        i = paramMethodCall.intValue();
      }
      ((Bundle)localObject2).putInt("count", i);
      ExpandFlutterIPCClient.a().a("METHOD_CHAT_GET_CONVERSATION_LIST", (Bundle)localObject2, new ExpandChatApiChannel.4(paramIExpandChannelCallback));
      return;
    }
    if (TextUtils.equals("removeConversation", (CharSequence)localObject1))
    {
      paramMethodCall = (ArrayList)paramMethodCall.argument("uinList");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putStringArrayList("uinList", paramMethodCall);
      ExpandFlutterIPCClient.a().a("METHOD_CHAT_REMOVE_CONVERSATION", (Bundle)localObject1, new ExpandChatApiChannel.5(paramIExpandChannelCallback));
      return;
    }
    if (TextUtils.equals("getExtendFriendInfo", (CharSequence)localObject1))
    {
      paramMethodCall = new Bundle();
      ExpandFlutterIPCClient.a().a("METHOD_REFRESH_EXTEND_FRIEND_INFO", paramMethodCall, new ExpandChatApiChannel.6(paramIExpandChannelCallback));
      return;
    }
    if ("getEmojFilePath".equals(localObject1))
    {
      paramMethodCall = (ArrayList)paramMethodCall.argument("emojServerIds");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putStringArrayList("data", paramMethodCall);
      ExpandFlutterIPCClient.a().a("METHOD_GET_SYS_EMOJI_FILE_PATH", (Bundle)localObject1, new ExpandChatApiChannel.7(paramIExpandChannelCallback));
    }
  }
  
  private void a(String paramString, Map<String, Object> paramMap)
  {
    EventChannel.EventSink localEventSink = (EventChannel.EventSink)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localEventSink != null)
    {
      localEventSink.success(paramMap);
      paramMap = new StringBuilder();
      paramMap.append("notify2Flutter ");
      paramMap.append(paramString);
      QLog.i("expand.chat.ExpandChatApiChannel", 1, paramMap.toString());
      return;
    }
    paramMap = new StringBuilder();
    paramMap.append("notify2Flutter ");
    paramMap.append(paramString);
    paramMap.append(". sink is null!");
    QLog.w("expand.chat.ExpandChatApiChannel", 1, paramMap.toString());
  }
  
  public MethodCodec a()
  {
    return jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ExpandFlutterIPCClient.a().b(this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
    this.b.clear();
    QLog.i("expand.chat.ExpandChatApiChannel", 1, "channel destroy");
  }
  
  protected void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    a(paramMethodCall, new ExpandChatApiChannel.3(this, paramMethodChannelResultWrapper));
  }
  
  protected String c()
  {
    return "method.expand_chat";
  }
  
  public void onCancel(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancel ChatStreamHandler ");
      localStringBuilder.append(paramObject);
      QLog.i("expand.chat.ExpandChatApiChannel", 2, localStringBuilder.toString());
    }
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChatStreamHandler. listen start ");
      localStringBuilder.append(paramObject);
      QLog.i("expand.chat.ExpandChatApiChannel", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramObject))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramObject, paramEventSink);
      return;
    }
    QLog.w("expand.chat.ExpandChatApiChannel", 1, "ChatStreamHandler. try listen but already exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel
 * JD-Core Version:    0.7.0.1
 */