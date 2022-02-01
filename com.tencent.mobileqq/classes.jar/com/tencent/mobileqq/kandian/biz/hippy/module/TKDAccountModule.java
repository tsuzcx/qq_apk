package com.tencent.mobileqq.kandian.biz.hippy.module;

import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

@HippyNativeModule(name="TKDAccountModule")
public class TKDAccountModule
  extends HippyNativeModuleBase
{
  private static final int LOGIN_TYPE_QQ = 1;
  private static final String TAG = "AccountModule";
  
  public TKDAccountModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public static HippyMap convertAccountInfo2HippyMap(@NonNull AccountInfo paramAccountInfo)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("type", 1);
    localHippyMap.pushString("qbid", paramAccountInfo.qqNum);
    localHippyMap.pushString("uin", paramAccountInfo.qqNum);
    localHippyMap.pushString("token", paramAccountInfo.qqNum);
    localHippyMap.pushString("nickname", paramAccountInfo.nickName);
    localHippyMap.pushString("head", paramAccountInfo.headUrl);
    localHippyMap.pushString("skey", paramAccountInfo.skey);
    localHippyMap.pushString("appid", paramAccountInfo.appid);
    return localHippyMap;
  }
  
  @NonNull
  public static AccountInfo getCurAccountInfo()
  {
    long l = RIJQQAppInterfaceUtil.c();
    AccountInfo localAccountInfo = new AccountInfo();
    Object localObject = ReadInJoyUserInfoModule.a(l, null);
    if (localObject != null)
    {
      localAccountInfo.qqNum = ((ReadInJoyUserInfo)localObject).uin;
      localAccountInfo.nickName = ((ReadInJoyUserInfo)localObject).nick;
      localAccountInfo.headUrl = ReadInJoyUserInfoModule.a((ReadInJoyUserInfo)localObject);
    }
    localObject = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (localObject != null) {
      localAccountInfo.skey = ((TicketManager)localObject).getSkey(localAccountInfo.qqNum);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppSetting.d());
    ((StringBuilder)localObject).append("");
    localAccountInfo.appid = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurAccountInfo .accountInfo=");
    ((StringBuilder)localObject).append(localAccountInfo);
    QLog.d("AccountModule", 1, ((StringBuilder)localObject).toString());
    return localAccountInfo;
  }
  
  @HippyMethod(name="getAccountInfo")
  public void getAccountInfo(Promise paramPromise)
  {
    paramPromise.resolve(convertAccountInfo2HippyMap(getCurAccountInfo()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDAccountModule
 * JD-Core Version:    0.7.0.1
 */