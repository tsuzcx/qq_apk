package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x519$GetNavigationMenuRspBody
  extends MessageMicro<GetNavigationMenuRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msg_ret", "int32_is_show", "str_struct_msg", "uint32_ver_no" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0) }, GetNavigationMenuRspBody.class);
  public final PBInt32Field int32_is_show = PBField.initInt32(0);
  public subcmd0x519.RetInfo msg_ret = new subcmd0x519.RetInfo();
  public final PBStringField str_struct_msg = PBField.initString("");
  public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuRspBody
 * JD-Core Version:    0.7.0.1
 */