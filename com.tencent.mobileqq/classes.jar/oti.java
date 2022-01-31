import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class oti
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    otl.v(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    otl.b(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", ajjy.a(2131647236));
    localJSONObject1.put("id_summary", localJSONObject2);
    otl.a(paramBaseArticleInfo, localJSONObject1, true);
    otl.e(paramBaseArticleInfo, localJSONObject1);
    otl.m(paramBaseArticleInfo, localJSONObject1);
    otl.B(paramBaseArticleInfo, localJSONObject1);
    otl.C(paramBaseArticleInfo, localJSONObject1);
    otl.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oti
 * JD-Core Version:    0.7.0.1
 */