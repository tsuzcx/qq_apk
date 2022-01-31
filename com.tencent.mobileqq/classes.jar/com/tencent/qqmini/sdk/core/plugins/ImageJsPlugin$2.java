package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;

class ImageJsPlugin$2
  implements MiniAppProxy.IChoosePhotoListner
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, bgok parambgok) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    QMLog.i("ImageJsPlugin", "openChoosePhotoActivity, path=" + paramArrayList);
    ImageJsPlugin.access$100(this.this$0, paramArrayList, this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */