package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class ReadInjoyWebShareHelperAction$clientCallback$1
  implements ITroopMemberApiClientApi.Callback
{
  ReadInjoyWebShareHelperAction$clientCallback$1(ReadInjoyWebShareHelperAction paramReadInjoyWebShareHelperAction) {}
  
  public final void callback(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("methodName");
    if (Intrinsics.areEqual(localObject, "callBackToJs"))
    {
      localObject = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "resp");
      ((ReadInjoyWebShareHelperAction)localObject).a(paramBundle);
      return;
    }
    if (Intrinsics.areEqual(localObject, "onFontSizeChange"))
    {
      localObject = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "resp");
      ReadInjoyWebShareHelperAction.a((ReadInjoyWebShareHelperAction)localObject, paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("method name = ");
    paramBundle.append((String)localObject);
    QLog.e("", 2, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInjoyWebShareHelperAction.clientCallback.1
 * JD-Core Version:    0.7.0.1
 */