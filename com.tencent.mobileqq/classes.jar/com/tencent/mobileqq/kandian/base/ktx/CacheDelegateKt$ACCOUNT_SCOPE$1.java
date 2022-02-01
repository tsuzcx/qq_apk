package com.tencent.mobileqq.kandian.base.ktx;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class CacheDelegateKt$ACCOUNT_SCOPE$1
  extends Lambda
  implements Function0<String>
{
  public static final 1 INSTANCE = new 1();
  
  CacheDelegateKt$ACCOUNT_SCOPE$1()
  {
    super(0);
  }
  
  public final String invoke()
  {
    String str = RIJQQAppInterfaceUtil.d();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJQQAppInterfaceUtil.getAccount()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.CacheDelegateKt.ACCOUNT_SCOPE.1
 * JD-Core Version:    0.7.0.1
 */