package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qphone.base.util.QLog;

class DataJsPlugin$10
  implements BaseAppBrandRuntime.ShareScreenshotCallback
{
  DataJsPlugin$10(DataJsPlugin paramDataJsPlugin, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, EntryModel paramEntryModel, ShareChatModel paramShareChatModel, boolean paramBoolean, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener) {}
  
  public void onGetShareScreenshot(String paramString)
  {
    int i = 11;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.this$0.jsPluginEngine.appBrandRuntime;
      localObject = this.val$title;
      str1 = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().iconUrl;
      str2 = this.val$finalPath;
      str3 = this.val$webURL;
      str4 = this.val$shareTemplateId;
      str5 = this.val$shareTemplateData;
      localEntryModel = this.val$finalQQDirectlyModel;
      localShareChatModel = this.val$finalChatDirectlyModel;
      if (this.val$finalFromInnerButton1) {}
      for (;;)
      {
        paramString.startShare((String)localObject, str1, str2, str3, str4, str5, localEntryModel, localShareChatModel, i, this.val$shareTarget, "", this.val$shareListener);
        QLog.e("[mini] DataJsPlugin", 1, "getShareScreenshot failed, savedScreenshotPath = null");
        return;
        i = 12;
      }
    }
    Object localObject = this.this$0.jsPluginEngine.appBrandRuntime;
    String str1 = this.val$title;
    String str2 = this.val$finalPath;
    String str3 = this.val$webURL;
    String str4 = this.val$shareTemplateId;
    String str5 = this.val$shareTemplateData;
    EntryModel localEntryModel = this.val$finalQQDirectlyModel;
    ShareChatModel localShareChatModel = this.val$finalChatDirectlyModel;
    if (this.val$finalFromInnerButton1) {}
    for (;;)
    {
      ((BaseAppBrandRuntime)localObject).startShare(str1, paramString, str2, str3, str4, str5, localEntryModel, localShareChatModel, i, this.val$shareTarget, "", this.val$shareListener);
      return;
      i = 12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */