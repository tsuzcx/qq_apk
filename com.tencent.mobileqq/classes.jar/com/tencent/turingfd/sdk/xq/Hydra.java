package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.List;

public class Hydra
  extends case
{
  public static List<Equuleus> Ba = new ArrayList();
  public List<Equuleus> Fa = null;
  public int R = 0;
  
  static
  {
    Equuleus localEquuleus = new Equuleus();
    Ba.add(localEquuleus);
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    List localList = this.Fa;
    if (localList != null) {
      parambyte.a(localList, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.Fa = ((List)paramtry.a(Ba, 1, false));
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
      if (!(paramObject instanceof Hydra)) {
        return false;
      }
      paramObject = (Hydra)paramObject;
    } while ((char.equals(this.R, paramObject.R)) && (char.equals(this.Fa, paramObject.Fa)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Hydra
 * JD-Core Version:    0.7.0.1
 */