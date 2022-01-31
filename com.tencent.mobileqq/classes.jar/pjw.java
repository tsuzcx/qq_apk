import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pjw
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    pkm.a(paramBaseArticleInfo, localJSONObject1, true);
    oee.b(paramBaseArticleInfo, localJSONObject1);
    oee.a(paramBaseArticleInfo, localJSONObject1);
    pkm.l(paramBaseArticleInfo, localJSONObject1);
    pkm.e(paramBaseArticleInfo, localJSONObject1);
    pkm.g(paramBaseArticleInfo, localJSONObject1);
    pkm.Z(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_triple_img_interact_cell");
    pkm.a(localJSONObject1, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      pkm.d(paramBaseArticleInfo, localJSONObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjw
 * JD-Core Version:    0.7.0.1
 */