package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d2$FriendInfo
  extends MessageMicro<FriendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field group = PBField.initUInt32(0);
  public final PBUInt32Field login = PBField.initUInt32(0);
  public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uin", "gender", "age", "group", "login", "remark" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localByteStringMicro }, FriendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d2.oidb_0x5d2.FriendInfo
 * JD-Core Version:    0.7.0.1
 */