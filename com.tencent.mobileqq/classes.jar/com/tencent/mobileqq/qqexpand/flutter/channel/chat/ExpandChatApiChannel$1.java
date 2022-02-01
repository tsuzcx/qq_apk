package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.qqexpand.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
import java.util.HashMap;
import java.util.Map;

class ExpandChatApiChannel$1
  extends IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener
{
  ExpandChatApiChannel$1(ExpandChatApiChannel paramExpandChatApiChannel) {}
  
  public void a()
  {
    HashMap localHashMap = new HashMap();
    ExpandChatApiChannel.a(this.a, ExpandChatApiChannel.a[1], localHashMap);
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("infos", paramString);
    ExpandChatApiChannel.a(this.a, ExpandChatApiChannel.a[2], localHashMap);
  }
  
  public void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("info", paramString);
    ExpandChatApiChannel.a(this.a, ExpandChatApiChannel.a[3], localHashMap);
  }
  
  public void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("conversations", paramString);
    ExpandChatApiChannel.a(this.a, ExpandChatApiChannel.a[0], localHashMap);
  }
  
  public void b(String paramString, int paramInt)
  {
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel.1
 * JD-Core Version:    0.7.0.1
 */