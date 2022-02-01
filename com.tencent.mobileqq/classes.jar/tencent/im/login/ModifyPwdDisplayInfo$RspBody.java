package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ModifyPwdDisplayInfo$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_bar_url = PBField.initString("");
  public final PBStringField str_hori_bar_content = PBField.initString("");
  public final PBUInt32Field uint32_display_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_access_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_display_flag", "str_hori_bar_content", "str_bar_url", "uint32_next_access_time" }, new Object[] { localInteger, "", "", localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.ModifyPwdDisplayInfo.RspBody
 * JD-Core Version:    0.7.0.1
 */