package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CUserGetCouponForCEventPush
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_qquin", "uint64_kfuin", "uint64_coupon_id", "uint32_timestamp", "uint64_kfext", "str_tips_content" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "" }, S2CUserGetCouponForCEventPush.class);
  public final PBStringField str_tips_content = PBField.initString("");
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_coupon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush
 * JD-Core Version:    0.7.0.1
 */