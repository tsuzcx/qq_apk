package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ReadInjoyPgcMultiCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, Utils.toLong(paramAbsBaseArticleInfo.mSubscribeID));
    Util.t(paramAbsBaseArticleInfo, localJSONObject1);
    Util.w(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_multi_image", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("summary_text", HardCodeUtil.a(2131910539));
    localJSONObject1.put("id_summary", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", "https://qqpublic.qpic.cn/qq_public_cover/0/0-1512726317-04871A48D592EB571A29D6F16C134B70_open/320");
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, false);
    Util.o(paramAbsBaseArticleInfo, localJSONObject1);
    Util.H(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_pgc_multi_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyPgcMultiCell
 * JD-Core Version:    0.7.0.1
 */