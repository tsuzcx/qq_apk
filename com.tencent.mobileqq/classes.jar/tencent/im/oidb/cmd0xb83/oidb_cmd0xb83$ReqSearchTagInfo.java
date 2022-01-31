package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb83$ReqSearchTagInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_search_info_list" }, new Object[] { null }, ReqSearchTagInfo.class);
  public final PBRepeatMessageField rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xb83.SearchInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqSearchTagInfo
 * JD-Core Version:    0.7.0.1
 */