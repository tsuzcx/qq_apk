package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$SocializeFeedsExtInfo
  extends MessageMicro<SocializeFeedsExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_site_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sum_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_article_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_in_use = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_video_ad = PBField.initUInt32(0);
  public final PBUInt32Field uint32_private_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_in_use = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 72, 80, 88 }, new String[] { "uint32_publish_time", "uint32_source", "bytes_article_url", "bytes_subject", "bytes_sum_pic_url", "bytes_site_name", "uint32_in_use", "uint32_src_in_use", "uint32_private_status", "uint32_article_status", "uint32_is_video_ad" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SocializeFeedsExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo
 * JD-Core Version:    0.7.0.1
 */