package com.tencent.mobileqq.richmedia.server;

import android.text.TextUtils;
import com.tencent.av.business.handler.AudioTrans;
import com.tencent.av.business.handler.AudioTrans.PBBytes;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SHeartBeatReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CNotifyExitReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CPushDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.NetAddr;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.conn.ConnManager;
import com.tencent.mobileqq.richmedia.conn.HostInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PeakAudioTransHandler
  extends BusinessHandler
{
  private static final Object b = Integer.valueOf(2000);
  public long a;
  private boolean c = false;
  private ConnManager d = new ConnManager(paramAppInterface, this.e);
  private ChannelStateManager e = new ChannelStateManager();
  private Random f = new Random();
  
  public PeakAudioTransHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private AudioTransClientTransInfo.IntHead a(int paramInt, String paramString)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    localIntHead.str_session_id.set(paramString);
    localIntHead.str_uin.set(this.appRuntime.getAccount());
    localIntHead.uint32_seq.set(this.f.nextInt());
    localIntHead.enum_body_type.set(paramInt);
    return localIntHead;
  }
  
  private AudioTransClientTransInfo.IntReqBody a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AudioTransClientTransInfo.IntReqBody localIntReqBody = new AudioTransClientTransInfo.IntReqBody();
    if (paramInt1 == 1)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
      paramArrayOfByte.uint32_client_ver.set(1);
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_net_type.set(paramInt4);
      paramArrayOfByte.enum_business_direction.set(1);
      paramArrayOfByte.enum_data_source.set(2);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_join_session_req.set(paramArrayOfByte);
      return localIntReqBody;
    }
    if (paramInt1 == 3)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SExitSessionReq();
      localIntReqBody.msg_exit_session_req.set(paramArrayOfByte);
      return localIntReqBody;
    }
    if (paramInt1 == 7)
    {
      AudioTransClientTransInfo.IntC2SRawDataReq localIntC2SRawDataReq = new AudioTransClientTransInfo.IntC2SRawDataReq();
      if (paramArrayOfByte != null) {
        localIntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(paramArrayOfByte, paramInt2, paramInt3));
      }
      localIntC2SRawDataReq.str_key.set("audio_trans");
      localIntReqBody.msg_raw_data_req.set(localIntC2SRawDataReq);
      return localIntReqBody;
    }
    if (paramInt1 == 5)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_change_session_req.set(paramArrayOfByte);
      return localIntReqBody;
    }
    if (paramInt1 == 9)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SHeartBeatReq();
      localIntReqBody.msg_heart_beat_req.set(paramArrayOfByte);
    }
    return localIntReqBody;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = new AudioTransClientTransInfo.InfoHead();
    try
    {
      paramArrayOfByte1 = (AudioTransClientTransInfo.InfoHead)((AudioTransClientTransInfo.InfoHead)localObject1).mergeFrom(paramArrayOfByte1);
      if (paramArrayOfByte1.uint32_error_no.has())
      {
        paramArrayOfByte2 = (AudioTransClientTransInfo.InfoRspBody)new AudioTransClientTransInfo.InfoRspBody().mergeFrom(paramArrayOfByte2);
        if (paramArrayOfByte1.uint32_error_no.get() == 0)
        {
          paramArrayOfByte2 = (AudioTransClientTransInfo.InfoC2SCreateSessionRsp)paramArrayOfByte2.msg_create_session_rsp.get();
          int i = paramArrayOfByte2.enum_channel_type.get();
          paramArrayOfByte1 = paramArrayOfByte1.str_session_id.get();
          if (i == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakAudioTransHandler", 2, "channelType is CT_SSO");
            }
            i = paramArrayOfByte2.uint32_combine_num.get();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("combineNum = ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject1).toString());
            }
            localObject1 = paramArrayOfByte2.rpt_msg_interface_list.get();
            paramArrayOfByte2 = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject3 = (AudioTransCommon.NetAddr)((Iterator)localObject1).next();
              Object localObject2 = AudioTrans.a(((AudioTransCommon.NetAddr)localObject3).fixed32_IP.get());
              int j = ((AudioTransCommon.NetAddr)localObject3).uint32_port.get();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("fixed32_IP = ");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("uint32_port = ");
                ((StringBuilder)localObject3).append(j);
                QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject3).toString());
              }
              localObject2 = new HostInfo((String)localObject2, j);
              ((HostInfo)localObject2).g = i;
              paramArrayOfByte2.add(localObject2);
            }
            long l = 0L;
            if (!TextUtils.isEmpty(paramArrayOfByte1)) {
              l = Long.valueOf(paramArrayOfByte1).longValue();
            }
            if (!paramArrayOfByte2.isEmpty())
            {
              if (this.e.d())
              {
                this.e.a(2);
                paramArrayOfByte1 = (HostInfo)paramArrayOfByte2.get(0);
                this.d.a(paramArrayOfByte2);
                this.d.a(paramArrayOfByte1, l);
                if (QLog.isColorLevel())
                {
                  paramArrayOfByte1 = new StringBuilder();
                  paramArrayOfByte1.append("create delay = ");
                  paramArrayOfByte1.append(System.currentTimeMillis() - this.a);
                  QLog.e("PeakAudioTransHandler", 1, paramArrayOfByte1.toString());
                }
              }
              else
              {
                QLog.e("PeakAudioTransHandler", 1, "session not in opening state");
                notifyUI(3, true, new Object[] { Long.valueOf(l), Integer.valueOf(0) });
              }
            }
            else {
              QLog.e("PeakAudioTransHandler", 1, "sessionIpList is null");
            }
          }
          else if (i == 2)
          {
            QLog.d("PeakAudioTransHandler", 2, "channelType is CT_RELAY");
          }
        }
        else
        {
          paramArrayOfByte1 = (AudioTransClientTransInfo.InfoC2SFailedRsp)paramArrayOfByte2.msg_failed_rsp.get();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("create session rsp failed, errcode:");
          paramArrayOfByte2.append(paramArrayOfByte1.uint32_errcode.get());
          paramArrayOfByte2.append("  msg:");
          paramArrayOfByte2.append(paramArrayOfByte1.str_errmsg.get());
          QLog.d("PeakAudioTransHandler", 2, paramArrayOfByte2.toString());
        }
      }
      else
      {
        QLog.e("PeakAudioTransHandler", 2, "response not return uint32_error_no");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("exception = ");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      QLog.e("PeakAudioTransHandler", 2, paramArrayOfByte2.toString());
    }
  }
  
  private void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject = new AudioTransClientTransInfo.IntHead();
    int j;
    label623:
    label628:
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfByte1 = (AudioTransClientTransInfo.IntHead)((AudioTransClientTransInfo.IntHead)localObject).mergeFrom(paramArrayOfByte1);
          if (!paramArrayOfByte1.uint32_error_no.has()) {
            break label623;
          }
          i = paramArrayOfByte1.uint32_error_no.get();
          if (!paramArrayOfByte1.enum_body_type.has()) {
            break label628;
          }
          j = paramArrayOfByte1.enum_body_type.get();
          long l = 0L;
          if (paramArrayOfByte1.str_session_id.has()) {
            l = Long.valueOf(paramArrayOfByte1.str_session_id.get()).longValue();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive result:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" sessionid:");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" bodyType:");
          ((StringBuilder)localObject).append(j);
          QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject).toString());
          paramArrayOfByte2 = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramArrayOfByte2);
          if (i == 0)
          {
            if (j == 2)
            {
              paramArrayOfByte1 = (AudioTransClientTransInfo.IntC2SJoinSessionRsp)paramArrayOfByte2.msg_join_session_rsp.get();
              i = paramArrayOfByte1.uint32_combine_num.get();
              j = paramArrayOfByte1.uint32_heartbeat_duration.get();
              if (QLog.isColorLevel())
              {
                paramArrayOfByte1 = new StringBuilder();
                paramArrayOfByte1.append("combineNum = ");
                paramArrayOfByte1.append(i);
                paramArrayOfByte1.append("\nheartBeatDuration = ");
                paramArrayOfByte1.append(j);
                QLog.d("PeakAudioTransHandler", 2, paramArrayOfByte1.toString());
              }
              notifyUI(1, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
              return;
            }
            if (j != 4) {
              break;
            }
            this.e.a(0);
            notifyUI(2, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
            a(l, false);
            return;
            if (j == 6)
            {
              paramArrayOfByte1 = (AudioTransClientTransInfo.IntC2SChangeSessionRsp)paramArrayOfByte2.msg_change_session_rsp.get();
              i = paramArrayOfByte1.uint32_combine_num.get();
              j = paramArrayOfByte1.enum_channel_type.get();
              paramArrayOfByte1 = new StringBuilder();
              paramArrayOfByte1.append("enum_channel_type = ");
              paramArrayOfByte1.append(j);
              paramArrayOfByte1.append("  uint32_combine_num = ");
              paramArrayOfByte1.append(i);
              QLog.d("PeakAudioTransHandler", 2, paramArrayOfByte1.toString());
              notifyUI(4, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
              return;
            }
            if ((j == 10) && (QLog.isColorLevel())) {
              QLog.d("PeakAudioTransHandler", 2, "onReceiveOther INT_C2S_HEART_BEAT_RSP heartbeat !");
            }
          }
          else
          {
            paramArrayOfByte2 = (AudioTransClientTransInfo.IntC2SFailedRsp)paramArrayOfByte2.msg_failed_rsp.get();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("create session rsp fail msg: ");
            ((StringBuilder)localObject).append(paramArrayOfByte1.uint32_error_no.get());
            ((StringBuilder)localObject).append(" uint32_errcode = ");
            ((StringBuilder)localObject).append(paramArrayOfByte2.uint32_errcode.get());
            ((StringBuilder)localObject).append(" str_errmsg = ");
            ((StringBuilder)localObject).append(paramArrayOfByte2.str_errmsg.get());
            QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject).toString());
            a(l);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
        {
          paramArrayOfByte1.printStackTrace();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("exception = ");
          paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
          QLog.e("PeakAudioTransHandler", 2, paramArrayOfByte2.toString(), paramArrayOfByte1);
        }
        return;
        int i = 0;
        continue;
        j = 0;
      }
    } while (j != 8);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = AudioTrans.a(paramArrayOfByte);
    paramArrayOfByte = ((AudioTrans.PBBytes)localObject1).a;
    localObject1 = ((AudioTrans.PBBytes)localObject1).b;
    Object localObject2 = new AudioTransClientTransInfo.IntHead();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (AudioTransClientTransInfo.IntHead)((AudioTransClientTransInfo.IntHead)localObject2).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.enum_body_type.has())
        {
          i = paramArrayOfByte.enum_body_type.get();
          long l = 0L;
          if (paramArrayOfByte.str_session_id.has()) {
            l = Long.valueOf(paramArrayOfByte.str_session_id.get()).longValue();
          }
          if (!paramArrayOfByte.uint32_error_no.has()) {
            break label581;
          }
          paramInt = paramArrayOfByte.uint32_error_no.get();
          if (paramInt == 0) {
            paramArrayOfByte = (AudioTransClientTransInfo.IntReqBody)new AudioTransClientTransInfo.IntReqBody().mergeFrom((byte[])localObject1);
          }
          switch (i)
          {
          case 13: 
            paramArrayOfByte = (AudioTransClientTransInfo.IntS2CNotifyExitReq)paramArrayOfByte.msg_notify_exit_req.get();
            i = -1;
            if (paramArrayOfByte.uint32_reason.has()) {
              i = paramArrayOfByte.uint32_reason.get();
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("onReceivePush exit:");
            paramArrayOfByte.append(i);
            QLog.d("PeakAudioTransHandler", 2, paramArrayOfByte.toString());
            notifyUI(2, true, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
            return;
          case 11: 
            paramArrayOfByte = ((AudioTransClientTransInfo.IntS2CPushDataReq)paramArrayOfByte.msg_push_data_req.get()).translate_result.get().toByteArray();
            localObject1 = (AudioTransCommon.TranslateResult)new AudioTransCommon.TranslateResult().mergeFrom(paramArrayOfByte);
            paramInt = ((AudioTransCommon.TranslateResult)localObject1).int32_end_seq.get();
            i = ((AudioTransCommon.TranslateResult)localObject1).int32_start_seq.get();
            paramArrayOfByte = ((AudioTransCommon.TranslateResult)localObject1).bytes_tar_text.get().toStringUtf8();
            int j = ((AudioTransCommon.TranslateResult)localObject1).int32_status.get();
            localObject1 = ((AudioTransCommon.TranslateResult)localObject1).bytes_src_text.get().toStringUtf8();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onReceivePush strChinese:");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" strEnglish:");
              ((StringBuilder)localObject2).append(paramArrayOfByte);
              QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject2).toString());
            }
            notifyUI(0, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j), localObject1, paramArrayOfByte });
            return;
          case 10: 
            QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat rsp:");
            return;
          case 9: 
            QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat req:");
            return;
            notifyUI(3, true, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("onReceivePush error:");
            paramArrayOfByte.append(paramInt);
            QLog.e("PeakAudioTransHandler", 2, paramArrayOfByte.toString());
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceivePush exception = ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        QLog.e("PeakAudioTransHandler", 2, ((StringBuilder)localObject1).toString(), paramArrayOfByte);
        return;
      }
      int i = 0;
      continue;
      label581:
      paramInt = 0;
    }
  }
  
  public void a(long paramLong)
  {
    this.e.j();
    notifyUI(3, true, new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!this.e.k())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("processNextEvent state legal lSessionID = ");
        localStringBuilder.append(paramLong);
        QLog.e("PeakAudioTransHandler", 2, localStringBuilder.toString());
      }
      a(paramLong);
      return;
    }
    int i = this.e.f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nextEvent = ");
    localStringBuilder.append(i);
    QLog.d("PeakAudioTransHandler", 2, localStringBuilder.toString());
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PeakAudioTransHandler", 2, "processNextEvent list is null");
              }
            }
            else
            {
              if (paramBoolean)
              {
                QLog.d("PeakAudioTransHandler", 2, "processNextEvent close tcp");
                this.d.a(paramLong);
                return;
              }
              QLog.d("PeakAudioTransHandler", 2, "processNextEvent already closed");
            }
          }
          else
          {
            if (!paramBoolean)
            {
              a(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
              return;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("processNextEvent already open nextEvent = ");
            localStringBuilder.append(i);
            QLog.d("PeakAudioTransHandler", 2, localStringBuilder.toString());
            a(paramLong);
          }
        }
        else
        {
          if (!paramBoolean)
          {
            a(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processNextEvent already open nextEvent = ");
          localStringBuilder.append(i);
          QLog.d("PeakAudioTransHandler", 2, localStringBuilder.toString());
          a(paramLong);
        }
      }
      else
      {
        if (!paramBoolean)
        {
          a(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("processNextEvent already open nextEvent = ");
        localStringBuilder.append(i);
        QLog.d("PeakAudioTransHandler", 2, localStringBuilder.toString());
      }
    }
    else
    {
      if (!paramBoolean)
      {
        a(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processNextEvent already open nextEvent = ");
      localStringBuilder.append(i);
      QLog.d("PeakAudioTransHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramBoolean, 2);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCmdToService cmd = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" len:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" sessionid:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" withEnglish:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PeakAudioTransHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l = -1L;
    if (paramString1 != null) {
      l = Long.valueOf(paramString1).longValue();
    }
    if (!this.e.k())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("sendCmdToService state legal cmd = ");
        paramString1.append(paramString2);
        QLog.e("PeakAudioTransHandler", 2, paramString1.toString());
      }
      a(l);
      return;
    }
    Object localObject = createToServiceMsg(paramString2);
    if ("TransInfoCreate.CreateSession".equals(paramString2))
    {
      paramString1 = new AudioTransClientTransInfo.InfoHead();
      paramString1.str_session_id.set(String.valueOf(0));
      paramString1.str_uin.set(this.appRuntime.getAccount());
      paramString1.uint32_seq.set(this.f.nextInt());
      paramString1.enum_body_type.set(1);
      paramString2 = new AudioTransClientTransInfo.InfoReqBody();
      paramArrayOfByte = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
      paramArrayOfByte.enum_business_type.set(3);
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_business_direction.set(1);
      paramArrayOfByte.uint32_client_ver.set(1);
      paramArrayOfByte.enum_net_type.set(paramInt3);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      paramArrayOfByte.rpt_member_list.set(Arrays.asList(new String[] { paramString1.str_uin.get() }));
      paramString2.msg_create_session_req.set(paramArrayOfByte);
      paramString1 = AudioTrans.a(paramString1.toByteArray(), paramString2.toByteArray());
      this.a = System.currentTimeMillis();
      ((ToServiceMsg)localObject).putWupBuffer(paramString1);
      if (!this.e.e())
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("sendCmdToService create last session not close state = ");
          paramString1.append(this.e.a());
          QLog.e("PeakAudioTransHandler", 2, paramString1.toString());
        }
        this.e.c(paramBoolean ^ true);
        return;
      }
      if (this.d.a())
      {
        sendPbReq((ToServiceMsg)localObject);
        this.e.a(1);
        return;
      }
      QLog.e("PeakAudioTransHandler", 2, "sendCmdToService create network is not available");
      return;
    }
    int i;
    if ("TransInfo.JoinSession".equals(paramString2))
    {
      i = 1;
    }
    else if ("TransInfo.ExitSession".equals(paramString2))
    {
      i = 3;
    }
    else if ("TransInfo.ChangeSession".equals(paramString2))
    {
      i = 5;
    }
    else if ("TransInfo.RawData".equals(paramString2))
    {
      i = 7;
    }
    else if ("TransInfo.HeartBeat".equals(paramString2))
    {
      i = 9;
    }
    else
    {
      QLog.e("PeakAudioTransHandler", 2, "unknown cmd");
      i = -1;
    }
    paramString1 = a(i, paramString1);
    paramString2 = a(i, paramArrayOfByte, paramInt1, paramInt2, paramBoolean, paramInt3);
    ((ToServiceMsg)localObject).putWupBuffer(AudioTrans.a(paramString1.toByteArray(), paramString2.toByteArray()));
    if (!this.e.c())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("sendCmdToService other  session not open ! state =");
        paramString1.append(this.e.a());
        QLog.e("PeakAudioTransHandler", 2, paramString1.toString());
      }
      if (i == 5)
      {
        if (paramBoolean) {
          paramInt1 = j;
        } else {
          paramInt1 = 3;
        }
      }
      else {
        paramInt1 = -1;
      }
      if (paramInt1 != -1) {
        this.e.c(paramInt1);
      }
      return;
    }
    if (this.d.a())
    {
      sendPbReq((ToServiceMsg)localObject);
      if (i == 3) {
        this.e.a(3);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "sendCmdToService others network is not available");
      }
      if (i == 3) {
        this.e.j();
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TransObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = AudioTrans.a(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramObject.a;
      paramObject = paramObject.b;
      if ("TransInfoCreate.CreateSession".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramObject);
        return;
      }
      b(paramToServiceMsg, paramObject);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceive fail, error msg is ");
    paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailMsg());
    QLog.e("PeakAudioTransHandler", 2, paramToServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler
 * JD-Core Version:    0.7.0.1
 */