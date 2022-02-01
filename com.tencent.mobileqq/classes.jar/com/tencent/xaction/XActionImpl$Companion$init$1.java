package com.tencent.xaction;

import com.tencent.xaction.openapi.api.IDownload;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XActionImpl$Companion$init$1", "Lcom/tencent/xaction/openapi/api/IDownload;", "requestFile", "", "id", "", "callback", "Lkotlin/Function2;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class XActionImpl$Companion$init$1
  implements IDownload
{
  public void requestFile(@NotNull String paramString, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"https", false, 2, null))
    {
      XActionImpl.a.a(paramString, paramFunction2);
      return;
    }
    XActionImpl.a.b(paramString, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XActionImpl.Companion.init.1
 * JD-Core Version:    0.7.0.1
 */