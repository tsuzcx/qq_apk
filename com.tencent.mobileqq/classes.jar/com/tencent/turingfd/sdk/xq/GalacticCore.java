package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.List;

public class GalacticCore
  extends case
{
  public static List<Eridanus> Ca = new ArrayList();
  public List<Eridanus> Ga = null;
  public int R = 0;
  
  static
  {
    Eridanus localEridanus = new Eridanus();
    Ca.add(localEridanus);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    List localList = this.Ga;
    if (localList != null) {
      parambyte.a(localList, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.Ga = ((List)paramtry.a(Ca, 1, false));
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
      if (!(paramObject instanceof GalacticCore)) {
        return false;
      }
      paramObject = (GalacticCore)paramObject;
    } while ((char.equals(this.R, paramObject.R)) && (char.equals(this.Ga, paramObject.Ga)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.GalacticCore
 * JD-Core Version:    0.7.0.1
 */