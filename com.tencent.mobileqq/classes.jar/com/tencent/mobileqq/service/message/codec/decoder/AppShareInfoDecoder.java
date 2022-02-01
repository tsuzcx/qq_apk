package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.PluginInfo;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class AppShareInfoDecoder
  implements Decoder<MessageHandler>
{
  public static void a(BaseMessageHandler paramBaseMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject3 = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    if (paramMsg.appshare_info.has())
    {
      long l1 = ((msg_comm.AppShareInfo)localObject3).appshare_id.get() & 0xFFFFFFFF;
      Object localObject1 = (msg_comm.PluginInfo)((msg_comm.AppShareInfo)localObject3).appshare_resource.get();
      boolean bool1 = ((msg_comm.AppShareInfo)localObject3).appshare_resource.has();
      String str1 = "AppShareInfoDecoder";
      Object localObject2;
      int i;
      if ((bool1) && (localObject1 != null) && (!paramBoolean))
      {
        localObject1 = AppShareIDUtil.a((msg_comm.PluginInfo)localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<--decodeC2CMsgPkg_AppShared appShareID:");
          ((StringBuilder)localObject2).append(((AppShareID)localObject1).toString());
          QLog.d("AppShareInfoDecoder", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = (AppShareID)paramBaseMessageHandler.a().find(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
        if (localObject2 == null)
        {
          paramBaseMessageHandler.a().persist((Entity)localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<--decodeC2CMsgPkg_AppShared Persist DB appid = ");
            ((StringBuilder)localObject2).append(((AppShareID)localObject1).strPkgName);
            QLog.d("AppShareInfoDecoder", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else if ((((AppShareID)localObject1).uiNewVer == ((AppShareID)localObject2).uiNewVer) && (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) <= 86400000L))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<--decodeC2CMsgPkg_AppShared Not need update DB appid = ");
            ((StringBuilder)localObject2).append(((AppShareID)localObject1).strPkgName);
            QLog.d("AppShareInfoDecoder", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          paramBaseMessageHandler.a().remove((Entity)localObject2);
          paramBaseMessageHandler.a().persist((Entity)localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<--decodeC2CMsgPkg_AppShared Update DB appid = ");
            ((StringBuilder)localObject2).append(((AppShareID)localObject1).strPkgName);
            QLog.d("AppShareInfoDecoder", 2, ((StringBuilder)localObject2).toString());
          }
        }
        ((MessageCache)paramBaseMessageHandler.a().getMsgCache()).a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        localObject1 = BaseApplication.getContext().getString(2131718875);
        Iterator localIterator = paramMsg.iterator();
        bool1 = false;
        localObject2 = null;
        paramBoolean = false;
        paramMsg = null;
        label1705:
        while (localIterator.hasNext())
        {
          Object localObject4 = (im_msg_body.Elem)localIterator.next();
          boolean bool2 = ((im_msg_body.Elem)localObject4).text.has();
          boolean bool3 = ((im_msg_body.Elem)localObject4).not_online_image.has();
          if (bool3) {
            paramBoolean = true;
          }
          if (bool2) {
            bool1 = true;
          }
          Object localObject5;
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("<--decodeC2CMsgPkg_AppShared hasText:");
            ((StringBuilder)localObject5).append(bool2);
            ((StringBuilder)localObject5).append(",hasNotOnlineImage:");
            ((StringBuilder)localObject5).append(bool3);
            QLog.d(str1, 2, ((StringBuilder)localObject5).toString());
          }
          long l2;
          if (bool3)
          {
            localObject4 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject4).not_online_image.get();
            int j = ((im_msg_body.NotOnlineImage)localObject4).file_len.get();
            if (((im_msg_body.NotOnlineImage)localObject4).download_path.has())
            {
              localObject5 = ((im_msg_body.NotOnlineImage)localObject4).download_path.get().toStringUtf8();
              localObject4 = localObject5;
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("<--decodeC2CMsgPkg_AppShared: serverPath:");
                ((StringBuilder)localObject4).append((String)localObject5);
                QLog.d(str1, 2, ((StringBuilder)localObject4).toString());
                localObject4 = localObject5;
              }
            }
            else
            {
              localObject4 = null;
            }
            if (localObject4 != null)
            {
              localObject5 = new RichMsg.PicRec();
              ((RichMsg.PicRec)localObject5).localPath.set((String)localObject4);
              localObject1 = ((RichMsg.PicRec)localObject5).size;
              l2 = j;
              ((PBUInt64Field)localObject1).set(l2);
              ((RichMsg.PicRec)localObject5).type.set(1);
              ((RichMsg.PicRec)localObject5).uuid.set((String)localObject4);
              localObject4 = TransfileUtile.makeTransFileProtocolData((String)localObject4, l2, 1, false, (String)localObject4);
              localObject2 = localObject5;
              localObject1 = localObject4;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("<--decodeC2CMsgPkg_AppShared: content:");
                ((StringBuilder)localObject1).append((String)localObject4);
                QLog.d(str1, 2, ((StringBuilder)localObject1).toString());
                localObject1 = localObject4;
                localObject2 = localObject5;
              }
            }
          }
          else
          {
            if (!bool2) {
              break label1093;
            }
            localObject4 = (im_msg_body.Text)((im_msg_body.Elem)localObject4).text.get();
            paramMsg = ((im_msg_body.Text)localObject4).str.get().toStringUtf8();
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("<--decodeC2CMsgPkg_AppShared actionUrl:");
              ((StringBuilder)localObject5).append(paramMsg);
              ((StringBuilder)localObject5).append(",hasLink:");
              ((StringBuilder)localObject5).append(((im_msg_body.Text)localObject4).link.has());
              ((StringBuilder)localObject5).append(",str:");
              ((StringBuilder)localObject5).append(((im_msg_body.Text)localObject4).str.has());
              ((StringBuilder)localObject5).append(",strC:");
              ((StringBuilder)localObject5).append(((im_msg_body.Text)localObject4).str.get().toStringUtf8());
              QLog.d(str1, 2, ((StringBuilder)localObject5).toString());
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("<--decodeC2CMsgPkg_AppShared : bytes:");
              ((StringBuilder)localObject5).append(((im_msg_body.Text)localObject4).str.get().size());
              ((StringBuilder)localObject5).append(",cont:");
              ((StringBuilder)localObject5).append(((im_msg_body.Text)localObject4).str.get());
              ((StringBuilder)localObject5).append(",content:");
              ((StringBuilder)localObject5).append(Arrays.toString(((im_msg_body.Text)localObject4).str.get().toByteArray()));
              QLog.d(str1, 2, ((StringBuilder)localObject5).toString());
            }
          }
          break label1705;
          label1093:
          if (((im_msg_body.Elem)localObject4).custom_face.has())
          {
            Object localObject8 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject4).custom_face.get();
            localObject1 = ((im_msg_body.CustomFace)localObject8).str_file_path.get();
            localObject2 = ((im_msg_body.CustomFace)localObject8).str_shortcut.get();
            localObject4 = ((im_msg_body.CustomFace)localObject8).str_big_url.get();
            localObject5 = ((im_msg_body.CustomFace)localObject8).str_orig_url.get();
            String str2 = ((im_msg_body.CustomFace)localObject8).str_thumb_url.get();
            l2 = ((im_msg_body.CustomFace)localObject8).uint32_file_id.get();
            long l3 = ((im_msg_body.CustomFace)localObject8).uint32_file_type.get();
            long l4 = ((im_msg_body.CustomFace)localObject8).uint32_server_ip.get();
            long l5 = ((im_msg_body.CustomFace)localObject8).uint32_server_port.get();
            long l6 = ((im_msg_body.CustomFace)localObject8).uint32_useful.get();
            Object localObject6 = ((im_msg_body.CustomFace)localObject8).bytes_md5.get().toByteArray();
            Object localObject7 = ((im_msg_body.CustomFace)localObject8).bytes_signature.get().toByteArray();
            localObject8 = ((im_msg_body.CustomFace)localObject8).bytes_flag.get().toByteArray();
            localObject6 = HexUtil.bytes2HexStr((byte[])localObject6);
            localObject7 = HexUtil.bytes2HexStr((byte[])localObject7);
            localObject8 = HexUtil.bytes2HexStr((byte[])localObject8);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(", shortCut:");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(", fileID:");
              localStringBuilder.append(l2 & 0xFFFFFFFF);
              localStringBuilder.append(", fileType:");
              localStringBuilder.append(l3 & 0xFFFFFFFF);
              localStringBuilder.append(", serverIP:");
              localStringBuilder.append(l4 & 0xFFFFFFFF);
              localStringBuilder.append(", serverPort");
              localStringBuilder.append(l5 & 0xFFFFFFFF);
              localStringBuilder.append(", useful");
              localStringBuilder.append(l6 & 0xFFFFFFFF);
              localStringBuilder.append(",md5:");
              localStringBuilder.append((String)localObject6);
              localStringBuilder.append(",signature:");
              localStringBuilder.append((String)localObject7);
              localStringBuilder.append(",flag:");
              localStringBuilder.append((String)localObject8);
              localStringBuilder.append(",downURLBig:");
              localStringBuilder.append((String)localObject4);
              localStringBuilder.append(",downURLOri:");
              localStringBuilder.append((String)localObject5);
              localStringBuilder.append(",downURLThum:");
              localStringBuilder.append(str2);
              QLog.d(str1, 2, localStringBuilder.toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("&gid=");
            ((StringBuilder)localObject2).append(paramLong1);
            ((StringBuilder)localObject2).append("&time=");
            ((StringBuilder)localObject2).append(paramLong2);
            ((StringBuilder)localObject2).append("&msfid=");
            ((StringBuilder)localObject2).append(paramBaseMessageHandler.a().getCurrentAccountUin());
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new RichMsg.PicRec();
            ((RichMsg.PicRec)localObject2).localPath.set((String)localObject1);
            ((RichMsg.PicRec)localObject2).size.set(0L);
            ((RichMsg.PicRec)localObject2).type.set(1);
            ((RichMsg.PicRec)localObject2).uuid.set((String)localObject1);
            localObject1 = TransfileUtile.makeTransFileProtocolData((String)localObject1, 0L, 1, false, (String)localObject1);
            paramBoolean = true;
          }
        }
        if ((paramBoolean) && (!bool1))
        {
          paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
          paramMsg.msgtype = -2000;
          paramMsg.msgData = ((RichMsg.PicRec)localObject2).toByteArray();
          paramMsg.msg = ((String)localObject1);
          paramMsg.parse();
          paramList.add(paramMsg);
          paramLong1 = l1;
        }
        else
        {
          if ((!paramBoolean) && (bool1))
          {
            paramBaseMessageHandler = (MessageForText)MessageRecordFactory.a(-1000);
            paramBaseMessageHandler.msgtype = -1000;
            paramBaseMessageHandler.msg = paramMsg;
            paramList.add(paramBaseMessageHandler);
            return;
          }
          if (paramMsg == null) {
            return;
          }
          localObject2 = paramMsg.trim();
          if (QLog.isColorLevel())
          {
            paramMsg = new StringBuilder();
            paramMsg.append("<--decodeC2CMsgPkg_AppShared: hasPicCnt:");
            paramMsg.append(paramBoolean);
            paramMsg.append(",hasTextCnt:");
            paramMsg.append(bool1);
            QLog.d(str1, 2, paramMsg.toString());
          }
          GetOpenID.a(paramBaseMessageHandler, String.valueOf(AppShareIDUtil.b(l1)));
          paramMsg = ActionMsgUtil.a(((msg_comm.AppShareInfo)localObject3).appshare_cookie.get().toByteArray());
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("<--decodeC2CMsgPkg_AppShared: content:");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(",opType:");
            ((StringBuilder)localObject3).append(paramMsg.b);
            QLog.d(str1, 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = paramMsg.a;
          paramLong1 = l1;
          localObject2 = ActionMsgUtil.a((String)localObject1, (String)localObject2, paramLong1, (String)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("<--decodeC2CMsgPkg_AppShared : content:");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(",encodeMsg:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d(str1, 2, ((StringBuilder)localObject3).toString());
          }
          localObject1 = MessageRecordFactory.a(paramMsg.b);
          ((MessageRecord)localObject1).msgtype = paramMsg.b;
          ((MessageRecord)localObject1).msg = ((String)localObject2);
          paramList.add(localObject1);
        }
      }
      else
      {
        paramLong1 = l1;
      }
      if (i == 0) {
        paramBaseMessageHandler.a(Long.valueOf(paramLong1));
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (!paramMsg.appshare_info.has()) {
      return;
    }
    a(paramMessageHandler, paramList, paramMsg, 0L, 0L, paramDecodeProtoPkgContext.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.AppShareInfoDecoder
 * JD-Core Version:    0.7.0.1
 */