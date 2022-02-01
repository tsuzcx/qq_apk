import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qma
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramBaseArticleInfo.avatar)) {
      localJSONObject1.put("avator_url", "default_comment_avatar");
    }
    for (;;)
    {
      qmm.s(paramBaseArticleInfo, localJSONObject1);
      qmm.a(paramBaseArticleInfo, localJSONObject1, true);
      uks.e(paramBaseArticleInfo, localJSONObject1);
      uks.a(paramBaseArticleInfo, localJSONObject1);
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.g(paramBaseArticleInfo, localJSONObject1);
      qmm.i(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_brand_optimization_cell");
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        qmm.f(paramBaseArticleInfo, localJSONObject1);
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
 * Qualified Name:     qma
 * JD-Core Version:    0.7.0.1
 */