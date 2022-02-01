package com.tencent.rfw.barrage.core;

class RFWBarrageMeasureManager$1
  implements Runnable
{
  public void run()
  {
    RFWBarrageMeasureManager.a(RFWBarrageMeasureManager.a(this.this$0), this.a);
    RFWBarrageMeasureManager.IMeasureCallback localIMeasureCallback = this.b;
    if (localIMeasureCallback != null) {
      localIMeasureCallback.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageMeasureManager.1
 * JD-Core Version:    0.7.0.1
 */