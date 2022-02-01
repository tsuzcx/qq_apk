package org.xwalk.core.extension;

public class MessageHandler$Handler
{
  String javaName;
  ReflectionHelper reflection;
  Object targetObject;
  ReflectionHelper.MemberType type;
  
  public MessageHandler$Handler(MessageHandler paramMessageHandler, String paramString, ReflectionHelper.MemberType paramMemberType, Object paramObject)
  {
    this(paramMessageHandler, paramString, paramMemberType, paramObject, null);
  }
  
  public MessageHandler$Handler(MessageHandler paramMessageHandler, String paramString, ReflectionHelper.MemberType paramMemberType, Object paramObject, ReflectionHelper paramReflectionHelper)
  {
    this.type = paramMemberType;
    this.javaName = paramString;
    this.targetObject = paramObject;
    this.reflection = paramReflectionHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.MessageHandler.Handler
 * JD-Core Version:    0.7.0.1
 */