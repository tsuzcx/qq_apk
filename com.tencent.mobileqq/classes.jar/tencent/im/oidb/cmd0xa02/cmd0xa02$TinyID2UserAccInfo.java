package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xa02$TinyID2UserAccInfo
  extends MessageMicro
{
  public static final int STR_USERACC_IDENTIFIER_FIELD_NUMBER = 4;
  public static final int UINT32_SDKAPPID_FIELD_NUMBER = 3;
  public static final int UINT32_USERACCTYPE_FIELD_NUMBER = 2;
  public static final int UINT64_TINYID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_tinyid", "uint32_useracctype", "uint32_sdkappid", "str_useracc_identifier" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, TinyID2UserAccInfo.class);
  public final PBStringField str_useracc_identifier = PBField.initString("");
  public final PBUInt32Field uint32_sdkappid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_useracctype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID2UserAccInfo
 * JD-Core Version:    0.7.0.1
 */