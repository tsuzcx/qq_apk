package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x93$UnreadMailCountInfo
  extends MessageMicro<UnreadMailCountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_unread_count", "uint32_data_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UnreadMailCountInfo.class);
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountInfo
 * JD-Core Version:    0.7.0.1
 */