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

class WebFastAdapter$7
  implements Runnable
{
  WebFastAdapter$7(WebFastAdapter paramWebFastAdapter, List paramList) {}
  
  public void run()
  {
    Iterator localIterator1 = this.a.iterator();
    int j = 0;
    if (localIterator1.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator1.next();
      Iterator localIterator2 = this.this$0.a().iterator();
      int i = j;
      for (;;)
      {
        j = i;
        if (!localIterator2.hasNext()) {
          break;
        }
        Object localObject = (BaseData)localIterator2.next();
        if ((localObject instanceof ProteusItemData))
        {
          JSONObject localJSONObject = ((ProteusItemData)localObject).c;
          if ((localJSONObject != null) && (localJSONObject.optString("kd_ug_rsp_info") != null))
          {
            localObject = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"), WebFastAdapter.a(localJSONObject));
            if ((!TextUtils.isEmpty(((FastWebRecommendUGInfo)localObject).b)) && (((FastWebRecommendUGInfo)localObject).b.equals(localDownloadInfo.d)))
            {
              j = i;
              try
              {
                if (localJSONObject.opt("id_recommend_category_txt") != null)
                {
                  int k = 1;
                  i = 1;
                  j = k;
                  localJSONObject = localJSONObject.getJSONObject("id_recommend_category_txt");
                  j = k;
                  StringBuilder localStringBuilder = new StringBuilder();
                  j = k;
                  localStringBuilder.append(((FastWebRecommendUGInfo)localObject).h);
                  j = k;
                  localStringBuilder.append(localDownloadInfo.f);
                  j = k;
                  localStringBuilder.append("%");
                  j = k;
                  localJSONObject.put("text", localStringBuilder.toString());
                  j = k;
                  localJSONObject.put("label_ug_progress_progress", localDownloadInfo.f);
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
    }
    if (j != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter.7
 * JD-Core Version:    0.7.0.1
 */