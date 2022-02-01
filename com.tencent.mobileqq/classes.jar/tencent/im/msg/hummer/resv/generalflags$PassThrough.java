package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class generalflags$PassThrough
  extends MessageMicro<PassThrough>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_av_terminate_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qqconnect_message_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qqconnect_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_av_terminate_ext", "bytes_qqconnect_tag_name", "bytes_qqconnect_message_ext" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, PassThrough.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.generalflags.PassThrough
 * JD-Core Version:    0.7.0.1
 */