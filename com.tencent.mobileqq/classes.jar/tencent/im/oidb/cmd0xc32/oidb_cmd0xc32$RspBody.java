package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xc32$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_set_rsp_body", "msg_get_rsp_body", "msg_check_rsp_body" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_cmd0xc32.CheckVisibilityRspBody msg_check_rsp_body = new oidb_cmd0xc32.CheckVisibilityRspBody();
  public oidb_cmd0xc32.GetVisibleListRspBody msg_get_rsp_body = new oidb_cmd0xc32.GetVisibleListRspBody();
  public oidb_cmd0xc32.SetVisibleListRspBody msg_set_rsp_body = new oidb_cmd0xc32.SetVisibleListRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.RspBody
 * JD-Core Version:    0.7.0.1
 */