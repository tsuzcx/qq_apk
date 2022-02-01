package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import java.util.List;

public class TroopAioNotifyObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  protected void a(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopAioNotifyObserver
 * JD-Core Version:    0.7.0.1
 */