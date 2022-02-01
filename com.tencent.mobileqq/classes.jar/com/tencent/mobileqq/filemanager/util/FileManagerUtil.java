package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.mpfile.MpfileTaskInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.openbrowser.SendbarMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;

public class FileManagerUtil
{
  private static final char[] a = { '…' };
  private static final String b = new String(a);
  
  public static int a(int paramInt1, int paramInt2)
  {
    return QQFileManagerUtil.a(paramInt1, paramInt2);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    return QQFileManagerUtil.a(paramContext, paramBitmap, paramInt);
  }
  
  public static SpannableString a(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    return QQFileManagerUtil.a(paramString1, paramString2, paramTipsClickedInterface);
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.a)
    {
      localFileManagerEntity.status = -1;
    }
    else if (paramMpfileTaskInfo.g == MpfileTaskInfo.c)
    {
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 1.0F;
    }
    else if ((paramMpfileTaskInfo.g != MpfileTaskInfo.d) && (paramMpfileTaskInfo.g != MpfileTaskInfo.e))
    {
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.r / (float)paramMpfileTaskInfo.q);
    }
    else
    {
      localFileManagerEntity.status = 3;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.r / (float)paramMpfileTaskInfo.q);
    }
    localFileManagerEntity.fileName = paramMpfileTaskInfo.k;
    localFileManagerEntity.setFilePath(paramMpfileTaskInfo.l);
    localFileManagerEntity.fileSize = paramMpfileTaskInfo.q;
    localFileManagerEntity.nFileType = c(paramMpfileTaskInfo.k);
    if (localFileManagerEntity.nFileType == 0)
    {
      localObject = (DataLineHandler)c().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (((DataLineHandler)localObject).a().c() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
      else {
        localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { ((DataLineHandler)localObject).a().d(), paramMpfileTaskInfo.k });
      }
    }
    localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.r / (float)paramMpfileTaskInfo.q);
    localFileManagerEntity.uniseq = paramMpfileTaskInfo.s;
    localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.j;
    localFileManagerEntity.peerDin = paramLong;
    Object localObject = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= create new Entity[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] fileName[");
    localStringBuilder.append(paramMpfileTaskInfo.k);
    localStringBuilder.append("] by mpfile size(");
    localStringBuilder.append(localFileManagerEntity.imgHeight);
    localStringBuilder.append(":");
    localStringBuilder.append(localFileManagerEntity.imgWidth);
    localStringBuilder.append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    ((QQAppInterface)localObject).getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    return QQFileManagerUtil.a(paramBaseQQAppInterface, paramMessageForFile);
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramLong, paramString, paramInt, paramChatMessage);
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    QQAppInterface localQQAppInterface = c();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localObject1 = localQQAppInterface.getFileManagerDataCenter().a(paramDataLineMsgRecord.entityID);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new FileManagerEntity();
      ((FileManagerEntity)localObject1).nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = ((FileManagerEntity)localObject1).nSessionId;
      ((FileManagerEntity)localObject1).datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
      localObject2 = localObject1;
      if (paramDataLineMsgRecord.nOpType == 31)
      {
        ((FileManagerEntity)localObject1).strTroopFilePath = paramDataLineMsgRecord.fileUuid;
        localObject2 = localObject1;
      }
    }
    if (localObject2.datalineEntitySessionId == 0L) {
      localObject2.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
    }
    localObject2.setCloudType(6);
    localObject2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    localObject2.status = -1;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      localObject2.status = 1;
      if (!paramDataLineMsgRecord.issuc) {
        localObject2.status = 0;
      } else if (paramDataLineMsgRecord.progress != 1.0F) {
        localObject2.status = 2;
      }
    }
    else if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      localObject2.status = 3;
      if (paramDataLineMsgRecord.progress == 0.0F) {
        localObject2.status = 0;
      }
    }
    if (paramDataLineMsgRecord.nOpType == 1) {
      localObject2.bSend = false;
    }
    localObject2.fileName = paramDataLineMsgRecord.filename;
    if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
      localObject2.setFilePath(paramDataLineMsgRecord.path);
    }
    localObject2.Uuid = paramDataLineMsgRecord.serverPath;
    if ((localObject2.Uuid == null) && ((paramDataLineMsgRecord.nOpType == 31) || (paramDataLineMsgRecord.nOpType == 29))) {
      localObject2.Uuid = paramDataLineMsgRecord.fileUuid;
    }
    localObject2.peerType = 6000;
    localObject2.peerUin = AppConstants.DATALINE_PC_UIN;
    if (1 == DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid))
    {
      localObject2.peerType = 6003;
      localObject2.peerUin = AppConstants.DATALINE_IPAD_UIN;
    }
    localObject2.fileSize = paramDataLineMsgRecord.filesize;
    localObject2.strFileMd5 = HexUtil.bytes2HexStr(paramDataLineMsgRecord.md5);
    localObject2.nFileType = c(paramDataLineMsgRecord.filename);
    if (localObject2.nFileType == 0)
    {
      localObject2.strThumbPath = paramDataLineMsgRecord.thumbPath;
      localObject2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
    }
    else if ((localObject2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == -2000))
    {
      localObject2.nFileType = 0;
    }
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      localObject2.nFileType = c(paramDataLineMsgRecord.path);
      localObject2.isFromrMolo = true;
    }
    a(paramDataLineMsgRecord, localObject2);
    localObject2.uniseq = paramDataLineMsgRecord.sessionid;
    localObject2.nOpType = paramDataLineMsgRecord.nOpType;
    localObject2.srvTime = (paramDataLineMsgRecord.time * 1000L);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("=_= create new Entity[");
    ((StringBuilder)localObject1).append(localObject2.nSessionId);
    ((StringBuilder)localObject1).append("] fileName[");
    ((StringBuilder)localObject1).append(paramDataLineMsgRecord.filename);
    ((StringBuilder)localObject1).append("] by dataline size(");
    ((StringBuilder)localObject1).append(localObject2.imgHeight);
    ((StringBuilder)localObject1).append(":");
    ((StringBuilder)localObject1).append(localObject2.imgWidth);
    ((StringBuilder)localObject1).append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    localQQAppInterface.getFileManagerDataCenter().d(localObject2);
    return localObject2;
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    QQAppInterface localQQAppInterface = c();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localObject1 = localQQAppInterface.getFileManagerProxy().a(paramMessageForDeviceFile.entityID);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new FileManagerEntity();
      ((FileManagerEntity)localObject2).nSessionId = a().longValue();
      paramMessageForDeviceFile.entityID = ((FileManagerEntity)localObject2).nSessionId;
    }
    ((FileManagerEntity)localObject2).setCloudType(8);
    ((FileManagerEntity)localObject2).bSend = paramMessageForDeviceFile.isSendFromLocal();
    ((FileManagerEntity)localObject2).nOpType = 1;
    if (((FileManagerEntity)localObject2).bSend) {
      ((FileManagerEntity)localObject2).nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus != 3) && (paramMessageForDeviceFile.nFileStatus != 1) && (paramMessageForDeviceFile.nFileStatus != 2))
    {
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        ((FileManagerEntity)localObject2).status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        ((FileManagerEntity)localObject2).status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        ((FileManagerEntity)localObject2).status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        ((FileManagerEntity)localObject2).status = -1;
      }
    }
    else {
      ((FileManagerEntity)localObject2).status = 2;
    }
    ((FileManagerEntity)localObject2).fileName = a(paramMessageForDeviceFile.filePath);
    if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
      ((FileManagerEntity)localObject2).setFilePath(paramMessageForDeviceFile.filePath);
    }
    ((FileManagerEntity)localObject2).fileSize = paramMessageForDeviceFile.fileSize;
    ((FileManagerEntity)localObject2).nFileType = c(paramMessageForDeviceFile.filePath);
    if ((((FileManagerEntity)localObject2).nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(DeviceMsgHandle.d))) {
      ((FileManagerEntity)localObject2).nFileType = 0;
    }
    ((FileManagerEntity)localObject2).fProgress = paramMessageForDeviceFile.progress;
    ((FileManagerEntity)localObject2).uniseq = paramMessageForDeviceFile.uSessionID;
    ((FileManagerEntity)localObject2).peerUin = paramMessageForDeviceFile.frienduin;
    ((FileManagerEntity)localObject2).peerType = paramMessageForDeviceFile.istroop;
    ((FileManagerEntity)localObject2).msgSeq = paramMessageForDeviceFile.uniseq;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("=_= create new Entity[");
    ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).nSessionId);
    ((StringBuilder)localObject1).append("] fileName[");
    ((StringBuilder)localObject1).append(paramMessageForDeviceFile.srcFileName);
    ((StringBuilder)localObject1).append("] by devices size(");
    ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).imgHeight);
    ((StringBuilder)localObject1).append(":");
    ((StringBuilder)localObject1).append(((FileManagerEntity)localObject2).imgWidth);
    ((StringBuilder)localObject1).append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    localQQAppInterface.getFileManagerDataCenter().d((FileManagerEntity)localObject2);
    return localObject2;
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    QQAppInterface localQQAppInterface = c();
    FileManagerEntity localFileManagerEntity1;
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.getFileManagerProxy().a(paramMessageForDeviceSingleStruct.entityID);
    } else {
      localFileManagerEntity1 = null;
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus != 3) && (paramMessageForDeviceSingleStruct.nMediaFileStatus != 1) && (paramMessageForDeviceSingleStruct.nMediaFileStatus != 2))
    {
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
    else {
      localFileManagerEntity2.status = 2;
    }
    localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
    localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
    localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
    localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
    if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
      localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
    }
    localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
    localFileManagerEntity2.nFileType = c(paramMessageForDeviceSingleStruct.strMediaFileName);
    localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
    localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
    localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
    localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
    localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
    localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity2);
    return localFileManagerEntity2;
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int i = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (i >= 0) {
      localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(i + 1);
    } else {
      localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    }
    Object localObject = new VFSFile(localFileManagerEntity.getFilePath());
    if (((VFSFile)localObject).exists()) {
      localFileManagerEntity.fileSize = ((VFSFile)localObject).length();
    }
    localFileManagerEntity.nFileType = c(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= create new Entity[");
    ((StringBuilder)localObject).append(localFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("] fileName[");
    ((StringBuilder)localObject).append(paramPrinterItemMsgRecord.filename);
    ((StringBuilder)localObject).append("] by print size(");
    ((StringBuilder)localObject).append(localFileManagerEntity.imgHeight);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(localFileManagerEntity.imgWidth);
    ((StringBuilder)localObject).append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    c().getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    return QQFileManagerUtil.a(paramFileInfo);
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    return QQFileManagerUtil.a(paramOfflineFileInfo, paramInt);
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return QQFileManagerUtil.a(paramWeiYunFileInfo);
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.t;
    if (FileUtil.d(paramTroopFileStatusInfo.k)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.k);
    }
    if (FileUtil.d(paramTroopFileStatusInfo.m)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.m;
    }
    if (FileUtil.d(paramTroopFileStatusInfo.l)) {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.l;
    } else if (FileUtil.d(paramTroopFileStatusInfo.n)) {
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.n;
    }
    localFileManagerEntity.fileSize = paramTroopFileStatusInfo.i;
    localFileManagerEntity.fProgress = ((float)paramTroopFileStatusInfo.j / (float)paramTroopFileStatusInfo.i);
    localFileManagerEntity.nFileType = c(paramTroopFileStatusInfo.t);
    if ((6 <= paramTroopFileStatusInfo.e) && (13 != paramTroopFileStatusInfo.e))
    {
      if (12 == paramTroopFileStatusInfo.e) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
    else {
      localFileManagerEntity.status = 2;
    }
    if (paramTroopFileStatusInfo.a != null) {
      localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.a.toString();
    }
    localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.r;
    localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.s;
    localFileManagerEntity.busId = paramTroopFileStatusInfo.u;
    localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.d;
    localFileManagerEntity.peerType = 1;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    localFileManagerEntity.uniseq = paramTroopFileStatusInfo.c;
    localFileManagerEntity.yybApkPackageName = paramTroopFileStatusInfo.A;
    localFileManagerEntity.yybApkName = paramTroopFileStatusInfo.B;
    localFileManagerEntity.yybApkIconUrl = paramTroopFileStatusInfo.C;
    localFileManagerEntity.apkSafeLevel = paramTroopFileStatusInfo.D;
    localFileManagerEntity.apkSafeMsg = paramTroopFileStatusInfo.E;
    localFileManagerEntity.apkSafeDetailUrl = paramTroopFileStatusInfo.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= create new Entity[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] fileName[");
    localStringBuilder.append(paramTroopFileStatusInfo.t);
    localStringBuilder.append("] by troop size(");
    localStringBuilder.append(localFileManagerEntity.imgHeight);
    localStringBuilder.append(":");
    localStringBuilder.append(localFileManagerEntity.imgWidth);
    localStringBuilder.append(")");
    QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    c().getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.strFavFileId = paramString2;
    localFileManagerEntity.strFavId = paramString1;
    localFileManagerEntity.fileName = paramString4;
    localFileManagerEntity.fileSize = paramLong;
    localFileManagerEntity.nFileType = c(paramString4);
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.setFilePath(paramString3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.strFileMd5 = paramString5;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString6;
    if (paramInt == 1) {
      localFileManagerEntity.nOpType = 36;
    } else if (paramInt == 0) {
      localFileManagerEntity.nOpType = 37;
    } else if (paramInt == 7) {
      localFileManagerEntity.nOpType = 38;
    }
    c().getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  private static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, MessageForFile paramMessageForFile)
  {
    return ForwardFileOption.a(paramFileManagerEntity, paramMessageForFile);
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface)
  {
    return new C2CProcessCallBack(paramQQAppInterface);
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramInt);
  }
  
  public static Long a()
  {
    return QQFileManagerUtil.g();
  }
  
  public static String a(int paramInt)
  {
    return QQFileManagerUtil.b(paramInt);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return QQFileManagerUtil.a(paramLong, paramInt);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramMessage);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = a(c(paramDataLineMsgRecord.path));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("]");
    localStringBuilder.append(paramDataLineMsgRecord.filename);
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramMessageRecord);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    return QQFileManagerUtil.a(paramByteStringMicro);
  }
  
  public static String a(String paramString)
  {
    return QQFileManagerUtil.n(paramString);
  }
  
  public static String a(String paramString, int paramInt)
  {
    return QQFileManagerUtil.b(paramString, paramInt);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, QQFileManagerUtil.IThumbResult paramIThumbResult)
  {
    return QQFileManagerUtil.a(paramString, paramInt1, paramInt2, paramIThumbResult);
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    return QQFileManagerUtil.a(paramString, paramBoolean, paramInt1, paramTextPaint, paramInt2);
  }
  
  public static String a(Map paramMap)
  {
    return QQFileManagerUtil.a(paramMap);
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (a(localMessageRecord)) {
          localArrayList.add(b((ChatMessage)localMessageRecord));
        } else {
          localArrayList.add(localMessageRecord);
        }
      }
      return localArrayList;
    }
    return paramList;
  }
  
  public static void a(long paramLong)
  {
    QQFileManagerUtil.b(paramLong);
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    QQFileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  public static void a(Activity paramActivity)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getFavFiles();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)((Iterator)localObject).next();
        if (c(localFavFileInfo.d) == 0) {
          localArrayList.add(Long.valueOf(localFavFileInfo.a));
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      int i = 0;
      long l = ((Long)localArrayList.get(0)).longValue();
      localObject = new long[localArrayList.size()];
      while (i < localObject.length)
      {
        localObject[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
      }
      QfavHelper.a(paramActivity, c().getCurrentAccountUin(), l, (long[])localObject);
    }
  }
  
  public static void a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    paramFileManagerEntity = new SendbarMediaFileBrowseProcessor(c()).a();
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramActivity, paramFileManagerEntity);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    QQFileManagerUtil.a(paramActivity, paramString);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).enterQlinkLocalFileBrowser(paramActivity, paramString, paramInt1, paramBoolean, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 1, paramString1);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).enterQlinkRecentFileBrowser(paramActivity, paramBoolean);
  }
  
  public static void a(Context paramContext)
  {
    QQFileManagerUtil.a(paramContext);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    QQFileManagerUtil.a(paramContext, paramFileManagerEntity, paramQQAppInterface, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    QQFileManagerUtil.a(paramContext, paramString);
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.a(paramImageView, paramFileManagerEntity);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    QQFileManagerUtil.a(paramImageView, paramString);
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.a(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str2 = FileUtil.a(paramDataLineMsgRecord.filename);
    if (str2 == null)
    {
      paramAsyncImageView.setImageResource(2130845755);
      return;
    }
    String str1 = paramDataLineMsgRecord.filename;
    Object localObject = str1;
    if (c(str2) == 0) {
      if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath))
      {
        localObject = paramDataLineMsgRecord.thumbPath;
      }
      else
      {
        paramDataLineMsgRecord = FilePathUtil.b(paramDataLineMsgRecord.path);
        localObject = str1;
        if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord)) {
          localObject = paramDataLineMsgRecord;
        }
      }
    }
    paramAsyncImageView.setDefaultImage(i(str2));
    if (c(str2) != 0)
    {
      int i = i(str2);
      if (i != 0) {
        paramAsyncImageView.setImageResource(i);
      }
    }
    else
    {
      paramAsyncImageView.setAsyncClipSize(128, 128);
      paramAsyncImageView.setAsyncImage((String)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramContext);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramContext, paramString1, paramString2, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    QFileUtils.a(paramQQAppInterface, paramChatMessage1, paramChatMessage2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, d());
      }
      return;
    }
    int i = (int)f(paramFileManagerEntity.peerType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("],setTempParam[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.i("FileManagerUtil<FileAssistant>", 2, localStringBuilder.toString());
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    if (i != 102)
    {
      if ((i != 104) && (i != 105)) {
        return;
      }
      paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
      return;
    }
    paramFileManagerEntity.tmpSessionFromPhone = paramString1;
    paramFileManagerEntity.tmpSessionToPhone = paramString2;
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    QQFileManagerUtil.a(paramChatMessage, paramMessageForFile);
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForTroopFile paramMessageForTroopFile)
  {
    paramMessageForTroopFile.uniseq = paramChatMessage.uniseq;
    paramMessageForTroopFile.msgseq = paramChatMessage.msgseq;
    paramMessageForTroopFile.url = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
    paramMessageForTroopFile.uuid = UUID.nameUUIDFromBytes(paramMessageForTroopFile.url.getBytes()).toString();
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.bisID = Integer.parseInt(str1);
    }
    paramMessageForTroopFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    String str2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      paramMessageForTroopFile.width = Integer.parseInt(str1);
      paramMessageForTroopFile.height = Integer.parseInt(str2);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.duration = Integer.parseInt(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  private static void a(DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity.fProgress = paramDataLineMsgRecord.progress;
    if ((paramFileManagerEntity.fProgress == 1.0D) && ((paramFileManagerEntity.status == 3) || (paramFileManagerEntity.status == -1))) {
      paramFileManagerEntity.fProgress = 0.0F;
    }
    if ((paramDataLineMsgRecord.nOpType == 1) && (Float.compare(paramDataLineMsgRecord.progress, 1.0F) == 0) && (!FilePathUtil.d(paramDataLineMsgRecord.path))) {
      paramFileManagerEntity.fProgress = 0.0F;
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.m(paramFileManagerEntity);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    QQFileManagerUtil.a(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramInt);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, QQFileManagerUtil.CheckResult paramCheckResult)
  {
    QQFileManagerUtil.a(paramFileManagerEntity, paramQQAppInterface, paramCheckResult);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.b(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    QQFileManagerUtil.a(paramAsyncImageView, paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    QQFileManagerUtil.a(paramAsyncImageView, paramString, paramInt);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    QQFileManagerUtil.a(paramAsyncImageView, paramString, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    QQFileManagerUtil.a(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    QQFileManagerUtil.a(paramList, paramActivity);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    QQFileManagerUtil.a(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    QQFileManagerUtil.a(paramBoolean, paramContext, paramFMDialogInterface, paramInt);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    return QQFileManagerUtil.a(paramContext, paramString, paramLong);
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    return QQFileManagerUtil.a(paramVFSFile1, paramVFSFile2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return QQFileManagerUtil.b(paramQQAppInterface, paramChatMessage);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return QQFileManagerUtil.b(paramQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    return QQFileManagerUtil.a(paramQQAppInterface, paramChatMessage, paramContext, paramBoolean);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter, boolean paramBoolean)
  {
    return a(paramQQAppInterface, paramIFileViewerAdapter.b(), paramIFileViewerAdapter.n(), paramBoolean);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(c(paramQQAppInterface), paramString, "PreviewMode");
    boolean bool1 = false;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {}
    try
    {
      int i = Integer.parseInt(paramQQAppInterface);
      if (paramInt == 16)
      {
        return false;
        i = -1;
      }
      boolean bool2 = e(i);
      if (paramBoolean)
      {
        paramBoolean = bool1;
        if (bool2)
        {
          paramBoolean = bool1;
          if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
            paramBoolean = true;
          }
        }
        return paramBoolean;
      }
      return bool2;
    }
    catch (NumberFormatException paramQQAppInterface) {}
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return QFileUtils.a(paramChatMessage);
  }
  
  public static boolean a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return QQFileManagerUtil.a(paramChatMessage, paramQQAppInterface, paramContext);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile)) {
      return true;
    }
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForDLFile);
  }
  
  public static boolean a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.m();
    int j = paramIFileViewerAdapter.n();
    String str = paramIFileViewerAdapter.h();
    paramIFileViewerAdapter = paramIFileViewerAdapter.j();
    boolean bool = true;
    if ((i == 3) && (j == 1))
    {
      if (!TextUtils.isEmpty(str)) {
        return bool;
      }
      if (!TextUtils.isEmpty(paramIFileViewerAdapter)) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return QQFileManagerUtil.a(paramFile1, paramFile2);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return QQFileManagerUtil.a(paramString1, paramString2);
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 102)
      {
        if (paramInt != 109)
        {
          if (paramInt != 124)
          {
            if (paramInt != 127) {
              return null;
            }
            return paramQQAppInterface.getMsgCache().o(paramString);
          }
          return paramQQAppInterface.getMsgCache().i(paramString);
        }
        return paramQQAppInterface.getMsgCache().u(paramString);
      }
      return null;
    }
    return paramQQAppInterface.getMsgCache().r(paramString);
  }
  
  public static byte[] a(String paramString, long paramLong)
  {
    return QQFileManagerUtil.a(paramString, paramLong);
  }
  
  public static Intent b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    if ((paramMessageRecord instanceof MessageForFile))
    {
      paramMessageRecord = (MessageForFile)paramMessageRecord;
      localBundle.putParcelable("fileinfo", a(a(paramQQAppInterface, paramMessageRecord), paramMessageRecord));
      localIntent.putExtras(localBundle);
      return localIntent;
    }
    Object localObject;
    if ((paramMessageRecord instanceof MessageForTroopFile))
    {
      paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
      paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessageRecord);
      localObject = a(paramQQAppInterface);
      ((FileManagerEntity)localObject).status = 2;
      ((FileManagerEntity)localObject).nOpType = 24;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.b(10006);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
        localForwardFileInfo.a(paramQQAppInterface.k);
      }
      localForwardFileInfo.d(paramQQAppInterface.t);
      localForwardFileInfo.d(paramQQAppInterface.i);
      localForwardFileInfo.a(Long.parseLong(paramMessageRecord.frienduin));
      if (paramQQAppInterface.a != null) {
        localForwardFileInfo.e(paramQQAppInterface.a.toString());
      }
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("forward_from_troop_file", true);
      return localIntent;
    }
    if ((paramMessageRecord instanceof MessageForDLFile))
    {
      paramMessageRecord = (MessageForDLFile)paramMessageRecord;
      int i = paramMessageRecord.deviceType;
      long l = paramMessageRecord.associatedId;
      localObject = paramQQAppInterface.getMessageFacade().d(i).a(l);
      if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((DataLineMsgRecord)localObject).path))) {
        try
        {
          paramQQAppInterface = a(new FileInfo(((DataLineMsgRecord)localObject).path));
          paramQQAppInterface.uniseq = paramMessageRecord.uniseq;
          paramQQAppInterface.strMiddleThumPath = ((DataLineMsgRecord)localObject).thumbPath;
          paramQQAppInterface.strLargeThumPath = ((DataLineMsgRecord)localObject).thumbPath;
          paramMessageRecord = new ForwardFileInfo();
          paramMessageRecord.b(10000);
          paramMessageRecord.d(paramQQAppInterface.getCloudType());
          paramMessageRecord.b(paramQQAppInterface.nSessionId);
          paramMessageRecord.d(paramQQAppInterface.fileName);
          paramMessageRecord.c(paramQQAppInterface.uniseq);
          paramMessageRecord.d(paramQQAppInterface.fileSize);
          paramMessageRecord.a(paramQQAppInterface.getFilePath());
          paramMessageRecord.f(paramQQAppInterface.strLargeThumPath);
          localBundle.putParcelable("fileinfo", paramMessageRecord);
          localIntent.putExtras(localBundle);
          return localIntent;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
    return localIntent;
  }
  
  public static ChatMessage b(ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    Object localObject = c();
    ChatMessage localChatMessage = paramChatMessage;
    if (a(paramChatMessage))
    {
      localChatMessage = paramChatMessage;
      if (!TextUtils.isEmpty(str))
      {
        int j = Integer.parseInt(str);
        if (j == 3)
        {
          localChatMessage = (ChatMessage)MessageRecordFactory.a(-2017);
          localChatMessage.isMultiMsg = paramChatMessage.isMultiMsg;
          localChatMessage.isReplySource = paramChatMessage.isReplySource;
          localChatMessage.selfuin = paramChatMessage.selfuin;
          localChatMessage.shmsgseq = paramChatMessage.shmsgseq;
          localChatMessage.frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          localChatMessage.senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          localObject = (MessageForTroopFile)localChatMessage;
          a(paramChatMessage, (MessageForTroopFile)localObject);
          ((MessageForTroopFile)localObject).istroop = 1;
        }
        else if ((j != 1) && (j != 2))
        {
          localChatMessage = paramChatMessage;
        }
        else
        {
          int i;
          if (j == 1) {
            i = -2005;
          } else {
            i = -2014;
          }
          localChatMessage = (ChatMessage)MessageRecordFactory.a(i);
          localChatMessage.isMultiMsg = paramChatMessage.isMultiMsg;
          localChatMessage.isReplySource = paramChatMessage.isReplySource;
          localChatMessage.selfuin = paramChatMessage.selfuin;
          localChatMessage.shmsgseq = paramChatMessage.shmsgseq;
          localChatMessage.frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          localChatMessage.senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          a(paramChatMessage, (MessageForFile)localChatMessage);
          if (localObject != null)
          {
            a((QQAppInterface)localObject, localChatMessage, paramChatMessage);
          }
          else if (j == 1)
          {
            localChatMessage.istroop = 0;
            localChatMessage.frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          }
          else if (j == 2)
          {
            localChatMessage.istroop = 3000;
          }
        }
        paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localChatMessage.saveExtInfoToExtStr("_m_ForwardFileStatus", paramChatMessage);
        }
      }
    }
    return localChatMessage;
  }
  
  public static IForwardCallBack b(QQAppInterface paramQQAppInterface)
  {
    return new FileManagerUtil.1(paramQQAppInterface);
  }
  
  public static String b(int paramInt)
  {
    return QQFileManagerUtil.c(paramInt);
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return QQFileManagerUtil.b(paramInt1, paramInt2);
  }
  
  public static String b(String paramString)
  {
    return QQFileManagerUtil.t(paramString);
  }
  
  public static void b(long paramLong)
  {
    try
    {
      QQFileManagerUtil.c(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).enterQlinkFromQfav(paramActivity, paramString, paramInt1, paramBoolean, paramInt2);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 3, paramString1);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    QQFileManagerUtil.b(paramContext, paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    QQFileManagerUtil.a(paramQQAppInterface, paramChatMessage, paramContext);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    QQFileManagerUtil.b(paramQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.a(paramAsyncImageView, paramFileManagerEntity);
  }
  
  public static void b(String paramString, int paramInt)
  {
    QQFileManagerUtil.a(paramString, paramInt);
  }
  
  public static boolean b()
  {
    return QQFileManagerUtil.h();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = paramIFileViewerAdapter.r();
    if (localFileManagerEntity == null) {
      return false;
    }
    int i;
    if ((a(paramQQAppInterface, paramIFileViewerAdapter, paramBoolean)) && (!localFileManagerEntity.isZipInnerFile)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramIFileViewerAdapter.f() != 6000) && (paramIFileViewerAdapter.m() != 7)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((paramIFileViewerAdapter.m() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null)) {
      k = 0;
    } else {
      k = 1;
    }
    int m;
    if (paramIFileViewerAdapter.m() != 0) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (paramIFileViewerAdapter.m() != 5) {
      n = 1;
    } else {
      n = 0;
    }
    return (i != 0) && (j != 0) && (k != 0) && (m != 0) && (n != 0);
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.i(paramFileManagerEntity);
  }
  
  public static boolean b(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.m();
    int j = paramIFileViewerAdapter.n();
    return (i == 3) && (j == 1);
  }
  
  public static int c(int paramInt)
  {
    return QQFileManagerUtil.d(paramInt);
  }
  
  public static int c(String paramString)
  {
    try
    {
      int i = QQFileManagerUtil.k(paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static Context c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getBaseContext();
  }
  
  public static QQAppInterface c()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = QQFileManagerUtil.a(paramFileManagerEntity);
      return paramFileManagerEntity;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public static void c(long paramLong)
  {
    try
    {
      QQFileManagerUtil.d(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    String str = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("url", str);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(paramContext, str, localIntent.getStringExtra("tdsourcetag"))) {
      WebAccelerator.a(paramContext, localIntent, paramString);
    }
  }
  
  public static void c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localObject = (MessageForFile)paramChatMessage;
      ((MessageForFile)localObject).uniseq = 0L;
      ((MessageForFile)localObject).msgseq = 0L;
      ((MessageForFile)localObject).fileName = "";
      ((MessageForFile)localObject).fileSize = 0L;
    }
    else if ((paramChatMessage instanceof MessageForTroopFile))
    {
      localObject = (MessageForTroopFile)paramChatMessage;
      ((MessageForTroopFile)localObject).uniseq = 0L;
      ((MessageForTroopFile)localObject).msgseq = 0L;
      ((MessageForTroopFile)localObject).url = "";
      ((MessageForTroopFile)localObject).uuid = "";
      ((MessageForTroopFile)localObject).bisID = 0;
      ((MessageForTroopFile)localObject).fileName = "";
      ((MessageForTroopFile)localObject).fileSize = 0L;
      ((MessageForTroopFile)localObject).width = 0;
      ((MessageForTroopFile)localObject).height = 0;
      ((MessageForTroopFile)localObject).duration = 0;
    }
    paramChatMessage.extStr = null;
  }
  
  public static int d(int paramInt)
  {
    return QQFileManagerUtil.e(paramInt);
  }
  
  public static int d(ChatMessage paramChatMessage)
  {
    return QQFileManagerUtil.a(paramChatMessage);
  }
  
  public static long d(long paramLong)
  {
    return QQFileManagerUtil.a(paramLong);
  }
  
  public static String d()
  {
    try
    {
      String str = QQFileManagerUtil.i();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    return QQFileManagerUtil.c(paramContext, paramString);
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.p(paramFileManagerEntity);
  }
  
  public static byte[] d(String paramString)
  {
    return QQFileManagerUtil.o(paramString);
  }
  
  public static String e(ChatMessage paramChatMessage)
  {
    return QQFileManagerUtil.b(paramChatMessage);
  }
  
  public static void e() {}
  
  public static void e(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.j(paramFileManagerEntity);
  }
  
  public static boolean e(int paramInt)
  {
    return QQFileManagerUtil.a(paramInt);
  }
  
  public static byte[] e(String paramString)
  {
    return QQFileManagerUtil.h(paramString);
  }
  
  public static long f()
  {
    return QQFileManagerUtil.b();
  }
  
  public static long f(int paramInt)
  {
    return QQFileManagerUtil.f(paramInt);
  }
  
  public static boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.k(paramFileManagerEntity);
  }
  
  public static byte[] f(String paramString)
  {
    return QQFileManagerUtil.i(paramString);
  }
  
  public static long g()
  {
    return QQFileManagerUtil.c();
  }
  
  public static void g(FileManagerEntity paramFileManagerEntity)
  {
    QQFileManagerUtil.e(paramFileManagerEntity);
  }
  
  public static byte[] g(String paramString)
  {
    return QQFileManagerUtil.j(paramString);
  }
  
  public static int h(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.n(paramFileManagerEntity);
  }
  
  public static long h(String paramString)
  {
    return QQFileManagerUtil.m(paramString);
  }
  
  public static TimeoutParam h()
  {
    return QQFileManagerUtil.d();
  }
  
  public static int i(String paramString)
  {
    return QQFileManagerUtil.q(paramString);
  }
  
  public static boolean i(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.o(paramFileManagerEntity);
  }
  
  public static String j(String paramString)
  {
    return QQFileManagerUtil.b(paramString);
  }
  
  public static boolean j(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.l(paramFileManagerEntity);
  }
  
  public static String k(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.h(paramFileManagerEntity);
  }
  
  public static String k(String paramString)
  {
    try
    {
      paramString = QQFileManagerUtil.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String l(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.g(paramFileManagerEntity);
  }
  
  public static void l(String paramString)
  {
    QQFileManagerUtil.w(paramString);
  }
  
  @TargetApi(9)
  public static int m(String paramString)
  {
    return QQFileManagerUtil.s(paramString);
  }
  
  public static boolean m(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.f(paramFileManagerEntity);
  }
  
  public static void n(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      QQFileManagerUtil.d(paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public static boolean n(String paramString)
  {
    return QQFileManagerUtil.v(paramString);
  }
  
  public static int o(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.r(paramFileManagerEntity);
  }
  
  public static int o(String paramString)
  {
    return QQFileManagerUtil.g(paramString);
  }
  
  public static int p(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.q(paramFileManagerEntity);
  }
  
  public static LinkedHashMap p(String paramString)
  {
    return QQFileManagerUtil.r(paramString);
  }
  
  public static String q(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.c(paramFileManagerEntity);
  }
  
  public static String q(String paramString)
  {
    return QQFileManagerUtil.x(paramString);
  }
  
  public static QQFileManagerUtil.VideoThumbInfo r(String paramString)
  {
    return QQFileManagerUtil.f(paramString);
  }
  
  public static String r(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileManagerUtil.b(paramFileManagerEntity);
  }
  
  public static boolean s(String paramString)
  {
    return QQFileManagerUtil.z(paramString);
  }
  
  public static String t(String paramString)
  {
    return QQFileManagerUtil.y(paramString);
  }
  
  public static String u(String paramString)
  {
    return QQFileManagerUtil.e(paramString);
  }
  
  public static long v(String paramString)
  {
    return QQFileManagerUtil.d(paramString);
  }
  
  public static int[] w(String paramString)
  {
    return QQFileManagerUtil.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */