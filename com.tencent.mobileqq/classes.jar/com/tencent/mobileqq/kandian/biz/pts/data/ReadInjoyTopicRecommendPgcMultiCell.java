package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ReadInjoyTopicRecommendPgcMultiCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Util.z(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    Util.d(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", HardCodeUtil.a(2131712963));
    localJSONObject1.put("id_summary", localJSONObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, true);
    Util.g(paramAbsBaseArticleInfo, localJSONObject1);
    Util.n(paramAbsBaseArticleInfo, localJSONObject1);
    Util.G(paramAbsBaseArticleInfo, localJSONObject1);
    Util.I(paramAbsBaseArticleInfo, localJSONObject1);
    Util.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTopicRecommendPgcMultiCell
 * JD-Core Version:    0.7.0.1
 */