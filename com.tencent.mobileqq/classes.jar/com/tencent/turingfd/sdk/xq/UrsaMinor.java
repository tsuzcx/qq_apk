package com.tencent.turingfd.sdk.xq;

public class UrsaMinor
  extends else
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e = 0;
  public String f = "";
  
  public void a(case paramcase)
  {
    paramcase.a(this.a, 0);
    paramcase.a(this.b, 1);
    String str = this.c;
    if (str != null) {
      paramcase.a(str, 2);
    }
    str = this.d;
    if (str != null) {
      paramcase.a(str, 3);
    }
    paramcase.a(this.e, 4);
    str = this.f;
    if (str != null) {
      paramcase.a(str, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.a = paramtry.a(this.a, 0, true);
    this.b = paramtry.a(this.b, 1, false);
    this.c = paramtry.b(2, false);
    this.d = paramtry.b(3, false);
    this.e = paramtry.a(this.e, 4, false);
    this.f = paramtry.b(5, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof UrsaMinor)) {
      return false;
    }
    paramObject = (UrsaMinor)paramObject;
    return (goto.a(this.a, paramObject.a)) && (goto.a(this.b, paramObject.b)) && (this.c.equals(paramObject.c)) && (this.d.equals(paramObject.d)) && (goto.a(this.e, paramObject.e)) && (this.f.equals(paramObject.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMinor
 * JD-Core Version:    0.7.0.1
 */