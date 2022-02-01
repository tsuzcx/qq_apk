package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class OfflineFileDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, int paramInt1, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(";friendUin:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(";isReaded:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(";isPullRoam:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(";isSelfSender:");
    localStringBuilder.append(paramBoolean3);
    localStringBuilder.append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
    {
      Object localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      Object localObject2 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject1).not_online_file.get();
      if (!((im_msg_body.RichText)localObject1).not_online_file.has())
      {
        localStringBuilder.append("hasNotOnlineFile:");
        localStringBuilder.append(((im_msg_body.RichText)localObject1).not_online_file.has());
        localStringBuilder.append(";hasUUID:");
        localStringBuilder.append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has());
        if (QLog.isColorLevel()) {
          QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
        }
        return;
      }
      if ((paramInt1 != 169) && (paramInt1 != 243))
      {
        paramMsg = new StringBuilder();
        paramMsg.append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8());
        paramMsg.append(l1);
        paramMsg = paramMsg.toString();
        localObject1 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
        localStringBuilder.append("     NotOnLineFile info : serverPath:");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(";fileKey :");
        localStringBuilder.append(paramMsg);
        localStringBuilder.append(";");
        if (!paramMessageHandler.D().a(paramMsg))
        {
          String str = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
          localStringBuilder.append("strFileName:");
          localStringBuilder.append(str);
          localStringBuilder.append(";");
          paramLong1 = ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get();
          paramMsg = null;
          if ((paramInt1 != 241) && (!MessageUtils.a(str, paramInt1)))
          {
            if ((paramInt1 == 242) || (MessageUtils.b(str, paramInt1)))
            {
              if (!str.equals(""))
              {
                if (!str.contains("_")) {
                  paramMsg = str.substring(0, str.length() - 4);
                } else {
                  paramMsg = str.substring(str.lastIndexOf("_") + 1, str.length() - 4);
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(l2);
                ((StringBuilder)localObject2).append(paramMsg);
                paramMsg = ((StringBuilder)localObject2).toString();
                localStringBuilder.append("c2cCmd:0xf2;key:");
                localStringBuilder.append(paramMsg);
                localStringBuilder.append(";");
                if (!paramBoolean4)
                {
                  if (StreamDataManager.m(paramMsg))
                  {
                    localStringBuilder.append("DuplicateKey:");
                    localStringBuilder.append(paramMsg);
                    localStringBuilder.append(";");
                    if (QLog.isColorLevel()) {
                      QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
                    }
                    StreamDataManager.l(paramMsg);
                    return;
                  }
                  StreamDataManager.k(paramMsg);
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("OfflineFileDecoder", 2, "offline ptt no filename");
              }
              paramMsg = TransfileUtile.makeTransFileProtocolData((String)localObject1, paramLong1, 2, false, (String)localObject1, null, "ftn");
              localObject2 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject2).localPath.set((String)localObject1);
              ((RichMsg.PttRec)localObject2).size.set(paramLong1);
              ((RichMsg.PttRec)localObject2).type.set(2);
              ((RichMsg.PttRec)localObject2).uuid.set((String)localObject1);
              ((RichMsg.PttRec)localObject2).isRead.set(false);
              ((RichMsg.PttRec)localObject2).serverStorageSource.set("ftn");
              ((RichMsg.PttRec)localObject2).isReport.set(0);
              ((RichMsg.PttRec)localObject2).version.set(5);
              paramLong1 = System.currentTimeMillis() / 1000L;
              ((RichMsg.PttRec)localObject2).msgRecTime.set(paramLong1);
              ((RichMsg.PttRec)localObject2).msgTime.set(l1);
              localObject1 = (MessageForPtt)MessageRecordFactory.a(-2002);
              ((MessageForPtt)localObject1).msgtype = -2002;
              ((MessageForPtt)localObject1).msgData = ((RichMsg.PttRec)localObject2).toByteArray();
              ((MessageForPtt)localObject1).parse();
              paramList.add(localObject1);
              ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPTTPV(paramMessageHandler.n, 1, false, 4);
            }
          }
          else
          {
            paramMessageHandler = new RichMsg.PicRec();
            paramMessageHandler.localPath.set((String)localObject1);
            paramMessageHandler.size.set(paramLong1);
            paramMessageHandler.type.set(1);
            paramMessageHandler.isRead.set(false);
            paramMessageHandler.uuid.set((String)localObject1);
            paramMessageHandler.serverStorageSource.set("ftn");
            paramMessageHandler.version.set(5);
            paramMessageHandler.isReport.set(0);
            localObject1 = (MessageForPic)MessageRecordFactory.a(-2000);
            ((MessageForPic)localObject1).msgtype = -2000;
            ((MessageForPic)localObject1).msgData = paramMessageHandler.toByteArray();
            ((MessageForPic)localObject1).parse();
            paramList.add(localObject1);
          }
          localStringBuilder.append("protocolStr:");
          localStringBuilder.append(paramMsg);
          localStringBuilder.append(";");
        }
        else
        {
          localStringBuilder.append("rcv a repeated offline file push msg");
        }
        if (QLog.isColorLevel()) {
          QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
        }
        return;
      }
      if (!paramBoolean4)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("<FileAssistant>offlineFile come: c2cCmd[");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append("]");
          QLog.d("OfflineFileDecoder", 2, localStringBuilder.toString());
        }
        paramMessageHandler.n.getFileTransferHandler().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt2, null);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<---decodeC2CMsgPkg_OfflineFile return null:hasBody:");
      paramMessageHandler.append(paramMsg.msg_body.has());
      paramMessageHandler.append("hasRichT:");
      paramMessageHandler.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      QLog.e("OfflineFileDecoder", 2, paramMessageHandler.toString());
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.c2c_cmd.get();
    long l2 = paramDecodeProtoPkgContext.x;
    boolean bool2 = paramDecodeProtoPkgContext.g;
    boolean bool3 = paramDecodeProtoPkgContext.h;
    boolean bool1;
    if (l1 == paramDecodeProtoPkgContext.a) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(paramMessageHandler, paramList, i, paramMsg, l2, bool2, bool3, bool1, paramDecodeProtoPkgContext.d, paramDecodeProtoPkgContext.j, paramDecodeProtoPkgContext.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.OfflineFileDecoder
 * JD-Core Version:    0.7.0.1
 */