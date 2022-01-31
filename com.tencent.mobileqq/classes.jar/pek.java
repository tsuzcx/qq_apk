import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pek
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    pen.w(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    pen.b(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", ajyc.a(2131713024));
    localJSONObject1.put("id_summary", localJSONObject2);
    pen.a(paramBaseArticleInfo, localJSONObject1, true);
    pen.e(paramBaseArticleInfo, localJSONObject1);
    pen.m(paramBaseArticleInfo, localJSONObject1);
    pen.C(paramBaseArticleInfo, localJSONObject1);
    pen.D(paramBaseArticleInfo, localJSONObject1);
    pen.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pek
 * JD-Core Version:    0.7.0.1
 */