package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastAdapter$5
  implements Runnable
{
  WebFastAdapter$5(WebFastAdapter paramWebFastAdapter, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.f().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (BaseData)localIterator.next();
      if ((localObject1 instanceof ProteusItemData))
      {
        JSONObject localJSONObject = ((ProteusItemData)localObject1).bb;
        if ((localJSONObject != null) && (localJSONObject.optString("kd_ug_rsp_info") != null))
        {
          FastWebRecommendUGInfo localFastWebRecommendUGInfo = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"), WebFastAdapter.a(localJSONObject));
          if ((!TextUtils.isEmpty(localFastWebRecommendUGInfo.d)) && (localFastWebRecommendUGInfo.d.equals(this.a.d)))
          {
            int j = i;
            try
            {
              if (localJSONObject.opt("id_recommend_category_txt") != null)
              {
                int k = 1;
                i = 1;
                j = k;
                localObject1 = localJSONObject.getJSONObject("id_recommend_category_txt");
                j = k;
                ((JSONObject)localObject1).put("text", localFastWebRecommendUGInfo.i);
                j = k;
                ((JSONObject)localObject1).put("label_ug_progress_progress", 100);
                String str = "";
                j = k;
                Object localObject3 = localJSONObject.opt("card_info");
                localObject1 = str;
                Object localObject2;
                if (localObject3 != null) {
                  try
                  {
                    localJSONObject = localJSONObject.getJSONObject("card_info");
                    localObject1 = str;
                    if (localJSONObject.opt("rowKey") != null) {
                      localObject1 = localJSONObject.getString("rowKey");
                    }
                  }
                  catch (JSONException localJSONException1)
                  {
                    j = k;
                    localJSONException1.printStackTrace();
                    localObject2 = str;
                  }
                }
                j = k;
                KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.c, localObject2, "20"));
                j = k;
                KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.c, localObject2, "11"));
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
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter.5
 * JD-Core Version:    0.7.0.1
 */