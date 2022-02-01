package com.tencent.mobileqq.vas.avatar;

import bibk;
import java.util.ArrayList;

public class IdleGetDynamic
  extends IdleUpdater
{
  private ArrayList<bibk> a;
  
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
      ((bibk)localObject.get(i)).a(true);
      i += 1;
    }
  }
  
  public void a(bibk parambibk)
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(parambibk);
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