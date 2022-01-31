import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pdx
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    pen.a(paramBaseArticleInfo, localJSONObject1, true);
    oau.b(paramBaseArticleInfo, localJSONObject1);
    oau.a(paramBaseArticleInfo, localJSONObject1);
    pen.m(paramBaseArticleInfo, localJSONObject1);
    pen.e(paramBaseArticleInfo, localJSONObject1);
    pen.g(paramBaseArticleInfo, localJSONObject1);
    pen.aa(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_triple_img_interact_cell");
    pen.a(localJSONObject1, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      pen.d(paramBaseArticleInfo, localJSONObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdx
 * JD-Core Version:    0.7.0.1
 */