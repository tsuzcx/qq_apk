package com.tencent.mobileqq.kandian.repo.fastweb;

class FastWebModule$OutdateLimitCacheFeild<T>
{
  T a;
  public boolean b;
  private long d;
  private long e;
  
  public FastWebModule$OutdateLimitCacheFeild(T paramT)
  {
    this(paramT, localObject, 600000L);
    if (localObject == null) {
      this.b = true;
    }
  }
  
  public FastWebModule$OutdateLimitCacheFeild(T paramT, long paramLong)
  {
    this.a = paramLong;
    this.e = System.currentTimeMillis();
    Object localObject;
    this.d = localObject;
  }
  
  public void a(T paramT)
  {
    this.a = paramT;
    this.e = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.e >= this.d;
  }
  
  public T b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.OutdateLimitCacheFeild
 * JD-Core Version:    0.7.0.1
 */