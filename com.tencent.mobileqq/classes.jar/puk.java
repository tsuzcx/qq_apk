import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class puk
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    puo.w(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    puo.b(paramBaseArticleInfo, localJSONObject1);
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", anzj.a(2131711710));
    localJSONObject1.put("id_summary", localJSONObject2);
    localJSONObject1.put("id_image_content", new JSONObject());
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramBaseArticleInfo.mSinglePicture.getFile());
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    puo.a(paramBaseArticleInfo, localJSONObject1, true);
    puo.e(paramBaseArticleInfo, localJSONObject1);
    puo.l(paramBaseArticleInfo, localJSONObject1);
    puo.C(paramBaseArticleInfo, localJSONObject1);
    puo.D(paramBaseArticleInfo, localJSONObject1);
    puo.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_big_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puk
 * JD-Core Version:    0.7.0.1
 */