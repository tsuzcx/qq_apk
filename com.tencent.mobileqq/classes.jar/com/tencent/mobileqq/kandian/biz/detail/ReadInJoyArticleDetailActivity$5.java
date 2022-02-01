package com.tencent.mobileqq.kandian.biz.detail;

import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyArticleDetailActivity$5
  implements MessageQueue.IdleHandler
{
  ReadInJoyArticleDetailActivity$5(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(new ReadInJoyArticleDetailActivity.5.1(this));
      return false;
    }
    Bundle localBundle = DataFactory.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.5
 * JD-Core Version:    0.7.0.1
 */