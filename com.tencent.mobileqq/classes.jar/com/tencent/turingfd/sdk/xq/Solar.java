package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.List;

public class Solar
  extends case
{
  public static List<Sculptor> Ha = new ArrayList();
  public List<Sculptor> La = null;
  public int ba = 0;
  
  static
  {
    Sculptor localSculptor = new Sculptor();
    Ha.add(localSculptor);
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    List localList = this.La;
    if (localList != null) {
      parambyte.a(localList, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.La = ((List)paramtry.a(Ha, 1, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Solar)) {
      return false;
    }
    paramObject = (Solar)paramObject;
    return (char.equals(this.ba, paramObject.ba)) && (char.equals(this.La, paramObject.La));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Solar
 * JD-Core Version:    0.7.0.1
 */