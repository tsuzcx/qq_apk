package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8f9$LiteMailBrief
  extends MessageMicro<LiteMailBrief>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_read_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_summary_truncate_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 64 }, new String[] { "bytes_feeds_id", "msg_source_id", "uint32_last_modify_time", "uint32_create_time", "uint32_my_read_status", "uint64_author_uin", "bytes_feeds_summary", "uint32_summary_truncate_flag" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0) }, LiteMailBrief.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.LiteMailBrief
 * JD-Core Version:    0.7.0.1
 */