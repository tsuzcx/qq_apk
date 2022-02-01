package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe89$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "create_pad_req_info", "get_pad_content_req_info", "uint64_group_code", "req_get_change_list_info" }, new Object[] { null, null, Long.valueOf(0L), null }, ReqBody.class);
  public oidb_cmd0xe89.ReqCreatePad create_pad_req_info = new oidb_cmd0xe89.ReqCreatePad();
  public oidb_cmd0xe89.ReqGetDocContent get_pad_content_req_info = new oidb_cmd0xe89.ReqGetDocContent();
  public oidb_cmd0xe89.ReqGetChangeList req_get_change_list_info = new oidb_cmd0xe89.ReqGetChangeList();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqBody
 * JD-Core Version:    0.7.0.1
 */