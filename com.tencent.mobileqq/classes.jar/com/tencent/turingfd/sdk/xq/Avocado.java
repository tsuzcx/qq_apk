package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avocado
  extends else
{
  public static Map<Integer, String> a;
  public static List<String> b;
  public int c = 0;
  public Map<Integer, String> d = null;
  public List<String> e = null;
  
  static
  {
    Object localObject = new HashMap();
    a = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(0), "");
    localObject = new ArrayList();
    b = (List)localObject;
    ((List)localObject).add("");
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.c, 0);
    Object localObject = this.d;
    if (localObject != null) {
      paramcase.a((Map)localObject, 1);
    }
    localObject = this.e;
    if (localObject != null) {
      paramcase.a((Collection)localObject, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.c = paramtry.a(this.c, 0, true);
    this.d = ((Map)paramtry.a(a, 1, false));
    this.e = ((List)paramtry.a(b, 2, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Avocado)) {
      return false;
    }
    paramObject = (Avocado)paramObject;
    return (goto.a(this.c, paramObject.c)) && (this.d.equals(paramObject.d)) && (this.e.equals(paramObject.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Avocado
 * JD-Core Version:    0.7.0.1
 */