package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class PlayFeedbackHelper$FeedbackCallback
{
  public int a;
  public AbsBaseArticleInfo a;
  public HashMap<String, String> a;
  public int b;
  
  public PlayFeedbackHelper$FeedbackCallback(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilHashMap.putAll(paramMap);
  }
  
  public abstract void a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.FeedbackCallback
 * JD-Core Version:    0.7.0.1
 */