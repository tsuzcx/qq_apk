package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.listentogether.player.IConnCallback;

class ListenTogetherManager$ConnCallback
  implements IConnCallback
{
  public Object a;
  
  private ListenTogetherManager$ConnCallback(ListenTogetherManager paramListenTogetherManager)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangObject == null) {}
    while (paramInt == 0) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.ConnCallback
 * JD-Core Version:    0.7.0.1
 */