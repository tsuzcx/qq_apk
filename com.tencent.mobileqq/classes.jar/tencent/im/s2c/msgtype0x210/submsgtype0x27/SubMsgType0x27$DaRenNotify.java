package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$DaRenNotify
  extends MessageMicro<DaRenNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_today_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_yestoday_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_login_days = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_login_days", "uint32_days", "uint32_is_yestoday_login", "uint32_is_today_login" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, DaRenNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify
 * JD-Core Version:    0.7.0.1
 */