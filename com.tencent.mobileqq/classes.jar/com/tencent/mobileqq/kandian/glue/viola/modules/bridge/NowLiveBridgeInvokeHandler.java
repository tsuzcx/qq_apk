package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/NowLiveBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "openRoom", "", "param", "Lorg/json/JSONObject;", "callback", "preload", "register", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class NowLiveBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final NowLiveBridgeInvokeHandler.Companion a = new NowLiveBridgeInvokeHandler.Companion(null);
  
  public NowLiveBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramString = paramJSONObject.optString("params");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonObject.optString(\"params\")");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("jumpType", 1);
      paramJSONObject.putString("roomid", paramString);
      paramJSONObject.putString("fromid", "violaCall");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nowlive openRoom  roomid = ");
        localStringBuilder.append(paramString);
        QLog.e("BridgeModule", 2, localStringBuilder.toString());
      }
      paramString = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
      paramString = paramString.getRuntime();
      if ((paramString instanceof QQAppInterface))
      {
        paramString = paramString.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
        if (paramString != null)
        {
          ((IDynamicNowManager)paramString).a(paramJSONObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager");
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    ThreadManager.post((Runnable)NowLiveBridgeInvokeHandler.preload.1.a, 8, null, true);
  }
  
  @NotNull
  public String a()
  {
    return "nowlive";
  }
  
  public void a()
  {
    NowLiveBridgeInvokeHandler localNowLiveBridgeInvokeHandler = (NowLiveBridgeInvokeHandler)this;
    a("openRoom", (Function2)new NowLiveBridgeInvokeHandler.register.1(localNowLiveBridgeInvokeHandler));
    a("preload", (Function2)new NowLiveBridgeInvokeHandler.register.2(localNowLiveBridgeInvokeHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.NowLiveBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */