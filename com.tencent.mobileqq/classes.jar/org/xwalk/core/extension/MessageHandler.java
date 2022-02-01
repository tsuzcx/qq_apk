package org.xwalk.core.extension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public class MessageHandler
{
  private String TAG = "MessageHandler";
  private Map<String, MessageHandler.Handler> mHandlers = new HashMap();
  
  public MessageHandler() {}
  
  public MessageHandler(MessageHandler paramMessageHandler)
  {
    this.mHandlers.putAll(paramMessageHandler.mHandlers);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    Object localObject1 = paramMessageInfo.getJsName();
    Object localObject2 = (MessageHandler.Handler)this.mHandlers.get(localObject1);
    if ((localObject2 != null) && (((MessageHandler.Handler)localObject2).targetObject != null))
    {
      localObject1 = ((MessageHandler.Handler)localObject2).targetObject;
      if ((paramMessageInfo.getExtension().isAutoJS()) && (((MessageHandler.Handler)localObject2).reflection != null)) {
        try
        {
          paramMessageInfo = ((MessageHandler.Handler)localObject2).reflection.handleMessage(paramMessageInfo, localObject1);
          return paramMessageInfo;
        }
        catch (Exception paramMessageInfo)
        {
          Log.e(this.TAG, paramMessageInfo.toString());
          return null;
        }
      }
      try
      {
        paramMessageInfo = localObject1.getClass().getMethod(((MessageHandler.Handler)localObject2).javaName, new Class[] { MessageInfo.class }).invoke(localObject1, new Object[] { paramMessageInfo });
        return paramMessageInfo;
      }
      catch (IllegalAccessException paramMessageInfo) {}catch (IllegalArgumentException paramMessageInfo) {}catch (NoSuchMethodException paramMessageInfo) {}catch (InvocationTargetException paramMessageInfo) {}catch (SecurityException paramMessageInfo) {}
      Log.e(this.TAG, paramMessageInfo.toString());
      return null;
    }
    paramMessageInfo = this.TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Cannot find handler for method ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.w(paramMessageInfo, ((StringBuilder)localObject2).toString());
    return null;
  }
  
  public void register(String paramString, Object paramObject)
  {
    register(paramString, paramString, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, Object paramObject)
  {
    register(paramString1, paramString2, ReflectionHelper.MemberType.JS_METHOD, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject)
  {
    register(paramString1, paramString2, paramMemberType, paramObject, null);
  }
  
  public void register(String paramString1, String paramString2, ReflectionHelper.MemberType paramMemberType, Object paramObject, ReflectionHelper paramReflectionHelper)
  {
    if (this.mHandlers.containsKey(paramString1))
    {
      paramString2 = this.TAG;
      paramMemberType = new StringBuilder();
      paramMemberType.append("Existing handler for ");
      paramMemberType.append(paramString1);
      Log.w(paramString2, paramMemberType.toString());
      return;
    }
    paramString2 = new MessageHandler.Handler(this, paramString2, paramMemberType, paramObject, paramReflectionHelper);
    this.mHandlers.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.MessageHandler
 * JD-Core Version:    0.7.0.1
 */