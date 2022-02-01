package com.tencent.smtt.sdk;

class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(g.a(this.a).getContext())) && (TbsDownloader.needDownload(g.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(g.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.g.1
 * JD-Core Version:    0.7.0.1
 */