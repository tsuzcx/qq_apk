package com.tencent.mobileqq.emosm.control;

import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public abstract class EmoAutomator
  implements Runnable
{
  public long a;
  public int b = 0;
  protected int c = 0;
  protected LinkedList<EmoAsyncStep> d = new LinkedList();
  private EmoLinearGroup e = null;
  private LinkedList<EmoLinearGroup> f = new LinkedList();
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoAutomator", 2, "onDestroy");
    }
    synchronized (this.d)
    {
      this.d.clear();
      this.c = 0;
      synchronized (this.f)
      {
        this.f.clear();
        if (this.e != null)
        {
          this.e.a(8);
          this.e = null;
        }
        this.a = 0L;
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
    synchronized (this.d)
    {
      this.c -= 1;
      if (this.d.size() > 0)
      {
        if (paramArrayOfEmoAsyncStep != null)
        {
          int j = paramArrayOfEmoAsyncStep.length;
          i = 0;
          if (i < j)
          {
            EmoAsyncStep localEmoAsyncStep = paramArrayOfEmoAsyncStep[i];
            if (!this.d.remove(localEmoAsyncStep)) {
              break label100;
            }
            a(localEmoAsyncStep);
            return;
          }
        }
        a((EmoAsyncStep)this.d.poll());
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoAutomator
 * JD-Core Version:    0.7.0.1
 */