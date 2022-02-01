package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import java.util.Random;

public class UFTTransferKey
  implements IUFTTransferKey
{
  private int a = 0;
  private long b = 0L;
  private boolean c = false;
  private Object d;
  
  public UFTTransferKey(int paramInt, boolean paramBoolean)
  {
    a(paramInt);
    a((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
    a(paramBoolean);
  }
  
  public Object a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey
 * JD-Core Version:    0.7.0.1
 */