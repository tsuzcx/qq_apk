package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xa80$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_req_group_info" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xa80.ReqGroupInfo> rpt_msg_req_group_info = PBField.initRepeatMessage(oidb_cmd0xa80.ReqGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqBody
 * JD-Core Version:    0.7.0.1
 */