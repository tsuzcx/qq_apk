package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x46f$UserDisLike
  extends MessageMicro<UserDisLike>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_dislike_account_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_dislike_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt64Field uint64_dislike_tagid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "type", "uint64_dislike_tagid", "bytes_dislike_account_id", "bytes_dislike_tag_name" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, UserDisLike.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike
 * JD-Core Version:    0.7.0.1
 */