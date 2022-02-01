package com.tencent.smtt.sdk;

class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(i.a(this.a).getContext())) && (TbsDownloader.needDownload(i.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(i.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.i.1
 * JD-Core Version:    0.7.0.1
 */