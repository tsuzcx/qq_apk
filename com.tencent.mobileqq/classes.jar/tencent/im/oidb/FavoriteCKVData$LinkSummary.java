package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FavoriteCKVData$LinkSummary
  extends MessageMicro<LinkSummary>
{
  public static final int Audio = 2;
  public static final int Video = 1;
  public static final int Web = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resource_uri = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uri = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FavoriteCKVData.PicInfo> rpt_msg_pic_info = PBField.initRepeatMessage(FavoriteCKVData.PicInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "bytes_uri", "bytes_title", "bytes_publisher", "bytes_brief", "rpt_msg_pic_info", "bytes_type", "bytes_resource_uri" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, localByteStringMicro6 }, LinkSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.LinkSummary
 * JD-Core Version:    0.7.0.1
 */