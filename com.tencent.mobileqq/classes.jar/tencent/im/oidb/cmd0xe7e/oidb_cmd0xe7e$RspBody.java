package tencent.im.oidb.cmd0xe7e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xe7e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_text_insert_card_info", "rpt_insert_module_info" }, new Object[] { null, null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xe7e.ModuleInfo> rpt_insert_module_info = PBField.initRepeatMessage(oidb_cmd0xe7e.ModuleInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xe7e.TextCardInfo> rpt_text_insert_card_info = PBField.initRepeatMessage(oidb_cmd0xe7e.TextCardInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.RspBody
 * JD-Core Version:    0.7.0.1
 */