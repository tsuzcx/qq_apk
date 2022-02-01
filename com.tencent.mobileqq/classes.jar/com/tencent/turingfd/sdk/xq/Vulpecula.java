package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vulpecula
  extends case
{
  public static Map<Integer, String> fc = new HashMap();
  public static List<String> gc;
  public int hc = 0;
  public Map<Integer, String> ic = null;
  public List<String> jc = null;
  
  static
  {
    fc.put(Integer.valueOf(0), "");
    gc = new ArrayList();
    gc.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.hc, 0);
    Object localObject = this.ic;
    if (localObject != null) {
      parambyte.a((Map)localObject, 1);
    }
    localObject = this.jc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.hc = paramtry.a(this.hc, 0, true);
    this.ic = ((Map)paramtry.a(fc, 1, false));
    this.jc = ((List)paramtry.a(gc, 2, false));
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
    return (char.equals(this.hc, paramObject.hc)) && (char.equals(this.ic, paramObject.ic)) && (char.equals(this.jc, paramObject.jc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Vulpecula
 * JD-Core Version:    0.7.0.1
 */