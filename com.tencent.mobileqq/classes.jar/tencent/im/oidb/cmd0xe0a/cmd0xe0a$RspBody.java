package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe0a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "cache_ts", "disabled", "app", "group_disabled", "redpoint_cache_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<cmd0xe0a.App> app = PBField.initRepeatMessage(cmd0xe0a.App.class);
  public final PBUInt32Field cache_ts = PBField.initUInt32(0);
  public final PBUInt32Field disabled = PBField.initUInt32(0);
  public final PBUInt32Field group_disabled = PBField.initUInt32(0);
  public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe0a.cmd0xe0a.RspBody
 * JD-Core Version:    0.7.0.1
 */