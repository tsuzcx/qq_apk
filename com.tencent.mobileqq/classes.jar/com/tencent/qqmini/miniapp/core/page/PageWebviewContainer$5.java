package com.tencent.qqmini.miniapp.core.page;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.page.widget.MiniSwipeRefreshLayout;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.util.HashMap;

class PageWebviewContainer$5
  implements Runnable
{
  PageWebviewContainer$5(PageWebviewContainer paramPageWebviewContainer, String paramString, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (PageWebviewContainer.access$300(this.this$0) != null) {
      PageWebviewContainer.access$300(this.this$0).setEnabled(false);
    }
    String str = ((MiniAppFileManager)PageWebviewContainer.access$400(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$filePath);
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = new File(str);
      if ((((File)localObject).exists()) && (((File)localObject).canRead()))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("style", "1");
        ((HashMap)localObject).put("local", "true");
        ((HashMap)localObject).put("topBarBgColor", "#808080");
        if (PageWebviewContainer.access$400(this.this$0).getAttachedActivity() == null)
        {
          QMLog.e("PageWebviewContainer", "can't openFileReader because of activity is null.");
          return;
        }
        if (QbSdk.openFileReader(PageWebviewContainer.access$400(this.this$0).getAttachedActivity(), str, (HashMap)localObject, new PageWebviewContainer.5.1(this)) > 0) {
          this.val$req.ok();
        }
      }
    }
    QMLog.e("PageWebviewContainer", "openDocument fail.");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.5
 * JD-Core Version:    0.7.0.1
 */