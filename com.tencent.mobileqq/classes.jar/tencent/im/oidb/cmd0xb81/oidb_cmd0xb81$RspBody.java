package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xb81$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_user_info_rsp", "proposedTracerParent" }, new Object[] { null, "" }, RspBody.class);
  public oidb_cmd0xb81.GetUserInfoRsp msg_get_user_info_rsp = new oidb_cmd0xb81.GetUserInfoRsp();
  public final PBStringField proposedTracerParent = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody
 * JD-Core Version:    0.7.0.1
 */