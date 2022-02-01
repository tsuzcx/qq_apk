package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dorado
  extends case
{
  public static List<String> La = new ArrayList();
  public static List<String> Ma;
  public String Ua = "";
  public List<String> Va = null;
  public List<String> Wa = null;
  public int eb = 0;
  public String ib = "";
  public int type = 0;
  
  static
  {
    La.add("");
    Ma = new ArrayList();
    Ma.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.eb, 0);
    Object localObject = this.ib;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    parambyte.a(this.type, 2);
    localObject = this.Ua;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    localObject = this.Va;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    localObject = this.Wa;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.eb = paramtry.a(this.eb, 0, true);
    this.ib = paramtry.a(1, false);
    this.type = paramtry.a(this.type, 2, false);
    this.Ua = paramtry.a(3, false);
    this.Va = ((List)paramtry.a(La, 4, false));
    this.Wa = ((List)paramtry.a(Ma, 5, false));
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
      if (!(paramObject instanceof Dorado)) {
        return false;
      }
      paramObject = (Dorado)paramObject;
    } while ((char.equals(this.eb, paramObject.eb)) && (char.equals(this.ib, paramObject.ib)) && (char.equals(this.type, paramObject.type)) && (char.equals(this.Ua, paramObject.Ua)) && (char.equals(this.Va, paramObject.Va)) && (char.equals(this.Wa, paramObject.Wa)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Dorado
 * JD-Core Version:    0.7.0.1
 */