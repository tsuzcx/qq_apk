package com.tencent.mobileqq.kandian.biz.video.feedback.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IPlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/impl/PlayFeedbackHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/IPlayFeedbackHelper;", "()V", "feedbackViolaCall", "", "shareEntryActivity", "Landroid/app/Activity;", "jsonObject", "Lorg/json/JSONObject;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayFeedbackHelperImpl
  implements IPlayFeedbackHelper
{
  public void feedbackViolaCall(@Nullable Activity paramActivity, @Nullable JSONObject paramJSONObject)
  {
    PlayFeedbackHelper.a(paramActivity, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feedback.api.impl.PlayFeedbackHelperImpl
 * JD-Core Version:    0.7.0.1
 */