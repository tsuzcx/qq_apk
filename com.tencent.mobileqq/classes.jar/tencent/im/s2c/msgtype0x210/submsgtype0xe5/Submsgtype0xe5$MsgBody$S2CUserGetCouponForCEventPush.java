package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CUserGetCouponForCEventPush
  extends MessageMicro<S2CUserGetCouponForCEventPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_tips_content = PBField.initString("");
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_coupon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_qquin", "uint64_kfuin", "uint64_coupon_id", "uint32_timestamp", "uint64_kfext", "str_tips_content" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0), localLong, "" }, S2CUserGetCouponForCEventPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush
 * JD-Core Version:    0.7.0.1
 */