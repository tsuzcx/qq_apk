package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DoutuServiceImpl$ComboData
{
  private boolean b;
  private List<DoutuMsgItem> c;
  private int d;
  private boolean e;
  private int f;
  
  public DoutuServiceImpl$ComboData(List<DoutuMsgItem> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramBoolean;
    this.e = paramInt2;
    int i;
    this.f = i;
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    int j = 0;
    while ((i < DoutuServiceImpl.access$900(this.a).size()) && (((DoutuMsgItem)DoutuServiceImpl.access$900(this.a).get(i)).c < paramLong))
    {
      j += 1;
      i += 1;
    }
    return j;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public ComboData e()
  {
    Object localObject;
    long l;
    if ((DoutuServiceImpl.access$800(this.a) != 0) && (this.c.size() == DoutuServiceImpl.access$800(this.a)))
    {
      if ((DoutuServiceImpl.access$900(this.a) != null) && (DoutuServiceImpl.access$900(this.a).size() > 0))
      {
        int i = a(((DoutuMsgItem)this.c.get(0)).c);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleCombo : offset = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        if ((i > 0) && (this.c.size() - 1 - i >= 0))
        {
          localObject = this.c;
          l = ((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1 - i)).a;
          localObject = this.c;
          if (((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1)).a - l < DoutuServiceImpl.access$1000(this.a))
          {
            this.f = (this.c.size() - 1);
            this.d += i;
            this.e = true;
            localObject = this.a;
            ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.a), (DoutuMsgItem)this.c.get(this.f), this.d, this.f);
            this.b = true;
            return this;
          }
          this.f = (this.c.size() - 1);
          this.d = 0;
          localObject = this.a;
          ((DoutuServiceImpl)localObject).removeComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.a));
          this.b = true;
          return this;
        }
      }
      this.f = (this.c.size() - 1);
      localObject = this.a;
      ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.a), (DoutuMsgItem)this.c.get(this.f), this.d, this.f);
      this.b = true;
      return this;
    }
    if ((DoutuServiceImpl.access$800(this.a) != 0) && (this.c.size() > DoutuServiceImpl.access$800(this.a)))
    {
      l = ((DoutuMsgItem)this.c.get(DoutuServiceImpl.access$800(this.a) - 1)).a;
      localObject = this.c;
      if (((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1)).a - l < DoutuServiceImpl.access$1000(this.a))
      {
        this.f = (this.c.size() - 1);
        this.d += this.c.size() - DoutuServiceImpl.access$800(this.a);
        localObject = this.a;
        ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.a), (DoutuMsgItem)this.c.get(this.f), this.d, this.f);
        this.b = true;
        return this;
      }
      this.f = (this.c.size() - 1);
      this.d = 0;
      localObject = this.a;
      ((DoutuServiceImpl)localObject).removeComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.a));
      this.b = true;
      return this;
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.ComboData
 * JD-Core Version:    0.7.0.1
 */