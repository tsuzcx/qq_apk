package tencent.im.oidb.cmd0xf12;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf12$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_main_msg = PBField.initString("");
  public final PBStringField str_secondary_msg = PBField.initString("");
  public final PBUInt32Field uint32_guidecardid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guidecardtype = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_guidecardid", "uint32_guidecardtype", "str_main_msg", "str_secondary_msg" }, new Object[] { localInteger, localInteger, "", "" }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf12.oidb_0xf12.RspBody
 * JD-Core Version:    0.7.0.1
 */