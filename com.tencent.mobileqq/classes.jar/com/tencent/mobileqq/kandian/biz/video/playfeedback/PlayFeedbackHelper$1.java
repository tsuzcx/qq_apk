package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.app.Activity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.Map;
import org.json.JSONObject;

final class PlayFeedbackHelper$1
  extends PlayFeedbackHelper.FeedbackCallback
{
  PlayFeedbackHelper$1(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Map paramMap, Activity paramActivity)
  {
    super(paramAbsBaseArticleInfo, paramInt1, paramInt2, paramMap);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    PlayFeedbackHelper.a(this.a, this, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.1
 * JD-Core Version:    0.7.0.1
 */