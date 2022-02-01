package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.pubaccount.util.PreloadManager;
import java.net.URI;
import java.net.URISyntaxException;

class WebViewFragment$9
  implements Runnable
{
  WebViewFragment$9(WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    try
    {
      URI localURI = new URI(this.this$0.mUrl);
      if (PreloadManager.a().a(localURI.getHost())) {
        this.this$0.enableSwipeBackForHost(true);
      }
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localURISyntaxException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.9
 * JD-Core Version:    0.7.0.1
 */