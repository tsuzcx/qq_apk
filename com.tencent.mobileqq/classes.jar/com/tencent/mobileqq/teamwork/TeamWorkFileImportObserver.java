package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramBoolean = false;
    switch (paramInt)
    {
    default: 
    case 7: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 1)
        {
          c((TeamWorkFileImportInfo)paramObject[0]);
          return;
        }
      }
      break;
    case 6: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 3)
        {
          a((String)paramObject[0], (String)paramObject[1], (TeamWorkFileImportInfo)paramObject[2]);
          return;
        }
      }
      break;
    case 5: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 1)
        {
          if (((Integer)paramObject[0]).intValue() > 0) {
            paramBoolean = true;
          }
          a(paramBoolean);
          return;
        }
      }
      break;
    case 4: 
      if (paramObject != null)
      {
        b((TeamWorkFileImportInfo)paramObject);
        return;
      }
      break;
    case 3: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 1)
        {
          a(((Integer)paramObject[0]).intValue());
          return;
        }
      }
      break;
    case 2: 
      if (paramObject != null)
      {
        a((TeamWorkFileImportInfo)paramObject);
        return;
      }
      break;
    case 1: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2) {
          a((String)paramObject[0], (TeamWorkFileImportInfo)paramObject[1]);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver
 * JD-Core Version:    0.7.0.1
 */