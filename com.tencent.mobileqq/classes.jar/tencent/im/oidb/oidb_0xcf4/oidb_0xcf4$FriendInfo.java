package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$FriendInfo
  extends MessageMicro<FriendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_add_frd_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_add_frd_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_frd_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_frd_sub_source = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_add_frd_days", "uint32_add_frd_source", "uint32_add_frd_sub_source", "bytes_add_frd_wording" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, FriendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo
 * JD-Core Version:    0.7.0.1
 */