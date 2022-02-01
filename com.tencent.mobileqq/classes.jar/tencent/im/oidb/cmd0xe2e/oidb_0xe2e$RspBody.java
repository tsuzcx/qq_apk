package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe2e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "get_apps", "recommend_apps", "search_apps", "reach_tail", "attachinfo", "max_app_num" }, new Object[] { null, null, null, Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
  public final PBStringField attachinfo = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xe2e.App> get_apps = PBField.initRepeatMessage(oidb_0xe2e.App.class);
  public final PBUInt32Field max_app_num = PBField.initUInt32(0);
  public final PBUInt32Field reach_tail = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xe2e.App> recommend_apps = PBField.initRepeatMessage(oidb_0xe2e.App.class);
  public final PBRepeatMessageField<oidb_0xe2e.App> search_apps = PBField.initRepeatMessage(oidb_0xe2e.App.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2e.oidb_0xe2e.RspBody
 * JD-Core Version:    0.7.0.1
 */