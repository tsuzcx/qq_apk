package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiMsg$MultiMsgApplyDownReq
  extends MessageMicro<MultiMsgApplyDownReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<MultiMsg.Ipv4Info> rpt_ip_v4_info = PBField.initRepeatMessage(MultiMsg.Ipv4Info.class);
  public final PBRepeatMessageField<MultiMsg.Ipv6Info> rpt_ip_v6_info = PBField.initRepeatMessage(MultiMsg.Ipv6Info.class);
  public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "bytes_msg_resid", "uint32_msg_type", "uint64_src_uin", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "rpt_ip_v4_info", "rpt_ip_v6_info" }, new Object[] { localByteStringMicro1, localInteger, Long.valueOf(0L), localInteger, localByteStringMicro2, localByteStringMicro3, null, null }, MultiMsgApplyDownReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownReq
 * JD-Core Version:    0.7.0.1
 */