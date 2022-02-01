package com.tencent.mobileqq.kandian.repo.pts;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSDataUtil
{
  public static String a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
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
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("articleID", localAbsBaseArticleInfo.mArticleID);
            localJSONObject2.put("rowKey", localAbsBaseArticleInfo.innerUniqueID);
            localJSONObject2.put("title", localAbsBaseArticleInfo.mTitle);
            localJSONObject2.put("coverImageUrl", localAbsBaseArticleInfo.mFirstPagePicUrl);
            localJSONObject2.put("jsonImageUrl", localAbsBaseArticleInfo.mJsonPictureList);
            localJSONObject2.put("articleContentUrl", localAbsBaseArticleInfo.mArticleContentUrl);
            localJSONObject2.put("subscribeName", localAbsBaseArticleInfo.mSubscribeName);
            localJSONObject2.put("channelID", localAbsBaseArticleInfo.mChannelID);
            localJSONObject2.put("recommendSeq", localAbsBaseArticleInfo.mRecommendSeq);
            localJSONObject2.put("algorithmID", localAbsBaseArticleInfo.mAlgorithmID);
            localJSONObject2.put("strategyID", localAbsBaseArticleInfo.mStrategyId);
            localJSONObject2.put("feedsType", localAbsBaseArticleInfo.mFeedType);
            localJSONObject2.put("proteusItemData", localAbsBaseArticleInfo.proteusItemsData);
            try
            {
              if (!ReadInJoyLogicEngine.a().a(localAbsBaseArticleInfo.mArticleID)) {
                break label389;
              }
              i = 1;
              localJSONObject2.put("hasRead", i);
            }
            catch (Exception localException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[getResponseJSONString], e = ");
              localStringBuilder.append(localException);
              QLog.e("PTSDataUtil", 1, localStringBuilder.toString());
            }
            ((JSONArray)localObject).put(localJSONObject2);
            continue;
          }
        }
        localJSONObject1.put("data", localObject);
      }
      catch (JSONException paramList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getResponseJSONString], e ");
        ((StringBuilder)localObject).append(paramList);
        QLog.e("PTSDataUtil", 1, ((StringBuilder)localObject).toString());
      }
      return localJSONObject1.toString();
      localObject = "0";
      continue;
      label389:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSDataUtil
 * JD-Core Version:    0.7.0.1
 */