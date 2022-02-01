package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xe89$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "create_pad_rsp_info", "get_pad_content_rsp_info", "rsp_get_change_list_info" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_cmd0xe89.RspCreatePad create_pad_rsp_info = new oidb_cmd0xe89.RspCreatePad();
  public oidb_cmd0xe89.RspGetDocContent get_pad_content_rsp_info = new oidb_cmd0xe89.RspGetDocContent();
  public oidb_cmd0xe89.RspGetChangeList rsp_get_change_list_info = new oidb_cmd0xe89.RspGetChangeList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspBody
 * JD-Core Version:    0.7.0.1
 */