package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x769$Config
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_type", "uint32_version", "rpt_content_list", "debug_msg", "rpt_msg_content_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, Config.class);
  public final PBStringField debug_msg = PBField.initString("");
  public final PBRepeatField rpt_content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField rpt_msg_content_list = PBField.initRepeatMessage(Oidb_0x769.Content.class);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.Config
 * JD-Core Version:    0.7.0.1
 */