package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyGalleryTripleCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mGalleryPicNumber);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910623));
    ((JSONObject)localObject1).put("gallery_cn_text", ((StringBuilder)localObject2).toString());
    localJSONObject.put("id_gallery_cnt", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
    localJSONObject.put("id_gallery_img", localObject1);
    localJSONObject.put("id_gallery_bg", new JSONObject());
    if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
    {
      if ((paramAbsBaseArticleInfo.mPictures.length >= 1) && (paramAbsBaseArticleInfo.mPictures[0] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[0];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject3 = ((URL)localObject1).getFile();
      if ((paramAbsBaseArticleInfo.mPictures.length >= 2) && (paramAbsBaseArticleInfo.mPictures[1] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[1];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject2 = ((URL)localObject1).getFile();
      if ((paramAbsBaseArticleInfo.mPictures.length >= 3) && (paramAbsBaseArticleInfo.mPictures[2] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[2];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject1 = ((URL)localObject1).getFile();
    }
    else
    {
      localObject3 = JSONUtils.a(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
      if (localObject3 == null) {
        break label516;
      }
      if (((JSONArray)localObject3).length() < 3) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null) {
        localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject1 = ((JSONObject)localObject1).optString("picture");
      }
      localObject2 = ((JSONArray)localObject3).optJSONObject(1);
      if (localObject2 == null) {
        localObject2 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject2 = ((JSONObject)localObject2).optString("picture");
      }
      localObject3 = ((JSONArray)localObject3).optJSONObject(2);
      if (localObject3 == null) {
        localObject3 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject3 = ((JSONObject)localObject3).optString("picture");
      }
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
    Object localObject4 = new JSONObject();
    ((JSONObject)localObject4).put("multi_img_url1", localObject3);
    localJSONObject.put("id_multi_img_1", localObject4);
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("multi_img_url2", localObject2);
    localJSONObject.put("id_multi_img_2", localObject3);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("multi_img_url3", localObject1);
    localJSONObject.put("id_multi_img_3", localObject2);
    Util.a(paramAbsBaseArticleInfo, localJSONObject, true);
    Util.a(paramAbsBaseArticleInfo, localJSONObject);
    Util.d(paramAbsBaseArticleInfo, localJSONObject);
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    Util.g(paramAbsBaseArticleInfo, localJSONObject);
    Util.h(paramAbsBaseArticleInfo, localJSONObject);
    Util.ac(paramAbsBaseArticleInfo, localJSONObject);
    if (paramAbsBaseArticleInfo.articleStyle == 6) {
      localJSONObject.put("style_ID", "ReadInjoy_triple_img_big_cell");
    } else {
      localJSONObject.put("style_ID", "ReadInjoy_triple_img_cell");
    }
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    label516:
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyGalleryTripleCell
 * JD-Core Version:    0.7.0.1
 */