package com.tencent.turingfd.sdk.xq;

public final class Bryony
  extends else
  implements Cloneable
{
  public int b = 0;
  public String c = "";
  
  public void a(case paramcase)
  {
    paramcase.a(this.b, 0);
    paramcase.a(this.c, 1);
  }
  
  public void a(try paramtry)
  {
    this.b = paramtry.a(this.b, 0, true);
    this.c = paramtry.b(1, true);
  }
  
  public void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int k = this.b;
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append('\t');
      i += 1;
    }
    paramStringBuilder.append("ret");
    paramStringBuilder.append(": ");
    paramStringBuilder.append(k);
    paramStringBuilder.append('\n');
    String str = this.c;
    i = j;
    while (i < paramInt)
    {
      paramStringBuilder.append('\t');
      i += 1;
    }
    paramStringBuilder.append("msgBlock");
    paramStringBuilder.append(": ");
    if (str == null)
    {
      paramStringBuilder.append("null");
      paramStringBuilder.append('\n');
      return;
    }
    paramStringBuilder.append(str);
    paramStringBuilder.append('\n');
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (a) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (Bryony)paramObject;
    boolean bool1 = bool2;
    if (goto.a(this.b, paramObject.b))
    {
      bool1 = bool2;
      if (this.c.equals(paramObject.c)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bryony
 * JD-Core Version:    0.7.0.1
 */