package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$TorchLimitInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_timestamp", "bool_limit" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, TorchLimitInfo.class);
  public final PBBoolField bool_limit = PBField.initBool(false);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.TorchLimitInfo
 * JD-Core Version:    0.7.0.1
 */