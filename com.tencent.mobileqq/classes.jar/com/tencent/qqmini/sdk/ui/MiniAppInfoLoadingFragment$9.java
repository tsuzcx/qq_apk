package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.widget.MiniToast;

class MiniAppInfoLoadingFragment$9
  implements Runnable
{
  MiniAppInfoLoadingFragment$9(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment) {}
  
  public void run()
  {
    MiniToast.makeText(this.this$0.getActivity(), 1, "启动失败，小程序包配置错误", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.9
 * JD-Core Version:    0.7.0.1
 */