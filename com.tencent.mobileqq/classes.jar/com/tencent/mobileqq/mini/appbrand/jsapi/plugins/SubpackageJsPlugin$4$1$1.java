package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import atwl;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import java.io.File;

class SubpackageJsPlugin$4$1$1
  implements Runnable
{
  SubpackageJsPlugin$4$1$1(SubpackageJsPlugin.4.1 param1) {}
  
  public void run()
  {
    atwl.a(new File(ApkgManager.getApkgFolderPath(this.this$2.this$1.val$miniGamePkg.appConfig.config), this.this$2.val$dirPath));
    SubpackageJsPlugin.access$000(this.this$2.this$1.this$0, this.this$2.this$1.val$webviewRef, this.this$2.this$1.val$taskId, this.this$2.this$1.val$subPackageName, this.this$2.this$1.val$currentLoader, this.this$2.this$1.val$miniGamePkg, this.this$2.this$1.val$tryCount + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.4.1.1
 * JD-Core Version:    0.7.0.1
 */