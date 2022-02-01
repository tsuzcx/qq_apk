package com.tencent.mobileqq.newnearby.hippy.module;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import org.json.JSONObject;

@HippyNativeModule(name="NearbyHippyDataModule")
public class NearbyHippyDataModule
  extends QQBaseModule
{
  private static final String TAG = "NearbyHippyDataModule";
  
  public NearbyHippyDataModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getUserInfo")
  public void getUserInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyDataModule", 2, "getUserInfo");
    Object localObject = getAppInterface();
    if ((localObject != null) && (((AppInterface)localObject).isLogin())) {
      try
      {
        paramHippyMap = ((AppInterface)localObject).getCurrentAccountUin();
        String str = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(paramHippyMap);
        localObject = new HippyMap();
        ((HippyMap)localObject).pushInt("retCode", 0);
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushString("uin", paramHippyMap);
        localHippyMap.pushString("nick", (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramHippyMap, "self_nick", ""));
        localHippyMap.pushInt("gender", ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramHippyMap, "self_gender", Integer.valueOf(-1))).intValue() - 1);
        localHippyMap.pushInt("age", ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramHippyMap, "self_age", Integer.valueOf(-1))).intValue());
        localHippyMap.pushString("skey", str);
        ((HippyMap)localObject).pushObject("data", localHippyMap);
        paramHippyMap = new StringBuilder();
        paramHippyMap.append("getUserInfo, rsp: ");
        paramHippyMap.append(((HippyMap)localObject).toJSONObject().toString());
        QLog.d("NearbyHippyDataModule", 2, paramHippyMap.toString());
        paramPromise.resolve(localObject);
        return;
      }
      catch (Throwable paramHippyMap)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userInfo error:");
        ((StringBuilder)localObject).append(paramHippyMap);
        QLog.e("NearbyHippyDataModule", 1, ((StringBuilder)localObject).toString());
        paramPromise.reject("getUserInfo fail");
      }
    }
    paramPromise.reject("getUserInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyDataModule
 * JD-Core Version:    0.7.0.1
 */