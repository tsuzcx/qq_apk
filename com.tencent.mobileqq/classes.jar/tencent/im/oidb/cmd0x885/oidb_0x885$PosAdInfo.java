package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_pos_layout = PBField.initEnum(0);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBUInt64Field is_auto_play = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0x885.AdInfo> rpt_msg_ad_info = PBField.initRepeatMessage(oidb_0x885.AdInfo.class);
  public final PBUInt32Field uint32_is_second_request = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_second_request = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "rpt_msg_ad_info", "is_auto_play", "uint32_need_second_request", "uint32_is_second_request" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, PosAdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */