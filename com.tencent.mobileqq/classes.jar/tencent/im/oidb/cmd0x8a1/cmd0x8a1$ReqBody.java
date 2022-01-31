package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8a1$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_CREATE_GROUP_INFO_FIELD_NUMBER = 2;
  public static final int MSG_SELECT_GROUP_CODE_INFO_FIELD_NUMBER = 3;
  public static final int UINT32_CREATE_OPTION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_create_option", "msg_create_group_info", "msg_select_group_code_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public cmd0x8a1.CreateGroupInfo msg_create_group_info = new cmd0x8a1.CreateGroupInfo();
  public cmd0x8a1.SelectGroupCodeInfo msg_select_group_code_info = new cmd0x8a1.SelectGroupCodeInfo();
  public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody
 * JD-Core Version:    0.7.0.1
 */