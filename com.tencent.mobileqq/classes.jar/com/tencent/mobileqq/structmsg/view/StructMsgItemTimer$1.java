package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.TimerCallback;

class StructMsgItemTimer$1
  implements CountdownTextView.TimerCallback
{
  StructMsgItemTimer$1(StructMsgItemTimer paramStructMsgItemTimer, CountdownTextView paramCountdownTextView) {}
  
  public void a()
  {
    StructMsgItemTimer localStructMsgItemTimer = this.b;
    localStructMsgItemTimer.aS = 0L;
    localStructMsgItemTimer.aU = true;
    this.a.setText(StructMsgItemTimer.a(localStructMsgItemTimer, 0L));
  }
  
  public void a(long paramLong)
  {
    paramLong /= 1000L;
    this.a.setText(StructMsgItemTimer.a(this.b, paramLong));
    this.b.aS = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTimer.1
 * JD-Core Version:    0.7.0.1
 */