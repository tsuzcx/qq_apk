package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoySmallVideoCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_icon", "public_account_video_profile");
    localJSONObject1.put("id_small_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_cover", "public_account_small_video_mengceng");
    localJSONObject1.put("id_small_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localObject = paramAbsBaseArticleInfo.mSinglePicture.getFile();
    } else {
      localObject = null;
    }
    localJSONObject2.put("article_small_imge_url", localObject);
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_duration", ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.mVideoDuration));
    localJSONObject1.put("id_small_video_duration", localObject);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, true);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      Util.a(paramAbsBaseArticleInfo, localJSONObject1);
      Util.d(paramAbsBaseArticleInfo, localJSONObject1);
    }
    else
    {
      Util.f(paramAbsBaseArticleInfo, localJSONObject1);
    }
    Util.o(paramAbsBaseArticleInfo, localJSONObject1);
    Util.g(paramAbsBaseArticleInfo, localJSONObject1);
    Util.j(paramAbsBaseArticleInfo, localJSONObject1);
    Util.aq(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
    Util.a(localJSONObject1, paramAbsBaseArticleInfo);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySmallVideoCell
 * JD-Core Version:    0.7.0.1
 */