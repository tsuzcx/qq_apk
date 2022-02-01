package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe82$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field add_ts = PBField.initUInt64(0L);
  public final PBUInt32Field added = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField cmd_trace = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField icon_simple_day = PBField.initString("");
  public final PBStringField icon_simple_night = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field redpoint = PBField.initInt32(0);
  public final PBUInt32Field removable = PBField.initUInt32(0);
  public final PBUInt32Field show_frame = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 72, 80, 88, 98, 106, 114, 120 }, new String[] { "appid", "type", "name", "icon", "url", "removable", "source", "desc", "added", "redpoint", "add_ts", "icon_simple_day", "icon_simple_night", "cmd_trace", "show_frame" }, new Object[] { localLong, localLong, "", "", "", localInteger, localInteger, "", localInteger, localInteger, localLong, "", "", "", localInteger }, App.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe82.cmd0xe82.App
 * JD-Core Version:    0.7.0.1
 */