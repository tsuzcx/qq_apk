package tencent.im.oidb.cmd0x6be;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6be$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 484008 }, new String[] { "uint32_appid" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6be.Oidb_0x6be.ReqBody
 * JD-Core Version:    0.7.0.1
 */