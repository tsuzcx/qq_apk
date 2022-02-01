package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$ScripCmsInfo
  extends MessageMicro<ScripCmsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_background_animation_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guide_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guide_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guide_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_left_bottom_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_scrip_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_frequency_limit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_scrip_total_sum = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 58, 66, 74, 82, 88, 96, 106, 112 }, new String[] { "bytes_main_title", "bytes_sub_title", "bytes_background_url", "bytes_icon_url", "bytes_left_bottom_txt", "bytes_background_animation_url", "bytes_guide_main_title", "bytes_guide_sub_title", "bytes_guide_background_url", "uint32_frequency_limit", "uint32_scrip_total_sum", "bytes_scrip_tag", "uint64_from_uin" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, Long.valueOf(0L) }, ScripCmsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo
 * JD-Core Version:    0.7.0.1
 */