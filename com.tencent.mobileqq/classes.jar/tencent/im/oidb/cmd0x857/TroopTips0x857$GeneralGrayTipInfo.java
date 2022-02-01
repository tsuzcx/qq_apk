package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$GeneralGrayTipInfo
  extends MessageMicro<GeneralGrayTipInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<TroopTips0x857.TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(TroopTips0x857.TemplParam.class);
  public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 80, 802 }, new String[] { "uint64_busi_type", "uint64_busi_id", "uint32_ctrl_flag", "uint32_c2c_type", "uint32_service_type", "uint64_templ_id", "rpt_msg_templ_param", "bytes_content", "uint64_tips_seq_id", "bytes_pb_reserv" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localLong, null, localByteStringMicro1, localLong, localByteStringMicro2 }, GeneralGrayTipInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GeneralGrayTipInfo
 * JD-Core Version:    0.7.0.1
 */