package com.tencent.mobileqq.troop.troopphoto.api;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopPhotoObserver
  implements BusinessObserver
{
  private static int a;
  public static final int c;
  
  static
  {
    int i = a;
    a = i + 1;
    c = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      boolean bool3 = ((Boolean)paramObject[2]).booleanValue();
      a((String)paramObject[3], paramBoolean, bool1, bool2, bool3);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopphoto.api.TroopPhotoObserver
 * JD-Core Version:    0.7.0.1
 */