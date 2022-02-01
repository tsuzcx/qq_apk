package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "authState", "Lcom/tencent/luggage/wxaapi/TdiAuthState;", "extraMsg", "", "kotlin.jvm.PlatformType", "onStateChecked"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$refreshAuthState$1
  implements TdiAuthCheckStateListener
{
  WxMiniDemoActivity$refreshAuthState$1(WxMiniDemoActivity paramWxMiniDemoActivity) {}
  
  public final void onStateChecked(@NotNull TdiAuthState paramTdiAuthState, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTdiAuthState, "authState");
    this.a.runOnUiThread((Runnable)new WxMiniDemoActivity.refreshAuthState.1.1(this, paramTdiAuthState, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.refreshAuthState.1
 * JD-Core Version:    0.7.0.1
 */