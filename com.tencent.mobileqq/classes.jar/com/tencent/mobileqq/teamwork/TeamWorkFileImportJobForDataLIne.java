package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportJobForDataLIne
  extends TeamWorkFileImportJob
{
  public TeamWorkFileImportJobForDataLIne(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.b != null) && (paramAppInterface != null))
    {
      this.c.addToFileImportingMap(this.b);
      this.c.fileImportFromLocalFileForDataLine(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDataLIne
 * JD-Core Version:    0.7.0.1
 */