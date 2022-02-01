package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastAdapter$9
  implements Runnable
{
  WebFastAdapter$9(WebFastAdapter paramWebFastAdapter) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (BaseData)localIterator.next();
      if ((localObject1 instanceof ProteusItemData))
      {
        JSONObject localJSONObject = ((ProteusItemData)localObject1).c;
        if (localJSONObject != null)
        {
          int j = i;
          try
          {
            if (localJSONObject.opt("id_recommend_category_txt") != null)
            {
              j = i;
              if (localJSONObject.optString("kd_ug_rsp_info") != null)
              {
                j = i;
                FastWebRecommendUGInfo localFastWebRecommendUGInfo = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"));
                if (i == 0)
                {
                  String str = "";
                  j = i;
                  Object localObject3 = localJSONObject.opt("card_info");
                  localObject1 = str;
                  if (localObject3 != null) {
                    try
                    {
                      localObject3 = localJSONObject.getJSONObject("card_info");
                      localObject1 = str;
                      if (((JSONObject)localObject3).opt("rowKey") != null) {
                        localObject1 = ((JSONObject)localObject3).getString("rowKey");
                      }
                    }
                    catch (JSONException localJSONException1)
                    {
                      j = i;
                      localJSONException1.printStackTrace();
                      localObject2 = str;
                    }
                  }
                  j = i;
                  KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, (String)localObject2, "19"));
                  j = i;
                  KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, (String)localObject2, "106"));
                  j = i;
                  ThreadManager.getUIHandler().postDelayed(new WebFastAdapter.9.1(this), 200L);
                }
                int k = 1;
                i = 1;
                j = k;
                Object localObject2 = localJSONObject.getJSONObject("id_recommend_category_txt");
                j = k;
                ((JSONObject)localObject2).put("text", localFastWebRecommendUGInfo.g);
                j = k;
                ((JSONObject)localObject2).put("label_ug_progress_progress", 100);
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
            i = j;
          }
        }
      }
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter.9
 * JD-Core Version:    0.7.0.1
 */