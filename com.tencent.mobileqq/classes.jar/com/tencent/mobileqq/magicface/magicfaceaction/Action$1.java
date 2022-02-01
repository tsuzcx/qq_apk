package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class Action$1
  implements MagicfaceDecoder.MagicPlayListener
{
  Action$1(Action paramAction) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fun startMagicPlay begins, sumPlayTimes:");
      ((StringBuilder)localObject).append(this.a.l);
      ((StringBuilder)localObject).append(",actionGlobalData.openSound:");
      ((StringBuilder)localObject).append(this.a.a.n);
      QLog.d("Action", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.l == 0)
    {
      this.a.c();
      if ((this.a.d.f != null) && (this.a.d.f.length() > 0) && (this.a.a.n))
      {
        if (this.a.d.h > 0)
        {
          localObject = this.a.d;
          ((MagicfacePlayRes)localObject).h -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.a.g.a(this.a.d.f, this.a.d.h);
      }
      if (this.a.d.k)
      {
        this.a.m = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (this.a.d.l == -1) {
          this.a.m.vibrate(new long[] { 0L, 1000L }, 0);
        } else {
          this.a.m.vibrate(this.a.d.l * 1000);
        }
      }
    }
    Object localObject = this.a;
    ((Action)localObject).l += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fun startMagicPlay ends, sumPlayTimes:");
      ((StringBuilder)localObject).append(this.a.l);
      QLog.d("Action", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func endMagicPlay begins, isStop:");
      localStringBuilder.append(this.a.k);
      localStringBuilder.append(",timeout:");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(",playTimes:");
      localStringBuilder.append(this.a.f);
      localStringBuilder.append(",sumPlayTimes:");
      localStringBuilder.append(this.a.l);
      localStringBuilder.append(",isTimeout:");
      localStringBuilder.append(this.a.j);
      QLog.d("Action", 2, localStringBuilder.toString());
    }
    if (this.a.k)
    {
      this.a.o.countDown();
      return;
    }
    if (this.a.e == -1)
    {
      if (this.a.f == -1)
      {
        this.a.g.a(this.a.d);
        return;
      }
      if (this.a.f > this.a.l)
      {
        this.a.g.a(this.a.d);
        return;
      }
      if (this.a.f == this.a.l)
      {
        this.a.o.countDown();
        return;
      }
    }
    if (!this.a.j) {
      this.a.g.a(this.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action.1
 * JD-Core Version:    0.7.0.1
 */