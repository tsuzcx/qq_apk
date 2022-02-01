import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pub
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramBaseArticleInfo.avatar)) {
      localJSONObject1.put("avator_url", "default_comment_avatar");
    }
    for (;;)
    {
      puo.q(paramBaseArticleInfo, localJSONObject1);
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      tqa.b(paramBaseArticleInfo, localJSONObject1);
      tqa.a(paramBaseArticleInfo, localJSONObject1);
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_brand_optimization_cell");
      puo.a(localJSONObject1, paramBaseArticleInfo);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        puo.d(paramBaseArticleInfo, localJSONObject1);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("article_model", paramBaseArticleInfo);
        localJSONObject1.put("id_view_AdBanner", localJSONObject2);
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_brand_optimization", localJSONObject2);
      localJSONObject1.put("id_info_operate_parent", new JSONObject());
      localJSONObject1.put("id_ad_brand_container", new JSONObject());
      return localJSONObject1;
      localJSONObject1.put("avator_url", paramBaseArticleInfo.avatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pub
 * JD-Core Version:    0.7.0.1
 */