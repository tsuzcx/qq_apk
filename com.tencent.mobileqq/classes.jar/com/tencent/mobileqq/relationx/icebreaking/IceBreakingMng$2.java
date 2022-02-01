package com.tencent.mobileqq.relationx.icebreaking;

import bbcc;
import bbcd;
import java.lang.ref.WeakReference;
import java.util.List;

public class IceBreakingMng$2
  implements Runnable
{
  public IceBreakingMng$2(bbcd parambbcd, List paramList) {}
  
  public void run()
  {
    if ((bbcd.b(this.this$0) != null) && (bbcd.b(this.this$0).get() != null)) {
      ((bbcc)bbcd.b(this.this$0).get()).a(true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.2
 * JD-Core Version:    0.7.0.1
 */