package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;

public final class Apricot
  extends else
{
  public static ArrayList<String> a;
  public static ArrayList<String> b;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public ArrayList<String> f = null;
  public ArrayList<String> g = null;
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
    int i = this.d;
    if (i != 0) {
      paramcase.a(i, 1);
    }
    i = this.e;
    if (i != 0) {
      paramcase.a(i, 2);
    }
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
    this.f = ((ArrayList)paramtry.a(a, 3, false));
    this.g = ((ArrayList)paramtry.a(b, 4, false));
    this.h = paramtry.b(5, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Apricot
 * JD-Core Version:    0.7.0.1
 */