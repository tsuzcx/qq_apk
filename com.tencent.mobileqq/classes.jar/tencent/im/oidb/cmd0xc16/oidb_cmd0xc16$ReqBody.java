package tencent.im.oidb.cmd0xc16;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc16$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_topic_cover_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint64_uin", "bytes_topic_title", "bytes_topic_desc", "bytes_topic_pic_url", "bytes_topic_cover_pic_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.ReqBody
 * JD-Core Version:    0.7.0.1
 */