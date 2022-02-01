package com.tencent.qqexpand;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterPlatformChannelMgr
{
  private static final String KEY_PUSH_MODULE = "FlutterPushModuleProtocol";
  private static volatile FlutterPlatformChannelMgr sInstance;
  private ExpandChannelDelegates mDelegateWrapper;
  private Map<String, FlutterPlatformProtocolBase> mProtocolWrapperSet = new HashMap();
  
  public static FlutterPlatformChannelMgr getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new FlutterPlatformChannelMgr();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void registerChannel(String paramString, FlutterPlatformProtocolBase paramFlutterPlatformProtocolBase)
  {
    if (this.mProtocolWrapperSet.containsKey(paramString))
    {
      FlutterPlatformProtocolBase localFlutterPlatformProtocolBase = (FlutterPlatformProtocolBase)this.mProtocolWrapperSet.get(paramString);
      this.mProtocolWrapperSet.remove(paramString);
      if (localFlutterPlatformProtocolBase != null) {
        localFlutterPlatformProtocolBase.onDestroy();
      }
      this.mProtocolWrapperSet.put(paramString, paramFlutterPlatformProtocolBase);
    }
  }
  
  public void destroy()
  {
    Iterator localIterator = this.mProtocolWrapperSet.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (FlutterPlatformProtocolBase)this.mProtocolWrapperSet.get(localObject);
      if (localObject != null) {
        ((FlutterPlatformProtocolBase)localObject).onDestroy();
      }
    }
    this.mProtocolWrapperSet.clear();
    this.mDelegateWrapper = null;
  }
  
  public ExpandChannelDelegates getChannelDelegates()
  {
    return this.mDelegateWrapper;
  }
  
  public void init(BinaryMessenger paramBinaryMessenger)
  {
    Log.d("Expand.PlatformChannelMgr", "init");
    paramBinaryMessenger = new FlutterPushModuleProtocol(paramBinaryMessenger);
    registerChannel("FlutterPushModuleProtocol", paramBinaryMessenger);
    ExpandChannelDelegates localExpandChannelDelegates = this.mDelegateWrapper;
    if ((localExpandChannelDelegates != null) && (localExpandChannelDelegates.mPushModuleDelegate != null)) {
      paramBinaryMessenger.setPushModuleDelegate(this.mDelegateWrapper.mPushModuleDelegate);
    }
  }
  
  public void setChannelDelegates(ExpandChannelDelegates paramExpandChannelDelegates)
  {
    Log.d("Expand.PlatformChannelMgr", "setChannelDelegates");
    this.mDelegateWrapper = paramExpandChannelDelegates;
    if (paramExpandChannelDelegates.mPushModuleDelegate != null)
    {
      FlutterPushModuleProtocol localFlutterPushModuleProtocol = (FlutterPushModuleProtocol)this.mProtocolWrapperSet.get("FlutterPushModuleProtocol");
      if (localFlutterPushModuleProtocol == null) {
        return;
      }
      localFlutterPushModuleProtocol.setPushModuleDelegate(paramExpandChannelDelegates.mPushModuleDelegate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqexpand.FlutterPlatformChannelMgr
 * JD-Core Version:    0.7.0.1
 */