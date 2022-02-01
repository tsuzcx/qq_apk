package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl;
import com.tencent.mobileqq.vas.util.VasUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$vasFtManager$2
  extends Lambda
  implements Function0<VasFTManagerImpl>
{
  public static final 2 INSTANCE = new 2();
  
  VasServiceImpl$vasFtManager$2()
  {
    super(0);
  }
  
  @NotNull
  public final VasFTManagerImpl invoke()
  {
    VasFTManagerImpl localVasFTManagerImpl = new VasFTManagerImpl();
    Object localObject = VasUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VasUtil.getAppInterface()");
    localObject = ((AppInterface)localObject).getApplicationContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VasUtil.getAppInterface().applicationContext");
    localVasFTManagerImpl.init((Context)localObject);
    return localVasFTManagerImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.vasFtManager.2
 * JD-Core Version:    0.7.0.1
 */