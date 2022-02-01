package com.tencent.mobileqq.multicard;

import java.util.List;
import java.util.Map;

class MultiCardFragment$1$1
  implements Runnable
{
  MultiCardFragment$1$1(MultiCardFragment.1 param1, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.d.this$0) != null) {
      MultiCardFragment.a(this.d.this$0).a(this.a, this.b, this.c);
    }
    if (MultiCardFragment.b(this.d.this$0) != null) {
      MultiCardFragment.b(this.d.this$0).g();
    }
    if (MultiCardFragment.c(this.d.this$0) != null) {
      MultiCardFragment.c(this.d.this$0).notifyDataSetChanged();
    }
    if (MultiCardFragment.d(this.d.this$0) != null)
    {
      MultiCardFragment.d(this.d.this$0).a(this.a.size());
      MultiCardFragment.d(this.d.this$0).b(0);
      MultiCardFragment.d(this.d.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.1
 * JD-Core Version:    0.7.0.1
 */