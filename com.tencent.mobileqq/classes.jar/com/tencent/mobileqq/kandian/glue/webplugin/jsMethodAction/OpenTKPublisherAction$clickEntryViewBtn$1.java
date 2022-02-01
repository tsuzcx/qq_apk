package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class OpenTKPublisherAction$clickEntryViewBtn$1
  implements ITroopMemberApiClientApi.Callback
{
  OpenTKPublisherAction$clickEntryViewBtn$1(OpenTKPublisherAction paramOpenTKPublisherAction, TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject, int paramInt) {}
  
  public final void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ALD_CONFIG_RESULT", "1");
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "it.getString(IReadInJoyW…n.ALD_CONFIG_RESULT, \"1\")");
    int i = Integer.parseInt(paramBundle);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        OpenTKPublisherAction.c(this.a, this.b, this.c, this.d);
        return;
      }
      OpenTKPublisherAction.b(this.a, this.b, this.c, this.d);
      return;
    }
    OpenTKPublisherAction.a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction.clickEntryViewBtn.1
 * JD-Core Version:    0.7.0.1
 */