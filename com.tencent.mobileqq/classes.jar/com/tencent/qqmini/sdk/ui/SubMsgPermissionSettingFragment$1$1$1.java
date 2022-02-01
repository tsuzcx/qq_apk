package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.widget.MiniToast;

class SubMsgPermissionSettingFragment$1$1$1
  implements Runnable
{
  SubMsgPermissionSettingFragment$1$1$1(SubMsgPermissionSettingFragment.1.1 param1, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L)
    {
      MiniToast.makeText(this.this$2.this$1.this$0.getActivity(), "请求失败，小程序未登录", 0).show();
      return;
    }
    MiniToast.makeText(this.this$2.this$1.this$0.getActivity(), "请求失败，请稍后重试", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */