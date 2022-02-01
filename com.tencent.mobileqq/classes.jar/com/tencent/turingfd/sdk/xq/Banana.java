package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Banana
  extends else
{
  public static List<String> a;
  public static List<String> b;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public List<String> f = null;
  public List<String> g = null;
  public String h = "";
  
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
    paramcase.a(this.d, 1);
    paramcase.a(this.e, 2);
    Object localObject = this.f;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 3);
    }
    localObject = this.g;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 4);
    }
    localObject = this.h;
    if (localObject != null) {
      paramcase.a((String)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.c = paramtry.a(this.c, 0, false);
    this.d = paramtry.a(this.d, 1, false);
    this.e = paramtry.a(this.e, 2, false);
    this.f = ((List)paramtry.a(a, 3, false));
    this.g = ((List)paramtry.a(b, 4, false));
    this.h = paramtry.b(5, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Banana)) {
      return false;
    }
    paramObject = (Banana)paramObject;
    return (goto.a(this.c, paramObject.c)) && (goto.a(this.d, paramObject.d)) && (goto.a(this.e, paramObject.e)) && (this.f.equals(paramObject.f)) && (this.g.equals(paramObject.g)) && (this.h.equals(paramObject.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Banana
 * JD-Core Version:    0.7.0.1
 */