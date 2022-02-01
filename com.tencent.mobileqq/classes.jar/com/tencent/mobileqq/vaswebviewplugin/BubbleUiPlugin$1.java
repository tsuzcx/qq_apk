package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;

class BubbleUiPlugin$1
  implements Runnable
{
  BubbleUiPlugin$1(BubbleUiPlugin paramBubbleUiPlugin) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("optype", "Bubble");
    localBundle.putString("opname", "Clk_bubble_setting");
    localBundle = DataFactory.a("reportActionCount", "", this.this$0.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */