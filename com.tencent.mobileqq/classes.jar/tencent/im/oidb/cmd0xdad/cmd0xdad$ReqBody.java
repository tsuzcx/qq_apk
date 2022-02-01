package tencent.im.oidb.cmd0xdad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xdad$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field amount = PBField.initInt64(0L);
  public final PBInt64Field client = PBField.initInt64(0L);
  public final PBUInt64Field gc = PBField.initUInt64(0L);
  public final PBStringField ip = PBField.initString("");
  public final PBInt64Field product_id = PBField.initInt64(0L);
  public cmd0xdad.LoginSig sig = new cmd0xdad.LoginSig();
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  public final PBStringField vsersion = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66 }, new String[] { "client", "product_id", "amount", "to_uin", "gc", "ip", "vsersion", "sig" }, new Object[] { localLong, localLong, localLong, localLong, localLong, "", "", null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdad.cmd0xdad.ReqBody
 * JD-Core Version:    0.7.0.1
 */