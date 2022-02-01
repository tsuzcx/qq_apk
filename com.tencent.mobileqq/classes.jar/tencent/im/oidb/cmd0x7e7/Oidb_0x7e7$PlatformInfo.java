package tencent.im.oidb.cmd0x7e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x7e7$PlatformInfo
  extends MessageMicro<PlatformInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field build_no = PBField.initUInt64(0L);
  public final PBBytesField os_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field pub_no = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "os_name", "build_no", "pub_no" }, new Object[] { localByteStringMicro, localLong, localLong }, PlatformInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.PlatformInfo
 * JD-Core Version:    0.7.0.1
 */