package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe83$TabInfo
  extends MessageMicro<TabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64 }, new String[] { "type", "name", "desc", "url", "num", "appid", "pic", "red_point" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0) }, TabInfo.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBStringField pic = PBField.initString("");
  public final PBInt32Field red_point = PBField.initInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo
 * JD-Core Version:    0.7.0.1
 */