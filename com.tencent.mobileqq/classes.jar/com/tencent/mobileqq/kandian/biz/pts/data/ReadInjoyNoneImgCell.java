package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ReadInjoyNoneImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Util.a(paramAbsBaseArticleInfo, localJSONObject, true);
    Util.a(paramAbsBaseArticleInfo, localJSONObject);
    Util.d(paramAbsBaseArticleInfo, localJSONObject);
    Util.g(paramAbsBaseArticleInfo, localJSONObject);
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    Util.j(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyNoneImgCell
 * JD-Core Version:    0.7.0.1
 */