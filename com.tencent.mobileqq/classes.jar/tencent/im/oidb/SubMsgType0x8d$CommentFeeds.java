package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x8d$CommentFeeds
  extends MessageMicro<CommentFeeds>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 66 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_comment_info", "bytes_feeds_subject" }, new Object[] { localLong, localLong, localLong, localByteStringMicro1, localLong, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, CommentFeeds.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.SubMsgType0x8d.CommentFeeds
 * JD-Core Version:    0.7.0.1
 */