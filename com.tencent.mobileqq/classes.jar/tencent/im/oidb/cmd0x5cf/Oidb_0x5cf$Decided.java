package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5cf$Decided
  extends MessageMicro<Decided>
{
  public static final int RPT_STR_WORDING_FIELD_NUMBER = 5;
  public static final int STR_ADD_SOURCE_FIELD_NUMBER = 6;
  public static final int UINT32_REQTYPE_FIELD_NUMBER = 3;
  public static final int UINT32_SOURCEID_FIELD_NUMBER = 7;
  public static final int UINT32_SOURCESUBID_FIELD_NUMBER = 8;
  public static final int UINT32_TIME_FIELD_NUMBER = 4;
  public static final int UINT64_FUIN_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 9;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_add_source = PBField.initString("");
  public final PBUInt32Field uint32_reqtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_reqtype", "uint32_time", "rpt_str_wording", "str_add_source", "uint32_sourceid", "uint32_sourcesubid", "uint64_group_code" }, new Object[] { localLong, localLong, localInteger, localInteger, "", "", localInteger, localInteger, localLong }, Decided.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.Decided
 * JD-Core Version:    0.7.0.1
 */