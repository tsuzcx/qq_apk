import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class qme
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject3 = null;
    JSONObject localJSONObject = new JSONObject();
    qmm.a(paramBaseArticleInfo, localJSONObject, true);
    uks.e(paramBaseArticleInfo, localJSONObject);
    uks.a(paramBaseArticleInfo, localJSONObject);
    uks.g(paramBaseArticleInfo, localJSONObject);
    qmm.n(paramBaseArticleInfo, localJSONObject);
    qmm.g(paramBaseArticleInfo, localJSONObject);
    qmm.i(paramBaseArticleInfo, localJSONObject);
    qmm.ab(paramBaseArticleInfo, localJSONObject);
    uks.f(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_ad_triple_img_cell");
    qmm.a(localJSONObject, paramBaseArticleInfo);
    Object localObject1;
    Object localObject2;
    label152:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = pnl.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label291;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label301;
        }
      }
      label291:
      label301:
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
        localJSONObject.put("id_info_operate_parent", new JSONObject());
        localJSONObject.put("id_ad_triple_container", new JSONObject());
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
      label334:
      if (localObject1 == null) {
        break label435;
      }
      localObject1 = ((URL)localObject1).getFile();
      label343:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label440;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label366:
      if (localObject2 == null) {
        break label450;
      }
      localObject2 = ((URL)localObject2).getFile();
      label375:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label455;
      }
    }
    label435:
    label440:
    label450:
    label455:
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
      break label334;
      localObject1 = null;
      break label343;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label366;
      localObject2 = null;
      break label375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qme
 * JD-Core Version:    0.7.0.1
 */