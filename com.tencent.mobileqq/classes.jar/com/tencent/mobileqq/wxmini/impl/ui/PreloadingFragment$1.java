package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;

class PreloadingFragment$1
  implements Runnable
{
  PreloadingFragment$1(PreloadingFragment paramPreloadingFragment) {}
  
  public void run()
  {
    if (!WxMiniSDKImpl.a.a()) {
      WxMiniSDKImpl.a.a(BaseApplicationImpl.sApplication);
    }
    int i = PreloadingFragment.a(this.this$0);
    WxMiniSDKImpl.a.c().setWxaProcessMaxCount(i);
    PreloadingFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.1
 * JD-Core Version:    0.7.0.1
 */