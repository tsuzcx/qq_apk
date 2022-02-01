package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoySmallImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str;
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      str = paramAbsBaseArticleInfo.mSinglePicture.getFile();
    } else {
      str = null;
    }
    localJSONObject2.put("article_small_imge_url", str);
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1, true);
    Util.a(paramAbsBaseArticleInfo, localJSONObject1);
    Util.d(paramAbsBaseArticleInfo, localJSONObject1);
    Util.g(paramAbsBaseArticleInfo, localJSONObject1);
    Util.o(paramAbsBaseArticleInfo, localJSONObject1);
    Util.h(paramAbsBaseArticleInfo, localJSONObject1);
    Util.ac(paramAbsBaseArticleInfo, localJSONObject1);
    Util.ag(paramAbsBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
    Util.a(localJSONObject1, paramAbsBaseArticleInfo);
    Util.af(paramAbsBaseArticleInfo, localJSONObject1);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySmallImgCell
 * JD-Core Version:    0.7.0.1
 */