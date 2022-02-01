package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyTripleImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Util.a(paramAbsBaseArticleInfo, localJSONObject, true);
    Util.a(paramAbsBaseArticleInfo, localJSONObject);
    Util.d(paramAbsBaseArticleInfo, localJSONObject);
    Util.o(paramAbsBaseArticleInfo, localJSONObject);
    Util.g(paramAbsBaseArticleInfo, localJSONObject);
    Util.h(paramAbsBaseArticleInfo, localJSONObject);
    Util.ac(paramAbsBaseArticleInfo, localJSONObject);
    Util.af(paramAbsBaseArticleInfo, localJSONObject);
    Util.ag(paramAbsBaseArticleInfo, localJSONObject);
    Util.aq(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_triple_img_cell");
    Util.a(localJSONObject, paramAbsBaseArticleInfo);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
    {
      if ((paramAbsBaseArticleInfo.mPictures.length >= 1) && (paramAbsBaseArticleInfo.mPictures[0] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[0];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      Object localObject5 = null;
      if (localObject1 != null) {
        localObject1 = ((URL)localObject1).getFile();
      } else {
        localObject1 = null;
      }
      if ((paramAbsBaseArticleInfo.mPictures.length >= 2) && (paramAbsBaseArticleInfo.mPictures[1] != null)) {
        localObject2 = paramAbsBaseArticleInfo.mPictures[1];
      } else {
        localObject2 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      if (localObject2 != null) {
        localObject2 = ((URL)localObject2).getFile();
      } else {
        localObject2 = null;
      }
      URL localURL;
      if ((paramAbsBaseArticleInfo.mPictures.length >= 3) && (paramAbsBaseArticleInfo.mPictures[2] != null)) {
        localURL = paramAbsBaseArticleInfo.mPictures[2];
      } else {
        localURL = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject3 = localObject2;
      localObject4 = localObject1;
      paramAbsBaseArticleInfo = localObject5;
      if (localURL != null)
      {
        paramAbsBaseArticleInfo = localURL.getFile();
        localObject3 = localObject2;
        localObject4 = localObject1;
      }
    }
    else
    {
      localObject3 = JSONUtils.a(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
      if (localObject3 == null) {
        break label475;
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
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        paramAbsBaseArticleInfo = ((JSONObject)localObject3).optString("picture");
      }
      localObject4 = localObject1;
      localObject3 = localObject2;
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url1", localObject4);
    FluencyOptUtils.a.a(localObject4);
    localJSONObject.put("id_multi_img_1", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url2", localObject3);
    FluencyOptUtils.a.a((String)localObject3);
    localJSONObject.put("id_multi_img_2", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url3", paramAbsBaseArticleInfo);
    FluencyOptUtils.a.a(paramAbsBaseArticleInfo);
    localJSONObject.put("id_multi_img_3", localObject1);
    label475:
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTripleImgCell
 * JD-Core Version:    0.7.0.1
 */