package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;

public final class UrsaMinor
  extends case
{
  public static ArrayList<String> Xb = new ArrayList();
  public static ArrayList<String> Yb;
  public int Zb = 0;
  public int _b = 0;
  public int ac = 0;
  public ArrayList<String> bc = null;
  public ArrayList<String> cc = null;
  public String dc = "";
  
  static
  {
    Xb.add("");
    Yb = new ArrayList();
    Yb.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.Zb, 0);
    int i = this._b;
    if (i != 0) {
      parambyte.b(i, 1);
    }
    i = this.ac;
    if (i != 0) {
      parambyte.b(i, 2);
    }
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
    this.Zb = paramtry.a(this.Zb, 0, false);
    this._b = paramtry.a(this._b, 1, false);
    this.ac = paramtry.a(this.ac, 2, false);
    this.bc = ((ArrayList)paramtry.a(Xb, 3, false));
    this.cc = ((ArrayList)paramtry.a(Yb, 4, false));
    this.dc = paramtry.a(5, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMinor
 * JD-Core Version:    0.7.0.1
 */