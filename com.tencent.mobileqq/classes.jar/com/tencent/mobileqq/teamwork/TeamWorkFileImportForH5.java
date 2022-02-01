package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportForH5
  extends TeamWorkFileImportJob
{
  FileManagerEntity a;
  private FileTransferObserver d = new TeamWorkFileImportForH5.1(this);
  
  public TeamWorkFileImportForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.b != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if ((this.b.m) && (!TextUtils.isEmpty(this.b.b)))
      {
        Object localObject = paramAppInterface.getMessageFacade().b(this.b.b, this.b.a, this.b.e);
        if ((localObject != null) && ((localObject instanceof MessageForFile))) {
          this.a = FileManagerUtil.a(paramAppInterface, (MessageForFile)localObject);
        } else {
          this.a = paramAppInterface.getFileManagerDataCenter().b(this.b.f);
        }
        localObject = this.a;
        if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)))
        {
          i = 1;
          paramAppInterface.getFileTransferHandler().a(this.a.Uuid, this.a.fileIdCrc, this.a.bSend, false, this.d);
          break label174;
        }
      }
      int i = 0;
      label174:
      if (i == 0)
      {
        this.b.m = false;
        this.c.fileImportFromLocalFileForH5(this.b);
      }
      this.c.addToFileImportingMap(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportForH5
 * JD-Core Version:    0.7.0.1
 */