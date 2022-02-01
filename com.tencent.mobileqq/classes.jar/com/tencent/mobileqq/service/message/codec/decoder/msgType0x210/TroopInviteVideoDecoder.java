package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.DealInviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.InviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.UninviteInfo;

public class TroopInviteVideoDecoder
  implements SubTypeDecoder
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    submsgtype0xb1.MsgBody localMsgBody = new submsgtype0xb1.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = 2000L;
      if (!paramBoolean) {
        l1 = 10000L;
      }
      ThreadManager.getUIHandler().postDelayed(new TroopInviteVideoDecoder.1(paramQQAppInterface, localMsgBody, paramBoolean), l1);
      long l2;
      if (localMsgBody.deal_info.has())
      {
        l1 = localMsgBody.deal_info.uint64_group_code.get();
        l2 = localMsgBody.deal_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.deal_info.str_id.get();
        int i = localMsgBody.deal_info.uint32_deal_result.get();
        if (paramQQAppInterface.getCurrentAccountUin().equals(l2 + ""))
        {
          Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box_by_invite_id");
          localIntent.putExtra("groupId", l1);
          localIntent.putExtra("inviteId", paramArrayOfByte);
          paramQQAppInterface.getApp().sendBroadcast(localIntent);
        }
        if (i == 0) {
          paramQQAppInterface.getGAudioHandler().a(l1, l2, paramArrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.deal_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + i);
        }
      }
      if (localMsgBody.univite_info.has())
      {
        l1 = localMsgBody.univite_info.uint64_group_code.get();
        l2 = localMsgBody.univite_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.univite_info.str_id.get();
        paramQQAppInterface.getGAudioHandler().b(l1, l2, paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.univite_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + paramArrayOfByte);
        }
        if (!paramBoolean) {
          a.put(paramArrayOfByte, Long.valueOf(System.currentTimeMillis() / 1000L));
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopInviteVideoDecoder", 2, "recv 0x210_0xb1, prase msgBody error");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0xb1.InviteInfo paramInviteInfo, boolean paramBoolean)
  {
    submsgtype0xb1.InviteInfo localInviteInfo;
    long l1;
    if (paramInviteInfo.has())
    {
      localInviteInfo = (submsgtype0xb1.InviteInfo)paramInviteInfo.get();
      l1 = System.currentTimeMillis() / 1000L;
      if (l1 - localInviteInfo.uint32_expire_time.get() <= 900L) {
        break label106;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "邀请过期了=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1);
      }
    }
    label106:
    Object localObject;
    do
    {
      do
      {
        long l2;
        do
        {
          return;
          if ((paramBoolean) || (!a.containsKey(localInviteInfo.str_id.get()))) {
            break;
          }
          l2 = ((Long)a.get(localInviteInfo.str_id.get())).longValue();
          if (l1 - l2 >= 10L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "离线-上线的时候收到邀请的前10s内先收到了取消的邀请=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|receiveUnInviteTime:" + l2 + ", currentTime:" + l1);
        return;
        paramBoolean = paramQQAppInterface.getAVNotifyCenter().c(localInviteInfo.uint64_group_code.get());
        if (QLog.isColorLevel()) {
          QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "msgBody.invite_info.has()==》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1 + ", hasGroupVideo:" + paramBoolean);
        }
        localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      } while ((!paramBoolean) || (((TroopManager)localObject).d(localInviteInfo.uint64_group_code.get() + "", localInviteInfo.uint64_uin.get() + "")));
      paramBoolean = false;
      if (paramQQAppInterface.getAVNotifyCenter().b() > 0L) {
        paramBoolean = true;
      }
      if (((TroopManager)localObject).b() != 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "只允许同时存在两个邀请框");
    return;
    if (((TroopManager)localObject).b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "hasGroupInviting");
      }
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
      paramInviteInfo.putExtra("uinType", 1);
      paramInviteInfo.putExtra("peerUin", String.valueOf(localInviteInfo.uint64_uin.get()));
    }
    for (;;)
    {
      ((TroopManager)localObject).a(String.valueOf(localInviteInfo.uint64_group_code.get()), String.valueOf(localInviteInfo.uint64_uin.get()));
      if (((KeyguardManager)paramQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.ReceiveRequest");
        ((Intent)localObject).putExtra("revVideoRequest", true);
        ((Intent)localObject).setPackage(paramQQAppInterface.getApp().getPackageName());
        paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      paramInviteInfo.addFlags(268435456);
      paramInviteInfo.putExtra("relationType", 1);
      paramInviteInfo.putExtra("discussId", localInviteInfo.uint64_group_code.get());
      paramInviteInfo.putExtra("friendUin", localInviteInfo.uint64_uin.get());
      paramInviteInfo.putExtra("inviteId", localInviteInfo.str_id.get());
      paramInviteInfo.putExtra("hasGVideoJoined", paramBoolean);
      paramInviteInfo.putExtra("memberType", TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localInviteInfo.uint64_group_code.get() + ""));
      paramQQAppInterface.getApp().startActivity(paramInviteInfo);
      return;
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), GaInviteDialogActivity.class);
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteVideoDecoder", 2, "processMsg0x210Sub0xb1");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(paramMessageHandler.a, paramMsgType0x210, false);
    MessageProtoCodec.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopInviteVideoDecoder
 * JD-Core Version:    0.7.0.1
 */