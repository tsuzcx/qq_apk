package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.easysync2.utils.Utils;

public class MergingOpAssembler
  extends OpAssembler
{
  Operation a = new Operation();
  int b = 0;
  private OpAssembler c = new OpAssembler();
  
  public void a()
  {
    a(false);
  }
  
  public void a(Operation paramOperation)
  {
    if (paramOperation.b > 0)
    {
      if ((this.a.a == paramOperation.a) && (Utils.a(this.a.d, paramOperation.d)))
      {
        Operation localOperation;
        if (paramOperation.c > 0)
        {
          localOperation = this.a;
          localOperation.b += this.b + paramOperation.b;
          localOperation = this.a;
          localOperation.c += paramOperation.c;
          this.b = 0;
          return;
        }
        if (this.a.c == 0)
        {
          localOperation = this.a;
          localOperation.b += paramOperation.b;
          return;
        }
        this.b += paramOperation.b;
        return;
      }
      a();
      Changeset.a(paramOperation, this.a);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != 0)
    {
      if ((!paramBoolean) || (this.a.a != '=') || (!Utils.a(this.a.d)))
      {
        this.c.a(this.a);
        int i = this.b;
        if (i > 0)
        {
          Operation localOperation = this.a;
          localOperation.b = i;
          localOperation.c = 0;
          this.c.a(localOperation);
          this.b = 0;
        }
      }
      this.a.a = '\000';
    }
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    this.c.c();
    Changeset.a(this.a);
  }
  
  @NonNull
  public String toString()
  {
    a();
    return this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.MergingOpAssembler
 * JD-Core Version:    0.7.0.1
 */