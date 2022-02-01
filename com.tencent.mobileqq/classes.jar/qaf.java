import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qaf
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    qai.y(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    qai.d(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", amtj.a(2131712139));
    localJSONObject1.put("id_summary", localJSONObject2);
    qai.a(paramBaseArticleInfo, localJSONObject1, true);
    qai.g(paramBaseArticleInfo, localJSONObject1);
    qai.n(paramBaseArticleInfo, localJSONObject1);
    qai.E(paramBaseArticleInfo, localJSONObject1);
    qai.F(paramBaseArticleInfo, localJSONObject1);
    qai.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */