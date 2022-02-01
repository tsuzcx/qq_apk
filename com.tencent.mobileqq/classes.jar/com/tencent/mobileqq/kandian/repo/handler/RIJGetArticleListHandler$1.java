package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

class RIJGetArticleListHandler$1
  implements Runnable
{
  RIJGetArticleListHandler$1(RIJGetArticleListHandler paramRIJGetArticleListHandler, ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = RIJGetArticleListHandler.a(this.this$0, this.a);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.b));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.c));
      if (this.a.H != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.a.H);
      }
      localToServiceMsg.getAttributes().put("auto_refresh_src", Integer.valueOf(this.a.D));
      if ((this.a.F & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.a.F));
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.a.i == null) || (this.a.i.size() < 1)) {
          break label288;
        }
        l = ((Long)this.a.i.get(0)).longValue();
        localJSONObject.put("preload_red_pnt_push_articleID", l);
        PublicAccountReportUtils.a(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((this.a.b == 0) && (this.a.c == -1L)) {
        this.this$0.a.a("-1", 1, 0);
      }
      this.this$0.a.sendPbReq(localToServiceMsg);
      WeakNetManager.a().a(localToServiceMsg);
      return;
      label288:
      long l = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler.1
 * JD-Core Version:    0.7.0.1
 */