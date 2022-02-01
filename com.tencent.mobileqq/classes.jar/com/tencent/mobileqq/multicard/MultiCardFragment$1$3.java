package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import java.util.Map;

class MultiCardFragment$1$3
  implements Runnable
{
  MultiCardFragment$1$3(MultiCardFragment.1 param1, Map paramMap) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.b.this$0) != null)
    {
      MultiCardFragment.a(this.b.this$0).a(null, null, this.a);
      if ((this.a != null) && (MultiCardFragment.g(this.b.this$0) != null) && (MultiCardFragment.f(this.b.this$0)))
      {
        Object localObject = MultiCardFragment.a(this.b.this$0).b(MultiCardFragment.g(this.b.this$0).getCurrentItem());
        if ((localObject != null) && (this.a.containsKey(((CardContent)localObject).c())))
        {
          localObject = MultiCardFragment.a(this.b.this$0).a(((CardContent)localObject).c());
          MultiCardFragment.a(this.b.this$0, (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.3
 * JD-Core Version:    0.7.0.1
 */