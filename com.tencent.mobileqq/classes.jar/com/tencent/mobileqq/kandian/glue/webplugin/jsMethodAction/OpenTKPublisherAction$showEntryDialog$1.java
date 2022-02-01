package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import com.tencent.biz.troop.TroopMemberApiClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class OpenTKPublisherAction$showEntryDialog$1
  extends Lambda
  implements Function0<Unit>
{
  OpenTKPublisherAction$showEntryDialog$1(OpenTKPublisherAction paramOpenTKPublisherAction, TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    OpenTKPublisherAction.a(this.this$0, this.$client, this.$json, this.$callbackSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction.showEntryDialog.1
 * JD-Core Version:    0.7.0.1
 */