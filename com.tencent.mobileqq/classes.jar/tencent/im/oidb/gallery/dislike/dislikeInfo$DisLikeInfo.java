package tencent.im.oidb.gallery.dislike;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class dislikeInfo$DisLikeInfo
  extends MessageMicro<DisLikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_dislike_account_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_dislike_describe = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt64Field uint64_dislike_tagid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "type", "bytes_dislike_describe", "uint64_dislike_tagid", "bytes_dislike_account_id" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, DisLikeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.gallery.dislike.dislikeInfo.DisLikeInfo
 * JD-Core Version:    0.7.0.1
 */