package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbde$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xbde.ReqSearchTopicInfo msg_req_search_tag_info = new oidb_cmd0xbde.ReqSearchTopicInfo();
  public final PBUInt32Field uint32_need_recent_topics = PBField.initUInt32(0);
  public final PBUInt32Field uint32_query_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90 }, new String[] { "uint32_reserved", "uint32_query_mode", "uint32_need_recent_topics", "msg_req_search_tag_info" }, new Object[] { localInteger, localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqBody
 * JD-Core Version:    0.7.0.1
 */