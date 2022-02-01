package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;

class ImageJsPlugin$2$2$1
  implements MiniAppProxy.IChoosePhotoListner
{
  ImageJsPlugin$2$2$1(ImageJsPlugin.2.2 param2) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    QMLog.i("ImageJsPlugin", "openChoosePhotoActivity, path=" + paramArrayList);
    ImageJsPlugin.access$100(this.this$2.this$1.this$0, paramArrayList, this.this$2.this$1.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2.2.1
 * JD-Core Version:    0.7.0.1
 */