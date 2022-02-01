package com.tencent.mobileqq.wxmini.impl.ui;

import android.util.Log;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errCode", "Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;", "errMsg", "", "onAuthFinish"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$3$3
  implements TdiAuthListener
{
  WxMiniDemoActivity$onCreate$3$3(WxMiniDemoActivity.onCreate.3 param3) {}
  
  public final void onAuthFinish(@NotNull TdiAuthErrCode paramTdiAuthErrCode, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTdiAuthErrCode, "errCode");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authHandle: errCode[");
    localStringBuilder.append(paramTdiAuthErrCode.name());
    localStringBuilder.append("], errMsg[");
    String str;
    if (paramString != null) {
      str = paramString;
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    Log.i("RuntimeSDKDemo.WxMiniDemoActivity", localStringBuilder.toString());
    this.a.a.runOnUiThread((Runnable)new WxMiniDemoActivity.onCreate.3.3.1(this, paramTdiAuthErrCode, paramString));
    WxMiniDemoActivity.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.3.3
 * JD-Core Version:    0.7.0.1
 */