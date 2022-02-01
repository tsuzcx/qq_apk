package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xee9$UserInfoItem
  extends MessageMicro<UserInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_live_status" }, new Object[] { Long.valueOf(0L), null }, UserInfoItem.class);
  public oidb_cmd0xee9.LiveStatus msg_live_status = new oidb_cmd0xee9.LiveStatus();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */