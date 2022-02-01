package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFtRepoter;", "", "()V", "APPKEY", "", "REQ_EVENT", "RSP_EVENT", "TAG", "getNetworkType", "reportActiveResp", "", "interFaceType", "from", "url", "reportFtRequest", "reportStateResp", "premiumState", "", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasFtRepoter
{
  public static final VasFtRepoter a = new VasFtRepoter();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("0DOU0I3BWB4O47OD", AppSetting.h(), "1000"));
  }
  
  @NotNull
  public final String a()
  {
    return String.valueOf(DeviceInfoUtil.g((Context)BaseApplication.getContext()));
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "interFaceType");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    if (TextUtils.isEmpty((CharSequence)paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", VasUtil.e());
    localHashMap.put("interface_type", paramString1);
    localHashMap.put("appid", paramString2);
    localHashMap.put("current_operator", a());
    QQUserAction.a("0DOU0I3BWB4O47OD", "qqvip_freeflow_make_request", true, -1L, -1L, (Map)localHashMap, true, true);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "interFaceType");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    if (TextUtils.isEmpty((CharSequence)paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", VasUtil.e());
    localHashMap.put("interface_type", paramString1);
    localHashMap.put("appid", paramString2);
    localHashMap.put("current_operator", a());
    localHashMap.put("premium_status", String.valueOf(paramInt));
    QQUserAction.a("0DOU0I3BWB4O47OD", "qqvip_freeflow_back_result", true, -1L, -1L, (Map)localHashMap, true, true);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "interFaceType");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    if (TextUtils.isEmpty((CharSequence)paramString2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", VasUtil.e());
    localHashMap.put("interface_type", paramString1);
    localHashMap.put("appid", paramString2);
    localHashMap.put("current_operator", a());
    localHashMap.put("url", Intrinsics.stringPlus(paramString3, ""));
    QQUserAction.a("0DOU0I3BWB4O47OD", "qqvip_freeflow_back_result", true, -1L, -1L, (Map)localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFtRepoter
 * JD-Core Version:    0.7.0.1
 */