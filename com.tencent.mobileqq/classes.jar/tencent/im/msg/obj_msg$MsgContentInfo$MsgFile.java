package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class obj_msg$MsgContentInfo$MsgFile
  extends MessageMicro<MsgFile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_sha1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_dead_time = PBField.initInt64(0L);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58 }, new String[] { "uint32_bus_id", "bytes_file_path", "uint64_file_size", "str_file_name", "int64_dead_time", "bytes_file_sha1", "bytes_ext" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), "", Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, MsgFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.obj_msg.MsgContentInfo.MsgFile
 * JD-Core Version:    0.7.0.1
 */