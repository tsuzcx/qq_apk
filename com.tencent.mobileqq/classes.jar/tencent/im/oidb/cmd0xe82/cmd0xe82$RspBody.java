package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe82$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0xe82.App> app = PBField.initRepeatMessage(cmd0xe82.App.class);
  public final PBUInt32Field cache_ts = PBField.initUInt32(0);
  public final PBUInt32Field disabled = PBField.initUInt32(0);
  public final PBUInt32Field group_disabled = PBField.initUInt32(0);
  public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
  public final PBUInt64Field switch_ts = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "cache_ts", "disabled", "app", "group_disabled", "redpoint_cache_ts", "switch_ts" }, new Object[] { localInteger, localInteger, null, localInteger, localInteger, Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe82.cmd0xe82.RspBody
 * JD-Core Version:    0.7.0.1
 */