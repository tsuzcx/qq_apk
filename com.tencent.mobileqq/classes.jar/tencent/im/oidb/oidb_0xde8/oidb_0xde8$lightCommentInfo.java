package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde8$lightCommentInfo
  extends MessageMicro<lightCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_total_num", "rpt_items" }, new Object[] { Long.valueOf(0L), null }, lightCommentInfo.class);
  public final PBRepeatMessageField<oidb_0xde8.lightCommentItem> rpt_items = PBField.initRepeatMessage(oidb_0xde8.lightCommentItem.class);
  public final PBUInt64Field uint64_total_num = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8.lightCommentInfo
 * JD-Core Version:    0.7.0.1
 */