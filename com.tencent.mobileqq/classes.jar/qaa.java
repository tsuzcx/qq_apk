import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qaa
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    qai.a(paramBaseArticleInfo, localJSONObject1, true);
    twr.b(paramBaseArticleInfo, localJSONObject1);
    twr.a(paramBaseArticleInfo, localJSONObject1);
    qai.n(paramBaseArticleInfo, localJSONObject1);
    qai.g(paramBaseArticleInfo, localJSONObject1);
    qai.i(paramBaseArticleInfo, localJSONObject1);
    qai.ab(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_triple_img_interact_cell");
    qai.a(localJSONObject1, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      qai.f(paramBaseArticleInfo, localJSONObject1);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_view_AdBanner", localJSONObject2);
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_model", paramBaseArticleInfo);
    localJSONObject1.put("id_article_triple_image_interact", localJSONObject2);
    localJSONObject1.put("id_info_operate_parent", new JSONObject());
    localJSONObject1.put("id_ad_triple_container", new JSONObject());
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qaa
 * JD-Core Version:    0.7.0.1
 */