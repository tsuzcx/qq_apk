package com.tencent.mobileqq.relationx.icebreaking;

import java.lang.ref.WeakReference;

class IceBreakingMng$3
  implements Runnable
{
  IceBreakingMng$3(IceBreakingMng paramIceBreakingMng) {}
  
  public void run()
  {
    if (IceBreakingMng.b(this.this$0) != null)
    {
      IIceBreakHotPicCallback localIIceBreakHotPicCallback = (IIceBreakHotPicCallback)IceBreakingMng.b(this.this$0).get();
      if (localIIceBreakHotPicCallback != null) {
        localIIceBreakHotPicCallback.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.3
 * JD-Core Version:    0.7.0.1
 */