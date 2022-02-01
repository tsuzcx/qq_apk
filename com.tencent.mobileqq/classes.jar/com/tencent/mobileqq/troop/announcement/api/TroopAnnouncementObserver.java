package com.tencent.mobileqq.troop.announcement.api;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopAnnouncementObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  private static int c;
  
  static
  {
    int i = c;
    c = i + 1;
    a = i;
    i = c;
    c = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.TroopAnnouncementObserver
 * JD-Core Version:    0.7.0.1
 */