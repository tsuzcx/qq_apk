package com.tencent.qqmini.sdk.core.plugins;

import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;

class ImageJsPlugin$1$2$1
  implements MiniAppProxy.IChoosePhotoListner
{
  ImageJsPlugin$1$2$1(ImageJsPlugin.1.2 param2) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    QMLog.i("ImageJsPlugin", "openChoosePhotoActivity, path=" + paramArrayList);
    ImageJsPlugin.access$100(this.this$2.this$1.this$0, paramArrayList, this.this$2.this$1.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.1.2.1
 * JD-Core Version:    0.7.0.1
 */