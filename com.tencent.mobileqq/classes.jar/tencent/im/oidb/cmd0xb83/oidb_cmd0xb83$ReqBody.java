package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb83$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_reserved", "msg_req_search_tag_info", "msg_req_recommend_tag_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public oidb_cmd0xb83.ReqRecommendTagInfo msg_req_recommend_tag_info = new oidb_cmd0xb83.ReqRecommendTagInfo();
  public oidb_cmd0xb83.ReqSearchTagInfo msg_req_search_tag_info = new oidb_cmd0xb83.ReqSearchTagInfo();
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqBody
 * JD-Core Version:    0.7.0.1
 */