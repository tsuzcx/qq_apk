package com.tencent.mtt.hippy.dom;

final class e$a
{
  private e.b b;
  
  private e$a(e parame) {}
  
  public void a(long paramLong, Object paramObject1, Object paramObject2)
  {
    e.b localb = this.a.a(paramLong, paramObject1, paramObject2);
    paramObject2 = this.b;
    if (paramObject2 == null)
    {
      this.b = localb;
      return;
    }
    paramObject1 = paramObject2;
    if (paramLong < paramObject2.b)
    {
      localb.a = paramObject2;
      this.b = localb;
      return;
    }
    while (paramObject1.a != null)
    {
      if (paramLong < paramObject1.a.b)
      {
        localb.a = paramObject1.a;
        break;
      }
      paramObject1 = paramObject1.a;
    }
    paramObject1.a = localb;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = this.b;
    Object localObject2 = null;
    while (localObject1 != null)
    {
      e.b localb = ((e.b)localObject1).a;
      if (((paramObject1 != null) && (((e.b)localObject1).c != paramObject1)) || ((paramObject2 != null) && (((e.b)localObject1).d != paramObject2)))
      {
        localObject2 = localObject1;
      }
      else
      {
        if (localObject2 != null) {
          localObject2.a = localb;
        } else {
          this.b = localb;
        }
        this.a.a((e.b)localObject1);
      }
      localObject1 = localb;
    }
  }
  
  public boolean a(long paramLong)
  {
    e.b localb = this.b;
    return (localb != null) && (localb.b <= paramLong);
  }
  
  public e.b b(long paramLong)
  {
    e.b localb1 = this.b;
    if (localb1 != null)
    {
      if (localb1.b > paramLong) {
        return null;
      }
      Object localObject1 = localb1.a;
      Object localObject2 = localb1;
      while (localObject1 != null)
      {
        if (((e.b)localObject1).b > paramLong)
        {
          ((e.b)localObject2).a = null;
          break;
        }
        e.b localb2 = ((e.b)localObject1).a;
        localObject2 = localObject1;
        localObject1 = localb2;
      }
      this.b = ((e.b)localObject1);
      return localb1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e.a
 * JD-Core Version:    0.7.0.1
 */