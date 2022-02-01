package com.tencent.mobileqq.kandian.biz.common;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.repo.daily.DailyCbaReportInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ReadInJoyHelper$5
  implements Runnable
{
  ReadInJoyHelper$5(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    boolean bool = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoCard(this.a);
    int i;
    for (;;)
    {
      try
      {
        localObject1 = RIJSPUtils.a("daily_cba_report_key", "");
        localObject2 = new ArrayList();
        if ((localObject1 != null) && (!TextUtils.isEmpty(localObject1.toString()))) {
          localObject1 = new JSONArray(localObject1.toString());
        } else {
          localObject1 = new JSONArray();
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveDailyClickCards error,msg=");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("ReadInJoyLog", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      if (i < ((JSONArray)localObject1).length())
      {
        ((List)localObject2).add(((JSONArray)localObject1).optJSONObject(i));
        i += 1;
      }
      else
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("click_time", System.currentTimeMillis());
        ((JSONObject)localObject1).put("rowkey", this.a.innerUniqueID);
        if (!bool) {
          break label330;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("isVideo", i);
      ((JSONObject)localObject1).put("algoid", this.a.mAlgorithmID);
      ((List)localObject2).add(localObject1);
      Collections.sort((List)localObject2, new DailyCbaReportInfos("click_time"));
      int k = Aladdin.getConfig(227).getIntegerFromString("request_article_nums", 10);
      localObject1 = new JSONArray();
      i = j;
      while ((i < ((List)localObject2).size()) && (i < k))
      {
        ((JSONArray)localObject1).put(((List)localObject2).get(i));
        i += 1;
      }
      RIJSPUtils.a("daily_cba_report_key", ((JSONArray)localObject1).toString());
      return;
      int j = 0;
      i = 0;
      break;
      label330:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.5
 * JD-Core Version:    0.7.0.1
 */