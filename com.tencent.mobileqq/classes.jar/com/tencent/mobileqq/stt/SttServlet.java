package com.tencent.mobileqq.stt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x355.Stt.ReqBody;
import tencent.im.cs.cmd0x355.Stt.RspBody;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttReq;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttResp;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttReq;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttResp;

public class SttServlet
  extends MSFServlet
{
  public static void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, Long paramLong)
  {
    Object localObject = new NewIntent(paramQQAppInterface.getApp(), SttServlet.class);
    int j = paramMessageForPtt.voiceLength;
    int i = j;
    if (j == 0) {
      i = QQRecorder.a(paramMessageForPtt);
    }
    j = paramMessageForPtt.voiceType;
    ((NewIntent)localObject).putExtra("k_session", paramLong);
    ((NewIntent)localObject).putExtra("k_sneder", Long.parseLong(paramMessageForPtt.senderuin));
    ((NewIntent)localObject).putExtra("k_receiver", Long.parseLong(paramMessageForPtt.frienduin));
    ((NewIntent)localObject).putExtra("k_size", paramMessageForPtt.fileSize);
    ((NewIntent)localObject).putExtra("k_ptt_time", i);
    ((NewIntent)localObject).putExtra("k_voice_type", j);
    ((NewIntent)localObject).putExtra("k_file_path", paramMessageForPtt.groupFileKeyStr);
    boolean bool;
    if (paramMessageForPtt.istroop == 0)
    {
      ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.urlAtServer);
      ((NewIntent)localObject).putExtra("k_cmd", 1);
      paramLong = paramMessageForPtt.urlAtServer;
      QLog.d("SttServlet", 1, "translate l:" + paramMessageForPtt.voiceLength + " from:" + paramMessageForPtt.istroop + " issend:" + paramMessageForPtt.isSend() + " format:" + paramMessageForPtt.voiceType + " size:" + paramMessageForPtt.fileSize + " uuid:" + paramLong);
      ((NewIntent)localObject).putExtra("k_retry", 0);
      if (((paramMessageForPtt.istroop != 0) || (!TextUtils.isEmpty(paramMessageForPtt.urlAtServer))) && ((paramMessageForPtt.istroop == 0) || (paramMessageForPtt.groupFileID != 0L) || (!TextUtils.isEmpty(paramMessageForPtt.groupFileKeyStr)))) {
        break label635;
      }
      bool = true;
    }
    label345:
    label635:
    for (;;)
    {
      for (;;)
      {
        ((NewIntent)localObject).putExtra("k_n_uuid", bool);
        paramQQAppInterface.startServlet((NewIntent)localObject);
        try
        {
          paramLong = StatisticCollector.a(BaseApplication.getContext());
          localObject = new HashMap();
          ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
          if (paramMessageForPtt.istroop == 0)
          {
            paramQQAppInterface = "1";
            ((HashMap)localObject).put("param_FailCode", paramQQAppInterface);
            ((HashMap)localObject).put("appversion", "7.6.0");
            paramLong.a("", "PttSttRequestV2", false, 0L, 0L, (HashMap)localObject, "");
            label379:
            if (bool) {
              i = 1000;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          try
          {
            if (paramMessageForPtt.istroop != 0) {
              i = 2000;
            }
            if (paramMessageForPtt.isSend())
            {
              i += 100;
              if (paramMessageForPtt.fileSize > 0L) {
                i += 10;
              }
            }
            for (;;)
            {
              paramQQAppInterface = StatisticCollector.a(BaseApplication.getContext());
              paramLong = new HashMap();
              paramLong.put(BaseConstants.RDM_NoChangeFailCode, "");
              paramLong.put("param_FailCode", String.valueOf(i));
              paramLong.put("sender", paramMessageForPtt.senderuin);
              paramLong.put("receiver", paramMessageForPtt.frienduin);
              paramLong.put("uinType", String.valueOf(paramMessageForPtt.istroop));
              paramLong.put("uploadState", String.valueOf(paramMessageForPtt.fileSize));
              paramLong.put("voiceType", String.valueOf(paramMessageForPtt.voiceType));
              paramLong.put("url", String.valueOf(paramMessageForPtt.url));
              paramQQAppInterface.a("", "PttSttErrRequest", false, 0L, 0L, paramLong, "");
              return;
              ((NewIntent)localObject).putExtra("k_cmd", 2);
              ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.groupFileID);
              ((NewIntent)localObject).putExtra("k_md5", paramMessageForPtt.md5);
              paramLong = String.valueOf(paramMessageForPtt.groupFileID);
              break;
              paramQQAppInterface = "2";
              break label345;
              paramQQAppInterface = paramQQAppInterface;
              paramQQAppInterface.printStackTrace();
              break label379;
              i += 20;
              continue;
              i += 200;
            }
            bool = false;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            return;
          }
        }
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    long l2 = 30000L;
    int i = paramIntent.getIntExtra("k_cmd", 0);
    long l1 = l2;
    boolean bool1 = bool2;
    Object localObject;
    if (bool2) {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new Stt.RspBody();
        ((Stt.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        switch (i)
        {
        case 1: 
          throw new RuntimeException("unknow cmd: " + i);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
        l1 = l2;
      }
    }
    label136:
    int j = paramIntent.getIntExtra("k_retry", 0);
    bool2 = paramIntent.getBooleanExtra("k_n_uuid", false);
    QLog.d("SttServlet", 1, "onReceive " + bool1 + " retry " + j + " nouuid" + bool2);
    if ((!bool1) && (!bool2))
    {
      j += 1;
      if (j < 3)
      {
        paramIntent.putExtra("k_retry", j);
        getAppRuntime().startServlet((NewIntent)paramIntent);
        return;
        if (((Stt.RspBody)localObject).msg_c2c_ptt_resp.uint32_error_code.get() != 0) {
          break label370;
        }
      }
    }
    label370:
    for (bool1 = true;; bool1 = false)
    {
      l1 = ((Stt.RspBody)localObject).msg_c2c_ptt_resp.uint32_waittime.get();
      break label136;
      if (((Stt.RspBody)localObject).msg_group_ptt_resp.uint32_error_code.get() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        j = ((Stt.RspBody)localObject).msg_group_ptt_resp.uint32_waittime.get();
        l1 = j;
        break;
      }
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putLong("k_session", paramIntent.getLongExtra("k_session", 0L));
      paramFromServiceMsg.putLong("k_time_out", l1);
      notifyObserver(paramIntent, i, bool1, paramFromServiceMsg, SttManager.class);
      return;
      break;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_retry", 0);
    byte[] arrayOfByte = null;
    Stt.ReqBody localReqBody;
    String str;
    Object localObject;
    if (i == 0)
    {
      i = paramIntent.getIntExtra("k_cmd", 0);
      localReqBody = new Stt.ReqBody();
      switch (i)
      {
      default: 
        throw new RuntimeException("unknow cmd: " + i);
      case 1: 
        str = "pttTrans.TransC2CPttReq";
        localObject = new Stt.TransC2CPttReq();
        ((Stt.TransC2CPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_receiver_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
        ((Stt.TransC2CPttReq)localObject).str_file_path.set(paramIntent.getStringExtra("k_file"));
        ((Stt.TransC2CPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
        ((Stt.TransC2CPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
        ((Stt.TransC2CPttReq)localObject).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
        localReqBody.uint32_sub_cmd.set(2);
        localReqBody.msg_c2c_ptt_req.set((MessageMicro)localObject);
        ((Stt.TransC2CPttReq)localObject).str_file_path.get();
        localObject = str;
        if (str != null)
        {
          paramIntent.putExtra("k_sso_id", str);
          arrayOfByte = localReqBody.toByteArray();
          localObject = ByteBuffer.allocate(arrayOfByte.length + 4);
          ((ByteBuffer)localObject).putInt(arrayOfByte.length + 4).put(arrayOfByte);
          arrayOfByte = ((ByteBuffer)localObject).array();
          paramIntent.putExtra("k_sso_data", arrayOfByte);
          paramIntent.putExtra("k_request_hash", arrayOfByte.hashCode());
          localObject = str;
        }
        break;
      }
    }
    for (;;)
    {
      paramPacket.setSSOCommand((String)localObject);
      paramPacket.putSendData(arrayOfByte);
      return;
      str = "pttTrans.TransGroupPttReq";
      localObject = new Stt.TransGroupPttReq();
      ((Stt.TransGroupPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_group_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
      ((Stt.TransGroupPttReq)localObject).uint32_fileid.set((int)paramIntent.getLongExtra("k_file", 0L));
      ((Stt.TransGroupPttReq)localObject).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
      ((Stt.TransGroupPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
      ((Stt.TransGroupPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
      ((Stt.TransGroupPttReq)localObject).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
      if (paramIntent.getStringExtra("k_file_path") != null) {
        ((Stt.TransGroupPttReq)localObject).str_file_path.set(paramIntent.getStringExtra("k_file_path"));
      }
      localReqBody.uint32_sub_cmd.set(1);
      localReqBody.msg_group_ptt_req.set((MessageMicro)localObject);
      break;
      localObject = paramIntent.getStringExtra("k_sso_id");
      arrayOfByte = paramIntent.getByteArrayExtra("k_sso_data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttServlet
 * JD-Core Version:    0.7.0.1
 */