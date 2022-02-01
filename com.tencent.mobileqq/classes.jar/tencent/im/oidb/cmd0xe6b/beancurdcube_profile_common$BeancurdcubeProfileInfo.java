package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class beancurdcube_profile_common$BeancurdcubeProfileInfo
  extends MessageMicro<BeancurdcubeProfileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 160018, 160090, 160154, 160250, 160258, 192018, 192066, 216298, 218114 }, new String[] { "enum_beancurdcube_profile_type", "uint32_last_modify_time", "msg_nickname", "msg_email", "msg_intro", "msg_birthday", "msg_location", "msg_homeland", "msg_company", "msg_occupation", "msg_education" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, BeancurdcubeProfileInfo.class);
  public final PBUInt32Field enum_beancurdcube_profile_type = PBField.initUInt32(0);
  public beancurdcube_profile_common.ProfileBirthday msg_birthday = new beancurdcube_profile_common.ProfileBirthday();
  public beancurdcube_profile_common.ProfileCompany msg_company = new beancurdcube_profile_common.ProfileCompany();
  public beancurdcube_profile_common.ProfileEducation msg_education = new beancurdcube_profile_common.ProfileEducation();
  public beancurdcube_profile_common.ProfileEmail msg_email = new beancurdcube_profile_common.ProfileEmail();
  public beancurdcube_profile_common.ProfileHomeLand msg_homeland = new beancurdcube_profile_common.ProfileHomeLand();
  public beancurdcube_profile_common.ProfileIntro msg_intro = new beancurdcube_profile_common.ProfileIntro();
  public beancurdcube_profile_common.ProfileLocation msg_location = new beancurdcube_profile_common.ProfileLocation();
  public beancurdcube_profile_common.ProfileNickname msg_nickname = new beancurdcube_profile_common.ProfileNickname();
  public beancurdcube_profile_common.ProfileOccupation msg_occupation = new beancurdcube_profile_common.ProfileOccupation();
  public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfileInfo
 * JD-Core Version:    0.7.0.1
 */