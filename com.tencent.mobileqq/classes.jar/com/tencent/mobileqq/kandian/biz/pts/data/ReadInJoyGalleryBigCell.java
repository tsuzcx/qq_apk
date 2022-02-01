package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyGalleryBigCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id_test", new JSONObject());
    Object localObject2 = new JSONObject();
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localObject1 = paramAbsBaseArticleInfo.mSinglePicture.getFile();
    } else {
      localObject1 = null;
    }
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    localJSONObject.put("id_article_large_imge", localObject2);
    Object localObject1 = new JSONObject();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mGalleryPicNumber);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910377));
    ((JSONObject)localObject1).put("gallery_cn_text", ((StringBuilder)localObject2).toString());
    localJSONObject.put("id_gallery_cnt", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
    localJSONObject.put("id_gallery_img", localObject1);
    localJSONObject.put("id_gallery_bg", new JSONObject());
    Util.a(paramAbsBaseArticleInfo, localJSONObject, true);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      Util.a(paramAbsBaseArticleInfo, localJSONObject);
      Util.d(paramAbsBaseArticleInfo, localJSONObject);
    }
    else
    {
      Util.f(paramAbsBaseArticleInfo, localJSONObject);
    }
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    Util.g(paramAbsBaseArticleInfo, localJSONObject);
    Util.j(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_large_cell");
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryBigCell
 * JD-Core Version:    0.7.0.1
 */