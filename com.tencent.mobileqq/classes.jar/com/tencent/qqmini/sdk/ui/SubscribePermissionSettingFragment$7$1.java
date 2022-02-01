package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.widget.MiniToast;

class SubscribePermissionSettingFragment$7$1
  implements Runnable
{
  SubscribePermissionSettingFragment$7$1(SubscribePermissionSettingFragment.7 param7) {}
  
  public void run()
  {
    MiniToast.makeText(this.this$1.this$0.getActivity(), "请求失败，请稍后重试", 0).show();
    SubscribePermissionSettingFragment.access$100(this.this$1.this$0, this.this$1.val$position, this.this$1.val$isChecked ^ true, this.this$1.val$clickItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.7.1
 * JD-Core Version:    0.7.0.1
 */