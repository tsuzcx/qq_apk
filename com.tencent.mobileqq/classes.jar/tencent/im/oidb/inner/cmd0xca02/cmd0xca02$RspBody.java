package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xca02$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 66, 74 }, new String[] { "uint32_timestamp", "rpt_result", "uint32_res", "bool_order", "available_app", "often_app", "disable_often", "often_app_wording", "all_app_wording" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), "", "" }, RspBody.class);
  public final PBStringField all_app_wording = PBField.initString("");
  public final PBRepeatMessageField<cmd0xca02.Result> available_app = PBField.initRepeatMessage(cmd0xca02.Result.class);
  public final PBBoolField bool_order = PBField.initBool(false);
  public final PBBoolField disable_often = PBField.initBool(false);
  public final PBRepeatMessageField<cmd0xca02.Result> often_app = PBField.initRepeatMessage(cmd0xca02.Result.class);
  public final PBStringField often_app_wording = PBField.initString("");
  public final PBRepeatMessageField<cmd0xca02.Result> rpt_result = PBField.initRepeatMessage(cmd0xca02.Result.class);
  public final PBUInt32Field uint32_res = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca02.cmd0xca02.RspBody
 * JD-Core Version:    0.7.0.1
 */