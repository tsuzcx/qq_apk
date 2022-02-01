package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBInt32Field int_req_type = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0x885.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x885.NegFeedback.class);
  public final PBRepeatMessageField<oidb_0x885.PosAdInfo> rpt_msg_pos_ad_info = PBField.initRepeatMessage(oidb_0x885.PosAdInfo.class);
  public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 72, 80, 88 }, new String[] { "int32_ret", "uint64_uin", "rpt_msg_pos_ad_info", "bytes_msg", "uint64_time", "rpt_msg_neg_feedback", "bytes_cookie", "bytes_ad_user_info", "uint64_ad_channel_id", "int_req_type", "uint64_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro1, Long.valueOf(0L), null, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.RspBody
 * JD-Core Version:    0.7.0.1
 */