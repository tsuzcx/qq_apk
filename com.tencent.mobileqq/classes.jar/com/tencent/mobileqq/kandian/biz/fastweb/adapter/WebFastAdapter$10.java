package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastAdapter$10
  implements Runnable
{
  WebFastAdapter$10(WebFastAdapter paramWebFastAdapter) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.f().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = ((ProteusItemData)localObject).bb;
        if (localObject != null)
        {
          int j = i;
          try
          {
            if (((JSONObject)localObject).opt("id_recommend_category_txt") != null)
            {
              j = i;
              if (((JSONObject)localObject).optString("kd_ug_rsp_info") != null)
              {
                int k = 1;
                i = 1;
                j = k;
                JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("id_recommend_category_txt");
                j = k;
                localJSONObject.put("text", new FastWebRecommendUGInfo(((JSONObject)localObject).optString("kd_ug_rsp_info")).h);
                j = k;
                localJSONObject.put("label_ug_progress_progress", 0);
              }
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
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter.10
 * JD-Core Version:    0.7.0.1
 */