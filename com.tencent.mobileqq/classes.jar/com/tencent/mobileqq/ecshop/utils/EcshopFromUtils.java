package com.tencent.mobileqq.ecshop.utils;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/utils/EcshopFromUtils;", "", "()V", "isQQShopAccount", "", "session", "Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;", "isShopOrWalletPubAccount", "uin", "", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public final class EcshopFromUtils
{
  public static final EcshopFromUtils a = new EcshopFromUtils();
  
  @JvmStatic
  public static final boolean a(@Nullable BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramBaseSessionInfo != null) {
      paramBaseSessionInfo = paramBaseSessionInfo.a;
    } else {
      paramBaseSessionInfo = null;
    }
    return Intrinsics.areEqual(paramBaseSessionInfo, "3046055438");
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString)
  {
    return (Intrinsics.areEqual("3046055438", paramString)) || (Intrinsics.areEqual("2711679534", paramString));
  }
  
  @JvmStatic
  public static final boolean b(@Nullable BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramBaseSessionInfo != null) {
      paramBaseSessionInfo = paramBaseSessionInfo.a;
    } else {
      paramBaseSessionInfo = null;
    }
    return a(paramBaseSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.EcshopFromUtils
 * JD-Core Version:    0.7.0.1
 */