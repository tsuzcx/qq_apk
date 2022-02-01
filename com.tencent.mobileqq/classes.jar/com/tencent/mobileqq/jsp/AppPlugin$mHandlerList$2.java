package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.util.privacy.handler.IJSPackageInfoHandler;
import com.tencent.mobileqq.util.privacy.handler.JSPackageInfoHandlerProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mobileqq/util/privacy/handler/IJSPackageInfoHandler;", "invoke"}, k=3, mv={1, 1, 16})
final class AppPlugin$mHandlerList$2
  extends Lambda
  implements Function0<List<? extends IJSPackageInfoHandler>>
{
  public static final 2 INSTANCE = new 2();
  
  AppPlugin$mHandlerList$2()
  {
    super(0);
  }
  
  @NotNull
  public final List<IJSPackageInfoHandler> invoke()
  {
    return new JSPackageInfoHandlerProvider().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppPlugin.mHandlerList.2
 * JD-Core Version:    0.7.0.1
 */