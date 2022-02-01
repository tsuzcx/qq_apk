package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;

class WebUiStrategy1GameCenter$1
  implements View.OnClickListener
{
  WebUiStrategy1GameCenter$1(WebUiStrategy1GameCenter paramWebUiStrategy1GameCenter, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountGameStoreUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list%3Fmode%3Dchengzaiye&_vt=3&via=2015_5_11&_sig=1248527088");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.val$activity, paramView, 4011, null);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "click", null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy1GameCenter.1
 * JD-Core Version:    0.7.0.1
 */