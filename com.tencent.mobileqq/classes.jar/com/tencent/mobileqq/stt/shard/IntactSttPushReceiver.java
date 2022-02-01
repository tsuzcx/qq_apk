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
  private BaseSttPushReceiver.SttPushPacket a;
  
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
      this.jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult.a(4, 2007);
      return 4001;
    }
    Long localLong = Long.valueOf(paramMsgBody.uint64_sessionid.get());
    int i = paramMsgBody.uint32_pos.get();
    int j = paramMsgBody.uint32_len.get();
    int k = paramMsgBody.uint32_total_len.get();
    int m = paramMsgBody.uint32_seq.get();
    int n = paramMsgBody.uint32_error_code.get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.stt_IntactSttRcv", 2, "onSttResultPush with: " + n + ", " + localLong + ", " + i + ", " + j + ", " + k);
    }
    if ((n != 0) || (i + j > k))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket != null) {
        this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult.a(4, 2008);
      return 4002;
    }
    paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
    this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket = a(this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket, i, j, k, 1 << m, paramMsgBody);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket.jdField_a_of_type_Boolean;
    if (bool)
    {
      paramMsgBody = new String(this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket.jdField_a_of_type_JavaNioByteBuffer.array());
      this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult.a(false);
      this.jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult.a(paramMsgBody, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt_IntactSttRcv", 2, "doReceivePushData stt pushPacket.isEnd = " + bool + "  | session = " + localLong);
      }
      return 0;
      paramMsgBody = "";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttShardBaseSttPushReceiver$SttPushPacket = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.stt.shard.IntactSttPushReceiver
 * JD-Core Version:    0.7.0.1
 */