package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee$ContextInfo
  extends MessageMicro<ContextInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_context_type = PBField.initEnum(0);
  public final PBRepeatMessageField<submsgtype0xee.PictureInfo> rpt_msg_pic_list = PBField.initRepeatMessage(submsgtype0xee.PictureInfo.class);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "uint64_id", "bytes_title", "rpt_msg_pic_list", "bytes_jump_url", "bytes_orange_word", "bytes_brief", "enum_context_type", "bytes_video_brief" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, ContextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ContextInfo
 * JD-Core Version:    0.7.0.1
 */