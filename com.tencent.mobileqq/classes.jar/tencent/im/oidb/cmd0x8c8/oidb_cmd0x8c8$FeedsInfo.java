package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0x8c8.AccountInfo account_info = new oidb_cmd0x8c8.AccountInfo();
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_number_of_participants = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField feeds_type = PBField.initEnum(0);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8c8.SocializeFeedsInfo msg_social_fees_info = new oidb_cmd0x8c8.SocializeFeedsInfo();
  public final PBUInt32Field uint32_article_is_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  
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
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 4002 }, new String[] { "feeds_type", "uint64_article_id", "uint32_article_is_video", "bytes_subscribe_name", "json_video_list", "bytes_subscribe_id", "bytes_article_summary", "uint32_business_id", "bytes_business_name", "bytes_business_url", "msg_social_fees_info", "bytes_business_name_prefix", "account_info", "bytes_rowkey", "bytes_number_of_participants" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localByteStringMicro5, localByteStringMicro6, null, localByteStringMicro7, null, localByteStringMicro8, localByteStringMicro9 }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */