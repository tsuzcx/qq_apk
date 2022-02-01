package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.widget.MiniToast;

class SubscribePermissionSettingFragment$8$1
  implements Runnable
{
  SubscribePermissionSettingFragment$8$1(SubscribePermissionSettingFragment.8 param8, long paramLong) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.val$finalErrCode == -101510007L) {
      MiniToast.makeText(this.this$1.this$0.getActivity(), "请求失败，小程序未登录", 0).show();
    }
    for (;;)
    {
      SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$1.this$0;
      int i = this.this$1.val$position;
      if (!this.this$1.val$isChecked) {
        bool = true;
      }
      SubscribePermissionSettingFragment.access$100(localSubscribePermissionSettingFragment, i, bool, this.this$1.val$clickItem);
      return;
      MiniToast.makeText(this.this$1.this$0.getActivity(), "请求失败，请稍后重试", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.8.1
 * JD-Core Version:    0.7.0.1
 */