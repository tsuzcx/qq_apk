package mqq.manager;

public abstract interface PushManager
  extends Manager
{
  public abstract void registProxyMessagePush(int paramInt, String paramString1, String paramString2, String... paramVarArgs);
  
  @Deprecated
  public abstract void unregistAllNotifyPush();
  
  public abstract void unregistProxyMessagePush(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.manager.PushManager
 * JD-Core Version:    0.7.0.1
 */