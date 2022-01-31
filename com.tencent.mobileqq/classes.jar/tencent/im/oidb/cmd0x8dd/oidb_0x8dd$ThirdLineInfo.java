package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x8dd$ThirdLineInfo
  extends MessageMicro<ThirdLineInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_interest_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rich_state = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_line_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_line_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "bytes_third_line_icon", "bytes_third_line_info", "bytes_common_label", "bytes_interest_tag", "bytes_rich_state" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ThirdLineInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.ThirdLineInfo
 * JD-Core Version:    0.7.0.1
 */