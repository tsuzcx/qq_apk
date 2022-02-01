package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import java.util.List;

class ReadInJoyDraftboxFragment$1$1$1
  implements Runnable
{
  ReadInJoyDraftboxFragment$1$1$1(ReadInJoyDraftboxFragment.1.1 param1, List paramList) {}
  
  public void run()
  {
    ReadInJoyDraftboxFragment.b(this.b.a.this$0).clear();
    Object localObject = this.a;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (ReadInJoyDraftboxItem)this.a.get(i);
        if (ReadInJoyDraftboxFragment.a((ReadInJoyDraftboxItem)localObject)) {
          ReadInJoyDraftboxFragment.b(this.b.a.this$0).add(localObject);
        }
        i -= 1;
      }
    }
    ReadInJoyDraftboxFragment.c(this.b.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */