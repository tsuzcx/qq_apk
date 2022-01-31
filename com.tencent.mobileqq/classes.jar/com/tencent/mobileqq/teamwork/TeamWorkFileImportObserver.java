package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;

public class TeamWorkFileImportObserver
  implements BusinessObserver
{
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
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
      } while (paramObject.length != 2);
      a((String)paramObject[0], (TeamWorkFileImportInfo)paramObject[1]);
      return;
    } while (paramObject == null);
    a((TeamWorkFileImportInfo)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver
 * JD-Core Version:    0.7.0.1
 */