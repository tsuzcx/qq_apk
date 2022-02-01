package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$RspTipsInfo
  extends MessageMicro<RspTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_scene_id", "str_review_protect_url" }, new Object[] { Integer.valueOf(0), "" }, RspTipsInfo.class);
  public final PBStringField str_review_protect_url = PBField.initString("");
  public final PBUInt32Field uint32_scene_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspTipsInfo
 * JD-Core Version:    0.7.0.1
 */