package com.tencent.mobileqq.qassistant.wake.aicore;

import bakl;
import baod;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class WakeDataSaveHelper$1
  implements Runnable
{
  public WakeDataSaveHelper$1(baod parambaod, LinkedList paramLinkedList, float paramFloat, int paramInt) {}
  
  public void run()
  {
    baod.a(this.this$0, this.jdField_a_of_type_JavaUtilLinkedList, Float.valueOf(this.jdField_a_of_type_Float), this.jdField_a_of_type_Int);
    ((AtomicBoolean)this.this$0.b.get(this.jdField_a_of_type_Int)).set(false);
    bakl.a("HelloQQWake", "saveData " + this.jdField_a_of_type_Int + ":" + this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.WakeDataSaveHelper.1
 * JD-Core Version:    0.7.0.1
 */