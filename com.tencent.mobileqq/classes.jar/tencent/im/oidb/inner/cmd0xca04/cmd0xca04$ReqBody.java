package tencent.im.oidb.inner.cmd0xca04;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xca04$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_timestamp", "rpt_uint32_appids", "msg_app_info", "rpt_uint32_add_appids", "rpt_uint32_del_appids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public cmd0xca04.AppInfo msg_app_info = new cmd0xca04.AppInfo();
  public final PBRepeatField rpt_uint32_add_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_del_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca04.cmd0xca04.ReqBody
 * JD-Core Version:    0.7.0.1
 */