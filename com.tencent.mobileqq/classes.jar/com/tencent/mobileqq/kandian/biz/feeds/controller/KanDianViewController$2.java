package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.biz.skin.CommonSkinRes;
import java.io.File;

class KanDianViewController$2
  implements Runnable
{
  KanDianViewController$2(KanDianViewController paramKanDianViewController) {}
  
  public void run()
  {
    String str = CommonSkinRes.k();
    if ((str != null) && (new File(str).exists()))
    {
      KanDianViewController.a(this.this$0).removeMessages(2);
      KanDianViewController.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.2
 * JD-Core Version:    0.7.0.1
 */