package tencent.im.oidb.cmd0xb73;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xb73$LikeAnimationConfig
  extends MessageMicro<LikeAnimationConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_icon_config_list" }, new Object[] { null }, LikeAnimationConfig.class);
  public final PBRepeatMessageField<oidb_0xb73.LikeAnimationIconConfig> rpt_msg_icon_config_list = PBField.initRepeatMessage(oidb_0xb73.LikeAnimationIconConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb73.oidb_0xb73.LikeAnimationConfig
 * JD-Core Version:    0.7.0.1
 */