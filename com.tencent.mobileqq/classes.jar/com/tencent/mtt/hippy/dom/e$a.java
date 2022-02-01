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
    do
    {
      paramObject1 = paramObject1.a;
      if (paramObject1.a == null) {
        break;
      }
    } while (paramLong >= paramObject1.a.b);
    localb.a = paramObject1.a;
    paramObject1.a = localb;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    Object localObject2 = null;
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      e.b localb = ((e.b)localObject1).a;
      Object localObject3;
      if (paramObject1 != null)
      {
        localObject3 = localObject1;
        if (((e.b)localObject1).c != paramObject1) {}
      }
      else if (paramObject2 != null)
      {
        localObject3 = localObject1;
        if (((e.b)localObject1).d != paramObject2) {}
      }
      else
      {
        if (localObject2 == null) {
          break label82;
        }
        localObject2.a = localb;
      }
      for (;;)
      {
        this.a.a((e.b)localObject1);
        localObject3 = localObject2;
        localObject2 = localObject3;
        localObject1 = localb;
        break;
        label82:
        this.b = localb;
      }
    }
  }
  
  public boolean a(long paramLong)
  {
    return (this.b != null) && (this.b.b <= paramLong);
  }
  
  public e.b b(long paramLong)
  {
    e.b localb1 = this.b;
    if ((localb1 == null) || (localb1.b > paramLong)) {
      return null;
    }
    Object localObject1 = localb1.a;
    Object localObject2 = localb1;
    for (;;)
    {
      if (localObject1 != null)
      {
        if (((e.b)localObject1).b > paramLong) {
          ((e.b)localObject2).a = null;
        }
      }
      else
      {
        this.b = ((e.b)localObject1);
        return localb1;
      }
      e.b localb2 = ((e.b)localObject1).a;
      localObject2 = localObject1;
      localObject1 = localb2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e.a
 * JD-Core Version:    0.7.0.1
 */