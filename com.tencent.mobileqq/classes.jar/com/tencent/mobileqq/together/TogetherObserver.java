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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          a(paramBoolean, (Bundle)paramObject);
          return;
        }
        if (paramBoolean) {
          a();
        }
      }
      else
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (TogetherSession)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      }
    }
    else
    {
      paramObject = (Object[])paramObject;
      a((TogetherSession)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Long)paramObject[4]).longValue(), paramObject[5]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherObserver
 * JD-Core Version:    0.7.0.1
 */