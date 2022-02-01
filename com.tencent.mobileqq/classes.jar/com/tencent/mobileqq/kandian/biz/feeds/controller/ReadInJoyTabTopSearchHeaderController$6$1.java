package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.app.UniteSearchHandler;

class ReadInJoyTabTopSearchHeaderController$6$1
  implements Runnable
{
  ReadInJoyTabTopSearchHeaderController$6$1(ReadInJoyTabTopSearchHeaderController.6 param6) {}
  
  public void run()
  {
    if (this.a.this$0.a) {
      return;
    }
    this.a.this$0.a(this.a.a, this.a.b, this.a.c);
    new UniteSearchHandler(this.a.d).a(this.a.d, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController.6.1
 * JD-Core Version:    0.7.0.1
 */