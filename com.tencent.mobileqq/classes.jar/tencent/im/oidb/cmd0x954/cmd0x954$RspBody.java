package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_feeds_count", "rpt_feed_info_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField rpt_feed_info_list = PBField.initRepeatMessage(cmd0x954.FeedInfo.class);
  public final PBUInt32Field uint32_feeds_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.RspBody
 * JD-Core Version:    0.7.0.1
 */