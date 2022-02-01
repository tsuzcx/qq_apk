package com.tencent.mobileqq.magicface.view;

import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceActionListener;
import com.tencent.qphone.base.util.QLog;

class MagicfaceViewController$7
  implements MagicfaceActionManager.MagicfaceActionListener
{
  MagicfaceViewController$7(MagicfaceViewController paramMagicfaceViewController, long paramLong, int paramInt) {}
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("【magicface】 cost =");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
      QLog.d("MagicfaceViewController", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (this.b == 0)
    {
      bool = this.c.q.k();
      this.c.q.d(bool);
    }
    else
    {
      bool = this.c.q.l();
      this.c.q.d(bool);
    }
    this.c.x.post(new MagicfaceViewController.7.1(this, paramActionGlobalData));
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.c.x.post(new MagicfaceViewController.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7
 * JD-Core Version:    0.7.0.1
 */