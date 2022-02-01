import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import org.json.JSONObject;

public class qmh
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    qmm.a(paramBaseArticleInfo, localJSONObject1, Utils.toLong(paramBaseArticleInfo.mSubscribeID));
    qmm.s(paramBaseArticleInfo, localJSONObject1);
    qmm.v(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", anvx.a(2131712497));
    localJSONObject1.put("id_summary", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", "https://qqpublic.qpic.cn/qq_public_cover/0/0-1512726317-04871A48D592EB571A29D6F16C134B70_open/320");
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    qmm.a(paramBaseArticleInfo, localJSONObject1, false);
    qmm.n(paramBaseArticleInfo, localJSONObject1);
    qmm.F(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmh
 * JD-Core Version:    0.7.0.1
 */