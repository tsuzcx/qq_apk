package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbde$TopicInfo
  extends MessageMicro<TopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_topic_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_discuss_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56 }, new String[] { "uint64_topic_id", "bytes_topic_name", "bytes_topic_url", "bytes_topic_cover_url", "bytes_topic_summary", "uint64_read_num", "uint64_discuss_num" }, new Object[] { localLong, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localLong, localLong }, TopicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.TopicInfo
 * JD-Core Version:    0.7.0.1
 */