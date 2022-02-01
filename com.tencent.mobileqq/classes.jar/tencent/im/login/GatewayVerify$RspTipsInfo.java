package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$RspTipsInfo
  extends MessageMicro<RspTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_guid_to_main_login_wording = PBField.initString("");
  public final PBStringField str_review_protect_url = PBField.initString("");
  public final PBUInt32Field uint32_guid_to_main_login_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_scene_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_scene_id", "str_review_protect_url", "uint32_guid_to_main_login_flag", "str_guid_to_main_login_wording" }, new Object[] { localInteger, "", localInteger, "" }, RspTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspTipsInfo
 * JD-Core Version:    0.7.0.1
 */