package tencent.im.oidb.cmd0xedf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xedf$ApplyAlliance
  extends MessageMicro<ApplyAlliance>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_apply_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_apply_group_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_group_owner = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_apply_group_code", "uint64_apply_group_owner", "uint64_source_group_owner" }, new Object[] { localLong, localLong, localLong }, ApplyAlliance.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xedf.oidb_0xedf.ApplyAlliance
 * JD-Core Version:    0.7.0.1
 */