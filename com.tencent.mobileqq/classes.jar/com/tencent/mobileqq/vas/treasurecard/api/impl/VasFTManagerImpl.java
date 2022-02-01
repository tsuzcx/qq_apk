package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfRequest;
import com.tencent.treasurecard.api.ITcSdkContext;
import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import com.tencent.treasurecard.bean.UserInfoReq;
import com.tencent.treasurecard.manager.TcSdkManager;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import com.tencent.treasurecard.util.VasFtNetUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl;", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "()V", "mRequest", "Lcom/tencent/treasurecard/net/INetRequest;", "getMRequest", "()Lcom/tencent/treasurecard/net/INetRequest;", "setMRequest", "(Lcom/tencent/treasurecard/net/INetRequest;)V", "mStateListener", "Lcom/tencent/treasurecard/api/ITcSdkContext$OnCardStateChangeListener;", "managerName", "", "getManagerName", "()Ljava/lang/String;", "buildFlowConfReq", "Lcom/tencent/pb/vas/treasurecard/MobileOrderServer$GetFlowConfRequest;", "init", "", "context", "Landroid/content/Context;", "obtainCardInfo", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "from", "obtainCardState", "", "queryTreasureCard", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "requestHttp", "url", "userInfoReq", "Lcom/tencent/treasurecard/bean/UserInfoReq;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasFTManagerImpl
  implements IVasFTManager
{
  private ITcSdkContext.OnCardStateChangeListener jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext$OnCardStateChangeListener = (ITcSdkContext.OnCardStateChangeListener)VasFTManagerImpl.mStateListener.1.a;
  @NotNull
  private INetRequest jdField_a_of_type_ComTencentTreasurecardNetINetRequest = (INetRequest)new VasFTManagerImpl.mRequest.1(this);
  
  private final MobileOrderServer.GetFlowConfRequest a()
  {
    MobileOrderServer.GetFlowConfRequest localGetFlowConfRequest = new MobileOrderServer.GetFlowConfRequest();
    int i = obtainCardState("");
    if (i <= 0) {
      i = 0;
    }
    localGetFlowConfRequest.BizType.set(i);
    localGetFlowConfRequest.appid.set(10001);
    return localGetFlowConfRequest;
  }
  
  private final UserInfoReq a()
  {
    UserInfoReq localUserInfoReq = new UserInfoReq("C10000000142", String.valueOf(VasFtNetUtil.a())).a("");
    Intrinsics.checkExpressionValueIsNotNull(localUserInfoReq, "UserInfoReq(FtConstants.…toString()).addUserId(\"\")");
    return localUserInfoReq;
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
  
  public void init(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    ITcSdkContext localITcSdkContext = TcSdkManager.a();
    localITcSdkContext.a(paramContext);
    localITcSdkContext.a(this.jdField_a_of_type_ComTencentTreasurecardNetINetRequest);
    localITcSdkContext.a(this.jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext$OnCardStateChangeListener);
  }
  
  @NotNull
  public VasFtCard obtainCardInfo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    return new VasFtCard(TreasureUtil.a.a().getString("tc_active_url", ""), "", TreasureUtil.a.a().getString("tc_active_tips", ""));
  }
  
  public int obtainCardState(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    int j = VasFtNetUtil.a();
    int i = 0;
    if (j != 1)
    {
      if (j != 2) {
        return -1;
      }
      paramString = TMSManager.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "TMSManager.getInstance()");
      if (paramString.b()) {
        return 2;
      }
    }
    else if (TreasureUtil.a.a() > 0)
    {
      i = 1;
    }
    return i;
  }
  
  public void queryTreasureCard(@NotNull INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramINetCallBack, "callBack");
    TcSdkManager.a().a((INetCallBack)new VasFTManagerImpl.queryTreasureCard.1(paramINetCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl
 * JD-Core Version:    0.7.0.1
 */