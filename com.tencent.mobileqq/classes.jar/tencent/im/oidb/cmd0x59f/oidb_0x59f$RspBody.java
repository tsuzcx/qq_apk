package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x59f.BindContactInfo msg_contact_bind_info = new oidb_0x59f.BindContactInfo();
  public oidb_0x59f.Guidelines_808 msg_guidelines808 = new oidb_0x59f.Guidelines_808();
  public oidb_0x59f.Guidelines_common msg_guidelines813 = new oidb_0x59f.Guidelines_common();
  public oidb_0x59f.Guidelines_8410 msg_guidelines8410 = new oidb_0x59f.Guidelines_8410();
  public oidb_0x59f.WelcomePage msg_welcome_page = new oidb_0x59f.WelcomePage();
  public final PBStringField str_account_mobile = PBField.initString("");
  public final PBStringField str_guide_url = PBField.initString("");
  public final PBStringField str_reg_mobile = PBField.initString("");
  public final PBUInt32Field uint32_addrlist_entrance_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_default_jump = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gray_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_mqq_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_pc_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mqq_first_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_not_req_nexttime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pc_first_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reg_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 88, 96, 106, 112, 122, 130, 138, 144, 154, 162, 168, 178, 186, 800 }, new String[] { "uint32_is_first_login", "uint32_default_jump", "uint32_is_first_mqq_login", "uint32_is_first_pc_login", "uint32_mqq_first_login", "uint32_pc_first_login", "msg_welcome_page", "uint32_reg_time", "msg_contact_bind_info", "str_account_mobile", "str_reg_mobile", "uint32_gray_flag", "str_guide_url", "msg_guidelines808", "uint32_addrlist_entrance_flag", "msg_guidelines813", "msg_guidelines8410", "uint32_need_not_req_nexttime" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null, localInteger, null, "", "", localInteger, "", null, localInteger, null, null, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.RspBody
 * JD-Core Version:    0.7.0.1
 */