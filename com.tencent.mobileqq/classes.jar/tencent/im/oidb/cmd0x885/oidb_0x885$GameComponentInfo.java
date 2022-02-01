package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x885$GameComponentInfo
  extends MessageMicro<GameComponentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x885.AdTagInfo> rpt_tag_info = PBField.initRepeatMessage(oidb_0x885.AdTagInfo.class);
  public final PBUInt32Field uint32_day_display_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_display_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_day_display_count", "uint32_session_display_count", "rpt_tag_info" }, new Object[] { localInteger, localInteger, null }, GameComponentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.GameComponentInfo
 * JD-Core Version:    0.7.0.1
 */