package com.tencent.mobileqq.wxmini.impl.ui;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$refreshAuthState$1$1$1
  implements Runnable
{
  WxMiniDemoActivity$refreshAuthState$1$1$1(WxMiniDemoActivity.refreshAuthState.1.1 param1, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    Object localObject = this.this$0.this$0.a.findViewById(1862402056);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById<TextView>(R.id.tv_login_status)");
    localObject = (TextView)localObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("登录状态：");
    localStringBuilder.append((String)this.a.element);
    ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.refreshAuthState.1.1.1
 * JD-Core Version:    0.7.0.1
 */