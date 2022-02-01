package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$onCreate$2$1$1
  implements Runnable
{
  WxMiniDemoActivity$onCreate$2$1$1(WxMiniDemoActivity.onCreate.2.1 param1, TdiAuthErrCode paramTdiAuthErrCode, String paramString) {}
  
  public final void run()
  {
    Context localContext = (Context)this.this$0.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authHandle: errCode[");
    localStringBuilder.append(this.a.name());
    localStringBuilder.append("], errMsg[");
    String str = this.b;
    if (str == null) {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    Toast.makeText(localContext, (CharSequence)localStringBuilder.toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.2.1.1
 * JD-Core Version:    0.7.0.1
 */