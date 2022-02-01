package com.tencent.qqexpand;

public abstract class ExpandChannelDelegates
{
  protected FlutterPushModuleProtocol.PushModuleDelegate mPushModuleDelegate;
  
  public ExpandChannelDelegates()
  {
    initDelegate();
  }
  
  public FlutterPushModuleProtocol.PushModuleDelegate getPushModuleDelegate()
  {
    return this.mPushModuleDelegate;
  }
  
  public abstract void initDelegate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqexpand.ExpandChannelDelegates
 * JD-Core Version:    0.7.0.1
 */