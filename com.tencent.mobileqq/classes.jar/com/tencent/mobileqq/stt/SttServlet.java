package com.tencent.mobileqq.stt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  public static void a(AppRuntime paramAppRuntime, MessageForPtt paramMessageForPtt, Long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new NewIntent(paramAppRuntime.getApp(), SttServlet.class);
    int j = paramMessageForPtt.voiceLength;
    int i = j;
    if (j == 0) {
      i = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
    }
    j = paramMessageForPtt.voiceType;
    ((NewIntent)localObject).putExtra("k_stt_mode_version", paramInt2);
    ((NewIntent)localObject).putExtra("k_session", paramLong);
    ((NewIntent)localObject).putExtra("k_sneder", Long.parseLong(paramMessageForPtt.senderuin));
    ((NewIntent)localObject).putExtra("k_receiver", Long.parseLong(paramMessageForPtt.frienduin));
    ((NewIntent)localObject).putExtra("k_size", paramMessageForPtt.fileSize);
    ((NewIntent)localObject).putExtra("k_ptt_time", i);
    ((NewIntent)localObject).putExtra("k_voice_type", j);
    ((NewIntent)localObject).putExtra("k_trans_type", paramInt1);
    ((NewIntent)localObject).putExtra("k_file_path", paramMessageForPtt.groupFileKeyStr);
    ((NewIntent)localObject).putExtra("k_md5", paramMessageForPtt.md5);
    paramInt1 = paramMessageForPtt.autoToText;
    boolean bool2 = false;
    if (paramInt1 >= 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    ((NewIntent)localObject).putExtra("k_ptt_type", paramInt1);
    if (paramMessageForPtt.istroop == 0)
    {
      ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.urlAtServer);
      ((NewIntent)localObject).putExtra("k_cmd", 1);
      paramLong = paramMessageForPtt.urlAtServer;
    }
    else
    {
      ((NewIntent)localObject).putExtra("k_cmd", 2);
      ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.groupFileID);
      paramLong = String.valueOf(paramMessageForPtt.groupFileID);
    }
    StringBuilder localStringBuilder = new StringBuilder("translate l:");
    localStringBuilder.append(paramMessageForPtt.voiceLength);
    localStringBuilder.append(" from:");
    localStringBuilder.append(paramMessageForPtt.istroop);
    localStringBuilder.append(" issend:");
    localStringBuilder.append(paramMessageForPtt.isSend());
    localStringBuilder.append(" format:");
    localStringBuilder.append(paramMessageForPtt.voiceType);
    localStringBuilder.append(" size:");
    localStringBuilder.append(paramMessageForPtt.fileSize);
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(paramLong);
    QLog.d("SttServlet", 1, localStringBuilder.toString());
    ((NewIntent)localObject).putExtra("k_retry", 0);
    boolean bool1;
    if ((paramMessageForPtt.istroop != 0) || (!TextUtils.isEmpty(paramMessageForPtt.urlAtServer)))
    {
      bool1 = bool2;
      if (paramMessageForPtt.istroop != 0)
      {
        bool1 = bool2;
        if (paramMessageForPtt.groupFileID == 0L)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramMessageForPtt.groupFileKeyStr)) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    ((NewIntent)localObject).putExtra("k_n_uuid", bool1);
    paramAppRuntime.startServlet((NewIntent)localObject);
    try
    {
      paramLong = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      if (paramMessageForPtt.istroop != 0) {
        break label728;
      }
      paramAppRuntime = "1";
      ((HashMap)localObject).put("param_FailCode", paramAppRuntime);
      ((HashMap)localObject).put("appversion", "8.7.0");
      paramLong.collectPerformance("", "PttSttRequestV2", false, 0L, 0L, (HashMap)localObject, "");
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
    if (bool1) {
      paramInt1 = 1000;
    }
    for (;;)
    {
      try
      {
        if (paramMessageForPtt.istroop != 0) {
          paramInt1 = 2000;
        }
        if (!paramMessageForPtt.isSend()) {
          break label742;
        }
        paramInt1 += 100;
        if (paramMessageForPtt.fileSize <= 0L) {
          break label734;
        }
        paramInt1 += 10;
        paramAppRuntime = StatisticCollector.getInstance(BaseApplication.getContext());
        paramLong = new HashMap();
        paramLong.put(BaseConstants.RDM_NoChangeFailCode, "");
        paramLong.put("param_FailCode", String.valueOf(paramInt1));
        paramLong.put("sender", paramMessageForPtt.senderuin);
        paramLong.put("receiver", paramMessageForPtt.frienduin);
        paramLong.put("uinType", String.valueOf(paramMessageForPtt.istroop));
        paramLong.put("uploadState", String.valueOf(paramMessageForPtt.fileSize));
        paramLong.put("voiceType", String.valueOf(paramMessageForPtt.voiceType));
        paramLong.put("url", String.valueOf(paramMessageForPtt.url));
        paramAppRuntime.collectPerformance("", "PttSttErrRequest", false, 0L, 0L, paramLong, "");
        return;
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
      return;
      label728:
      paramAppRuntime = "2";
      break;
      label734:
      paramInt1 += 20;
      continue;
      label742:
      paramInt1 += 200;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int m = paramIntent.getIntExtra("k_cmd", 0);
    long l2 = 30000L;
    StringBuilder localStringBuilder = null;
    Object localObject1 = null;
    Object localObject2 = null;
    long l1;
    if (bool1)
    {
      l1 = l2;
      localObject1 = localStringBuilder;
    }
    label955:
    label961:
    label967:
    for (;;)
    {
      try
      {
        Object localObject3 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        l1 = l2;
        localObject1 = localStringBuilder;
        paramFromServiceMsg = new byte[((ByteBuffer)localObject3).getInt() - 4];
        l1 = l2;
        localObject1 = localStringBuilder;
        ((ByteBuffer)localObject3).get(paramFromServiceMsg);
        l1 = l2;
        localObject1 = localStringBuilder;
        localObject3 = new Stt.RspBody();
        l1 = l2;
        localObject1 = localStringBuilder;
        ((Stt.RspBody)localObject3).mergeFrom(paramFromServiceMsg);
        long l3;
        if (m != 1)
        {
          if (m == 2)
          {
            l1 = l2;
            localObject1 = localStringBuilder;
            if (((Stt.RspBody)localObject3).msg_group_ptt_resp.uint32_error_code.get() != 0) {
              break label955;
            }
            bool2 = true;
            l1 = l2;
            localObject1 = localStringBuilder;
            j = ((Stt.RspBody)localObject3).msg_group_ptt_resp.uint32_error_code.get();
            l1 = l2;
            localObject1 = localStringBuilder;
            l3 = ((Stt.RspBody)localObject3).msg_group_ptt_resp.uint32_waittime.get();
            l2 = l3;
            paramFromServiceMsg = localObject2;
            bool1 = bool2;
            i = j;
            l1 = l3;
            localObject1 = localStringBuilder;
            if (((Stt.RspBody)localObject3).msg_group_ptt_resp.str_text != null)
            {
              l2 = l3;
              paramFromServiceMsg = localObject2;
              bool1 = bool2;
              i = j;
              l1 = l3;
              localObject1 = localStringBuilder;
              if (((Stt.RspBody)localObject3).msg_group_ptt_resp.str_text.has())
              {
                l1 = l3;
                localObject1 = localStringBuilder;
                paramFromServiceMsg = ((Stt.RspBody)localObject3).msg_group_ptt_resp.str_text.get();
                l2 = l3;
                bool1 = bool2;
                i = j;
                break label967;
              }
            }
          }
          else
          {
            l1 = l2;
            localObject1 = localStringBuilder;
            paramFromServiceMsg = new StringBuilder();
            l1 = l2;
            localObject1 = localStringBuilder;
            paramFromServiceMsg.append("unknow cmd: ");
            l1 = l2;
            localObject1 = localStringBuilder;
            paramFromServiceMsg.append(m);
            l1 = l2;
            localObject1 = localStringBuilder;
            throw new RuntimeException(paramFromServiceMsg.toString());
          }
        }
        else
        {
          l1 = l2;
          localObject1 = localStringBuilder;
          if (((Stt.RspBody)localObject3).msg_c2c_ptt_resp.uint32_error_code.get() != 0) {
            break label961;
          }
          bool2 = true;
          l1 = l2;
          localObject1 = localStringBuilder;
          j = ((Stt.RspBody)localObject3).msg_c2c_ptt_resp.uint32_error_code.get();
          l1 = l2;
          localObject1 = localStringBuilder;
          l3 = ((Stt.RspBody)localObject3).msg_c2c_ptt_resp.uint32_waittime.get();
          l2 = l3;
          paramFromServiceMsg = localObject2;
          bool1 = bool2;
          i = j;
          l1 = l3;
          localObject1 = localStringBuilder;
          if (((Stt.RspBody)localObject3).msg_c2c_ptt_resp.str_text != null)
          {
            l2 = l3;
            paramFromServiceMsg = localObject2;
            bool1 = bool2;
            i = j;
            l1 = l3;
            localObject1 = localStringBuilder;
            if (((Stt.RspBody)localObject3).msg_c2c_ptt_resp.str_text.has())
            {
              l1 = l3;
              localObject1 = localStringBuilder;
              paramFromServiceMsg = ((Stt.RspBody)localObject3).msg_c2c_ptt_resp.str_text.get();
              l2 = l3;
              bool1 = bool2;
              i = j;
              break label967;
            }
          }
        }
        l1 = l2;
        localObject1 = paramFromServiceMsg;
        if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
        {
          l1 = l2;
          localObject1 = paramFromServiceMsg;
          localStringBuilder = new StringBuilder();
          l1 = l2;
          localObject1 = paramFromServiceMsg;
          localStringBuilder.append("onReceive  text =");
          l1 = l2;
          localObject1 = paramFromServiceMsg;
          localStringBuilder.append(paramFromServiceMsg.length());
          l1 = l2;
          localObject1 = paramFromServiceMsg;
          QLog.d("SttServlet", 1, localStringBuilder.toString());
        }
        l1 = l2;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        i = 2001;
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive  errormsg =");
        localStringBuilder.append(paramFromServiceMsg.toString());
        QLog.d("SttServlet", 1, localStringBuilder.toString());
      }
      int i = 0;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      l1 = l2;
      int k = paramIntent.getIntExtra("k_retry", 0);
      boolean bool2 = paramIntent.getBooleanExtra("k_n_uuid", false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" retry ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(" nouuid");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(" resultCode=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("SttServlet", 1, ((StringBuilder)localObject1).toString());
      int j = k;
      if (!bool1)
      {
        j = k;
        if (!bool2)
        {
          j = k;
          if (i != 48)
          {
            k += 1;
            j = k;
            if (k < 3)
            {
              paramIntent.putExtra("k_retry", k);
              getAppRuntime().startServlet((NewIntent)paramIntent);
              return;
            }
          }
        }
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("k_session", paramIntent.getLongExtra("k_session", 0L));
      ((Bundle)localObject1).putLong("k_time_out", l1);
      ((Bundle)localObject1).putInt("k_result_code", i);
      ((Bundle)localObject1).putInt("k_retry", j);
      if (paramFromServiceMsg != null) {
        ((Bundle)localObject1).putString("k_ptt_trans_txt", paramFromServiceMsg);
      }
      notifyObserver(paramIntent, m, bool1, (Bundle)localObject1, SttManager.class);
      return;
      bool2 = false;
      continue;
      bool2 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_retry", 0);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("str_filemd5");
      ((StringBuilder)localObject1).append(paramIntent.getStringExtra("k_md5"));
      ((StringBuilder)localObject1).append(" uint32_msg_type=");
      ((StringBuilder)localObject1).append(paramIntent.getIntExtra("k_ptt_type", 0));
      QLog.d("PttSliceUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0)
    {
      i = paramIntent.getIntExtra("k_cmd", 0);
      Object localObject2 = new Stt.ReqBody();
      if (i != 1)
      {
        if (i == 2)
        {
          localObject3 = new Stt.TransGroupPttReq();
          ((Stt.TransGroupPttReq)localObject3).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
          ((Stt.TransGroupPttReq)localObject3).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
          ((Stt.TransGroupPttReq)localObject3).uint64_group_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
          ((Stt.TransGroupPttReq)localObject3).uint32_fileid.set((int)paramIntent.getLongExtra("k_file", 0L));
          ((Stt.TransGroupPttReq)localObject3).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
          ((Stt.TransGroupPttReq)localObject3).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
          ((Stt.TransGroupPttReq)localObject3).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
          ((Stt.TransGroupPttReq)localObject3).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
          ((Stt.TransGroupPttReq)localObject3).uint32_event_type.set(paramIntent.getIntExtra("k_trans_type", 1));
          ((Stt.TransGroupPttReq)localObject3).uint32_msg_type.set(paramIntent.getIntExtra("k_ptt_type", 0));
          if (paramIntent.getStringExtra("k_file_path") != null) {
            ((Stt.TransGroupPttReq)localObject3).str_file_path.set(paramIntent.getStringExtra("k_file_path"));
          }
          localObject1 = localObject2;
          ((Stt.ReqBody)localObject1).uint32_sub_cmd.set(1);
          ((Stt.ReqBody)localObject1).ptt_version.set(paramIntent.getIntExtra("k_stt_mode_version", 1));
          ((Stt.ReqBody)localObject1).msg_group_ptt_req.set((MessageMicro)localObject3);
          localObject1 = "pttTrans.TransGroupPttReq";
        }
        else
        {
          paramIntent = new StringBuilder();
          paramIntent.append("unknow cmd: ");
          paramIntent.append(i);
          throw new RuntimeException(paramIntent.toString());
        }
      }
      else
      {
        localObject3 = new Stt.TransC2CPttReq();
        ((Stt.TransC2CPttReq)localObject3).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
        ((Stt.TransC2CPttReq)localObject3).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
        ((Stt.TransC2CPttReq)localObject3).uint64_receiver_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
        ((Stt.TransC2CPttReq)localObject3).str_file_path.set(paramIntent.getStringExtra("k_file"));
        ((Stt.TransC2CPttReq)localObject3).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
        ((Stt.TransC2CPttReq)localObject3).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
        ((Stt.TransC2CPttReq)localObject3).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
        ((Stt.TransC2CPttReq)localObject3).uint32_event_type.set(paramIntent.getIntExtra("k_trans_type", 1));
        ((Stt.TransC2CPttReq)localObject3).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
        ((Stt.TransC2CPttReq)localObject3).uint32_msg_type.set(paramIntent.getIntExtra("k_ptt_type", 0));
        localObject1 = localObject2;
        ((Stt.ReqBody)localObject1).uint32_sub_cmd.set(2);
        ((Stt.ReqBody)localObject1).ptt_version.set(paramIntent.getIntExtra("k_stt_mode_version", 1));
        ((Stt.ReqBody)localObject1).msg_c2c_ptt_req.set((MessageMicro)localObject3);
        ((Stt.TransC2CPttReq)localObject3).str_file_path.get();
        localObject1 = "pttTrans.TransC2CPttReq";
      }
      paramIntent.putExtra("k_sso_id", (String)localObject1);
      localObject2 = ((Stt.ReqBody)localObject2).toByteArray();
      Object localObject3 = ByteBuffer.allocate(localObject2.length + 4);
      ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
      localObject2 = ((ByteBuffer)localObject3).array();
      paramIntent.putExtra("k_sso_data", (byte[])localObject2);
      paramIntent.putExtra("k_request_hash", localObject2.hashCode());
      paramIntent = (Intent)localObject2;
    }
    else
    {
      localObject1 = paramIntent.getStringExtra("k_sso_id");
      paramIntent = paramIntent.getByteArrayExtra("k_sso_data");
    }
    paramPacket.setSSOCommand((String)localObject1);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttServlet
 * JD-Core Version:    0.7.0.1
 */