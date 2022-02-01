package com.tencent.mobileqq.relationx.icebreaking;

import java.lang.ref.WeakReference;
import java.util.List;

class IceBreakingMng$2
  implements Runnable
{
  IceBreakingMng$2(IceBreakingMng paramIceBreakingMng, List paramList, int paramInt) {}
  
  public void run()
  {
    if ((IceBreakingMng.b(this.this$0) != null) && (IceBreakingMng.b(this.this$0).get() != null)) {
      ((IIceBreakHotPicCallback)IceBreakingMng.b(this.this$0).get()).a(true, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.2
 * JD-Core Version:    0.7.0.1
 */