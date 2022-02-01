package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb83$RspRecommendTagInfo
  extends MessageMicro<RspRecommendTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_tag_info_list" }, new Object[] { null }, RspRecommendTagInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xb83.TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xb83.TagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspRecommendTagInfo
 * JD-Core Version:    0.7.0.1
 */