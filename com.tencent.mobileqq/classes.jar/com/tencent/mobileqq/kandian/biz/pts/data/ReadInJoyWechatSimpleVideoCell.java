package com.tencent.mobileqq.kandian.biz.pts.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWechatSimpleVideoCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Util.c(paramAbsBaseArticleInfo, localJSONObject);
    Util.af(paramAbsBaseArticleInfo, localJSONObject);
    Util.a(paramAbsBaseArticleInfo, localJSONObject, false);
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    Util.g(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_wechat_simple_video_cell");
    localJSONObject.put("video_id", paramAbsBaseArticleInfo.getVideoVid());
    localJSONObject.put("busi_type", paramAbsBaseArticleInfo.busiType);
    String str;
    if (paramAbsBaseArticleInfo.getVideoCoverURL() != null) {
      str = paramAbsBaseArticleInfo.getVideoCoverURL().getPath();
    } else {
      str = "";
    }
    localJSONObject.put("video_cover_image_url", str);
    localJSONObject.put("dt_pgid", "14");
    Util.ar(paramAbsBaseArticleInfo, localJSONObject);
    Util.H(paramAbsBaseArticleInfo, localJSONObject);
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    a(paramAbsBaseArticleInfo, localJSONObject);
    return localJSONObject;
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!Util.f(paramAbsBaseArticleInfo)) {
      return;
    }
    try
    {
      Util.aq(paramAbsBaseArticleInfo, paramJSONObject);
      Util.d(paramAbsBaseArticleInfo, paramJSONObject);
      Util.b(paramAbsBaseArticleInfo, paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindAutoPlayInfo error! msg=");
      localStringBuilder.append(paramJSONObject);
      QLog.d("ReadInJoyWechatSimpleVideoCell", 1, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.jumpUrl)) {
      paramAbsBaseArticleInfo.jumpUrl = Util.a(paramAbsBaseArticleInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyWechatSimpleVideoCell
 * JD-Core Version:    0.7.0.1
 */