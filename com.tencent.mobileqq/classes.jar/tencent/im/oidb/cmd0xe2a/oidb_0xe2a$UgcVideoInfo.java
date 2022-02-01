package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;

public final class oidb_0xe2a$UgcVideoInfo
  extends MessageMicro<UgcVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public articlesummary.BiuMultiLevel biu_multi_level = new articlesummary.BiuMultiLevel();
  public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_position = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cover_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cover_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_friends = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reprint_disable = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_column_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104, 112, 184, 194, 202, 216 }, new String[] { "bytes_title", "bytes_url", "bytes_cover_url", "uint32_cover_width", "uint32_cover_height", "uint64_column_id", "uint32_duration", "uint32_width", "uint32_height", "uint64_file_size", "bytes_file_md5", "bytes_brief", "uint32_reprint_disable", "uint32_remind_friends", "uint32_upload_type", "biu_multi_level", "bytes_position", "uint32_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, Long.valueOf(0L), localInteger, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localInteger, localInteger, localInteger, null, localByteStringMicro6, localInteger }, UgcVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.UgcVideoInfo
 * JD-Core Version:    0.7.0.1
 */