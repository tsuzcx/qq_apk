package com.tencent.mobileqq.kandian.biz.video.click;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class RIJVideoHandleClick$10$1
  implements Runnable
{
  RIJVideoHandleClick$10$1(RIJVideoHandleClick.10 param10, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject;
    if (RIJVideoHandleClick.b(this.b.a).a().B() == 56)
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("algorithm_id", this.a.mAlgorithmID);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    else
    {
      localJSONObject = null;
    }
    PublicAccountReportUtils.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", VideoReporter.a(this.a.mVideoVid, this.a.innerUniqueID, (int)this.a.mChannelID, localJSONObject), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.10.1
 * JD-Core Version:    0.7.0.1
 */