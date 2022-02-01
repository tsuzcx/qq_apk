package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WxMiniDemoActivity$refreshAuthState$1$1
  implements Runnable
{
  WxMiniDemoActivity$refreshAuthState$1$1(WxMiniDemoActivity.refreshAuthState.1 param1, TdiAuthState paramTdiAuthState, String paramString) {}
  
  public final void a()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = "未知";
    Object localObject = this.a;
    int i = WxMiniDemoActivity.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localObject = "未加载动态包";
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          localObject = "未登录";
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("已过期(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(')');
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("已登录(");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(")\n(");
      ((StringBuilder)localObject).append(WxMiniSDKImpl.a.c().getTdiUserId());
      ((StringBuilder)localObject).append(" ！！！重要,请将该id记录以便于提供给官方定位问题！！！)");
      localObject = ((StringBuilder)localObject).toString();
    }
    localObjectRef.element = localObject;
    this.this$0.a.runOnUiThread((Runnable)new WxMiniDemoActivity.refreshAuthState.1.1.1(this, localObjectRef));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.refreshAuthState.1.1
 * JD-Core Version:    0.7.0.1
 */