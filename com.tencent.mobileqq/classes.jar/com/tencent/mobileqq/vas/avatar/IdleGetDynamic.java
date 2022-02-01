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
    }
    finally {}
    int j = localObject.size();
    int i = 0;
    while (i < j)
    {
      ((VasAvatarLoader)localObject.get(i)).a(true);
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleGetDynamic
 * JD-Core Version:    0.7.0.1
 */