package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.extendfriend.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper;
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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener = new ExpandChatApiChannel.1(this);
  private Map<Object, EventChannel.EventSink> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<Integer, ExpandBaseChannel.MethodChannelResultWrapper> b = new HashMap();
  
  static
  {
    jdField_a_of_type_IoFlutterPluginCommonMethodCodec = StandardMethodCodec.INSTANCE;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "onConversationUpdate", "onConversationListRefresh", "onOnlineStateChange", "onExtendFriendInfoUpdate" };
  }
  
  public ExpandChatApiChannel(BinaryMessenger paramBinaryMessenger)
  {
    a(paramBinaryMessenger);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    ExpandFlutterIPCClient.a().a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
  }
  
  private void a(ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ExpandChatApiChannel.2(this, paramMethodChannelResultWrapper, paramObject));
  }
  
  private void a(BinaryMessenger paramBinaryMessenger)
  {
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_chat." + jdField_a_of_type_ArrayOfJavaLangString[0], jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_chat." + jdField_a_of_type_ArrayOfJavaLangString[1], jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_chat." + jdField_a_of_type_ArrayOfJavaLangString[2], jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_chat." + jdField_a_of_type_ArrayOfJavaLangString[3], jdField_a_of_type_IoFlutterPluginCommonMethodCodec).setStreamHandler(this);
  }
  
  private void a(String paramString, Map<String, Object> paramMap)
  {
    EventChannel.EventSink localEventSink = (EventChannel.EventSink)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localEventSink != null)
    {
      localEventSink.success(paramMap);
      QLog.i("expand.chat.ExpandChatApiChannel", 1, "notify2Flutter " + paramString);
      return;
    }
    QLog.w("expand.chat.ExpandChatApiChannel", 1, "notify2Flutter " + paramString + ". sink is null!");
  }
  
  public MethodCodec a()
  {
    return jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ExpandFlutterIPCClient.a().b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
    this.b.clear();
    QLog.i("expand.chat.ExpandChatApiChannel", 1, "channel destroy");
  }
  
  public void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    Object localObject = paramMethodCall.method;
    if (QLog.isColorLevel()) {
      QLog.d("expand.chat.ExpandChatApiChannel", 2, "[onMethodCall] method=" + (String)localObject);
    }
    int i;
    if (TextUtils.equals("getConversationList", (CharSequence)localObject))
    {
      localObject = (String)paramMethodCall.argument("cursor");
      paramMethodCall = (Integer)paramMethodCall.argument("count");
      Bundle localBundle = new Bundle();
      localBundle.putString("cursor", (String)localObject);
      if (paramMethodCall == null)
      {
        i = 0;
        localBundle.putInt("count", i);
        ExpandFlutterIPCClient.a().a("METHOD_CHAT_GET_CONVERSATION_LIST", localBundle, new ExpandChatApiChannel.3(this, paramMethodChannelResultWrapper));
      }
    }
    do
    {
      return;
      i = paramMethodCall.intValue();
      break;
      if (TextUtils.equals("removeConversation", (CharSequence)localObject))
      {
        paramMethodCall = (ArrayList)paramMethodCall.argument("uinList");
        localObject = new Bundle();
        ((Bundle)localObject).putStringArrayList("uinList", paramMethodCall);
        ExpandFlutterIPCClient.a().a("METHOD_CHAT_REMOVE_CONVERSATION", (Bundle)localObject, new ExpandChatApiChannel.4(this, paramMethodChannelResultWrapper));
        return;
      }
      if (TextUtils.equals("getExtendFriendInfo", (CharSequence)localObject))
      {
        paramMethodCall = new Bundle();
        ExpandFlutterIPCClient.a().a("METHOD_REFRESH_EXTEND_FRIEND_INFO", paramMethodCall, new ExpandChatApiChannel.5(this, paramMethodChannelResultWrapper));
        return;
      }
    } while (!"getEmojFilePath".equals(localObject));
    paramMethodCall = (ArrayList)paramMethodCall.argument("emojServerIds");
    localObject = new Bundle();
    ((Bundle)localObject).putStringArrayList("data", paramMethodCall);
    ExpandFlutterIPCClient.a().a("METHOD_GET_SYS_EMOJI_FILE_PATH", (Bundle)localObject, new ExpandChatApiChannel.6(this, paramMethodChannelResultWrapper));
  }
  
  public String c()
  {
    return "method.expand_chat";
  }
  
  public void onCancel(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramObject);
    if (QLog.isColorLevel()) {
      QLog.i("expand.chat.ExpandChatApiChannel", 2, "onCancel ChatStreamHandler " + paramObject);
    }
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (QLog.isColorLevel()) {
      QLog.i("expand.chat.ExpandChatApiChannel", 2, "ChatStreamHandler. listen start " + paramObject);
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramObject))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramObject, paramEventSink);
      return;
    }
    QLog.w("expand.chat.ExpandChatApiChannel", 1, "ChatStreamHandler. try listen but already exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel
 * JD-Core Version:    0.7.0.1
 */