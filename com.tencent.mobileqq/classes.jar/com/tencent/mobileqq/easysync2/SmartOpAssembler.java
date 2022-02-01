package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.List;

public class SmartOpAssembler
  extends OpAssembler
{
  private MergingOpAssembler a = new MergingOpAssembler();
  private MergingOpAssembler b = new MergingOpAssembler();
  private MergingOpAssembler c = new MergingOpAssembler();
  private StringBuilder d = new StringBuilder();
  private char e;
  private int f;
  
  private void a(Operation paramOperation, String paramString)
  {
    int i = paramString.lastIndexOf('\n');
    if (i < 0)
    {
      paramOperation.b = paramString.length();
      paramOperation.c = 0;
      a(paramOperation);
      return;
    }
    i += 1;
    paramOperation.b = i;
    paramOperation.c = (paramString.split("\n", -1).length - 1);
    a(paramOperation);
    paramOperation.b = (paramString.length() - i);
    paramOperation.c = 0;
    a(paramOperation);
  }
  
  private void d()
  {
    this.d.append(this.c.toString());
    this.c.c();
  }
  
  private void e()
  {
    this.d.append(this.a.toString());
    this.a.c();
    this.d.append(this.b.toString());
    this.b.c();
  }
  
  public void a()
  {
    this.c.b();
  }
  
  void a(char paramChar, String paramString)
  {
    Operation localOperation = Changeset.a(paramChar);
    localOperation.d = "";
    a(localOperation, paramString);
  }
  
  void a(char paramChar, String paramString, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    Operation localOperation = Changeset.a(paramChar);
    localOperation.d = Changeset.a(paramChar, paramList, paramAttribPool);
    a(localOperation, paramString);
  }
  
  public void a(Operation paramOperation)
  {
    if (paramOperation.a == 0) {
      return;
    }
    if (paramOperation.b == 0) {
      return;
    }
    if (paramOperation.a == '-')
    {
      if (this.e == '=') {
        d();
      }
      this.a.a(paramOperation);
      this.f -= paramOperation.b;
    }
    else if (paramOperation.a == '+')
    {
      if (this.e == '=') {
        d();
      }
      this.b.a(paramOperation);
      this.f += paramOperation.b;
    }
    else if (paramOperation.a == '=')
    {
      if (this.e != '=') {
        e();
      }
      this.c.a(paramOperation);
    }
    this.e = paramOperation.a;
  }
  
  int b()
  {
    return this.f;
  }
  
  public void c()
  {
    this.a.c();
    this.b.c();
    this.c.c();
    StringBuilder localStringBuilder = this.d;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.f = 0;
  }
  
  @NonNull
  public String toString()
  {
    e();
    d();
    return this.d.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.SmartOpAssembler
 * JD-Core Version:    0.7.0.1
 */