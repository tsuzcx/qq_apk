package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class beancurdcube_profile_common$ProfileLocation
  extends MessageMicro<ProfileLocation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_nation", "uint32_province", "uint32_city", "uint32_district" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ProfileLocation.class);
  public final PBUInt32Field uint32_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_district = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_province = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileLocation
 * JD-Core Version:    0.7.0.1
 */