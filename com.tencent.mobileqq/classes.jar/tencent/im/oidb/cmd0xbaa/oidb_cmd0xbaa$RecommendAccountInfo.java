package tencent.im.oidb.cmd0xbaa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbaa$RecommendAccountInfo
  extends MessageMicro<RecommendAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_class = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_recommend_reason", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "bytes_class" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, RecommendAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbaa.oidb_cmd0xbaa.RecommendAccountInfo
 * JD-Core Version:    0.7.0.1
 */