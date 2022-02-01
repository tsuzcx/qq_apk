package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;

public class TroopAnnouncementDecoder
  implements SubTypeDecoder
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject1 = new Submsgtype0x4e.MsgBody();
    try
    {
      paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      int i = paramArrayOfByte.uint32_appid.get();
      long l1 = paramArrayOfByte.uint64_group_id.get();
      long l2 = paramArrayOfByte.uint64_group_code.get();
      if (!paramArrayOfByte.msg_group_bulletin.has()) {
        break label292;
      }
      MessageCache.c();
      localObject1 = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
      new ArrayList();
      paramArrayOfByte = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject1).next();
        long l3 = ((Submsgtype0x4e.GroupBulletin.Content)localObject2).uint64_uin.get();
        String str = ((Submsgtype0x4e.GroupBulletin.Content)localObject2).bytes_feedid.get().toStringUtf8();
        int j = ((Submsgtype0x4e.GroupBulletin.Content)localObject2).uint32_time.get();
        localObject2 = (ITroopAnnouncementHandler)paramQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
        if (((ITroopAnnouncementHandler)localObject2).b(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
          }
        }
        else if ((TroopNotificationCache)paramArrayOfByte.find(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopAnnouncementDecoder", 2, "notice has exist!");
          }
        }
        else {
          ((ITroopAnnouncementHandler)localObject2).a(i, l1, l2, l3, str, j, (short)23, false, false);
        }
      }
      paramArrayOfByte.close();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label278:
      label292:
      break label278;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAnnouncementDecoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(paramMessageHandler.n, paramMsgType0x210);
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopAnnouncementDecoder
 * JD-Core Version:    0.7.0.1
 */