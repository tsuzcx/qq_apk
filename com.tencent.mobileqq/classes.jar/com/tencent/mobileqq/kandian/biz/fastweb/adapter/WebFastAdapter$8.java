package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastAdapter$8
  implements Runnable
{
  WebFastAdapter$8(WebFastAdapter paramWebFastAdapter, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      if ((localObject instanceof ProteusItemData))
      {
        JSONObject localJSONObject = ((ProteusItemData)localObject).c;
        if ((localJSONObject != null) && (localJSONObject.optString("kd_ug_rsp_info") != null))
        {
          localObject = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"), WebFastAdapter.a(localJSONObject));
          if ((!TextUtils.isEmpty(((FastWebRecommendUGInfo)localObject).b)) && (((FastWebRecommendUGInfo)localObject).b.equals(this.a.d)))
          {
            int j = i;
            try
            {
              if (localJSONObject.opt("id_recommend_category_txt") != null)
              {
                int k = 1;
                i = 1;
                j = k;
                localJSONObject = localJSONObject.getJSONObject("id_recommend_category_txt");
                j = k;
                localJSONObject.put("text", ((FastWebRecommendUGInfo)localObject).i);
                j = k;
                localJSONObject.put("label_ug_progress_progress", this.a.f);
              }
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter.8
 * JD-Core Version:    0.7.0.1
 */