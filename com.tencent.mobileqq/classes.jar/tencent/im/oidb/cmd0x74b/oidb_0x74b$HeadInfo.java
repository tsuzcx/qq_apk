package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x74b$HeadInfo
  extends MessageMicro<HeadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34, 40, 48, 88 }, new String[] { "uint32_id", "rpt_videoheadlist", "str_photohead", "uint32_timestamp", "uint32_type", "uint32_invalid" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HeadInfo.class);
  public final PBRepeatMessageField<oidb_0x74b.VideoHeadInfo> rpt_videoheadlist = PBField.initRepeatMessage(oidb_0x74b.VideoHeadInfo.class);
  public final PBStringField str_photohead = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_invalid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo
 * JD-Core Version:    0.7.0.1
 */