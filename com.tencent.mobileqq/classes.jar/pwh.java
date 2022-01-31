import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pwh
{
  public static String a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject;
    if (paramBoolean) {
      localObject = "1";
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("success", localObject);
        localObject = new JSONArray();
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label355;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label355;
        }
        localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("articleID", localBaseArticleInfo.mArticleID);
        localJSONObject2.put("rowKey", localBaseArticleInfo.innerUniqueID);
        localJSONObject2.put("title", localBaseArticleInfo.mTitle);
        localJSONObject2.put("coverImageUrl", localBaseArticleInfo.mFirstPagePicUrl);
        localJSONObject2.put("jsonImageUrl", localBaseArticleInfo.mJsonPictureList);
        localJSONObject2.put("articleContentUrl", localBaseArticleInfo.mArticleContentUrl);
        localJSONObject2.put("subscribeName", localBaseArticleInfo.mSubscribeName);
        localJSONObject2.put("channelID", localBaseArticleInfo.mChannelID);
        localJSONObject2.put("recommendSeq", localBaseArticleInfo.mRecommendSeq);
        localJSONObject2.put("algorithmID", localBaseArticleInfo.mAlgorithmID);
        localJSONObject2.put("strategyID", localBaseArticleInfo.mStrategyId);
        localJSONObject2.put("feedsType", localBaseArticleInfo.mFeedType);
        localJSONObject2.put("proteusItemData", localBaseArticleInfo.proteusItemsData);
      }
      catch (JSONException paramList)
      {
        BaseArticleInfo localBaseArticleInfo;
        JSONObject localJSONObject2;
        QLog.e("PTSDataUtil", 1, "[getResponseJSONString], e " + paramList);
      }
      try
      {
        if (!owy.a().a(localBaseArticleInfo.mArticleID)) {
          break label367;
        }
        i = 1;
        localJSONObject2.put("hasRead", i);
      }
      catch (Exception localException)
      {
        QLog.e("PTSDataUtil", 1, "[getResponseJSONString], e = " + localException);
        continue;
      }
      ((JSONArray)localObject).put(localJSONObject2);
      continue;
      for (;;)
      {
        return localJSONObject1.toString();
        localObject = "0";
        break;
        label355:
        localJSONObject1.put("data", localObject);
      }
      label367:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwh
 * JD-Core Version:    0.7.0.1
 */