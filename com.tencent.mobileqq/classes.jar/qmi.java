import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qmi
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
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", anvx.a(2131712289));
    localJSONObject1.put("id_summary", localJSONObject2);
    localJSONObject1.put("id_image_content", new JSONObject());
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramBaseArticleInfo.mSinglePicture.getFile());
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    qmm.a(paramBaseArticleInfo, localJSONObject1, true);
    qmm.g(paramBaseArticleInfo, localJSONObject1);
    qmm.n(paramBaseArticleInfo, localJSONObject1);
    qmm.F(paramBaseArticleInfo, localJSONObject1);
    qmm.G(paramBaseArticleInfo, localJSONObject1);
    qmm.b(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_big_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmi
 * JD-Core Version:    0.7.0.1
 */