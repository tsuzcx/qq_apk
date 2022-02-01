package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDynamicChannelFragment$4
  implements Runnable
{
  ReadInJoyDynamicChannelFragment$4(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = this.a.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject1).next();
        Object localObject2 = localAbsBaseArticleInfo.mProteusTemplateBean;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("channel_id", ReadInJoyDynamicChannelFragment.m(this.this$0));
          localJSONObject.put("article_id", localAbsBaseArticleInfo.mArticleID);
        }
        catch (JSONException localJSONException1)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, "reportExposedData, json exception, ", localJSONException1);
        }
        if (localObject2 != null)
        {
          localObject2 = ((TemplateBean)localObject2).getDataAttribute(null);
          if (localObject2 != null)
          {
            localObject2 = ((Map)localObject2).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
              String str = (String)((Map.Entry)localObject3).getKey();
              localObject3 = ((Map.Entry)localObject3).getValue();
              try
              {
                localJSONObject.put(str, localObject3);
              }
              catch (JSONException localJSONException2)
              {
                QLog.d("ReadInJoyDynamicChannelFragment", 2, "reportExposedData, e: ", localJSONException2);
              }
            }
          }
        }
        QLog.d("ReadInJoyDynamicChannelFragment", 1, new Object[] { "actionName = ", ReadInJoyDynamicChannelFragment.a(this.this$0), "\n", "r5 = ", localJSONObject });
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", ReadInJoyDynamicChannelFragment.b(this.this$0), ReadInJoyDynamicChannelFragment.c(this.this$0), 0, 0, "", "", "", localJSONObject.toString(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.4
 * JD-Core Version:    0.7.0.1
 */