package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Perseus
  extends case
{
  public static Apricot Ma = new Apricot();
  public static String Na = new String();
  public static byte[] Oa = new byte[1];
  public static List<String> Pa;
  public static List<String> Qa;
  public static List<String> Ra;
  public Apricot Sa = null;
  public String Ta = null;
  public String Ua = "";
  public String Va = "";
  public int Wa = 0;
  public byte[] Xa = null;
  public List<String> Ya = null;
  public String Za = "";
  public List<String> _a = null;
  public List<String> ab = null;
  
  static
  {
    Oa[0] = 0;
    Pa = new ArrayList();
    String str = new String();
    Pa.add(str);
    Qa = new ArrayList();
    Qa.add("");
    Ra = new ArrayList();
    Ra.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.Sa, 0);
    Object localObject = this.Ta;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    localObject = this.Ua;
    if (localObject != null) {
      parambyte.b((String)localObject, 2);
    }
    localObject = this.Va;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    parambyte.b(this.Wa, 4);
    localObject = this.Xa;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    localObject = this.Ya;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 6);
    }
    localObject = this.Za;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    localObject = this._a;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 8);
    }
    localObject = this.ab;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.Sa = ((Apricot)paramtry.a(Ma, 0, true));
    this.Ta = paramtry.a(Na, 1, false);
    this.Ua = paramtry.a(2, false);
    this.Va = paramtry.a(3, false);
    this.Wa = paramtry.a(this.Wa, 4, false);
    this.Xa = paramtry.a(Oa, 5, false);
    this.Ya = ((List)paramtry.a(Pa, 6, false));
    this.Za = paramtry.a(7, false);
    this._a = ((List)paramtry.a(Qa, 8, false));
    this.ab = ((List)paramtry.a(Ra, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Perseus)) {
      return false;
    }
    paramObject = (Perseus)paramObject;
    return (char.equals(this.Sa, paramObject.Sa)) && (char.equals(this.Ta, paramObject.Ta)) && (char.equals(this.Ua, paramObject.Ua)) && (char.equals(this.Va, paramObject.Va)) && (char.equals(this.Wa, paramObject.Wa)) && (char.equals(this.Xa, paramObject.Xa)) && (char.equals(this.Ya, paramObject.Ya)) && (char.equals(this.Za, paramObject.Za)) && (char.equals(this._a, paramObject._a)) && (char.equals(this.ab, paramObject.ab));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Perseus
 * JD-Core Version:    0.7.0.1
 */