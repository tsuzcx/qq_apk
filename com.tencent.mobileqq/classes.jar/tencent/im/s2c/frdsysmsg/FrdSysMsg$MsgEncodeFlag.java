package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FrdSysMsg$MsgEncodeFlag
  extends MessageMicro<MsgEncodeFlag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_is_utf8" }, new Object[] { Integer.valueOf(0) }, MsgEncodeFlag.class);
  public final PBUInt32Field uint32_is_utf8 = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.MsgEncodeFlag
 * JD-Core Version:    0.7.0.1
 */