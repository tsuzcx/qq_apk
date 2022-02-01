package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class ShowPictureAction$showPicture$1
  implements ITroopMemberApiClientApi.Callback
{
  ShowPictureAction$showPicture$1(ShowPictureAction paramShowPictureAction, TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("click_view_type");
    if (i == 4)
    {
      this.b.a(ShowPictureAction.a(this.a));
      return;
    }
    ReadInJoyJsMethodActionController localReadInJoyJsMethodActionController = ReadInJoyJsMethodActionController.a;
    String str = ShowPictureAction.b(this.a);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("clickType", i);
    localJSONObject.put("liked", paramBundle.getBoolean("like_state"));
    localReadInJoyJsMethodActionController.a(str, 0, "", localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ShowPictureAction.showPicture.1
 * JD-Core Version:    0.7.0.1
 */