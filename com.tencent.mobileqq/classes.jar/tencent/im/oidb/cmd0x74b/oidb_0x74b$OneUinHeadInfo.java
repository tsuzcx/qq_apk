package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x74b$OneUinHeadInfo
  extends MessageMicro<OneUinHeadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 88 }, new String[] { "uint64_uin", "uint32_timestamp", "rpt_msg_head_list", "uint64_tinyid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, OneUinHeadInfo.class);
  public final PBRepeatMessageField<oidb_0x74b.HeadInfo> rpt_msg_head_list = PBField.initRepeatMessage(oidb_0x74b.HeadInfo.class);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo
 * JD-Core Version:    0.7.0.1
 */