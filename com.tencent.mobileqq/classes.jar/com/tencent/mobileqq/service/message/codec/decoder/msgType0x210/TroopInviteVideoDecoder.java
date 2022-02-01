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
    localMsgBody = new submsgtype0xb1.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      l1 = 2000L;
      if (!paramBoolean) {
        l1 = 10000L;
      }
      ThreadManager.getUIHandler().postDelayed(new TroopInviteVideoDecoder.1(paramQQAppInterface, localMsgBody, paramBoolean), l1);
      boolean bool = localMsgBody.deal_info.has();
      if (!bool) {
        break label494;
      }
      l1 = localMsgBody.deal_info.uint64_group_code.get();
      l2 = localMsgBody.deal_info.uint64_uin.get();
      paramArrayOfByte = localMsgBody.deal_info.str_id.get();
      i = localMsgBody.deal_info.uint32_deal_result.get();
      localObject = paramQQAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l2);
      localStringBuilder.append("");
      if (((String)localObject).equals(localStringBuilder.toString()))
      {
        localObject = new Intent("tencent.video.q2v.close_invite_msg_box_by_invite_id");
        ((Intent)localObject).putExtra("groupId", l1);
        ((Intent)localObject).putExtra("inviteId", paramArrayOfByte);
        paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      if (i != 0) {
        break label485;
      }
      paramQQAppInterface.getGAudioHandler().a(l1, l2, paramArrayOfByte);
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        long l1;
        long l2;
        int i;
        Object localObject;
        continue;
        continue;
        paramArrayOfByte = localMsgBody;
        continue;
        paramArrayOfByte = localMsgBody;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recv 0x210_0xb1, msgBody.deal_info.has()==》troopUin：");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", memUin:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", invitedId:");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      ((StringBuilder)localObject).append(", dealResult:");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, ((StringBuilder)localObject).toString());
      break label488;
      if (paramArrayOfByte.univite_info.has())
      {
        l1 = paramArrayOfByte.univite_info.uint64_group_code.get();
        l2 = paramArrayOfByte.univite_info.uint64_uin.get();
        paramArrayOfByte = paramArrayOfByte.univite_info.str_id.get();
        paramQQAppInterface.getGAudioHandler().b(l1, l2, paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("recv 0x210_0xb1, msgBody.univite_info.has()==》troopUin：");
          paramQQAppInterface.append(l1);
          paramQQAppInterface.append(", memUin:");
          paramQQAppInterface.append(l2);
          paramQQAppInterface.append(", invitedId:");
          paramQQAppInterface.append(paramArrayOfByte);
          paramQQAppInterface.append(", dealResult:");
          paramQQAppInterface.append(paramArrayOfByte);
          QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, paramQQAppInterface.toString());
        }
        if (!paramBoolean)
        {
          a.put(paramArrayOfByte, Long.valueOf(System.currentTimeMillis() / 1000L));
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopInviteVideoDecoder", 2, "recv 0x210_0xb1, prase msgBody error");
          }
        }
      }
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0xb1.InviteInfo paramInviteInfo, boolean paramBoolean)
  {
    if (paramInviteInfo.has())
    {
      submsgtype0xb1.InviteInfo localInviteInfo = (submsgtype0xb1.InviteInfo)paramInviteInfo.get();
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 - localInviteInfo.uint32_expire_time.get() > 900L)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("邀请过期了=》troopUin:");
          paramQQAppInterface.append(localInviteInfo.uint64_group_code.get());
          paramQQAppInterface.append("|uint32_expire_time:");
          paramQQAppInterface.append(localInviteInfo.uint32_expire_time.get());
          paramQQAppInterface.append(", currentTime:");
          paramQQAppInterface.append(l1);
          QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, paramQQAppInterface.toString());
        }
        return;
      }
      if ((!paramBoolean) && (a.containsKey(localInviteInfo.str_id.get())))
      {
        long l2 = ((Long)a.get(localInviteInfo.str_id.get())).longValue();
        if (l1 - l2 < 10L)
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("离线-上线的时候收到邀请的前10s内先收到了取消的邀请=》troopUin:");
            paramQQAppInterface.append(localInviteInfo.uint64_group_code.get());
            paramQQAppInterface.append("|receiveUnInviteTime:");
            paramQQAppInterface.append(l2);
            paramQQAppInterface.append(", currentTime:");
            paramQQAppInterface.append(l1);
            QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, paramQQAppInterface.toString());
          }
          return;
        }
      }
      paramBoolean = paramQQAppInterface.getAVNotifyCenter().c(localInviteInfo.uint64_group_code.get());
      if (QLog.isColorLevel())
      {
        paramInviteInfo = new StringBuilder();
        paramInviteInfo.append("msgBody.invite_info.has()==》troopUin:");
        paramInviteInfo.append(localInviteInfo.uint64_group_code.get());
        paramInviteInfo.append("|uint32_expire_time:");
        paramInviteInfo.append(localInviteInfo.uint32_expire_time.get());
        paramInviteInfo.append(", currentTime:");
        paramInviteInfo.append(l1);
        paramInviteInfo.append(", hasGroupVideo:");
        paramInviteInfo.append(paramBoolean);
        QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, paramInviteInfo.toString());
      }
      Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBoolean)
      {
        paramInviteInfo = new StringBuilder();
        paramInviteInfo.append(localInviteInfo.uint64_group_code.get());
        paramInviteInfo.append("");
        paramInviteInfo = paramInviteInfo.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localInviteInfo.uint64_uin.get());
        localStringBuilder.append("");
        if (!((TroopManager)localObject).c(paramInviteInfo, localStringBuilder.toString()))
        {
          paramBoolean = false;
          if (paramQQAppInterface.getAVNotifyCenter().b() > 0L) {
            paramBoolean = true;
          }
          if (((TroopManager)localObject).b() == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "只允许同时存在两个邀请框");
            }
            return;
          }
          if (((TroopManager)localObject).b() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopInviteVideoDecoder.troopgroup_vedio.invite", 2, "hasGroupInviting");
            }
            paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
            paramInviteInfo.putExtra("uinType", 1);
            paramInviteInfo.putExtra("peerUin", String.valueOf(localInviteInfo.uint64_uin.get()));
          }
          else
          {
            paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), GaInviteDialogActivity.class);
          }
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
          localObject = paramQQAppInterface.getCurrentAccountUin();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localInviteInfo.uint64_group_code.get());
          localStringBuilder.append("");
          paramInviteInfo.putExtra("memberType", TroopMemberUtil.a(paramQQAppInterface, (String)localObject, localStringBuilder.toString()));
          paramQQAppInterface.getApp().startActivity(paramInviteInfo);
        }
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteVideoDecoder", 2, "processMsg0x210Sub0xb1");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(paramMessageHandler.a, paramMsgType0x210, false);
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopInviteVideoDecoder
 * JD-Core Version:    0.7.0.1
 */