package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.filter.AEOrientationEventListener;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess;

class QQLiveAnchorTRTCRoom$3
  extends AEOrientationEventListener
{
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QQLiveAnchorTRTCRoom.c(this.a) != null) {
      QQLiveAnchorTRTCRoom.c(this.a).a(paramFloat3);
    }
  }
  
  public void a(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorTRTCRoom.3
 * JD-Core Version:    0.7.0.1
 */