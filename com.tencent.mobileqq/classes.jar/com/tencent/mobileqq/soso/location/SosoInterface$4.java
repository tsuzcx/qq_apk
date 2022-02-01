package com.tencent.mobileqq.soso.location;

final class SosoInterface$4
  implements Runnable
{
  SosoInterface$4(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener) {}
  
  public void run()
  {
    if (!this.val$tmpLis.isRemoved) {
      SosoInterface.startLocation(this.val$tmpLis);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.4
 * JD-Core Version:    0.7.0.1
 */