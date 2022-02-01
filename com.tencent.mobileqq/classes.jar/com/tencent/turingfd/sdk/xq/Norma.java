package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Norma
  extends case
{
  public static List<String> Sb = new ArrayList();
  public static List<String> Tb;
  public int Vb = 0;
  public int Wb = 0;
  public List<String> Xb = null;
  public List<String> Yb = null;
  public String Zb = "";
  public int type = 0;
  
  static
  {
    Sb.add("");
    Tb = new ArrayList();
    Tb.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.type, 0);
    parambyte.a(this.Vb, 1);
    parambyte.a(this.Wb, 2);
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
    this.type = paramtry.a(this.type, 0, false);
    this.Vb = paramtry.a(this.Vb, 1, false);
    this.Wb = paramtry.a(this.Wb, 2, false);
    this.Xb = ((List)paramtry.a(Sb, 3, false));
    this.Yb = ((List)paramtry.a(Tb, 4, false));
    this.Zb = paramtry.a(5, false);
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
      if (!(paramObject instanceof Norma)) {
        return false;
      }
      paramObject = (Norma)paramObject;
    } while ((char.equals(this.type, paramObject.type)) && (char.equals(this.Vb, paramObject.Vb)) && (char.equals(this.Wb, paramObject.Wb)) && (char.equals(this.Xb, paramObject.Xb)) && (char.equals(this.Yb, paramObject.Yb)) && (char.equals(this.Zb, paramObject.Zb)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Norma
 * JD-Core Version:    0.7.0.1
 */