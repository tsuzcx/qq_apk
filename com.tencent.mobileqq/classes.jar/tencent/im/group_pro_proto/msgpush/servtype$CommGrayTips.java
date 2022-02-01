package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$CommGrayTips
  extends MessageMicro<CommGrayTips>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<servtype.CommGrayTips.TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(servtype.CommGrayTips.TemplParam.class);
  public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 80, 802 }, new String[] { "uint64_busi_type", "uint64_busi_id", "uint32_ctrl_flag", "uint64_templ_id", "rpt_msg_templ_param", "bytes_content", "uint64_tips_seq_id", "bytes_pb_reserv" }, new Object[] { localLong, localLong, Integer.valueOf(0), localLong, null, localByteStringMicro1, localLong, localByteStringMicro2 }, CommGrayTips.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.CommGrayTips
 * JD-Core Version:    0.7.0.1
 */