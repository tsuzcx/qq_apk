package com.tencent.superplayer.bandwidth;

import com.tencent.superplayer.api.ISuperPlayer;

class SPBufferRangeController$1
  implements Runnable
{
  SPBufferRangeController$1(SPBufferRangeController paramSPBufferRangeController, ISuperPlayer paramISuperPlayer, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    ISuperPlayer localISuperPlayer = this.val$player;
    int[] arrayOfInt = this.val$buffferRange;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = this.val$emergencyTimeForPreplay;
    localISuperPlayer.setBusinessDownloadStrategy(i, j, k, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBufferRangeController.1
 * JD-Core Version:    0.7.0.1
 */