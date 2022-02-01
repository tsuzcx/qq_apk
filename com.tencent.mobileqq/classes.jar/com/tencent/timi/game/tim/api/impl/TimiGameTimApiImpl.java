package com.tencent.timi.game.tim.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.env.ServerEnvInfo;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.group.IGroupManager;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.tim.api.impl.group.GroupManager;
import com.tencent.timi.game.tim.api.impl.message.C2CMsgManager;
import com.tencent.timi.game.tim.api.impl.message.GroupMsgManager;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import request.GetUserSignRequest;
import request.GetUserSignRequest.Companion;
import trpc.yes.common.MessageOuterClass.TimMsgBody;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl;", "Lcom/tencent/timi/game/tim/api/ITimiGameTimApi;", "()V", "groupManager", "Lcom/tencent/timi/game/tim/api/group/IGroupManager;", "imSdkSoPath", "", "isLogining", "", "loginCallbacks", "", "Lcom/tencent/timi/game/tim/api/ILoginCallback;", "mapC2CMessageManager", "", "", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "mapGroupMessageManager", "msgListener", "com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$msgListener$1", "Lcom/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$msgListener$1;", "msgListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/tim/api/message/INewMsgListener;", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "userSign", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "checkInit", "", "getC2CMsgManager", "uid", "getGroupManager", "getGroupMsgManager", "groupId", "getUserSig", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "init", "context", "Landroid/content/Context;", "initSdk", "listener", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "internalDirectLogin", "uin", "internalLogin", "isLoaded", "isUserSignValid", "login", "logout", "notifyGroupMsg", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "registerListener", "saveUserSign", "serviceDestroy", "unregisterListener", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl
  implements ITimiGameTimApi
{
  public static final TimiGameTimApiImpl.Companion a = new TimiGameTimApiImpl.Companion(null);
  private static boolean l;
  private final Lazy b = LazyKt.lazy((Function0)TimiGameTimApiImpl.sp.2.INSTANCE);
  private String c = "";
  private IGroupManager d;
  private Map<Long, IMsgManager> e = (Map)new LinkedHashMap();
  private Map<Long, IMsgManager> f = (Map)new LinkedHashMap();
  private CopyOnWriteArrayList<INewMsgListener> g = new CopyOnWriteArrayList();
  private boolean h;
  private List<ILoginCallback> i = (List)new ArrayList();
  private TcloudServerOuterClass.GetUserTCloudSignRsp j = new TcloudServerOuterClass.GetUserTCloudSignRsp();
  private TimiGameTimApiImpl.msgListener.1 k = new TimiGameTimApiImpl.msgListener.1(this);
  
  private final void a(V2TIMSDKListener paramV2TIMSDKListener)
  {
    Object localObject = BaseManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseManager.getInstance()");
    if (!((BaseManager)localObject).isInited())
    {
      if (l)
      {
        BaseManager.getInstance().setLibraryPath(this.c);
        localObject = V2TIMManager.getInstance();
        Context localContext = (Context)BaseApplication.getContext();
        ServerEnvInfo localServerEnvInfo = ServerEnv.d();
        Intrinsics.checkExpressionValueIsNotNull(localServerEnvInfo, "ServerEnv.getCurEnvInfo()");
        ((V2TIMManager)localObject).initSDK(localContext, localServerEnvInfo.a(), new V2TIMSDKConfig(), paramV2TIMSDKListener);
        return;
      }
      Logger.a("TimManager", "load ImSDK so ");
      SoLoadManager.getInstance().load("ImSDK", (OnLoadListener)new TimiGameTimApiImpl.initSdk.1(this, paramV2TIMSDKListener));
    }
  }
  
  private final void a(String paramString, ILoginCallback paramILoginCallback)
  {
    String str = this.j.im_sign.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("login uid[");
    localStringBuilder.append(LogUtil.getSafePrintUin(paramString));
    localStringBuilder.append("], sig[");
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    Logger.a("TimManager", localStringBuilder.toString());
    if (paramILoginCallback != null) {
      this.i.add(paramILoginCallback);
    }
    if (this.h) {
      return;
    }
    this.h = true;
    V2TIMManager.getInstance().login(paramString, str, (V2TIMCallback)new TimiGameTimApiImpl.internalDirectLogin.2(this, paramString));
  }
  
  private final void b(ILoginCallback paramILoginCallback)
  {
    Logger.b("TimManager", "internalLogin");
    Object localObject1 = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
    localObject1 = ((ILoginCoreService)localObject1).b();
    Object localObject2 = V2TIMManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "V2TIMManager.getInstance()");
    int m = ((V2TIMManager)localObject2).getLoginStatus();
    int n = 1;
    if (m == 1)
    {
      localObject2 = V2TIMManager.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "V2TIMManager.getInstance()");
      if (Intrinsics.areEqual(((V2TIMManager)localObject2).getLoginUser(), localObject1))
      {
        Logger.b("TimManager", "internalLogin direct suc");
        if (paramILoginCallback != null) {
          paramILoginCallback.a();
        }
        return;
      }
    }
    localObject2 = (CharSequence)this.j.im_sign.get();
    m = n;
    if (localObject2 != null) {
      if (StringsKt.isBlank((CharSequence)localObject2)) {
        m = n;
      } else {
        m = 0;
      }
    }
    if (m != 0)
    {
      a((IResultListener)new TimiGameTimApiImpl.internalLogin.1(this, (String)localObject1, paramILoginCallback));
      return;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "uin");
    a((String)localObject1, paramILoginCallback);
  }
  
  private final void c(long paramLong)
  {
    SharedPreferences.Editor localEditor = e().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expire_time_");
    localStringBuilder.append(paramLong);
    localEditor.putInt(localStringBuilder.toString(), this.j.expire_time.get());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_sig_");
    localStringBuilder.append(paramLong);
    localEditor.putString(localStringBuilder.toString(), this.j.im_sign.get());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_sig_");
    localStringBuilder.append(paramLong);
    localEditor.putString(localStringBuilder.toString(), this.j.trtc_sign.get());
    localEditor.apply();
  }
  
  private final SharedPreferences e()
  {
    return (SharedPreferences)this.b.getValue();
  }
  
  private final boolean f()
  {
    String str = this.j.im_sign.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "userSign.im_sign.get()");
    if ((StringsKt.isBlank((CharSequence)str) ^ true))
    {
      str = this.j.trtc_sign.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "userSign.trtc_sign.get()");
      if (((StringsKt.isBlank((CharSequence)str) ^ true)) && (this.j.expire_time.get() - System.currentTimeMillis() / 1000 > 3600000L)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public IMsgManager a(long paramLong)
  {
    if (this.e.get(Long.valueOf(paramLong)) == null) {
      this.e.put(Long.valueOf(paramLong), new C2CMsgManager(LongExKt.a(paramLong)));
    }
    Object localObject = this.e.get(Long.valueOf(paramLong));
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (IMsgManager)localObject;
  }
  
  public void a()
  {
    a(null);
    Object localObject1 = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
    localObject1 = ((ILoginCoreService)localObject1).b();
    Object localObject2 = this.j.expire_time;
    SharedPreferences localSharedPreferences = e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expire_time_");
    localStringBuilder.append((String)localObject1);
    ((PBUInt32Field)localObject2).set(localSharedPreferences.getInt(localStringBuilder.toString(), 0));
    localObject2 = this.j.im_sign;
    localSharedPreferences = e();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_sig_");
    localStringBuilder.append((String)localObject1);
    ((PBStringField)localObject2).set(localSharedPreferences.getString(localStringBuilder.toString(), ""));
    localObject2 = this.j.trtc_sign;
    localSharedPreferences = e();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_sig_");
    localStringBuilder.append((String)localObject1);
    ((PBStringField)localObject2).set(localSharedPreferences.getString(localStringBuilder.toString(), ""));
    if (!f()) {
      a(null);
    }
  }
  
  public void a(@Nullable Context paramContext)
  {
    d();
  }
  
  public void a(@Nullable ILoginCallback paramILoginCallback)
  {
    Logger.b("TimManager", "login");
    BaseManager localBaseManager = BaseManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localBaseManager, "BaseManager.getInstance()");
    if (!localBaseManager.isInited())
    {
      a((V2TIMSDKListener)new TimiGameTimApiImpl.login.1(this, paramILoginCallback));
      return;
    }
    b(paramILoginCallback);
  }
  
  public void a(@NotNull INewMsgListener paramINewMsgListener)
  {
    Intrinsics.checkParameterIsNotNull(paramINewMsgListener, "listener");
    if (this.g.isEmpty()) {
      V2TIMManager.getMessageManager().addAdvancedMsgListener((V2TIMAdvancedMsgListener)this.k);
    }
    if (!this.g.contains(paramINewMsgListener)) {
      this.g.add(paramINewMsgListener);
    }
  }
  
  public void a(@Nullable IResultListener<TcloudServerOuterClass.GetUserTCloudSignRsp> paramIResultListener)
  {
    if (f())
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(this.j);
      }
      return;
    }
    if (QBaseActivity.sTopActivity == null)
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(-1, "appRuntime null");
      }
      return;
    }
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    long l1 = ((ILoginCoreService)localIService).a();
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetUserSignRequest.a.a(l1), TcloudServerOuterClass.GetUserTCloudSignRsp.class, (RequestListener)new TimiGameTimApiImpl.getUserSig.1(this, l1, paramIResultListener));
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.TimMsgBody paramTimMsgBody)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupId");
    Intrinsics.checkParameterIsNotNull(paramTimMsgBody, "timMsgBody");
    if (UStringsKt.toULongOrNull(paramString) == null) {
      return;
    }
    Iterator localIterator = ((Iterable)this.g).iterator();
    while (localIterator.hasNext()) {
      ((INewMsgListener)localIterator.next()).a(UStringsKt.toULong(paramString), paramTimMsgBody);
    }
  }
  
  @NotNull
  public IMsgManager b(long paramLong)
  {
    if (this.f.get(Long.valueOf(paramLong)) == null) {
      this.f.put(Long.valueOf(paramLong), new GroupMsgManager(LongExKt.a(paramLong)));
    }
    Object localObject = this.f.get(Long.valueOf(paramLong));
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (IMsgManager)localObject;
  }
  
  public void b(@NotNull INewMsgListener paramINewMsgListener)
  {
    Intrinsics.checkParameterIsNotNull(paramINewMsgListener, "listener");
    this.g.remove(paramINewMsgListener);
    if (this.g.isEmpty()) {
      V2TIMManager.getMessageManager().removeAdvancedMsgListener((V2TIMAdvancedMsgListener)this.k);
    }
  }
  
  public boolean b()
  {
    return l;
  }
  
  public void c()
  {
    this.j = new TcloudServerOuterClass.GetUserTCloudSignRsp();
    V2TIMManager.getInstance().logout((V2TIMCallback)new TimiGameTimApiImpl.logout.1());
  }
  
  @NotNull
  public IGroupManager d()
  {
    if (this.d == null) {
      this.d = ((IGroupManager)new GroupManager());
    }
    IGroupManager localIGroupManager = this.d;
    if (localIGroupManager == null) {
      Intrinsics.throwNpe();
    }
    return localIGroupManager;
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl
 * JD-Core Version:    0.7.0.1
 */