import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class puf
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject3 = null;
    JSONObject localJSONObject = new JSONObject();
    puo.a(paramBaseArticleInfo, localJSONObject, true);
    tqa.b(paramBaseArticleInfo, localJSONObject);
    tqa.a(paramBaseArticleInfo, localJSONObject);
    tqa.c(paramBaseArticleInfo, localJSONObject);
    puo.l(paramBaseArticleInfo, localJSONObject);
    puo.e(paramBaseArticleInfo, localJSONObject);
    puo.g(paramBaseArticleInfo, localJSONObject);
    puo.Z(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_ad_triple_img_cell");
    puo.a(localJSONObject, paramBaseArticleInfo);
    Object localObject1;
    Object localObject2;
    label146:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = sel.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label285;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label295;
        }
      }
      label285:
      label295:
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
        break label146;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label328:
      if (localObject1 == null) {
        break label429;
      }
      localObject1 = ((URL)localObject1).getFile();
      label337:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label434;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label360:
      if (localObject2 == null) {
        break label444;
      }
      localObject2 = ((URL)localObject2).getFile();
      label369:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label449;
      }
    }
    label429:
    label434:
    label444:
    label449:
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
      break label328;
      localObject1 = null;
      break label337;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label360;
      localObject2 = null;
      break label369;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puf
 * JD-Core Version:    0.7.0.1
 */