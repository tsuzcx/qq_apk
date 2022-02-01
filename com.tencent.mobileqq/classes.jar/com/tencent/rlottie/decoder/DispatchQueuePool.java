package com.tencent.rlottie.decoder;

import androidx.annotation.UiThread;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;

public class DispatchQueuePool
{
  public static SecureRandom a = new SecureRandom();
  private LinkedList<DispatchQueue> b = new LinkedList();
  private HashMap<DispatchQueue, Integer> c = new HashMap();
  private LinkedList<DispatchQueue> d = new LinkedList();
  private int e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private Runnable j = new DispatchQueuePool.1(this);
  
  public DispatchQueuePool(int paramInt)
  {
    this.e = paramInt;
    this.g = a.nextInt();
  }
  
  @UiThread
  public void a(Runnable paramRunnable)
  {
    Object localObject;
    if ((!this.d.isEmpty()) && ((this.h / 2 <= this.d.size()) || ((this.b.isEmpty()) && (this.f >= this.e))))
    {
      localObject = (DispatchQueue)this.d.remove(0);
    }
    else if (this.b.isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DispatchQueuePool");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(a.nextInt());
      localObject = new DispatchQueue(((StringBuilder)localObject).toString());
      ((DispatchQueue)localObject).setPriority(10);
      this.f += 1;
    }
    else
    {
      localObject = (DispatchQueue)this.b.remove(0);
    }
    if (!this.i)
    {
      DispatchQueue.a(this.j, 30000L);
      this.i = true;
    }
    this.h += 1;
    this.d.add(localObject);
    Integer localInteger2 = (Integer)this.c.get(localObject);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.c.put(localObject, Integer.valueOf(localInteger1.intValue() + 1));
    ((DispatchQueue)localObject).b(new DispatchQueuePool.2(this, paramRunnable, (DispatchQueue)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.DispatchQueuePool
 * JD-Core Version:    0.7.0.1
 */