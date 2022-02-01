package tencent.im.oidb.cmd0xbd4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbd4$Invitee
  extends MessageMicro<Invitee>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ts = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_from", "uint32_ts" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, Invitee.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.Invitee
 * JD-Core Version:    0.7.0.1
 */