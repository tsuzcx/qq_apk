package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.List;

public class Virgo
  extends else
{
  public static List<UrsaMajor> a;
  public int b = 0;
  public List<UrsaMajor> c = null;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new UrsaMajor());
  }
  
  public void a(case paramcase)
  {
    paramcase.a(this.b, 0);
    List localList = this.c;
    if (localList != null) {
      paramcase.a(localList, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.b = paramtry.a(this.b, 0, true);
    this.c = ((List)paramtry.a(a, 1, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Virgo)) {
      return false;
    }
    paramObject = (Virgo)paramObject;
    return (goto.a(this.b, paramObject.b)) && (this.c.equals(paramObject.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Virgo
 * JD-Core Version:    0.7.0.1
 */