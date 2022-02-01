package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;

class SwiftBrowserShareMenuHandler$1
  implements Runnable
{
  SwiftBrowserShareMenuHandler$1(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int k = this.this$0.f.a().c;
    String str1;
    if (this.this$0.f.a().c == 0)
    {
      str1 = this.this$0.e.getAppRuntime().getCurrentAccountUin();
      String str2 = this.this$0.f.a().n;
      String str3 = this.this$0.f.a().m;
      boolean bool;
      if (this.this$0.f.a().f == 3) {
        bool = true;
      } else {
        bool = false;
      }
      if (!TeamWorkHandlerUtils.a(str1, str2, str3, bool, false, 1, null, null, null))
      {
        i = 0;
        break label127;
      }
    }
    int i = 1;
    label127:
    int j = i;
    if (i != 0)
    {
      str1 = TeamWorkHandlerUtils.b(this.this$0.e.getAppRuntime().getCurrentAccountUin(), this.this$0.f.a());
      this.this$0.f.a().q = str1;
      if (str1 != null) {
        j = 1;
      } else {
        j = 0;
      }
    }
    SwiftBrowserShareMenuHandler.a(this.this$0, this.a, this.b, this.c, this.d);
    if ((j != 0) && ((this.this$0.e instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
      ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)this.this$0.e).c(k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1
 * JD-Core Version:    0.7.0.1
 */