package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$ExtParam
  extends MessageMicro<ExtParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_login_sig", "uint32_business_id" }, new Object[] { null, Integer.valueOf(0) }, ExtParam.class);
  public oidb_0x6b6.LoginSig msg_login_sig = new oidb_0x6b6.LoginSig();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ExtParam
 * JD-Core Version:    0.7.0.1
 */