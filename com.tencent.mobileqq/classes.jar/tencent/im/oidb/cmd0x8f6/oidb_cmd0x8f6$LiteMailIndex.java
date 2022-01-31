package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f6$LiteMailIndex
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8f6.SourceID msg_source = new oidb_cmd0x8f6.SourceID();
  public final PBRepeatMessageField rpt_msg_concern_uin_list = PBField.initRepeatMessage(oidb_cmd0x8f6.ConcernInfo.class);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_source", "bytes_feeds_id", "uint64_author_uin", "rpt_msg_concern_uin_list" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), null }, LiteMailIndex.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.LiteMailIndex
 * JD-Core Version:    0.7.0.1
 */