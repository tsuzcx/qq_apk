package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$BusinessEntryInfo
  extends MessageMicro<BusinessEntryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_business_entry_new", "uint32_business_entry_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BusinessEntryInfo.class);
  public final PBUInt32Field uint32_business_entry_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_entry_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.BusinessEntryInfo
 * JD-Core Version:    0.7.0.1
 */