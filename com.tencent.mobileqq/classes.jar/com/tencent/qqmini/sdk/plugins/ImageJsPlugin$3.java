package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;

class ImageJsPlugin$3
  implements MiniAppProxy.IChoosePhotoListner
{
  ImageJsPlugin$3(ImageJsPlugin paramImageJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openChoosePhotoActivity, path=");
    localStringBuilder.append(paramArrayList);
    QMLog.i("ImageJsPlugin", localStringBuilder.toString());
    ImageJsPlugin.access$100(this.this$0, paramArrayList, this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */