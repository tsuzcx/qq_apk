package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class TroopCommonlyUsedObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = 0;
      if ((paramArrayOfObject[0] instanceof Integer)) {
        paramInt = ((Integer)paramArrayOfObject[0]).intValue();
      } else {
        paramInt = -1;
      }
      if ((paramArrayOfObject[1] instanceof Integer)) {
        i = ((Integer)paramArrayOfObject[1]).intValue();
      }
      paramBoolean = paramArrayOfObject[2] instanceof Map;
      String str = null;
      Map localMap;
      if (paramBoolean) {
        localMap = (Map)paramArrayOfObject[2];
      } else {
        localMap = null;
      }
      if ((paramArrayOfObject[3] instanceof String)) {
        str = (String)paramArrayOfObject[3];
      }
      a(paramInt, i, localMap, str);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCommonlyUsedObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != b) {
      return;
    }
    if (paramArrayOfObject != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramArrayOfObject.length == 5)
      {
        localObject1 = localObject2;
        if (paramArrayOfObject[4] != null) {
          localObject1 = (String)paramArrayOfObject[4];
        }
      }
      a((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)localObject1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      paramObject = (Object[])paramObject;
    } else {
      paramObject = null;
    }
    b(paramInt, paramBoolean, paramObject);
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver
 * JD-Core Version:    0.7.0.1
 */