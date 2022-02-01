package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeac$GroupFileMsg
  extends MessageMicro<GroupFileMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bus_id = PBField.initUInt32(0);
  public final PBUInt64Field dead_time = PBField.initUInt64(0L);
  public final PBBytesField ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_sha1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 58, 66 }, new String[] { "file_name", "bus_id", "file_id", "file_size", "dead_time", "file_sha1", "ext", "file_md5" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), "", localLong, localLong, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GroupFileMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.GroupFileMsg
 * JD-Core Version:    0.7.0.1
 */