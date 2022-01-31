package com.tencent.mobileqq.util;

import com.tencent.mobileqq.data.DynamicAvatar;
import java.util.ArrayList;

public class IdleGetDynamic
  extends IdleUpdater
{
  private ArrayList a;
  
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
      ((DynamicFaceDrawable)localObject.get(i)).a((DynamicAvatar)localObject.get(i + 1));
      i += 2;
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, DynamicAvatar paramDynamicAvatar)
  {
    int i = 0;
    try
    {
      if (this.a == null)
      {
        i = 1;
        this.a = new ArrayList();
      }
      this.a.add(paramDynamicFaceDrawable);
      this.a.add(paramDynamicAvatar);
      if (i != 0) {
        b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.util.IdleGetDynamic
 * JD-Core Version:    0.7.0.1
 */