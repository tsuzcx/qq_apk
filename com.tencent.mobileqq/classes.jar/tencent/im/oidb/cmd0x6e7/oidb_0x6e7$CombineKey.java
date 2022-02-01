package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6e7$CombineKey
  extends MessageMicro<CombineKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_ext1 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ext2 = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ext3 = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_ext1", "uint64_ext2", "uint64_ext3" }, new Object[] { localLong, localLong, localLong }, CombineKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e7.oidb_0x6e7.CombineKey
 * JD-Core Version:    0.7.0.1
 */