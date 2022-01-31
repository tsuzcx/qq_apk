package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$TopicRecommendInfo
  extends MessageMicro<TopicRecommendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_follow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number_of_participants = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "uint32_number_of_participants", "bytes_pic_url", "uint32_is_follow" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, TopicRecommendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.TopicRecommendInfo
 * JD-Core Version:    0.7.0.1
 */