package com.tencent.mobileqq.troop.robot.api.impl;

import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.OnTalkingChangeListener;
import java.lang.ref.WeakReference;

class TroopRobotServiceImpl$2
  implements Runnable
{
  TroopRobotServiceImpl$2(TroopRobotServiceImpl paramTroopRobotServiceImpl) {}
  
  public void run()
  {
    if (this.this$0.mOnTalkingChangeListener != null)
    {
      ITroopRobotService.OnTalkingChangeListener localOnTalkingChangeListener = (ITroopRobotService.OnTalkingChangeListener)this.this$0.mOnTalkingChangeListener.get();
      if (localOnTalkingChangeListener != null) {
        localOnTalkingChangeListener.a(this.this$0.talkingTroopUin, this.this$0.talkingRobotUin, this.this$0.mIsTalking);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */