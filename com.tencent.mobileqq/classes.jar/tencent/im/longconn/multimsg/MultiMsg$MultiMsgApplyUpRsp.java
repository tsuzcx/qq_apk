package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiMsg$MultiMsgApplyUpRsp
  extends MessageMicro<MultiMsgApplyUpRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public MultiMsg.ExternMsg msg_extern_info = new MultiMsg.ExternMsg();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_up_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_up_v6_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 90, 98, 104 }, new String[] { "uint32_result", "bytes_msg_resid", "bytes_msg_ukey", "rpt_uint32_up_ip", "rpt_uint32_up_port", "uint64_block_size", "uint64_up_offset", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "msg_extern_info", "rpt_bytes_up_ip_v6", "rpt_uint32_up_v6_port" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, Integer.valueOf(0) }, MultiMsgApplyUpRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp
 * JD-Core Version:    0.7.0.1
 */