package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$AccountVInfo
  extends MessageMicro<AccountVInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_v_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_follow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_unowned = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_v_icon_url", "uint32_is_unowned", "uint32_follow_count", "uint32_is_show_follow" }, new Object[] { localByteStringMicro, localInteger, localInteger, localInteger }, AccountVInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AccountVInfo
 * JD-Core Version:    0.7.0.1
 */