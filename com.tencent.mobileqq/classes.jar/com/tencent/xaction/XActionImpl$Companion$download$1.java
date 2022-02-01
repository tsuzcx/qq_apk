package com.tencent.xaction;

import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XActionImpl$Companion$download$1", "Lcom/tencent/vas/update/callback/listener/IUpdateListener;", "onLoadFail", "", "updateListenerParams", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "onLoadSuccess", "onProgress", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class XActionImpl$Companion$download$1
  implements IUpdateListener
{
  XActionImpl$Companion$download$1(Function2 paramFunction2, XAResBusiness paramXAResBusiness, String paramString) {}
  
  public void onLoadFail(@NotNull UpdateListenerParams paramUpdateListenerParams)
  {
    Intrinsics.checkParameterIsNotNull(paramUpdateListenerParams, "updateListenerParams");
    XActionImpl.Companion.a(XActionImpl.a, this.a, "failed", "");
  }
  
  public void onLoadSuccess(@NotNull UpdateListenerParams paramUpdateListenerParams)
  {
    Intrinsics.checkParameterIsNotNull(paramUpdateListenerParams, "updateListenerParams");
    paramUpdateListenerParams = XActionImpl.a;
    Function2 localFunction2 = this.a;
    String str = this.b.e(this.c);
    Intrinsics.checkExpressionValueIsNotNull(str, "business.getSavePath(scid)");
    XActionImpl.Companion.a(paramUpdateListenerParams, localFunction2, "success", str);
  }
  
  public void onProgress(@NotNull UpdateListenerParams paramUpdateListenerParams)
  {
    Intrinsics.checkParameterIsNotNull(paramUpdateListenerParams, "updateListenerParams");
    XActionImpl.Companion.a(XActionImpl.a, this.a, "progress", String.valueOf(paramUpdateListenerParams.mProgress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XActionImpl.Companion.download.1
 * JD-Core Version:    0.7.0.1
 */