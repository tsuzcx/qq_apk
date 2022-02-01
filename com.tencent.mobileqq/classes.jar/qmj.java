import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qmj
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    qmm.z(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    qmm.d(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", anvx.a(2131712486));
    localJSONObject1.put("id_summary", localJSONObject2);
    qmm.a(paramBaseArticleInfo, localJSONObject1, true);
    qmm.g(paramBaseArticleInfo, localJSONObject1);
    qmm.n(paramBaseArticleInfo, localJSONObject1);
    qmm.F(paramBaseArticleInfo, localJSONObject1);
    qmm.G(paramBaseArticleInfo, localJSONObject1);
    qmm.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmj
 * JD-Core Version:    0.7.0.1
 */