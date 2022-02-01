package com.tencent.timi.game.tim.api.impl;

import android.content.Context;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.env.ServerEnvInfo;
import com.tencent.timi.game.utils.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "code", "", "result", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class TimiGameTimApiImpl$initSdk$1
  implements OnLoadListener
{
  TimiGameTimApiImpl$initSdk$1(TimiGameTimApiImpl paramTimiGameTimApiImpl, V2TIMSDKListener paramV2TIMSDKListener) {}
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load so, code[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], result[");
    ((StringBuilder)localObject).append(paramLoadExtResult);
    ((StringBuilder)localObject).append(']');
    Logger.a("TimManager", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramLoadExtResult, "result");
      if (paramLoadExtResult.isSucc())
      {
        localObject = this.a;
        paramLoadExtResult = new File(paramLoadExtResult.getSoLoadPath()).getParent();
        Intrinsics.checkExpressionValueIsNotNull(paramLoadExtResult, "File(result.soLoadPath).parent");
        TimiGameTimApiImpl.a((TimiGameTimApiImpl)localObject, paramLoadExtResult);
        TimiGameTimApiImpl.a(true);
        BaseManager.getInstance().setLibraryPath(TimiGameTimApiImpl.a(this.a));
        paramLoadExtResult = V2TIMManager.getInstance();
        localObject = (Context)BaseApplication.getContext();
        ServerEnvInfo localServerEnvInfo = ServerEnv.d();
        Intrinsics.checkExpressionValueIsNotNull(localServerEnvInfo, "ServerEnv.getCurEnvInfo()");
        paramLoadExtResult.initSDK((Context)localObject, localServerEnvInfo.a(), new V2TIMSDKConfig(), this.b);
        return;
      }
    }
    paramLoadExtResult = this.b;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.onConnectFailed(paramInt, "load so failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.initSdk.1
 * JD-Core Version:    0.7.0.1
 */