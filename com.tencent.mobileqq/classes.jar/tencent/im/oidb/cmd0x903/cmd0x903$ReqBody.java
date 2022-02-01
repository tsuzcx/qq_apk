package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x903$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0x903.SubCmd0x1Req opt_msg_check_forbit_group_req = new cmd0x903.SubCmd0x1Req();
  public cmd0x903.SubCmd0x2Req opt_msg_get_invited_uin_list_req = new cmd0x903.SubCmd0x2Req();
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "opt_msg_check_forbit_group_req", "opt_msg_get_invited_uin_list_req", "uint32_client_type", "uint32_client_version" }, new Object[] { null, null, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x903.cmd0x903.ReqBody
 * JD-Core Version:    0.7.0.1
 */