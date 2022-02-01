package com.tencent.mobileqq.newnearby.hippy.module;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wifi.Base64;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@HippyNativeModule(name="NearbyHippySSOModule")
public class NearbyHippySSOModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "NearbyHippySSOModule";
  
  public NearbyHippySSOModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="sendData")
  public void sendData(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("pbsend readableMap=");
    ((StringBuilder)localObject1).append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippySSOModule", 2, ((StringBuilder)localObject1).toString());
    localObject1 = paramHippyMap.getString("cmd");
    Object localObject2 = paramHippyMap.getString("data");
    paramHippyMap = BaseApplicationImpl.getApplication().getRuntime();
    localObject2 = Base64.a((String)localObject2, 0);
    ProtoUtils.a(paramHippyMap, new NearbyHippySSOModule.1(this, (byte[])localObject2, paramPromise), (byte[])localObject2, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.module.NearbyHippySSOModule
 * JD-Core Version:    0.7.0.1
 */