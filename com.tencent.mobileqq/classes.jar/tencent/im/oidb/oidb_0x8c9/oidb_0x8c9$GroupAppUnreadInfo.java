package tencent.im.oidb.oidb_0x8c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8c9$GroupAppUnreadInfo
  extends MessageMicro<GroupAppUnreadInfo>
{
  public static final int OPT_INT32_GROUP_ALBUM_PASSIVE_CNT_FIELD_NUMBER = 3;
  public static final int OPT_INT32_GROUP_UNREAD_NUM_FIELD_NUMBER = 2;
  public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint64_appid", "opt_int32_group_unread_num", "opt_int32_group_album_passive_cnt" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupAppUnreadInfo.class);
  public final PBInt32Field opt_int32_group_album_passive_cnt = PBField.initInt32(0);
  public final PBInt32Field opt_int32_group_unread_num = PBField.initInt32(0);
  public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo
 * JD-Core Version:    0.7.0.1
 */