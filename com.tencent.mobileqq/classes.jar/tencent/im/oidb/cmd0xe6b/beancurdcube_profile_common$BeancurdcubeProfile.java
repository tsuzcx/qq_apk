package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class beancurdcube_profile_common$BeancurdcubeProfile
  extends MessageMicro<BeancurdcubeProfile>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurdcube_profile_info" }, new Object[] { null }, BeancurdcubeProfile.class);
  public final PBRepeatMessageField<beancurdcube_profile_common.BeancurdcubeProfileInfo> rpt_beancurdcube_profile_info = PBField.initRepeatMessage(beancurdcube_profile_common.BeancurdcubeProfileInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfile
 * JD-Core Version:    0.7.0.1
 */