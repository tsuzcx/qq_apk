package com.tencent.mobileqq.easysync2;

import com.tencent.util.Pair;
import java.util.List;

public class Changeset$Builder
{
  int a;
  SmartOpAssembler b = new SmartOpAssembler();
  Operation c = new Operation();
  StringBuilder d = new StringBuilder();
  
  public Changeset$Builder(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Builder a(int paramInt1, int paramInt2)
  {
    Operation localOperation = this.c;
    localOperation.a = '=';
    localOperation.d = "";
    localOperation.b = paramInt1;
    localOperation.c = Math.max(paramInt2, 0);
    this.b.a(this.c);
    return this;
  }
  
  public Builder a(String paramString, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    this.b.a('+', paramString, paramList, paramAttribPool);
    this.d.append(paramString);
    return this;
  }
  
  public Builder b(int paramInt1, int paramInt2)
  {
    Operation localOperation = this.c;
    localOperation.a = '-';
    localOperation.d = "";
    localOperation.b = paramInt1;
    localOperation.c = paramInt2;
    this.b.a(localOperation);
    return this;
  }
  
  public String toString()
  {
    this.b.a();
    int i = this.a;
    int j = this.b.b();
    return Changeset.a(this.a, i + j, this.b.toString(), this.d.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.Builder
 * JD-Core Version:    0.7.0.1
 */