package com.tencent.mobileqq.kandian.biz.pts.data;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadInJoySingleTopicCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo;
    Object localObject2 = null;
    if ((localObject1 != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() != 0))
    {
      localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0);
      localObject3 = BaseApplicationImpl.getApplication().getResources();
      localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).f;
      localObject2 = String.format(((Resources)localObject3).getString(2131915542), new Object[] { ReadInJoyHelper.c(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).e) });
    }
    else
    {
      localObject1 = null;
    }
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("participant_title_text", localObject2);
    localJSONObject.put("id_participant_title", localObject3);
    Util.a(paramAbsBaseArticleInfo, localJSONObject, false);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("participant_pic_url", localObject1);
    localJSONObject.put("id_participant_imge", localObject2);
    localJSONObject.put("id_view_cover", new JSONObject());
    Util.d(paramAbsBaseArticleInfo, localJSONObject);
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_single_topic_cell");
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySingleTopicCell
 * JD-Core Version:    0.7.0.1
 */