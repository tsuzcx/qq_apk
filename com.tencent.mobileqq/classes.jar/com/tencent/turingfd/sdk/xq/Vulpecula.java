package com.tencent.turingfd.sdk.xq;

public class Vulpecula
  extends else
{
  public static Apple a = new Apple();
  public static Almond b = new Almond();
  public static Virgo c = new Virgo();
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public Apple g = null;
  public Almond h = null;
  public Virgo i = null;
  
  public void a(case paramcase)
  {
    paramcase.a(this.d, 0);
    paramcase.a(this.e, 1);
    paramcase.a(this.f, 2);
    Object localObject = this.g;
    if (localObject != null) {
      paramcase.a((else)localObject, 3);
    }
    localObject = this.h;
    if (localObject != null) {
      paramcase.a((else)localObject, 4);
    }
    localObject = this.i;
    if (localObject != null) {
      paramcase.a((else)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.d = paramtry.a(this.d, 0, true);
    this.e = paramtry.a(this.e, 1, false);
    this.f = paramtry.a(this.f, 2, false);
    this.g = ((Apple)paramtry.a(a, 3, false));
    this.h = ((Almond)paramtry.a(b, 4, false));
    this.i = ((Virgo)paramtry.a(c, 5, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Vulpecula)) {
      return false;
    }
    paramObject = (Vulpecula)paramObject;
    return (goto.a(this.d, paramObject.d)) && (goto.a(this.e, paramObject.e)) && (goto.a(this.f, paramObject.f)) && (this.g.equals(paramObject.g)) && (this.h.equals(paramObject.h)) && (this.i.equals(paramObject.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Vulpecula
 * JD-Core Version:    0.7.0.1
 */