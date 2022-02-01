package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe2e$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 72, 80, 88, 114, 120, 128, 136, 144, 152, 162, 170 }, new String[] { "appid", "type", "name", "icon", "url", "removable", "source", "desc", "added", "redpoint", "add_ts", "cmd_trace", "show_frame", "playing_num", "add_uin", "total_playing_num", "qq_friend_playing_num", "playing_users", "tags" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null }, App.class);
  public final PBUInt64Field add_ts = PBField.initUInt64(0L);
  public final PBUInt64Field add_uin = PBField.initUInt64(0L);
  public final PBUInt32Field added = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField cmd_trace = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field playing_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xe2e.PlayingUser> playing_users = PBField.initRepeatMessage(oidb_0xe2e.PlayingUser.class);
  public final PBUInt32Field qq_friend_playing_num = PBField.initUInt32(0);
  public final PBInt32Field redpoint = PBField.initInt32(0);
  public final PBUInt32Field removable = PBField.initUInt32(0);
  public final PBUInt32Field show_frame = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xe2e.Tag> tags = PBField.initRepeatMessage(oidb_0xe2e.Tag.class);
  public final PBUInt32Field total_playing_num = PBField.initUInt32(0);
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2e.oidb_0xe2e.App
 * JD-Core Version:    0.7.0.1
 */