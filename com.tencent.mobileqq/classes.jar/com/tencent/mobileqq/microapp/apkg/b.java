package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public void run()
  {
    synchronized (a.a(this.a))
    {
      QWalletTools.saveObject(this.a, a.b(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.b
 * JD-Core Version:    0.7.0.1
 */