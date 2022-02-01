package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleSmallMsg$CommGrayTipsInfo
  extends MessageMicro<CommGrayTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<QQCircleSmallMsg.TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(QQCircleSmallMsg.TemplParam.class);
  public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 80, 802 }, new String[] { "uint64_busi_type", "uint64_busi_id", "uint32_ctrl_flag", "uint32_c2c_type", "uint32_service_type", "uint64_templ_id", "rpt_msg_templ_param", "bytes_content", "uint64_tips_seq_id", "bytes_pb_reserv" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, CommGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.CommGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */