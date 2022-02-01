package com.tencent.mobileqq.jsp;

import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class StudyModePlugin$2
  implements Runnable
{
  StudyModePlugin$2(StudyModePlugin paramStudyModePlugin, WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    WebViewFragment localWebViewFragment = this.a;
    if ((localWebViewFragment != null) && (localWebViewFragment.getSwiftTitleUI() != null) && (this.a.getSwiftTitleUI().d != null)) {
      this.a.getSwiftTitleUI().d.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.StudyModePlugin.2
 * JD-Core Version:    0.7.0.1
 */