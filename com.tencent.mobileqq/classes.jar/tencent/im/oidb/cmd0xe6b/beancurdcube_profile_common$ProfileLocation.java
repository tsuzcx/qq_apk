package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class beancurdcube_profile_common$ProfileLocation
  extends MessageMicro<ProfileLocation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_district = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_province = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_nation", "uint32_province", "uint32_city", "uint32_district" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, ProfileLocation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileLocation
 * JD-Core Version:    0.7.0.1
 */