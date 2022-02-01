package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PGCPicInfo
  extends MessageMicro<PGCPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_animation = PBField.initUInt32(0);
  public articlesummary.PGCVideoInfo msg_video_info = new articlesummary.PGCVideoInfo();
  public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gallery_index = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 82, 88 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "msg_video_info", "bytes_pic_desc", "uint64_gallery_index" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, null, localByteStringMicro4, Long.valueOf(0L) }, PGCPicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo
 * JD-Core Version:    0.7.0.1
 */