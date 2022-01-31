package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb81$GetUserInfoRsp
  extends MessageMicro<GetUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_user_info" }, new Object[] { null }, GetUserInfoRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xb81.UserInfoItem> rpt_msg_user_info = PBField.initRepeatMessage(oidb_cmd0xb81.UserInfoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */