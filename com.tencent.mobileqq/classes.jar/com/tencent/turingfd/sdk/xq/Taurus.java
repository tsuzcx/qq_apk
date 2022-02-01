package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Taurus
  extends else
{
  public static List<String> a;
  public static List<String> b;
  public int c = 0;
  public String d = "";
  public int e = 0;
  public String f = "";
  public List<String> g = null;
  public List<String> h = null;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add("");
    localArrayList = new ArrayList();
    b = localArrayList;
    localArrayList.add("");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.c, 0);
    Object localObject = this.d;
    if (localObject != null) {
      paramcase.a((String)localObject, 1);
    }
    paramcase.a(this.e, 2);
    localObject = this.f;
    if (localObject != null) {
      paramcase.a((String)localObject, 3);
    }
    localObject = this.g;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 4);
    }
    localObject = this.h;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.c = paramtry.a(this.c, 0, true);
    this.d = paramtry.b(1, false);
    this.e = paramtry.a(this.e, 2, false);
    this.f = paramtry.b(3, false);
    this.g = ((List)paramtry.a(a, 4, false));
    this.h = ((List)paramtry.a(b, 5, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Taurus)) {
      return false;
    }
    paramObject = (Taurus)paramObject;
    return (goto.a(this.c, paramObject.c)) && (this.d.equals(paramObject.d)) && (goto.a(this.e, paramObject.e)) && (this.f.equals(paramObject.f)) && (this.g.equals(paramObject.g)) && (this.h.equals(paramObject.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Taurus
 * JD-Core Version:    0.7.0.1
 */