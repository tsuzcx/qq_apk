package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe1b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_req_type", "msg_get_flag_info_req", "msg_set_flag_info_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public oidb_0xe1b.GetFlagInfoReq msg_get_flag_info_req = new oidb_0xe1b.GetFlagInfoReq();
  public oidb_0xe1b.SetFlagInfoReq msg_set_flag_info_req = new oidb_0xe1b.SetFlagInfoReq();
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody
 * JD-Core Version:    0.7.0.1
 */