package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardProcessor;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.api.ITcSdkContext;
import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import com.tencent.treasurecard.bean.UserInfoReq;
import com.tencent.treasurecard.manager.TcSdkManager;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl;", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "()V", "mRequest", "Lcom/tencent/treasurecard/net/INetRequest;", "getMRequest", "()Lcom/tencent/treasurecard/net/INetRequest;", "setMRequest", "(Lcom/tencent/treasurecard/net/INetRequest;)V", "mStateListener", "Lcom/tencent/treasurecard/api/ITcSdkContext$OnCardStateChangeListener;", "managerName", "", "getManagerName", "()Ljava/lang/String;", "buildActiveReq", "Lcom/tencent/pb/vas/treasurecard/MobileOrderServer$GetFlowConfRequest;", "cardState", "", "checkActiveReq", "", "clearCacheAndRequest", "init", "", "isMobileOprt", "isWifi", "obtainCardInfo", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "from", "obtainCardState", "queryTreasureCard", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "requestHttp", "url", "treasureCardState", "userInfoReq", "Lcom/tencent/treasurecard/bean/UserInfoReq;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasFTManagerImpl
  implements IVasFTManager
{
  @NotNull
  private INetRequest a = (INetRequest)new VasFTManagerImpl.mRequest.1(this);
  private ITcSdkContext.OnCardStateChangeListener b = (ITcSdkContext.OnCardStateChangeListener)VasFTManagerImpl.mStateListener.1.a;
  
  private final UserInfoReq a()
  {
    return new UserInfoReq("P00000008797", String.valueOf(DeviceInfoUtil.g((Context)BaseApplication.getContext())));
  }
  
  private final String a(String paramString)
  {
    String str = (String)null;
    try
    {
      paramString = new OkHttpClient().newCall(new Request.Builder().url(paramString).build()).execute();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "response");
      if (paramString.isSuccessful())
      {
        paramString = paramString.body();
        if (paramString == null) {
          Intrinsics.throwNpe();
        }
        paramString = paramString.string();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(paramString.code()));
        localStringBuilder.append(paramString.message());
        paramString = localStringBuilder.toString();
      }
    }
    catch (Exception paramString)
    {
      paramString.toString();
      return str;
    }
    return paramString;
  }
  
  private final boolean a(int paramInt)
  {
    return (-1 != paramInt) && (TreasureUtil.a.d(TreasureCardProcessor.e().b));
  }
  
  private final MobileOrderServer.GetFlowConfRequest b(int paramInt)
  {
    MobileOrderServer.GetFlowConfRequest localGetFlowConfRequest = new MobileOrderServer.GetFlowConfRequest();
    int i = 2;
    if (paramInt != 1) {
      if (paramInt != 2) {
        i = 0;
      } else {
        i = 1;
      }
    }
    localGetFlowConfRequest.BizType.set(i);
    localGetFlowConfRequest.appid.set(10001);
    return localGetFlowConfRequest;
  }
  
  private final boolean b()
  {
    return DeviceInfoUtil.g((Context)BaseApplication.getContext()) == 1;
  }
  
  private final boolean c()
  {
    String str = DeviceInfoUtil.f((Context)BaseApplication.getContext()).a;
    if (str != null) {
      return str.equals("WIFI");
    }
    return true;
  }
  
  public boolean clearCacheAndRequest()
  {
    Object localObject = TcSdkManager.b();
    ((ITcSdkContext)localObject).a();
    TreasureUtil.a.b();
    boolean bool;
    if ((!c()) && (b()))
    {
      ((ITcSdkContext)localObject).a(null);
      bool = true;
    }
    else
    {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearCacheAndRequest ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("treasureCard", 2, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void init()
  {
    ITcSdkContext localITcSdkContext = TcSdkManager.b();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    localITcSdkContext.a(localAppRuntime.getApplicationContext());
    localITcSdkContext.a(this.a);
    localITcSdkContext.a(TreasureCardProcessor.e().a);
    localITcSdkContext.a(this.b);
    QLog.d("treasureCard", 2, "init");
  }
  
  @NotNull
  public VasFtCard obtainCardInfo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    Object localObject2 = TreasureUtil.a.c().getString("tc_active_url", "");
    String str = TreasureUtil.a.c().getString("tc_active_tips", "");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&from=");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    VasFtRepoter.a.a("B", paramString);
    VasFtRepoter.a.a("B", paramString, (String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("obtainCardInfo ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(str);
    QLog.d("treasureCard", 2, ((StringBuilder)localObject2).toString());
    return new VasFtCard((String)localObject1, "", str);
  }
  
  public int obtainCardState(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    int i = CUKingCardUtils.a();
    int j = TreasureUtil.a.a();
    if (i == 1) {
      i = 1;
    } else if (j == 1) {
      i = 2;
    } else if ((i != 0) && (j != 0)) {
      i = -1;
    } else {
      i = 0;
    }
    VasFtRepoter.a.a("A", paramString);
    VasFtRepoter.a.a("A", paramString, i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("obtainCardState ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" , ");
    localStringBuilder.append(i);
    QLog.d("treasureCard", 2, localStringBuilder.toString());
    return i;
  }
  
  public void queryTreasureCard(@NotNull INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramINetCallBack, "callBack");
    TcSdkManager.b().a((INetCallBack)new VasFTManagerImpl.queryTreasureCard.1(paramINetCallBack));
  }
  
  public int treasureCardState(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    return TreasureUtil.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl
 * JD-Core Version:    0.7.0.1
 */