package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xc32$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_op", "msg_set_req_body", "msg_get_req_body", "msg_check_req_body" }, new Object[] { Integer.valueOf(1), null, null, null }, ReqBody.class);
  public final PBEnumField enum_op = PBField.initEnum(1);
  public oidb_cmd0xc32.CheckVisibilityReqBody msg_check_req_body = new oidb_cmd0xc32.CheckVisibilityReqBody();
  public oidb_cmd0xc32.GetVisibleListReqBody msg_get_req_body = new oidb_cmd0xc32.GetVisibleListReqBody();
  public oidb_cmd0xc32.SetVisibleListReqBody msg_set_req_body = new oidb_cmd0xc32.SetVisibleListReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.ReqBody
 * JD-Core Version:    0.7.0.1
 */