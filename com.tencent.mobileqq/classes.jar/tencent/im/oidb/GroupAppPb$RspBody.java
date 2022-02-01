package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupAppPb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "full_list", "group_gray_list", "red_point_list", "cache_interval" }, new Object[] { null, null, null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field cache_interval = PBField.initUInt32(0);
  public GroupAppPb.AppList full_list = new GroupAppPb.AppList();
  public GroupAppPb.AppList group_gray_list = new GroupAppPb.AppList();
  public GroupAppPb.AppList red_point_list = new GroupAppPb.AppList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.GroupAppPb.RspBody
 * JD-Core Version:    0.7.0.1
 */