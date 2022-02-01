package com.tencent.superplayer.bandwidth;

import com.tencent.superplayer.api.ISuperPlayer;

class SPBufferRangeController$1
  implements Runnable
{
  SPBufferRangeController$1(SPBufferRangeController paramSPBufferRangeController, ISuperPlayer paramISuperPlayer, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.val$player.setBusinessDownloadStrategy(this.val$buffferRange[0], this.val$buffferRange[1], this.val$emergencyTimeForPreplay, this.val$emergencyTimeForPreplay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBufferRangeController.1
 * JD-Core Version:    0.7.0.1
 */