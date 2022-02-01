package com.tencent.turingfd.sdk.xq;

public class Serpens
  extends else
{
  public static Bergamot a = new Bergamot();
  public static Berry b = new Berry();
  public Bergamot c = null;
  public Berry d = null;
  public int e = 0;
  public String f = "";
  public String g = "";
  
  public void a(case paramcase)
  {
    Object localObject = this.c;
    if (localObject != null) {
      paramcase.a((else)localObject, 0);
    }
    localObject = this.d;
    if (localObject != null) {
      paramcase.a((else)localObject, 1);
    }
    paramcase.a(this.e, 2);
    localObject = this.f;
    if (localObject != null) {
      paramcase.a((String)localObject, 3);
    }
    localObject = this.g;
    if (localObject != null) {
      paramcase.a((String)localObject, 4);
    }
  }
  
  public void a(try paramtry)
  {
    this.c = ((Bergamot)paramtry.a(a, 0, false));
    this.d = ((Berry)paramtry.a(b, 1, false));
    this.e = paramtry.a(this.e, 2, false);
    this.f = paramtry.b(3, false);
    this.g = paramtry.b(4, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Serpens)) {
      return false;
    }
    paramObject = (Serpens)paramObject;
    Bergamot localBergamot1 = this.c;
    Bergamot localBergamot2 = paramObject.c;
    int i = goto.a;
    return (localBergamot1.equals(localBergamot2)) && (this.d.equals(paramObject.d)) && (goto.a(this.e, paramObject.e)) && (this.f.equals(paramObject.f)) && (this.g.equals(paramObject.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Serpens
 * JD-Core Version:    0.7.0.1
 */