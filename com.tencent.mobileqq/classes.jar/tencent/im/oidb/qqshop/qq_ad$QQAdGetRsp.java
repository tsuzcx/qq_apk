package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdGetRsp
  extends MessageMicro<QQAdGetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 50, 56, 64, 74, 82, 90, 98 }, new String[] { "ret", "msg", "is_boss_qq", "del_aid", "red_point", "qgg_prompt", "qgg_msgs", "qgg_prompt_id" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), Long.valueOf(0L), null, "", "", "" }, QQAdGetRsp.class);
  public final PBRepeatField<Long> del_aid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBoolField is_boss_qq = PBField.initBool(false);
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatField<String> qgg_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField qgg_prompt = PBField.initString("");
  public final PBStringField qgg_prompt_id = PBField.initString("");
  public final PBRepeatMessageField<qq_ad.QQAdGetRsp.RedPointInfo> red_point = PBField.initRepeatMessage(qq_ad.QQAdGetRsp.RedPointInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp
 * JD-Core Version:    0.7.0.1
 */