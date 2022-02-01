package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;

class ImageJsPlugin$2$2
  implements DialogInterface.OnClickListener
{
  ImageJsPlugin$2$2(ImageJsPlugin.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!ImageJsPlugin.access$500(this.this$1.this$0).openChoosePhotoActivity(ImageJsPlugin.access$400(this.this$1.this$0).getAttachedActivity(), this.this$1.val$count, new ImageJsPlugin.2.2.1(this)))
    {
      Activity localActivity = ImageJsPlugin.access$600(this.this$1.this$0).getAttachedActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("暂不支持在");
      localStringBuilder.append(QUAUtil.getApplicationName(ImageJsPlugin.access$700(this.this$1.this$0)));
      localStringBuilder.append("中选择图片");
      MiniToast.makeText(localActivity, 0, localStringBuilder.toString(), 1);
      this.this$1.val$req.fail();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2.2
 * JD-Core Version:    0.7.0.1
 */