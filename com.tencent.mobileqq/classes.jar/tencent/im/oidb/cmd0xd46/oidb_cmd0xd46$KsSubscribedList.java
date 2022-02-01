package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46$KsSubscribedList
  extends MessageMicro<KsSubscribedList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_subscribed_count", "msg_ks_banner_info", "rpt_msg_ks_topic_list" }, new Object[] { Integer.valueOf(0), null, null }, KsSubscribedList.class);
  public oidb_cmd0xd46.KsBannerInfo msg_ks_banner_info = new oidb_cmd0xd46.KsBannerInfo();
  public final PBRepeatMessageField<oidb_cmd0xd46.KsTopicInfo> rpt_msg_ks_topic_list = PBField.initRepeatMessage(oidb_cmd0xd46.KsTopicInfo.class);
  public final PBUInt32Field uint32_subscribed_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsSubscribedList
 * JD-Core Version:    0.7.0.1
 */