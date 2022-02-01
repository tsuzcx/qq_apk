package com.tencent.mobileqq.jubao;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xccb.C2cMsgInfo;
import tencent.im.oidb.cmd0xccb.GroupMsgInfo;
import tencent.im.oidb.cmd0xccb.GuildMsgInfo;
import tencent.im.oidb.cmd0xccb.LocalMsgInfo;
import tencent.im.oidb.cmd0xccb.ReqBody;
import tencent.im.oidb.cmd0xccb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class JubaoServlet
  extends MSFServlet
{
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("jubaoApiPlugin", 1, "servlet onReceive  start = ");
    for (;;)
    {
      try
      {
        i = paramFromServiceMsg.getResultCode();
        i1 = paramFromServiceMsg.getResultCode();
        bool = paramFromServiceMsg.isSuccess();
        k = -1;
        if (!bool) {
          break label1166;
        }
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject1 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject1);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject1);
        i = paramFromServiceMsg.uint32_result.get();
        j = paramFromServiceMsg.uint32_command.get();
        if ((i == 0) && (j == 3275))
        {
          localObject2 = new cmd0xccb.RspBody();
          ((cmd0xccb.RspBody)localObject2).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          ((cmd0xccb.RspBody)localObject2).dest_uin.get();
          m = ((cmd0xccb.RspBody)localObject2).type.get();
          if (!((cmd0xccb.RspBody)localObject2).c2c_type.has()) {
            break label1122;
          }
          j = ((cmd0xccb.RspBody)localObject2).c2c_type.get();
          if (((cmd0xccb.RspBody)localObject2).service_type.has()) {
            k = ((cmd0xccb.RspBody)localObject2).service_type.get();
          }
          paramFromServiceMsg = Base64Util.encodeToString(((cmd0xccb.RspBody)localObject2).res_id.get().toByteArray(), 0);
          localObject1 = new ArrayList();
          Iterator localIterator;
          Object localObject3;
          JubaoMsgData localJubaoMsgData;
          if ((m != 1) && (m != 6))
          {
            if ((m != 2) && (m != 3) && (m != 4) && (m != 5))
            {
              if ((m == 7) || (m == 8))
              {
                localIterator = ((cmd0xccb.RspBody)localObject2).guild_msg.get().iterator();
                if (localIterator.hasNext())
                {
                  localObject3 = (cmd0xccb.GuildMsgInfo)localIterator.next();
                  localJubaoMsgData = new JubaoMsgData();
                  localJubaoMsgData.msgSeq = ((int)((cmd0xccb.GuildMsgInfo)localObject3).msg_seq.get());
                  localJubaoMsgData.result = ((cmd0xccb.GuildMsgInfo)localObject3).roam_flag.get();
                  ((ArrayList)localObject1).add(localJubaoMsgData);
                  if (!QLog.isColorLevel()) {
                    break label1128;
                  }
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("servlet upload onReceive GuildMsgInfo = ");
                  ((StringBuilder)localObject3).append(localJubaoMsgData.toJson().toString());
                  QLog.d("jubaoApiPlugin", 2, ((StringBuilder)localObject3).toString());
                  break label1128;
                }
              }
            }
            else
            {
              localIterator = ((cmd0xccb.RspBody)localObject2).group_msg.get().iterator();
              if (localIterator.hasNext())
              {
                localObject3 = (cmd0xccb.GroupMsgInfo)localIterator.next();
                localJubaoMsgData = new JubaoMsgData();
                localJubaoMsgData.msgSeq = ((cmd0xccb.GroupMsgInfo)localObject3).msg_seq.get();
                localJubaoMsgData.result = ((cmd0xccb.GroupMsgInfo)localObject3).roam_flag.get();
                ((ArrayList)localObject1).add(localJubaoMsgData);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("servlet upload onReceive data = ");
                ((StringBuilder)localObject3).append(localJubaoMsgData.toJson().toString());
                QLog.d("jubaoApiPlugin", 2, ((StringBuilder)localObject3).toString());
                continue;
              }
            }
          }
          else
          {
            localIterator = ((cmd0xccb.RspBody)localObject2).c2c_msg.get().iterator();
            if (localIterator.hasNext())
            {
              localObject3 = (cmd0xccb.C2cMsgInfo)localIterator.next();
              localJubaoMsgData = new JubaoMsgData();
              localJubaoMsgData.msgSeq = ((cmd0xccb.C2cMsgInfo)localObject3).msg_seq.get();
              localJubaoMsgData.msgTime = ((cmd0xccb.C2cMsgInfo)localObject3).msg_time.get();
              localJubaoMsgData.msgRandom = ((cmd0xccb.C2cMsgInfo)localObject3).msg_random.get();
              localJubaoMsgData.result = ((cmd0xccb.C2cMsgInfo)localObject3).roam_flag.get();
              ((ArrayList)localObject1).add(localJubaoMsgData);
              if (!QLog.isColorLevel()) {
                continue;
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("servlet upload onReceive data = ");
              ((StringBuilder)localObject3).append(localJubaoMsgData.toJson().toString());
              QLog.d("jubaoApiPlugin", 2, ((StringBuilder)localObject3).toString());
              continue;
            }
          }
          if (!((cmd0xccb.RspBody)localObject2).local_msg.has())
          {
            if (!QLog.isColorLevel()) {
              break label1131;
            }
            QLog.d("jubaoApiPlugin", 2, "onReceiver first success");
            break label1131;
          }
          if (!QLog.isColorLevel()) {
            break label1131;
          }
          QLog.d("jubaoApiPlugin", 2, "onReceiver second success");
          break label1131;
        }
        if ((i != 506) || (j != 3275)) {
          break label1154;
        }
        localObject1 = new cmd0xccb.RspBody();
        ((cmd0xccb.RspBody)localObject1).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        long l1 = ((cmd0xccb.RspBody)localObject1).dest_uin.get();
        j = ((cmd0xccb.RspBody)localObject1).type.get();
        long l2 = ((cmd0xccb.RspBody)localObject1).group_code.get();
        if (((cmd0xccb.RspBody)localObject1).local_msg.has()) {
          break label1154;
        }
        if (QLog.isColorLevel()) {
          QLog.d("jubaoApiPlugin", 2, "onReceiver first failure");
        }
        MultiMsgManager.a().a(a(), String.valueOf(l1), j, String.valueOf(l2), new JubaoServlet.JubaoUploadCallback());
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        int i1;
        Object localObject2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("servlet onReceive exception:  = ");
        ((StringBuilder)localObject1).append(paramFromServiceMsg);
        QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject1).toString());
        QLog.e("jubaoApiPlugin", 1, paramFromServiceMsg, new Object[0]);
        paramIntent.putExtra("jubao_result_code", 3);
        notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), JubaoIPCServer.class);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("servlet upload onReceive isSucess = ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(",ssoResultCode = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(",oidbResultCode = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",uuid:");
      ((StringBuilder)localObject2).append(paramFromServiceMsg);
      ((StringBuilder)localObject2).append(",c2cType:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",serviceType:");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("，result=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject2).toString());
      if (bool)
      {
        paramIntent.putExtra("jubao_uuid", paramFromServiceMsg);
        paramIntent.putExtra("jubao_msg_list", (Serializable)localObject1);
      }
      paramIntent.putExtra("jubao_result_code", i);
      notifyObserver(paramIntent, 0, bool, paramIntent.getExtras(), JubaoIPCServer.class);
      return;
      label1122:
      int j = -1;
      continue;
      label1128:
      continue;
      label1131:
      int n = i;
      int m = k;
      int k = j;
      boolean bool = true;
      j = i;
      int i = n;
      continue;
      label1154:
      m = i;
      j = i;
      i = m;
      break label1169;
      label1166:
      j = 0;
      label1169:
      Object localObject1 = null;
      paramFromServiceMsg = null;
      m = -1;
      bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QLog.d("jubaoApiPlugin", 1, "servlet onSend  start = ");
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new cmd0xccb.ReqBody();
        Object localObject2 = paramIntent.getStringExtra("jubao_evil_uin");
        Object localObject3 = paramIntent.getStringExtra("jubao_chat_uin");
        Object localObject4 = paramIntent.getStringExtra("jubao_group_code");
        int m = paramIntent.getIntExtra("jubao_chat_type", 0);
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1520;
          }
          l2 = Long.parseLong((String)localObject2);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1526;
          }
          l3 = Long.parseLong((String)localObject3);
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            l1 = Long.parseLong((String)localObject4);
          } else {
            l1 = 0L;
          }
          if (m == 1)
          {
            if (l3 == 0L) {
              i = 3;
            } else {
              i = 2;
            }
            j = i;
            i = -1;
            k = 2;
          }
          else if (m == 1000)
          {
            i = 0;
            j = 1;
            k = 1;
          }
          else
          {
            if (m == 1020)
            {
              i = 1;
              continue;
            }
            if (m == 3000)
            {
              if (l3 == 0L)
              {
                i = 5;
                continue;
              }
              i = 4;
              continue;
            }
            if (m == 1004) {
              continue;
            }
            if (m == 1006)
            {
              i = 130;
              j = 6;
              continue;
            }
            if (m == 1022)
            {
              i = 134;
              continue;
            }
            if ((m == 1032) || (m == 1034) || (m == 1033)) {
              break label1544;
            }
            if (m == 10008)
            {
              i = 165;
              continue;
            }
            if (m == 1008)
            {
              i = 129;
              continue;
            }
            if (m == 1001)
            {
              i = 124;
              continue;
            }
            if (m == 1024)
            {
              i = 58;
              continue;
            }
            if (m == 1023)
            {
              i = 133;
              continue;
            }
            if (m == 10002)
            {
              i = 146;
              continue;
            }
            if (m == 10004)
            {
              i = 153;
              continue;
            }
            if (m == 1005)
            {
              i = 201;
              continue;
            }
            if (m == 1036)
            {
              i = 160;
              continue;
            }
            if (m == 1044)
            {
              i = 163;
              continue;
            }
            if (m == 1045)
            {
              i = 166;
              continue;
            }
            if (m == 10010)
            {
              i = 167;
              continue;
            }
            if (m == 10013)
            {
              i = 170;
              continue;
            }
            if (m == 10014)
            {
              long l4 = l1;
              if (l4 == 0L)
              {
                i = 8;
                ((cmd0xccb.ReqBody)localObject1).guild_id.set(l2);
              }
              else
              {
                i = 7;
                ((cmd0xccb.ReqBody)localObject1).guild_id.set(l4);
              }
              ((cmd0xccb.ReqBody)localObject1).channel_id.set(l3);
              ((cmd0xccb.ReqBody)localObject1).dest_uin.set(l2);
              j = i;
              i = -1;
              continue;
            }
            if (m != 10007) {
              break label1539;
            }
            localObject2 = Base64.decode(paramIntent.getStringExtra("jubao_game_sig"), 0);
            ((cmd0xccb.ReqBody)localObject1).sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
            if (!QLog.isColorLevel()) {
              break label1532;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(" sig = ");
            ((StringBuilder)localObject3).append(localObject2);
            QLog.d("jubaoApiPlugin", 2, ((StringBuilder)localObject3).toString());
            break label1532;
          }
          i1 = m;
          ((cmd0xccb.ReqBody)localObject1).type.set(j);
          if ((j != 1) && (j != 2) && (j != 4) && (j != 6)) {
            break label1551;
          }
          ((cmd0xccb.ReqBody)localObject1).dest_uin.set(l3);
        }
        catch (NumberFormatException paramPacket)
        {
          long l1;
          int k;
          int i1;
          int n;
          Object localObject5;
          StringBuilder localStringBuilder;
          QLog.e("jubaoApiPlugin", 1, paramPacket, new Object[0]);
          paramIntent.putExtra("jubao_result_code", 2);
          notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), JubaoIPCServer.class);
          return;
        }
        ((cmd0xccb.ReqBody)localObject1).group_code.set(l1);
        localObject2 = new ArrayList();
        localObject3 = (ArrayList)paramIntent.getExtras().get("jubao_msg_list");
        n = i;
        if (localObject3 != null)
        {
          m = 0;
          n = i;
          if (m < ((ArrayList)localObject3).size())
          {
            localObject4 = new cmd0xccb.GuildMsgInfo();
            ((cmd0xccb.GuildMsgInfo)localObject4).msg_seq.set(((JubaoMsgData)((ArrayList)localObject3).get(m)).msgSeq);
            ((List)localObject2).add(localObject4);
            m += 1;
            continue;
          }
        }
        ((cmd0xccb.ReqBody)localObject1).guild_msg.set((List)localObject2);
        localObject2 = paramIntent.getStringExtra("multi_msg_resID");
        if ((localObject2 != null) && (((String)localObject2).length() != 0))
        {
          localObject3 = new cmd0xccb.LocalMsgInfo();
          ((cmd0xccb.LocalMsgInfo)localObject3).local_res_id.set(ByteStringMicro.copyFromUtf8((String)localObject2));
          ((cmd0xccb.ReqBody)localObject1).local_msg.set((MessageMicro)localObject3);
        }
        localObject3 = (List)paramIntent.getSerializableExtra("jubao_msg_list");
        if (localObject3 != null)
        {
          if (j != 1)
          {
            if (j != 6) {
              break label1578;
            }
            continue;
            localObject2 = new ArrayList();
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (JubaoMsgData)((Iterator)localObject3).next();
              localObject5 = new cmd0xccb.GroupMsgInfo();
              ((cmd0xccb.GroupMsgInfo)localObject5).msg_seq.set(((JubaoMsgData)localObject4).msgSeq);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("data.msgSeq :");
              localStringBuilder.append(((JubaoMsgData)localObject4).msgSeq);
              QLog.d("jubaoApiPlugin", 1, localStringBuilder.toString());
              ((List)localObject2).add(localObject5);
              continue;
            }
            ((cmd0xccb.ReqBody)localObject1).group_msg.set((List)localObject2);
            continue;
          }
          localObject2 = new ArrayList();
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (JubaoMsgData)((Iterator)localObject3).next();
            localObject5 = new cmd0xccb.C2cMsgInfo();
            ((cmd0xccb.C2cMsgInfo)localObject5).msg_seq.set(((JubaoMsgData)localObject4).msgSeq);
            ((cmd0xccb.C2cMsgInfo)localObject5).msg_time.set(((JubaoMsgData)localObject4).msgTime);
            ((cmd0xccb.C2cMsgInfo)localObject5).msg_random.set(((JubaoMsgData)localObject4).msgRandom);
            ((List)localObject2).add(localObject5);
            continue;
          }
          ((cmd0xccb.ReqBody)localObject1).c2c_msg.set((List)localObject2);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("servlet onSend uinTypeDst:");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" c2CType:");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(" serviceType:");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(" chatType:");
        ((StringBuilder)localObject2).append(i1);
        QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject2).toString());
        if (i1 == 10014)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("guildId :");
          ((StringBuilder)localObject2).append(((cmd0xccb.ReqBody)localObject1).guild_id.get());
          ((StringBuilder)localObject2).append("\n channelId : ");
          ((StringBuilder)localObject2).append(((cmd0xccb.ReqBody)localObject1).channel_id.get());
          ((StringBuilder)localObject2).append("\n evilId : ");
          ((StringBuilder)localObject2).append(((cmd0xccb.ReqBody)localObject1).dest_uin.get());
          ((StringBuilder)localObject2).append("\n msgInfo : ");
          ((StringBuilder)localObject2).append(((cmd0xccb.ReqBody)localObject1).guild_msg.get());
          QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3275);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xccb.ReqBody)localObject1).toByteArray()));
        localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
        localObject2 = ByteBuffer.allocate(localObject1.length + 4);
        ((ByteBuffer)localObject2).putInt(localObject1.length + 4);
        ((ByteBuffer)localObject2).put((byte[])localObject1);
        paramPacket.putSendData(((ByteBuffer)localObject2).array());
        paramPacket.setSSOCommand("OidbSvc.0xccb_0");
        return;
      }
      catch (Exception paramPacket)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("servlet onSend exception :");
        ((StringBuilder)localObject1).append(paramPacket);
        QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject1).toString());
        paramIntent.putExtra("jubao_result_code", 2);
        notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), JubaoIPCServer.class);
        return;
      }
      label1520:
      long l2 = 0L;
      continue;
      label1526:
      long l3 = 0L;
      continue;
      label1532:
      int i = 164;
      continue;
      label1539:
      i = -1;
      continue;
      label1544:
      i = 156;
      continue;
      label1551:
      if ((j != 2) && (j != 3) && (j != 4)) {
        if (j == 5)
        {
          continue;
          label1578:
          if ((j != 2) && (j != 3) && (j != 4)) {
            if (j != 5) {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoServlet
 * JD-Core Version:    0.7.0.1
 */