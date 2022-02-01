package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyGalleryChannelDoubleCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (paramAbsBaseArticleInfo.mGalleryPicNumber > 2)
    {
      localObject1 = new JSONObject();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mGalleryPicNumber);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131712909));
      ((JSONObject)localObject1).put("gallery_cn_text", ((StringBuilder)localObject2).toString());
      localJSONObject.put("id_gallery_cnt", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject.put("id_gallery_img", localObject1);
      localJSONObject.put("id_gallery_bg", new JSONObject());
    }
    if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
    {
      if ((paramAbsBaseArticleInfo.mPictures.length >= 1) && (paramAbsBaseArticleInfo.mPictures[0] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[0];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject2 = ((URL)localObject1).getFile();
      if ((paramAbsBaseArticleInfo.mPictures.length >= 2) && (paramAbsBaseArticleInfo.mPictures[1] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[1];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject1 = ((URL)localObject1).getFile();
    }
    else
    {
      localObject2 = JSONUtils.a(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
      if (localObject2 == null) {
        break label387;
      }
      if (((JSONArray)localObject2).length() < 2) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject2).optJSONObject(0);
      if (localObject1 == null) {
        localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject1 = ((JSONObject)localObject1).optString("picture");
      }
      localObject2 = ((JSONArray)localObject2).optJSONObject(1);
      if (localObject2 == null) {
        localObject2 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject2 = ((JSONObject)localObject2).optString("picture");
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("multi_img_url1", localObject2);
    localJSONObject.put("id_multi_img_1", localObject3);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("multi_img_url2", localObject1);
    localJSONObject.put("id_multi_img_2", localObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject, true);
    Util.n(paramAbsBaseArticleInfo, localJSONObject);
    Util.k(paramAbsBaseArticleInfo, localJSONObject);
    Util.a(localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_gallery_channel_double_img_cell");
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    label387:
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryChannelDoubleCell
 * JD-Core Version:    0.7.0.1
 */