package com.tencent.mobileqq.soso.location;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

final class SosoInterface$6
  implements Runnable
{
  SosoInterface$6(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener, int paramInt, SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    this.val$lis.onLocationFinish(this.val$err, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.6
 * JD-Core Version:    0.7.0.1
 */