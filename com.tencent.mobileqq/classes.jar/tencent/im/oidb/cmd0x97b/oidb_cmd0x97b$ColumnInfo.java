package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x97b$ColumnInfo
  extends MessageMicro<ColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_column_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_column_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106 }, new String[] { "uint32_video_count", "uint32_column_count", "uint32_subscribe_count", "bytes_video_jump_url", "bytes_column_jump_url", "bytes_subscribe_jump_url" }, new Object[] { localInteger, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ColumnInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */