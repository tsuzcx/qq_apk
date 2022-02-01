package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lynx
  extends case
{
  public static Map<Integer, String> ac = new HashMap();
  public static List<String> bc;
  public int cc = 0;
  public Map<Integer, String> dc = null;
  public List<String> ec = null;
  
  static
  {
    ac.put(Integer.valueOf(0), "");
    bc = new ArrayList();
    bc.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.cc, 0);
    Object localObject = this.dc;
    if (localObject != null) {
      parambyte.a((Map)localObject, 1);
    }
    localObject = this.ec;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 2);
    }
  }
  
  public void a(try paramtry)
  {
    this.cc = paramtry.a(this.cc, 0, true);
    this.dc = ((Map)paramtry.a(ac, 1, false));
    this.ec = ((List)paramtry.a(bc, 2, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Lynx)) {
        return false;
      }
      paramObject = (Lynx)paramObject;
    } while ((char.equals(this.cc, paramObject.cc)) && (char.equals(this.dc, paramObject.dc)) && (char.equals(this.ec, paramObject.ec)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lynx
 * JD-Core Version:    0.7.0.1
 */