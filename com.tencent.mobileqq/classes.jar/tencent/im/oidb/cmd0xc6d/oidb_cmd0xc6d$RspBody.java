package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xc6d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_card_josn = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0xc6d.ModuleInfo> rpt_insert_module_info = PBField.initRepeatMessage(oidb_cmd0xc6d.ModuleInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xc6d.TextCardInfo> rpt_text_insert_card_info = PBField.initRepeatMessage(oidb_cmd0xc6d.TextCardInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_card_josn", "rpt_insert_module_info", "rpt_text_insert_card_info" }, new Object[] { localByteStringMicro, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.RspBody
 * JD-Core Version:    0.7.0.1
 */