package com.tencent.mobileqq.together;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class TogetherObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
    case 1: 
    case 0: 
    case 3: 
      do
      {
        return;
        paramObject = (Object[])paramObject;
        a(paramBoolean, (TogetherSession)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
        paramObject = (Object[])paramObject;
        a((TogetherSession)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Long)paramObject[4]).longValue(), paramObject[5]);
        return;
      } while (!paramBoolean);
      a();
      return;
    }
    a(paramBoolean, (Bundle)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherObserver
 * JD-Core Version:    0.7.0.1
 */