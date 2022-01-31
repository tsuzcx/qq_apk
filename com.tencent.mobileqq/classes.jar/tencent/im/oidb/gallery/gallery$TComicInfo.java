package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class gallery$TComicInfo
  extends MessageMicro<TComicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_chapter_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comic_status = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comic_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_comic_type = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_chapter_seqno = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comic_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "bytes_comic_title", "rpt_bytes_comic_type", "bytes_comic_status", "uint32_chapter_seqno", "uint32_comic_id", "bytes_chapter_cover" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, TComicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.TComicInfo
 * JD-Core Version:    0.7.0.1
 */