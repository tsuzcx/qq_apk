package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

class BridgeModule$19
  implements TopGestureLayout.OnGestureListener
{
  BridgeModule$19(BridgeModule paramBridgeModule) {}
  
  public void flingLToR()
  {
    BridgeModule.access$1702(this.a, true);
    this.a.onActivityBack();
    BridgeModule.access$1702(this.a, false);
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.19
 * JD-Core Version:    0.7.0.1
 */