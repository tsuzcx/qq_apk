package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x81f$GetAuthDataReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_auth", "uint32_accu_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetAuthDataReq.class);
  public final PBUInt32Field uint32_accu_data = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auth = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataReq
 * JD-Core Version:    0.7.0.1
 */