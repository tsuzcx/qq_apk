package tencent.im.oidb.cmd0xb01;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xb01$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint32_result", "double_density" }, new Object[] { Integer.valueOf(0), Double.valueOf(0.0D) }, RspBody.class);
  public final PBDoubleField double_density = PBField.initDouble(0.0D);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb01.cmd0xb01.RspBody
 * JD-Core Version:    0.7.0.1
 */