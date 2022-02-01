package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$KdLiveInfo
  extends MessageMicro<KdLiveInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_hot_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hot_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_status_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_status_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_style_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_style_type", "bytes_status_bg_url", "bytes_status_icon_url", "bytes_status_text", "bytes_hot_icon_url", "bytes_hot_text", "bytes_title_jump_url", "bytes_report_common_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, KdLiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo
 * JD-Core Version:    0.7.0.1
 */