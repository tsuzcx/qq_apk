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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          if (paramObject != null)
          {
            paramObject = (Object[])paramObject;
            if (paramObject.length == 1) {
              a(((Integer)paramObject[0]).intValue());
            }
          }
        }
        else if (paramObject != null)
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length == 2) {
            a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          }
        }
      }
      else if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 4) {
          a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
        }
      }
    }
    else if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        a((String)paramObject[0], (String)paramObject[1]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkExportObserver
 * JD-Core Version:    0.7.0.1
 */