package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;

class ShareManager$1$1
  implements Runnable
{
  ShareManager$1$1(ShareManager.1 param1, long paramLong, String paramString) {}
  
  public void run()
  {
    long l = this.val$finalErrCode;
    if ((l != -100070004L) && (l != -1000710003L))
    {
      MiniToast.makeText(this.this$1.val$shareData.fromActivity, 1, "小程序分享失败，参数错误", 1).show();
      return;
    }
    DialogUtil.createCustomDialog(this.this$1.val$shareData.fromActivity, 230, "分享失败", this.val$finalErrMsg, new ShareManager.1.1.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1.1
 * JD-Core Version:    0.7.0.1
 */