package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Apple
  extends case
{
  public static List<String> Xb = new ArrayList();
  public static List<String> Yb;
  public int _b = 0;
  public int ac = 0;
  public List<String> bc = null;
  public List<String> cc = null;
  public String dc = "";
  public int type = 0;
  
  static
  {
    Xb.add("");
    Yb = new ArrayList();
    Yb.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.type, 0);
    parambyte.b(this._b, 1);
    parambyte.b(this.ac, 2);
    Object localObject = this.bc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 3);
    }
    localObject = this.cc;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    localObject = this.dc;
    if (localObject != null) {
      parambyte.b((String)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.type = paramtry.a(this.type, 0, false);
    this._b = paramtry.a(this._b, 1, false);
    this.ac = paramtry.a(this.ac, 2, false);
    this.bc = ((List)paramtry.a(Xb, 3, false));
    this.cc = ((List)paramtry.a(Yb, 4, false));
    this.dc = paramtry.a(5, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Apple)) {
      return false;
    }
    paramObject = (Apple)paramObject;
    return (char.equals(this.type, paramObject.type)) && (char.equals(this._b, paramObject._b)) && (char.equals(this.ac, paramObject.ac)) && (char.equals(this.bc, paramObject.bc)) && (char.equals(this.cc, paramObject.cc)) && (char.equals(this.dc, paramObject.dc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Apple
 * JD-Core Version:    0.7.0.1
 */