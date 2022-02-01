package com.tencent.mobileqq.filemanager.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class GuildFilePBDecoderHelper
{
  private FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile, GuildFileData paramGuildFileData, msg_comm.MsgHead paramMsgHead, String paramString)
  {
    long l1 = paramMsgHead.msg_seq.get();
    long l2 = paramMsgHead.msg_uid.get();
    long l3 = paramMsgHead.msg_time.get();
    paramMsgHead = "";
    String str = ((IGPSService)paramQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    paramQQAppInterface.getFileManagerProxy().a(localFileManagerEntity);
    localFileManagerEntity.uniseq = paramMessageForFile.uniseq;
    localFileManagerEntity.guildId = paramGuildFileData.a;
    localFileManagerEntity.channelId = paramGuildFileData.b;
    localFileManagerEntity.Uuid = paramGuildFileData.k;
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.selfUin = paramQQAppInterface.getAccount();
    localFileManagerEntity.status = -1;
    localFileManagerEntity.fileSize = paramGuildFileData.j;
    localFileManagerEntity.srvTime = (l3 * 1000L);
    localFileManagerEntity.fileName = paramGuildFileData.i;
    localFileManagerEntity.nFileType = FileManagerUtil.c(paramGuildFileData.i);
    localFileManagerEntity.setCloudType(12);
    localFileManagerEntity.msgSeq = l1;
    localFileManagerEntity.msgUid = l2;
    localFileManagerEntity.peerType = 10014;
    localFileManagerEntity.lastTime = paramGuildFileData.m;
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str))) {
      bool = true;
    } else {
      bool = false;
    }
    localFileManagerEntity.bSend = bool;
    localFileManagerEntity.nOpType = 53;
    paramString = (IGPSService)paramQQAppInterface.getRuntimeService(IGPSService.class, "");
    paramMessageForFile = paramString.getGuildInfo(paramGuildFileData.a);
    if (paramMessageForFile != null) {
      paramMessageForFile = paramMessageForFile.getGuildName();
    } else {
      paramMessageForFile = "";
    }
    paramString = paramString.getChannelInfo(paramGuildFileData.b);
    paramGuildFileData = paramMsgHead;
    if (paramString != null) {
      paramGuildFileData = paramString.getChannelName();
    }
    localFileManagerEntity.peerNick = paramMessageForFile;
    localFileManagerEntity.guildName = paramMessageForFile;
    localFileManagerEntity.channelName = paramGuildFileData;
    paramQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static GuildFilePBDecoderHelper a()
  {
    return GuildFilePBDecoderHelper.HolderClass.a();
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile, GuildFileData paramGuildFileData, FileManagerEntity paramFileManagerEntity)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = ((IGPSService)paramQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    paramMessageForFile.init(str, paramGuildFileData.b, paramQQAppInterface, "", paramFileManagerEntity.srvTime, -2005, 10014, paramFileManagerEntity.msgSeq);
    paramMessageForFile.msg = TransfileUtile.makeTransFileProtocolData(paramGuildFileData.i, paramGuildFileData.j, 0, true);
    paramMessageForFile.msgUid = paramFileManagerEntity.msgUid;
    paramMessageForFile.fileName = paramFileManagerEntity.fileName;
    paramMessageForFile.fileSize = paramFileManagerEntity.fileSize;
    paramMessageForFile.filePath = "";
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString, msg_comm.MsgHead paramMsgHead)
  {
    long l1 = paramMsgHead.msg_seq.get();
    long l2 = paramMsgHead.msg_uid.get();
    paramMsgHead = ((IGuildSendMessageHandler)paramQQAppInterface.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a().iterator();
    while (paramMsgHead.hasNext())
    {
      Object localObject = (MessageRecord)paramMsgHead.next();
      if ((localObject != null) && (((MessageRecord)localObject).msgUid == l2))
      {
        long l3 = ((MessageRecord)localObject).uniseq;
        localObject = paramQQAppInterface.getFileManagerDataCenter().a(l3, paramString, 10014);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).msgSeq = l1;
          paramQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, String paramString, msg_comm.MsgHead paramMsgHead)
  {
    paramMsgHead.msg_seq.get();
    long l = paramMsgHead.msg_uid.get();
    paramMsgHead = ((IMessageFacade)paramQQAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramString, 10014);
    if (paramMsgHead != null)
    {
      paramMsgHead = paramMsgHead.iterator();
      while (paramMsgHead.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramMsgHead.next();
        if ((localMessageRecord != null) && (localMessageRecord.msgUid == l) && (paramQQAppInterface.getFileManagerDataCenter().a(localMessageRecord.uniseq, paramString, 10014) != null)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile, msg_comm.Msg paramMsg, GuildFileData paramGuildFileData, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((paramMessageForFile != null) && (paramMsg != null) && (paramGuildFileData != null))
    {
      paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (a(paramQQAppInterface, paramGuildFileData.b, paramMsg)) {
        return;
      }
      if (b(paramQQAppInterface, paramGuildFileData.b, paramMsg)) {
        return;
      }
      paramMsg = a(paramQQAppInterface, paramMessageForFile, paramGuildFileData, paramMsg, String.valueOf(paramDecodeProtoPkgContext.b));
      a(paramQQAppInterface, paramMessageForFile, paramGuildFileData, paramMsg);
      FileUtils.a(paramQQAppInterface, paramMsg);
      paramQQAppInterface.getFileManagerDataCenter().c(paramMsg);
      return;
    }
    QLog.e("GuildFilePBDecoderHelper", 1, "handleGuildFileMsg args error !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFilePBDecoderHelper
 * JD-Core Version:    0.7.0.1
 */