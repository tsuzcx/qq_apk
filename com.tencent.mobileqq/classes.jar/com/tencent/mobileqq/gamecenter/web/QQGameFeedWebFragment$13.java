package com.tencent.mobileqq.gamecenter.web;

import abuf;
import amwn;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$13
  implements Runnable
{
  QQGameFeedWebFragment$13(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    QQGameFeedWebFragment.a(this.this$0, false, 0);
    this.this$0.c();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), "1");
    localHashMap.put(Integer.valueOf(4), "20");
    abuf.a(amwn.a(), "769", "205036", "", "76901", "1", "160", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.13
 * JD-Core Version:    0.7.0.1
 */