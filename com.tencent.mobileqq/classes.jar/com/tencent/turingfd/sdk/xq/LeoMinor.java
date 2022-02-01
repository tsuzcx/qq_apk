package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;

public final class LeoMinor
  extends case
{
  public static ArrayList<String> Sb = new ArrayList();
  public static ArrayList<String> Tb;
  public int Ub = 0;
  public int Vb = 0;
  public int Wb = 0;
  public ArrayList<String> Xb = null;
  public ArrayList<String> Yb = null;
  public String Zb = "";
  
  static
  {
    Sb.add("");
    Tb = new ArrayList();
    Tb.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.Ub, 0);
    int i = this.Vb;
    if (i != 0) {
      parambyte.a(i, 1);
    }
    i = this.Wb;
    if (i != 0) {
      parambyte.a(i, 2);
    }
    Object localObject = this.Xb;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 3);
    }
    localObject = this.Yb;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 4);
    }
    localObject = this.Zb;
    if (localObject != null) {
      parambyte.b((String)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.Ub = paramtry.a(this.Ub, 0, false);
    this.Vb = paramtry.a(this.Vb, 1, false);
    this.Wb = paramtry.a(this.Wb, 2, false);
    this.Xb = ((ArrayList)paramtry.a(Sb, 3, false));
    this.Yb = ((ArrayList)paramtry.a(Tb, 4, false));
    this.Zb = paramtry.a(5, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.LeoMinor
 * JD-Core Version:    0.7.0.1
 */