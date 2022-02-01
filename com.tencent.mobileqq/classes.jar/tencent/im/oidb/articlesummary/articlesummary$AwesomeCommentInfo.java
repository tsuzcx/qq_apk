package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$AwesomeCommentInfo
  extends MessageMicro<AwesomeCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField avatar = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field icon_height = PBField.initUInt32(0);
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field icon_with = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 66, 74, 82 }, new String[] { "rowkey", "icon_url", "icon_with", "icon_height", "jump_url", "uin", "nick_name", "avatar", "comment_id", "content" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, AwesomeCommentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo
 * JD-Core Version:    0.7.0.1
 */