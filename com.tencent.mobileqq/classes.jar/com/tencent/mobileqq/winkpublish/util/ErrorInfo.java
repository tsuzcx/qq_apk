package com.tencent.mobileqq.winkpublish.util;

import java.util.ArrayList;

public class ErrorInfo
{
  public String a;
  public String b;
  public ArrayList<String> c;
  public ArrayList<String> d;
  private StringBuilder e = new StringBuilder(64);
  
  private ErrorInfo() {}
  
  private ErrorInfo(String paramString)
  {
    this.a = paramString;
  }
  
  public static ErrorInfo a(String paramString)
  {
    return new ErrorInfo(paramString);
  }
  
  public ErrorInfo a(String paramString, Object... paramVarArgs)
  {
    if (paramString == null)
    {
      this.b = paramString;
      return this;
    }
    this.b = String.format(paramString, paramVarArgs);
    return this;
  }
  
  public ErrorInfo b(String paramString)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramString);
    return this;
  }
  
  public ErrorInfo c(String paramString)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramString);
    return this;
  }
  
  public String toString()
  {
    Object localObject = this.e;
    int i = ((StringBuilder)localObject).length();
    int j = 0;
    ((StringBuilder)localObject).delete(0, i);
    localObject = this.e;
    ((StringBuilder)localObject).append(" TAG:");
    ((StringBuilder)localObject).append(this.a);
    if (this.b != null)
    {
      localObject = this.e;
      ((StringBuilder)localObject).append(" DESC:[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
    }
    localObject = this.c;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      this.e.append(" reasons:[");
      int k;
      for (i = 0; i < this.c.size(); i = k)
      {
        localObject = this.e;
        k = i + 1;
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append((String)this.c.get(i));
        ((StringBuilder)localObject).append("; ");
      }
      this.e.append("]\n\t");
    }
    localObject = this.d;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      this.e.append(" solves:[");
      for (i = j; i < this.d.size(); i = j)
      {
        localObject = this.e;
        j = i + 1;
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append((String)this.d.get(i));
        ((StringBuilder)localObject).append("; ");
      }
      this.e.append("]");
    }
    return this.e.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */