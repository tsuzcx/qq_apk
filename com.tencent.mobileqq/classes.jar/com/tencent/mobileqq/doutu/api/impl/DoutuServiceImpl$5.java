package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import java.util.List;

class DoutuServiceImpl$5
  implements Runnable
{
  DoutuServiceImpl$5(DoutuServiceImpl paramDoutuServiceImpl, boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.mDoutuAdapter != null)
    {
      if ((this.a) && (this.b.size() >= 0))
      {
        this.this$0.mDoutuAdapter.a(this.b, this.c, this.d);
        return;
      }
      if (this.c) {
        this.this$0.mDoutuAdapter.a(this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */