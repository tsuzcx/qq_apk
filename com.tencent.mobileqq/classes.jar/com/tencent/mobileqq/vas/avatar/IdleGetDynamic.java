package com.tencent.mobileqq.vas.avatar;

import java.util.ArrayList;

public class IdleGetDynamic
  extends IdleUpdater
{
  private ArrayList<VasAvatarLoader> a;
  
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
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        ((VasAvatarLoader)localArrayList.get(i)).a(true);
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(VasAvatarLoader paramVasAvatarLoader)
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(paramVasAvatarLoader);
      if (this.a.size() == 1) {
        b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleGetDynamic
 * JD-Core Version:    0.7.0.1
 */