package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ComaBerenices
  extends case
{
  public static Octans Ha = new Octans();
  public static String Ia = new String();
  public static byte[] Ja = new byte[1];
  public static List<String> Ka;
  public static List<String> La;
  public static List<String> Ma;
  public Octans Na = null;
  public String Oa = null;
  public String Pa = "";
  public String Qa = "";
  public int Ra = 0;
  public byte[] Sa = null;
  public List<String> Ta = null;
  public String Ua = "";
  public List<String> Va = null;
  public List<String> Wa = null;
  
  static
  {
    Ja[0] = 0;
    Ka = new ArrayList();
    String str = new String();
    Ka.add(str);
    La = new ArrayList();
    La.add("");
    Ma = new ArrayList();
    Ma.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.Na, 0);
    Object localObject = this.Oa;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    localObject = this.Pa;
    if (localObject != null) {
      parambyte.b((String)localObject, 2);
    }
    localObject = this.Qa;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    parambyte.a(this.Ra, 4);
    localObject = this.Sa;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    localObject = this.Ta;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 6);
    }
    localObject = this.Ua;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    localObject = this.Va;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 8);
    }
    localObject = this.Wa;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.Na = ((Octans)paramtry.a(Ha, 0, true));
    this.Oa = paramtry.a(Ia, 1, false);
    this.Pa = paramtry.a(2, false);
    this.Qa = paramtry.a(3, false);
    this.Ra = paramtry.a(this.Ra, 4, false);
    this.Sa = paramtry.a(Ja, 5, false);
    this.Ta = ((List)paramtry.a(Ka, 6, false));
    this.Ua = paramtry.a(7, false);
    this.Va = ((List)paramtry.a(La, 8, false));
    this.Wa = ((List)paramtry.a(Ma, 9, false));
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
      if (!(paramObject instanceof ComaBerenices)) {
        return false;
      }
      paramObject = (ComaBerenices)paramObject;
    } while ((char.equals(this.Na, paramObject.Na)) && (char.equals(this.Oa, paramObject.Oa)) && (char.equals(this.Pa, paramObject.Pa)) && (char.equals(this.Qa, paramObject.Qa)) && (char.equals(this.Ra, paramObject.Ra)) && (char.equals(this.Sa, paramObject.Sa)) && (char.equals(this.Ta, paramObject.Ta)) && (char.equals(this.Ua, paramObject.Ua)) && (char.equals(this.Va, paramObject.Va)) && (char.equals(this.Wa, paramObject.Wa)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.ComaBerenices
 * JD-Core Version:    0.7.0.1
 */