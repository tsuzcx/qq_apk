package com.tencent.qqmini.sdk.runtime.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import bgmk;
import bgnt;
import bhgc;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.util.HashMap;

public class PageWebviewContainer$6
  implements Runnable
{
  PageWebviewContainer$6(PageWebviewContainer paramPageWebviewContainer, String paramString, bgmk parambgmk) {}
  
  public void run()
  {
    if (PageWebviewContainer.a(this.this$0) != null) {
      PageWebviewContainer.a(this.this$0).setEnabled(false);
    }
    String str = bgnt.a().a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = new File(str);
      if ((((File)localObject).exists()) && (((File)localObject).canRead()))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("style", "1");
        ((HashMap)localObject).put("local", "true");
        ((HashMap)localObject).put("topBarBgColor", "#808080");
        if (QbSdk.openFileReader(AppLoaderFactory.g().getContext(), str, (HashMap)localObject, new bhgc(this)) > 0) {
          this.jdField_a_of_type_Bgmk.a();
        }
      }
    }
    QMLog.e("PageWebviewContainer", "openDocument fail.");
    this.jdField_a_of_type_Bgmk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer.6
 * JD-Core Version:    0.7.0.1
 */