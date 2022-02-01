package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.listentogether.player.IConnCallback;

class ListenTogetherManager$ConnCallback
  implements IConnCallback
{
  public Object a = new Object();
  
  private ListenTogetherManager$ConnCallback(ListenTogetherManager paramListenTogetherManager) {}
  
  public void a(int paramInt)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    if (paramInt != 0) {
      try
      {
        this.a.notifyAll();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.ConnCallback
 * JD-Core Version:    0.7.0.1
 */