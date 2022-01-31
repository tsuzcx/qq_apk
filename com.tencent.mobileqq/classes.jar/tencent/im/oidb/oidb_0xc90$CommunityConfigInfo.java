package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc90$CommunityConfigInfo
  extends MessageMicro<CommunityConfigInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_jump_home_page_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_dynamic_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_community_bid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "bytes_jump_home_page_url", "bytes_name", "bytes_pic_url", "uint32_dynamic_count", "uint64_community_bid", "uint32_follow_status" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CommunityConfigInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc90.CommunityConfigInfo
 * JD-Core Version:    0.7.0.1
 */