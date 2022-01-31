import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pkj
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    pkm.v(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    pkm.b(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", alpo.a(2131713407));
    localJSONObject1.put("id_summary", localJSONObject2);
    pkm.a(paramBaseArticleInfo, localJSONObject1, true);
    pkm.e(paramBaseArticleInfo, localJSONObject1);
    pkm.l(paramBaseArticleInfo, localJSONObject1);
    pkm.B(paramBaseArticleInfo, localJSONObject1);
    pkm.C(paramBaseArticleInfo, localJSONObject1);
    pkm.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkj
 * JD-Core Version:    0.7.0.1
 */