package com.tencent.mobileqq.troop.utils;

import java.lang.ref.WeakReference;

class TroopRobotManager$3
  implements Runnable
{
  TroopRobotManager$3(TroopRobotManager paramTroopRobotManager) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      TroopRobotManager.OnTalkingChangeListener localOnTalkingChangeListener = (TroopRobotManager.OnTalkingChangeListener)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnTalkingChangeListener != null) {
        localOnTalkingChangeListener.a(this.this$0.d, this.this$0.b, this.this$0.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.3
 * JD-Core Version:    0.7.0.1
 */