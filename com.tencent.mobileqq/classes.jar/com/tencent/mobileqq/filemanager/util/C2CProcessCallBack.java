package com.tencent.mobileqq.filemanager.util;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class C2CProcessCallBack
  implements IForwardCallBack
{
  QQAppInterface a;
  
  public C2CProcessCallBack(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public long a(FileManagerEntity paramFileManagerEntity, long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, String paramString3, long paramLong3)
  {
    a(paramFileManagerEntity, paramLong1, paramString1);
    paramString1 = this.a.getCurrentAccountUin();
    this.a.getFileManagerDataCenter().a(paramString2, paramString1, true, "", paramLong2, true, paramInt, paramString3, paramFileManagerEntity.msgSeq, paramLong3, paramFileManagerEntity.msgUid, -1L, MessageCache.a());
    this.a.getFileManagerDataCenter().a(paramFileManagerEntity);
    return paramFileManagerEntity.nSessionId;
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt3, long paramLong3, int paramInt4, String paramString5, TroopFileInfo paramTroopFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.fileName = paramString4;
    if ((paramTroopFileInfo != null) && (FileUtil.b(paramTroopFileInfo.l)))
    {
      paramString4 = new BitmapFactory.Options();
      paramString4.inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a(paramTroopFileInfo.l, paramString4);
      if ((paramString4.outHeight > 0) && (paramString4.outWidth > 0))
      {
        localFileManagerEntity.imgWidth = paramString4.outWidth;
        localFileManagerEntity.imgHeight = paramString4.outHeight;
      }
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "[" + localFileManagerEntity.nSessionId + "]entity forward from troop no size, get and use thumb size(wh)[" + localFileManagerEntity.imgWidth + ":" + localFileManagerEntity.imgHeight + "]");
      }
    }
    paramString4 = MessageRecordFactory.a(-1000);
    ForwardOrderManager.a().a(paramString4.uniseq, paramLong3, paramInt4);
    paramLong3 = paramString4.uniseq;
    localFileManagerEntity.uniseq = paramLong3;
    if (paramInt1 == 0)
    {
      localFileManagerEntity.nOpType = 24;
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + localFileManagerEntity.nSessionId + "],[troopToOffline]");
      }
    }
    do
    {
      for (;;)
      {
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.peerType = paramInt1;
        localFileManagerEntity.peerUin = paramString1;
        localFileManagerEntity.peerNick = FileManagerUtil.a(this.a, paramString1, null, paramInt1);
        localFileManagerEntity.selfUin = paramString2;
        localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
        localFileManagerEntity.setCloudType(4);
        localFileManagerEntity.status = 2;
        localFileManagerEntity.msgSeq = FileManagerUtil.a();
        localFileManagerEntity.msgUid = FileManagerUtil.b();
        localFileManagerEntity.fileSize = paramLong2;
        localFileManagerEntity.TroopUin = paramLong1;
        localFileManagerEntity.busId = paramInt2;
        localFileManagerEntity.strTroopFilePath = paramString3;
        if (paramTroopFileInfo != null)
        {
          localFileManagerEntity.strTroopFileID = paramTroopFileInfo.a.toString();
          localFileManagerEntity.lastTime = paramTroopFileInfo.c;
        }
        localFileManagerEntity.TroopUin = paramLong1;
        localFileManagerEntity.forwardTroopFileEntrance = paramInt3;
        return a(localFileManagerEntity, paramLong1, paramString3, paramString1, paramLong2, paramInt1, paramString5, paramLong3);
        if (paramInt1 != 3000) {
          break;
        }
        localFileManagerEntity.nOpType = 25;
        if (QLog.isColorLevel()) {
          QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + localFileManagerEntity.nSessionId + "],[troopToDisc]");
        }
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("群同事传递的peerType不对！");
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    paramString5 = TroopFileManager.a(this.a, Long.parseLong(paramString2));
    if (paramString5 != null) {
      paramString5.c(paramString3, paramString4, paramLong1, paramInt2);
    }
    String str = TransfileUtile.makeTransFileProtocolData("", 0L, 0, true);
    paramString5 = null;
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString2);
      l1 = l2;
      TroopFileInfo localTroopFileInfo = TroopFileManager.a(this.a, l2).a(paramString3);
      paramString5 = localTroopFileInfo;
      l1 = l2;
    }
    catch (Exception localException)
    {
      label82:
      break label82;
    }
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, l1, paramLong1, paramInt3, paramLong2, paramInt4, str, paramString5);
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    return null;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong, String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramLong);
    if (localTroopFileTransferManager != null)
    {
      paramString = localTroopFileTransferManager.a(paramString);
      if (paramString != null)
      {
        paramFileManagerEntity.yybApkPackageName = paramString.k;
        paramFileManagerEntity.yybApkName = paramString.l;
        paramFileManagerEntity.yybApkIconUrl = paramString.m;
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().b(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult,but entity is null SessionId[" + paramLong + "]");
      return;
    }
    label214:
    label232:
    String str;
    if (localFileManagerEntity.nOpType == 24)
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
      }
      if ((paramBoolean) && (TextUtils.isEmpty(paramString4) != true)) {
        break label444;
      }
      localFileManagerEntity.status = 0;
      if (TextUtils.isEmpty(paramString4) == true) {
        QLog.e("C2CProcessCallBack<FileAssistant>", 1, "!!!!!!!！！！new uuid is null!!!!!!!");
      }
      if (paramInt != 0)
      {
        if (TextUtils.isEmpty(paramString1)) {
          break label793;
        }
        FMToastUtil.c(paramString1);
        paramBoolean = false;
      }
      if (localFileManagerEntity.peerType != 0) {
        break label816;
      }
      paramString4 = this.a;
      str = localFileManagerEntity.forwardTroopFileEntrance + "";
      if (paramBoolean != true) {
        break label808;
      }
      paramString2 = "1";
      label283:
      ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_fri", 0, 0, paramString3, str, paramString2, localFileManagerEntity.peerUin);
      label315:
      paramString2 = this.a.getFileManagerNotifyCenter();
      if (localFileManagerEntity.status != 1) {
        break label908;
      }
    }
    label908:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString2.a(paramBoolean, 46, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Integer.valueOf(paramInt), paramString1 });
      return;
      if (localFileManagerEntity.nOpType == 25)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult operation Error![" + localFileManagerEntity.nOpType + "]");
      break;
      label444:
      localFileManagerEntity.status = 1;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.Uuid = paramString4;
      localFileManagerEntity.TroopUin = 0L;
      localFileManagerEntity.strTroopFileID = null;
      localFileManagerEntity.strTroopFilePath = null;
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "onResult bSuccess[true],peerType[" + localFileManagerEntity.peerType + "],peerUin[" + localFileManagerEntity.peerUin + "],uuid[" + localFileManagerEntity.Uuid + "]");
      }
      paramString2 = null;
      if (localFileManagerEntity.peerType == 3000)
      {
        this.a.getFileManagerNotifyCenter().a(localFileManagerEntity, 64, "");
        this.a.getFileTransferHandler().a(localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, this.a.getCurrentAccountUin(), localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramString4, localFileManagerEntity.uniseq, localFileManagerEntity.msgUid, null);
        if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0) {
          paramString2 = this.a.getFileManagerEngine().a(localFileManagerEntity, 5);
        }
      }
      for (;;)
      {
        if (paramString2 == null) {
          break label791;
        }
        localFileManagerEntity.strLargeThumPath = paramString2;
        break;
        if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
        {
          paramString2 = this.a.getFileManagerEngine().b(localFileManagerEntity);
          continue;
          this.a.getFileManagerNotifyCenter().a(localFileManagerEntity, 63, "");
          this.a.getFileTransferHandler().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0) {
            paramString2 = this.a.getFileManagerEngine().a(localFileManagerEntity, 5);
          } else if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2) {
            paramString2 = this.a.getFileManagerEngine().a(localFileManagerEntity);
          }
        }
      }
      label791:
      break label214;
      label793:
      FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131692607));
      break label232;
      label808:
      paramString2 = "2";
      break label283;
      label816:
      if (localFileManagerEntity.peerType != 3000) {
        break label315;
      }
      paramString4 = this.a;
      str = localFileManagerEntity.forwardTroopFileEntrance + "";
      if (paramBoolean == true) {}
      for (paramString2 = "1";; paramString2 = "2")
      {
        ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_talk", 0, 0, paramString3, str, paramString2, "");
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.C2CProcessCallBack
 * JD-Core Version:    0.7.0.1
 */