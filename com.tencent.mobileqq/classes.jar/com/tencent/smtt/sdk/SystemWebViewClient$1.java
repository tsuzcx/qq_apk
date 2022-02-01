package com.tencent.smtt.sdk;

class SystemWebViewClient$1
  implements Runnable
{
  SystemWebViewClient$1(SystemWebViewClient paramSystemWebViewClient) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.a(this.a).getContext())) && (TbsDownloader.needDownload(SystemWebViewClient.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(SystemWebViewClient.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */