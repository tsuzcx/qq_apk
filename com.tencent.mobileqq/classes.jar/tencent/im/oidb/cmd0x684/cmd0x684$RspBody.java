package tencent.im.oidb.cmd0x684;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x684$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_listtype", "str_errinfo" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_errinfo = PBField.initString("");
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x684.cmd0x684.RspBody
 * JD-Core Version:    0.7.0.1
 */