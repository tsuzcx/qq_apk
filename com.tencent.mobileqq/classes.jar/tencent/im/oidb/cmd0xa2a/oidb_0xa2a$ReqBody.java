package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa2a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "group_id", "lbs_info", "is_private", "is_ignore_show_num", "online_num", "online_info", "hok_appid", "hok_type" }, new Object[] { Long.valueOf(0L), null, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field hok_appid = PBField.initUInt32(0);
  public final PBUInt32Field hok_type = PBField.initUInt32(0);
  public final PBBoolField is_ignore_show_num = PBField.initBool(false);
  public final PBBoolField is_private = PBField.initBool(false);
  public oidb_0xa2a.LBSInfo lbs_info = new oidb_0xa2a.LBSInfo();
  public final PBRepeatMessageField<oidb_0xa2a.GroupOnlineInfo> online_info = PBField.initRepeatMessage(oidb_0xa2a.GroupOnlineInfo.class);
  public final PBUInt32Field online_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody
 * JD-Core Version:    0.7.0.1
 */