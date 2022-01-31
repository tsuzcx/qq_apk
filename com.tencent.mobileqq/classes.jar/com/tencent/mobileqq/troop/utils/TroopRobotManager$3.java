package com.tencent.mobileqq.troop.utils;

import bckx;
import bclg;
import java.lang.ref.WeakReference;

public class TroopRobotManager$3
  implements Runnable
{
  public TroopRobotManager$3(bckx parambckx) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bclg localbclg = (bclg)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbclg != null) {
        localbclg.a(this.this$0.d, this.this$0.b, this.this$0.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.3
 * JD-Core Version:    0.7.0.1
 */