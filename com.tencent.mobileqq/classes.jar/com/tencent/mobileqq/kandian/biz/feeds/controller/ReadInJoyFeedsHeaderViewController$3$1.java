package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.app.UniteSearchHandler;

class ReadInJoyFeedsHeaderViewController$3$1
  implements Runnable
{
  ReadInJoyFeedsHeaderViewController$3$1(ReadInJoyFeedsHeaderViewController.3 param3) {}
  
  public void run()
  {
    if (this.a.this$0.a) {
      return;
    }
    this.a.this$0.f();
    this.a.this$0.c = new UniteSearchHandler(this.a.a);
    this.a.this$0.c.a(this.a.a, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.3.1
 * JD-Core Version:    0.7.0.1
 */