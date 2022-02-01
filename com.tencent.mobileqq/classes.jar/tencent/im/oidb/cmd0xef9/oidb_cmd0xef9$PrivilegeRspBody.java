package tencent.im.oidb.cmd0xef9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xef9$PrivilegeRspBody
  extends MessageMicro<PrivilegeRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field allow_bits = PBField.initUInt64(0L);
  public final PBUInt64Field daily_topic_num = PBField.initUInt64(0L);
  public final PBStringField forbid_wording = PBField.initString("");
  public final PBBoolField is_allowed = PBField.initBool(false);
  public final PBBoolField is_experience = PBField.initBool(false);
  public final PBStringField jump_url = PBField.initString("");
  public final PBUInt64Field level = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 248 }, new String[] { "is_allowed", "forbid_wording", "jump_url", "level", "allow_bits", "is_experience", "daily_topic_num" }, new Object[] { localBoolean, "", "", localLong, localLong, localBoolean, localLong }, PrivilegeRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody
 * JD-Core Version:    0.7.0.1
 */