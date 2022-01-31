package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x8d$DeleteFeeds
  extends MessageMicro<DeleteFeeds>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_delete_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DeleteFeeds.class);
  public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.DeleteFeeds
 * JD-Core Version:    0.7.0.1
 */