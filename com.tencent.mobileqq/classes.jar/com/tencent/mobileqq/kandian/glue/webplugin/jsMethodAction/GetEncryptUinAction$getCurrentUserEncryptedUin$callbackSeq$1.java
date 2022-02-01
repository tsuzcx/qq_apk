package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class GetEncryptUinAction$getCurrentUserEncryptedUin$callbackSeq$1
  implements ITroopMemberApiClientApi.Callback
{
  GetEncryptUinAction$getCurrentUserEncryptedUin$callbackSeq$1(GetEncryptUinAction paramGetEncryptUinAction) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("resultCode");
    String str = paramBundle.getString("resultMsg");
    paramBundle = paramBundle.getString("iid", "");
    GetEncryptUinAction localGetEncryptUinAction = this.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "msg");
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "uin");
    GetEncryptUinAction.a(localGetEncryptUinAction, i, str, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.GetEncryptUinAction.getCurrentUserEncryptedUin.callbackSeq.1
 * JD-Core Version:    0.7.0.1
 */