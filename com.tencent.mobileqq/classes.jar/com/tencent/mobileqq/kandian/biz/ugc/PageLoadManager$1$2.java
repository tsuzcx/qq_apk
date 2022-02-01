package com.tencent.mobileqq.kandian.biz.ugc;

import java.util.ArrayList;

class PageLoadManager$1$2
  implements Runnable
{
  PageLoadManager$1$2(PageLoadManager.1 param1) {}
  
  public void run()
  {
    PageLoadManager.a(this.a.this$0, true);
    if (PageLoadManager.c(this.a.this$0) != null) {
      PageLoadManager.c(this.a.this$0).a(new ArrayList(), PageLoadManager.d(this.a.this$0));
    }
    PageLoadManager.b(this.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.1.2
 * JD-Core Version:    0.7.0.1
 */