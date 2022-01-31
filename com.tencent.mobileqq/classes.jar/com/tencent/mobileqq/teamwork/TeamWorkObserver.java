package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class TeamWorkObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List paramList) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    } while (paramObject == null);
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkObserver
 * JD-Core Version:    0.7.0.1
 */