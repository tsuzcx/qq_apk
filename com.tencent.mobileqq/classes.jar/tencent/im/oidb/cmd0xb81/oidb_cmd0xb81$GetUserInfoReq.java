package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$GetUserInfoReq
  extends MessageMicro<GetUserInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 82 }, new String[] { "msg_account_info", "msg_user_option", "uint32_info_priority", "msg_shadow_ctl" }, new Object[] { null, null, Integer.valueOf(0), null }, GetUserInfoReq.class);
  public final PBRepeatMessageField<oidb_cmd0xb81.AccountInfo> msg_account_info = PBField.initRepeatMessage(oidb_cmd0xb81.AccountInfo.class);
  public oidb_cmd0xb81.ShadowInfoCtl msg_shadow_ctl = new oidb_cmd0xb81.ShadowInfoCtl();
  public oidb_cmd0xb81.UserInfoOption msg_user_option = new oidb_cmd0xb81.UserInfoOption();
  public final PBUInt32Field uint32_info_priority = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq
 * JD-Core Version:    0.7.0.1
 */