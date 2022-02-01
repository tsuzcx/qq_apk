package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadInJoyLargeVideoCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    localObject = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject != null) {
      localObject = ((URL)localObject).getFile();
    } else {
      localObject = null;
    }
    localJSONObject2.put("article_large_imge_url", localObject);
    FluencyOptUtils.a.a((String)localObject);
    localJSONObject1.put("id_article_large_imge", localJSONObject2);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_duration", ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.mVideoDuration));
    localJSONObject1.put("id_large_video_duration", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
    localJSONObject1.put("id_video_play_icon", localObject);
    localJSONObject1.put("id_video_paly_text", new JSONObject());
    if ((paramAbsBaseArticleInfo.richTitleInfoList != null) && (paramAbsBaseArticleInfo.richTitleInfoList.size() > 0)) {
      Util.a(paramAbsBaseArticleInfo, localJSONObject1, "rich_text_line", "rich_text_info", false);
    } else {
      Util.a(paramAbsBaseArticleInfo, localJSONObject1, true);
    }
    Util.ab(paramAbsBaseArticleInfo, localJSONObject1);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      Util.a(paramAbsBaseArticleInfo, localJSONObject1);
      Util.d(paramAbsBaseArticleInfo, localJSONObject1);
    }
    else
    {
      Util.f(paramAbsBaseArticleInfo, localJSONObject1);
    }
    Util.n(paramAbsBaseArticleInfo, localJSONObject1);
    Util.g(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
    localObject = new JSONObject();
    ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
    localJSONObject1.put("id_large_video_activity_img", localObject);
    localJSONObject1.put("id_large_video_activity_label", new JSONObject());
    Util.h(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
    Util.an(paramAbsBaseArticleInfo, localJSONObject1);
    Util.ae(paramAbsBaseArticleInfo, localJSONObject1);
    Util.ap(paramAbsBaseArticleInfo, localJSONObject1);
    Util.H(paramAbsBaseArticleInfo, localJSONObject1);
    Util.a(localJSONObject1, paramAbsBaseArticleInfo);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyLargeVideoCell
 * JD-Core Version:    0.7.0.1
 */