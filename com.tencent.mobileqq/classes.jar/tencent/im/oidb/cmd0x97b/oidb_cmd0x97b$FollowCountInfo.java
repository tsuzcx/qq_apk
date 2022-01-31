package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x97b$FollowCountInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_my_follow_count", "uint32_my_fans_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FollowCountInfo.class);
  public final PBUInt32Field uint32_my_fans_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_follow_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo
 * JD-Core Version:    0.7.0.1
 */