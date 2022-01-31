package tencent.im.oidb.cmd0x950;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x950$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88 }, new String[] { "uint32_req_type", "uint32_req_with_recommendation" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_with_recommendation = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x950.oidb_0x950.ReqBody
 * JD-Core Version:    0.7.0.1
 */