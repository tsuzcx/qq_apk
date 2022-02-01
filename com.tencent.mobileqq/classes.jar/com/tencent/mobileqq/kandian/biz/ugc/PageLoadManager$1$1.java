package com.tencent.mobileqq.kandian.biz.ugc;

import java.util.List;

class PageLoadManager$1$1
  implements Runnable
{
  PageLoadManager$1$1(PageLoadManager.1 param1, List paramList) {}
  
  public void run()
  {
    PageLoadManager.a(this.b.this$0, PageLoadManager.a(this.b.this$0) + this.a.size());
    PageLoadManager localPageLoadManager = this.b.this$0;
    boolean bool;
    if (this.a.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    PageLoadManager.a(localPageLoadManager, bool);
    if (PageLoadManager.c(this.b.this$0) != null) {
      PageLoadManager.c(this.b.this$0).a(this.a, PageLoadManager.d(this.b.this$0));
    }
    PageLoadManager.b(this.b.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.1.1
 * JD-Core Version:    0.7.0.1
 */