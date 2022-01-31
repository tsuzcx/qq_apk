package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x978$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_uin", "uint64_client_switch", "msg_req_follow_para" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, ReqBody.class);
  public oidb_cmd0x978.ReqFollowOperationPara msg_req_follow_para = new oidb_cmd0x978.ReqFollowOperationPara();
  public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqBody
 * JD-Core Version:    0.7.0.1
 */