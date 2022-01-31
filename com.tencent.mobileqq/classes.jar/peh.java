import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class peh
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    pek.w(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    pek.b(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", ajya.a(2131713035));
    localJSONObject1.put("id_summary", localJSONObject2);
    pek.a(paramBaseArticleInfo, localJSONObject1, true);
    pek.e(paramBaseArticleInfo, localJSONObject1);
    pek.m(paramBaseArticleInfo, localJSONObject1);
    pek.C(paramBaseArticleInfo, localJSONObject1);
    pek.D(paramBaseArticleInfo, localJSONObject1);
    pek.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */