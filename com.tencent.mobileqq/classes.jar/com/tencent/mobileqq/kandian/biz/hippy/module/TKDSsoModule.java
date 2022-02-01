package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;

@HippyNativeModule(name="TKDSsoModule")
public class TKDSsoModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "TKDSsoModule";
  private static final String TAG = "TKDSsoModule";
  private QQBridgeModule mBridgeModule = new QQBridgeModule();
  
  public TKDSsoModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.mBridgeModule.setEngineId(paramHippyEngineContext.getEngineId());
  }
  
  @HippyMethod(name="send")
  public void send(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("TKDSsoModule", 1, new Object[] { paramHippyMap, paramPromise });
    if ((paramHippyMap != null) && (paramPromise != null)) {
      this.mBridgeModule.sendRequest(paramHippyMap.toJSONObject(), paramPromise.getCallId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDSsoModule
 * JD-Core Version:    0.7.0.1
 */