package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$RspLftInfo
  extends MessageMicro<RspLftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_lft_forbid_area = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lft_forbid_reason = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88 }, new String[] { "uint32_lft_forbid_area", "uint32_lft_forbid_reason" }, new Object[] { localInteger, localInteger }, RspLftInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspLftInfo
 * JD-Core Version:    0.7.0.1
 */