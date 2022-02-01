package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_pos_layout = PBField.initEnum(0);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBUInt64Field is_auto_play = PBField.initUInt64(0L);
  public oidb_0x6cf.AdInfo msg_ad_info = new oidb_0x6cf.AdInfo();
  public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "msg_ad_info", "is_auto_play" }, new Object[] { localInteger, localByteStringMicro, localInteger, localLong, null, localLong }, PosAdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */