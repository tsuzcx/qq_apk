package com.tencent.mobileqq.webview;

import bgth;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class WebViewAioShareMusicHelper$1
  implements Runnable
{
  public WebViewAioShareMusicHelper$1(bgth parambgth, boolean paramBoolean) {}
  
  public void run()
  {
    if ((bgth.a(this.this$0) != null) && (bgth.a(this.this$0).mUIStyleHandler != null)) {
      bgth.a(this.this$0).mUIStyleHandler.setShareMusicVisible(this.a, bgth.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.1
 * JD-Core Version:    0.7.0.1
 */