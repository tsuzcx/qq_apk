package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoyTopicRecommendPgcSmallCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Util.A(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    Util.d(paramAbsBaseArticleInfo, localJSONObject1);
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", HardCodeUtil.a(2131910405));
    localJSONObject1.put("id_summary", localJSONObject2);
    localJSONObject1.put("id_image_content", new JSONObject());
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramAbsBaseArticleInfo.mSinglePicture.getFile());
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, true);
    Util.g(paramAbsBaseArticleInfo, localJSONObject1);
    Util.o(paramAbsBaseArticleInfo, localJSONObject1);
    Util.H(paramAbsBaseArticleInfo, localJSONObject1);
    Util.J(paramAbsBaseArticleInfo, localJSONObject1);
    Util.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_small_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTopicRecommendPgcSmallCell
 * JD-Core Version:    0.7.0.1
 */