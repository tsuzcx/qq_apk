package tencent.im.oidb.cmd0xd82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd82$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redpoint = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread = PBField.initUInt32(0);
  public final PBUInt64Field uint64_blocked_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_entrance", "uint32_redpoint", "uint64_blocked_uin", "uint32_unread" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.RspBody
 * JD-Core Version:    0.7.0.1
 */