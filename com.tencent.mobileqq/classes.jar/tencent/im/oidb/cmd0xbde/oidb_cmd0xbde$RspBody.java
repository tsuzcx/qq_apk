package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbde$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint32_reserved", "msg_rsp_search_tag_info" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public oidb_cmd0xbde.RspSearchTopicResult msg_rsp_search_tag_info = new oidb_cmd0xbde.RspSearchTopicResult();
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspBody
 * JD-Core Version:    0.7.0.1
 */