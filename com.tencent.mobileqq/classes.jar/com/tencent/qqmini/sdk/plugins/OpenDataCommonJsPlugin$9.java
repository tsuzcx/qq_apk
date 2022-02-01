package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;

class OpenDataCommonJsPlugin$9
  implements GetScreenshot.Callback
{
  OpenDataCommonJsPlugin$9(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, InnerShareData.Builder paramBuilder) {}
  
  public void onGetScreenshot(String paramString)
  {
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      this.val$shareDataBuilder.setSharePicPath(paramString).build().shareAppMessage();
      return;
    }
    paramString = ((MiniAppFileManager)OpenDataCommonJsPlugin.access$700(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
    this.val$shareDataBuilder.setSharePicPath(paramString).setIsLocalPic(true).build().shareAppMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */