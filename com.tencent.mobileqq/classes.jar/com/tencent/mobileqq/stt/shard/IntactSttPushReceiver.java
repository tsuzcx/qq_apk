package com.tencent.mobileqq.stt.shard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;

public class IntactSttPushReceiver
  extends BaseSttPushReceiver
{
  private BaseSttPushReceiver.SttPushPacket b;
  
  public IntactSttPushReceiver(AIOSttResult paramAIOSttResult)
  {
    super(paramAIOSttResult);
  }
  
  public int a(SttResultPush.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {
      return 4001;
    }
    paramMsgBody = paramMsgBody.msg_ptt_resp;
    if (!paramMsgBody.has())
    {
      this.a.a(4, 2007);
      return 4001;
    }
    Long localLong = Long.valueOf(paramMsgBody.uint64_sessionid.get());
    int i = paramMsgBody.uint32_pos.get();
    int j = paramMsgBody.uint32_len.get();
    int k = paramMsgBody.uint32_total_len.get();
    int m = paramMsgBody.uint32_seq.get();
    int n = paramMsgBody.uint32_error_code.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSttResultPush with: ");
      localStringBuilder.append(n);
      localStringBuilder.append(", ");
      localStringBuilder.append(localLong);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      localStringBuilder.append(", ");
      localStringBuilder.append(j);
      localStringBuilder.append(", ");
      localStringBuilder.append(k);
      QLog.d("Q.stt_IntactSttRcv", 2, localStringBuilder.toString());
    }
    if ((n == 0) && (i + j <= k))
    {
      paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
      this.b = a(this.b, i, j, k, 1 << m, paramMsgBody);
      boolean bool = this.b.d;
      if (bool)
      {
        paramMsgBody = new String(this.b.c.array());
        this.b = null;
      }
      else
      {
        paramMsgBody = "";
      }
      this.a.a(false);
      this.a.a(paramMsgBody, bool);
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("doReceivePushData stt pushPacket.isEnd = ");
        paramMsgBody.append(bool);
        paramMsgBody.append("  | session = ");
        paramMsgBody.append(localLong);
        QLog.d("Q.stt_IntactSttRcv", 2, paramMsgBody.toString());
      }
      return 0;
    }
    if (this.b != null) {
      this.b = null;
    }
    this.a.a(4, 2008);
    return 4002;
  }
  
  public void a()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.shard.IntactSttPushReceiver
 * JD-Core Version:    0.7.0.1
 */