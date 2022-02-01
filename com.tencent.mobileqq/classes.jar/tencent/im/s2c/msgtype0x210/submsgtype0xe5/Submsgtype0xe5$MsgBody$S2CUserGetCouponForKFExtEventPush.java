package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CUserGetCouponForKFExtEventPush
  extends MessageMicro<S2CUserGetCouponForKFExtEventPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_appid = PBField.initString("");
  public final PBStringField str_notify_tips = PBField.initString("");
  public final PBStringField str_openid = PBField.initString("");
  public final PBStringField str_visitorid = PBField.initString("");
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_coupon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fakeuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qq_pub_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96 }, new String[] { "uint32_channel_type", "uint64_fakeuin", "uint64_qquin", "str_openid", "str_visitorid", "str_appid", "uint64_qq_pub_uin", "uint64_kfuin", "uint64_coupon_id", "str_notify_tips", "uint32_timestamp", "uint64_kfext" }, new Object[] { localInteger, localLong, localLong, "", "", "", localLong, localLong, localLong, "", localInteger, localLong }, S2CUserGetCouponForKFExtEventPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CUserGetCouponForKFExtEventPush
 * JD-Core Version:    0.7.0.1
 */