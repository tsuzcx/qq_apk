package com.tencent.smtt.sdk;

class SmttWebViewClient$1
  implements Runnable
{
  SmttWebViewClient$1(SmttWebViewClient paramSmttWebViewClient) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(SmttWebViewClient.access$000(this.this$0).getContext())) && (TbsDownloader.needDownload(SmttWebViewClient.access$000(this.this$0).getContext(), false))) {
      TbsDownloader.startDownload(SmttWebViewClient.access$000(this.this$0).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */