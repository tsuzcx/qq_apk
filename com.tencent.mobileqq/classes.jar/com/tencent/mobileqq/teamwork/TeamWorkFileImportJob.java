package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportJob;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class TeamWorkFileImportJob
  implements ITeamWorkFileImportJob
{
  public TeamWorkFileImportInfo b;
  protected ITeamWorkFileImportHandler c;
  
  public TeamWorkFileImportJob(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    this.b = paramTeamWorkFileImportInfo;
    if (paramAppInterface != null) {
      this.c = ((ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName()));
    }
  }
  
  public void a(AppInterface paramAppInterface) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (FileUtils.fileExistsAndNotEmpty(this.b.d)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("---notifyUIFailed try local fileName: ");
        ((StringBuilder)localObject).append(this.b.c);
        QLog.i("TeamWorkFileImportJob", 2, ((StringBuilder)localObject).toString());
      }
      this.c.removeFileImporting(this.b);
      Object localObject = this.b;
      ((TeamWorkFileImportInfo)localObject).m = false;
      this.c.addToFileImportingMap((TeamWorkFileImportInfo)localObject);
      this.c.fileImportFromLocalFile(this.b);
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      this.c.notifyUIError(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJob
 * JD-Core Version:    0.7.0.1
 */