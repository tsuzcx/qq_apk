package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyCopyFromRspBody
  extends MessageMicro<ApplyCopyFromRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "bytes_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0) }, ApplyCopyFromRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyFromRspBody
 * JD-Core Version:    0.7.0.1
 */