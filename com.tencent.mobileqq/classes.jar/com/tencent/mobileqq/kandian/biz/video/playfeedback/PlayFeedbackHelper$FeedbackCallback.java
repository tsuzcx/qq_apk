package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class PlayFeedbackHelper$FeedbackCallback
{
  public AbsBaseArticleInfo b;
  public int c;
  public int d;
  public HashMap<String, String> e = new HashMap();
  
  public PlayFeedbackHelper$FeedbackCallback(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    this.b = paramAbsBaseArticleInfo;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e.putAll(paramMap);
  }
  
  public abstract void a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.FeedbackCallback
 * JD-Core Version:    0.7.0.1
 */