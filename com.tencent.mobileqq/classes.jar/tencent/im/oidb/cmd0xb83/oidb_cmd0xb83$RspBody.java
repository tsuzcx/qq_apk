package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb83$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_reserved", "msg_rsp_search_tag_info", "msg_rsp_recommend_tag_info" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_cmd0xb83.RspRecommendTagInfo msg_rsp_recommend_tag_info = new oidb_cmd0xb83.RspRecommendTagInfo();
  public oidb_cmd0xb83.RspSearchTagInfo msg_rsp_search_tag_info = new oidb_cmd0xb83.RspSearchTagInfo();
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody
 * JD-Core Version:    0.7.0.1
 */