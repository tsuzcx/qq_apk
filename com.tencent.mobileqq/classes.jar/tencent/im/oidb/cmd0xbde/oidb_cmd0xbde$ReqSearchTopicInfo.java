package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbde$ReqSearchTopicInfo
  extends MessageMicro<ReqSearchTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_search_info_list" }, new Object[] { null }, ReqSearchTopicInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xbde.SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xbde.SearchInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqSearchTopicInfo
 * JD-Core Version:    0.7.0.1
 */