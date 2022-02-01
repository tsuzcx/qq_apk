import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class qlu
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.mGalleryPicNumber > 3)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + anvx.a(2131712472));
      localJSONObject.put("id_gallery_cnt", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject.put("id_gallery_img", localObject1);
      localJSONObject.put("id_gallery_bg", new JSONObject());
    }
    Object localObject3;
    Object localObject2;
    label177:
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
          break label323;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label333;
        }
      }
      label323:
      label333:
      for (localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject3 = ((JSONObject)localObject3).optString("picture"))
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("multi_img_url1", localObject1);
        localJSONObject.put("id_multi_img_1", localObject4);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject2);
        localJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", localObject3);
        localJSONObject.put("id_multi_img_3", localObject1);
        qmm.a(paramBaseArticleInfo, localJSONObject, true);
        qmm.n(paramBaseArticleInfo, localJSONObject);
        qmm.k(paramBaseArticleInfo, localJSONObject);
        qmm.a(localJSONObject);
        localJSONObject.put("style_ID", "ReadInjoy_gallery_channel_triple_img_big_cell");
        qmm.a(localJSONObject, paramBaseArticleInfo);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject2 = ((JSONObject)localObject2).optString("picture");
        break label177;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label366:
      localObject2 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label448;
      }
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label394:
      localObject3 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label458;
      }
    }
    label448:
    label458:
    for (Object localObject1 = paramBaseArticleInfo.mSinglePicture;; localObject1 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = ((URL)localObject1).getFile();
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label366;
      localObject1 = paramBaseArticleInfo.mPictures[1];
      break label394;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlu
 * JD-Core Version:    0.7.0.1
 */