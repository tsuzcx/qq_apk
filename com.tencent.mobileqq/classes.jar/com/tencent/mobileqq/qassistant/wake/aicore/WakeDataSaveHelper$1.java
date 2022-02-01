package com.tencent.mobileqq.qassistant.wake.aicore;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

class WakeDataSaveHelper$1
  implements Runnable
{
  WakeDataSaveHelper$1(WakeDataSaveHelper paramWakeDataSaveHelper, LinkedList paramLinkedList, float paramFloat, int paramInt) {}
  
  public void run()
  {
    WakeDataSaveHelper.a(this.this$0, this.jdField_a_of_type_JavaUtilLinkedList, Float.valueOf(this.jdField_a_of_type_Float), this.jdField_a_of_type_Int);
    ((AtomicBoolean)this.this$0.b.get(this.jdField_a_of_type_Int)).set(false);
    AssistantUtils.a("HelloQQWake", "saveData " + this.jdField_a_of_type_Int + ":" + this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.WakeDataSaveHelper.1
 * JD-Core Version:    0.7.0.1
 */