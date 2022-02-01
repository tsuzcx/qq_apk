package tencent.im.s2c.msgtype0x210.submsgtype0xb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xb1$UninviteInfo
  extends MessageMicro<UninviteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_id = PBField.initString("");
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint64_group_code", "str_id" }, new Object[] { localLong, localLong, "" }, UninviteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.UninviteInfo
 * JD-Core Version:    0.7.0.1
 */