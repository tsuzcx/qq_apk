package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class OpenTKPublisherAction$clickEntryViewBtn$callbackSeq$1
  implements ITroopMemberApiClientApi.Callback
{
  OpenTKPublisherAction$clickEntryViewBtn$callbackSeq$1(OpenTKPublisherAction paramOpenTKPublisherAction) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("resultCode");
    String str1 = paramBundle.getString("resultMsg");
    paramBundle = new JSONObject(paramBundle.getString("publisherExtra"));
    if (i == 1) {
      QQToast.makeText((Context)BaseApplicationImpl.getContext(), 1, (CharSequence)str1, 0).show();
    }
    ReadInJoyJsMethodActionController localReadInJoyJsMethodActionController = ReadInJoyJsMethodActionController.a;
    String str2 = OpenTKPublisherAction.a(this.a);
    Intrinsics.checkExpressionValueIsNotNull(str1, "msg");
    localReadInJoyJsMethodActionController.a(str2, i, str1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction.clickEntryViewBtn.callbackSeq.1
 * JD-Core Version:    0.7.0.1
 */