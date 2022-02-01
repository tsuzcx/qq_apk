package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.biz.skin.RefreshRes;
import java.io.File;

class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  KanDianViewController$PullRefreshCompleteListener$1(KanDianViewController.PullRefreshCompleteListener paramPullRefreshCompleteListener) {}
  
  public void run()
  {
    String str = RefreshRes.f();
    if ((str != null) && (new File(str).exists()))
    {
      KanDianViewController.a(this.a.a, str);
      KanDianViewController.a(this.a.a).removeMessages(3);
      KanDianViewController.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */