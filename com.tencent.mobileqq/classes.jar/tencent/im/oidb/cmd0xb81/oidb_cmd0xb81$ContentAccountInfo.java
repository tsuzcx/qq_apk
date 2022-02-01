package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$ContentAccountInfo
  extends MessageMicro<ContentAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField media_id = PBField.initString("");
  public final PBUInt32Field pgc_account_anshen_audit_result = PBField.initUInt32(0);
  public final PBUInt32Field pgc_account_xinan_audit_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ai_youzhi_tag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_characteristic_account = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  public final PBUInt64Field uint64_qq = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 40, 50, 56, 64, 88, 96, 160, 168 }, new String[] { "uint32_account_type", "media_id", "uint64_qq", "uint32_src", "uint32_characteristic_account", "uint32_ai_youzhi_tag", "pgc_account_xinan_audit_result", "pgc_account_anshen_audit_result" }, new Object[] { localInteger, "", Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger }, ContentAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ContentAccountInfo
 * JD-Core Version:    0.7.0.1
 */