package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe34$UnReadInfo
  extends MessageMicro<UnReadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_uin", "c2c_info", "group_info", "retcode" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, UnReadInfo.class);
  public cmd0xe34.C2CMsgUnreadNumInfo c2c_info = new cmd0xe34.C2CMsgUnreadNumInfo();
  public cmd0xe34.GroupMsgUnreadNumInfo group_info = new cmd0xe34.GroupMsgUnreadNumInfo();
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34.UnReadInfo
 * JD-Core Version:    0.7.0.1
 */