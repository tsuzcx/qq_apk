package com.tencent.turingfd.sdk.xq;

public class UrsaMajor
  extends else
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public String f = "";
  public int g = 0;
  public String h = "";
  
  public void a(case paramcase)
  {
    paramcase.a(this.a, 0);
    paramcase.a(this.b, 1);
    paramcase.a(this.c, 2);
    paramcase.a(this.d, 3);
    String str = this.e;
    if (str != null) {
      paramcase.a(str, 4);
    }
    str = this.f;
    if (str != null) {
      paramcase.a(str, 5);
    }
    paramcase.a(this.g, 6);
    str = this.h;
    if (str != null) {
      paramcase.a(str, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.a = paramtry.a(this.a, 0, true);
    this.b = paramtry.a(this.b, 1, false);
    this.c = paramtry.a(this.c, 2, false);
    this.d = paramtry.a(this.d, 3, false);
    this.e = paramtry.b(4, false);
    this.f = paramtry.b(5, false);
    this.g = paramtry.a(this.g, 6, false);
    this.h = paramtry.b(7, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof UrsaMajor)) {
      return false;
    }
    paramObject = (UrsaMajor)paramObject;
    return (goto.a(this.a, paramObject.a)) && (goto.a(this.b, paramObject.b)) && (goto.a(this.c, paramObject.c)) && (goto.a(this.d, paramObject.d)) && (this.e.equals(paramObject.e)) && (this.f.equals(paramObject.f)) && (goto.a(this.g, paramObject.g)) && (this.h.equals(paramObject.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMajor
 * JD-Core Version:    0.7.0.1
 */