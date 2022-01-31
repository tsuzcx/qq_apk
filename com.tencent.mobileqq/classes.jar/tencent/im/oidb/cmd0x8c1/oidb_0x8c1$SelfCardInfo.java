package tencent.im.oidb.cmd0x8c1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8c1$SelfCardInfo
  extends MessageMicro<SelfCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_xml_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_direction_flag = PBField.initInt32(0);
  public final PBInt32Field int32_friend_flag = PBField.initInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_uin", "bytes_xml_msg", "int32_direction_flag", "int32_friend_flag" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SelfCardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c1.oidb_0x8c1.SelfCardInfo
 * JD-Core Version:    0.7.0.1
 */