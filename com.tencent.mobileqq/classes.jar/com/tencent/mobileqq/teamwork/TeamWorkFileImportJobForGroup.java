package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class TeamWorkFileImportJobForGroup
  extends TeamWorkFileImportJob
{
  FileManagerEntity a;
  private TroopFileReqDownloadFileObserver d = new TeamWorkFileImportJobForGroup.1(this);
  
  public TeamWorkFileImportJobForGroup(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private FileManagerEntity a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return null;
      }
      paramQQAppInterface = paramQQAppInterface.getFileManagerProxy();
      Object localObject = paramQQAppInterface.c();
      if (localObject == null) {
        paramQQAppInterface.init();
      }
      if (localObject == null) {
        return null;
      }
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (FileManagerEntity)paramQQAppInterface.next();
        if ((((FileManagerEntity)localObject).peerUin != null) && (TextUtils.equals(paramString1, ((FileManagerEntity)localObject).strTroopFileID)) && (((FileManagerEntity)localObject).peerUin.equals(paramString2)))
        {
          if ((((FileManagerEntity)localObject).cloudType == 1) && (FileManagerUtil.d((FileManagerEntity)localObject))) {
            ((FileManagerEntity)localObject).status = 16;
          }
          return localObject;
        }
      }
    }
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramJSONObject.optString("groupuin")))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramJSONObject.optString("businesstype"))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.b != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      boolean bool = this.b.m;
      int j = 1;
      int i;
      if ((bool) && (this.b.a == 1) && (!TextUtils.isEmpty(this.b.g)) && (this.b.h != 0) && (!TextUtils.isEmpty(this.b.b)))
      {
        Object localObject = new TroopFileInfo();
        ((TroopFileInfo)localObject).b = UUID.nameUUIDFromBytes(this.b.g.getBytes());
        ((TroopFileInfo)localObject).c = this.b.g;
        ((TroopFileInfo)localObject).d = this.b.c;
        ((TroopFileInfo)localObject).f = this.b.h;
        localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
        ((TroopFileTransferManager.Item)localObject).FileName = this.b.c;
        TroopFileProtocol.a(paramAppInterface, Long.valueOf(this.b.b).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, false, this.d);
        localObject = paramAppInterface.getMessageFacade().b(this.b.b, this.b.a, this.b.e);
        if (localObject != null)
        {
          this.a = paramAppInterface.getFileManagerDataCenter().b(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          if (this.a == null) {
            this.a = paramAppInterface.getFileManagerDataCenter().a(this.b.f);
          }
          FileManagerEntity localFileManagerEntity = this.a;
          if ((localFileManagerEntity != null) && (TextUtils.isEmpty(localFileManagerEntity.strFileMd5))) {
            this.a = a(paramAppInterface, this.a.strTroopFileID, ((MessageRecord)localObject).frienduin);
          }
          localFileManagerEntity = this.a;
          if (localFileManagerEntity != null)
          {
            i = j;
            if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {}
          }
          else
          {
            this.a = paramAppInterface.getFileManagerDataCenter().a(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, this.b.a, this.b.f);
            i = j;
          }
        }
        else
        {
          QLog.w("TeamWorkFileImportJobForGroup", 2, "can not find message");
          i = j;
        }
      }
      else
      {
        i = 0;
      }
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
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForGroup
 * JD-Core Version:    0.7.0.1
 */