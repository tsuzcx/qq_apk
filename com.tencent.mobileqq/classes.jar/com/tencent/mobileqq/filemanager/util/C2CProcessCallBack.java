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
import mqq.app.AppRuntime;

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
    if ((paramTroopFileInfo != null) && (FileUtil.a(paramTroopFileInfo.l)))
    {
      paramString4 = new BitmapFactory.Options();
      paramString4.inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a(paramTroopFileInfo.l, paramString4);
      if ((paramString4.outHeight > 0) && (paramString4.outWidth > 0))
      {
        localFileManagerEntity.imgWidth = paramString4.outWidth;
        localFileManagerEntity.imgHeight = paramString4.outHeight;
      }
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder();
        paramString4.append("[");
        paramString4.append(localFileManagerEntity.nSessionId);
        paramString4.append("]entity forward from troop no size, get and use thumb size(wh)[");
        paramString4.append(localFileManagerEntity.imgWidth);
        paramString4.append(":");
        paramString4.append(localFileManagerEntity.imgHeight);
        paramString4.append("]");
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, paramString4.toString());
      }
    }
    paramString4 = MessageRecordFactory.a(-1000);
    ForwardOrderManager.a().a(paramString4.uniseq, paramLong3, paramInt4);
    paramLong3 = paramString4.uniseq;
    localFileManagerEntity.uniseq = paramLong3;
    if (paramInt1 == 0)
    {
      localFileManagerEntity.nOpType = 24;
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder();
        paramString4.append("getC2CProcessCallBack->prepareForward nSessionId[");
        paramString4.append(localFileManagerEntity.nSessionId);
        paramString4.append("],[troopToOffline]");
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, paramString4.toString());
      }
    }
    else if (paramInt1 == 3000)
    {
      localFileManagerEntity.nOpType = 25;
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder();
        paramString4.append("getC2CProcessCallBack->prepareForward nSessionId[");
        paramString4.append(localFileManagerEntity.nSessionId);
        paramString4.append("],[troopToDisc]");
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, paramString4.toString());
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        break label551;
      }
    }
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
    label551:
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
    l1 = 0L;
    String str = TransfileUtile.makeTransFileProtocolData("", 0L, 0, true);
    paramString5 = null;
    try
    {
      l2 = Long.parseLong(paramString2);
      l1 = l2;
      localObject = TroopFileManager.a(this.a, l2);
    }
    catch (Exception localException1)
    {
      Object localObject;
      label89:
      break label89;
    }
    try
    {
      localObject = ((TroopFileManager)localObject).a(paramString3);
      paramString5 = (String)localObject;
      l1 = l2;
    }
    catch (Exception localException2)
    {
      l1 = l2;
      break label89;
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
    Object localObject2 = this;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getC2CProcessCallBack->onResult bSuccess[");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("],nSessionId[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("],retCode[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("],retMsg[");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("],uuid[");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("],troopUin[");
      ((StringBuilder)localObject1).append(paramString3);
      ((StringBuilder)localObject1).append("],strNewPath[");
      ((StringBuilder)localObject1).append(paramString4);
      ((StringBuilder)localObject1).append("]");
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((C2CProcessCallBack)localObject2).a.getFileManagerDataCenter().b(paramLong);
    if (localObject1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("getC2CProcessCallBack->onResult,but entity is null SessionId[");
      paramString1.append(paramLong);
      paramString1.append("]");
      QLog.e("C2CProcessCallBack<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (((FileManagerEntity)localObject1).nOpType == 24)
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
      }
    }
    else if (((FileManagerEntity)localObject1).nOpType == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getC2CProcessCallBack->onResult operation Error![");
      paramString2.append(((FileManagerEntity)localObject1).nOpType);
      paramString2.append("]");
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, paramString2.toString());
    }
    Object localObject3;
    if ((paramBoolean) && (TextUtils.isEmpty(paramString4) != true))
    {
      ((FileManagerEntity)localObject1).status = 1;
      ((FileManagerEntity)localObject1).setCloudType(1);
      ((FileManagerEntity)localObject1).Uuid = paramString4;
      ((FileManagerEntity)localObject1).TroopUin = 0L;
      ((FileManagerEntity)localObject1).strTroopFileID = null;
      ((FileManagerEntity)localObject1).strTroopFilePath = null;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onResult bSuccess[true],peerType[");
        paramString2.append(((FileManagerEntity)localObject1).peerType);
        paramString2.append("],peerUin[");
        paramString2.append(((FileManagerEntity)localObject1).peerUin);
        paramString2.append("],uuid[");
        paramString2.append(((FileManagerEntity)localObject1).Uuid);
        paramString2.append("]");
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, paramString2.toString());
      }
      if (((FileManagerEntity)localObject1).peerType == 3000)
      {
        ((C2CProcessCallBack)localObject2).a.getFileManagerNotifyCenter().a((FileManagerEntity)localObject1, 64, "");
        localObject3 = ((C2CProcessCallBack)localObject2).a.getFileTransferHandler();
        paramLong = ((FileManagerEntity)localObject1).nSessionId;
        String str1 = ((FileManagerEntity)localObject1).peerUin;
        localObject2 = ((C2CProcessCallBack)localObject2).a.getCurrentAccountUin();
        String str2 = ((FileManagerEntity)localObject1).fileName;
        long l1 = ((FileManagerEntity)localObject1).fileSize;
        long l2 = ((FileManagerEntity)localObject1).uniseq;
        long l3 = ((FileManagerEntity)localObject1).msgUid;
        paramString2 = (String)localObject1;
        ((FileTransferHandler)localObject3).a(paramLong, str1, (String)localObject2, str2, l1, paramString4, l2, l3, null);
        if (FileManagerUtil.a(paramString2.fileName) == 0)
        {
          paramString2 = this.a.getFileManagerEngine().a(paramString2, 5);
          break label757;
        }
        if (FileManagerUtil.a(paramString2.fileName) == 2)
        {
          paramString2 = this.a.getFileManagerEngine().b(paramString2);
          break label757;
        }
      }
      else
      {
        paramString2 = (String)localObject1;
        ((C2CProcessCallBack)localObject2).a.getFileManagerNotifyCenter().a(paramString2, 63, "");
        ((C2CProcessCallBack)localObject2).a.getFileTransferHandler().a(paramString2.peerUin, paramString2, null);
        if (FileManagerUtil.a(paramString2.fileName) == 0)
        {
          paramString2 = ((C2CProcessCallBack)localObject2).a.getFileManagerEngine().a(paramString2, 5);
          break label757;
        }
        if (FileManagerUtil.a(paramString2.fileName) == 2)
        {
          paramString2 = ((C2CProcessCallBack)localObject2).a.getFileManagerEngine().a(paramString2);
          break label757;
        }
      }
      paramString2 = null;
      label757:
      if (paramString2 != null) {
        ((FileManagerEntity)localObject1).strLargeThumPath = paramString2;
      }
    }
    else
    {
      ((FileManagerEntity)localObject1).status = 0;
      if (TextUtils.isEmpty(paramString4) == true) {
        QLog.e("C2CProcessCallBack<FileAssistant>", 1, "!!!!!!!！！！new uuid is null!!!!!!!");
      }
    }
    paramString4 = this;
    if (paramInt != 0)
    {
      if (!TextUtils.isEmpty(paramString1)) {
        FMToastUtil.c(paramString1);
      } else {
        FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131692559));
      }
      paramBoolean = false;
    }
    if (((FileManagerEntity)localObject1).peerType == 0)
    {
      localObject2 = paramString4.a;
      paramString2 = new StringBuilder();
      paramString2.append(((FileManagerEntity)localObject1).forwardTroopFileEntrance);
      paramString2.append("");
      localObject3 = paramString2.toString();
      if (paramBoolean == true) {
        paramString2 = "1";
      } else {
        paramString2 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_files", "", "transfer", "Clk_fri", 0, 0, paramString3, (String)localObject3, paramString2, ((FileManagerEntity)localObject1).peerUin);
    }
    else if (((FileManagerEntity)localObject1).peerType == 3000)
    {
      localObject2 = paramString4.a;
      paramString2 = new StringBuilder();
      paramString2.append(((FileManagerEntity)localObject1).forwardTroopFileEntrance);
      paramString2.append("");
      localObject3 = paramString2.toString();
      if (paramBoolean == true) {
        paramString2 = "1";
      } else {
        paramString2 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_files", "", "transfer", "Clk_talk", 0, 0, paramString3, (String)localObject3, paramString2, "");
    }
    paramString2 = paramString4.a.getFileManagerNotifyCenter();
    if (((FileManagerEntity)localObject1).status == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    paramString2.a(paramBoolean, 46, new Object[] { Long.valueOf(((FileManagerEntity)localObject1).nSessionId), Integer.valueOf(paramInt), paramString1 });
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.C2CProcessCallBack
 * JD-Core Version:    0.7.0.1
 */