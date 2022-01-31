package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyGetTrafficRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_use_file_size", "uint32_use_file_num", "uint64_all_file_size", "uint32_all_file_num" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ApplyGetTrafficRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_all_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_file_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_all_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_use_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyGetTrafficRsp
 * JD-Core Version:    0.7.0.1
 */