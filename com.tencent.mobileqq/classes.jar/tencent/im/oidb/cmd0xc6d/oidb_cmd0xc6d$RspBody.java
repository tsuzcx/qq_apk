package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc6d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_card_json = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0xc6d.ModuleInfo> rpt_insert_module_info = PBField.initRepeatMessage(oidb_cmd0xc6d.ModuleInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xc6d.TextCardInfo> rpt_text_insert_card_info = PBField.initRepeatMessage(oidb_cmd0xc6d.TextCardInfo.class);
  public final PBUInt32Field uint32_card_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_card_json", "uint32_card_type", "rpt_insert_module_info", "rpt_text_insert_card_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.RspBody
 * JD-Core Version:    0.7.0.1
 */