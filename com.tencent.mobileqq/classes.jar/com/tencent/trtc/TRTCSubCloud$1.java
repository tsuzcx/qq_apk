package com.tencent.trtc;

import java.util.ArrayList;
import java.util.HashMap;

class TRTCSubCloud$1
  implements Runnable
{
  TRTCSubCloud$1(TRTCSubCloud paramTRTCSubCloud) {}
  
  public void run()
  {
    synchronized (TRTCSubCloud.access$000(this.a))
    {
      if (TRTCSubCloud.access$100(this.a) != 0L)
      {
        TRTCSubCloud.access$200(this.a, "destroy context");
        TRTCSubCloud.access$400(this.a, TRTCSubCloud.access$300(this.a));
      }
      TRTCSubCloud.access$502(this.a, 0L);
      TRTCSubCloud.access$602(this.a, null);
      TRTCSubCloud.access$702(this.a, null);
      TRTCSubCloud.access$800(this.a).clear();
      TRTCSubCloud.access$900(this.a).clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.1
 * JD-Core Version:    0.7.0.1
 */