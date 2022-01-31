package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bglv;
import bgok;
import bgrm;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;

class ImageJsPlugin$1$2
  implements DialogInterface.OnClickListener
{
  ImageJsPlugin$1$2(ImageJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!ImageJsPlugin.access$200(this.this$1.this$0).openChoosePhotoActivity(this.this$1.this$0.mMiniAppContext.a(), this.this$1.val$count, new ImageJsPlugin.1.2.1(this)))
    {
      bgrm.a(this.this$1.this$0.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.this$1.this$0.mContext) + "中选择图片", 1);
      this.this$1.val$req.b();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.1.2
 * JD-Core Version:    0.7.0.1
 */