package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.app.UniteSearchHandler;

class ReadInJoyFeedsHeaderViewController$3$1
  implements Runnable
{
  ReadInJoyFeedsHeaderViewController$3$1(ReadInJoyFeedsHeaderViewController.3 param3) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.this$0.f();
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = new UniteSearchHandler(this.a.a);
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.a.a, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.3.1
 * JD-Core Version:    0.7.0.1
 */