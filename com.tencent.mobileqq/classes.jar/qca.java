import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qca
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    qcd.w(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    qcd.b(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", anni.a(2131711798));
    localJSONObject1.put("id_summary", localJSONObject2);
    qcd.a(paramBaseArticleInfo, localJSONObject1, true);
    qcd.e(paramBaseArticleInfo, localJSONObject1);
    qcd.l(paramBaseArticleInfo, localJSONObject1);
    qcd.C(paramBaseArticleInfo, localJSONObject1);
    qcd.D(paramBaseArticleInfo, localJSONObject1);
    qcd.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qca
 * JD-Core Version:    0.7.0.1
 */