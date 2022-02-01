package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.biz.hippy.api.IHippyWupCallback;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;

@HippyNativeModule(name="TKDWupModule")
public class TKDWupModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "HippyQQWupModule";
  protected QQAppInterface app;
  protected BroadcastReceiver mAccountChangedReceiver = new TKDWupModule.2(this);
  protected UniteSearchObserver mUniteSearchObserver = new TKDWupModule.1(this);
  private Integer requestId;
  private IHippyWupCallback wupCallbackManager;
  
  public TKDWupModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void doSend(HippyMap paramHippyMap, Promise paramPromise, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        String str1 = paramHippyMap.getString("serviceName");
        String str2 = paramHippyMap.getString("funcName");
        String str3 = paramHippyMap.getString("reqName");
        String str5 = paramHippyMap.getString("rspClassName");
        String str4 = paramHippyMap.getString("reqClassName");
        localObject = paramHippyMap.getString("base64data");
        paramHippyMap = paramHippyMap.getString("rspName");
        IHippyWupCallback localIHippyWupCallback = this.wupCallbackManager;
        Integer localInteger = Integer.valueOf(this.requestId.intValue() + 1);
        this.requestId = localInteger;
        localIHippyWupCallback.registerWupCallback(paramHippyMap, str5, paramPromise, localInteger);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          if (paramBoolean) {
            break label282;
          }
          if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
          {
            break label282;
            paramHippyMap = Base64Util.decode(paramHippyMap, 0);
            localObject = new TKDWupUniPacket();
            ((TKDWupUniPacket)localObject).setServantName(str1);
            ((TKDWupUniPacket)localObject).setFuncName(str2);
            ((TKDWupUniPacket)localObject).setEncodeName("UTF-8");
            ((TKDWupUniPacket)localObject).setRequestId(this.requestId.intValue());
            ((TKDWupUniPacket)localObject).putRawRequestData(str3, str4, paramHippyMap);
            new UniteSearchHandler((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(((TKDWupUniPacket)localObject).encode(), this.wupCallbackManager, this.requestId);
          }
        }
        throw new IllegalArgumentException("Invalid Params when sending wup from Hippy!!!!!");
      }
      catch (Throwable paramHippyMap)
      {
        QLog.e("WupModule", 1, "Error Sending Hippy WUP Requeset");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wup send error, cause: ");
        ((StringBuilder)localObject).append(paramHippyMap.getMessage());
        paramPromise.reject(((StringBuilder)localObject).toString());
        return;
      }
      label282:
      paramHippyMap = (HippyMap)localObject;
      if (localObject == null) {
        paramHippyMap = "";
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.app.removeObserver(this.mUniteSearchObserver);
    if ((this.mContext != null) && (this.mContext.getGlobalConfigs() != null) && (this.mContext.getGlobalConfigs().getContext() != null)) {
      this.mContext.getGlobalConfigs().getContext().unregisterReceiver(this.mAccountChangedReceiver);
    }
  }
  
  public void initialize()
  {
    this.wupCallbackManager = new TKDWupModule.HippyWupCallbackManager();
    this.requestId = Integer.valueOf(0);
    this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.app.addObserver(this.mUniteSearchObserver);
    if ((this.mContext != null) && (this.mContext.getGlobalConfigs() != null) && (this.mContext.getGlobalConfigs().getContext() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
      this.mContext.getGlobalConfigs().getContext().registerReceiver(this.mAccountChangedReceiver, localIntentFilter);
    }
  }
  
  @HippyMethod(name="pbSend")
  public void pbsend(HippyMap paramHippyMap, Promise paramPromise)
  {
    doSend(paramHippyMap, paramPromise, true);
  }
  
  @HippyMethod(name="send")
  public void send(HippyMap paramHippyMap, Promise paramPromise)
  {
    doSend(paramHippyMap, paramPromise, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDWupModule
 * JD-Core Version:    0.7.0.1
 */