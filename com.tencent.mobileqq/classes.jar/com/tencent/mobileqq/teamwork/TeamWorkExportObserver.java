package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;

public class TeamWorkExportObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
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
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (paramObject == null);
                  paramObject = (Object[])paramObject;
                } while (paramObject.length != 2);
                a((String)paramObject[0], (String)paramObject[1]);
                return;
              } while (paramObject == null);
              paramObject = (Object[])paramObject;
            } while (paramObject.length != 4);
            a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
            return;
          } while (paramObject == null);
          paramObject = (Object[])paramObject;
        } while (paramObject.length != 2);
        a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    a(((Integer)paramObject[0]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkExportObserver
 * JD-Core Version:    0.7.0.1
 */