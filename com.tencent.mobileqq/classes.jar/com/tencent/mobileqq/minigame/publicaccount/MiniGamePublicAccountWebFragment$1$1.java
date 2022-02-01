package com.tencent.mobileqq.minigame.publicaccount;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MiniGamePublicAccountWebFragment$1$1
  implements Runnable
{
  MiniGamePublicAccountWebFragment$1$1(MiniGamePublicAccountWebFragment.1 param1, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    Object localObject;
    if (this.val$result.code == 0)
    {
      localObject = this.val$result.data;
      if (localObject != null)
      {
        MiniGamePublicAccountWebFragment.access$002(this.this$1.this$0, (List)((Bundle)localObject).getSerializable("key_msg_list"));
        if (MiniGamePublicAccountWebFragment.access$000(this.this$1.this$0) == null) {
          MiniGamePublicAccountWebFragment.access$002(this.this$1.this$0, new ArrayList());
        }
      }
    }
    int i = MiniGamePublicAccountWebFragment.access$000(this.this$1.this$0).size();
    if (i > 0)
    {
      this.this$1.this$0.emptyLayout.setVisibility(8);
      this.this$1.this$0.pagerContainer.setVisibility(0);
      this.this$1.this$0.notifyWebHeaderHeight(MiniGamePublicAccountWebFragment.access$100(this.this$1.this$0));
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_more", "expo", null, null, null);
      MiniGamePublicAccountWebFragment.access$202(this.this$1.this$0, new ArrayList(Collections.nCopies(i, Boolean.valueOf(false))));
      MiniGamePublicAccountWebFragment.access$300(this.this$1.this$0, 0);
      localObject = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountWebUrl", "https://h5.qzone.qq.com/miniapp/act/gamePublic");
      this.this$1.this$0.webView.loadUrl((String)localObject);
      MiniGamePublicAccountWebFragment.access$400(this.this$1.this$0, 0, false);
      return;
    }
    this.this$1.this$0.pagerContainer.setVisibility(8);
    this.this$1.this$0.emptyLayout.setVisibility(0);
    this.this$1.this$0.notifyWebHeaderHeight(MiniGamePublicAccountWebFragment.access$100(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1.1
 * JD-Core Version:    0.7.0.1
 */