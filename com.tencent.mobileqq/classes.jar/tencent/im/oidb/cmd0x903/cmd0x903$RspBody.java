package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x903$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x903.SubCmd0x1Rsp opt_msg_check_forbit_group_rsp = new cmd0x903.SubCmd0x1Rsp();
  public cmd0x903.SubCmd0x2Rsp opt_msg_get_invited_uin_list_rsp = new cmd0x903.SubCmd0x2Rsp();
  public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "opt_uint32_result", "opt_bytes_errmsg", "opt_msg_check_forbit_group_rsp", "opt_msg_get_invited_uin_list_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x903.cmd0x903.RspBody
 * JD-Core Version:    0.7.0.1
 */