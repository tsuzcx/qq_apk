package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$Comment
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_parent_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x954.UserInfo msg_comment_parent_info = new cmd0x954.UserInfo();
  public cmd0x954.UserInfo msg_commenter_info = new cmd0x954.UserInfo();
  public final PBUInt32Field uint32_anonymity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hot = PBField.initUInt32(0);
  public final PBUInt64Field uint64_comment_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64, 800 }, new String[] { "uint64_comment_uin", "msg_commenter_info", "bytes_comment_id", "bytes_comment_content", "uint64_comment_time", "bytes_comment_parent_id", "msg_comment_parent_info", "uint32_anonymity", "uint32_hot" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, null, Integer.valueOf(0), Integer.valueOf(0) }, Comment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.Comment
 * JD-Core Version:    0.7.0.1
 */