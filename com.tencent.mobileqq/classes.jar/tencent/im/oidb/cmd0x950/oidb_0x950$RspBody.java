package tencent.im.oidb.cmd0x950;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.campus_common.Topic;

public final class oidb_0x950$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98, 106, 114 }, new String[] { "rpt_topics", "rpt_recommended_recently_used", "rpt_recommended_lastes_activities", "rpt_recommended_config", "rpt_recommended_recommend" }, new Object[] { null, null, null, null, null }, RspBody.class);
  public final PBRepeatMessageField rpt_recommended_config = PBField.initRepeatMessage(campus_common.Topic.class);
  public final PBRepeatMessageField rpt_recommended_lastes_activities = PBField.initRepeatMessage(campus_common.Topic.class);
  public final PBRepeatMessageField rpt_recommended_recently_used = PBField.initRepeatMessage(campus_common.Topic.class);
  public final PBRepeatMessageField rpt_recommended_recommend = PBField.initRepeatMessage(campus_common.Topic.class);
  public final PBRepeatMessageField rpt_topics = PBField.initRepeatMessage(campus_common.Topic.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x950.oidb_0x950.RspBody
 * JD-Core Version:    0.7.0.1
 */