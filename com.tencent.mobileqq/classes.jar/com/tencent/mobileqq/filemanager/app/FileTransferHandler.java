package com.tencent.mobileqq.filemanager.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.FileQueryReq;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMConstants.RevertMsgCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadHitReqV2;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadReqV2;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadReqV3;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.Cmd0x346CSBody;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactorySender;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.service.message.codec.decoder.TempSessionDecoder;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.A9Message;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.qidian.util.QidianUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x3ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0xaReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x2RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0xaRspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file.msg;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileApkInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileAssitInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class FileTransferHandler
{
  public static final byte[] c = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  private static final String d = FileTransferObserver.class.getName();
  private static int e = 0;
  private static Handler i = new FileTransferHandler.1(Looper.getMainLooper());
  public final QQAppInterface a;
  AIOMessageSpreadManager b = null;
  private long f;
  private Map<Long, FileTransferObserver> g = new HashMap();
  private DecimalFormat h = new DecimalFormat("0.00");
  private MessageFactorySender j = new MessageFactorySender();
  private MessageFactoryReceiver k = new MessageFactoryReceiver();
  
  public FileTransferHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private int a(long paramLong, im_msg_body.NotOnlineFile paramNotOnlineFile, int paramInt)
  {
    if (paramNotOnlineFile.uint32_reserved.has())
    {
      int m = paramNotOnlineFile.uint32_reserved.get();
      paramInt = m;
      if (m == paramLong) {
        paramInt = 0;
      }
    }
    return paramInt;
  }
  
  private FileManagerEntity a(MessageHandler paramMessageHandler, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    long l = paramInt2;
    if (0L != l)
    {
      paramMessageHandler = this.a.getFileManagerDataCenter().a(paramString1, l);
      if (paramMessageHandler != null)
      {
        paramLong3 = paramMessageHandler.nSessionId;
        if (!this.a.getFileManagerDataCenter().b(paramString1, l))
        {
          paramMessageHandler.Uuid = paramString3;
          if (!paramString4.isEmpty())
          {
            paramMessageHandler.fileIdCrc = paramString4;
            paramString2 = new StringBuilder();
            paramString2.append("Recv a online changto offline file. fileIdCrc: ");
            paramString2.append(paramString4);
            QLog.i("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
          }
          FileManagerUtil.a(this.a, paramMessageHandler);
          FileManagerUtil.a(paramMessageHandler, this.a, null);
          if ((paramBoolean2) && (paramBoolean1))
          {
            paramString2 = new StringBuilder();
            paramString2.append("Recv a online changto offline file. name: ");
            paramString2.append(paramString5);
            paramString2.append(". is  roma and readed, think okt!!");
            QLog.i("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
          else
          {
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
          paramMessageHandler = this.a.getMessageFacade().b(paramString1, 0, paramMessageHandler.uniseq);
          if (paramMessageHandler != null)
          {
            if ((paramMessageHandler instanceof MessageForFile))
            {
              paramString2 = (MessageForFile)paramMessageHandler;
              paramString2.originalmsgShseq = paramMessageHandler.shmsgseq;
              paramString2.originalMsgUid = paramMessageHandler.msgUid;
              paramString2.originalTime = paramMessageHandler.time;
            }
            paramMessageHandler.shmsgseq = paramShort;
            paramMessageHandler.time = paramLong1;
            paramMessageHandler.msgUid = paramLong4;
            this.a.getMessageFacade().a(paramInt1).a(paramString1, paramInt1, paramMessageHandler, 3);
          }
          return null;
        }
        this.a.getOnlineFileSessionCenter().f(paramLong3);
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("Recv a online changto offline file. name: ");
        paramMessageHandler.append(paramString5);
        paramMessageHandler.append(". user had delete about onlinefile record!!! ");
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramMessageHandler.toString());
        paramBoolean1 = true;
        bool = true;
        paramLong1 = paramLong3;
        break label376;
      }
      paramBoolean1 = false;
    }
    else
    {
      paramBoolean1 = true;
    }
    paramLong1 = 0L;
    boolean bool = false;
    label376:
    TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.a.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
    paramLong2 = MessageRecordFactory.a(-2005).uniseq;
    this.a.getCurrentAccountUin();
    if (0L != l)
    {
      this.a.getOnlineFileSessionCenter().f(paramLong1);
      if (QLog.isColorLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("Recv a offline file name: ");
        paramMessageHandler.append(paramString5);
        paramMessageHandler.append(". and it is : online changto offline. OLfilesession=");
        paramMessageHandler.append(l);
        paramMessageHandler.append("isPullRoam =");
        paramMessageHandler.append(paramBoolean2);
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramMessageHandler.toString());
      }
      if (paramBoolean2)
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("Recv a online changto offline file. name: ");
        paramMessageHandler.append(paramString5);
        paramMessageHandler.append(". isPullRoam hadHasOlSessionRecord=");
        paramMessageHandler.append(bool);
        paramMessageHandler.append(" isDelOlSessionRecord=");
        paramMessageHandler.append(paramBoolean1);
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramMessageHandler.toString());
      }
      if ((0L != paramLong1) && (!this.a.getFileManagerDataCenter().d(paramLong1))) {
        return this.a.getFileManagerDataCenter().a(paramLong1, paramLong2, paramString1, 0);
      }
      return this.a.getFileManagerDataCenter().b(paramLong2, paramString1, 0);
    }
    return this.a.getFileManagerDataCenter().b(paramLong2, paramString1, 0);
  }
  
  private FileManagerEntity a(hummer_resv_21.ResvAttr paramResvAttr)
  {
    if ((paramResvAttr != null) && (paramResvAttr.file_assist_info.has()))
    {
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      hummer_resv_21.FileAssitInfo localFileAssitInfo = (hummer_resv_21.FileAssitInfo)paramResvAttr.file_assist_info.get();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = localFileManagerEntity;
      if (localFileAssitInfo.uint64_session_id.has())
      {
        long l2 = localFileAssitInfo.uint64_session_id.get();
        long l1 = l2;
        if (paramResvAttr != null)
        {
          l1 = l2;
          if (paramResvAttr.device_type.has())
          {
            l1 = l2;
            if (QFileAssistantUtils.c(paramResvAttr.device_type.get()) == 2) {
              l1 = l2 | 0x0;
            }
          }
        }
        localFileManagerEntity.nSessionId = l1;
        localObject = this.a.getFileManagerDataCenter().a(l1);
        paramResvAttr = localFileManagerEntity;
        if (localObject != null) {
          paramResvAttr = (hummer_resv_21.ResvAttr)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setWlan Sessionid:");
        ((StringBuilder)localObject).append(paramResvAttr.nSessionId);
        localStringBuilder.append(((StringBuilder)localObject).toString());
        localObject = paramResvAttr;
      }
      if (localFileAssitInfo.uint32_group_id.has())
      {
        ((FileManagerEntity)localObject).dlGroupId = localFileAssitInfo.uint32_group_id.get();
        paramResvAttr = new StringBuilder();
        paramResvAttr.append(" groupId:");
        paramResvAttr.append(((FileManagerEntity)localObject).dlGroupId);
        localStringBuilder.append(paramResvAttr.toString());
      }
      if (localFileAssitInfo.uint32_group_count.has())
      {
        ((FileManagerEntity)localObject).dlGroupCount = localFileAssitInfo.uint32_group_count.get();
        paramResvAttr = new StringBuilder();
        paramResvAttr.append(" groupCount:");
        paramResvAttr.append(((FileManagerEntity)localObject).dlGroupCount);
        localStringBuilder.append(paramResvAttr.toString());
      }
      if (localFileAssitInfo.uint32_group_idx.has())
      {
        ((FileManagerEntity)localObject).dlGourpIndex = localFileAssitInfo.uint32_group_idx.get();
        paramResvAttr = new StringBuilder();
        paramResvAttr.append(" groupIndex:");
        paramResvAttr.append(((FileManagerEntity)localObject).dlGourpIndex);
        localStringBuilder.append(paramResvAttr.toString());
      }
      QLog.i("FileTransferHandler<FileAssistant>.NFRV", 1, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  private ToServiceMsg a(boolean paramBoolean, int paramInt, long paramLong, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    ToServiceMsg localToServiceMsg = b("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    localToServiceMsg.putWupBuffer(paramPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    this.a.sendToService(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public static Pair<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.getBytes();
    if (paramString.length > 36)
    {
      byte[] arrayOfByte1 = new byte[32];
      byte[] arrayOfByte2 = new byte[paramString.length - 32];
      int m = 0;
      while (m < paramString.length)
      {
        if (m < 32) {
          arrayOfByte1[m] = paramString[m];
        } else {
          arrayOfByte2[(m - 32)] = paramString[m];
        }
        m += 1;
      }
      return new Pair(new String(arrayOfByte1), new String(arrayOfByte2));
    }
    return null;
  }
  
  private String a(String paramString, TempSessionInfo paramTempSessionInfo)
  {
    if ((paramTempSessionInfo.a == 1000) || (paramTempSessionInfo.a == 1020) || (paramTempSessionInfo.a == 1004)) {
      paramString = String.valueOf(paramTempSessionInfo.c);
    }
    return paramString;
  }
  
  private List<String> a(FileUploadInfo paramFileUploadInfo, List<String> paramList, cmd0x346.ApplyUploadRspV2 paramApplyUploadRspV2)
  {
    if (paramApplyUploadRspV2.int32_ret_code.has()) {
      paramFileUploadInfo.a = paramApplyUploadRspV2.int32_ret_code.get();
    }
    if (paramApplyUploadRspV2.str_ret_msg.has()) {
      paramFileUploadInfo.b = paramApplyUploadRspV2.str_ret_msg.get();
    }
    if (paramApplyUploadRspV2.uint64_total_space.has()) {
      paramFileUploadInfo.c = paramApplyUploadRspV2.uint64_total_space.get();
    }
    if (paramApplyUploadRspV2.uint64_used_space.has()) {
      paramFileUploadInfo.d = paramApplyUploadRspV2.uint64_used_space.get();
    }
    if (paramApplyUploadRspV2.uint64_uploaded_size.has()) {
      paramFileUploadInfo.e = paramApplyUploadRspV2.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV2.str_upload_ip.has()) {
      paramFileUploadInfo.f = paramApplyUploadRspV2.str_upload_ip.get();
    } else if (paramApplyUploadRspV2.str_upload_domain.has()) {
      paramFileUploadInfo.f = paramApplyUploadRspV2.str_upload_domain.get();
    } else {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
    }
    if (paramApplyUploadRspV2.uint32_upload_port.has()) {
      paramFileUploadInfo.g = ((short)paramApplyUploadRspV2.uint32_upload_port.get());
    }
    if (paramApplyUploadRspV2.bytes_uuid.has()) {
      paramFileUploadInfo.h = paramApplyUploadRspV2.bytes_uuid.get().toByteArray();
    }
    if (paramApplyUploadRspV2.bytes_upload_key.has()) {
      paramFileUploadInfo.i = paramApplyUploadRspV2.bytes_upload_key.get().toByteArray();
    }
    if (paramApplyUploadRspV2.bool_file_exist.has()) {
      paramFileUploadInfo.j = paramApplyUploadRspV2.bool_file_exist.get();
    }
    if (paramApplyUploadRspV2.uint32_upload_port.has()) {
      paramFileUploadInfo.k = paramApplyUploadRspV2.uint32_pack_size.get();
    }
    if (paramApplyUploadRspV2.uint32_httpsvr_api_ver.has()) {
      paramFileUploadInfo.o = paramApplyUploadRspV2.uint32_httpsvr_api_ver.get();
    }
    if (paramApplyUploadRspV2.bytes_sha.has()) {
      paramFileUploadInfo.m = paramApplyUploadRspV2.bytes_sha.get().toByteArray();
    }
    Object localObject = paramList;
    if (paramApplyUploadRspV2.rpt_str_uploadip_list.has())
    {
      localObject = paramList;
      if (paramApplyUploadRspV2.rpt_str_uploadip_list.get().size() > 0) {
        localObject = paramApplyUploadRspV2.rpt_str_uploadip_list.get();
      }
    }
    if (paramApplyUploadRspV2.str_upload_https_domain.has()) {
      paramFileUploadInfo.p = paramApplyUploadRspV2.str_upload_https_domain.get();
    }
    if (paramApplyUploadRspV2.uint32_upload_https_port.has()) {
      paramFileUploadInfo.q = ((short)paramApplyUploadRspV2.uint32_upload_https_port.get());
    }
    if (paramApplyUploadRspV2.str_upload_dns.has()) {
      paramFileUploadInfo.r = paramApplyUploadRspV2.str_upload_dns.get();
    }
    if (paramApplyUploadRspV2.str_upload_lanip.has()) {
      paramFileUploadInfo.s = paramApplyUploadRspV2.str_upload_lanip.get();
    }
    return localObject;
  }
  
  private List<String> a(FileUploadInfo paramFileUploadInfo, List<String> paramList, cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3)
  {
    if (paramApplyUploadRspV3.int32_ret_code.has()) {
      paramFileUploadInfo.a = paramApplyUploadRspV3.int32_ret_code.get();
    }
    if (paramApplyUploadRspV3.str_ret_msg.has()) {
      paramFileUploadInfo.b = paramApplyUploadRspV3.str_ret_msg.get();
    }
    if (paramApplyUploadRspV3.uint64_total_space.has()) {
      paramFileUploadInfo.c = paramApplyUploadRspV3.uint64_total_space.get();
    }
    if (paramApplyUploadRspV3.uint64_used_space.has()) {
      paramFileUploadInfo.d = paramApplyUploadRspV3.uint64_used_space.get();
    }
    if (paramApplyUploadRspV3.uint64_uploaded_size.has()) {
      paramFileUploadInfo.e = paramApplyUploadRspV3.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV3.str_upload_ip.has()) {
      paramFileUploadInfo.f = paramApplyUploadRspV3.str_upload_ip.get();
    } else if (paramApplyUploadRspV3.str_upload_domain.has()) {
      paramFileUploadInfo.f = paramApplyUploadRspV3.str_upload_domain.get();
    } else {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
    }
    if (paramApplyUploadRspV3.uint32_upload_port.has()) {
      paramFileUploadInfo.g = ((short)paramApplyUploadRspV3.uint32_upload_port.get());
    }
    if (paramApplyUploadRspV3.bytes_uuid.has()) {
      paramFileUploadInfo.h = paramApplyUploadRspV3.bytes_uuid.get().toByteArray();
    }
    if (paramApplyUploadRspV3.bytes_upload_key.has()) {
      paramFileUploadInfo.i = paramApplyUploadRspV3.bytes_upload_key.get().toByteArray();
    }
    if (paramApplyUploadRspV3.bool_file_exist.has()) {
      paramFileUploadInfo.j = paramApplyUploadRspV3.bool_file_exist.get();
    }
    if (paramFileUploadInfo.u) {
      if (paramFileUploadInfo.j)
      {
        if (paramApplyUploadRspV3.str_fileidcrc.has()) {
          paramFileUploadInfo.w = paramApplyUploadRspV3.str_fileidcrc.get();
        }
      }
      else if (paramApplyUploadRspV3.bytes_media_plateform_upload_key.has()) {
        paramFileUploadInfo.v = paramApplyUploadRspV3.bytes_media_plateform_upload_key.get().toByteArray();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
      }
    }
    if (paramApplyUploadRspV3.uint32_upload_port.has()) {
      paramFileUploadInfo.k = paramApplyUploadRspV3.uint32_pack_size.get();
    }
    Object localObject = paramList;
    if (paramApplyUploadRspV3.rpt_str_uploadip_list.has())
    {
      localObject = paramList;
      if (paramApplyUploadRspV3.rpt_str_uploadip_list.get().size() > 0) {
        localObject = paramApplyUploadRspV3.rpt_str_uploadip_list.get();
      }
    }
    if (paramApplyUploadRspV3.str_upload_https_domain.has()) {
      paramFileUploadInfo.p = paramApplyUploadRspV3.str_upload_https_domain.get();
    }
    if (paramApplyUploadRspV3.uint32_upload_https_port.has()) {
      paramFileUploadInfo.q = ((short)paramApplyUploadRspV3.uint32_upload_https_port.get());
    }
    if (paramApplyUploadRspV3.str_upload_dns.has()) {
      paramFileUploadInfo.r = paramApplyUploadRspV3.str_upload_dns.get();
    }
    if (paramApplyUploadRspV3.str_upload_lanip.has()) {
      paramFileUploadInfo.s = paramApplyUploadRspV3.str_upload_lanip.get();
    }
    return localObject;
  }
  
  private List<String> a(FileUploadInfo paramFileUploadInfo, List<String> paramList, cmd0x346.RspBody paramRspBody)
  {
    cmd0x346.ApplyUploadRsp localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramRspBody.msg_apply_upload_rsp.get();
    if (localApplyUploadRsp.int32_ret_code.has()) {
      paramFileUploadInfo.a = localApplyUploadRsp.int32_ret_code.get();
    }
    if (localApplyUploadRsp.str_ret_msg.has()) {
      paramFileUploadInfo.b = localApplyUploadRsp.str_ret_msg.get();
    }
    if (localApplyUploadRsp.uint64_total_space.has()) {
      paramFileUploadInfo.c = localApplyUploadRsp.uint64_total_space.get();
    }
    if (localApplyUploadRsp.uint64_used_space.has()) {
      paramFileUploadInfo.d = localApplyUploadRsp.uint64_used_space.get();
    }
    if (localApplyUploadRsp.uint64_uploaded_size.has()) {
      paramFileUploadInfo.e = localApplyUploadRsp.uint64_uploaded_size.get();
    }
    if (localApplyUploadRsp.str_upload_ip.has()) {
      paramFileUploadInfo.f = localApplyUploadRsp.str_upload_ip.get();
    } else if (localApplyUploadRsp.str_upload_domain.has()) {
      paramFileUploadInfo.f = localApplyUploadRsp.str_upload_domain.get();
    } else {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
    }
    if (localApplyUploadRsp.uint32_upload_port.has()) {
      paramFileUploadInfo.g = ((short)localApplyUploadRsp.uint32_upload_port.get());
    }
    if (localApplyUploadRsp.bytes_uuid.has()) {
      paramFileUploadInfo.h = localApplyUploadRsp.bytes_uuid.get().toByteArray();
    }
    if (localApplyUploadRsp.bytes_upload_key.has()) {
      paramFileUploadInfo.i = localApplyUploadRsp.bytes_upload_key.get().toByteArray();
    }
    if (localApplyUploadRsp.bool_file_exist.has()) {
      paramFileUploadInfo.j = localApplyUploadRsp.bool_file_exist.get();
    }
    if (localApplyUploadRsp.uint32_upload_port.has()) {
      paramFileUploadInfo.k = localApplyUploadRsp.uint32_pack_size.get();
    }
    paramRspBody = paramList;
    if (localApplyUploadRsp.rpt_str_uploadip_list.has())
    {
      paramRspBody = paramList;
      if (localApplyUploadRsp.rpt_str_uploadip_list.get().size() > 0) {
        paramRspBody = localApplyUploadRsp.rpt_str_uploadip_list.get();
      }
    }
    if (localApplyUploadRsp.str_upload_dns.has()) {
      paramFileUploadInfo.r = localApplyUploadRsp.str_upload_dns.get();
    }
    return paramRspBody;
  }
  
  private msg_svc.PbSendMsgReq a(String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    paramLong = FileManagerUtil.g();
    long l = FileManagerUtil.f();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.a = paramInt1;
    localTransMsgContext.b = paramArrayOfByte;
    paramString = MessageProtoCodec.a(this.a, 13, paramString, localTransMsgContext, l, MessageUtils.b(paramLong));
    paramArrayOfByte = new im_msg_head.InstInfo();
    if (paramInt2 == 3) {
      paramInt1 = 1001;
    } else {
      paramInt1 = 1;
    }
    paramArrayOfByte.uint32_apppid.set(paramInt1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(paramInt2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.d());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    return paramString;
  }
  
  private void a(long paramLong, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramLong != -5L) && (paramLong != -6L)) {
      return;
    }
    MessageHandler localMessageHandler = (MessageHandler)this.a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
    if (localMessageHandler == null) {
      return;
    }
    localMessageHandler.a(3008, false, new Object[] { paramFileManagerEntity.peerUin, Integer.valueOf(3000), Integer.valueOf(103) });
  }
  
  private void a(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    int m = paramFileManagerEntity.nOpType;
    if (m != 4)
    {
      if (m != 7)
      {
        if (m != 32) {}
        switch (m)
        {
        default: 
          return;
        case 29: 
          try
          {
            IForwardCallBack localIForwardCallBack = (IForwardCallBack)paramFileManagerEntity.mContext;
            if (localIForwardCallBack == null) {
              return;
            }
            localIForwardCallBack.a(paramBoolean, paramFileManagerEntity.datalineEntitySessionId, paramInt, paramString1, null, null, paramString2);
            return;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            paramString2 = new StringBuilder();
            paramString2.append("handleForwardFromOfflineResponse: Exception is ");
            paramString2.append(paramString1.toString());
            QLog.e("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
            return;
          }
        case 26: 
        case 27: 
          try
          {
            ((IForwardCallBack)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString1, String.valueOf(paramFileManagerEntity.peerUin), paramString2);
            return;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            paramString2 = new StringBuilder();
            paramString2.append("handleForwardFromOfflineResponse: Exception is ");
            paramString2.append(paramString1.toString());
            QLog.e("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
            return;
          }
        }
      }
      c(paramLong, paramBoolean, paramInt, paramString1, paramString2, paramFileManagerEntity);
    }
    else
    {
      b(paramLong, paramBoolean, paramInt, paramString1, paramString2, paramFileManagerEntity);
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString6, TempSessionInfo paramTempSessionInfo, int paramInt3, hummer_resv_21.ResvAttr paramResvAttr, byte[] paramArrayOfByte, String paramString7)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalHandleOffLineFileMsg friendUin[");
      ((StringBuilder)localObject).append(String.valueOf(paramString1));
      ((StringBuilder)localObject).append("],senderuin[");
      ((StringBuilder)localObject).append(String.valueOf(paramString2));
      ((StringBuilder)localObject).append("],time[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      ((StringBuilder)localObject).append("],seq[");
      ((StringBuilder)localObject).append(String.valueOf(paramShort));
      ((StringBuilder)localObject).append("],isRead[");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean1));
      ((StringBuilder)localObject).append("],isPullRoam[");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean2));
      ((StringBuilder)localObject).append("],type[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt1));
      ((StringBuilder)localObject).append("],uuid[");
      ((StringBuilder)localObject).append(String.valueOf(paramString3));
      ((StringBuilder)localObject).append("],fileIdCrc[");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append("],type[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt1));
      ((StringBuilder)localObject).append("],strFileName[");
      ((StringBuilder)localObject).append(String.valueOf(paramString5));
      ((StringBuilder)localObject).append("],dwFileSize[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong2));
      ((StringBuilder)localObject).append("],reserve[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("],vipBubbleID[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong3));
      ((StringBuilder)localObject).append("],vipBubbleDiyTextID[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt3));
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramResvAttr);
    if (localObject == null) {
      paramMessageHandler = a(paramMessageHandler, paramString1, paramString2, paramLong1, paramShort, paramBoolean1, paramBoolean2, paramInt1, paramString3, paramString4, paramString5, paramLong2, paramInt2, paramLong3, paramLong4);
    } else {
      paramMessageHandler = (MessageHandler)localObject;
    }
    if (paramMessageHandler == null)
    {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "entry is null,may be is onlinefile!");
      return;
    }
    if (TextUtils.isEmpty(paramString5))
    {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  no file name . return!!!!");
      return;
    }
    if (a(paramList, paramString1, paramString2, paramShort, paramBoolean1, paramBoolean2, paramString3, paramString5, paramInt2, paramLong4)) {
      return;
    }
    localObject = TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.a.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
    if (paramTempSessionInfo != null)
    {
      if (paramTempSessionInfo.a == -1)
      {
        m = 0;
      }
      else
      {
        paramString2 = a(paramString2, paramTempSessionInfo);
        m = 1;
      }
      if (m != 0)
      {
        m = paramTempSessionInfo.a;
        break label519;
      }
    }
    int m = 0;
    label519:
    String str = this.a.getCurrentAccountUin();
    paramMessageHandler.setCloudType(1);
    paramMessageHandler.fileName = paramString5;
    paramMessageHandler.fileSize = paramLong2;
    paramMessageHandler.peerNick = FileManagerUtil.a(this.a, paramString1, null, 0);
    paramMessageHandler.peerType = m;
    paramMessageHandler.peerUin = paramString1;
    paramMessageHandler.srvTime = (paramLong1 * 1000L);
    paramMessageHandler.status = -1;
    paramMessageHandler.Uuid = paramString3;
    paramMessageHandler.fileIdCrc = paramString4;
    paramMessageHandler.isReaded = paramBoolean1;
    paramMessageHandler.bSend = false;
    long l = paramShort;
    paramMessageHandler.msgSeq = l;
    paramMessageHandler.msgUid = paramLong4;
    paramMessageHandler.strFileMd5 = paramString6;
    paramMessageHandler.nFileType = FileManagerUtil.c(paramString5);
    a(paramString1, paramString2, paramString3, paramTempSessionInfo, paramArrayOfByte, paramString7, paramMessageHandler);
    if ((paramResvAttr != null) && (paramResvAttr.file_image_info != null) && (paramResvAttr.file_image_info.has()))
    {
      paramString4 = (hummer_resv_21.FileImgInfo)paramResvAttr.file_image_info.get();
      paramMessageHandler.imgWidth = paramString4.uint32_file_width.get();
      paramMessageHandler.imgHeight = paramString4.uint32_file_height.get();
    }
    if ((paramResvAttr != null) && (paramResvAttr.file_apk_info != null) && (paramResvAttr.file_apk_info.has())) {
      a((hummer_resv_21.FileApkInfo)paramResvAttr.file_apk_info.get(), paramMessageHandler);
    }
    paramString4 = new StringBuilder();
    paramString4.append("=_=k recv OfflineFile Id[");
    paramString4.append(paramMessageHandler.nSessionId);
    paramString4.append("],File[");
    paramString4.append(paramMessageHandler.fileName);
    paramString4.append("], Md5[");
    paramString4.append(paramMessageHandler.strFileMd5);
    paramString4.append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 1, paramString4.toString());
    FileManagerUtil.c(paramString5);
    if (TextUtils.isEmpty(paramMessageHandler.Uuid))
    {
      paramMessageHandler.nWeiYunSrcType = -2;
      paramString4 = new StringBuilder();
      paramString4.append("friendUin:");
      paramString4.append(String.valueOf(paramString1));
      paramString4.append("senderuin:");
      paramString4.append(String.valueOf(paramString2));
      paramString4.append("time:");
      paramString4.append(String.valueOf(paramLong1));
      paramString4.append("seq:");
      paramString4.append(String.valueOf(paramShort));
      paramString4.append("isRead:");
      paramString4.append(String.valueOf(paramBoolean1));
      paramString4.append("isPullRoam:");
      paramString4.append(String.valueOf(paramBoolean2));
      paramString4.append("type:");
      paramString4.append(String.valueOf(paramInt1));
      paramString4.append("uuid:");
      paramString4.append(String.valueOf(paramString3));
      paramString4.append("strFileName:");
      paramString4.append(String.valueOf(paramString5));
      paramString4.append("dwFileSize:");
      paramString4.append(String.valueOf(paramLong2));
      paramString4.append("reserve:");
      paramString4.append(String.valueOf(paramInt2));
      paramString4.append("vipBubbleID:");
      paramString4.append(String.valueOf(paramLong3));
      paramString4.append("vipBubbleDiyTextID:");
      paramString4.append(String.valueOf(paramInt3));
      paramString4 = paramString4.toString();
      FileManagerUtil.a(this.a, paramMessageHandler.nSessionId, "actFileDownDetail", 0L, "", paramMessageHandler.selfUin, paramMessageHandler.Uuid, paramMessageHandler.strFileMd5, 9081L, paramString4, 0L, 0L, paramLong2, "", "", 0, "uuid null", null);
    }
    FileManagerUtil.a(this.a, paramMessageHandler);
    FileManagerUtil.a(this.a, paramString2, "", paramMessageHandler);
    if (str.equals(paramString2))
    {
      this.a.getFileManagerDataCenter().a(paramString1, 0, paramMessageHandler.uniseq);
      paramMessageHandler.nOpType = 0;
      paramMessageHandler.status = 1;
      paramMessageHandler.bSend = true;
      paramMessageHandler.isReaded = true;
      paramMessageHandler.bDelInFM = false;
      paramMessageHandler.bOnceSuccess = true;
    }
    paramMessageHandler.bDelInFM = false;
    this.a.getFileManagerDataCenter().a(paramMessageHandler);
    this.a.getFileManagerDataCenter().c(paramMessageHandler);
    FileManagerUtil.a(paramMessageHandler, this.a, null);
    if (QLog.isDevelopLevel())
    {
      paramString4 = new StringBuilder();
      paramString4.append("offline file come:fileName[");
      paramString4.append(paramString5);
      paramString4.append("],uuid[");
      paramString4.append(paramString3);
      paramString4.append("] insert To AIO");
      QLog.w("FileTransferHandler<FileAssistant>", 2, paramString4.toString());
    }
    if (!this.a.getFileManagerDataCenter().f(paramMessageHandler.nSessionId))
    {
      paramString4 = new StringBuilder();
      paramString4.append("MsgRecord is not exsited, addAIOMsg uniseq:");
      paramString4.append(paramMessageHandler.uniseq);
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramString4.toString());
      this.a.getFileManagerDataCenter().e(paramMessageHandler.nSessionId);
      paramLong1 = a(paramList, paramString1, paramString2, paramString5, paramLong2, paramBoolean1, m, (String)localObject, l, l, paramString3, paramInt1, paramMessageHandler.uniseq, paramLong4, paramLong3, paramLong1, -2005, paramInt3, paramResvAttr);
      paramList = paramMessageHandler;
      paramList.uniseq = paramLong1;
      this.a.getFileManagerDataCenter().c(paramList);
    }
    paramList = paramMessageHandler;
    paramMessageHandler = this;
    if ((QFileAssistantUtils.a(paramList.peerUin)) && (paramList.status != 16) && (QFileAssistantUtils.a(paramString2)) && (QFileAssistantUtils.a(paramMessageHandler.a, paramList.fileSize))) {
      paramMessageHandler.a.getFileManagerEngine().h(paramList);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("File Coming:");
      paramString2.append(FileManagerUtil.c(paramList));
      QLog.i("FileTransferHandler<FileAssistant>", 2, paramString2.toString());
    }
    paramMessageHandler.a.getFileManagerNotifyCenter().a(paramList.uniseq, paramList.nSessionId, paramString1, m, 17, null, 0, null);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    MsgCSBody0x346 localMsgCSBody0x346 = new MsgCSBody0x346();
    localMsgCSBody0x346.uMsgSubType = 1400;
    localMsgCSBody0x346.fileQueryReq = new FileQueryReq();
    localMsgCSBody0x346.fileQueryReq.uint64_uin = this.a.getLongAccountUin();
    localMsgCSBody0x346.fileQueryReq.bytes_uuid = paramFileManagerEntity.Uuid.getBytes();
    localMsgCSBody0x346.uint32_business_id = 3;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("newAssistant", true);
    localBundle.putString("fileKey", paramString);
    localDataLineHandler.a(paramFileManagerEntity.nSessionId, localMsgCSBody0x346, localBundle);
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int m = e;
    e = m + 1;
    localUniPacket.setRequestId(m);
    this.j.a(paramToServiceMsg, localUniPacket);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "check handleGetOffLineFileResp is not used!");
  }
  
  private void a(String paramString, long paramLong1, long paramLong2, short paramShort, int paramInt)
  {
    if (paramInt != 0) {
      ThreadManager.executeOnSubThread(new FileTransferHandler.3(this, paramString, paramInt, paramShort, paramLong1, paramLong2));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, TempSessionInfo paramTempSessionInfo, byte[] paramArrayOfByte, String paramString4, FileManagerEntity paramFileManagerEntity)
  {
    if (FMConstants.a(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "tencentdoc use new type");
      }
      paramFileManagerEntity.nFileType = 13;
      paramFileManagerEntity.bombData = paramArrayOfByte;
      paramFileManagerEntity.strThumbPath = paramString4;
      paramFileManagerEntity.nOpType = 0;
      if (paramString2.equals(paramString1)) {
        paramFileManagerEntity.nOpType = 1;
      }
      if (paramTempSessionInfo != null)
      {
        if (paramTempSessionInfo.a != -1) {
          paramFileManagerEntity.peerType = 1;
        }
        paramFileManagerEntity.TroopUin = paramTempSessionInfo.c;
      }
      paramFileManagerEntity.bDelInFM = false;
    }
  }
  
  private void a(List<MessageRecord> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt1, hummer_resv_21.ResvAttr paramResvAttr, long paramLong2, long paramLong3, short paramShort, String paramString2, int paramInt2, long paramLong4, String paramString3, String paramString4)
  {
    if ((!paramBoolean1) && (!paramString3.equalsIgnoreCase(paramString4)))
    {
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder();
        paramString4.append("Recv a file receipt file name: ");
        paramString4.append(paramString2);
        paramString4.append("type[");
        paramString4.append(paramInt2);
        paramString4.append("]. insert tips into aio");
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramString4.toString());
      }
      paramString4 = TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.a.getAccount(), paramString2, 0, null), paramLong4, 0, false, null);
      long l1 = MessageRecordFactory.a(-2005).uniseq;
      long l2 = paramShort;
      a(paramList, paramString1, paramString3, paramString2, paramLong4, paramBoolean1, 0, paramString4, l2, l2, "", paramInt2, l1, paramLong2, paramLong1, paramLong3, -3008, paramInt1, paramResvAttr);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("Recv a file receipt file name: ");
      paramList.append(paramString2);
      paramList.append("don't need to handle because isPullRoam[");
      paramList.append(paramBoolean2);
      paramList.append("],senderuin[");
      paramList.append(paramString3);
      paramList.append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramList.toString());
    }
  }
  
  private void a(List<MessageRecord> paramList, hummer_resv_21.ResvAttr paramResvAttr, long paramLong)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      if ((QFileAssistantUtils.a(localStringBuilder.toString())) && (paramResvAttr != null) && (paramResvAttr.device_type.has()))
      {
        int m = paramResvAttr.device_type.get();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramResvAttr = (MessageRecord)paramList.next();
          if (TextUtils.isEmpty(paramResvAttr.getExtInfoFromExtStr("dataline_msg_device_type"))) {
            QFileAssistantUtils.a(paramResvAttr, m);
          }
        }
      }
    }
  }
  
  private void a(hummer_resv_21.FileApkInfo paramFileApkInfo, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileApkInfo != null) && (paramFileApkInfo.str_package_name.has()))
    {
      paramFileManagerEntity.yybApkPackageName = paramFileApkInfo.str_package_name.get();
      paramFileManagerEntity.yybApkName = paramFileApkInfo.str_app_name.get();
      paramFileManagerEntity.yybApkIconUrl = paramFileApkInfo.str_icon_url.get();
    }
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    Object localObject = Long.valueOf(0L);
    int m;
    if (paramBoolean)
    {
      paramFileManagerEntity.status = 1;
      m = paramFileManagerEntity.nOpType;
      if (m != 20)
      {
        if (m != 21)
        {
          if (m != 27)
          {
            if (!QLog.isDevelopLevel()) {
              return;
            }
            throw new NullPointerException(HardCodeUtil.a(2131902581));
          }
          if ((paramFileManagerEntity.mContext instanceof IForwardCallBack))
          {
            ForwardOrderManager.a().a(this.a, paramFileManagerEntity.uniseq);
            ((IForwardCallBack)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
          }
        }
        else
        {
          paramFileManagerEntity.Uuid = paramString1;
          paramFileManagerEntity.peerType = 0;
          paramFileManagerEntity.setCloudType(1);
          this.a.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, localObject, localObject, paramString1, Long.valueOf(paramLong) });
          a(paramFileManagerEntity.peerUin, paramFileManagerEntity, null);
          this.a.getFileManagerNotifyCenter().a(paramFileManagerEntity, 6, null);
        }
      }
      else
      {
        localObject = a(paramString1);
        if (localObject != null)
        {
          paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
          paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);
        }
        else
        {
          paramFileManagerEntity.WeiYunFileId = paramString1;
        }
        paramFileManagerEntity.setCloudType(2);
        this.a.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
      }
    }
    else
    {
      m = paramFileManagerEntity.nOpType;
      if (m != 20)
      {
        if (m != 21)
        {
          if (m != 27)
          {
            if (!QLog.isDevelopLevel()) {
              return;
            }
            throw new NullPointerException(HardCodeUtil.a(2131902582));
          }
          if ((paramInt == -6101) || (paramInt == -7003))
          {
            paramFileManagerEntity.status = 16;
            if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
            {
              localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
              ((FileManagerEntity)localObject).status = 16;
              this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
              paramFileManagerEntity.mContext = null;
            }
            this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
          }
          if ((paramFileManagerEntity.mContext instanceof IForwardCallBack)) {
            ((IForwardCallBack)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
          }
        }
        else
        {
          if ((paramInt == -6101) || (paramInt == -7003))
          {
            paramFileManagerEntity.status = 16;
            if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
            {
              FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramFileManagerEntity.mContext;
              localFileManagerEntity.status = 16;
              this.a.getFileManagerDataCenter().c(localFileManagerEntity);
              paramFileManagerEntity.mContext = null;
            }
            this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
          }
          this.a.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, localObject, localObject, paramString1, Long.valueOf(paramLong) });
        }
      }
      else
      {
        if ((paramInt == -6101) || (paramInt == -7003))
        {
          paramFileManagerEntity.status = 16;
          if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
          {
            localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
            ((FileManagerEntity)localObject).status = 16;
            this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
            paramFileManagerEntity.mContext = null;
          }
          this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
        }
        this.a.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1002) || (paramInt == 1013);
  }
  
  private boolean a(int paramInt, msg_comm.Msg paramMsg)
  {
    if (!paramMsg.msg_head.has())
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("<---decodeC2CMessagePackage: msgList[");
        paramMsg.append(paramInt);
        paramMsg.append("] : msg doesn't has msgHead.");
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramMsg.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean a(long paramLong, boolean paramBoolean, List<MessageRecord> paramList, int paramInt, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead)
  {
    boolean bool1 = a(paramInt, paramMsg);
    boolean bool2 = false;
    if (!bool1)
    {
      paramInt = (short)paramMsgHead.msg_seq.get();
      long l1 = paramMsgHead.from_uin.get();
      long l2 = paramMsgHead.msg_time.get();
      long l3 = paramMsgHead.msg_uid.get();
      int m = paramMsgHead.msg_type.get();
      int n = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
      if ((!MessageUtils.d(m)) || (!paramMsgHead.c2c_cmd.has()) || (n != 169))
      {
        bool1 = bool2;
        if (m != 529) {
          break label345;
        }
        if (n != 4) {
          return false;
        }
      }
      paramMsg = new FileTransferHandler.ParseFileInfoForMsg(this, paramMsg, paramMsgHead, m, n).c();
      if (!paramMsg.a())
      {
        paramMsg = paramMsg.b();
        if (!a(paramMsg))
        {
          m = paramMsg.uint32_file_type.get();
          paramMsg.uint64_file_size.get();
          paramMsg.uint32_subcmd.get();
          if (!a(paramBoolean, m))
          {
            long l4 = paramInt;
            paramMsgHead = a(0, String.valueOf(paramLong), String.valueOf(l1), l2, l4, l3);
            if (paramMsgHead != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
              }
              paramList.add(paramMsgHead);
            }
            else
            {
              paramInt = a(l1, paramMsg, 0);
              bool1 = bool2;
              if (!a(String.valueOf(paramLong), paramMsg.bytes_file_uuid.get().toStringUtf8(), paramInt, l4, l3, paramList, String.valueOf(l1))) {
                break label345;
              }
            }
          }
        }
      }
    }
    bool1 = true;
    label345:
    return bool1;
  }
  
  private boolean a(MessageHandler paramMessageHandler, boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramMessageHandler.D().a(paramString2)) && (!paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("isPullRoam[false] and local already recv.  fileName[");
        paramMessageHandler.append(paramString1);
        paramMessageHandler.append("] uuid[");
        paramMessageHandler.append(paramString3);
        paramMessageHandler.append("] fileType[");
        paramMessageHandler.append(paramInt1);
        paramMessageHandler.append("] subCmd[");
        paramMessageHandler.append(paramInt2);
        paramMessageHandler.append("]");
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramMessageHandler.toString());
      }
      if (QLog.isDevelopLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("offline file come:fileName[");
        paramMessageHandler.append(paramString1);
        paramMessageHandler.append("] Filtered");
        QLog.w("FileTransferHandler<FileAssistant>", 2, paramMessageHandler.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    return (paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013);
  }
  
  private boolean a(ProtoReqManagerImpl.ProtoResp paramProtoResp, FileUploadInfo paramFileUploadInfo)
  {
    if (a(paramProtoResp))
    {
      paramFileUploadInfo.a = -100001;
      paramFileUploadInfo = new StringBuilder();
      paramFileUploadInfo.append("handleUploadResponse: resp is timeout[");
      paramFileUploadInfo.append(paramProtoResp.resp.getResultCode());
      paramFileUploadInfo.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramFileUploadInfo.toString());
      return true;
    }
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      paramFileUploadInfo.a = -100002;
      paramFileUploadInfo = new StringBuilder();
      paramFileUploadInfo.append("handleUploadResponse: resp is failed[");
      paramFileUploadInfo.append(paramProtoResp.resp.getResultCode());
      paramFileUploadInfo.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramFileUploadInfo.toString());
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, String paramString3)
  {
    Object localObject5 = this;
    Object localObject1 = paramList;
    String str1 = "FileTransferHandler<FileAssistant>";
    if (paramLong1 != 0L)
    {
      localObject2 = ((FileTransferHandler)localObject5).a.getFileManagerDataCenter().a(String.valueOf(paramString1), paramLong1);
      if (localObject2 != null)
      {
        if (!((FileManagerEntity)localObject2).bDelInAio)
        {
          paramString1 = ((FileTransferHandler)localObject5).a.getMessageFacade().b(String.valueOf(paramString1), ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
          if (paramString1 != null) {
            ((List)localObject1).add(paramString1);
          }
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("ol2offline duplicate msg, entity info");
          paramString1.append(FileManagerUtil.c((FileManagerEntity)localObject2));
          QLog.d("FileTransferHandler<FileAssistant>", 2, paramString1.toString());
        }
        return true;
      }
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("msgFilterByFMDB,friendUin[");
    ((StringBuilder)localObject3).append(FileManagerUtil.k(paramString1));
    ((StringBuilder)localObject3).append("],uuid[");
    ((StringBuilder)localObject3).append(paramString2);
    ((StringBuilder)localObject3).append("],olSessionId[");
    ((StringBuilder)localObject3).append(paramLong1);
    ((StringBuilder)localObject3).append("],msgSeq[");
    ((StringBuilder)localObject3).append(paramLong2);
    ((StringBuilder)localObject3).append("],msgUid[");
    ((StringBuilder)localObject3).append(paramLong3);
    ((StringBuilder)localObject3).append("],senderuin[");
    ((StringBuilder)localObject3).append(FileManagerUtil.k(paramString3));
    Object localObject2 = "]";
    ((StringBuilder)localObject3).append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
    localObject3 = "/offline";
    Object localObject4 = "";
    String str2 = paramString2.replace("/offline", "");
    localObject5 = ((FileTransferHandler)localObject5).a.getFileManagerProxy().c();
    int m = 0;
    paramString2 = (String)localObject1;
    localObject1 = localObject4;
    localObject4 = localObject5;
    while (m < ((List)localObject4).size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((List)localObject4).get(m);
      String str3 = str2.replace((CharSequence)localObject3, (CharSequence)localObject1);
      if (localFileManagerEntity.Uuid != null) {
        localObject5 = localFileManagerEntity.Uuid.replace((CharSequence)localObject3, (CharSequence)localObject1);
      } else {
        localObject5 = localObject1;
      }
      int n = localFileManagerEntity.nOpType;
      if ((n == 0) || (n == 1) || (n == 3) || (n == 7) || (n == 21)) {
        for (;;)
        {
          if ((paramLong2 == localFileManagerEntity.msgSeq) && (paramLong3 == localFileManagerEntity.msgUid))
          {
            localObject5 = this.a.getMessageFacade().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (localObject5 != null)
            {
              paramString2.add(localObject5);
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("msgSeq and msguid are all equal, duplicate msg, entity info");
                paramString1.append(FileManagerUtil.c(localFileManagerEntity));
                QLog.d(str1, 2, paramString1.toString());
              }
              return true;
            }
            paramString2 = new ArrayList();
            localObject5 = localFileManagerEntity.fileName;
            paramLong1 = localFileManagerEntity.fileSize;
            boolean bool = localFileManagerEntity.isReaded;
            long l1 = localFileManagerEntity.uniseq;
            long l2 = localFileManagerEntity.srvTime / 1000L;
            a(paramString2, paramString1, paramString3, (String)localObject5, paramLong1, bool, 0, null, paramLong2, paramLong2, str2, 0, l1, paramLong3, -1L, l2, -2005, 0, null);
            if (paramString2.size() > 0)
            {
              paramList.add((MessageRecord)paramString2.get(0));
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("msgSeq and msguid are all equal, duplicate msg, entity info");
                paramString1.append(FileManagerUtil.c(localFileManagerEntity));
                QLog.d(str1, 2, paramString1.toString());
              }
              return true;
            }
            paramString2 = paramList;
          }
          else if (((String)localObject5).equalsIgnoreCase(str3))
          {
            localObject5 = this.a.getMessageFacade().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (localObject5 != null)
            {
              paramString2.add(localObject5);
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("duplicate msg, entity info");
                paramString1.append(FileManagerUtil.c(localFileManagerEntity));
                QLog.d(str1, 2, paramString1.toString());
              }
              return true;
            }
            paramString2 = new ArrayList();
            a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, str2, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005, 0, null);
            if (paramString2.size() > 0)
            {
              paramList.add((MessageRecord)paramString2.get(0));
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("Uuid are all equal, duplicate msg, entity info");
                paramString1.append(FileManagerUtil.c(localFileManagerEntity));
                QLog.d(str1, 2, paramString1.toString());
              }
              return true;
            }
            paramString2 = paramList;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("Entity [");
        ((StringBuilder)localObject5).append(FileManagerUtil.c(localFileManagerEntity));
        ((StringBuilder)localObject5).append((String)localObject2);
        QLog.w(str1, 1, ((StringBuilder)localObject5).toString());
      }
      m += 1;
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, String paramString1, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      ArrayList localArrayList = new ArrayList();
      if (a(paramString1, paramString3, paramInt, paramShort, paramLong, localArrayList, paramString2))
      {
        if (localArrayList.size() > 0)
        {
          paramString3 = (MessageRecord)localArrayList.get(0);
          paramList.add(localArrayList.get(0));
          FileManagerUtil.b(this.a, paramString2, paramString1, paramString3.istroop);
          if (this.b == null) {
            this.b = ((AIOMessageSpreadManager)this.a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER));
          }
          if ((paramString3 instanceof MessageForFile))
          {
            paramList = (MessageForFile)paramString3;
            paramList.fileName = paramString4;
            this.b.a(paramList);
          }
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, short paramShort)
  {
    if ((paramBoolean2) && (paramBoolean1))
    {
      paramString = a(0, paramString, String.valueOf(paramLong3), paramLong2, paramShort, paramLong1);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
        }
        MessageRecord localMessageRecord = MessageRecordFactory.a(-2005);
        localMessageRecord.msgtype = -2005;
        localMessageRecord.msg = paramString.msg;
        ((MessageForFile)localMessageRecord).parse();
        localMessageRecord.uniseq = paramString.uniseq;
        paramList.add(localMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(im_msg_body.NotOnlineFile paramNotOnlineFile)
  {
    if (!paramNotOnlineFile.bytes_file_name.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    return (paramBoolean) && (paramInt == 1);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    return ((paramBoolean4) && (paramBoolean2)) || (((paramBoolean3) || (paramBoolean1)) && (paramInt < 3));
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (paramGroupFile == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "disc file is coming but file info is null!");
      return -1L;
    }
    String str2 = String.valueOf(paramLong2);
    String str3 = String.valueOf(paramLong3);
    Object localObject1;
    if (paramGroupFile.bytes_filename.has())
    {
      try
      {
        localObject1 = new String(paramGroupFile.bytes_filename.get().toByteArray(), "UTF-8");
        try
        {
          String str1 = FileManagerUtil.a((String)localObject1);
          localObject1 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1) {}
        localUnsupportedEncodingException2.printStackTrace();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localObject1 = null;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("internalDiscOfflineFile: Exception is ");
      ((StringBuilder)localObject3).append(localUnsupportedEncodingException2.toString());
      QLog.e("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = null;
    }
    long l;
    if (paramGroupFile.uint64_file_size.has()) {
      l = paramGroupFile.uint64_file_size.get();
    } else {
      l = 0L;
    }
    if (paramGroupFile.bytes_file_id.has()) {
      localObject2 = paramGroupFile.bytes_file_id.get().toByteArray();
    } else {
      localObject2 = null;
    }
    if (paramGroupFile.bytes_batch_id.has()) {
      paramGroupFile.bytes_batch_id.get().toByteArray();
    }
    if (paramGroupFile.bytes_mark.has()) {
      paramGroupFile.bytes_mark.get().toByteArray();
    }
    paramLong5 = this.a.getFileManagerDataCenter().a(3000, paramLong4, paramLong6, paramLong2, paramLong5);
    if (paramLong5 > 0L)
    {
      paramGroupFile = this.a.getFileManagerDataCenter().a(paramLong5, String.valueOf(paramLong2), 3000);
      if (paramGroupFile != null)
      {
        paramGroupFile.status = 1;
        paramGroupFile.fProgress = 1.0F;
      }
      return paramLong5;
    }
    Object localObject3 = this.a.getCurrentAccountUin();
    paramGroupFile = this.a.getFileManagerDataCenter().b(paramLong1, str2, 3000);
    paramGroupFile.setCloudType(1);
    paramGroupFile.fileName = ((String)localObject1);
    paramGroupFile.fileSize = l;
    paramGroupFile.nOpType = 1;
    paramGroupFile.peerNick = FileManagerUtil.a(this.a, str2, str3, 3000);
    paramGroupFile.peerType = 3000;
    paramGroupFile.peerUin = str2;
    paramGroupFile.selfUin = str3;
    paramGroupFile.srvTime = (1000L * paramLong6);
    paramGroupFile.status = -1;
    if (localObject2 != null) {
      paramGroupFile.Uuid = new String((byte[])localObject2);
    }
    paramGroupFile.isReaded = false;
    paramGroupFile.bSend = false;
    paramGroupFile.msgSeq = paramLong4;
    paramGroupFile.msgUid = 0L;
    paramGroupFile.imgHeight = paramInt2;
    paramGroupFile.imgWidth = paramInt1;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("=_=k recv DiscFile Id[");
    ((StringBuilder)localObject2).append(paramGroupFile.nSessionId);
    ((StringBuilder)localObject2).append("],File[");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    FileManagerUtil.c((String)localObject1);
    if ((paramGroupFile.Uuid == null) || (paramGroupFile.Uuid.length() == 0)) {
      paramGroupFile.nWeiYunSrcType = -2;
    }
    FileManagerUtil.a(this.a, paramGroupFile);
    if (((String)localObject3).equals(String.valueOf(paramLong3)))
    {
      this.a.getFileManagerDataCenter().a(str3, 3000, paramLong1);
      paramGroupFile.nOpType = 7;
      paramGroupFile.peerNick = this.a.getApplication().getString(2131889564);
      paramGroupFile.bSend = true;
      paramGroupFile.isReaded = true;
      paramGroupFile.bOnceSuccess = true;
    }
    this.a.getFileManagerDataCenter().a(paramGroupFile);
    FileManagerUtil.a(paramGroupFile, this.a, null);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("File Coming:");
      ((StringBuilder)localObject1).append(FileManagerUtil.c(paramGroupFile));
      QLog.i("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    FileManagerUtil.b(this.a, String.valueOf(paramLong3), str2, 3000);
    this.a.getFileManagerNotifyCenter().a(paramLong1, paramGroupFile.nSessionId, str2, 3000, 17, null, 0, null);
    return paramLong1;
  }
  
  private Cmd0x346CSBody b(OfflineFileUploadPara paramOfflineFileUploadPara)
  {
    Cmd0x346CSBody localCmd0x346CSBody = new Cmd0x346CSBody();
    localCmd0x346CSBody.c = new ApplyUploadHitReqV2();
    paramOfflineFileUploadPara.a = paramOfflineFileUploadPara.a.replace("+", "");
    long l = Long.parseLong(this.a.getCurrentAccountUin());
    localCmd0x346CSBody.c.a = l;
    localCmd0x346CSBody.c.b = Long.parseLong(paramOfflineFileUploadPara.a);
    localCmd0x346CSBody.c.c = paramOfflineFileUploadPara.b;
    localCmd0x346CSBody.c.d = new String(paramOfflineFileUploadPara.f);
    localCmd0x346CSBody.c.h = new String(paramOfflineFileUploadPara.e);
    localCmd0x346CSBody.c.e = paramOfflineFileUploadPara.g;
    localCmd0x346CSBody.c.g = paramOfflineFileUploadPara.i;
    localCmd0x346CSBody.c.f = paramOfflineFileUploadPara.j;
    return localCmd0x346CSBody;
  }
  
  private ToServiceMsg b(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), paramString);
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (((paramString2 == null) || (paramString2.length() < 1)) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forward offline to weiyun ,but weiyun fileid is null! retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("retMsg[");
      ((StringBuilder)localObject).append(String.valueOf(paramString1));
      ((StringBuilder)localObject).append("]");
      QLog.w("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramFileManagerEntity.status = 1;
      paramFileManagerEntity.setCloudType(2);
    }
    else
    {
      paramFileManagerEntity.status = 0;
    }
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      paramFileManagerEntity.status = 16;
      if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
      {
        localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
        ((FileManagerEntity)localObject).status = 16;
        this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
        paramFileManagerEntity.mContext = null;
      }
      this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
    }
    Object localObject = a(paramString2);
    if (localObject != null)
    {
      paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
      paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);
    }
    else
    {
      paramFileManagerEntity.WeiYunFileId = paramString2;
    }
    this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg);
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), FileTransferServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.a.startServlet(localNewIntent);
    long l = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    int m = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = m;
    a(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.m, localStatictisInfo });
  }
  
  private FileTransferHandler.OlFileInfo c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      int m = paramArrayOfByte.length;
      FileTransferHandler.OlFileInfo localOlFileInfo = new FileTransferHandler.OlFileInfo(null);
      if (m >= 16)
      {
        int i1 = PkgTools.getShortData(paramArrayOfByte, 0);
        byte[] arrayOfByte1 = new byte[i1];
        int n = 2 + i1;
        if (m >= n)
        {
          PkgTools.getBytesData(paramArrayOfByte, 2, arrayOfByte1, i1);
          try
          {
            localOlFileInfo.a = new String(arrayOfByte1, "UTF-16LE");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeOnlineFileInfo: Exception is ");
            localStringBuilder.append(localUnsupportedEncodingException.toString());
            QLog.e("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
          }
          i1 = n + 4;
          if (m >= i1)
          {
            long l = PkgTools.getLongData(paramArrayOfByte, n);
            n = i1 + 2;
            if (m >= n)
            {
              i1 = PkgTools.getShortData(paramArrayOfByte, i1);
              byte[] arrayOfByte2 = new byte[i1];
              int i2 = n + i1;
              if (m >= i2)
              {
                PkgTools.getBytesData(paramArrayOfByte, n, arrayOfByte2, i1);
                if (m >= i2 + 4)
                {
                  localOlFileInfo.b = ((PkgTools.getLongData(paramArrayOfByte, i2) << 32) + l);
                  return localOlFileInfo;
                }
                QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
                return null;
              }
              QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
              return null;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
            return null;
          }
          QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
          return null;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
        return null;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
    }
    return null;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {
      try
      {
        paramToServiceMsg = this.k.a(paramToServiceMsg, paramFromServiceMsg);
        return paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(this.k.getClass().getSimpleName());
          paramFromServiceMsg.append(" decode error,");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d("FileTransferHandler<FileAssistant>", 2, paramFromServiceMsg.toString());
        }
      }
    }
    return null;
  }
  
  private void c(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString2)) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forward offline to weiyun ,but weiyun fileid is null! retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("retMsg[");
      ((StringBuilder)localObject).append(String.valueOf(paramString1));
      ((StringBuilder)localObject).append("]");
      QLog.w("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {
      paramFileManagerEntity.status = 1;
    } else {
      paramFileManagerEntity.status = 0;
    }
    if (paramBoolean)
    {
      paramFileManagerEntity.Uuid = paramString2;
      paramFileManagerEntity.setCloudType(1);
      paramFileManagerEntity.peerType = 3000;
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, this.a.getCurrentAccountUin(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramString2, paramFileManagerEntity.uniseq, paramFileManagerEntity.msgUid, null);
    }
    int m = paramInt;
    if ((m != -6101) && (m != -7003)) {
      break label276;
    }
    paramFileManagerEntity.status = 16;
    if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
    {
      localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
      ((FileManagerEntity)localObject).status = 16;
      this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
      paramFileManagerEntity.mContext = null;
    }
    this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
    label276:
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString1, Long.valueOf(0L), Long.valueOf(0L), paramString2, Long.valueOf(paramLong) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo != null) && (paramOffLineFileInfo.b == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
      }
      int m = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = m;
      localStatictisInfo.a = paramFromServiceMsg.getAppSeq();
      a(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private boolean c(String paramString)
  {
    Iterator localIterator = this.a.getFileManagerProxy().b().iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.replace("/offline", "").equalsIgnoreCase(paramString.replace("/offline", ""))))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "uuid is compare memory!");
        return true;
      }
    }
    return false;
  }
  
  private boolean c(SubMsgType0x4.WlanRecvNotify paramWlanRecvNotify)
  {
    if (!paramWlanRecvNotify.uint64_session_id.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no session_id");
      return false;
    }
    if (!paramWlanRecvNotify.uint32_send_client_type.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no send_type");
      return false;
    }
    if (!paramWlanRecvNotify.uint32_target_client_type.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no recv_type");
      return false;
    }
    if (!paramWlanRecvNotify.str_file_name.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no file_name");
      return false;
    }
    if (!paramWlanRecvNotify.uint64_file_size.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no file_size");
      return false;
    }
    if (!paramWlanRecvNotify.uint32_time.has())
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no time");
      return false;
    }
    return true;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int m = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleReqOffFilePackError, count: ");
      ((StringBuilder)localObject).append(m);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (m < 3)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", m + 1);
      b(paramToServiceMsg);
      return;
    }
    Object localObject = new StatictisInfo();
    ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
    ((StatictisInfo)localObject).c = m;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      ((StatictisInfo)localObject).b = 2900;
      ((StatictisInfo)localObject).d = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    ((StatictisInfo)localObject).e = BaseMessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    m = paramToServiceMsg.extraData.getInt("offfile_type");
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return;
          }
          a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localObject });
          return;
        }
        a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localObject });
        return;
      }
      a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localObject });
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo != null) && (paramOffLineFileInfo.b == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
      }
      int m = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = m;
      a(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void h(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = a(paramProtoResp);
    Object localObject1 = "FileTransferHandler<FileAssistant>";
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleQueryRecvListResponse: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleQueryRecvListResponse: resp is failed[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      Object localObject2 = paramProtoResp.resp.getWupBuffer();
      paramProtoResp = new cmd0x346.RspBody();
      try
      {
        paramProtoResp.mergeFrom((byte[])localObject2);
        if (!paramProtoResp.msg_recv_list_query_rsp.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: rspBody has not msg_recv_list_query_rsp");
        }
        else
        {
          localObject2 = (cmd0x346.RecvListQueryRsp)paramProtoResp.msg_recv_list_query_rsp.get();
          if (((cmd0x346.RecvListQueryRsp)localObject2).int32_ret_code.has())
          {
            int m = ((cmd0x346.RecvListQueryRsp)localObject2).int32_ret_code.get();
            if (m != 0)
            {
              paramProtoResp = new StringBuilder();
              paramProtoResp.append("handleQueryRecvListResponse: failed retCode[");
              paramProtoResp.append(m);
              paramProtoResp.append("]");
              QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
              break label661;
            }
          }
          if (paramProtoResp.uint32_flag_use_media_platform.has())
          {
            if (paramProtoResp.uint32_flag_use_media_platform.get() == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramProtoResp = new StringBuilder();
            paramProtoResp.append("handleQueryRecvListResponse: bUseMediaPlatform ");
            paramProtoResp.append(bool1);
            QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
          }
          else
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            bool1 = false;
          }
          Iterator localIterator = ((cmd0x346.RecvListQueryRsp)localObject2).rpt_msg_file_list.get().iterator();
          paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
          while (localIterator.hasNext())
          {
            Object localObject3 = (cmd0x346.FileInfo)localIterator.next();
            localObject1 = new OfflineFileInfo();
            ((OfflineFileInfo)localObject1).a = false;
            ((OfflineFileInfo)localObject1).e = ((cmd0x346.FileInfo)localObject3).uint32_danger_evel.get();
            ((OfflineFileInfo)localObject1).g = ((cmd0x346.FileInfo)localObject3).uint64_file_size.get();
            ((OfflineFileInfo)localObject1).h = (MessageCache.c() * 1000L + ((cmd0x346.FileInfo)localObject3).uint32_life_time.get() * 1000L);
            ((OfflineFileInfo)localObject1).i = (((cmd0x346.FileInfo)localObject3).uint32_upload_time.get() * 1000L);
            ((OfflineFileInfo)localObject1).f = ((cmd0x346.FileInfo)localObject3).str_file_name.get();
            ((OfflineFileInfo)localObject1).b = new String(((cmd0x346.FileInfo)localObject3).bytes_uuid.get().toByteArray());
            if (bool1) {
              ((OfflineFileInfo)localObject1).c = ((cmd0x346.FileInfo)localObject3).str_fileidcrc.get();
            }
            ((OfflineFileInfo)localObject1).d = ((cmd0x346.FileInfo)localObject3).uint64_uin.get();
            ((OfflineFileInfo)localObject1).j = HexUtil.bytes2HexStr(((cmd0x346.FileInfo)localObject3).bytes_md5.get().toByteArray());
            localArrayList.add(localObject1);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleQueryRecvListResponse OfflineFileInfo[");
              ((StringBuilder)localObject3).append(((OfflineFileInfo)localObject1).toString());
              ((StringBuilder)localObject3).append("]");
              QLog.d(paramProtoResp, 2, ((StringBuilder)localObject3).toString());
            }
          }
          if (((cmd0x346.RecvListQueryRsp)localObject2).uint32_is_end.get() > 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          bool2 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
      }
    }
    label661:
    boolean bool2 = false;
    bool1 = true;
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5021, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
  }
  
  private void i(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = a(paramProtoResp);
    Object localObject1 = "FileTransferHandler<FileAssistant>";
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleQuerySendListResponse: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleQuerySendListResponse: resp is failed[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      Object localObject2 = paramProtoResp.resp.getWupBuffer();
      paramProtoResp = new cmd0x346.RspBody();
      try
      {
        paramProtoResp.mergeFrom((byte[])localObject2);
        if (!paramProtoResp.msg_send_list_query_rsp.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: rspBody has not msg_send_list_query_rsp");
        }
        else
        {
          localObject2 = (cmd0x346.SendListQueryRsp)paramProtoResp.msg_send_list_query_rsp.get();
          if (((cmd0x346.SendListQueryRsp)localObject2).int32_ret_code.has())
          {
            int m = ((cmd0x346.SendListQueryRsp)localObject2).int32_ret_code.get();
            if (m != 0)
            {
              paramProtoResp = new StringBuilder();
              paramProtoResp.append("handleQuerySendListResponse: failed retCode[");
              paramProtoResp.append(m);
              paramProtoResp.append("]");
              QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
              break label661;
            }
          }
          if (paramProtoResp.uint32_flag_use_media_platform.has())
          {
            if (paramProtoResp.uint32_flag_use_media_platform.get() == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramProtoResp = new StringBuilder();
            paramProtoResp.append("handleQuerySendListResponse: bUseMediaPlatform ");
            paramProtoResp.append(bool1);
            QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
          }
          else
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            bool1 = false;
          }
          Iterator localIterator = ((cmd0x346.SendListQueryRsp)localObject2).rpt_msg_file_list.get().iterator();
          paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
          while (localIterator.hasNext())
          {
            Object localObject3 = (cmd0x346.FileInfo)localIterator.next();
            localObject1 = new OfflineFileInfo();
            ((OfflineFileInfo)localObject1).a = true;
            ((OfflineFileInfo)localObject1).e = ((cmd0x346.FileInfo)localObject3).uint32_danger_evel.get();
            ((OfflineFileInfo)localObject1).g = ((cmd0x346.FileInfo)localObject3).uint64_file_size.get();
            ((OfflineFileInfo)localObject1).h = (MessageCache.c() * 1000L + ((cmd0x346.FileInfo)localObject3).uint32_life_time.get() * 1000L);
            ((OfflineFileInfo)localObject1).i = (((cmd0x346.FileInfo)localObject3).uint32_upload_time.get() * 1000L);
            ((OfflineFileInfo)localObject1).f = ((cmd0x346.FileInfo)localObject3).str_file_name.get();
            ((OfflineFileInfo)localObject1).b = new String(((cmd0x346.FileInfo)localObject3).bytes_uuid.get().toByteArray());
            if (bool1) {
              ((OfflineFileInfo)localObject1).c = ((cmd0x346.FileInfo)localObject3).str_fileidcrc.get();
            }
            ((OfflineFileInfo)localObject1).d = ((cmd0x346.FileInfo)localObject3).uint64_uin.get();
            ((OfflineFileInfo)localObject1).j = HexUtil.bytes2HexStr(((cmd0x346.FileInfo)localObject3).bytes_md5.get().toByteArray());
            localArrayList.add(localObject1);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleQuerySendListResponse OfflineFileInfo[");
              ((StringBuilder)localObject3).append(((OfflineFileInfo)localObject1).toString());
              ((StringBuilder)localObject3).append("]");
              QLog.d(paramProtoResp, 2, ((StringBuilder)localObject3).toString());
            }
          }
          if (((cmd0x346.SendListQueryRsp)localObject2).uint32_is_end.get() > 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          bool2 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
      }
    }
    label661:
    boolean bool2 = false;
    bool1 = true;
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5022, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
  }
  
  private void j(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    boolean bool1;
    Object localObject2;
    if (!a(paramProtoResp, localFileUploadInfo))
    {
      Object localObject1 = paramProtoResp.resp.getWupBuffer();
      localFileUploadInfo.t = ((byte[])localObject1);
      localObject3 = new cmd0x346.RspBody();
      try
      {
        ((cmd0x346.RspBody)localObject3).mergeFrom((byte[])localObject1);
        if (!((cmd0x346.RspBody)localObject3).msg_apply_upload_rsp.has())
        {
          localFileUploadInfo.a = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        }
        else
        {
          localObject1 = a(localFileUploadInfo, null, (cmd0x346.RspBody)localObject3);
          bool1 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    else
    {
      localObject2 = null;
      bool1 = false;
    }
    if ((localFileUploadInfo.a == 0) && ((localFileUploadInfo.f == null) || (localFileUploadInfo.f.length() == 0))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((localFileUploadInfo.f != null) && (localFileUploadInfo.f.length() > 0)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((localFileUploadInfo.a != -91245) && (localFileUploadInfo.a != -7010)) {
      bool4 = false;
    } else {
      bool4 = true;
    }
    boolean bool5;
    if ((localFileUploadInfo.h != null) && (localFileUploadInfo.h.length != 0)) {
      bool5 = false;
    } else {
      bool5 = true;
    }
    Object localObject3 = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    if (a(bool2, bool3, bool4, bool5, ((FileTransferHandler.PreviewBusiData)localObject3).g()))
    {
      ((FileTransferHandler.PreviewBusiData)localObject3).h();
      a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (FileTransferHandler.PreviewBusiData)localObject3);
      return;
    }
    paramProtoReq = new StatictisInfo();
    paramProtoReq.b = localFileUploadInfo.a;
    paramProtoReq.c = paramProtoResp.freeRunnalbleIndex;
    boolean bool2 = bool1;
    if (bool5)
    {
      bool2 = bool1;
      if (bool3)
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("uuid_null[");
        paramProtoResp.append(localFileUploadInfo.toString());
        paramProtoResp.append("]");
        localFileUploadInfo.b = paramProtoResp.toString();
        bool2 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("decodeOffFilePBResponse:return ");
      paramProtoResp.append(bool2);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      paramProtoResp.append(", totalSpace=");
      paramProtoResp.append(localFileUploadInfo.c);
      paramProtoResp.append(", usedSpace=");
      paramProtoResp.append(localFileUploadInfo.d);
      paramProtoResp.append(", ip=");
      paramProtoResp.append(localFileUploadInfo.f);
      paramProtoResp.append(", port=");
      paramProtoResp.append(localFileUploadInfo.g);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)localObject3).e(), 5004, bool2, new Object[] { localFileUploadInfo, paramProtoReq, localObject2 });
  }
  
  private void k(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    Object localObject;
    if (a(paramProtoResp))
    {
      localFileUploadInfo.a = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUploadSuccResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localFileUploadInfo.a = -100002;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUploadSuccResponse: resp is failed[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = paramProtoResp.resp.getWupBuffer();
      cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (!localRspBody.msg_upload_succ_rsp.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.a = -100003;
        }
        else
        {
          localObject = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
          if (((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.has()) {
            localFileUploadInfo.a = ((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.get();
          }
          if (((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.has()) {
            localFileUploadInfo.b = ((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.get();
          }
          bool = true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    boolean bool = false;
    if (localFileUploadInfo.a != 0) {
      bool = false;
    }
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = localFileUploadInfo.a;
    localStatictisInfo.c = paramProtoResp.freeRunnalbleIndex;
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("handleUploadSuccResponse: return ");
      paramProtoResp.append(bool);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5005, bool, new Object[] { localFileUploadInfo, localStatictisInfo });
  }
  
  private void l(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    paramProtoReq = new face2face_file.msg();
    Object localObject = this.a.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    StringBuilder localStringBuilder;
    long l1;
    if (a(paramProtoResp))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleResistTerrorist: resp is timeout[");
      localStringBuilder.append(paramProtoResp.resp.getResultCode());
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      l1 = -100001L;
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleResistTerrorist: resp is failed[");
      localStringBuilder.append(paramProtoResp.resp.getResultCode());
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      l1 = -100002L;
    }
    else
    {
      paramProtoResp = paramProtoResp.resp.getWupBuffer();
      try
      {
        paramProtoReq.mergeFrom(paramProtoResp);
        l1 = 0L;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        l1 = -100003L;
      }
    }
    paramProtoResp = ((SharedPreferences)localObject).edit();
    if ((paramProtoReq.has()) && (paramProtoReq.result.has()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleResistTerrorist: return resMessage.result:");
        ((StringBuilder)localObject).append(paramProtoReq.result.get());
        QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      paramProtoResp.putInt("QlinkResistTerrorist_res", paramProtoReq.result.get());
      paramProtoResp.putLong("SettingQlinkResistTerroristLastTime", MessageCache.c());
      paramProtoResp.putString("SettingQlinkResistTerroristLastAccount", this.a.getCurrentAccountUin());
    }
    paramProtoResp.commit();
    long l2;
    if (l1 == -100001L)
    {
      l2 = 9043L;
    }
    else
    {
      l2 = l1;
      if (l1 == -100003L) {
        l2 = 9045L;
      }
    }
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("handleResistTerrorist: return ");
      paramProtoResp.append(paramProtoReq.result);
      paramProtoResp.append(" ,retCode:");
      paramProtoResp.append(l2);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
  }
  
  private void m(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    int m = -100003;
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    if (bool)
    {
      m = -100001;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRemoveResponse: resp is timeout[");
      localStringBuilder.append(paramProtoResp.resp.getResultCode());
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    }
    for (;;)
    {
      bool = false;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleRemoveResponse: resp is failed[");
        localStringBuilder.append(paramProtoResp.resp.getResultCode());
        localStringBuilder.append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (!localRspBody.msg_delete_file_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          }
          else
          {
            localObject = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
            if (((cmd0x346.DeleteFileRsp)localObject).int32_ret_code.has()) {
              m = ((cmd0x346.DeleteFileRsp)localObject).int32_ret_code.get();
            } else {
              m = 0;
            }
            paramProtoResp = localStringBuilder;
            if (((cmd0x346.DeleteFileRsp)localObject).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x346.DeleteFileRsp)localObject).str_ret_msg.get();
            }
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
        }
      }
    }
    if (m != 0) {
      bool = false;
    }
    paramProtoReq = ((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).f();
    localObject = ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(paramProtoReq);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRemoveResponse, bSuccess[");
    localStringBuilder.append(String.valueOf(bool));
    localStringBuilder.append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    if (localObject != null) {
      this.a.getFileManagerNotifyCenter().a(bool, 20, new Object[] { Integer.valueOf(m), paramProtoResp, paramProtoReq, ((WeiYunFileInfo)localObject).c, Boolean.valueOf(true) });
    }
  }
  
  private void n(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    FileTransferHandler.PreviewBusiData localPreviewBusiData = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    switch (localPreviewBusiData.d())
    {
    case 9: 
    default: 
      paramProtoReq = new StringBuilder();
      paramProtoReq.append("handleDiscGetFileInfo: subcmd[");
      paramProtoReq.append(localPreviewBusiData.d());
      paramProtoReq.append("] is not implemented");
      QLog.e("FileTransferHandler<FileAssistant>", 1, paramProtoReq.toString());
      return;
    case 10: 
      w(paramProtoReq, paramProtoResp);
      return;
    case 8: 
      p(paramProtoReq, paramProtoResp);
      return;
    case 7: 
      q(paramProtoReq, paramProtoResp);
      return;
    case 6: 
      o(paramProtoReq, paramProtoResp);
      return;
    case 3: 
      r(paramProtoReq, paramProtoResp);
      return;
    case 2: 
      t(paramProtoReq, paramProtoResp);
      return;
    case 1: 
      s(paramProtoReq, paramProtoResp);
    }
  }
  
  private void o(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    int n = -100003;
    Object localObject1 = "";
    int m;
    Object localObject2;
    if (bool)
    {
      m = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("internalForwardDisc2Disc: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      bool = false;
      localObject2 = null;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
      localObject1 = localObject2;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("internalForwardDisc2Disc: resp is failed[");
        ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject2).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (((cmd0x345.RspBody)localObject2).uint32_return_code.has()) {
            m = ((cmd0x345.RspBody)localObject2).uint32_return_code.get();
          } else {
            m = 0;
          }
          if (!((cmd0x345.RspBody)localObject2).msg_subcmd_0x5_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
            m = n;
          }
          else
          {
            localObject2 = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject2).msg_subcmd_0x5_rsp_body.get();
            paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
            if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject2).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject2).str_ret_msg.get();
            }
            if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject2).str_file_id.has()) {
              localObject1 = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject2).str_file_id.get();
            } else {
              localObject1 = null;
            }
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = n;
        }
      }
    }
    if (m != 0) {
      bool = false;
    }
    if (localObject1 == null) {
      bool = false;
    }
    long l = ((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).c();
    paramProtoReq = this.a.getFileManagerDataCenter().a(l);
    if (paramProtoReq == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
    }
    if (bool)
    {
      paramProtoReq.Uuid = ((String)localObject1);
      paramProtoReq.setCloudType(1);
      this.a.getFileManagerNotifyCenter().a(bool, 19, new Object[] { Integer.valueOf(m), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), localObject1, Long.valueOf(l) });
      a(l, paramProtoReq.peerUin, this.a.getCurrentAccountUin(), paramProtoReq.fileName, paramProtoReq.fileSize, (String)localObject1, paramProtoReq.uniseq, paramProtoReq.msgUid, null);
      this.a.getFileManagerNotifyCenter().a(paramProtoReq, 6, null);
    }
    else
    {
      localObject2 = paramProtoReq;
      ((FileManagerEntity)localObject2).status = 0;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("nId[");
      ((StringBuilder)localObject3).append(l);
      ((StringBuilder)localObject3).append("],forward disc2disc faild, retCode[");
      ((StringBuilder)localObject3).append(m);
      ((StringBuilder)localObject3).append("], retMsg[");
      ((StringBuilder)localObject3).append(paramProtoResp);
      ((StringBuilder)localObject3).append("]");
      QLog.e("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
      if ((m == -6101) || (m == -7003))
      {
        ((FileManagerEntity)localObject2).status = 16;
        if ((((FileManagerEntity)localObject2).mContext != null) && ((((FileManagerEntity)localObject2).mContext instanceof FileManagerEntity)))
        {
          localObject3 = (FileManagerEntity)((FileManagerEntity)localObject2).mContext;
          ((FileManagerEntity)localObject3).status = 16;
          this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject3);
          ((FileManagerEntity)localObject2).mContext = null;
        }
        this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
      }
      this.a.getFileManagerNotifyCenter().a(bool, 19, new Object[] { Integer.valueOf(m), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), localObject1, Long.valueOf(l) });
    }
    this.a.getFileManagerDataCenter().c(paramProtoReq);
  }
  
  private void p(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    int n = -100003;
    Object localObject2 = "";
    int m;
    Object localObject1;
    if (bool)
    {
      m = -100001;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("internalPreviewDiscFile: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    String str2;
    String str1;
    Object localObject4;
    short s;
    Object localObject3;
    for (;;)
    {
      str2 = "";
      str1 = str2;
      localObject1 = str1;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
      localObject4 = paramProtoResp;
      bool = false;
      n = 0;
      localObject5 = null;
      s = 0;
      localObject3 = paramProtoResp;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject5;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("internalPreviewDiscFile: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject1 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject1).mergeFrom(paramProtoResp);
          if (((cmd0x345.RspBody)localObject1).uint32_return_code.has()) {
            m = ((cmd0x345.RspBody)localObject1).uint32_return_code.get();
          } else {
            m = 0;
          }
          if (!((cmd0x345.RspBody)localObject1).msg_subcmd_0x7_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
            m = n;
          }
          else
          {
            cmd0x345.RspBody.SubCmd0x7RspBody localSubCmd0x7RspBody = (cmd0x345.RspBody.SubCmd0x7RspBody)((cmd0x345.RspBody)localObject1).msg_subcmd_0x7_rsp_body.get();
            str2 = localSubCmd0x7RspBody.str_server_ip.get();
            str1 = localSubCmd0x7RspBody.str_dns.get();
            n = localSubCmd0x7RspBody.uint32_server_port.get();
            localObject5 = localSubCmd0x7RspBody.str_url.get();
            localObject3 = localSubCmd0x7RspBody.str_ret_msg.get();
            paramProtoResp = new StringBuilder();
            paramProtoResp.append("FTN5K=");
            paramProtoResp.append(localSubCmd0x7RspBody.bytes_cookie.get().toStringUtf8());
            localObject4 = paramProtoResp.toString();
            if (localSubCmd0x7RspBody.str_https_domain.has()) {
              paramProtoResp = localSubCmd0x7RspBody.str_https_domain.get();
            } else {
              paramProtoResp = null;
            }
            if (localSubCmd0x7RspBody.uint32_https_port.has()) {
              s = (short)localSubCmd0x7RspBody.uint32_https_port.get();
            } else {
              s = 0;
            }
            localObject1 = localObject2;
            if (localSubCmd0x7RspBody.str_dns.has()) {
              localObject1 = localSubCmd0x7RspBody.str_dns.get();
            }
            bool = true;
            localObject2 = localObject1;
            localObject1 = localObject5;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = n;
        }
      }
    }
    if (m != 0) {
      bool = false;
    }
    Object localObject5 = new Bundle();
    if (paramProtoResp != null) {
      ((Bundle)localObject5).putString("strHttpsDomain", paramProtoResp);
    }
    ((Bundle)localObject5).putShort("httpsPort", s);
    ((Bundle)localObject5).putString("IPv6Dns", (String)localObject2);
    paramProtoReq = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    if (paramProtoReq.a())
    {
      long l = paramProtoReq.c();
      this.a.getFileManagerNotifyCenter().a(bool, 192, new Object[] { Integer.valueOf(m), localObject3, localObject4, localObject1, str2, str1, Integer.valueOf(n), null, Long.valueOf(l), localObject5 });
      return;
    }
    this.a.getFileManagerNotifyCenter().a(bool, 21, new Object[] { Integer.valueOf(m), localObject3, localObject4, localObject1, str2, str1, Integer.valueOf(n), localObject5 });
  }
  
  private void q(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    Object localObject = "";
    cmd0x345.RspBody.SubCmd0x6RspBody localSubCmd0x6RspBody = null;
    StringBuilder localStringBuilder = null;
    int m;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("internalForwardDiscFile: resp is timeout[");
      localStringBuilder.append(paramProtoResp.resp.getResultCode());
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      m = -100001;
    }
    for (;;)
    {
      bool = false;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject;
      localObject = localSubCmd0x6RspBody;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("internalForwardDiscFile: resp is failed[");
        localStringBuilder.append(paramProtoResp.resp.getResultCode());
        localStringBuilder.append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
        m = -100002;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.uint32_return_code.has()) {
            m = localRspBody.uint32_return_code.get();
          } else {
            m = 0;
          }
          if (!localRspBody.msg_subcmd_0x6_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
          }
          else
          {
            localSubCmd0x6RspBody = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();
            paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject;
            if (localSubCmd0x6RspBody.str_ret_msg.has()) {
              paramProtoResp = localSubCmd0x6RspBody.str_ret_msg.get();
            }
            localObject = localStringBuilder;
            if (localSubCmd0x6RspBody.str_file_id.has()) {
              localObject = localSubCmd0x6RspBody.str_file_id.get();
            }
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = -100003;
        }
      }
    }
    if (m != 0) {
      bool = false;
    }
    if (localObject == null) {
      bool = false;
    }
    long l = ((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).c();
    paramProtoReq = this.a.getFileManagerDataCenter().a(l);
    if (paramProtoReq == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
    }
    paramProtoReq.status = 0;
    a(bool, paramProtoReq, (String)localObject, m, paramProtoResp, l);
    this.a.getFileManagerDataCenter().c(paramProtoReq);
  }
  
  private void r(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    Bundle localBundle = new Bundle();
    boolean bool = a(paramProtoResp.resp.getResultCode());
    String str2 = "";
    int m = 80;
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    Object localObject1;
    long l1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("internalDownloadDiscFile: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      l1 = -100001L;
    }
    short s;
    for (;;)
    {
      localObject1 = "";
      s = 0;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("internalDownloadDiscFile: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        l1 = -100002L;
      }
      else
      {
        localObject1 = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject2).mergeFrom((byte[])localObject1);
          if (((cmd0x345.RspBody)localObject2).uint32_return_code.has()) {
            l1 = ((cmd0x345.RspBody)localObject2).uint32_return_code.get();
          } else {
            l1 = 0L;
          }
          if (!((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
          }
          else
          {
            localObject1 = new FileTransferHandler.DiscDownloadInfo(this, l1, "", 80, "", "", "", "", (short)0, "", localBundle, (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.get()).j();
            l1 = ((FileTransferHandler.DiscDownloadInfo)localObject1).a();
            str2 = ((FileTransferHandler.DiscDownloadInfo)localObject1).b();
            m = ((FileTransferHandler.DiscDownloadInfo)localObject1).c();
            str1 = ((FileTransferHandler.DiscDownloadInfo)localObject1).d();
            str3 = ((FileTransferHandler.DiscDownloadInfo)localObject1).e();
            str4 = ((FileTransferHandler.DiscDownloadInfo)localObject1).f();
            str5 = ((FileTransferHandler.DiscDownloadInfo)localObject1).g();
            s = ((FileTransferHandler.DiscDownloadInfo)localObject1).h();
            localObject1 = ((FileTransferHandler.DiscDownloadInfo)localObject1).i();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          l1 = -100003L;
        }
      }
    }
    Object localObject2 = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    long l2;
    if (l1 == -100001L) {
      l2 = 9043L;
    }
    for (;;)
    {
      break;
      if (l1 == -100003L)
      {
        l2 = 9045L;
      }
      else
      {
        int n;
        if ((l1 == 0L) && (str2 == null)) {
          n = 1;
        } else {
          n = 0;
        }
        int i1 = ((FileTransferHandler.PreviewBusiData)localObject2).g();
        l2 = l1;
        if (n != 0)
        {
          l2 = l1;
          if (i1 < 3)
          {
            ((FileTransferHandler.PreviewBusiData)localObject2).h();
            a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (FileTransferHandler.PreviewBusiData)localObject2);
            return;
          }
        }
      }
    }
    if ((str2 != null) && (str2.length() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("internalDownloadDiscFile: return ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", retCode=");
      localStringBuilder.append(l2);
      localStringBuilder.append(", strHost=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", strCheckSum=");
      if (str1 != null) {
        paramProtoReq = str1;
      } else {
        paramProtoReq = "";
      }
      localStringBuilder.append(paramProtoReq);
      localStringBuilder.append(", strCookie=");
      localStringBuilder.append(str3);
      localStringBuilder.append(", port=");
      localStringBuilder.append(m);
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    }
    localBundle.putShort("httpsPort", s);
    localBundle.putString("IPv6Dns", localInvalidProtocolBufferMicroException);
    a(((FileTransferHandler.PreviewBusiData)localObject2).e(), 5013, bool, new Object[] { Long.valueOf(l2), str4, str5, str2, Integer.valueOf(m), str1, str3, Integer.valueOf(paramProtoResp.resp.getAppSeq()), Long.valueOf(((FileTransferHandler.PreviewBusiData)localObject2).c()), localBundle });
  }
  
  private void s(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    long l;
    if (a(paramProtoResp))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("internalSendDiscFileRequest: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      localObject3 = "";
      localObject4 = localObject3;
      localObject5 = localObject4;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject5;
      localObject1 = paramProtoResp;
      localObject2 = localObject1;
      l = -100001L;
    }
    Object localObject7;
    int m;
    boolean bool;
    String str;
    short s;
    Object localObject6;
    for (;;)
    {
      localObject7 = "";
      m = 0;
      bool = false;
      str = null;
      s = 0;
      localObject6 = paramProtoResp;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject2;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("internalSendDiscFileRequest: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        localObject3 = "";
        localObject4 = localObject3;
        localObject5 = localObject4;
        paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject5;
        localObject1 = paramProtoResp;
        localObject2 = localObject1;
        l = -100002L;
      }
      else
      {
        localObject1 = paramProtoResp.resp.getWupBuffer();
        paramProtoResp = new cmd0x345.RspBody();
        try
        {
          paramProtoResp.mergeFrom((byte[])localObject1);
          if (paramProtoResp.uint32_return_code.has()) {
            l = paramProtoResp.uint32_return_code.get();
          } else {
            l = 0L;
          }
          localObject6 = "";
          if (!paramProtoResp.msg_subcmd_0x1_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
          }
          else
          {
            localObject7 = (cmd0x345.RspBody.SubCmd0x1RspBody)paramProtoResp.msg_subcmd_0x1_rsp_body.get();
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_id.has()) {
              localObject1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_id.get();
            } else {
              localObject1 = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_key.has()) {
              paramProtoResp = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_key.get();
            } else {
              paramProtoResp = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_check_sum.has()) {
              localObject4 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_check_sum.get();
            } else {
              localObject4 = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_host.has()) {
              localObject3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_host.get();
            } else {
              localObject3 = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).uint32_port.has()) {
              m = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).uint32_port.get();
            } else {
              m = 0;
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_name.has()) {
              localObject2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_file_name.get();
            } else {
              localObject2 = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_warn.has()) {
              localObject5 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_warn.get();
            } else {
              localObject5 = "";
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_https_domain.has()) {
              str = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_https_domain.get();
            } else {
              str = null;
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).uint32_https_port.has()) {
              s = (short)((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).uint32_https_port.get();
            } else {
              s = 0;
            }
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_dns.has()) {
              localObject6 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject7).str_dns.get();
            }
            bool = true;
            localObject7 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject1;
            localObject1 = localObject2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          localObject3 = "";
          localObject4 = localObject3;
          localObject5 = localObject4;
          paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject5;
          localObject1 = paramProtoResp;
          localObject2 = localObject1;
          l = -100003L;
        }
      }
    }
    if (l != 0L) {
      bool = false;
    }
    Object localObject2 = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    if (l == -100001L)
    {
      l = 9043L;
    }
    else if (l == -100003L)
    {
      l = 9045L;
    }
    else
    {
      int n;
      if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
        n = 0;
      } else {
        n = 1;
      }
      int i1 = ((FileTransferHandler.PreviewBusiData)localObject2).g();
      if ((n != 0) && (i1 < 3))
      {
        ((FileTransferHandler.PreviewBusiData)localObject2).h();
        a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (FileTransferHandler.PreviewBusiData)localObject2);
        return;
      }
    }
    paramProtoReq = new Bundle();
    if (str != null) {
      paramProtoReq.putString("strHttpsDomain", str);
    }
    paramProtoReq.putShort("httpsPort", s);
    paramProtoReq.putString("IPv6Dns", (String)localObject6);
    a(((FileTransferHandler.PreviewBusiData)localObject2).e(), 5015, bool, new Object[] { Long.valueOf(l), localObject4, paramProtoResp, localObject3, localObject7, Integer.valueOf(m), localObject1, localObject5, paramProtoReq });
  }
  
  private void t(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    paramProtoReq = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    long l2 = paramProtoReq.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [Feed Replay] Id[");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append("]sendDiscFeed Replay");
    QLog.i("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    long l1;
    if (a(paramProtoResp))
    {
      l1 = -100001L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [Feed Replay] Id[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]internalSendDiscFileRequest: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    for (;;)
    {
      bool = false;
      break label357;
      if (paramProtoResp.resp.getResultCode() == 1000) {
        break;
      }
      l1 = -100002L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [Feed Replay] Id[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]internalSendDiscFileRequest: resp is failed[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    paramProtoResp = paramProtoResp.resp.getWupBuffer();
    localObject = new cmd0x345.RspBody();
    try
    {
      ((cmd0x345.RspBody)localObject).mergeFrom(paramProtoResp);
      if (((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
        l1 = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
      } else {
        l1 = 0L;
      }
      if (!((cmd0x345.RspBody)localObject).msg_subcmd_0x2_rsp_body.has())
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("=_= ^! [Feed Replay] Id[");
        paramProtoResp.append(l2);
        paramProtoResp.append("]internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
      }
      else
      {
        bool = true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramProtoResp)
    {
      paramProtoResp.printStackTrace();
      bool = false;
      l1 = -100003L;
    }
    label357:
    if (l1 != 0L) {
      bool = false;
    }
    if (l2 == 0L)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]why sessoinId is 0?!");
    }
    else
    {
      paramProtoResp = this.a.getFileManagerDataCenter().a(l2);
      if (paramProtoResp != null)
      {
        if (bool)
        {
          paramProtoResp.status = 1;
          this.a.getFileManagerNotifyCenter().a(paramProtoResp, 6, "");
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("=_= ^! [Feed Replay]nSessionId[");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append("] sendDiscFeed faild,retCode[");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append("]");
          QLog.e("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
          paramProtoResp.status = 0;
          a(l1, paramProtoResp);
        }
        this.a.getFileManagerDataCenter().c(paramProtoResp);
      }
    }
    if ((bool) && (l2 > 0L)) {
      FileManagerUtil.a(this.a, l2);
    }
    a(paramProtoReq.e(), 5016, bool, new Object[] { Long.valueOf(l1) });
  }
  
  private void u(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay] response FileHit");
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    Object localObject;
    if (a(paramProtoResp))
    {
      localFileUploadInfo.a = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [CS Replay]handleUploadResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localFileUploadInfo.a = -100002;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [CS Replay]handleUploadResponse: resp is failed[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = paramProtoResp.resp.getWupBuffer();
      cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (!localRspBody.msg_apply_upload_hit_rsp_v2.has())
        {
          localFileUploadInfo.a = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        }
        else
        {
          localObject = (cmd0x346.ApplyUploadHitRspV2)localRspBody.msg_apply_upload_hit_rsp_v2.get();
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).int32_ret_code.has()) {
            localFileUploadInfo.a = ((cmd0x346.ApplyUploadHitRspV2)localObject).int32_ret_code.get();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).str_ret_msg.has()) {
            localFileUploadInfo.b = ((cmd0x346.ApplyUploadHitRspV2)localObject).str_ret_msg.get();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).uint64_total_space.has()) {
            localFileUploadInfo.c = ((cmd0x346.ApplyUploadHitRspV2)localObject).uint64_total_space.get();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).uint64_used_space.has()) {
            localFileUploadInfo.d = ((cmd0x346.ApplyUploadHitRspV2)localObject).uint64_used_space.get();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_ip.has()) {
            localFileUploadInfo.f = ((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_ip.get();
          } else if (((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_domain.has()) {
            localFileUploadInfo.f = ((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_domain.get();
          } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).uint32_upload_port.has()) {
            localFileUploadInfo.g = ((short)((cmd0x346.ApplyUploadHitRspV2)localObject).uint32_upload_port.get());
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).bytes_uuid.has()) {
            localFileUploadInfo.h = ((cmd0x346.ApplyUploadHitRspV2)localObject).bytes_uuid.get().toByteArray();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).bytes_upload_key.has()) {
            localFileUploadInfo.i = ((cmd0x346.ApplyUploadHitRspV2)localObject).bytes_upload_key.get().toByteArray();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_https_domain.has()) {
            localFileUploadInfo.p = ((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_https_domain.get();
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).uint32_upload_https_port.has()) {
            localFileUploadInfo.q = ((short)((cmd0x346.ApplyUploadHitRspV2)localObject).uint32_upload_https_port.get());
          }
          if (((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_dns.has()) {
            localFileUploadInfo.r = ((cmd0x346.ApplyUploadHitRspV2)localObject).str_upload_dns.get();
          }
          bool1 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    boolean bool1 = false;
    int m;
    if ((localFileUploadInfo.f != null) && (localFileUploadInfo.f.length() > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((localFileUploadInfo.h != null) && (localFileUploadInfo.h.length != 0)) {
      n = 0;
    } else {
      n = 1;
    }
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = localFileUploadInfo.a;
    localStatictisInfo.c = paramProtoResp.freeRunnalbleIndex;
    boolean bool2 = bool1;
    if (n != 0)
    {
      bool2 = bool1;
      if (m != 0)
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("uuid_null[");
        paramProtoResp.append(localFileUploadInfo.toString());
        paramProtoResp.append("]");
        localFileUploadInfo.b = paramProtoResp.toString();
        bool2 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("decodeOffFilePBResponse:return ");
      paramProtoResp.append(bool2);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      paramProtoResp.append(", totalSpace=");
      paramProtoResp.append(localFileUploadInfo.c);
      paramProtoResp.append(", usedSpace=");
      paramProtoResp.append(localFileUploadInfo.d);
      paramProtoResp.append(", ip=");
      paramProtoResp.append(localFileUploadInfo.f);
      paramProtoResp.append(", port=");
      paramProtoResp.append(localFileUploadInfo.g);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5020, bool2, new Object[] { localFileUploadInfo, localStatictisInfo, null });
  }
  
  private void v(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse ");
    }
    boolean bool1 = a(paramProtoResp);
    int m = -100003;
    boolean bool2 = false;
    boolean bool3 = true;
    StringBuilder localStringBuilder = null;
    Object localObject;
    if (bool1)
    {
      m = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRemoveResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    int n;
    for (;;)
    {
      bool1 = false;
      n = m;
      paramProtoResp = localStringBuilder;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleRemoveResponse: resp is failed[");
        ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject).msg_recall_file_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          }
          else
          {
            localObject = (cmd0x346.RecallFileRsp)((cmd0x346.RspBody)localObject).msg_recall_file_rsp.get();
            if (((cmd0x346.RecallFileRsp)localObject).int32_ret_code.has()) {
              m = ((cmd0x346.RecallFileRsp)localObject).int32_ret_code.get();
            } else {
              m = 0;
            }
            n = m;
            bool1 = bool3;
            paramProtoResp = localStringBuilder;
            if (!((cmd0x346.RecallFileRsp)localObject).str_ret_msg.has()) {
              break;
            }
            paramProtoResp = ((cmd0x346.RecallFileRsp)localObject).str_ret_msg.get();
            n = m;
            bool1 = bool3;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
        }
      }
    }
    if (n != 0) {
      bool1 = bool2;
    }
    paramProtoReq = (FMConstants.RevertMsgCallback)((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).b();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRecallResponse [");
      localStringBuilder.append(bool1);
      localStringBuilder.append("],retCode[");
      localStringBuilder.append(n);
      localStringBuilder.append("], retMsg[");
      localStringBuilder.append(paramProtoResp);
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      paramProtoReq.a();
      return;
    }
    paramProtoReq.a(n, paramProtoResp);
  }
  
  private void w(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    int n = -100003;
    Object localObject1 = "";
    int m;
    Object localObject2;
    if (bool)
    {
      m = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("internalForwardDisc2Disc: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      bool = false;
      paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("internalForwardDisc2Disc: resp is failed[");
        ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject2).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (((cmd0x345.RspBody)localObject2).uint32_return_code.has()) {
            m = ((cmd0x345.RspBody)localObject2).uint32_return_code.get();
          } else {
            m = 0;
          }
          if (!((cmd0x345.RspBody)localObject2).msg_subcmd_0xa_rsp_body.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
            m = n;
          }
          else
          {
            localObject2 = (cmd0x345.RspBody.SubCmd0xaRspBody)((cmd0x345.RspBody)localObject2).msg_subcmd_0xa_rsp_body.get();
            paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
            if (((cmd0x345.RspBody.SubCmd0xaRspBody)localObject2).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x345.RspBody.SubCmd0xaRspBody)localObject2).str_ret_msg.get();
            }
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = n;
        }
      }
    }
    if (m != 0) {
      bool = false;
    }
    paramProtoReq = (FMConstants.RevertMsgCallback)((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("internalDeleteDiscFile [");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("],retCode[");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("], retMsg[");
      ((StringBuilder)localObject1).append(paramProtoResp);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramProtoReq == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "del disc file, but callback is null!!!,check here!!!");
      return;
    }
    if (bool)
    {
      paramProtoReq.a();
      return;
    }
    paramProtoReq.a(m, paramProtoResp);
  }
  
  public long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDiscFileCome,uinseq[");
      localStringBuilder.append(String.valueOf(paramLong1));
      localStringBuilder.append("],discUin[");
      localStringBuilder.append(String.valueOf(paramLong2));
      localStringBuilder.append("],sendUin[");
      localStringBuilder.append(String.valueOf(paramLong3));
      localStringBuilder.append("],seq[");
      localStringBuilder.append(String.valueOf(paramLong4));
      localStringBuilder.append("],msgTime[");
      localStringBuilder.append(String.valueOf(paramLong6));
      localStringBuilder.append("],fileInfo[");
      localStringBuilder.append(String.valueOf(paramGroupFile));
      localStringBuilder.append("],oriImgWidth[");
      localStringBuilder.append(String.valueOf(paramInt1));
      localStringBuilder.append("],oriImgHeight[");
      localStringBuilder.append(String.valueOf(paramInt2));
      localStringBuilder.append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    }
    return b(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramGroupFile, paramInt1, paramInt2);
  }
  
  public long a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3, int paramInt4, hummer_resv_21.ResvAttr paramResvAttr)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public MessageRecord a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.a.getMessageFacade().h(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("------->msgFilter :msgIsTroop:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",peerUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",list size:");
      if (localObject == null) {
        paramInt = 0;
      } else {
        paramInt = ((List)localObject).size();
      }
      localStringBuilder.append(paramInt);
      QLog.d("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramString1 = ((List)localObject).iterator();
      while (paramString1.hasNext())
      {
        localObject = (MessageRecord)paramString1.next();
        if ((((MessageRecord)localObject).msgUid != 0L) && (paramLong3 != 0L))
        {
          if ((((MessageRecord)localObject).msgUid == paramLong3) && (((MessageRecord)localObject).shmsgseq == paramLong2) && (((MessageRecord)localObject).senderuin.equals(paramString2)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
            }
            return localObject;
          }
        }
        else if ((Math.abs(((MessageRecord)localObject).time - paramLong1) < 30L) && (((MessageRecord)localObject).shmsgseq == paramLong2) && (((MessageRecord)localObject).senderuin.equals(paramString2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          return localObject;
        }
      }
    }
    return null;
  }
  
  public OnlineFileSessionInfo a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int m = paramArrayOfByte.length;
      OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
      if (m >= 16)
      {
        PkgTools.getBytesData(paramArrayOfByte, 0, localOnlineFileSessionInfo.f, 16);
        if (m >= 28)
        {
          localOnlineFileSessionInfo.c = PkgTools.getLongData(paramArrayOfByte, 24);
          if (m >= 51)
          {
            int n = PkgTools.getShortData(paramArrayOfByte, 49);
            if (n < 4)
            {
              localOnlineFileSessionInfo.i = false;
              return localOnlineFileSessionInfo;
            }
            byte[] arrayOfByte = new byte[n];
            if (m >= 51 + n)
            {
              PkgTools.getBytesData(paramArrayOfByte, 51, arrayOfByte, n);
              m = 0;
              while (m < n)
              {
                int i1 = arrayOfByte[m];
                int i2 = m + 1;
                m = i2 + 2;
                if (n >= m)
                {
                  i2 = PkgTools.getShortData(arrayOfByte, i2);
                  if ((i1 != 1) && (i1 != 2) && (i1 != 3)) {
                    if (i1 == 4)
                    {
                      paramArrayOfByte = new byte[i2];
                      if (n >= m + i2)
                      {
                        PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i2);
                        paramArrayOfByte = c(paramArrayOfByte);
                        if (paramArrayOfByte != null)
                        {
                          localOnlineFileSessionInfo.a = paramArrayOfByte.a;
                          localOnlineFileSessionInfo.b = paramArrayOfByte.b;
                        }
                        else
                        {
                          QLog.e("FileTransferHandler<FileAssistant>", 1, "decode file info error for request or accept");
                          return null;
                        }
                      }
                      else
                      {
                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
                        return localOnlineFileSessionInfo;
                      }
                    }
                    else if (i1 != 12)
                    {
                      boolean bool;
                      if (i1 == 15)
                      {
                        if (i2 < 1)
                        {
                          localOnlineFileSessionInfo.i = false;
                        }
                        else if (n >= m + i2)
                        {
                          paramArrayOfByte = new byte[i2];
                          PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i2);
                          if (paramArrayOfByte[0] == 1) {
                            bool = true;
                          } else {
                            bool = false;
                          }
                          localOnlineFileSessionInfo.i = bool;
                        }
                      }
                      else if (i1 == 17) {
                        if (i2 < 1)
                        {
                          localOnlineFileSessionInfo.l = false;
                        }
                        else if (n >= m + i2)
                        {
                          paramArrayOfByte = new byte[i2];
                          PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i2);
                          if (paramArrayOfByte[0] == 1) {
                            bool = true;
                          } else {
                            bool = false;
                          }
                          localOnlineFileSessionInfo.l = bool;
                        }
                      }
                    }
                  }
                  m = i2 + m;
                }
                else
                {
                  QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
                }
              }
              return localOnlineFileSessionInfo;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
            return null;
          }
          QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
          return null;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
        return null;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
    return null;
  }
  
  public Cmd0x346CSBody a(OfflineFileUploadPara paramOfflineFileUploadPara)
  {
    Cmd0x346CSBody localCmd0x346CSBody = new Cmd0x346CSBody();
    long l = Long.parseLong(this.a.getCurrentAccountUin());
    if (paramOfflineFileUploadPara.c == 1700)
    {
      localCmd0x346CSBody.b = new ApplyUploadReqV3();
      paramOfflineFileUploadPara.a = paramOfflineFileUploadPara.a.replace("+", "");
      localCmd0x346CSBody.b.a = l;
      localCmd0x346CSBody.b.b = Long.parseLong(paramOfflineFileUploadPara.a);
      localCmd0x346CSBody.b.c = paramOfflineFileUploadPara.b;
      localCmd0x346CSBody.b.d = new String(paramOfflineFileUploadPara.f);
      localCmd0x346CSBody.b.i = new String(paramOfflineFileUploadPara.e);
      localCmd0x346CSBody.b.e = paramOfflineFileUploadPara.g;
      localCmd0x346CSBody.b.g = paramOfflineFileUploadPara.i;
      localCmd0x346CSBody.b.f = paramOfflineFileUploadPara.h;
      localCmd0x346CSBody.b.h = paramOfflineFileUploadPara.j;
      return localCmd0x346CSBody;
    }
    if (paramOfflineFileUploadPara.c == 1600)
    {
      localCmd0x346CSBody.a = new ApplyUploadReqV2();
      paramOfflineFileUploadPara.a = paramOfflineFileUploadPara.a.replace("+", "");
      localCmd0x346CSBody.a.a = l;
      localCmd0x346CSBody.a.b = Long.parseLong(paramOfflineFileUploadPara.a);
      localCmd0x346CSBody.a.c = paramOfflineFileUploadPara.b;
      localCmd0x346CSBody.a.d = new String(paramOfflineFileUploadPara.f);
      localCmd0x346CSBody.a.g = new String(paramOfflineFileUploadPara.e);
      localCmd0x346CSBody.a.e = paramOfflineFileUploadPara.g;
      localCmd0x346CSBody.a.f = paramOfflineFileUploadPara.j;
    }
    return localCmd0x346CSBody;
  }
  
  public List<MessageRecord> a(List<msg_comm.Msg> paramList, long paramLong, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(paramList);
    int m = 0;
    while (m < localArrayList2.size())
    {
      msg_comm.Msg localMsg = (msg_comm.Msg)localArrayList2.get(m);
      if (a(paramLong, paramBoolean, localArrayList1, m, localMsg, (msg_comm.MsgHead)localMsg.msg_head.get())) {
        paramList.remove(localMsg);
      }
      m += 1;
    }
    return localArrayList1;
  }
  
  public cmd0x346.ApplyUploadReqV2 a(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    paramCmd0x346CSBody = paramCmd0x346CSBody.a;
    localApplyUploadReqV2.uint64_sender_uin.set(paramCmd0x346CSBody.a);
    localApplyUploadReqV2.uint64_recver_uin.set(paramCmd0x346CSBody.b);
    localApplyUploadReqV2.uint64_file_size.set(paramCmd0x346CSBody.c);
    localApplyUploadReqV2.str_file_name.set(paramCmd0x346CSBody.d);
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.e));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.f));
    localApplyUploadReqV2.str_local_filepath.set(paramCmd0x346CSBody.g);
    localApplyUploadReqV2.uint32_danger_level.set(paramCmd0x346CSBody.h);
    localApplyUploadReqV2.uint64_total_space.set(paramCmd0x346CSBody.i);
    return localApplyUploadReqV2;
  }
  
  public void a(int paramInt1, int paramInt2, FileTransferObserver paramFileTransferObserver, int paramInt3)
  {
    Object localObject = new cmd0x346.RecvListQueryReq();
    ((cmd0x346.RecvListQueryReq)localObject).uint64_uin.set(this.a.getLongAccountUin());
    ((cmd0x346.RecvListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_req_count.set(paramInt2);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_filter_filetype.set(paramInt3);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recv_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(100);
    localObject = localReqBody.uint32_seq;
    paramInt1 = e;
    e = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform enabled");
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform not enabled");
    }
    paramFileTransferObserver = new FileTransferHandler.PreviewBusiData(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100", localReqBody.toByteArray(), paramFileTransferObserver, 10000, 3, 1);
  }
  
  public void a(int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ForwardIntrlnal : uDstId[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.peerUin));
      ((StringBuilder)localObject1).append("], uDstUin[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.selfUin));
      ((StringBuilder)localObject1).append(" nDstSvcId[");
      ((StringBuilder)localObject1).append(String.valueOf(paramInt1));
      ((StringBuilder)localObject1).append(" uFileSize[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.fileSize));
      ((StringBuilder)localObject1).append(" strFileName[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.fileName));
      ((StringBuilder)localObject1).append(" strUuid[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.Uuid));
      ((StringBuilder)localObject1).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() >= 1) && (this.a.getAccount() != null))
    {
      Object localObject2 = new cmd0x346.ApplyCopyToReq();
      localObject1 = this.a.getAccount().replace("+", "");
      ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong((String)localObject1));
      if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104)) {
        ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong(paramFileManagerEntity.peerUin));
      }
      ((cmd0x346.ApplyCopyToReq)localObject2).uint32_dst_svcid.set(paramInt1);
      ((cmd0x346.ApplyCopyToReq)localObject2).uint64_src_uin.set(Long.parseLong((String)localObject1));
      ((cmd0x346.ApplyCopyToReq)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
      ((cmd0x346.ApplyCopyToReq)localObject2).str_file_name.set(paramFileManagerEntity.fileName);
      ((cmd0x346.ApplyCopyToReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
      localObject1 = new cmd0x346.ReqBody();
      ((cmd0x346.ReqBody)localObject1).msg_apply_copy_to_req.set((MessageMicro)localObject2);
      ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(60100);
      localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
      paramInt1 = e;
      e = paramInt1 + 1;
      ((PBUInt32Field)localObject2).set(paramInt1);
      ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(paramInt2);
      ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
      paramFileManagerEntity = new FileTransferHandler.PreviewBusiData(this, false, paramFileManagerEntity.nSessionId);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
    }
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    a(paramInt, 3, paramFileManagerEntity);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt3)
  {
    if (!b(paramOnlineFileSessionInfo)) {
      return;
    }
    if (paramInt1 != 129)
    {
      if (paramInt1 != 131)
      {
        if (paramInt1 != 133)
        {
          paramString1 = new StringBuilder();
          paramString1.append("OLfilesession[");
          paramString1.append(paramOnlineFileSessionInfo.c);
          paramString1.append("] handleOnLineFilePushMsg. error cmd:");
          paramString1.append(paramInt1);
          QLog.e("FileTransferHandler<FileAssistant>", 1, paramString1.toString());
          return;
        }
        paramString2 = new StringBuilder();
        paramString2.append("OLfilesession[");
        paramString2.append(paramOnlineFileSessionInfo.c);
        paramString2.append("] handle cmd 0x85. cancel.type:");
        paramString2.append(paramOnlineFileSessionInfo.j);
        paramString2.append(" reason:");
        paramString2.append(paramOnlineFileSessionInfo.k);
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
        if (2 == paramOnlineFileSessionInfo.j)
        {
          this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 2);
          return;
        }
        if (1 == paramOnlineFileSessionInfo.j)
        {
          if (57 == paramOnlineFileSessionInfo.k)
          {
            this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 5);
            return;
          }
          if (70 == paramOnlineFileSessionInfo.k)
          {
            this.a.getOnlineFileSessionCenter().c(paramString1, paramOnlineFileSessionInfo.c);
            return;
          }
          if (71 == paramOnlineFileSessionInfo.k)
          {
            this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 4);
            return;
          }
          if (5 == paramOnlineFileSessionInfo.k)
          {
            this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 2);
            return;
          }
          if (paramOnlineFileSessionInfo.k == 0)
          {
            this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 3);
            return;
          }
          if (58 == paramOnlineFileSessionInfo.k)
          {
            this.a.getOnlineFileSessionCenter().c(paramString1, paramOnlineFileSessionInfo.c);
            return;
          }
          paramString1 = new StringBuilder();
          paramString1.append("OLfilesession[");
          paramString1.append(paramOnlineFileSessionInfo.c);
          paramString1.append("] canceltype:1.unkonw reason:");
          paramString1.append(paramOnlineFileSessionInfo.k);
          QLog.e("FileTransferHandler<FileAssistant>", 1, paramString1.toString());
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("OLfilesession[");
        paramString1.append(paramOnlineFileSessionInfo.c);
        paramString1.append("] unknow canceltype:");
        paramString1.append(paramOnlineFileSessionInfo.j);
        QLog.e("FileTransferHandler<FileAssistant>", 1, paramString1.toString());
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("OLfilesession[");
      paramString2.append(paramOnlineFileSessionInfo.c);
      paramString2.append("] handle cmd 0x83. accept");
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramString2.toString());
      this.a.getOnlineFileSessionCenter().a(paramString1, paramOnlineFileSessionInfo.c, 1);
      return;
    }
    paramString3 = new StringBuilder();
    paramString3.append("OLfilesession[");
    paramString3.append(paramOnlineFileSessionInfo.c);
    paramString3.append("] handle cmd 0x81. request");
    QLog.i("FileTransferHandler<FileAssistant>", 1, paramString3.toString());
    this.a.getOnlineFileSessionCenter().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramOnlineFileSessionInfo, paramLong2, paramInt3);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean, Cmd0x346CSBody paramCmd0x346CSBody, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int m = e;
    e = m + 1;
    ((PBUInt32Field)localObject).set(m);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [CS Step], SessionId[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("], send pb uMsgSubType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 1600)
    {
      if (paramInt != 1700)
      {
        if (paramInt != 1800)
        {
          paramCmd0x346CSBody = new StringBuilder();
          paramCmd0x346CSBody.append("=_= ^! SessionId[");
          paramCmd0x346CSBody.append(paramFileManagerEntity.nSessionId);
          paramCmd0x346CSBody.append("]send0x346Req, unknwon nCmdType:");
          paramCmd0x346CSBody.append(paramInt);
          QLog.e("FileTransferHandler<FileAssistant>", 2, paramCmd0x346CSBody.toString());
          return;
        }
        localObject = c(paramCmd0x346CSBody);
        localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
        paramFileTransferObserver = new FileTransferHandler.PreviewBusiData(this, paramCmd0x346CSBody.c.e, paramCmd0x346CSBody.c.g, null, paramFileTransferObserver);
        paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
      }
      else
      {
        localObject = b(paramCmd0x346CSBody);
        localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
        paramFileTransferObserver = new FileTransferHandler.PreviewBusiData(this, paramCmd0x346CSBody.b.e, paramCmd0x346CSBody.b.g, null, paramFileTransferObserver);
        paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
      }
    }
    else
    {
      localObject = a(paramCmd0x346CSBody);
      localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
      paramFileTransferObserver = new FileTransferHandler.PreviewBusiData(this, paramCmd0x346CSBody.a.e, null, paramCmd0x346CSBody.a.f, paramFileTransferObserver);
      paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
    }
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        ((cmd0x346.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= ^> SessionId[");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      localStringBuilder.append("]send0x346Req, add TempInfo:");
      localStringBuilder.append(paramFileManagerEntity.tmpSessionType);
      QLog.e("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
      localReqBody.msg_extension_req.set((MessageMicro)localObject);
    }
    if (paramBoolean) {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
    }
    a(paramCmd0x346CSBody, localReqBody.toByteArray(), paramFileTransferObserver);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getDiscFile : String[");
      paramString1.append(paramString2);
      paramString1.append("], nDiscId[");
      paramString1.append(paramLong2);
      paramString1.append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramString1.toString());
    }
    paramString1 = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
    paramString1.uint64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    paramString1.str_file_id.set(paramString2);
    paramString1.uint64_disscus_uin.set(paramLong2);
    paramString1.uint32_costom_id.set(0);
    paramString2 = new cmd0x345.ReqBody();
    paramString2.msg_subcmd_0x3_req_body.set(paramString1);
    paramString2.uint32_sub_cmd.set(3);
    paramString1 = new FileTransferHandler.PreviewBusiData(this, false, paramLong1, paramFileTransferObserver, 3);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString2.toByteArray(), paramString1);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramString4.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramString3);
    if ((paramString5 != null) && (paramString5.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramString5.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new FileTransferHandler.PreviewBusiData(this, false, paramLong1, null, 6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, long paramLong4, FileTransferObserver paramFileTransferObserver)
  {
    cmd0x345.ReqBody.SubCmd0x2ReqBody localSubCmd0x2ReqBody = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
    int m = (int)Long.parseLong(paramString1);
    localSubCmd0x2ReqBody.uint32_disscus_uin.set(m);
    m = (int)Long.parseLong(paramString2);
    localSubCmd0x2ReqBody.uint32_sender_uin.set(m);
    localSubCmd0x2ReqBody.str_file_name.set(paramString3);
    localSubCmd0x2ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x2ReqBody.str_file_id.set(paramString4);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_id.set(paramString1);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_item_id.set(paramString1);
    localSubCmd0x2ReqBody.uint64_time.set(MessageCache.c());
    localSubCmd0x2ReqBody.uint32_busid.set(106);
    paramString1 = this.a.getFileManagerDataCenter().a(paramLong1);
    if (paramString1 != null)
    {
      int n = 0;
      paramString2 = new hummer_resv_21.ResvAttr();
      m = n;
      if (FileManagerUtil.c(paramString1.fileName) == 5)
      {
        m = n;
        if (!TextUtils.isEmpty(paramString1.strApkPackageName))
        {
          paramString3 = new hummer_resv_21.FileApkInfo();
          paramString3.str_package_name.set(paramString1.strApkPackageName);
          paramString3.str_version.set("");
          paramString2.file_apk_info.set(paramString3);
          m = 1;
        }
      }
      if (paramString1.nFileType != 0)
      {
        n = m;
        if (paramString1.nFileType != 2) {}
      }
      else
      {
        FileManagerUtil.n(paramString1);
        if ((paramString1.imgHeight > 0) && (paramString1.imgWidth > 0))
        {
          paramString3 = new hummer_resv_21.FileImgInfo();
          paramString3.uint32_file_height.set(paramString1.imgHeight);
          paramString3.uint32_file_width.set(paramString1.imgWidth);
          paramString2.file_image_info.set(paramString3);
          paramString3 = new StringBuilder();
          paramString3.append("send Disc Feeds setThumbSize height[");
          paramString3.append(paramString1.imgHeight);
          paramString3.append("], width[");
          paramString3.append(paramString1.imgWidth);
          paramString3.append("]");
          QLog.i("FileTransferHandler<FileAssistant>", 1, paramString3.toString());
          n = 1;
        }
        else
        {
          n = m;
          if (!FileManagerUtil.b(paramString1)) {
            if (paramString1.nFileType != 0)
            {
              n = m;
              if (paramString1.nFileType != 2) {}
            }
            else
            {
              new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.12(this, paramString1), 1000L);
              n = m;
            }
          }
        }
      }
      if (n != 0) {
        localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      }
    }
    if ((paramLong4 == 0L) && (QLog.isDevelopLevel())) {
      throw new NullPointerException();
    }
    m = MessageUtils.a(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(m);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    paramString2 = new StringBuilder();
    paramString2.append("=_= ^ [Disc Feed]send Disc Feed[");
    paramString2.append(paramLong1);
    paramString2.append("]");
    QLog.i("FileTransferHandler<FileAssistant>", 2, paramString2.toString());
    paramString2 = new FileTransferHandler.PreviewBusiData(this, false, paramLong1, paramFileTransferObserver, 2);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, FileTransferObserver paramFileTransferObserver)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    if (paramBoolean) {
      m = 1;
    } else {
      m = 2;
    }
    localApplyDownloadReq.uint32_owner_type.set(m);
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_req.set(localApplyDownloadReq);
    paramString1.uint32_cmd.set(1200);
    Object localObject = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    ((PBUInt32Field)localObject).set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    localObject = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
    paramString1.msg_extension_req.set((MessageMicro)localObject);
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform not enabled");
    }
    paramString2 = new FileTransferHandler.PreviewBusiData(this, paramLong, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().a(paramLong);
    localFileManagerEntity.strFileMd5 = HexUtil.bytes2HexStr(paramArrayOfByte);
    paramArrayOfByte = new SubMsgType0x7.MsgBody();
    paramArrayOfByte.uint32_sub_cmd.set(1);
    paramLong = this.a.getLongAccountUin();
    ProtocolHelper.fillMsgHeader(paramArrayOfByte.msg_header, paramLong, paramLong, 0);
    Object localObject = new SubMsgType0x7.MsgBody.FTNNotify();
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).uint64_sessionid.set(localFileManagerEntity.nSessionId);
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).str_file_name.set(localFileManagerEntity.fileName);
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).str_file_index.set(paramString);
    paramString = HexUtil.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramString));
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).uint64_file_len.set(localFileManagerEntity.fileSize);
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramString));
    int m = localFileManagerEntity.nFileType;
    if (m != 0)
    {
      if (m != 2) {
        m = 0;
      } else {
        m = 2;
      }
    }
    else {
      m = 1;
    }
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).uint32_originfiletype.set(m);
    ((SubMsgType0x7.MsgBody.FTNNotify)localObject).setHasFlag(true);
    paramArrayOfByte.rpt_msg_subcmd_0x1_ftn_notify.add((MessageMicro)localObject);
    paramArrayOfByte.setHasFlag(true);
    m = paramArrayOfByte.msg_header.uint32_dst_ter_type.get();
    paramString = this.a.getCurrentAccountUin();
    localObject = paramArrayOfByte.toByteArray();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CDatalineMsg DataLineMsgRecord:");
      localStringBuilder.append(localFileManagerEntity.nSessionId);
      QLog.d("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramString = a(paramString, 7, (byte[])localObject, localFileManagerEntity.nSessionId, m);
    DataLineHandler.a(paramArrayOfByte, paramString);
    a(false, 1004, localFileManagerEntity.nSessionId, paramString);
  }
  
  public void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.ResvAttr paramResvAttr)
  {
    boolean bool = paramMsg.msg_head.c2c_tmp_msg_head.has();
    String str1 = null;
    TempSessionInfo localTempSessionInfo;
    if (bool) {
      localTempSessionInfo = TempSessionDecoder.a(paramMsg, this.a);
    } else {
      localTempSessionInfo = null;
    }
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if (!paramNotOnlineFile.bytes_file_name.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
      return;
    }
    String str2 = FileManagerUtil.a(paramNotOnlineFile.bytes_file_name.get().toStringUtf8());
    int m = paramNotOnlineFile.uint32_file_type.get();
    long l5 = paramNotOnlineFile.uint64_file_size.get();
    int n = paramNotOnlineFile.uint32_subcmd.get();
    String str3 = FileHttpUtils.a(paramNotOnlineFile.bytes_file_md5.get().toByteArray());
    Object localObject1 = this.a.getCurrentAccountUin();
    if (paramNotOnlineFile.bytes_file_uuid.has())
    {
      str4 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("offline file come, msgTime[");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append("] msgSeq[");
        ((StringBuilder)localObject2).append(s);
        ((StringBuilder)localObject2).append("] msgUid[");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append("]  fileName[");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append("] uuid[");
        ((StringBuilder)localObject2).append(str4);
        ((StringBuilder)localObject2).append("] fileType[");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append("] subCmd[");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append("] strMd5[");
        ((StringBuilder)localObject2).append(str3);
        ((StringBuilder)localObject2).append("]");
        QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      }
    }
    long l2 = l1;
    if (m == 1)
    {
      a(paramList, paramString, paramBoolean1, paramBoolean2, paramLong, paramInt, paramResvAttr, l3, l4, s, str2, m, l5, String.valueOf(l1), (String)localObject1);
      return;
    }
    if (!paramNotOnlineFile.bytes_file_uuid.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not uuid");
      }
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8());
    ((StringBuilder)localObject1).append(l4);
    Object localObject2 = new String(((StringBuilder)localObject1).toString());
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("offline file come:fileName[");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    String str4 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
    if ((paramResvAttr != null) && (paramResvAttr.file_assist_info.has())) {
      a(paramResvAttr);
    }
    localObject1 = this;
    if (a(paramMessageHandler, paramBoolean2, str2, m, n, (String)localObject2, str4)) {
      return;
    }
    n = ((FileTransferHandler)localObject1).a(l2, paramNotOnlineFile, 0);
    a(paramString, l3, l4, s, n);
    if (a(paramList, paramString, paramBoolean1, paramBoolean2, l3, l4, l2, s)) {
      return;
    }
    if (((FileTransferHandler)localObject1).c(str4)) {
      return;
    }
    if (l5 == 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---decodeC2CMsgPkg_MsgType0x211:fileType[");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("], UUID[");
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append("], filename[");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("], fileSize[");
      ((StringBuilder)localObject1).append(l5);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    if (paramNotOnlineFile.str_fileidcrc_media.has())
    {
      str1 = paramNotOnlineFile.str_fileidcrc_media.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleOffLineFileMsg UUID[");
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append("], FileIdCrc[");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("], filename[");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("], fileSize[");
      ((StringBuilder)localObject1).append(l5);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    localObject1 = paramResvAttr;
    if ((localObject1 != null) && (((hummer_resv_21.ResvAttr)localObject1).file_apk_info.has())) {
      localObject1 = (hummer_resv_21.FileApkInfo)((hummer_resv_21.ResvAttr)localObject1).file_apk_info.get();
    }
    a(paramMessageHandler, paramList, paramString, String.valueOf(l2), l4, s, paramBoolean1, paramBoolean2, m, str4, str1, str2, l5, n, paramLong, l3, str3, localTempSessionInfo, paramInt, paramResvAttr, paramNotOnlineFile.bytes_pb_reserve.get().toByteArray(), paramNotOnlineFile.bytes_note.get().toStringUtf8());
    a(paramList, paramResvAttr, l2);
    if (((localTempSessionInfo != null) && (localTempSessionInfo.a == 1024)) || (BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(l2)))) {
      QidianUtils.a(this.a, paramList, paramNotOnlineFile, paramMsg, localTempSessionInfo);
    }
  }
  
  public void a(FileTransferObserver paramFileTransferObserver, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramFileTransferObserver != null)
    {
      Message localMessage = i.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = new Object[] { paramFileTransferObserver, Boolean.valueOf(paramBoolean), paramObject };
      localMessage.sendToTarget();
      paramFileTransferObserver = new StringBuilder();
      paramFileTransferObserver.append("notifyUI. sendToTarget[");
      paramFileTransferObserver.append(paramBoolean);
      paramFileTransferObserver.append("] .type=");
      paramFileTransferObserver.append(paramInt);
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramFileTransferObserver.toString());
      return;
    }
    paramFileTransferObserver = new StringBuilder();
    paramFileTransferObserver.append("notifyUI. not find observer .type=");
    paramFileTransferObserver.append(paramInt);
    QLog.e("FileTransferHandler<FileAssistant>", 1, paramFileTransferObserver.toString());
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ForwardOfflineFile : PeerUin[");
      ((StringBuilder)localObject1).append(FileManagerUtil.k(paramFileManagerEntity.peerUin));
      ((StringBuilder)localObject1).append("], FileUUID[");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.Uuid);
      ((StringBuilder)localObject1).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramFileManagerEntity != null) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
    {
      cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
      localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
      String str = paramFileManagerEntity.peerUin.replace("+", "");
      localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong(str));
      localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
      localObject1 = new cmd0x346.ReqBody();
      ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set(localApplyForwardFileReq);
      ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
      Object localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
      int m = e;
      e = m + 1;
      ((PBUInt32Field)localObject2).set(m);
      ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(3);
      ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject2 = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject2).uint64_id.set(3L);
        ((cmd0x346.ExtensionReq)localObject2).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          ((cmd0x346.ExtensionReq)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          ((cmd0x346.ExtensionReq)localObject2).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ForwardOfflineFile : addtempinfo SessionType[");
          ((StringBuilder)localObject2).append(paramFileManagerEntity.tmpSessionType);
          ((StringBuilder)localObject2).append("], sessionId[");
          ((StringBuilder)localObject2).append(paramFileManagerEntity.nSessionId);
          ((StringBuilder)localObject2).append("]");
          QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if ((!a()) && (!QFileAssistantUtils.a(str)))
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform not enabled");
      }
      else
      {
        ((cmd0x346.ReqBody)localObject1).uint32_flag_support_mediaplatform.set(1);
        if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
        {
          localApplyForwardFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
          QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled");
        }
        else
        {
          QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
        }
      }
      paramFileManagerEntity = new FileTransferHandler.PreviewBusiData(this, false, paramFileManagerEntity.nSessionId);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("entity info error:");
    ((StringBuilder)localObject1).append(FileManagerUtil.c(paramFileManagerEntity));
    QLog.e("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    Object localObject = paramFileManagerEntity.peerUin.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong((String)localObject));
    localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        localSubCmd0x6ReqBody.str_dst_phone_number.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ForwardDiscFile : addtempinfo SessionType[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.tmpSessionType);
        ((StringBuilder)localObject).append("], sessionId[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("]");
        QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = new cmd0x345.ReqBody();
    ((cmd0x345.ReqBody)localObject).msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    ((cmd0x345.ReqBody)localObject).uint32_sub_cmd.set(7);
    paramFileManagerEntity = new FileTransferHandler.PreviewBusiData(this, false, paramFileManagerEntity.nSessionId, null, 7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, FMConstants.RevertMsgCallback paramRevertMsgCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "revertC2CFile ");
    }
    cmd0x346.RecallFileReq localRecallFileReq = new cmd0x346.RecallFileReq();
    localRecallFileReq.uint64_uin.set(this.a.getLongAccountUin());
    localRecallFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recall_file_req.set(localRecallFileReq);
    localReqBody.uint32_cmd.set(400);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int m = e;
    e = m + 1;
    localPBUInt32Field.set(m);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        localRecallFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform not enabled");
    }
    paramFileManagerEntity = new FileTransferHandler.PreviewBusiData(this);
    FileTransferHandler.PreviewBusiData.a(paramFileManagerEntity, paramRevertMsgCallback);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400", localReqBody.toByteArray(), paramFileManagerEntity, 10000, 3, 1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, FileTransferObserver paramFileTransferObserver)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramString3, false, null, paramFileTransferObserver);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUploadSuccState : selfUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.k(paramString1));
      ((StringBuilder)localObject).append("], toUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.k(paramString2));
      ((StringBuilder)localObject).append("], filePath[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x346.UploadSuccReq();
    ((cmd0x346.UploadSuccReq)localObject).uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    ((cmd0x346.UploadSuccReq)localObject).uint64_recver_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.UploadSuccReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        ((cmd0x346.UploadSuccReq)localObject).str_fileidcrc.set(paramString4);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform not enabled");
    }
    paramString1.msg_upload_succ_req.set((MessageMicro)localObject);
    paramString1.uint32_cmd.set(800);
    paramString2 = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    paramString2.set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint64_id.set(3L);
      paramString2.uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        paramString2.str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("setUploadSuccState : addtempinfo SessionType[");
        paramString2.append(paramFileManagerEntity.tmpSessionType);
        paramString2.append("], sessionId[");
        paramString2.append(paramFileManagerEntity.nSessionId);
        paramString2.append("]");
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramString2.toString());
      }
    }
    paramFileManagerEntity = new FileTransferHandler.PreviewBusiData(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramString1.toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(OfflineFileUploadPara paramOfflineFileUploadPara, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    Cmd0x346CSBody localCmd0x346CSBody = a(paramOfflineFileUploadPara);
    paramFileManagerEntity.strFileSha3 = FileHttpUtils.a(paramOfflineFileUploadPara.j);
    a(1L, paramOfflineFileUploadPara.c, paramOfflineFileUploadPara.d, localCmd0x346CSBody, paramFileTransferObserver, paramFileManagerEntity);
  }
  
  public void a(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    paramProtoReq.callback = new FileTransferHandler.2(this);
    ((IProtoReqManager)this.a.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(paramProtoReq);
  }
  
  public void a(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    DownloadRespInfo localDownloadRespInfo = new DownloadRespInfo();
    boolean bool1 = a(paramProtoResp);
    long l = -100003L;
    Object localObject1;
    if (bool1)
    {
      l = -100001L;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleDownloadResp: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    boolean bool2;
    Object localObject2;
    for (;;)
    {
      bool1 = false;
      bool2 = false;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        l = -100002L;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleDownloadResp: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject2 = paramProtoResp.resp.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom((byte[])localObject2);
          if (!((cmd0x346.RspBody)localObject1).msg_apply_download_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          }
          else
          {
            if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.has())
            {
              if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.get() == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleDownloadResp: bUseMediaPlatform ");
              ((StringBuilder)localObject2).append(bool1);
              QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform false uint32_flag_use_media_platform not set");
              bool1 = false;
            }
            DownloadRespInfo.a(localDownloadRespInfo, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject1).msg_apply_download_rsp.get(), bool1, this.a.getAccount());
            l = localDownloadRespInfo.a;
            bool2 = bool1;
            bool1 = true;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    int m;
    if ((l == 0L) && (localDownloadRespInfo.f == null) && (localDownloadRespInfo.d == null)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((l != -91245L) && (l != -7010L)) {
      n = 0;
    } else {
      n = 1;
    }
    FileTransferHandler.PreviewBusiData localPreviewBusiData = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    int i1 = localPreviewBusiData.g();
    if (((n != 0) || (m != 0)) && (i1 < 3))
    {
      localPreviewBusiData.h();
      a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, localPreviewBusiData);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleDownloadResp: return ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", retCode=");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(", retMsg=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.b);
      ((StringBuilder)localObject2).append(", key=");
      if (localDownloadRespInfo.c != null) {
        paramProtoReq = localDownloadRespInfo.c.toStringUtf8();
      } else {
        paramProtoReq = "";
      }
      ((StringBuilder)localObject2).append(paramProtoReq);
      ((StringBuilder)localObject2).append(", strIP=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.d);
      ((StringBuilder)localObject2).append(", port=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.e);
      ((StringBuilder)localObject2).append(", strUrl=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.f);
      ((StringBuilder)localObject2).append(", strHttpsDomain=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.l);
      ((StringBuilder)localObject2).append(", httpsPort=");
      ((StringBuilder)localObject2).append(localDownloadRespInfo.n);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    }
    paramProtoReq = new Bundle();
    if (localDownloadRespInfo.l != null) {
      paramProtoReq.putString("strHttpsDomain", localDownloadRespInfo.l);
    }
    if (localDownloadRespInfo.m != null) {
      paramProtoReq.putString("IPv6Dns", localDownloadRespInfo.m);
    }
    paramProtoReq.putShort("httpsPort", localDownloadRespInfo.n);
    if ((localDownloadRespInfo.o != null) && (localDownloadRespInfo.o.size() > 0))
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll(localDownloadRespInfo.o);
      paramProtoReq.putStringArrayList("ipv6list", (ArrayList)localObject2);
    }
    a(localPreviewBusiData.e(), 5006, bool1, new Object[] { Long.valueOf(l), localDownloadRespInfo.b, localDownloadRespInfo.g, localDownloadRespInfo.c, Boolean.valueOf(bool2), localDownloadRespInfo.d, Short.valueOf(localDownloadRespInfo.e), localDownloadRespInfo.f, localDownloadRespInfo.i, Integer.valueOf(paramProtoResp.resp.getAppSeq()), localDownloadRespInfo.h, localDownloadRespInfo.j, localDownloadRespInfo.k, Long.valueOf(localPreviewBusiData.c()), paramProtoReq });
  }
  
  public final void a(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(d))
    {
      long l = ???.extraData.getLong(d);
      synchronized (this.g)
      {
        FileTransferObserver localFileTransferObserver = (FileTransferObserver)this.g.remove(Long.valueOf(l));
        if (localFileTransferObserver != null)
        {
          ??? = i.obtainMessage();
          ???.what = paramInt;
          ???.obj = new Object[] { localFileTransferObserver, Boolean.valueOf(paramBoolean), paramObject };
          ???.sendToTarget();
          ??? = new StringBuilder();
          ???.append("notifyUI. sendToTarget. seq=");
          ???.append(l);
          ???.append(".type=");
          ???.append(paramInt);
          QLog.i("FileTransferHandler<FileAssistant>", 1, ???.toString());
          return;
        }
        ??? = new StringBuilder();
        ???.append("notifyUI. not find observer. seq=");
        ???.append(l);
        ???.append(".type=");
        ???.append(paramInt);
        QLog.e("FileTransferHandler<FileAssistant>", 1, ???.toString());
        return;
      }
    }
    ??? = new StringBuilder();
    ???.append("notifyUI. not find seq_key. type=");
    ???.append(paramInt);
    QLog.e("FileTransferHandler<FileAssistant>", 1, ???.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleResponse : req is null");
      }
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      float f1 = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[RES]cmd=");
        localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
        localStringBuilder.append(" app seq:");
        localStringBuilder.append(paramFromServiceMsg.getAppSeq());
        localStringBuilder.append(" during ");
        localStringBuilder.append(this.h.format(f1));
        localStringBuilder.append("sec.");
        QLog.d("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
      }
    }
    if (paramToServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)c(paramToServiceMsg, paramFromServiceMsg));
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleResponse : cmd ");
    paramFromServiceMsg.append(paramToServiceMsg.getServiceCmd().hashCode());
    paramFromServiceMsg.append("unknow");
    QLog.i("FileTransferHandler<FileAssistant>", 1, paramFromServiceMsg.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    long l2 = paramFromServiceMsg.getResultCode();
    long l1;
    Object localObject;
    if ((l2 != 1002L) && (l2 != 1013L))
    {
      l1 = l2;
      if (l2 != 1000L)
      {
        l1 = -100002L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleOffLineFileSendCCSuccess: resp is failed[");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        bool = false;
        break label150;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleOffLineFileSendCCSuccess: resp is timeout[");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      l1 = -100001L;
    }
    boolean bool = true;
    label150:
    int m;
    if (l1 == -100001L) {
      m = 1;
    } else {
      m = 0;
    }
    int n = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if ((m != 0) && (n < 3))
    {
      paramToServiceMsg.extraData.putInt("retryIndex", n + 1);
      return;
    }
    l2 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if ((l2 != 0L) && (l2 != 241L))
    {
      bool = false;
      l1 = l2;
    }
    if ((bool) && (paramLong > 0L))
    {
      FileManagerUtil.a(this.a, paramLong);
      localObject = this.a.getFileManagerDataCenter().b(paramLong);
      if (localObject != null)
      {
        l2 = FileManagerUtil.v(((FileManagerEntity)localObject).fileName);
        if (((FileManagerEntity)localObject).fileSize <= l2)
        {
          localObject = this.a.getMessageProxy(((FileManagerEntity)localObject).peerType).b(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          ((AIOMessageSpreadManager)this.a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((MessageRecord)localObject);
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("can't find File Msg sID:");
          ((StringBuilder)localObject).append(paramLong);
          QLog.e("AIOMessageSpreadManager", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    l2 = paramToServiceMsg.extraData.getLong("uniseq");
    a(paramToServiceMsg, 5014, bool, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(paramLong), Long.valueOf(l2) });
    ForwardOrderManager.a().a(this.a, l2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (MessageFactoryReceiver.OffLineFileInfo)paramObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: ");
      localStringBuilder.append(paramObject.k);
      QLog.d("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
    }
    int m = paramObject.k;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 6) {
            return;
          }
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      long l = paramInt1;
      new Handler((Looper)localObject).post(new FileTransferHandler.10(this, l, paramInt3, paramInt2, paramString));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] Handle upload progress notify. speed=");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" progress =");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.a.getOnlineFileSessionCenter().a(paramString, paramInt1, paramInt3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      long l = paramInt1;
      new Handler((Looper)localObject).post(new FileTransferHandler.9(this, l, paramInt2, paramString2, paramString1));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] Handle upload failed notify. retCode =");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("(1:cancel upload) reason=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (1 == paramInt2)
    {
      this.a.getOnlineFileSessionCenter().b(paramString1, paramInt1);
      return;
    }
    if (2 == paramInt2)
    {
      this.a.getOnlineFileSessionCenter().b(paramString1, paramInt1);
      return;
    }
    if (3 == paramInt2)
    {
      this.a.getOnlineFileSessionCenter().d(paramString1, paramInt1);
      return;
    }
    this.a.getOnlineFileSessionCenter().b(paramString1, paramInt1);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new FileTransferHandler.11(this, paramLong1, paramString1, paramInt, paramString2, paramLong2));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("] upload competed:");
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.a.getOnlineFileSessionCenter().a(paramString1, paramLong1, paramInt, paramString2, paramLong2);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new FileTransferHandler.6(this, paramLong, paramBoolean, paramString));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]  handle recv onlinefile resp. sucess =");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.a.getOnlineFileSessionCenter().a(paramString, paramLong, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PreviewOfflineFile : FileUUID[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    localPBUInt32Field.set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        ((cmd0x346.ApplyDownloadAbsReq)localObject).str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform not enabled");
    }
    paramString2 = new FileTransferHandler.PreviewBusiData(this);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getOfflineVideoThumbInfo : FileUUID[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    localPBUInt32Field.set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        ((cmd0x346.ApplyDownloadAbsReq)localObject).str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform not enabled");
    }
    paramString2 = new FileTransferHandler.PreviewBusiData(this, true, paramLong);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, BuddyTransfileProcessor.A9Message paramA9Message, long paramLong1, short paramShort, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->>getOffLineFile--toUin: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" filePath: ");
      ((StringBuilder)localObject).append(paramA9Message.serverPath);
      ((StringBuilder)localObject).append(" delUin: ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b("TransService.ReqOffFilePack");
    ((ToServiceMsg)localObject).extraData.putString("selfuin", this.a.getCurrentAccountUin());
    ((ToServiceMsg)localObject).extraData.putString("uin", paramString2);
    ((ToServiceMsg)localObject).extraData.putByteArray("filepath", paramA9Message.serverPath.getBytes());
    ((ToServiceMsg)localObject).extraData.putInt("offfile_type", 0);
    ((ToServiceMsg)localObject).extraData.putLong("msgTime", paramLong1);
    ((ToServiceMsg)localObject).extraData.putShort("msgSeq", paramShort);
    ((ToServiceMsg)localObject).extraData.putLong("delUin", paramLong2);
    ((ToServiceMsg)localObject).extraData.putByte("type", paramA9Message.type);
    ((ToServiceMsg)localObject).extraData.putInt("retryIndex", 0);
    ((ToServiceMsg)localObject).extraData.putString("friendUin", paramString1);
    ((ToServiceMsg)localObject).extraData.putBoolean("isRead", paramBoolean);
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, FMConstants.RevertMsgCallback paramRevertMsgCallback)
  {
    cmd0x345.ReqBody.SubCmd0xaReqBody localSubCmd0xaReqBody = new cmd0x345.ReqBody.SubCmd0xaReqBody();
    try
    {
      localSubCmd0xaReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
      localSubCmd0xaReqBody.uint64_uin.set(Long.parseLong(paramString2));
      localSubCmd0xaReqBody.str_file_id.set(paramString3);
      paramString1 = new cmd0x345.ReqBody();
      paramString1.msg_subcmd_0xa_req_body.set(localSubCmd0xaReqBody);
      paramString1.uint32_sub_cmd.set(10);
      paramString2 = new FileTransferHandler.PreviewBusiData(this);
      FileTransferHandler.PreviewBusiData.a(paramString2, 10);
      FileTransferHandler.PreviewBusiData.a(paramString2, paramRevertMsgCallback);
      a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramRevertMsgCallback.a(-1, paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int m = 2;
    if (bool)
    {
      paramString4 = new StringBuilder();
      paramString4.append("RemoveOfflineFile : PeerUin[");
      paramString4.append(FileManagerUtil.k(paramString1));
      paramString4.append("], FileUUID[");
      paramString4.append(paramString2);
      paramString4.append("], bSend[");
      paramString4.append(paramBoolean);
      paramString4.append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramString4.toString());
    }
    if (paramBoolean) {
      m = 1;
    }
    paramString4 = new cmd0x346.DeleteFileReq();
    this.a.getCurrentAccountUin();
    try
    {
      long l1 = Long.parseLong(this.a.getCurrentAccountUin());
      long l2 = Long.parseLong(paramString1);
      paramString4.uint64_uin.set(l1);
      paramString4.uint64_peer_uin.set(l2);
      paramString4.uint32_delete_type.set(m);
      paramString4.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      paramString1 = new cmd0x346.ReqBody();
      paramString1.msg_delete_file_req.set(paramString4);
      paramString1.uint32_cmd.set(900);
      PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
      m = e;
      e = m + 1;
      localPBUInt32Field.set(m);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      if (a())
      {
        paramString1.uint32_flag_support_mediaplatform.set(1);
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString4.str_fileidcrc.set(paramString3);
          QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled");
        }
        else
        {
          QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
        }
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform not enabled");
      }
      paramString2 = new FileTransferHandler.PreviewBusiData(this, paramString2);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDownloadSuccState : selfUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.k(paramString1));
      ((StringBuilder)localObject).append("], filePath[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x346.DownloadSuccReq();
    ((cmd0x346.DownloadSuccReq)localObject).uint64_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.DownloadSuccReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_download_succ_req.set((MessageMicro)localObject);
    paramString1.uint32_cmd.set(1000);
    paramString2 = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    paramString2.set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        ((cmd0x346.DownloadSuccReq)localObject).str_fileidcrc.set(paramString3);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled, but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform not enabled");
    }
    paramString2 = new FileTransferHandler.PreviewBusiData(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, FileTransferObserver paramFileTransferObserver)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    if (paramBoolean1) {
      m = 1;
    } else {
      m = 2;
    }
    localApplyDownloadReq.uint32_owner_type.set(m);
    if (paramBoolean2) {
      localApplyDownloadReq.uint32_need_https_url.set(1);
    }
    paramString1 = new cmd0x346.ReqBody();
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled, but FileIdCrc is null");
      }
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform not enabled");
    }
    paramString1.msg_apply_download_req.set(localApplyDownloadReq);
    paramString1.uint32_cmd.set(1200);
    paramString2 = paramString1.uint32_seq;
    int m = e;
    e = m + 1;
    paramString2.set(m);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new cmd0x346.ExtensionReq();
    paramString2.uint32_download_url_type.set(1);
    paramString1.msg_extension_req.set(paramString2);
    paramString2 = new FileTransferHandler.PreviewBusiData(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, FileTransferHandler.PreviewBusiData paramPreviewBusiData)
  {
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramPreviewBusiData;
    a(localProtoReq);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, FileTransferHandler.PreviewBusiData paramPreviewBusiData, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramPreviewBusiData;
    localProtoReq.tryTime = paramInt1;
    localProtoReq.tryCount = paramInt2;
    localProtoReq.fixScheduleCount = paramInt3;
    a(localProtoReq);
  }
  
  protected boolean a()
  {
    return ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).isMediaPlatformEnabled();
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    paramFMTransC2CMsgInfo.subCmd = paramInt2;
    if (paramFMTransC2CMsgInfo.fileTransferObserver != null) {
      synchronized (this.g)
      {
        paramFMTransC2CMsgInfo.observerSeq = this.f;
        this.g.put(Long.valueOf(this.f), paramFMTransC2CMsgInfo.fileTransferObserver);
        this.f += 1L;
      }
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("send0x211c2cMsg transC2CMsgInfo:");
      ((StringBuilder)???).append(paramFMTransC2CMsgInfo.toString());
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)???).toString());
    }
    return this.a.getMsgHandler().D().a(paramString, paramInt1, paramArrayOfByte, paramFMTransC2CMsgInfo);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    localOnlineFileSessionInfo.f = ((byte[])c.clone());
    localOnlineFileSessionInfo.j = 4;
    localOnlineFileSessionInfo.c = paramLong;
    byte[] arrayOfByte = this.a.getFileTransferHandler().a(localOnlineFileSessionInfo);
    if (arrayOfByte == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(localOnlineFileSessionInfo.c);
      paramString.append("]. recvOnLineFile failed:");
      QLog.e("FileTransferHandler<FileAssistant>", 1, paramString.toString());
      return false;
    }
    return this.a.getMsgHandler().D().a(paramString, paramLong, 133, arrayOfByte);
  }
  
  public boolean a(String paramString, FileManagerEntity paramFileManagerEntity, FileTransferObserver paramFileTransferObserver)
  {
    Object localObject1 = this.a.getMessageFacade().b(paramString, 0, paramFileManagerEntity.uniseq);
    if (localObject1 != null)
    {
      paramFileManagerEntity.msgSeq = ((MessageRecord)localObject1).msgseq;
      paramFileManagerEntity.msgUid = ((MessageRecord)localObject1).msgUid;
    }
    SubMsgType0x4.MsgBody localMsgBody = new SubMsgType0x4.MsgBody();
    localObject1 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject1).uint32_file_type.set(0);
    ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFrom(paramFileManagerEntity.fileName.getBytes()));
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      ((im_msg_body.NotOnlineFile)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5)));
    }
    ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(1);
    if (paramFileManagerEntity.bUseMediaPlatform)
    {
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        ((im_msg_body.NotOnlineFile)localObject1).str_fileidcrc_media.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    else {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform not enabled");
    }
    localMsgBody.msg_not_online_file.set((MessageMicro)localObject1);
    Object localObject2;
    if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName))
    {
      localObject1 = new hummer_resv_21.ResvAttr();
      localObject2 = new hummer_resv_21.FileApkInfo();
      if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName)) {
        ((hummer_resv_21.FileApkInfo)localObject2).str_package_name.set(paramFileManagerEntity.yybApkPackageName);
      }
      if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkName)) {
        ((hummer_resv_21.FileApkInfo)localObject2).str_app_name.set(paramFileManagerEntity.yybApkName);
      }
      if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkIconUrl)) {
        ((hummer_resv_21.FileApkInfo)localObject2).str_icon_url.set(paramFileManagerEntity.yybApkIconUrl);
      }
      ((hummer_resv_21.ResvAttr)localObject1).file_apk_info.set((MessageMicro)localObject2);
      localMsgBody.resv_attr.set((MessageMicro)localObject1);
    }
    if (QFileAssistantUtils.a(paramString))
    {
      if (localMsgBody.resv_attr.has()) {
        localObject1 = (hummer_resv_21.ResvAttr)localMsgBody.resv_attr.get();
      } else {
        localObject1 = new hummer_resv_21.ResvAttr();
      }
      localObject2 = new hummer_resv_21.FileAssitInfo();
      ((hummer_resv_21.FileAssitInfo)localObject2).uint64_session_id.set(paramFileManagerEntity.nSessionId);
      ((hummer_resv_21.FileAssitInfo)localObject2).uint32_group_id.set(paramFileManagerEntity.dlGroupId);
      ((hummer_resv_21.FileAssitInfo)localObject2).uint32_group_count.set(paramFileManagerEntity.dlGroupCount);
      ((hummer_resv_21.FileAssitInfo)localObject2).uint32_group_idx.set(paramFileManagerEntity.dlGourpIndex);
      ((hummer_resv_21.ResvAttr)localObject1).file_assist_info.set((MessageMicro)localObject2);
      ((hummer_resv_21.ResvAttr)localObject1).device_type.set(QFileAssistantUtils.c());
      localMsgBody.resv_attr.set((MessageMicro)localObject1);
    }
    ThreadManager.executeOnSubThread(new FileTransferHandler.7(this, paramFileManagerEntity, new hummer_resv_21.FileImgInfo(), localMsgBody, paramFileTransferObserver, new Handler(Looper.getMainLooper()), paramString));
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    im_msg_body.NotOnlineFile localNotOnlineFile = new im_msg_body.NotOnlineFile();
    localNotOnlineFile.uint32_file_type.set(1);
    localNotOnlineFile.bytes_file_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localNotOnlineFile.uint64_file_size.set(paramLong1);
    localNotOnlineFile.bytes_file_name.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localNotOnlineFile.uint32_subcmd.set(2);
    ((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.set(localNotOnlineFile);
    paramString2 = ((SubMsgType0x4.MsgBody)localObject).toByteArray();
    localObject = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject).busiType = 1029;
    ((FMTransC2CMsgInfo)localObject).uuid = paramString3;
    ((FMTransC2CMsgInfo)localObject).msgSeq = FileManagerUtil.f();
    ((FMTransC2CMsgInfo)localObject).msgUid = FileManagerUtil.g();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public boolean a(SubMsgType0x4.WlanRecvNotify paramWlanRecvNotify)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    ((SubMsgType0x4.MsgBody)localObject).msg_wlan_recved_notify.set(paramWlanRecvNotify);
    paramWlanRecvNotify = ((SubMsgType0x4.MsgBody)localObject).toByteArray();
    localObject = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject).busiType = 1055;
    ((FMTransC2CMsgInfo)localObject).msgSeq = FileManagerUtil.f();
    ((FMTransC2CMsgInfo)localObject).msgUid = FileManagerUtil.g();
    return a(QFileAssistantUtils.b(this.a), 529, 4, paramWlanRecvNotify, (FMTransC2CMsgInfo)localObject);
  }
  
  public byte[] a(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    PkgTools.copyData(arrayOfByte, 0, paramOnlineFileSessionInfo.f, 16);
    PkgTools.dWord2Byte(arrayOfByte, 22, paramOnlineFileSessionInfo.c);
    PkgTools.word2Byte(arrayOfByte, 28, paramOnlineFileSessionInfo.j);
    PkgTools.word2Byte(arrayOfByte, 30, (short)1);
    arrayOfByte[32] = 1;
    PkgTools.word2Byte(arrayOfByte, 35, (short)11);
    arrayOfByte[37] = 15;
    PkgTools.word2Byte(arrayOfByte, 38, (short)1);
    arrayOfByte[40] = 1;
    arrayOfByte[41] = 16;
    PkgTools.word2Byte(arrayOfByte, 42, (short)4);
    PkgTools.dWord2Byte(arrayOfByte, 44, this.a.getAppid());
    paramOnlineFileSessionInfo = new byte[48];
    PkgTools.copyData(paramOnlineFileSessionInfo, 0, arrayOfByte, 48);
    return paramOnlineFileSessionInfo;
  }
  
  public OnlineFileSessionInfo b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int m = paramArrayOfByte.length;
      OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
      if (m >= 16)
      {
        PkgTools.getBytesData(paramArrayOfByte, 0, localOnlineFileSessionInfo.f, 16);
        if (m >= 26)
        {
          localOnlineFileSessionInfo.c = PkgTools.getLongData(paramArrayOfByte, 22);
          if (m >= 30)
          {
            localOnlineFileSessionInfo.j = PkgTools.getShortData(paramArrayOfByte, 28);
            if (m >= 32)
            {
              int n = PkgTools.getShortData(paramArrayOfByte, 30);
              if (n < 2) {
                if (m >= 34)
                {
                  localOnlineFileSessionInfo.k = PkgTools.getShortData(paramArrayOfByte, 32);
                }
                else
                {
                  QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
                  return null;
                }
              }
              n = 32 + n + 2;
              int i1 = n + 2;
              if (m >= i1)
              {
                n = PkgTools.getShortData(paramArrayOfByte, n);
                if (n < 4)
                {
                  localOnlineFileSessionInfo.i = false;
                  return localOnlineFileSessionInfo;
                }
                byte[] arrayOfByte = new byte[n];
                PkgTools.getBytesData(paramArrayOfByte, i1, arrayOfByte, n);
                m = 0;
                while (m < n)
                {
                  i1 = arrayOfByte[m];
                  int i2 = m + 1;
                  m = i2 + 2;
                  if (n > m)
                  {
                    i2 = PkgTools.getShortData(arrayOfByte, i2);
                    if (i1 == 15)
                    {
                      if (i2 != 1)
                      {
                        localOnlineFileSessionInfo.i = false;
                      }
                      else if (n >= m + i2)
                      {
                        paramArrayOfByte = new byte[i2];
                        PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i2);
                        boolean bool;
                        if (paramArrayOfByte[0] == 1) {
                          bool = true;
                        } else {
                          bool = false;
                        }
                        localOnlineFileSessionInfo.i = bool;
                      }
                    }
                    else if (i1 == 4)
                    {
                      paramArrayOfByte = new byte[i2];
                      if (n >= m + i2)
                      {
                        PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i2);
                        paramArrayOfByte = c(paramArrayOfByte);
                        if (paramArrayOfByte != null)
                        {
                          localOnlineFileSessionInfo.a = paramArrayOfByte.a;
                          localOnlineFileSessionInfo.b = paramArrayOfByte.b;
                        }
                        else
                        {
                          QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
                          return null;
                        }
                      }
                      else
                      {
                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
                        return localOnlineFileSessionInfo;
                      }
                    }
                    m = i2 + m;
                  }
                  else
                  {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
                  }
                }
                return localOnlineFileSessionInfo;
              }
              QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
              return null;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
            return null;
          }
          QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
          return null;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
        return null;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
    return null;
  }
  
  public cmd0x346.ApplyUploadReqV3 b(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    paramCmd0x346CSBody = paramCmd0x346CSBody.b;
    localApplyUploadReqV3.uint64_sender_uin.set(paramCmd0x346CSBody.a);
    localApplyUploadReqV3.uint64_recver_uin.set(paramCmd0x346CSBody.b);
    localApplyUploadReqV3.uint64_file_size.set(paramCmd0x346CSBody.c);
    localApplyUploadReqV3.str_file_name.set(paramCmd0x346CSBody.d);
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.e));
    if (paramCmd0x346CSBody.f != null) {
      localApplyUploadReqV3.bytes_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.f));
    }
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.g));
    if (paramCmd0x346CSBody.h != null) {
      localApplyUploadReqV3.bytes_3sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.h));
    }
    localApplyUploadReqV3.uint32_contenttype.set(0);
    localApplyUploadReqV3.str_local_filepath.set(paramCmd0x346CSBody.i);
    localApplyUploadReqV3.uint32_danger_level.set(paramCmd0x346CSBody.j);
    localApplyUploadReqV3.uint64_total_space.set(paramCmd0x346CSBody.k);
    return localApplyUploadReqV3;
  }
  
  public void b()
  {
    face2face_file.msg localmsg = new face2face_file.msg();
    localmsg.version.set(1);
    localmsg.result.set(0);
    a("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ", localmsg.toByteArray(), null);
  }
  
  public void b(int paramInt1, int paramInt2, FileTransferObserver paramFileTransferObserver, int paramInt3)
  {
    Object localObject = new cmd0x346.SendListQueryReq();
    ((cmd0x346.SendListQueryReq)localObject).uint64_uin.set(this.a.getLongAccountUin());
    ((cmd0x346.SendListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.SendListQueryReq)localObject).uint32_req_count.set(paramInt2);
    ((cmd0x346.SendListQueryReq)localObject).uint32_filter_filetype.set(paramInt3);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_send_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(200);
    localObject = localReqBody.uint32_seq;
    paramInt1 = e;
    e = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform enabled");
    }
    else
    {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform not enabled");
    }
    paramFileTransferObserver = new FileTransferHandler.PreviewBusiData(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200", localReqBody.toByteArray(), paramFileTransferObserver, 10000, 3, 1);
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.4(this, paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2, paramInt3));
      return;
    }
    a(paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2, paramInt3);
  }
  
  public void b(OfflineFileUploadPara paramOfflineFileUploadPara, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramOfflineFileUploadPara = b(paramOfflineFileUploadPara);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= ^! [CS Send] Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("]SendOfflineFileHit");
    QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
    a(1L, 1800, false, paramOfflineFileUploadPara, paramFileTransferObserver, paramFileManagerEntity);
  }
  
  protected void b(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    Object localObject;
    if (a(paramProtoResp))
    {
      localFileUploadInfo.a = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDownloadSuccResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localFileUploadInfo.a = -100002;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDownloadSuccResponse: resp is failed[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = paramProtoResp.resp.getWupBuffer();
      cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (!localRspBody.msg_download_succ_rsp.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.a = -100003;
        }
        else
        {
          localObject = (cmd0x346.DownloadSuccRsp)localRspBody.msg_download_succ_rsp.get();
          if (((cmd0x346.DownloadSuccRsp)localObject).int32_ret_code.has()) {
            localFileUploadInfo.a = ((cmd0x346.DownloadSuccRsp)localObject).int32_ret_code.get();
          }
          if (((cmd0x346.DownloadSuccRsp)localObject).str_ret_msg.has()) {
            localFileUploadInfo.b = ((cmd0x346.DownloadSuccRsp)localObject).str_ret_msg.get();
          }
          if (((cmd0x346.DownloadSuccRsp)localObject).int32_down_stat.has()) {
            localFileUploadInfo.l = ((cmd0x346.DownloadSuccRsp)localObject).int32_down_stat.get();
          }
          bool = true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    boolean bool = false;
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = localFileUploadInfo.a;
    localStatictisInfo.c = paramProtoResp.freeRunnalbleIndex;
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("handleDownloadSuccResponse: return ");
      paramProtoResp.append(bool);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      paramProtoResp.append(", retStat");
      paramProtoResp.append(localFileUploadInfo.l);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5007, bool, new Object[] { localFileUploadInfo, localStatictisInfo });
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2 = paramFromServiceMsg.getResultCode();
    long l1;
    StringBuilder localStringBuilder;
    if ((l2 != 1002L) && (l2 != 1013L))
    {
      l1 = l2;
      if (l2 != 1000L)
      {
        l1 = -100002L;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleWlanNotify: resp is failed[");
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
        bool = false;
        break label150;
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWlanNotify: resp is timeout[");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
      l1 = -100001L;
    }
    boolean bool = true;
    label150:
    int m;
    if (l1 == -100001L) {
      m = 1;
    } else {
      m = 0;
    }
    int n = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if ((m != 0) && (n < 3))
    {
      paramToServiceMsg.extraData.putInt("retryIndex", n + 1);
      return;
    }
    l2 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if ((l2 != 0L) && (l2 != 241L))
    {
      bool = false;
      l1 = l2;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleWlanNotify bSuccess: ");
    paramToServiceMsg.append(bool);
    paramToServiceMsg.append(", serverCode : ");
    paramToServiceMsg.append(l1);
    QLog.i("FileTransferHandler<FileAssistant>", 1, paramToServiceMsg.toString());
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new FileTransferHandler.8(this, paramLong, paramBoolean, paramString));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]  handle query onlinefile upload progress resp. sucess =");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.a.getOnlineFileSessionCenter().b(paramString, paramLong, paramBoolean);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PreviewOfflineFile : FileUUID[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    ((cmd0x345.ReqBody.SubCmd0x7ReqBody)localObject).uint64_disscus_uin.set(Long.parseLong(paramString1));
    ((cmd0x345.ReqBody.SubCmd0x7ReqBody)localObject).str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set((MessageMicro)localObject);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new FileTransferHandler.PreviewBusiData(this, false, 0L, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void b(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDiscVideoThumbInfo : FileUUID[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    ((cmd0x345.ReqBody.SubCmd0x7ReqBody)localObject).uint64_disscus_uin.set(Long.parseLong(paramString1));
    ((cmd0x345.ReqBody.SubCmd0x7ReqBody)localObject).str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set((MessageMicro)localObject);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new FileTransferHandler.PreviewBusiData(this, true, paramLong, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void b(SubMsgType0x4.WlanRecvNotify paramWlanRecvNotify)
  {
    if (!c(paramWlanRecvNotify))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify param failed");
      return;
    }
    long l2 = paramWlanRecvNotify.uint64_session_id.get();
    if (this.a.getFileManagerDataCenter().f(l2))
    {
      paramWlanRecvNotify = new StringBuilder();
      paramWlanRecvNotify.append(l2);
      paramWlanRecvNotify.append(" is exsited, igone!");
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramWlanRecvNotify.toString());
      return;
    }
    int m = paramWlanRecvNotify.uint32_send_client_type.get();
    int n = paramWlanRecvNotify.uint32_target_client_type.get();
    int i1 = QFileAssistantUtils.c();
    int i2 = QFileAssistantUtils.c(m);
    int i3 = QFileAssistantUtils.c(n);
    int i4 = QFileAssistantUtils.c(i1);
    long l1 = l2;
    if (i2 == 2) {
      l1 = l2 | 0x0;
    }
    if (this.a.getFileManagerDataCenter().a(l1) != null)
    {
      paramWlanRecvNotify = new StringBuilder();
      paramWlanRecvNotify.append(l1);
      paramWlanRecvNotify.append(" is exsited, igone!");
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramWlanRecvNotify.toString());
      return;
    }
    Object localObject = paramWlanRecvNotify.str_file_name.get();
    l2 = paramWlanRecvNotify.uint64_file_size.get();
    int i5 = paramWlanRecvNotify.uint32_time.get();
    paramWlanRecvNotify = QFileAssistantUtils.b(this.a);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = l1;
    localFileManagerEntity.uniseq = FileManagerUtil.a().longValue();
    localFileManagerEntity.peerUin = paramWlanRecvNotify;
    localFileManagerEntity.fileName = ((String)localObject);
    localFileManagerEntity.fileSize = l2;
    localFileManagerEntity.msgTime = i5;
    localFileManagerEntity.bDelInFM = true;
    boolean bool = false;
    localFileManagerEntity.cloudType = 0;
    localFileManagerEntity.bOnceSuccess = true;
    if (i2 == i4) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendType:");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(",recvType:");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(",currentType:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(",parentSendType:");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(",parentCurrentType:");
    ((StringBuilder)localObject).append(i4);
    QLog.i("FileTransferHandler<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    if ((i4 != i2) && (i4 != i3))
    {
      localFileManagerEntity.status = 5;
      localFileManagerEntity.nOpType = 11;
    }
    else
    {
      localFileManagerEntity.status = 16;
      localFileManagerEntity.cloudType = 1;
    }
    localObject = this.a.getCurrentUin();
    this.a.getFileManagerDataCenter().a(localFileManagerEntity);
    this.a.getFileManagerDataCenter().a(paramWlanRecvNotify, (String)localObject, bool, m, localFileManagerEntity);
    this.a.getFileManagerDataCenter().e(l1);
  }
  
  public boolean b(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo != null)
    {
      c.equals(paramOnlineFileSessionInfo.f);
      if (!paramOnlineFileSessionInfo.i)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(paramOnlineFileSessionInfo.c);
        localStringBuilder.append("]  is not surpport mulitendpoint");
        QLog.e("FileTransferHandler<FileAssistant>", 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, long paramLong)
  {
    Object localObject = new SubMsgType0x5.MsgBody();
    ((SubMsgType0x5.MsgBody)localObject).uint32_sessionid.set((int)paramLong);
    localObject = ((SubMsgType0x5.MsgBody)localObject).toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.sessionId = paramLong;
    localFMTransC2CMsgInfo.busiType = 1025;
    localFMTransC2CMsgInfo.msgSeq = FileManagerUtil.f();
    localFMTransC2CMsgInfo.msgUid = FileManagerUtil.g();
    localFMTransC2CMsgInfo.entity = this.a.getFileManagerDataCenter().a(paramLong);
    return a(paramString, 529, 5, (byte[])localObject, localFMTransC2CMsgInfo);
  }
  
  public cmd0x346.ApplyUploadHitReqV2 c(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    paramCmd0x346CSBody = paramCmd0x346CSBody.c;
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramCmd0x346CSBody.a);
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramCmd0x346CSBody.b);
    localApplyUploadHitReqV2.uint64_file_size.set(paramCmd0x346CSBody.c);
    localApplyUploadHitReqV2.str_file_name.set(paramCmd0x346CSBody.d);
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.e));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.f));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.g));
    localApplyUploadHitReqV2.str_local_filepath.set(paramCmd0x346CSBody.h);
    localApplyUploadHitReqV2.uint32_danger_level.set(paramCmd0x346CSBody.i);
    localApplyUploadHitReqV2.uint64_total_space.set(paramCmd0x346CSBody.j);
    return localApplyUploadHitReqV2;
  }
  
  public void c()
  {
    if (this.a.getCurrentAccountUin() != null)
    {
      Object localObject1 = this.a.getApplication().getSharedPreferences("wifiphoto_smart_reminder", 0);
      long l1 = ((SharedPreferences)localObject1).getLong("wifiphoto_smart_reminder_last_time", 0L);
      long l2 = MessageCache.c();
      if (l2 - l1 > 86400L)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("wifiphoto_smart_reminder_last_time", l2);
        ((SharedPreferences.Editor)localObject1).commit();
        boolean bool = SystemUtil.a();
        l1 = SystemUtil.b();
        l2 = SystemUtil.c();
        if ((bool) && (l1 != 0L)) {
          l1 = Math.min(l1, l2) * 1024L;
        } else {
          l1 = l2 * 1024L;
        }
        l2 = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getPicCount(this.a.getApplication());
        if ((l1 <= 1073741824L) && (l2 >= 50L))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("freeSize", l1);
            ((JSONObject)localObject1).put("deviceType", 2);
            ((JSONObject)localObject1).put("subtype", "8");
            ((JSONObject)localObject1).put("photoCount", l2);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd();
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint64_sessionid.set(1L);
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_size.set(1);
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_index.set(0);
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_type.set(5);
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(((JSONObject)localObject1).toString().getBytes()));
          ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).setHasFlag(true);
          localObject1 = new SubMsgType0x7.MsgBody();
          ((SubMsgType0x7.MsgBody)localObject1).uint32_sub_cmd.set(4);
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_app_id.set(1001);
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_inst_id.set(AppSetting.d());
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_app_id.set(1);
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_inst_id.set(1);
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_dst_uin.set(Long.valueOf(this.a.getCurrentAccountUin()).longValue());
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_src_uin.set(Long.valueOf(this.a.getCurrentAccountUin()).longValue());
          ((SubMsgType0x7.MsgBody)localObject1).msg_header.setHasFlag(true);
          ((SubMsgType0x7.MsgBody)localObject1).msg_subcmd_0x4_generic.set((MessageMicro)localObject2);
          ((SubMsgType0x7.MsgBody)localObject1).setHasFlag(true);
          localObject2 = this.a.getCurrentAccountUin();
          Object localObject3 = ((SubMsgType0x7.MsgBody)localObject1).toByteArray();
          localObject1 = b("MessageSvc.PbSendMsg");
          ((ToServiceMsg)localObject1).extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
          ((ToServiceMsg)localObject1).extraData.putInt("ROUNTING_TYPE", 13);
          ((ToServiceMsg)localObject1).extraData.putBoolean("ISFROM_DATALINE", true);
          ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_CMD", 1002);
          ((ToServiceMsg)localObject1).addAttribute("cookie", Integer.valueOf(1));
          ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
          l1 = FileManagerUtil.g();
          l2 = FileManagerUtil.f();
          TransMsgContext localTransMsgContext = new TransMsgContext();
          localTransMsgContext.a = 7;
          localTransMsgContext.b = ((byte[])localObject3);
          localObject2 = MessageProtoCodec.a(this.a, 13, (String)localObject2, localTransMsgContext, l2, MessageUtils.b(l1));
          localObject3 = new im_msg_head.InstInfo();
          ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1);
          ((im_msg_head.InstInfo)localObject3).uint32_instid.set(1);
          ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
          ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject3);
          localObject3 = new im_msg_head.InstInfo();
          ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1001);
          ((im_msg_head.InstInfo)localObject3).uint32_instid.set(AppSetting.d());
          ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
          ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject3);
          ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
          ((ToServiceMsg)localObject1).putWupBuffer(((msg_svc.PbSendMsgReq)localObject2).toByteArray());
          if (localObject1 != null)
          {
            ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
            this.a.sendToService((ToServiceMsg)localObject1);
          }
        }
      }
    }
  }
  
  protected void c(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool = a(paramProtoResp);
    String str1 = "";
    Object localObject1;
    int m;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePreviewResponse: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      m = -100001;
    }
    short s;
    Object localObject2;
    String str2;
    String str3;
    int i1;
    String str4;
    Object localObject3;
    for (;;)
    {
      paramProtoResp = null;
      for (;;)
      {
        s = 0;
        localObject2 = null;
        localObject1 = null;
        bool = false;
        str2 = null;
        str3 = null;
        i1 = 0;
        str4 = null;
        localObject3 = null;
        break label657;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handlePreviewResponse: resp is failed[");
          ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
          ((StringBuilder)localObject1).append("]");
          QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
          m = -100002;
          break;
        }
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
          }
          else
          {
            localObject1 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.get();
            if (((cmd0x346.ApplyDownloadAbsRsp)localObject1).int32_ret_code.has()) {
              m = ((cmd0x346.ApplyDownloadAbsRsp)localObject1).int32_ret_code.get();
            } else {
              m = 0;
            }
            if (((cmd0x346.ApplyDownloadAbsRsp)localObject1).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x346.ApplyDownloadAbsRsp)localObject1).str_ret_msg.get();
            } else {
              paramProtoResp = null;
            }
            if ((m == 0) && (!((cmd0x346.ApplyDownloadAbsRsp)localObject1).msg_download_info.has()))
            {
              QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
              m = -100003;
              continue;
            }
            localObject3 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject1).msg_download_info.get();
            str2 = ((cmd0x346.DownloadInfo)localObject3).str_download_ip.get();
            str3 = ((cmd0x346.DownloadInfo)localObject3).str_download_domain.get();
            i1 = ((cmd0x346.DownloadInfo)localObject3).uint32_port.get();
            str4 = ((cmd0x346.DownloadInfo)localObject3).str_download_url.get();
            if (((cmd0x346.DownloadInfo)localObject3).str_cookie.has())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("FTN5K=");
              ((StringBuilder)localObject1).append(((cmd0x346.DownloadInfo)localObject3).str_cookie.get());
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            else
            {
              localObject1 = null;
            }
            if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has())
            {
              if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handlePreviewResponse: bUseMediaPlatform ");
              ((StringBuilder)localObject2).append(bool);
              QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
              bool = false;
            }
            if (bool) {
              localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_media_platform_download_key.get();
            } else {
              localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_download_key.get();
            }
            localObject4 = HexUtil.bytes2HexStr(((ByteStringMicro)localObject2).toByteArray());
            if (((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.has()) {
              localObject2 = ((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.get();
            } else {
              localObject2 = null;
            }
            if (((cmd0x346.DownloadInfo)localObject3).uint32_https_port.has()) {
              s = (short)((cmd0x346.DownloadInfo)localObject3).uint32_https_port.get();
            } else {
              s = 0;
            }
            if (((cmd0x346.DownloadInfo)localObject3).str_download_dns.has()) {
              str1 = ((cmd0x346.DownloadInfo)localObject3).str_download_dns.get();
            }
            bool = true;
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = -100003;
        }
      }
    }
    label657:
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("handlePreviewResponse: return ");
      ((StringBuilder)localObject4).append(bool);
      ((StringBuilder)localObject4).append(", retCode=");
      ((StringBuilder)localObject4).append(m);
      ((StringBuilder)localObject4).append(", retMsg=");
      ((StringBuilder)localObject4).append(paramProtoResp);
      ((StringBuilder)localObject4).append(", Key=");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(", IP=");
      ((StringBuilder)localObject4).append(str2);
      ((StringBuilder)localObject4).append(", Domain=");
      ((StringBuilder)localObject4).append(str3);
      ((StringBuilder)localObject4).append(", port=");
      ((StringBuilder)localObject4).append(i1);
      ((StringBuilder)localObject4).append(", strHttpsDomain=");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(", httpsPort=");
      ((StringBuilder)localObject4).append(s);
      ((StringBuilder)localObject4).append("ipv6Domain=");
      ((StringBuilder)localObject4).append(str1);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject4).toString());
    }
    int n;
    if (m == -100001)
    {
      n = 9043;
    }
    else
    {
      n = m;
      if (m == -100003) {
        n = 9045;
      }
    }
    if (n != 0) {
      bool = false;
    }
    paramProtoReq = (FileTransferHandler.PreviewBusiData)paramProtoReq.busiData;
    Object localObject4 = new Bundle();
    if (localObject1 != null) {
      ((Bundle)localObject4).putString("strHttpsDomain", (String)localObject1);
    }
    ((Bundle)localObject4).putShort("httpsPort", s);
    if (!TextUtils.isEmpty(str1)) {
      ((Bundle)localObject4).putString("IPv6Dns", str1);
    }
    if (paramProtoReq.a())
    {
      this.a.getFileManagerNotifyCenter().a(bool, 191, new Object[] { Integer.valueOf(n), paramProtoResp, localObject3, localObject2, str2, str3, Integer.valueOf(i1), str4, Long.valueOf(paramProtoReq.c()), localObject4 });
      return;
    }
    this.a.getFileManagerNotifyCenter().a(bool, 18, new Object[] { Integer.valueOf(n), paramProtoResp, localObject3, localObject2, str2, str3, Integer.valueOf(i1), localObject4 });
  }
  
  protected void d(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool1 = a(paramProtoResp);
    int m = -100003;
    long l2 = 0L;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2;
    if (bool1)
    {
      m = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleForwardResponse: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    long l3;
    boolean bool2;
    for (;;)
    {
      l3 = 0L;
      paramProtoResp = null;
      localObject2 = paramProtoResp;
      bool1 = false;
      bool2 = false;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        m = -100002;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleForwardResponse: resp is failed[");
        ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject2).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = paramProtoResp.resp.getWupBuffer();
        paramProtoResp = new cmd0x346.RspBody();
        try
        {
          paramProtoResp.mergeFrom((byte[])localObject2);
          if (!paramProtoResp.msg_apply_forward_file_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          }
          else
          {
            if (paramProtoResp.uint32_flag_use_media_platform.has())
            {
              if (paramProtoResp.uint32_flag_use_media_platform.get() == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleForwardResponse: bUseMediaPlatform ");
              ((StringBuilder)localObject1).append(bool1);
              QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
              bool1 = false;
            }
            cmd0x346.ApplyForwardFileRsp localApplyForwardFileRsp = (cmd0x346.ApplyForwardFileRsp)paramProtoResp.msg_apply_forward_file_rsp.get();
            if (localApplyForwardFileRsp.int32_ret_code.has()) {
              m = localApplyForwardFileRsp.int32_ret_code.get();
            } else {
              m = 0;
            }
            if (localApplyForwardFileRsp.str_ret_msg.has()) {
              paramProtoResp = localApplyForwardFileRsp.str_ret_msg.get();
            } else {
              paramProtoResp = null;
            }
            if (localApplyForwardFileRsp.bytes_uuid.has()) {
              localObject1 = new String(localApplyForwardFileRsp.bytes_uuid.get().toByteArray());
            } else {
              localObject1 = null;
            }
            localObject2 = localObject3;
            if (bool1)
            {
              localObject2 = localObject3;
              if (localApplyForwardFileRsp.str_fileidcrc.has()) {
                localObject2 = localApplyForwardFileRsp.str_fileidcrc.get();
              }
            }
            if (localApplyForwardFileRsp.uint64_total_space.has()) {
              l1 = localApplyForwardFileRsp.uint64_total_space.get();
            } else {
              l1 = 0L;
            }
            if (localApplyForwardFileRsp.uint64_used_space.has()) {
              l2 = localApplyForwardFileRsp.uint64_used_space.get();
            }
            bool2 = bool1;
            l3 = l2;
            bool1 = true;
            localObject3 = paramProtoResp;
            paramProtoResp = (ProtoReqManagerImpl.ProtoResp)localObject1;
            l2 = l1;
            localObject1 = localObject3;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
        }
      }
    }
    if (m != 0) {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleForwardResponse: return ");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(", retCode=");
      ((StringBuilder)localObject3).append(m);
      ((StringBuilder)localObject3).append(", retMsg=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(", totalSpace=");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(", usedSpace=");
      ((StringBuilder)localObject3).append(l3);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject3).toString());
    }
    long l1 = ((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).c();
    if (bool1)
    {
      paramProtoReq = new FileManagerReporter.FileAssistantReportData();
      paramProtoReq.b = "send_file_suc";
      paramProtoReq.c = 1;
      FileManagerReporter.a(this.a.getCurrentAccountUin(), paramProtoReq);
    }
    this.a.getFileManagerDataCenter().a(bool1, m, (String)localObject1, paramProtoResp, bool2, (String)localObject2, l1);
    this.a.getFileManagerNotifyCenter().a(bool1, 19, new Object[] { Integer.valueOf(m), localObject1, Long.valueOf(l2), Long.valueOf(l3), paramProtoResp, Long.valueOf(l1) });
    paramProtoReq = this.a.getFileManagerDataCenter().a(l1);
    if (paramProtoReq != null)
    {
      FileManagerUtil.a(this.a, paramProtoReq);
      if ((paramProtoReq.nOpType == 26) || (paramProtoReq.nOpType == 27)) {
        try
        {
          ((IForwardCallBack)paramProtoReq.mContext).a(bool1, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, m, (String)localObject1, String.valueOf(paramProtoReq.peerUin), paramProtoResp);
          return;
        }
        catch (Exception paramProtoReq)
        {
          paramProtoReq.printStackTrace();
          paramProtoResp = new StringBuilder();
          paramProtoResp.append("handleForwardResponse: Exception is ");
          paramProtoResp.append(paramProtoReq.toString());
          QLog.e("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
        }
      }
    }
  }
  
  protected void e(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    boolean bool1 = a(paramProtoResp);
    boolean bool2 = false;
    Object localObject1;
    int m;
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleForwardFromOfflineResponse: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      m = -100001;
    }
    for (;;)
    {
      localObject1 = null;
      paramProtoResp = null;
      bool1 = false;
      break;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleForwardFromOfflineResponse: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        m = -100002;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.has())
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          }
          else
          {
            localObject1 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.get();
            if (((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.has()) {
              m = ((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.get();
            } else {
              m = 0;
            }
            if (((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.get();
            } else {
              paramProtoResp = null;
            }
            if (((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.has()) {
              localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.get();
            } else {
              localObject1 = null;
            }
            bool1 = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          m = -100003;
        }
      }
    }
    if (m != 0) {
      bool1 = bool2;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleForwardFromOfflineResponse: return ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", retCode=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(", retMsg=");
      ((StringBuilder)localObject2).append(paramProtoResp);
      QLog.d("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    }
    long l = ((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).c();
    paramProtoReq = this.a.getFileManagerDataCenter().a(l);
    if (paramProtoReq == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
      return;
    }
    if (bool1)
    {
      localObject2 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject2).b = "send_file_suc";
      ((FileManagerReporter.FileAssistantReportData)localObject2).c = 1;
      FileManagerReporter.a(this.a.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
    }
    if ((QFileAssistantUtils.a(this.a)) && (QFileAssistantUtils.a(paramProtoReq.peerUin)))
    {
      if (bool1) {
        a(paramProtoReq, (String)localObject1);
      }
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("notify to old device[");
      paramProtoResp.append(bool1);
      paramProtoResp.append("]:");
      paramProtoResp.append(paramProtoReq.nSessionId);
      QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoResp.toString());
      return;
    }
    if ((m == -6101) || (m == -7003))
    {
      paramProtoReq.status = 16;
      if ((paramProtoReq.mContext != null) && ((paramProtoReq.mContext instanceof FileManagerEntity)))
      {
        localObject2 = (FileManagerEntity)paramProtoReq.mContext;
        ((FileManagerEntity)localObject2).status = 16;
        this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
        paramProtoReq.mContext = null;
      }
      this.a.getFileManagerDataCenter().c(paramProtoReq);
    }
    a(l, bool1, m, paramProtoResp, (String)localObject1, paramProtoReq);
  }
  
  public void f(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay]reponse V3");
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    boolean bool1 = a(paramProtoResp);
    Object localObject1 = null;
    Object localObject2;
    if (bool1)
    {
      localFileUploadInfo.a = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_= ^! [CS Replay]handleUploadResponse: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localFileUploadInfo.a = -100002;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_= ^! [CS Replay]handleUploadResponse: resp is failed[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
      localFileUploadInfo.t = arrayOfByte;
      localObject2 = new cmd0x346.RspBody();
      try
      {
        ((cmd0x346.RspBody)localObject2).mergeFrom(arrayOfByte);
        if (!((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp_v3.has())
        {
          localFileUploadInfo.a = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        }
        else
        {
          if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has())
          {
            if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            localFileUploadInfo.u = bool1;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleUploadResponseV3: bUseMediaPlatform ");
            ((StringBuilder)localObject1).append(localFileUploadInfo.u);
            QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
          }
          else
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform false uint32_flag_use_media_platform not set");
          }
          localObject2 = a(localFileUploadInfo, null, (cmd0x346.ApplyUploadRspV3)((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp_v3.get());
          localObject1 = localObject2;
          if (localFileUploadInfo.a == 0)
          {
            bool1 = true;
            localObject1 = localObject2;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    bool1 = false;
    localFileUploadInfo.o = 2;
    int m;
    if ((localFileUploadInfo.f != null) && (localFileUploadInfo.f.length() > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((localFileUploadInfo.h != null) && (localFileUploadInfo.h.length != 0)) {
      n = 0;
    } else {
      n = 1;
    }
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = localFileUploadInfo.a;
    localStatictisInfo.c = paramProtoResp.freeRunnalbleIndex;
    boolean bool2 = bool1;
    if (n != 0)
    {
      bool2 = bool1;
      if (m != 0)
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("uuid_null[");
        paramProtoResp.append(localFileUploadInfo.toString());
        paramProtoResp.append("]");
        localFileUploadInfo.b = paramProtoResp.toString();
        bool2 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("decodeOffFilePBResponse:return ");
      paramProtoResp.append(bool2);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      paramProtoResp.append(", totalSpace=");
      paramProtoResp.append(localFileUploadInfo.c);
      paramProtoResp.append(", usedSpace=");
      paramProtoResp.append(localFileUploadInfo.d);
      paramProtoResp.append(", ip=");
      paramProtoResp.append(localFileUploadInfo.f);
      paramProtoResp.append(", port=");
      paramProtoResp.append(localFileUploadInfo.g);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5004, bool2, new Object[] { localFileUploadInfo, localStatictisInfo, localObject1 });
  }
  
  public void g(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> [CS Replay]response V2");
    FileUploadInfo localFileUploadInfo = new FileUploadInfo();
    boolean bool1 = a(paramProtoResp);
    List localList = null;
    Object localObject;
    if (bool1)
    {
      localFileUploadInfo.a = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [CS Replay]handleUploadResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramProtoResp.resp.getResultCode() != 1000)
    {
      localFileUploadInfo.a = -100002;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [CS Replay]handleUploadResponse: resp is failed[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = paramProtoResp.resp.getWupBuffer();
      localFileUploadInfo.t = ((byte[])localObject);
      cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (!localRspBody.msg_apply_upload_rsp_v2.has())
        {
          localFileUploadInfo.a = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        }
        else
        {
          localList = a(localFileUploadInfo, null, (cmd0x346.ApplyUploadRspV2)localRspBody.msg_apply_upload_rsp_v2.get());
          bool1 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.a = -100003;
      }
    }
    bool1 = false;
    int m;
    if ((localFileUploadInfo.f != null) && (localFileUploadInfo.f.length() > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((localFileUploadInfo.h != null) && (localFileUploadInfo.h.length != 0)) {
      n = 0;
    } else {
      n = 1;
    }
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = localFileUploadInfo.a;
    localStatictisInfo.c = paramProtoResp.freeRunnalbleIndex;
    boolean bool2 = bool1;
    if (n != 0)
    {
      bool2 = bool1;
      if (m != 0)
      {
        paramProtoResp = new StringBuilder();
        paramProtoResp.append("uuid_null[");
        paramProtoResp.append(localFileUploadInfo.toString());
        paramProtoResp.append("]");
        localFileUploadInfo.b = paramProtoResp.toString();
        bool2 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramProtoResp = new StringBuilder();
      paramProtoResp.append("decodeOffFilePBResponse:return ");
      paramProtoResp.append(bool2);
      paramProtoResp.append(", retCode=");
      paramProtoResp.append(localFileUploadInfo.a);
      paramProtoResp.append(", retMsg=");
      paramProtoResp.append(localFileUploadInfo.b);
      paramProtoResp.append(", totalSpace=");
      paramProtoResp.append(localFileUploadInfo.c);
      paramProtoResp.append(", usedSpace=");
      paramProtoResp.append(localFileUploadInfo.d);
      paramProtoResp.append(", ip=");
      paramProtoResp.append(localFileUploadInfo.f);
      paramProtoResp.append(", port=");
      paramProtoResp.append(localFileUploadInfo.g);
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoResp.toString());
    }
    a(((FileTransferHandler.PreviewBusiData)paramProtoReq.busiData).e(), 5004, bool2, new Object[] { localFileUploadInfo, localStatictisInfo, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler
 * JD-Core Version:    0.7.0.1
 */