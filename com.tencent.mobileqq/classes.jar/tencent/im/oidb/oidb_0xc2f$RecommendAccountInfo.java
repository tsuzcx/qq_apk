package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc2f$RecommendAccountInfo
  extends MessageMicro<RecommendAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "bytes_recommend_reason" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3 }, RecommendAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo
 * JD-Core Version:    0.7.0.1
 */