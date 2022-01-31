package tencent.im.oidb.cmd0x4f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x4f1$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_c2c_trial_authority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(300);
  public final PBUInt32Field uint32_multi_trial_authority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_gray_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 88, 104 }, new String[] { "uint32_pstn_gray_flag", "uint32_interval", "bytes_cookies", "uint32_c2c_trial_authority", "uint32_multi_trial_authority" }, new Object[] { Integer.valueOf(0), Integer.valueOf(300), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4f1.oidb_0x4f1.RspBody
 * JD-Core Version:    0.7.0.1
 */