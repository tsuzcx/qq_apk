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
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (localObject1 == null) {
      return;
    }
    if (paramInt != 0) {
      try
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.ConnCallback
 * JD-Core Version:    0.7.0.1
 */