import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class pem
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject3 = null;
    JSONObject localJSONObject = new JSONObject();
    pen.a(paramBaseArticleInfo, localJSONObject, true);
    pen.a(paramBaseArticleInfo, localJSONObject);
    pen.b(paramBaseArticleInfo, localJSONObject);
    pen.m(paramBaseArticleInfo, localJSONObject);
    pen.e(paramBaseArticleInfo, localJSONObject);
    pen.f(paramBaseArticleInfo, localJSONObject);
    pen.Y(paramBaseArticleInfo, localJSONObject);
    pen.ab(paramBaseArticleInfo, localJSONObject);
    pen.ac(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_triple_img_cell");
    pen.a(localJSONObject, paramBaseArticleInfo);
    Object localObject1;
    Object localObject2;
    label152:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = rap.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label261;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label271;
        }
      }
      label261:
      label271:
      for (paramBaseArticleInfo = paramBaseArticleInfo.mFirstPagePicUrl;; paramBaseArticleInfo = ((JSONObject)localObject3).optString("picture"))
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url1", localObject4);
        localJSONObject.put("id_multi_img_1", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject3);
        localJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", paramBaseArticleInfo);
        localJSONObject.put("id_multi_img_3", localObject1);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject2 = ((JSONObject)localObject2).optString("picture");
        break label152;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label304:
      if (localObject1 == null) {
        break label405;
      }
      localObject1 = ((URL)localObject1).getFile();
      label313:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label410;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label336:
      if (localObject2 == null) {
        break label420;
      }
      localObject2 = ((URL)localObject2).getFile();
      label345:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label425;
      }
    }
    label405:
    label410:
    label420:
    label425:
    for (URL localURL = paramBaseArticleInfo.mSinglePicture;; localURL = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = localObject1;
      paramBaseArticleInfo = (BaseArticleInfo)localObject3;
      localObject3 = localObject2;
      if (localURL == null) {
        break;
      }
      paramBaseArticleInfo = localURL.getFile();
      localObject4 = localObject1;
      localObject3 = localObject2;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label304;
      localObject1 = null;
      break label313;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label336;
      localObject2 = null;
      break label345;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pem
 * JD-Core Version:    0.7.0.1
 */