package com.tencent.mobileqq.vas.avatar;

import bhqp;
import java.util.ArrayList;

public class IdleGetDynamic
  extends IdleUpdater
{
  private ArrayList<bhqp> a;
  
  public IdleGetDynamic()
  {
    super(32);
  }
  
  public void a()
  {
    try
    {
      ArrayList localArrayList = this.a;
      this.a = null;
      if (localArrayList == null) {
        return;
      }
    }
    finally {}
    int j = localObject.size();
    int i = 0;
    while (i < j)
    {
      ((bhqp)localObject.get(i)).a(true);
      i += 1;
    }
  }
  
  public void a(bhqp parambhqp)
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(parambhqp);
      if (this.a.size() == 1) {
        b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleGetDynamic
 * JD-Core Version:    0.7.0.1
 */