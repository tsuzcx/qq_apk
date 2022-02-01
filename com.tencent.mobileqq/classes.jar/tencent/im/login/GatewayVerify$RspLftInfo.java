package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$RspLftInfo
  extends MessageMicro<RspLftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "uint32_lft_forbid_area" }, new Object[] { Integer.valueOf(0) }, RspLftInfo.class);
  public final PBUInt32Field uint32_lft_forbid_area = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspLftInfo
 * JD-Core Version:    0.7.0.1
 */