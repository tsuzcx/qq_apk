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
import org.json.JSONObject;

public class TeamWorkFileImportJobForDisc
  extends TeamWorkFileImportJob
{
  FileManagerEntity a;
  private FileTransferObserver d = new TeamWorkFileImportJobForDisc.1(this);
  
  public TeamWorkFileImportJobForDisc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return TextUtils.isEmpty(paramJSONObject.optString("discussuin")) ^ true;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.b != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if ((this.b.m) && (this.b.a == 3000) && (!TextUtils.isEmpty(this.b.b)))
      {
        Object localObject = paramAppInterface.getMessageFacade().b(this.b.b, this.b.a, this.b.e);
        if ((localObject != null) && ((localObject instanceof MessageForFile))) {
          this.a = FileManagerUtil.a(paramAppInterface, (MessageForFile)localObject);
        }
        if (this.a == null) {
          this.a = paramAppInterface.getFileManagerDataCenter().a(this.b.e, this.b.b, this.b.a);
        }
        localObject = this.a;
        if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (!TextUtils.isEmpty(this.a.peerUin)))
        {
          i = 1;
          paramAppInterface.getFileTransferHandler().a(this.a.nSessionId, this.a.fileName, Long.parseLong(this.a.peerUin), this.a.Uuid, this.d);
          break label227;
        }
      }
      int i = 0;
      label227:
      if (i == 0)
      {
        this.b.m = false;
        this.c.fileImportFromLocalFile(this.b);
      }
      this.c.addToFileImportingMap(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDisc
 * JD-Core Version:    0.7.0.1
 */