package com.tencent.mobileqq.emosm.control;

import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public abstract class EmoAutomator
  implements Runnable
{
  public int a;
  public long a;
  private EmoLinearGroup a;
  protected LinkedList<EmoAsyncStep> a;
  protected int b;
  private LinkedList<EmoLinearGroup> b;
  
  public EmoAutomator()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoLinearGroup = null;
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoAutomator", 2, "onDestroy");
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_b_of_type_Int = 0;
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_b_of_type_JavaUtilLinkedList.clear();
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoLinearGroup.a(8);
          this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoLinearGroup = null;
        }
        this.jdField_a_of_type_Long = 0L;
        return;
      }
    }
  }
  
  @TargetApi(9)
  public void a(EmoAsyncStep paramEmoAsyncStep) {}
  
  public void a(EmoAsyncStep[] paramArrayOfEmoAsyncStep)
  {
    int i;
    label100:
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_b_of_type_Int -= 1;
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        if (paramArrayOfEmoAsyncStep != null)
        {
          int j = paramArrayOfEmoAsyncStep.length;
          i = 0;
          if (i < j)
          {
            EmoAsyncStep localEmoAsyncStep = paramArrayOfEmoAsyncStep[i];
            if (!this.jdField_a_of_type_JavaUtilLinkedList.remove(localEmoAsyncStep)) {
              break label100;
            }
            a(localEmoAsyncStep);
            return;
          }
        }
        a((EmoAsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll());
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoAutomator
 * JD-Core Version:    0.7.0.1
 */