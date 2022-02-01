package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xed4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "retcode", "retmsg", "retobj", "content_has_coin", "content_coin_num", "extra" }, new Object[] { Integer.valueOf(0), "", null, Boolean.valueOf(false), Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field content_coin_num = PBField.initInt32(0);
  public final PBBoolField content_has_coin = PBField.initBool(false);
  public final PBRepeatMessageField<oidb_cmd0xed4.ExtraInfo> extra = PBField.initRepeatMessage(oidb_cmd0xed4.ExtraInfo.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBStringField retmsg = PBField.initString("");
  public oidb_cmd0xed4.UserCoin retobj = new oidb_cmd0xed4.UserCoin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody
 * JD-Core Version:    0.7.0.1
 */