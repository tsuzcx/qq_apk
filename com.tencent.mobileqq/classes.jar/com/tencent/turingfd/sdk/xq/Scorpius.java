package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scorpius
  extends else
{
  public static Serpens a = new Serpens();
  public static List<Sculptor> b = new ArrayList();
  public static List<Taurus> c;
  public static List<Solar> d;
  public Serpens e = null;
  public List<Sculptor> f = null;
  public List<Taurus> g = null;
  public List<Solar> h = null;
  
  static
  {
    Object localObject = new Sculptor();
    b.add(localObject);
    c = new ArrayList();
    localObject = new Taurus();
    c.add(localObject);
    d = new ArrayList();
    localObject = new Solar();
    d.add(localObject);
  }
  
  public void a(case paramcase)
  {
    Object localObject = this.e;
    if (localObject != null) {
      paramcase.a((else)localObject, 0);
    }
    localObject = this.f;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 1);
    }
    localObject = this.g;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 2);
    }
    localObject = this.h;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 3);
    }
  }
  
  public void a(try paramtry)
  {
    this.e = ((Serpens)paramtry.a(a, 0, false));
    this.f = ((List)paramtry.a(b, 1, false));
    this.g = ((List)paramtry.a(c, 2, false));
    this.h = ((List)paramtry.a(d, 3, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Scorpius)) {
      return false;
    }
    paramObject = (Scorpius)paramObject;
    Serpens localSerpens1 = this.e;
    Serpens localSerpens2 = paramObject.e;
    int i = goto.a;
    return (localSerpens1.equals(localSerpens2)) && (this.f.equals(paramObject.f)) && (this.g.equals(paramObject.g)) && (this.h.equals(paramObject.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Scorpius
 * JD-Core Version:    0.7.0.1
 */