package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class TweetTopicEntranceShouldShowAction$shouldShowPublisherEntrance$callbackSeq$1
  implements ITroopMemberApiClientApi.Callback
{
  TweetTopicEntranceShouldShowAction$shouldShowPublisherEntrance$callbackSeq$1(TweetTopicEntranceShouldShowAction paramTweetTopicEntranceShouldShowAction) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("resultCode");
    paramBundle = paramBundle.getString("resultMsg");
    TweetTopicEntranceShouldShowAction localTweetTopicEntranceShouldShowAction = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "msg");
    TweetTopicEntranceShouldShowAction.a(localTweetTopicEntranceShouldShowAction, i, paramBundle, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.TweetTopicEntranceShouldShowAction.shouldShowPublisherEntrance.callbackSeq.1
 * JD-Core Version:    0.7.0.1
 */