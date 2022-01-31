package tencent.im.oidb.cmd0x93b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x93b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_actual_name = PBField.initString("");
  public final PBStringField str_class = PBField.initString("");
  public final PBStringField str_college = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_other_info = PBField.initString("");
  public final PBStringField str_school = PBField.initString("");
  public final PBStringField str_school_info = PBField.initString("");
  public final PBUInt32Field uint32_admission_year = PBField.initUInt32(0);
  public final PBUInt32Field uint32_college_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 98, 106, 114, 250, 258, 264, 274, 280, 290, 296, 306, 312, 320 }, new String[] { "uint64_uin", "uint32_flag", "bytes_skey", "str_name", "str_school_info", "str_actual_name", "str_school", "uint32_school_type", "str_college", "uint32_grade", "str_class", "uint32_admission_year", "str_other_info", "uint32_school_id", "uint32_college_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x93b.oidb_0x93b.RspBody
 * JD-Core Version:    0.7.0.1
 */