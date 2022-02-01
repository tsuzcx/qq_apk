package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x406$GroupFeeMember
  extends MessageMicro<GroupFeeMember>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_nick_name = PBField.initString("");
  public final PBUInt64Field uint64_paid_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint64_paid_time", "string_nick_name" }, new Object[] { localLong, localLong, "" }, GroupFeeMember.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember
 * JD-Core Version:    0.7.0.1
 */